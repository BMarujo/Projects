namespace SistemaGestaoHospital
{
    partial class RecordTreatmentOutcomeForm
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
            txtDoctorCitizenCardNumber = new TextBox();
            lblPatientCitizenCardNumber = new Label();
            txtPatientCitizenCardNumber = new TextBox();
            lblDescription = new Label();
            txtDescription = new TextBox();
            lblTestDate = new Label();
            btnSave = new Button();
            btnCancel = new Button();
            dtpAppointmentDateTime = new DateTimePicker();
            SuspendLayout();
            // 
            // lblDoctorCitizenCardNumber
            // 
            lblDoctorCitizenCardNumber.Location = new Point(50, 39);
            lblDoctorCitizenCardNumber.Name = "lblDoctorCitizenCardNumber";
            lblDoctorCitizenCardNumber.Size = new Size(266, 20);
            lblDoctorCitizenCardNumber.TabIndex = 2;
            lblDoctorCitizenCardNumber.Text = "Doctor Citizen Card Number:";
            // 
            // txtDoctorCitizenCardNumber
            // 
            txtDoctorCitizenCardNumber.Location = new Point(50, 73);
            txtDoctorCitizenCardNumber.Name = "txtDoctorCitizenCardNumber";
            txtDoctorCitizenCardNumber.Size = new Size(200, 31);
            txtDoctorCitizenCardNumber.TabIndex = 3;
            txtDoctorCitizenCardNumber.TextChanged += txtDoctorCitizenCardNumber_TextChanged;
            // 
            // lblPatientCitizenCardNumber
            // 
            lblPatientCitizenCardNumber.Location = new Point(50, 107);
            lblPatientCitizenCardNumber.Name = "lblPatientCitizenCardNumber";
            lblPatientCitizenCardNumber.Size = new Size(246, 20);
            lblPatientCitizenCardNumber.TabIndex = 4;
            lblPatientCitizenCardNumber.Text = "Patient Citizen Card Number:";
            // 
            // txtPatientCitizenCardNumber
            // 
            txtPatientCitizenCardNumber.Location = new Point(50, 146);
            txtPatientCitizenCardNumber.Name = "txtPatientCitizenCardNumber";
            txtPatientCitizenCardNumber.Size = new Size(200, 31);
            txtPatientCitizenCardNumber.TabIndex = 5;
            // 
            // lblDescription
            // 
            lblDescription.Location = new Point(50, 180);
            lblDescription.Name = "lblDescription";
            lblDescription.Size = new Size(119, 34);
            lblDescription.TabIndex = 6;
            lblDescription.Text = "Description:";
            // 
            // txtDescription
            // 
            txtDescription.Location = new Point(50, 217);
            txtDescription.Multiline = true;
            txtDescription.Name = "txtDescription";
            txtDescription.Size = new Size(500, 100);
            txtDescription.TabIndex = 7;
            // 
            // lblTestDate
            // 
            lblTestDate.Location = new Point(50, 320);
            lblTestDate.Name = "lblTestDate";
            lblTestDate.Size = new Size(100, 20);
            lblTestDate.TabIndex = 10;
            lblTestDate.Text = "Test Date:";
            // 
            // btnSave
            // 
            btnSave.Location = new Point(50, 399);
            btnSave.Name = "btnSave";
            btnSave.Size = new Size(100, 30);
            btnSave.TabIndex = 14;
            btnSave.Text = "Save";
            btnSave.Click += btnSave_Click;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(170, 399);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(100, 30);
            btnCancel.TabIndex = 15;
            btnCancel.Text = "Cancel";
            btnCancel.Click += btnCancel_Click_1;
            // 
            // dtpAppointmentDateTime
            // 
            dtpAppointmentDateTime.Location = new Point(50, 353);
            dtpAppointmentDateTime.Name = "dtpAppointmentDateTime";
            dtpAppointmentDateTime.Size = new Size(200, 31);
            dtpAppointmentDateTime.TabIndex = 16;
            // 
            // RecordTreatmentOutcomeForm
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(dtpAppointmentDateTime);
            Controls.Add(lblDoctorCitizenCardNumber);
            Controls.Add(txtDoctorCitizenCardNumber);
            Controls.Add(lblPatientCitizenCardNumber);
            Controls.Add(txtPatientCitizenCardNumber);
            Controls.Add(lblDescription);
            Controls.Add(txtDescription);
            Controls.Add(lblTestDate);
            Controls.Add(btnSave);
            Controls.Add(btnCancel);
            Name = "RecordTreatmentOutcomeForm";
            Text = "RecordTreatmentOutcomeForm";
            Load += RecordTreatmentOutcomeForm_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private System.Windows.Forms.Label lblDoctorCitizenCardNumber;
        private System.Windows.Forms.TextBox txtDoctorCitizenCardNumber;
        private System.Windows.Forms.Label lblPatientCitizenCardNumber;
        private System.Windows.Forms.TextBox txtPatientCitizenCardNumber;
        private System.Windows.Forms.Label lblDescription;
        private System.Windows.Forms.TextBox txtDescription;
        private System.Windows.Forms.Label lblTestDate;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnCancel;
        private DateTimePicker dtpAppointmentDateTime;
    }
}

