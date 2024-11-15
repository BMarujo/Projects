using SistemaGestaoHospital.Models;
using System.Data;
using System.Data.SqlClient;

namespace SistemaGestaoHospital
{
    public partial class PatientManagementForm : Form
    {
        private readonly SqlConnection _connection = Form1.cn;
        private List<Patient> patients = [];
        private List<Illness> illnesses = [];

        private Patient selectedPatient = null;
        private Illness selectedIllness = null;
        private char selectedGender = 'U'; // U for Undefined
        private bool hasInsurance = false;

        public PatientManagementForm()
        {
            InitializeComponent();
        }

        private void PatientManagementForm_Load(object sender, EventArgs e)
        {
            InitializePatients();
            InitializeIllness();

            listBox1.SelectedIndex = -1;
            panel1.Visible = false;
            save_record.Visible = false;
            cancel.Visible = false;
            updatePanel.Visible = false;
            updatePatientInfo.Visible = false;
        }

        private void InitializePatients()
        {
            SqlCommand cmd = new ("SELECT * FROM ViewPatientDetails ORDER BY Name", _connection);

            using (SqlDataReader reader = cmd.ExecuteReader())
            {
                while (reader.Read()) {
                    Patient patient = new(
                        citizenCardNumber: (string)reader["CitizenCardNumber"],
                        name: (string) reader["Name"],
                        gender: (string) reader["Gender"],
                        age: (int)reader["Age"],
                        contactInformation: (string) reader["ContactInformation"],
                        address: (string) reader["Address"],
                        insurance: (bool) reader["Insurance"] 
                        );
                    patients.Add( patient );
                }
                reader.Close();
            }

            listBox1.DataSource = patients;
            listBox1.SelectedIndex = 0;

            listBox1.Format += (sender, e) =>
            {
                var patient = (Patient)e.ListItem;
                e.Value = patient.ToString();
            };

            listBox1.SelectedIndex = -1;
        }

        private void InitializeIllness()
        {
            using (SqlCommand command = new ("ListAllIllnesses", _connection))
            {
                command.CommandType = CommandType.StoredProcedure;

                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    Illness illness = new(
                        id: 1,
                        name: (string) reader["IllnessName"],
                        description: "",
                        patientId: 0 
                    );
                    illnesses.Add( illness );
                }
                reader.Close();
            }

            // Insert a default 'null' item at the beginning of the list
            illnesses.Insert(0, new Illness(0, "Please select an option", "", 0));

            comboBox1.DataSource = illnesses;

            comboBox1.DisplayMember = "Name";
            comboBox1.ValueMember = "Id";

            comboBox1.SelectedIndex = 0;
        }

        private void btnAddPatient_Click(object sender, EventArgs e)
        {
            listBox1.Visible = false;
            panel1.Visible = true;
            btnDeletePatient.Visible = false;
            btnUpdatePatient.Visible = false;
            btnViewPatientProfile.Visible = false;
            save_record.Visible = true;
            cancel.Visible = true;
            label1.Visible = false;
            comboBox1.Visible = false;

        }

        private void btnUpdatePatient_Click(object sender, EventArgs e)
        {
            contactUpdate.Text = selectedPatient.ContactInformation;
            addressUpdate.Text = selectedPatient.Address;
            updateInsurance.Checked = selectedPatient.Insurance;

            if (selectedPatient != null)
            {
                panel1.Visible = false;
                updatePanel.Visible = true;
                updatePatientInfo.Visible = true;
                cancel.Visible = true;
                btnDeletePatient.Visible = false;
                btnUpdatePatient.Visible = false;
                btnViewPatientProfile.Visible = false;
                label1.Visible = false;
                comboBox1.Visible = false;
                listBox1.Visible = false;
                btnAddPatient.Visible = false;
            }
            else
            {
                MessageBox.Show("Please select a patient");
            }
        }

        private void btnDeletePatient_Click(object sender, EventArgs e)
        {
            if (selectedPatient != null)
            {
                using SqlCommand command = new("DeletePatient", _connection);
                {
                    command.CommandType = CommandType.StoredProcedure;

                    command.Parameters.Add(new SqlParameter("@CitizenCardNumber", SqlDbType.VarChar)).Value = selectedPatient.CitizenCardNumber;
                }

                int result = command.ExecuteNonQuery();
                // Check the result (number of rows affected)
                if (result > 0)
                {
                    Console.WriteLine("Patient removed successfully.");
                }
                else
                {
                    Console.WriteLine("No patient was removed.");
                } 
                patients.Clear();
                InitializePatients();
                listBox1.SelectedIndex = -1;
            }
            else
            {
                MessageBox.Show("Please select a patient");
            }
        }

        private void btnViewPatientProfile_Click(object sender, EventArgs e)
        {
            if (selectedPatient != null)
            {
                // Use view that gives this info
                string profile = "\t          PROFILE\n\n" +
                   $"Name: {selectedPatient.Name}\n" +
                   $"Gender: {selectedPatient.Gender}\n" +
                   $"Age: {selectedPatient.Age} years old\n" +
                   $"Contact: {selectedPatient.ContactInformation}\n" +
                   $"Address: {selectedPatient.Address}\n" +
                   $"Insurance: {(selectedPatient.Insurance ? "Yes" : "No")}";
                MessageBox.Show(profile);
            }
            else
            {
                MessageBox.Show("Please select a patient");
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBox1.SelectedItem != null)
            {
                selectedPatient = listBox1.SelectedItem as Patient;
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.SelectedIndex > 0)
            {
                Illness selectedIllness = comboBox1.SelectedItem as Illness;

                if (selectedIllness != null)
                {
                    patients.Clear ();
                    using SqlCommand command = new("GetPatientsByIllness", _connection);
                    {
                        command.CommandType = CommandType.StoredProcedure;

                        command.Parameters.Add(new SqlParameter("@IllnessName", SqlDbType.VarChar)).Value = selectedIllness.Name;
                        SqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            Patient patient = new(
                                citizenCardNumber: (string)reader["CitizenCardNumber"],
                                name: (string)reader["Name"],
                                gender: (string) reader["Gender"],
                                age: (int)reader["Age"],
                                contactInformation: (string) reader["ContactInformation"],
                                address: (string) reader["Address"],
                                insurance: (bool) reader["Insurance"] 
                            );
                            patients.Add(patient);
                        }
                        reader.Close();
                    }

                    listBox1.DataSource = patients;

                    listBox1.Format += (sender, e) =>
                    {
                        var patient = (Patient)e.ListItem;
                        e.Value = patient.ToString();
                    };
                }
            } else
            {
                patients.Clear();
                InitializePatients(); 
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Save button
            if (checkInputs())
            {
                panel1.Visible = false;
                listBox1.Visible = true;
                btnDeletePatient.Visible = true;
                btnUpdatePatient.Visible = true;
                btnViewPatientProfile.Visible = true;
                save_record.Visible = false;
                cancel.Visible = false;
                label1.Visible = true;
                comboBox1.Visible = true;

                using SqlCommand command = new("AddPatient", _connection);
                {
                    command.CommandType = CommandType.StoredProcedure;

                    command.Parameters.Add(new SqlParameter("@CitizenCardNumber", SqlDbType.VarChar)).Value = textBox1.Text;
                    command.Parameters.Add(new SqlParameter("@Name", SqlDbType.VarChar)).Value = textBox2.Text;
                    command.Parameters.Add(new SqlParameter("@Gender", SqlDbType.Char)).Value = selectedGender;
                    command.Parameters.Add(new SqlParameter("@DateOfBirth", SqlDbType.Date)).Value = dateTimePicker1.Value;
                    command.Parameters.Add(new SqlParameter("@ContactInformation", SqlDbType.VarChar)).Value = textBox4.Text;
                    command.Parameters.Add(new SqlParameter("@Address", SqlDbType.Text)).Value = textBox5.Text;
                    command.Parameters.Add(new SqlParameter("@Insurance", SqlDbType.Bit)).Value = true;
                }

                int result = command.ExecuteNonQuery();
                // Check the result (number of rows affected)
                if (result > 0)
                {
                    Console.WriteLine("Patient added successfully.");
                }
                else
                {
                    Console.WriteLine("No patient was added.");
                } 
                patients.Clear();
                InitializePatients();
                listBox1.SelectedIndex = -1;
            }
            else
            {
                MessageBox.Show("You have empty fields");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            // Cancel button
            panel1.Visible = false;
            listBox1.Visible = true;
            btnDeletePatient.Visible = true;
            btnUpdatePatient.Visible = true;
            btnViewPatientProfile.Visible = true;
            save_record.Visible = false;
            cancel.Visible = false;
            label1.Visible = true;
            comboBox1.Visible = true;
            updatePanel.Visible = false;
            updatePatientInfo.Visible = false;
            btnAddPatient.Visible = true;

            textBox1.Clear();
            textBox2.Clear();
            textBox4.Clear();
            textBox5.Clear();
            male.Checked = false;
            Female.Checked = false;
            dateTimePicker1.Checked = false;
            checkBox1.Checked = false; 
            // other logic here !
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (male.Checked)
            {
                selectedGender = 'M';
            }
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            if (Female.Checked)
            {
                selectedGender = 'F';
            }
        }
        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            hasInsurance = !hasInsurance;
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            hasInsurance = !hasInsurance;
        }

        private void updatePatientInfo_Click(object sender, EventArgs e)
        {
            if (checkUpdateInputs())
            {
                panel1.Visible = false;
                listBox1.Visible = true;
                btnDeletePatient.Visible = true;
                btnUpdatePatient.Visible = true;
                btnViewPatientProfile.Visible = true;
                save_record.Visible = false;
                cancel.Visible = false;
                label1.Visible = true;
                comboBox1.Visible = true;
                updatePatientInfo.Visible = false;
                cancel.Visible = false;
                btnAddPatient.Visible = true;
                updatePanel.Visible = false;

                using SqlCommand command = new("UpdatePatientContact", _connection);
                {
                    command.CommandType = CommandType.StoredProcedure;

                    command.Parameters.Add(new SqlParameter("@CitizenCardNumber", SqlDbType.VarChar)).Value = selectedPatient.CitizenCardNumber;
                    command.Parameters.Add(new SqlParameter("@NewContactInformation", SqlDbType.VarChar)).Value = contactUpdate.Text;
                    command.Parameters.Add(new SqlParameter("@NewAddress", SqlDbType.Text)).Value = addressUpdate.Text;
                    command.Parameters.Add(new SqlParameter("@NewInsurance", SqlDbType.Bit)).Value = updateInsurance.Checked;
                }

                int result = command.ExecuteNonQuery();
                // Check the result (number of rows affected)
                if (result > 0)
                {
                    Console.WriteLine("Patient updated successfully.");
                }
                else
                {
                    Console.WriteLine("No patient was updated.");
                } 
                patients.Clear();
                InitializePatients();
                listBox1.SelectedIndex = -1;
            }
            else
            {
                MessageBox.Show("You have empty fields");
            }
        }

        private bool checkInputs()
        {
            if (selectedGender == 'U'
                || textBox1.Text.Length == 0
                || textBox2.Text.Length == 0
                || textBox4.Text.Length == 0
                || textBox5.Text.Length == 0
                || dateTimePicker1.ToString().Length == 0
                )
            {
                return false;
            }
            return true;
        }

        private bool checkUpdateInputs()
        {
            if (contactUpdate.Text.Length == 0
                || addressUpdate.Text.Length == 0)
            {
                return false;
            }
            return true;
        }
    }
}

