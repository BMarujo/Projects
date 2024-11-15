namespace SistemaGestaoHospital
{
    partial class BillingPrescriptionsForm
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
            btnUpdatePaymentStatus = new Button();
            btnPrescribeMedication = new Button();
            label1 = new Label();
            outstandingBills = new ListBox();
            label2 = new Label();
            prescriptionList = new ListBox();
            FilterbyPatient = new ComboBox();
            SuspendLayout();
            // 
            // btnUpdatePaymentStatus
            // 
            btnUpdatePaymentStatus.BackColor = Color.LimeGreen;
            btnUpdatePaymentStatus.ForeColor = SystemColors.ActiveCaptionText;
            btnUpdatePaymentStatus.Location = new Point(153, 547);
            btnUpdatePaymentStatus.Margin = new Padding(3, 4, 3, 4);
            btnUpdatePaymentStatus.Name = "btnUpdatePaymentStatus";
            btnUpdatePaymentStatus.Size = new Size(171, 40);
            btnUpdatePaymentStatus.TabIndex = 1;
            btnUpdatePaymentStatus.Text = "Pay";
            btnUpdatePaymentStatus.UseVisualStyleBackColor = false;
            btnUpdatePaymentStatus.Click += btnUpdatePaymentStatus_Click;
            // 
            // btnPrescribeMedication
            // 
            btnPrescribeMedication.Location = new Point(527, 547);
            btnPrescribeMedication.Margin = new Padding(3, 4, 3, 4);
            btnPrescribeMedication.Name = "btnPrescribeMedication";
            btnPrescribeMedication.Size = new Size(171, 40);
            btnPrescribeMedication.TabIndex = 2;
            btnPrescribeMedication.Text = "Prescribe Medication";
            btnPrescribeMedication.Click += btnPrescribeMedication_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(24, 23);
            label1.Name = "label1";
            label1.Size = new Size(121, 20);
            label1.TabIndex = 5;
            label1.Text = "Outstanding Bills";
            // 
            // outstandingBills
            // 
            outstandingBills.FormattingEnabled = true;
            outstandingBills.Location = new Point(24, 46);
            outstandingBills.Name = "outstandingBills";
            outstandingBills.Size = new Size(427, 484);
            outstandingBills.TabIndex = 6;
            outstandingBills.SelectedIndexChanged += outstandingBills_SelectedIndexChanged;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(480, 23);
            label2.Name = "label2";
            label2.Size = new Size(87, 20);
            label2.TabIndex = 7;
            label2.Text = "Pescriptions";
            label2.Visible = false;
            // 
            // prescriptionList
            // 
            prescriptionList.FormattingEnabled = true;
            prescriptionList.Location = new Point(477, 46);
            prescriptionList.Name = "prescriptionList";
            prescriptionList.Size = new Size(425, 484);
            prescriptionList.TabIndex = 8;
            // 
            // FilterbyPatient
            // 
            FilterbyPatient.FormattingEnabled = true;
            FilterbyPatient.Location = new Point(715, 547);
            FilterbyPatient.Name = "FilterbyPatient";
            FilterbyPatient.Size = new Size(165, 28);
            FilterbyPatient.TabIndex = 9;
            FilterbyPatient.SelectedIndexChanged += FilterbyPatient_SelectedIndexChanged_1;
            // 
            // BillingPrescriptionsForm
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(914, 600);
            Controls.Add(FilterbyPatient);
            Controls.Add(prescriptionList);
            Controls.Add(label2);
            Controls.Add(outstandingBills);
            Controls.Add(label1);
            Controls.Add(btnUpdatePaymentStatus);
            Controls.Add(btnPrescribeMedication);
            Margin = new Padding(3, 4, 3, 4);
            Name = "BillingPrescriptionsForm";
            Text = "BillingPrescriptionsForm";
            Load += BillingPrescriptionsForm_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private System.Windows.Forms.Button btnUpdatePaymentStatus;
        private System.Windows.Forms.Button btnPrescribeMedication;
        private Label label1;
        private ListBox outstandingBills;
        private Label label2;
        private ListBox prescriptionList;
        private ComboBox FilterbyPatient;
    }
}
