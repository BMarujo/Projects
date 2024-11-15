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
    public partial class AppointmentTreatmentForm : Form
    {
        public AppointmentTreatmentForm()
        {
            InitializeComponent();
        }

        private void btnScheduleAppointment_Click(object sender, EventArgs e)
        {
            // Open the form to schedule appointment
            ScheduleAppointmentForm scheduleAppointmentForm = new ScheduleAppointmentForm();
            scheduleAppointmentForm.Show();
            this.Hide();
        }

        private void btnUpdateAppointment_Click(object sender, EventArgs e)
        {
            // Open the form to update appointment
            UpdateAppointmentForm updateAppointmentForm = new UpdateAppointmentForm();
            updateAppointmentForm.Show();
            this.Hide();
        }

        private void btnCancelAppointment_Click(object sender, EventArgs e)
        {
            // Open the form to cancel appointment
            CancelAppointmentForm cancelAppointmentForm = new CancelAppointmentForm();
            cancelAppointmentForm.Show();
            this.Hide();
        }

        private void btnViewUpcomingAppointments_Click(object sender, EventArgs e)
        {
            // Open the form to view upcoming appointments
            ViewUpcomingAppointmentsForm viewUpcomingAppointmentsForm = new ViewUpcomingAppointmentsForm();
            viewUpcomingAppointmentsForm.Show();
            this.Hide();
        }

        private void btnRecordTreatmentOutcome_Click(object sender, EventArgs e)
        {
            // Open the form to record treatment outcome

            RecordTreatmentOutcomeForm recordTreatmentOutcomeForm = new RecordTreatmentOutcomeForm();
            recordTreatmentOutcomeForm.Show();
            this.Hide();
        }
    }
}
