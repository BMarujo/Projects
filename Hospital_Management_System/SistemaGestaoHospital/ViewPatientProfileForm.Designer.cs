namespace SistemaGestaoHospital
{
    partial class ViewPatientProfileForm
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
            lblCitizenCardNumber = new Label();
            txtCitizenCardNumber = new TextBox();
            btnViewProfile = new Button();
            lblName = new Label();
            txtName = new TextBox();
            lblGender = new Label();
            txtGender = new TextBox();
            lblDateOfBirth = new Label();
            txtDateOfBirth = new TextBox();
            lblContactInformation = new Label();
            txtContactInformation = new TextBox();
            lblAddress = new Label();
            txtAddress = new TextBox();
            lblMedicalHistory = new Label();
            txtMedicalHistory = new TextBox();
            SuspendLayout();
            // 
            // lblCitizenCardNumber
            // 
            lblCitizenCardNumber.AutoSize = true;
            lblCitizenCardNumber.Location = new Point(26, 28);
            lblCitizenCardNumber.Name = "lblCitizenCardNumber";
            lblCitizenCardNumber.Size = new Size(118, 15);
            lblCitizenCardNumber.TabIndex = 0;
            lblCitizenCardNumber.Text = "Citizen Card Number";
            // 
            // txtCitizenCardNumber
            // 
            txtCitizenCardNumber.Location = new Point(158, 25);
            txtCitizenCardNumber.Name = "txtCitizenCardNumber";
            txtCitizenCardNumber.Size = new Size(176, 23);
            txtCitizenCardNumber.TabIndex = 1;
            // 
            // btnViewProfile
            // 
            btnViewProfile.Location = new Point(350, 23);
            btnViewProfile.Name = "btnViewProfile";
            btnViewProfile.Size = new Size(88, 28);
            btnViewProfile.TabIndex = 2;
            btnViewProfile.Text = "Search";
            btnViewProfile.UseVisualStyleBackColor = true;
            btnViewProfile.Click += btnViewProfile_Click;
            // 
            // lblName
            // 
            lblName.AutoSize = true;
            lblName.Location = new Point(26, 66);
            lblName.Name = "lblName";
            lblName.Size = new Size(39, 15);
            lblName.TabIndex = 3;
            lblName.Text = "Name";
            // 
            // txtName
            // 
            txtName.Location = new Point(158, 63);
            txtName.Name = "txtName";
            txtName.Size = new Size(176, 23);
            txtName.TabIndex = 4;
            // 
            // lblGender
            // 
            lblGender.AutoSize = true;
            lblGender.Location = new Point(26, 103);
            lblGender.Name = "lblGender";
            lblGender.Size = new Size(45, 15);
            lblGender.TabIndex = 5;
            lblGender.Text = "Gender";
            // 
            // txtGender
            // 
            txtGender.Location = new Point(158, 100);
            txtGender.Name = "txtGender";
            txtGender.Size = new Size(176, 23);
            txtGender.TabIndex = 6;
            // 
            // lblDateOfBirth
            // 
            lblDateOfBirth.AutoSize = true;
            lblDateOfBirth.Location = new Point(26, 141);
            lblDateOfBirth.Name = "lblDateOfBirth";
            lblDateOfBirth.Size = new Size(73, 15);
            lblDateOfBirth.TabIndex = 7;
            lblDateOfBirth.Text = "Date of Birth";
            // 
            // txtDateOfBirth
            // 
            txtDateOfBirth.Location = new Point(158, 138);
            txtDateOfBirth.Name = "txtDateOfBirth";
            txtDateOfBirth.Size = new Size(176, 23);
            txtDateOfBirth.TabIndex = 8;
            // 
            // lblContactInformation
            // 
            lblContactInformation.AutoSize = true;
            lblContactInformation.Location = new Point(26, 178);
            lblContactInformation.Name = "lblContactInformation";
            lblContactInformation.Size = new Size(115, 15);
            lblContactInformation.TabIndex = 9;
            lblContactInformation.Text = "Contact Information";
            // 
            // txtContactInformation
            // 
            txtContactInformation.Location = new Point(158, 175);
            txtContactInformation.Name = "txtContactInformation";
            txtContactInformation.Size = new Size(176, 23);
            txtContactInformation.TabIndex = 10;
            // 
            // lblAddress
            // 
            lblAddress.AutoSize = true;
            lblAddress.Location = new Point(26, 216);
            lblAddress.Name = "lblAddress";
            lblAddress.Size = new Size(49, 15);
            lblAddress.TabIndex = 11;
            lblAddress.Text = "Address";
            // 
            // txtAddress
            // 
            txtAddress.Location = new Point(158, 213);
            txtAddress.Name = "txtAddress";
            txtAddress.Size = new Size(176, 23);
            txtAddress.TabIndex = 12;
            // 
            // lblMedicalHistory
            // 
            lblMedicalHistory.AutoSize = true;
            lblMedicalHistory.Location = new Point(26, 253);
            lblMedicalHistory.Name = "lblMedicalHistory";
            lblMedicalHistory.Size = new Size(90, 15);
            lblMedicalHistory.TabIndex = 13;
            lblMedicalHistory.Text = "Medical History";
            // 
            // txtMedicalHistory
            // 
            txtMedicalHistory.Location = new Point(158, 250);
            txtMedicalHistory.Multiline = true;
            txtMedicalHistory.Name = "txtMedicalHistory";
            txtMedicalHistory.Size = new Size(176, 75);
            txtMedicalHistory.TabIndex = 14;
            // 
            // ViewPatientProfileForm
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(525, 375);
            Controls.Add(txtMedicalHistory);
            Controls.Add(lblMedicalHistory);
            Controls.Add(txtAddress);
            Controls.Add(lblAddress);
            Controls.Add(txtContactInformation);
            Controls.Add(lblContactInformation);
            Controls.Add(txtDateOfBirth);
            Controls.Add(lblDateOfBirth);
            Controls.Add(txtGender);
            Controls.Add(lblGender);
            Controls.Add(txtName);
            Controls.Add(lblName);
            Controls.Add(btnViewProfile);
            Controls.Add(txtCitizenCardNumber);
            Controls.Add(lblCitizenCardNumber);
            Name = "ViewPatientProfileForm";
            Text = "View Patient Profile";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Label lblCitizenCardNumber;
        private System.Windows.Forms.TextBox txtCitizenCardNumber;
        private System.Windows.Forms.Button btnViewProfile;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblGender;
        private System.Windows.Forms.TextBox txtGender;
        private System.Windows.Forms.Label lblDateOfBirth;
        private System.Windows.Forms.TextBox txtDateOfBirth;
        private System.Windows.Forms.Label lblContactInformation;
        private System.Windows.Forms.TextBox txtContactInformation;
        private System.Windows.Forms.Label lblAddress;
        private System.Windows.Forms.TextBox txtAddress;
        private System.Windows.Forms.Label lblMedicalHistory;
        private System.Windows.Forms.TextBox txtMedicalHistory;
    }
}
