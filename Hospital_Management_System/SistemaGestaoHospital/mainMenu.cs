using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SistemaGestaoHospital
{
    public partial class mainMenu : Form
    {
        public mainMenu()
        {
            InitializeComponent();
        }

        private void btnPatientManagement_Click(object sender, EventArgs e)
        {
            // Open the Patient Management form
            PatientManagementForm patientManagementForm = new PatientManagementForm();
            patientManagementForm.Show();
        }

        private void btnAppointmentTreatment_Click(object sender, EventArgs e)
        {
            // Open the Appointment and Treatment form
            AppointmentTreatmentForm appointmentTreatmentForm = new AppointmentTreatmentForm();
            appointmentTreatmentForm.Show();
        }

        private void btnBillingPrescriptions_Click(object sender, EventArgs e)
        {
            // Open the Billing and Prescriptions form
            BillingPrescriptionsForm billingPrescriptionsForm = new BillingPrescriptionsForm();
            billingPrescriptionsForm.Show();
        }

        private void mainMenu_Load(object sender, EventArgs e)
        {

        }
    }
}
