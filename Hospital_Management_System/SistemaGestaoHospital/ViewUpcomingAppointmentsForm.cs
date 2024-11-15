using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class ViewUpcomingAppointmentsForm : Form
    {
        public ViewUpcomingAppointmentsForm()
        {
            InitializeComponent();
            btnSearch.Click += btnSearch_Click;
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            // Get the citizen card number from the text box
            string citizenCardNumber = txtCitizenCardNumber.Text.Trim();

            if (!string.IsNullOrEmpty(citizenCardNumber))
            {
                // Call the method to get appointments
                GetAppointments(citizenCardNumber);
            }
            else
            {
                MessageBox.Show("Please enter a valid Citizen Card Number.", "Input Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void GetAppointments(string citizenCardNumber)
        {
            // Use the existing connection from Form1
            SqlConnection connection = Form1.cn;

            try
            {
                using (SqlCommand command = new SqlCommand("GetAppointmentsByCitizenCardNumber", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;

                    // Add parameter to the stored procedure
                    command.Parameters.AddWithValue("@CitizenCardNumber", citizenCardNumber);

                    // Execute the stored procedure and get the results
                    SqlDataAdapter adapter = new SqlDataAdapter(command);
                    DataTable dataTable = new DataTable();
                    adapter.Fill(dataTable);

                    // Bind the results to the DataGridView
                    dataGridView1.DataSource = dataTable;
                }
            }
            catch (Exception ex)
            {
                // Handle any errors that may have occurred
                MessageBox.Show("An error occurred while retrieving the appointments: " + ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            AppointmentTreatmentForm appointmentTreatmentForm = new AppointmentTreatmentForm();
            appointmentTreatmentForm.Show();
            this.Close();
        }
    }
}
