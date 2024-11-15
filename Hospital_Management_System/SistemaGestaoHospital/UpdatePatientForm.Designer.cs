namespace SistemaGestaoHospital
{
    partial class UpdatePatientForm
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
            this.lblCitizenCardNumber = new System.Windows.Forms.Label();
            this.txtCitizenCardNumber = new System.Windows.Forms.TextBox();
            this.lblContactInformation = new System.Windows.Forms.Label();
            this.txtContactInformation = new System.Windows.Forms.TextBox();
            this.lblAddress = new System.Windows.Forms.Label();
            this.txtAddress = new System.Windows.Forms.TextBox();
            this.lblMedicalHistory = new System.Windows.Forms.Label();
            this.txtMedicalHistory = new System.Windows.Forms.TextBox();
            this.btnUpdate = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblCitizenCardNumber
            // 
            this.lblCitizenCardNumber.AutoSize = true;
            this.lblCitizenCardNumber.Location = new System.Drawing.Point(50, 30);
            this.lblCitizenCardNumber.Name = "lblCitizenCardNumber";
            this.lblCitizenCardNumber.Size = new System.Drawing.Size(130, 17);
            this.lblCitizenCardNumber.TabIndex = 0;
            this.lblCitizenCardNumber.Text = "Citizen Card Number";
            // 
            // txtCitizenCardNumber
            // 
            this.txtCitizenCardNumber.Location = new System.Drawing.Point(200, 27);
            this.txtCitizenCardNumber.Name = "txtCitizenCardNumber";
            this.txtCitizenCardNumber.Size = new System.Drawing.Size(200, 22);
            this.txtCitizenCardNumber.TabIndex = 1;
            // 
            // lblContactInformation
            // 
            this.lblContactInformation.AutoSize = true;
            this.lblContactInformation.Location = new System.Drawing.Point(50, 70);
            this.lblContactInformation.Name = "lblContactInformation";
            this.lblContactInformation.Size = new System.Drawing.Size(124, 17);
            this.lblContactInformation.TabIndex = 2;
            this.lblContactInformation.Text = "Contact Information";
            // 
            // txtContactInformation
            // 
            this.txtContactInformation.Location = new System.Drawing.Point(200, 67);
            this.txtContactInformation.Name = "txtContactInformation";
            this.txtContactInformation.Size = new System.Drawing.Size(200, 22);
            this.txtContactInformation.TabIndex = 3;
            // 
            // lblAddress
            // 
            this.lblAddress.AutoSize = true;
            this.lblAddress.Location = new System.Drawing.Point(50, 110);
            this.lblAddress.Name = "lblAddress";
            this.lblAddress.Size = new System.Drawing.Size(60, 17);
            this.lblAddress.TabIndex = 4;
            this.lblAddress.Text = "Address";
            // 
            // txtAddress
            // 
            this.txtAddress.Location = new System.Drawing.Point(200, 107);
            this.txtAddress.Name = "txtAddress";
            this.txtAddress.Size = new System.Drawing.Size(200, 22);
            this.txtAddress.TabIndex = 5;
            // 
            // lblMedicalHistory
            // 
            this.lblMedicalHistory.AutoSize = true;
            this.lblMedicalHistory.Location = new System.Drawing.Point(50, 150);
            this.lblMedicalHistory.Name = "lblMedicalHistory";
            this.lblMedicalHistory.Size = new System.Drawing.Size(106, 17);
            this.lblMedicalHistory.TabIndex = 6;
            this.lblMedicalHistory.Text = "Medical History";
            // 
            // txtMedicalHistory
            // 
            this.txtMedicalHistory.Location = new System.Drawing.Point(200, 147);
            this.txtMedicalHistory.Multiline = true;
            this.txtMedicalHistory.Name = "txtMedicalHistory";
            this.txtMedicalHistory.Size = new System.Drawing.Size(200, 80);
            this.txtMedicalHistory.TabIndex = 7;
            // 
            // btnUpdate
            // 
            this.btnUpdate.Location = new System.Drawing.Point(200, 250);
            this.btnUpdate.Name = "btnUpdate";
            this.btnUpdate.Size = new System.Drawing.Size(100, 30);
            this.btnUpdate.TabIndex = 8;
            this.btnUpdate.Text = "Update";
            this.btnUpdate.UseVisualStyleBackColor = true;
            this.btnUpdate.Click += new System.EventHandler(this.btnUpdate_Click);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(310, 250);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(100, 30);
            this.btnCancel.TabIndex = 9;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // UpdatePatientForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnUpdate);
            this.Controls.Add(this.txtMedicalHistory);
            this.Controls.Add(this.lblMedicalHistory);
            this.Controls.Add(this.txtAddress);
            this.Controls.Add(this.lblAddress);
            this.Controls.Add(this.txtContactInformation);
            this.Controls.Add(this.lblContactInformation);
            this.Controls.Add(this.txtCitizenCardNumber);
            this.Controls.Add(this.lblCitizenCardNumber);
            this.Name = "UpdatePatientForm";
            this.Text = "Update Patient Information";
            this.ResumeLayout(false);
            this.PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Label lblCitizenCardNumber;
        private System.Windows.Forms.TextBox txtCitizenCardNumber;
        private System.Windows.Forms.Label lblContactInformation;
        private System.Windows.Forms.TextBox txtContactInformation;
        private System.Windows.Forms.Label lblAddress;
        private System.Windows.Forms.TextBox txtAddress;
        private System.Windows.Forms.Label lblMedicalHistory;
        private System.Windows.Forms.TextBox txtMedicalHistory;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.Button btnCancel;
    }
}
