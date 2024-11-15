using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class RecordTreatmentOutcomeForm : Form
    {
        public RecordTreatmentOutcomeForm()
        {
            InitializeComponent();
        }

        private void txtDoctorCitizenCardNumber_TextChanged(object sender, EventArgs e)
        {
            // You can handle any additional actions here if needed
        }

        private void RecordTreatmentOutcomeForm_Load(object sender, EventArgs e)
        {
            // Any initialization actions can be performed here
        }

        private void btnCancel_Click_1(object sender, EventArgs e)
        {
            AppointmentTreatmentForm appointmentTreatmentForm = new AppointmentTreatmentForm();
            appointmentTreatmentForm.Show();
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            // Collect data from form
            string doctorCitizenCardNumber = txtDoctorCitizenCardNumber.Text.Trim();
            string patientCitizenCardNumber = txtPatientCitizenCardNumber.Text.Trim();
            string description = txtDescription.Text.Trim();
            DateTime recordDate = dtpAppointmentDateTime.Value;

            // Validate inputs
            if (string.IsNullOrEmpty(doctorCitizenCardNumber) ||
                string.IsNullOrEmpty(patientCitizenCardNumber) ||
                string.IsNullOrEmpty(description))
            {
                MessageBox.Show("Please fill in all fields.", "Validation Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Call the stored procedure to save the treatment outcome
            SaveTreatmentOutcome(doctorCitizenCardNumber, patientCitizenCardNumber, description, recordDate);
        }

        private void SaveTreatmentOutcome(string doctorID, string patientID, string description, DateTime recordDate)
        {
            // Use the existing connection from Form1
            SqlConnection connection = Form1.cn;

            try
            {
                using (SqlCommand command = new SqlCommand("RecordTreatment", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;

                    // Add parameters to the stored procedure
                    command.Parameters.AddWithValue("@DoctorID", doctorID);
                    command.Parameters.AddWithValue("@PatientID", patientID);
                    command.Parameters.AddWithValue("@Description", description);
                    command.Parameters.AddWithValue("@RecordDate", recordDate);

                    // Open the connection if it's not already open
                    if (connection.State != ConnectionState.Open)
                    {
                        connection.Open();
                    }

                    // Execute the stored procedure
                    command.ExecuteNonQuery();

                    MessageBox.Show("Treatment outcome recorded successfully.", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    this.Close();
                }
            }
            catch (Exception ex)
            {
                // Handle any errors that may have occurred
                MessageBox.Show("An error occurred while recording the treatment outcome: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            finally
            {
                // Ensure the connection is closed
                if (connection.State == ConnectionState.Open)
                {
                    connection.Close();
                }
            }
        }
    }
}
