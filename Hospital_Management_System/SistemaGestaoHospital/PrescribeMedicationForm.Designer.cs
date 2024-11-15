namespace SistemaGestaoHospital
{
    partial class PrescribeMedicationForm
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
            labelPatientID = new Label();
            labelDoctorID = new Label();
            labelAppointmentID = new Label();
            labelPrescriptionDate = new Label();
            dateTimePickerPrescriptionDate = new DateTimePicker();
            labelDosageInstructions = new Label();
            labelMedicationID = new Label();
            buttonPrescribe = new Button();
            buttonCancel = new Button();
            richTextBox1 = new RichTextBox();
            PatientsDropdown = new ComboBox();
            AppointmentDropdown = new ComboBox();
            DoctorsDropdown = new ComboBox();
            MedicationDropdown = new ComboBox();
            SuspendLayout();
            // 
            // labelPatientID
            // 
            labelPatientID.AutoSize = true;
            labelPatientID.Location = new Point(36, 27);
            labelPatientID.Name = "labelPatientID";
            labelPatientID.Size = new Size(60, 20);
            labelPatientID.TabIndex = 1;
            labelPatientID.Text = "Patients";
            // 
            // labelDoctorID
            // 
            labelDoctorID.AutoSize = true;
            labelDoctorID.Location = new Point(36, 74);
            labelDoctorID.Name = "labelDoctorID";
            labelDoctorID.Size = new Size(61, 20);
            labelDoctorID.TabIndex = 3;
            labelDoctorID.Text = "Doctors";
            // 
            // labelAppointmentID
            // 
            labelAppointmentID.AutoSize = true;
            labelAppointmentID.Location = new Point(35, 122);
            labelAppointmentID.Name = "labelAppointmentID";
            labelAppointmentID.Size = new Size(97, 20);
            labelAppointmentID.TabIndex = 5;
            labelAppointmentID.Text = "Appointment";
            // 
            // labelPrescriptionDate
            // 
            labelPrescriptionDate.AutoSize = true;
            labelPrescriptionDate.Location = new Point(32, 172);
            labelPrescriptionDate.Name = "labelPrescriptionDate";
            labelPrescriptionDate.Size = new Size(123, 20);
            labelPrescriptionDate.TabIndex = 6;
            labelPrescriptionDate.Text = "Prescription Date";
            // 
            // dateTimePickerPrescriptionDate
            // 
            dateTimePickerPrescriptionDate.Location = new Point(184, 172);
            dateTimePickerPrescriptionDate.Margin = new Padding(3, 4, 3, 4);
            dateTimePickerPrescriptionDate.Name = "dateTimePickerPrescriptionDate";
            dateTimePickerPrescriptionDate.Size = new Size(227, 27);
            dateTimePickerPrescriptionDate.TabIndex = 7;
            dateTimePickerPrescriptionDate.ValueChanged += dateTimePickerPrescriptionDate_ValueChanged;
            // 
            // labelDosageInstructions
            // 
            labelDosageInstructions.AutoSize = true;
            labelDosageInstructions.Location = new Point(32, 224);
            labelDosageInstructions.Name = "labelDosageInstructions";
            labelDosageInstructions.Size = new Size(142, 20);
            labelDosageInstructions.TabIndex = 8;
            labelDosageInstructions.Text = "Dosage Instructions:";
            // 
            // labelMedicationID
            // 
            labelMedicationID.AutoSize = true;
            labelMedicationID.Location = new Point(32, 345);
            labelMedicationID.Name = "labelMedicationID";
            labelMedicationID.Size = new Size(90, 20);
            labelMedicationID.TabIndex = 10;
            labelMedicationID.Text = "Medications";
            // 
            // buttonPrescribe
            // 
            buttonPrescribe.Location = new Point(46, 409);
            buttonPrescribe.Margin = new Padding(3, 4, 3, 4);
            buttonPrescribe.Name = "buttonPrescribe";
            buttonPrescribe.Size = new Size(162, 38);
            buttonPrescribe.TabIndex = 12;
            buttonPrescribe.Text = "Prescribe";
            buttonPrescribe.UseVisualStyleBackColor = true;
            buttonPrescribe.Click += buttonPrescribe_Click;
            // 
            // buttonCancel
            // 
            buttonCancel.Location = new Point(252, 409);
            buttonCancel.Margin = new Padding(3, 4, 3, 4);
            buttonCancel.Name = "buttonCancel";
            buttonCancel.Size = new Size(168, 38);
            buttonCancel.TabIndex = 13;
            buttonCancel.Text = "Cancel";
            buttonCancel.UseVisualStyleBackColor = true;
            buttonCancel.Click += buttonCancel_Click;
            // 
            // richTextBox1
            // 
            richTextBox1.Location = new Point(184, 224);
            richTextBox1.Name = "richTextBox1";
            richTextBox1.Size = new Size(227, 99);
            richTextBox1.TabIndex = 14;
            richTextBox1.Text = "";
            richTextBox1.TextChanged += richTextBox1_TextChanged;
            // 
            // PatientsDropdown
            // 
            PatientsDropdown.FormattingEnabled = true;
            PatientsDropdown.Location = new Point(184, 27);
            PatientsDropdown.Name = "PatientsDropdown";
            PatientsDropdown.Size = new Size(227, 28);
            PatientsDropdown.TabIndex = 15;
            PatientsDropdown.SelectedIndexChanged += PatientsDropdown_SelectedIndexChanged;
            // 
            // AppointmentDropdown
            // 
            AppointmentDropdown.FormattingEnabled = true;
            AppointmentDropdown.Location = new Point(184, 122);
            AppointmentDropdown.Name = "AppointmentDropdown";
            AppointmentDropdown.Size = new Size(227, 28);
            AppointmentDropdown.TabIndex = 16;
            AppointmentDropdown.SelectedIndexChanged += AppointmentDropdown_SelectedIndexChanged;
            // 
            // DoctorsDropdown
            // 
            DoctorsDropdown.FormattingEnabled = true;
            DoctorsDropdown.Location = new Point(184, 74);
            DoctorsDropdown.Name = "DoctorsDropdown";
            DoctorsDropdown.Size = new Size(227, 28);
            DoctorsDropdown.TabIndex = 17;
            DoctorsDropdown.SelectedIndexChanged += DoctorsDropdown_SelectedIndexChanged;
            // 
            // MedicationDropdown
            // 
            MedicationDropdown.FormattingEnabled = true;
            MedicationDropdown.Location = new Point(184, 345);
            MedicationDropdown.Name = "MedicationDropdown";
            MedicationDropdown.Size = new Size(227, 28);
            MedicationDropdown.TabIndex = 18;
            MedicationDropdown.SelectedIndexChanged += MedicationDropdown_SelectedIndexChanged;
            // 
            // PrescribeMedicationForm
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(458, 485);
            Controls.Add(MedicationDropdown);
            Controls.Add(DoctorsDropdown);
            Controls.Add(AppointmentDropdown);
            Controls.Add(PatientsDropdown);
            Controls.Add(richTextBox1);
            Controls.Add(buttonCancel);
            Controls.Add(buttonPrescribe);
            Controls.Add(labelMedicationID);
            Controls.Add(labelDosageInstructions);
            Controls.Add(dateTimePickerPrescriptionDate);
            Controls.Add(labelPrescriptionDate);
            Controls.Add(labelAppointmentID);
            Controls.Add(labelDoctorID);
            Controls.Add(labelPatientID);
            Margin = new Padding(3, 4, 3, 4);
            Name = "PrescribeMedicationForm";
            Text = "Prescribe Medication Form";
            Load += PrescribeMedicationForm_Load_1;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private System.Windows.Forms.Label labelPatientID;
        private System.Windows.Forms.Label labelDoctorID;
        private System.Windows.Forms.Label labelAppointmentID;
        private System.Windows.Forms.Label labelPrescriptionDate;
        private System.Windows.Forms.DateTimePicker dateTimePickerPrescriptionDate;
        private System.Windows.Forms.Label labelDosageInstructions;
        private System.Windows.Forms.Label labelMedicationID;
        private System.Windows.Forms.Button buttonPrescribe;
        private System.Windows.Forms.Button buttonCancel;
        private RichTextBox richTextBox1;
        private ComboBox PatientsDropdown;
        private ComboBox AppointmentDropdown;
        private ComboBox DoctorsDropdown;
        private ComboBox MedicationDropdown;
    }
}

