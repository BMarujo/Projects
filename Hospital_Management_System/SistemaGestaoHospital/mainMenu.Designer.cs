namespace SistemaGestaoHospital
{
    partial class mainMenu
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
            btnPatientManagement = new Button();
            btnAppointmentTreatment = new Button();
            btnBillingPrescriptions = new Button();
            SuspendLayout();
            // 
            // btnPatientManagement
            // 
            btnPatientManagement.Location = new Point(375, 78);
            btnPatientManagement.Margin = new Padding(4, 5, 4, 5);
            btnPatientManagement.Name = "btnPatientManagement";
            btnPatientManagement.Size = new Size(250, 78);
            btnPatientManagement.TabIndex = 0;
            btnPatientManagement.Text = "Patient Management";
            btnPatientManagement.UseVisualStyleBackColor = true;
            btnPatientManagement.Click += btnPatientManagement_Click;
            // 
            // btnAppointmentTreatment
            // 
            btnAppointmentTreatment.Location = new Point(375, 234);
            btnAppointmentTreatment.Margin = new Padding(4, 5, 4, 5);
            btnAppointmentTreatment.Name = "btnAppointmentTreatment";
            btnAppointmentTreatment.Size = new Size(250, 78);
            btnAppointmentTreatment.TabIndex = 1;
            btnAppointmentTreatment.Text = "Appointment and Treatment";
            btnAppointmentTreatment.UseVisualStyleBackColor = true;
            btnAppointmentTreatment.Click += btnAppointmentTreatment_Click;
            // 
            // btnBillingPrescriptions
            // 
            btnBillingPrescriptions.Location = new Point(375, 391);
            btnBillingPrescriptions.Margin = new Padding(4, 5, 4, 5);
            btnBillingPrescriptions.Name = "btnBillingPrescriptions";
            btnBillingPrescriptions.Size = new Size(250, 78);
            btnBillingPrescriptions.TabIndex = 2;
            btnBillingPrescriptions.Text = "Billing and Prescriptions";
            btnBillingPrescriptions.UseVisualStyleBackColor = true;
            btnBillingPrescriptions.Click += btnBillingPrescriptions_Click;
            // 
            // mainMenu
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1000, 703);
            Controls.Add(btnBillingPrescriptions);
            Controls.Add(btnAppointmentTreatment);
            Controls.Add(btnPatientManagement);
            Margin = new Padding(4, 5, 4, 5);
            Name = "mainMenu";
            Text = "Main Menu";
            Load += mainMenu_Load;
            ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Button btnPatientManagement;
        private System.Windows.Forms.Button btnAppointmentTreatment;
        private System.Windows.Forms.Button btnBillingPrescriptions;
    }
}
