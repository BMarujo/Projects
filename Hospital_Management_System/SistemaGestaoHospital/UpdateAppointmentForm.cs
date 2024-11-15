using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class UpdateAppointmentForm : Form
    {
        public UpdateAppointmentForm()
        {
            InitializeComponent();
            btnUpdate.Click += btnUpdate_Click;
            btnCancel.Click += btnCancel_Click;
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            // Get values from form inputs
            if (int.TryParse(txtAppointmentID.Text, out int appointmentID) &&
                cmbStatus.SelectedItem != null)
            {
                DateTime newAppointmentDateTime = dtpAppointmentDateTime.Value;
                string newStatus = cmbStatus.SelectedItem.ToString();

                // Call the method to update the appointment
                UpdateAppointment(appointmentID, newAppointmentDateTime, newStatus);
            }
            else
            {
                MessageBox.Show("Please provide valid input for all fields.", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            // Close the form when Cancel button is clicked
            this.Close();
        }

        private void UpdateAppointment(int appointmentID, DateTime newAppointmentDateTime, string newStatus)
        {
            // Use the existing connection from Form1
            SqlConnection connection = Form1.cn;

            try
            {
                using (SqlCommand command = new SqlCommand("UpdateAppointment", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;

                    // Add parameters to the stored procedure
                    command.Parameters.AddWithValue("@AppointmentID", appointmentID);
                    command.Parameters.AddWithValue("@NewAppointmentDateTime", newAppointmentDateTime);
                    command.Parameters.AddWithValue("@NewStatus", newStatus);

                    // Execute the stored procedure
                    command.ExecuteNonQuery();
                }

                MessageBox.Show("Appointment updated successfully.", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                // Handle any errors that may have occurred
                MessageBox.Show("An error occurred while updating the appointment: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnCancel_Click_1(object sender, EventArgs e)
        {
            AppointmentTreatmentForm appointmentTreatmentForm = new AppointmentTreatmentForm();
            appointmentTreatmentForm.Show();
            this.Close();
        }
    }
}
