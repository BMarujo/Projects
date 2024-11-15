namespace SistemaGestaoHospital
{
    partial class UpdatePaymentStatusForm
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
            this.components = new System.ComponentModel.Container();
            this.textBoxBillID = new System.Windows.Forms.TextBox();
            this.labelBillID = new System.Windows.Forms.Label();
            this.labelPaymentStatus = new System.Windows.Forms.Label();
            this.comboBoxPaymentStatus = new System.Windows.Forms.ComboBox();
            this.buttonUpdate = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textBoxBillID
            // 
            this.textBoxBillID.Location = new System.Drawing.Point(184, 59);
            this.textBoxBillID.Name = "textBoxBillID";
            this.textBoxBillID.Size = new System.Drawing.Size(200, 22);
            this.textBoxBillID.TabIndex = 0;
            // 
            // labelBillID
            // 
            this.labelBillID.AutoSize = true;
            this.labelBillID.Location = new System.Drawing.Point(42, 59);
            this.labelBillID.Name = "labelBillID";
            this.labelBillID.Size = new System.Drawing.Size(53, 17);
            this.labelBillID.TabIndex = 1;
            this.labelBillID.Text = "Bill ID:";
            // 
            // labelPaymentStatus
            // 
            this.labelPaymentStatus.AutoSize = true;
            this.labelPaymentStatus.Location = new System.Drawing.Point(42, 107);
            this.labelPaymentStatus.Name = "labelPaymentStatus";
            this.labelPaymentStatus.Size = new System.Drawing.Size(111, 17);
            this.labelPaymentStatus.TabIndex = 2;
            this.labelPaymentStatus.Text = "Payment Status:";
            // 
            // comboBoxPaymentStatus
            // 
            this.comboBoxPaymentStatus.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.comboBoxPaymentStatus.FormattingEnabled = true;
            this.comboBoxPaymentStatus.Items.AddRange(new object[] {
            "Paid",
            "Unpaid"});
            this.comboBoxPaymentStatus.Location = new System.Drawing.Point(184, 104);
            this.comboBoxPaymentStatus.Name = "comboBoxPaymentStatus";
            this.comboBoxPaymentStatus.Size = new System.Drawing.Size(200, 24);
            this.comboBoxPaymentStatus.TabIndex = 3;
            // 
            // buttonUpdate
            // 
            this.buttonUpdate.Location = new System.Drawing.Point(130, 172);
            this.buttonUpdate.Name = "buttonUpdate";
            this.buttonUpdate.Size = new System.Drawing.Size(100, 30);
            this.buttonUpdate.TabIndex = 4;
            this.buttonUpdate.Text = "Update";
            this.buttonUpdate.UseVisualStyleBackColor = true;
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(273, 172);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(100, 30);
            this.buttonCancel.TabIndex = 5;
            this.buttonCancel.Text = "Cancel";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // UpdatePaymentStatusForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(451, 234);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonUpdate);
            this.Controls.Add(this.comboBoxPaymentStatus);
            this.Controls.Add(this.labelPaymentStatus);
            this.Controls.Add(this.labelBillID);
            this.Controls.Add(this.textBoxBillID);
            this.Name = "UpdatePaymentStatusForm";
            this.Text = "Update Payment Status";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxBillID;
        private System.Windows.Forms.Label labelBillID;
        private System.Windows.Forms.Label labelPaymentStatus;
        private System.Windows.Forms.ComboBox comboBoxPaymentStatus;
        private System.Windows.Forms.Button buttonUpdate;
        private System.Windows.Forms.Button buttonCancel;
    }
}
