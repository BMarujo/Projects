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
    public partial class ViewPatientProfileForm : Form
    {
        public ViewPatientProfileForm()
        {
            InitializeComponent();
        }

        private void btnViewProfile_Click(object sender, EventArgs e)
        {
            // Get the citizen card number from the text box
            string citizenCardNumber = txtCitizenCardNumber.Text;

            // Code to retrieve the patient's information from the database
            string connectionString = "your_connection_string_here";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string query = @"SELECT p.Name, p.Gender, p.DateOfBirth, p.ContactInformation, p.Address, i.Description AS MedicalHistory
                                 FROM Patient p
                                 LEFT JOIN Illness i ON p.CitizenCardNumber = i.PatientID
                                 WHERE p.CitizenCardNumber = @CitizenCardNumber";

                SqlCommand command = new SqlCommand(query, connection);
                command.Parameters.AddWithValue("@CitizenCardNumber", citizenCardNumber);

                connection.Open();
                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    txtName.Text = reader["Name"].ToString();
                    txtGender.Text = reader["Gender"].ToString();
                    txtDateOfBirth.Text = Convert.ToDateTime(reader["DateOfBirth"]).ToString("yyyy-MM-dd");
                    txtContactInformation.Text = reader["ContactInformation"].ToString();
                    txtAddress.Text = reader["Address"].ToString();
                    txtMedicalHistory.Text = reader["MedicalHistory"].ToString();
                }
                else
                {
                    MessageBox.Show("Patient not found. Please check the Citizen Card Number and try again.");
                }
            }
        }
    }
}

