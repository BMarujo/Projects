using System;
using System.Data;
using System.Data.SqlClient;

namespace SistemaGestaoHospital
{
    public partial class Form1 : Form
    {
        public static SqlConnection cn;


        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // just for debug
            textBox2.Text = "p10g10";
            textBox3.Text = "163410447.A";
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            cn = getprivSGBDConnection(textBox1.Text, "p10g10", textBox2.Text, textBox3.Text);

            if (cn.State != ConnectionState.Open)

                try
                {
                    cn.Open();
                    if (cn.State == ConnectionState.Open)
                    {
                        MessageBox.Show("Successful connection to database " + cn.Database + " on the " + cn.DataSource + " server", "Connection Test", MessageBoxButtons.OK);
                        Form mainMenu = new mainMenu();
                        mainMenu.Show();
                        this.Hide();
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Failed to open connection to database due to the error \r\n" + ex.Message, "Connection Test", MessageBoxButtons.OK);
                }
        }

        private static SqlConnection getprivSGBDConnection(string dbServer, string dbName, string userName, string userPass)
        {
            return new SqlConnection("Data Source =" + dbServer + ";" + "Initial Catalog =" + dbName + "; uid = " + userName + ";" + "password = " + userPass);

        }

    }
}
