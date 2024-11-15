using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace SistemaGestaoHospital
{
    public partial class UpdatePatientForm : Form
    {
        public UpdatePatientForm()
        {
            InitializeComponent();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            // Get the values from the text boxes
            string citizenCardNumber = txtCitizenCardNumber.Text;
            string contactInformation = txtContactInformation.Text;
            string address = txtAddress.Text;
            string medicalHistory = txtMedicalHistory.Text;

            // Code to update the patient's information in the database goes here
            string connectionString = "your_connection_string_here";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string query = @"UPDATE Patient
                                 SET ContactInformation = @ContactInformation,
                                     Address = @Address
                                 WHERE CitizenCardNumber = @CitizenCardNumber;

                                 UPDATE Illness
                                 SET Description = @MedicalHistory
                                 WHERE PatientID = @CitizenCardNumber";

                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@CitizenCardNumber", citizenCardNumber);
                command.Parameters.AddWithValue("@ContactInformation", contactInformation);
                command.Parameters.AddWithValue("@Address", address);
                command.Parameters.AddWithValue("@MedicalHistory", medicalHistory);

                connection.Open();
                int result = command.ExecuteNonQuery();

                // Check if the update was successful
                if (result > 0)
                {
                    MessageBox.Show("Patient information updated successfully!");
                }
                else
                {
                    MessageBox.Show("Error updating patient information. Please check the Citizen Card Number and try again.");
                }

                this.Close();
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            // Close the form without updating
            this.Close();
        }
    }
}

