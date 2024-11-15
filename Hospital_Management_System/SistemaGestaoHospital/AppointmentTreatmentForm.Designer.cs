namespace SistemaGestaoHospital
{
    partial class AppointmentTreatmentForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnScheduleAppointment = new Button();
            btnUpdateAppointment = new Button();
            btnCancelAppointment = new Button();
            btnViewUpcomingAppointments = new Button();
            btnRecordTreatmentOutcome = new Button();
            SuspendLayout();
            // 
            // btnScheduleAppointment
            // 
            btnScheduleAppointment.Location = new Point(50, 58);
            btnScheduleAppointment.Name = "btnScheduleAppointment";
            btnScheduleAppointment.Size = new Size(400, 59);
            btnScheduleAppointment.TabIndex = 0;
            btnScheduleAppointment.Text = "Schedule Appointment";
            btnScheduleAppointment.Click += btnScheduleAppointment_Click;
            // 
            // btnUpdateAppointment
            // 
            btnUpdateAppointment.Location = new Point(50, 132);
            btnUpdateAppointment.Name = "btnUpdateAppointment";
            btnUpdateAppointment.Size = new Size(400, 59);
            btnUpdateAppointment.TabIndex = 1;
            btnUpdateAppointment.Text = "Update Appointment";
            btnUpdateAppointment.Click += btnUpdateAppointment_Click;
            // 
            // btnCancelAppointment
            // 
            btnCancelAppointment.Location = new Point(50, 214);
            btnCancelAppointment.Name = "btnCancelAppointment";
            btnCancelAppointment.Size = new Size(400, 57);
            btnCancelAppointment.TabIndex = 2;
            btnCancelAppointment.Text = "Cancel Appointment";
            btnCancelAppointment.Click += btnCancelAppointment_Click;
            // 
            // btnViewUpcomingAppointments
            // 
            btnViewUpcomingAppointments.Location = new Point(50, 288);
            btnViewUpcomingAppointments.Name = "btnViewUpcomingAppointments";
            btnViewUpcomingAppointments.Size = new Size(400, 56);
            btnViewUpcomingAppointments.TabIndex = 3;
            btnViewUpcomingAppointments.Text = "View Upcoming Appointments";
            btnViewUpcomingAppointments.Click += btnViewUpcomingAppointments_Click;
            // 
            // btnRecordTreatmentOutcome
            // 
            btnRecordTreatmentOutcome.Location = new Point(50, 360);
            btnRecordTreatmentOutcome.Name = "btnRecordTreatmentOutcome";
            btnRecordTreatmentOutcome.Size = new Size(400, 59);
            btnRecordTreatmentOutcome.TabIndex = 4;
            btnRecordTreatmentOutcome.Text = "Record Treatment Outcome";
            btnRecordTreatmentOutcome.Click += btnRecordTreatmentOutcome_Click;
            // 
            // AppointmentTreatmentForm
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnScheduleAppointment);
            Controls.Add(btnUpdateAppointment);
            Controls.Add(btnCancelAppointment);
            Controls.Add(btnViewUpcomingAppointments);
            Controls.Add(btnRecordTreatmentOutcome);
            Name = "AppointmentTreatmentForm";
            Text = "AppointmentTreatmentForm";
            ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Button btnScheduleAppointment;
        private System.Windows.Forms.Button btnUpdateAppointment;
        private System.Windows.Forms.Button btnCancelAppointment;
        private System.Windows.Forms.Button btnViewUpcomingAppointments;
        private System.Windows.Forms.Button btnRecordTreatmentOutcome;
    }
}
