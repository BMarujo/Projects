using SistemaGestaoHospital.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class PrescribeMedicationForm : Form
    {
        private List<Patient> filterByPatient = [];
        private List<Doctor> filterByDoctor = [];
        private List<Appointment> filterByAppointment = [];
        private List<Medication> filterByMedication = []; 

        public PrescribeMedicationForm()
        {
            InitializeComponent();
            PopulatePatientsFilter();
            PopulateDoctorFilter();
            PopulateAppointmentFilter();
            PopulateMedicationFilter();
        }

        private void PopulateMedicationFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                string query = "SELECT MedicationID, MedicationName, Description, UsageInstructions, SideEffects, Manufacturer FROM Medications";
                SqlCommand command = new (query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Medication newMedication = new (
                        medicationID: Convert.ToInt32(reader["MedicationID"]),
                        medicationName: reader["MedicationName"].ToString(),
                        description: reader["Description"].ToString(),
                        usageInstructions: reader["UsageInstructions"].ToString(),
                        sideEffects: reader["SideEffects"].ToString(),
                        manufacturer: reader["Manufacturer"].ToString()
                    );
                    filterByMedication.Add(newMedication);
                }

                reader.Close();
            }

            filterByMedication.Insert(0, new Medication(0, "Please select a medication", "Select a medication from the list.", "", "", ""));

            MedicationDropdown.DataSource = filterByMedication;
            MedicationDropdown.DisplayMember = "MedicationName";
            MedicationDropdown.ValueMember = "MedicationID";
            MedicationDropdown.SelectedIndex = 0;
        }

        private void PopulatePatientsFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                string query = @"
            SELECT CitizenCardNumber, Name, Gender, dbo.GetAge(DateOfBirth) AS Age, 
                   ContactInformation, Address, Insurance 
            FROM Patient";
                SqlCommand command = new (query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Patient newPatient = new Patient(
                        citizenCardNumber: reader["CitizenCardNumber"].ToString(),
                        name: reader["Name"].ToString(),
                        gender: (reader["Gender"].ToString()),
                        age: Convert.ToInt32(reader["Age"]),
                        contactInformation: reader["ContactInformation"].ToString(),
                        address: reader["Address"].ToString(),
                        insurance: Convert.ToBoolean(reader["Insurance"])
                    );
                    filterByPatient.Add(newPatient);
                }

                reader.Close();
            }

            filterByPatient.Insert(0, new Patient("123123", "Please select a patient", "U", 0, null, null, false));

            PatientsDropdown.DataSource = filterByPatient;
            PatientsDropdown.DisplayMember = "Name";
            PatientsDropdown.ValueMember = "CitizenCardNumber";
            PatientsDropdown.SelectedIndex = 0;
        }

        private void PopulateDoctorFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                string query = @"
            SELECT CitizenCardNumber, Name, Gender, dbo.GetAge(DateOfBirth) AS Age, 
                   ContactInformation, Address, LicenseDetails, ShiftSchedule, 
                   DepartmentID, Specialization 
            FROM Doctor";
                SqlCommand command = new SqlCommand(query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Doctor newDoctor = new Doctor(
                        citizenCardNumber: reader["CitizenCardNumber"].ToString(),
                        name: reader["Name"].ToString(),
                        gender: Convert.ToChar(reader["Gender"]),
                        dateOfBirth: Convert.ToInt32(reader["Age"]),
                        contactInformation: reader["ContactInformation"].ToString(),
                        address: reader["Address"].ToString(),
                        licenseDetails: reader["LicenseDetails"].ToString(),
                        shiftSchedule: reader["ShiftSchedule"].ToString(),
                        departmentID: reader.IsDBNull(reader.GetOrdinal("DepartmentID")) ? (int?)null : Convert.ToInt32(reader["DepartmentID"]),
                        specialization: reader.IsDBNull(reader.GetOrdinal("Specialization")) ? (int?)null : Convert.ToInt32(reader["Specialization"])
                    );
                    filterByDoctor.Add(newDoctor);
                }

                reader.Close();
            }

            filterByDoctor.Insert(0, new Doctor(null, "Please select a doctor", 'U', 0, null, null, null, null, null, null));

            DoctorsDropdown.DataSource = filterByDoctor;
            DoctorsDropdown.DisplayMember = "Name";
            DoctorsDropdown.ValueMember = "CitizenCardNumber";
            DoctorsDropdown.SelectedIndex = 0;
        }

        private void PopulateAppointmentFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                string query = "SELECT AppointmentID, DoctorID, PatientID, AppointmentDateTime, Reason FROM Appointment";
                SqlCommand command = new SqlCommand(query, connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Appointment newAppointment = new Appointment(
                        appointmentId: Convert.ToInt32(reader["AppointmentID"]),
                        doctorID: reader["DoctorID"].ToString(),
                        patientID: reader["PatientID"].ToString(),
                        appointmentDateTime: Convert.ToDateTime(reader["AppointmentDateTime"]),
                        reason: reader["Reason"].ToString()
                    );
                    filterByAppointment.Add(newAppointment);
                }

                reader.Close();
            }

            filterByAppointment.Insert(0, new Appointment(0, null, null, DateTime.MinValue, "Please select an appointment"));

            AppointmentDropdown.DataSource = filterByAppointment;
            AppointmentDropdown.DisplayMember = "DisplayText";
            AppointmentDropdown.ValueMember = "AppointmentID";
            AppointmentDropdown.SelectedIndex = 0;
        }

        private void MedicationDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void AppointmentDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void DoctorsDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void PatientsDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonPrescribe_Click(object sender, EventArgs e)
        {
            if (PatientsDropdown.SelectedIndex == 0 || DoctorsDropdown.SelectedIndex == 0 || AppointmentDropdown.SelectedIndex == 0 || MedicationDropdown.SelectedIndex == 0)
            {
                MessageBox.Show("Please select valid options from all dropdowns.");
                return;
            }

            string selectedPatientID = PatientsDropdown.SelectedValue.ToString();
            string selectedDoctorID = DoctorsDropdown.SelectedValue.ToString();
            int selectedAppointmentID = Convert.ToInt32(AppointmentDropdown.SelectedValue);
            int selectedMedicationID = Convert.ToInt32(MedicationDropdown.SelectedValue);
            DateTime prescriptionDate = dateTimePickerPrescriptionDate.Value;
            string dosageInstructions = richTextBox1.Text;

            SqlConnection connection = Form1.cn;
            {
                SqlCommand command = new("PrescribeMedication", connection)
                {
                    CommandType = System.Data.CommandType.StoredProcedure
                };
                command.Parameters.AddWithValue("@PatientID", selectedPatientID);
                command.Parameters.AddWithValue("@DoctorID", selectedDoctorID);
                command.Parameters.AddWithValue("@AppointmentID", selectedAppointmentID);
                command.Parameters.AddWithValue("@MedicationID", selectedMedicationID);
                command.Parameters.AddWithValue("@PrescriptionDate", prescriptionDate);
                command.Parameters.AddWithValue("@DosageInstructions", dosageInstructions);

                command.ExecuteNonQuery();
            }

            MessageBox.Show("Medication prescribed successfully!");
            this.Close();
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void dateTimePickerPrescriptionDate_ValueChanged(object sender, EventArgs e)
        {

        }

        private void PrescribeMedicationForm_Load_1(object sender, EventArgs e)
        {

        }
    }
}
