using SistemaGestaoHospital.Models;
using System.Data.SqlClient;

namespace SistemaGestaoHospital
{
    public partial class BillingPrescriptionsForm : Form
    {
        private List<Bill> bills = [];
        private List<Prescription> prescriptions = [];
        private List<Patient> filterByPatient = [];
        private Bill selectedBill = null;

        public BillingPrescriptionsForm()
        {
            InitializeComponent();

            btnUpdatePaymentStatus.Visible = false;

            PopulateBills();
            PopulatePrescriptions();
            PopulatePatientsFilter();

            outstandingBills.SelectedIndex = -1;
            prescriptionList.SelectedIndex = -1;
        }

        private void PopulatePatientsFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                SqlCommand command = new("SELECT * FROM ViewPatientDetails ORDER BY Name", connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Patient newPatient = new(
                        citizenCardNumber: (string)reader["CitizenCardNumber"],
                        name: (string)reader["Name"],
                        gender: (string)reader["Gender"],
                        age: (int)(reader["Age"]),
                        contactInformation: (string)reader["ContactInformation"],
                        address: (string)reader["Address"],
                        insurance: (bool)(reader["Insurance"])
                    );
                    filterByPatient.Add(newPatient);
                }

                reader.Close();
            }

            filterByPatient.Insert(0, new Patient("123123", "Please select a patient", "U", 0, null, null, false));

            FilterbyPatient.DataSource = filterByPatient;
            FilterbyPatient.DisplayMember = "Name";
            FilterbyPatient.ValueMember = "CitizenCardNumber";
            FilterbyPatient.SelectedIndex = 0;
        }

        private void PopulatePrescriptions()
        {
            prescriptions.Clear();

            SqlConnection connection = Form1.cn;
            {
                string query = "SELECT * FROM Prescriptions";
                SqlCommand command = new(query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Prescription newPrescription = new(
                        PrescriptionId: (int)reader["PrescriptionID"],
                        PatientId: (string)reader["PatientID"],
                        DoctorId: (string)reader["DoctorID"],
                        AppointmentId: (int)reader["AppointmentID"],
                        date: (DateTime)(reader["PrescriptionDate"]),
                        dosageInstruct: (string)reader["DosageInstructions"],
                        MedicationId: (int)(reader["MedicationID"])
                    );
                    prescriptions.Add(newPrescription);
                }

                reader.Close();
            }

            prescriptionList.DataSource = prescriptions;
            prescriptionList.SelectedIndex = 0;

            prescriptionList.Format += (sender, e) =>
            {
                var presc = (Prescription)e.ListItem;
                e.Value = presc.ToString();
            };
        }

        private void PopulateBills()
        {
            bills.Clear();

            SqlConnection connection = Form1.cn;
            {
                connection.Close();
                connection.Open();
                // Modify the query to select only unpaid bills
                string query = "SELECT * FROM ViewUnpaidBills";
                SqlCommand command = new(query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Bill newBill = new(
                        id: (int)reader["BillID"],
                        Patient: (string)reader["PatientID"],
                        Doctor: (string)reader["DoctorID"],
                        appointId: (int)reader["AppointmentID"],
                        payStatus: (string)reader["PaymentStatus"],
                        date: (DateTime)reader["BillDate"],
                        totalAmount: (decimal)reader["TotalAmount"]
                    );
                    bills.Add(newBill);
                }

                reader.Close();
            }

            outstandingBills.DataSource = bills;
            outstandingBills.SelectedIndex = 0;

            outstandingBills.Format += (sender, e) =>
            {
                var bill = (Bill)e.ListItem;
                e.Value = bill.ToString();
            };

            outstandingBills.SelectedIndex = -1;
        }

        // Update Payment Status
        private void btnUpdatePaymentStatus_Click(object sender, EventArgs e)
        {
            if (selectedBill != null)
            {
                SqlConnection connection = Form1.cn;
                {
                    SqlCommand command = new("UpdateBillPaymentStatus", connection)
                    {
                        CommandType = System.Data.CommandType.StoredProcedure
                    };
                    command.Parameters.AddWithValue("@BillID", selectedBill.BillID);
                    command.ExecuteNonQuery();
                }

                MessageBox.Show("Payment done for bill: " + selectedBill.ToString());
                btnUpdatePaymentStatus.Visible = false;
                PopulateBills();
            }
        }

        // Navigate to Prescribe Medication Form
        private void btnPrescribeMedication_Click(object sender, EventArgs e)
        {
            PrescribeMedicationForm prescribeMedicationForm = new();
            prescribeMedicationForm.FormClosed += PrescribeMedication_FormClosed;
            prescribeMedicationForm.Show();
        }

        private void PrescribeMedication_FormClosed(object? sender, FormClosedEventArgs e)
        {
            PopulatePrescriptions();
        }

        private void outstandingBills_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (outstandingBills.SelectedIndex >= 0 && outstandingBills.SelectedItem != null)
            {
                selectedBill = outstandingBills.SelectedItem as Bill;
                btnUpdatePaymentStatus.Visible = true;
            }
            else
            {
                btnUpdatePaymentStatus.Visible = false;
            }
        }

        private void FilterbyPatient_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            if (FilterbyPatient.SelectedIndex > 0)
            {
                string selectedPatientID = FilterbyPatient.SelectedValue.ToString();
                PopulatePrescriptionsByPatient(selectedPatientID);
            }
            else
            {
                prescriptions.Clear();
                PopulatePrescriptions();
            }
        }

        private void PopulatePrescriptionsByPatient(string patientID)
        {
            prescriptions.Clear();

            SqlConnection connection = Form1.cn;
            {
                SqlCommand command = new("ListPrescriptionsByPatient", connection)
                {
                    CommandType = System.Data.CommandType.StoredProcedure
                };
                command.Parameters.AddWithValue("@PatientID", patientID);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Prescription newPrescription = new(
                        PrescriptionId: (int)(reader["PrescriptionID"]),
                        PatientId: (string)reader["PatientID"],
                        DoctorId: (string)reader["DoctorID"],
                        AppointmentId: (int)(reader["AppointmentID"]),
                        date: (DateTime)(reader["PrescriptionDate"]),
                        dosageInstruct: (string)reader["DosageInstructions"],
                        MedicationId: (int)(reader["MedicationID"])
                    );
                    prescriptions.Add(newPrescription);
                }

                reader.Close();
            }

            if (prescriptions.Count > 0)
            {
                prescriptionList.DataSource = prescriptions;
                prescriptionList.SelectedIndex = 0;
            }
            else
            {
                prescriptionList.DataSource = null;
                prescriptionList.ClearSelected();
            }

            prescriptionList.Format += (sender, e) =>
            {
                var presc = (Prescription)e.ListItem;
                e.Value = presc.ToString();
            };
        }

        private void BillingPrescriptionsForm_Load(object sender, EventArgs e)
        {

        }
    }
}
