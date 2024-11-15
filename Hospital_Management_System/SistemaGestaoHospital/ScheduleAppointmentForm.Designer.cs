namespace SistemaGestaoHospital
{
    partial class ScheduleAppointmentForm
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
            lblDoctorCitizenCardNumber = new Label();
            lblPatientCitizenCardNumber = new Label();
            lblAppointmentDateTime = new Label();
            dtpAppointmentDateTime = new DateTimePicker();
            lblReason = new Label();
            txtReason = new TextBox();
            lblStatus = new Label();
            cmbStatus = new ComboBox();
            btnSave = new Button();
            btnCancel = new Button();
            PatientsDropdown = new ComboBox();
            DoctorsDropdown = new ComboBox();
            SuspendLayout();
            // 
            // lblDoctorCitizenCardNumber
            // 
            lblDoctorCitizenCardNumber.Location = new Point(40, 40);
            lblDoctorCitizenCardNumber.Margin = new Padding(2, 0, 2, 0);
            lblDoctorCitizenCardNumber.Name = "lblDoctorCitizenCardNumber";
            lblDoctorCitizenCardNumber.Size = new Size(195, 16);
            lblDoctorCitizenCardNumber.TabIndex = 0;
            lblDoctorCitizenCardNumber.Text = "Doctor Citizen Card Number:";
            // 
            // lblPatientCitizenCardNumber
            // 
            lblPatientCitizenCardNumber.Location = new Point(40, 80);
            lblPatientCitizenCardNumber.Margin = new Padding(2, 0, 2, 0);
            lblPatientCitizenCardNumber.Name = "lblPatientCitizenCardNumber";
            lblPatientCitizenCardNumber.Size = new Size(195, 16);
            lblPatientCitizenCardNumber.TabIndex = 2;
            lblPatientCitizenCardNumber.Text = "Patient Citizen Card Number:";
            // 
            // lblAppointmentDateTime
            // 
            lblAppointmentDateTime.Location = new Point(40, 120);
            lblAppointmentDateTime.Margin = new Padding(2, 0, 2, 0);
            lblAppointmentDateTime.Name = "lblAppointmentDateTime";
            lblAppointmentDateTime.Size = new Size(176, 25);
            lblAppointmentDateTime.TabIndex = 4;
            lblAppointmentDateTime.Text = "Appointment DateTime:";
            // 
            // dtpAppointmentDateTime
            // 
            dtpAppointmentDateTime.Location = new Point(240, 120);
            dtpAppointmentDateTime.Margin = new Padding(2, 2, 2, 2);
            dtpAppointmentDateTime.Name = "dtpAppointmentDateTime";
            dtpAppointmentDateTime.Size = new Size(161, 27);
            dtpAppointmentDateTime.TabIndex = 5;
            // 
            // lblReason
            // 
            lblReason.Location = new Point(40, 160);
            lblReason.Margin = new Padding(2, 0, 2, 0);
            lblReason.Name = "lblReason";
            lblReason.Size = new Size(160, 16);
            lblReason.TabIndex = 6;
            lblReason.Text = "Reason:";
            // 
            // txtReason
            // 
            txtReason.Location = new Point(240, 160);
            txtReason.Margin = new Padding(2, 2, 2, 2);
            txtReason.Name = "txtReason";
            txtReason.Size = new Size(161, 27);
            txtReason.TabIndex = 7;
            // 
            // lblStatus
            // 
            lblStatus.Location = new Point(40, 200);
            lblStatus.Margin = new Padding(2, 0, 2, 0);
            lblStatus.Name = "lblStatus";
            lblStatus.Size = new Size(160, 16);
            lblStatus.TabIndex = 8;
            lblStatus.Text = "Status:";
            // 
            // cmbStatus
            // 
            cmbStatus.Items.AddRange(new object[] { "Scheduled", "Cancelled", "Completed", "In Progress" });
            cmbStatus.Location = new Point(240, 200);
            cmbStatus.Margin = new Padding(2, 2, 2, 2);
            cmbStatus.Name = "cmbStatus";
            cmbStatus.Size = new Size(161, 28);
            cmbStatus.TabIndex = 9;
            // 
            // btnSave
            // 
            btnSave.Location = new Point(40, 240);
            btnSave.Margin = new Padding(2, 2, 2, 2);
            btnSave.Name = "btnSave";
            btnSave.Size = new Size(80, 24);
            btnSave.TabIndex = 10;
            btnSave.Text = "Save";
            btnSave.Click += btnSave_Click;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(136, 240);
            btnCancel.Margin = new Padding(2, 2, 2, 2);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(80, 24);
            btnCancel.TabIndex = 11;
            btnCancel.Text = "Cancel";
            btnCancel.Click += btnCancel_Click;
            // 
            // PatientsDropdown
            // 
            PatientsDropdown.FormattingEnabled = true;
            PatientsDropdown.Location = new Point(240, 77);
            PatientsDropdown.Name = "PatientsDropdown";
            PatientsDropdown.Size = new Size(161, 28);
            PatientsDropdown.TabIndex = 16;
            PatientsDropdown.SelectedIndexChanged += PatientsDropdown_SelectedIndexChanged;
            // 
            // DoctorsDropdown
            // 
            DoctorsDropdown.FormattingEnabled = true;
            DoctorsDropdown.Location = new Point(240, 37);
            DoctorsDropdown.Name = "DoctorsDropdown";
            DoctorsDropdown.Size = new Size(161, 28);
            DoctorsDropdown.TabIndex = 18;
            DoctorsDropdown.SelectedIndexChanged += DoctorsDropdown_SelectedIndexChanged;
            // 
            // ScheduleAppointmentForm
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(640, 360);
            Controls.Add(DoctorsDropdown);
            Controls.Add(PatientsDropdown);
            Controls.Add(lblDoctorCitizenCardNumber);
            Controls.Add(lblPatientCitizenCardNumber);
            Controls.Add(lblAppointmentDateTime);
            Controls.Add(dtpAppointmentDateTime);
            Controls.Add(lblReason);
            Controls.Add(txtReason);
            Controls.Add(lblStatus);
            Controls.Add(cmbStatus);
            Controls.Add(btnSave);
            Controls.Add(btnCancel);
            Margin = new Padding(2, 2, 2, 2);
            Name = "ScheduleAppointmentForm";
            Text = "ScheduleAppointmentForm";
            Load += ScheduleAppointmentForm_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Label lblDoctorCitizenCardNumber;
        private System.Windows.Forms.Label lblPatientCitizenCardNumber;
        private System.Windows.Forms.Label lblAppointmentDateTime;
        private System.Windows.Forms.DateTimePicker dtpAppointmentDateTime;
        private System.Windows.Forms.Label lblReason;
        private System.Windows.Forms.TextBox txtReason;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ComboBox cmbStatus;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnCancel;
        private ComboBox PatientsDropdown;
        private ComboBox DoctorsDropdown;
    }
}
