namespace SistemaGestaoHospital
{
    partial class UpdateAppointmentForm
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
            lblAppointmentID = new Label();
            txtAppointmentID = new TextBox();
            lblAppointmentDateTime = new Label();
            lblStatus = new Label();
            btnUpdate = new Button();
            btnCancel = new Button();
            cmbStatus = new ComboBox();
            dtpAppointmentDateTime = new DateTimePicker();
            SuspendLayout();
            // 
            // lblAppointmentID
            // 
            lblAppointmentID.Location = new Point(50, 50);
            lblAppointmentID.Name = "lblAppointmentID";
            lblAppointmentID.Size = new Size(168, 50);
            lblAppointmentID.TabIndex = 0;
            lblAppointmentID.Text = "Appointment ID:";
            // 
            // txtAppointmentID
            // 
            txtAppointmentID.Location = new Point(283, 47);
            txtAppointmentID.Name = "txtAppointmentID";
            txtAppointmentID.Size = new Size(200, 31);
            txtAppointmentID.TabIndex = 1;
            // 
            // lblAppointmentDateTime
            // 
            lblAppointmentDateTime.Location = new Point(50, 121);
            lblAppointmentDateTime.Name = "lblAppointmentDateTime";
            lblAppointmentDateTime.Size = new Size(203, 31);
            lblAppointmentDateTime.TabIndex = 6;
            lblAppointmentDateTime.Text = "Appointment DateTime:";
            // 
            // lblStatus
            // 
            lblStatus.Location = new Point(50, 190);
            lblStatus.Name = "lblStatus";
            lblStatus.Size = new Size(150, 20);
            lblStatus.TabIndex = 10;
            lblStatus.Text = "Status:";
            // 
            // btnUpdate
            // 
            btnUpdate.Location = new Point(160, 272);
            btnUpdate.Name = "btnUpdate";
            btnUpdate.Size = new Size(124, 42);
            btnUpdate.TabIndex = 12;
            btnUpdate.Text = "Update";
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(428, 272);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(124, 42);
            btnCancel.TabIndex = 13;
            btnCancel.Text = "Cancel";
            btnCancel.Click += btnCancel_Click_1;
            // 
            // cmbStatus
            // 
            cmbStatus.Items.AddRange(new object[] { "Scheduled", "Cancelled", "Completed", "In Progress" });
            cmbStatus.Location = new Point(283, 190);
            cmbStatus.Name = "cmbStatus";
            cmbStatus.Size = new Size(200, 33);
            cmbStatus.TabIndex = 14;
            // 
            // dtpAppointmentDateTime
            // 
            dtpAppointmentDateTime.Location = new Point(283, 121);
            dtpAppointmentDateTime.Name = "dtpAppointmentDateTime";
            dtpAppointmentDateTime.Size = new Size(200, 31);
            dtpAppointmentDateTime.TabIndex = 15;
            // 
            // UpdateAppointmentForm
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(dtpAppointmentDateTime);
            Controls.Add(cmbStatus);
            Controls.Add(lblAppointmentID);
            Controls.Add(txtAppointmentID);
            Controls.Add(lblAppointmentDateTime);
            Controls.Add(lblStatus);
            Controls.Add(btnUpdate);
            Controls.Add(btnCancel);
            Name = "UpdateAppointmentForm";
            Text = "UpdateAppointmentForm";
            ResumeLayout(false);
            PerformLayout();
        }
        #endregion

        private System.Windows.Forms.Label lblAppointmentID;
        private System.Windows.Forms.TextBox txtAppointmentID;
        private System.Windows.Forms.Label lblAppointmentDateTime;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.Button btnCancel;
        private ComboBox cmbStatus;
        private DateTimePicker dtpAppointmentDateTime;
    }
}
