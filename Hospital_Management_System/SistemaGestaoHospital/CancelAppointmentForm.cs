using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class CancelAppointmentForm : Form
    {
        public CancelAppointmentForm()
        {
            InitializeComponent();
            btnCancelAppointment.Click += btnCancelAppointment_Click;
            btnCancel.Click += btnCancel_Click;
        }

        private void btnCancelAppointment_Click(object sender, EventArgs e)
        {
            // Get value from form input
            if (int.TryParse(txtAppointmentID.Text, out int appointmentID))
            {
                // Call the method to cancel the appointment
                CancelAppointment(appointmentID);
            }
            else
            {
                MessageBox.Show("Please provide a valid Appointment ID.", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            // Close the form when Cancel button is clicked
            this.Close();
        }

        private void CancelAppointment(int appointmentID)
        {
            // Use the existing connection from Form1
            SqlConnection connection = Form1.cn;

            try
            {
                using (SqlCommand command = new SqlCommand("CancelAppointment", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;

                    // Add parameter to the stored procedure
                    command.Parameters.AddWithValue("@AppointmentID", appointmentID);

                    // Execute the stored procedure
                    command.ExecuteNonQuery();
                }

                MessageBox.Show("Appointment cancelled successfully.", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                // Handle any errors that may have occurred
                MessageBox.Show("An error occurred while cancelling the appointment: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
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
