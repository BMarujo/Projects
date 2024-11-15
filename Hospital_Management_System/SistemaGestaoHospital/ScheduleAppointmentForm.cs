using System.Data;
using System.Data.SqlClient;
using SistemaGestaoHospital.Models;

namespace SistemaGestaoHospital
{
    public partial class ScheduleAppointmentForm : Form
    {
        private Doctor selectedDoctor = null;
        private Patient selectedPatient = null;

        private List<Doctor> listOfDoctors = [];
        private List<Patient> listOfPatients = [];

        // Constructor
        public ScheduleAppointmentForm()
        {
            InitializeComponent();
            PopulateDoctorsFilter();
            PopulatePatientsFilter();
        }

        private void PopulateDoctorsFilter()
        {
            SqlConnection connection = Form1.cn;
            {
                SqlCommand command = new("SELECT * FROM Doctor", connection);

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Doctor newDoc = new(
                        citizenCardNumber: (string)reader["CitizenCardNumber"],
                        name: (string)reader["Name"],
                        gender: ConvertToChar((string) reader["Gender"]),
                        dateOfBirth: null,
                        contactInformation: (string)reader["ContactInformation"],
                        address: (string)reader["Address"],
                        licenseDetails: (string) (reader["LicenseDetails"]),
                        shiftSchedule: (string)(reader["ShiftSchedule"]),
                        departmentID: null,
                        specialization: null
                    );
                    listOfDoctors.Add(newDoc);
                }

                reader.Close();
            }

            listOfDoctors.Insert(0, new Doctor("Select a Doctor", "None", 'U', 0, "", "", "", "", null, null));

            DoctorsDropdown.DataSource = listOfDoctors;
            DoctorsDropdown.DisplayMember = "CitizenCardNumber";
            DoctorsDropdown.ValueMember = "CitizenCardNumber";
            DoctorsDropdown.SelectedIndex = 0;
        }

        private char ConvertToChar(string input)
        {
            if (!string.IsNullOrEmpty(input) && input.Length == 1)
            {
                return input[0];
            }
            else
            {
                throw new ArgumentException("Input is not a valid single character string.");
            }
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
                    listOfPatients.Add(newPatient);
                }

                reader.Close();
            }

            listOfPatients.Insert(0, new Patient("Select a Patient", "None", "U", 0, null, null, false));

            PatientsDropdown.DataSource = listOfPatients;
            PatientsDropdown.DisplayMember = "CitizenCardNumber";
            PatientsDropdown.ValueMember = "CitizenCardNumber";
            PatientsDropdown.SelectedIndex = 0;
        }

        private void ScheduleAppointmentForm_Load(object sender, EventArgs e)
        {
            // Any initialization code can go here
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            AppointmentTreatmentForm appointmentTreatmentForm = new AppointmentTreatmentForm();
            appointmentTreatmentForm.Show();
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            // Get values from form inputs
            string doctorID = selectedDoctor.CitizenCardNumber;
            string patientID = selectedPatient.CitizenCardNumber;
            DateTime appointmentDateTime = dtpAppointmentDateTime.Value;
            string reason = txtReason.Text;
            string status = cmbStatus.SelectedItem.ToString();

            // Call the method to schedule the appointment
            ScheduleAppointment(doctorID, patientID, appointmentDateTime, reason, status);

            this.Close();
        }

        private void ScheduleAppointment(string doctorID, string patientID, DateTime appointmentDateTime, string reason, string status)
        {
            // Use the existing connection from Form1
            SqlConnection connection = Form1.cn;

            try
            {
                using (SqlCommand command = new ("ScheduleAppointment", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;

                    // Add parameters to the stored procedure
                    command.Parameters.AddWithValue("@DoctorID", doctorID);
                    command.Parameters.AddWithValue("@PatientID", patientID);
                    command.Parameters.AddWithValue("@AppointmentDateTime", appointmentDateTime);
                    command.Parameters.AddWithValue("@Reason", reason);
                    command.Parameters.AddWithValue("@Status", status);

                    // Execute the stored procedure
                    command.ExecuteNonQuery();
                }

                MessageBox.Show("Appointment scheduled successfully.");
            }
            catch (Exception ex)
            {
                // Handle any errors that may have occurred
                MessageBox.Show("An error occurred while scheduling the appointment: " + ex.Message);
            }
        }

        private void DoctorsDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (DoctorsDropdown.SelectedIndex >= 0 && DoctorsDropdown.SelectedItem != null)
            {
                selectedDoctor = DoctorsDropdown.SelectedItem as Doctor;
            } 
        }

        private void PatientsDropdown_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (PatientsDropdown.SelectedIndex >= 0 && PatientsDropdown.SelectedItem != null)
            {
                selectedPatient = PatientsDropdown.SelectedItem as Patient;
            } 
        }
    }
}
