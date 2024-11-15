namespace SistemaGestaoHospital
{
    partial class PatientManagementForm
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
            btnAddPatient = new Button();
            btnUpdatePatient = new Button();
            btnDeletePatient = new Button();
            btnViewPatientProfile = new Button();
            listBox1 = new ListBox();
            comboBox1 = new ComboBox();
            label1 = new Label();
            panel1 = new Panel();
            Female = new RadioButton();
            male = new RadioButton();
            label2 = new Label();
            textBox1 = new TextBox();
            label8 = new Label();
            checkBox1 = new CheckBox();
            label7 = new Label();
            label3 = new Label();
            label6 = new Label();
            textBox2 = new TextBox();
            textBox5 = new TextBox();
            label4 = new Label();
            textBox4 = new TextBox();
            label5 = new Label();
            dateTimePicker1 = new DateTimePicker();
            updatePanel = new Panel();
            updateInsurance = new CheckBox();
            addressUpdate = new TextBox();
            contactUpdate = new TextBox();
            label11 = new Label();
            label10 = new Label();
            label9 = new Label();
            save_record = new Button();
            cancel = new Button();
            updatePatientInfo = new Button();
            panel1.SuspendLayout();
            updatePanel.SuspendLayout();
            SuspendLayout();
            // 
            // btnAddPatient
            // 
            btnAddPatient.Location = new Point(50, 57);
            btnAddPatient.Margin = new Padding(3, 4, 3, 4);
            btnAddPatient.Name = "btnAddPatient";
            btnAddPatient.Size = new Size(200, 62);
            btnAddPatient.TabIndex = 0;
            btnAddPatient.Text = "Add New Patient";
            btnAddPatient.UseVisualStyleBackColor = true;
            btnAddPatient.Click += btnAddPatient_Click;
            // 
            // btnUpdatePatient
            // 
            btnUpdatePatient.Location = new Point(467, 478);
            btnUpdatePatient.Margin = new Padding(3, 4, 3, 4);
            btnUpdatePatient.Name = "btnUpdatePatient";
            btnUpdatePatient.Size = new Size(146, 51);
            btnUpdatePatient.TabIndex = 1;
            btnUpdatePatient.Text = "Update Record";
            btnUpdatePatient.UseVisualStyleBackColor = true;
            btnUpdatePatient.Click += btnUpdatePatient_Click;
            // 
            // btnDeletePatient
            // 
            btnDeletePatient.Location = new Point(315, 478);
            btnDeletePatient.Margin = new Padding(3, 4, 3, 4);
            btnDeletePatient.Name = "btnDeletePatient";
            btnDeletePatient.Size = new Size(146, 51);
            btnDeletePatient.TabIndex = 2;
            btnDeletePatient.Text = "Delete Record";
            btnDeletePatient.UseVisualStyleBackColor = true;
            btnDeletePatient.Click += btnDeletePatient_Click;
            // 
            // btnViewPatientProfile
            // 
            btnViewPatientProfile.Location = new Point(619, 478);
            btnViewPatientProfile.Margin = new Padding(3, 4, 3, 4);
            btnViewPatientProfile.Name = "btnViewPatientProfile";
            btnViewPatientProfile.Size = new Size(146, 51);
            btnViewPatientProfile.TabIndex = 3;
            btnViewPatientProfile.Text = "See Profile";
            btnViewPatientProfile.UseVisualStyleBackColor = true;
            btnViewPatientProfile.Click += btnViewPatientProfile_Click;
            // 
            // listBox1
            // 
            listBox1.FormattingEnabled = true;
            listBox1.Location = new Point(315, 57);
            listBox1.Name = "listBox1";
            listBox1.Size = new Size(452, 384);
            listBox1.TabIndex = 5;
            listBox1.SelectedIndexChanged += listBox1_SelectedIndexChanged;
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Location = new Point(50, 179);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(200, 28);
            comboBox1.TabIndex = 6;
            comboBox1.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(50, 156);
            label1.Name = "label1";
            label1.Size = new Size(186, 20);
            label1.TabIndex = 7;
            label1.Text = "Filter Patients by Condition";
            // 
            // panel1
            // 
            panel1.Controls.Add(Female);
            panel1.Controls.Add(male);
            panel1.Controls.Add(label2);
            panel1.Controls.Add(textBox1);
            panel1.Controls.Add(label8);
            panel1.Controls.Add(checkBox1);
            panel1.Controls.Add(label7);
            panel1.Controls.Add(label3);
            panel1.Controls.Add(label6);
            panel1.Controls.Add(textBox2);
            panel1.Controls.Add(textBox5);
            panel1.Controls.Add(label4);
            panel1.Controls.Add(textBox4);
            panel1.Controls.Add(label5);
            panel1.Controls.Add(dateTimePicker1);
            panel1.Location = new Point(315, 57);
            panel1.Name = "panel1";
            panel1.Size = new Size(450, 384);
            panel1.TabIndex = 8;
            // 
            // Female
            // 
            Female.AutoSize = true;
            Female.Location = new Point(306, 120);
            Female.Name = "Female";
            Female.Size = new Size(78, 24);
            Female.TabIndex = 17;
            Female.TabStop = true;
            Female.Text = "Female";
            Female.UseVisualStyleBackColor = true;
            Female.CheckedChanged += radioButton2_CheckedChanged;
            // 
            // male
            // 
            male.AutoSize = true;
            male.Location = new Point(223, 120);
            male.Name = "male";
            male.Size = new Size(63, 24);
            male.TabIndex = 16;
            male.TabStop = true;
            male.Text = "Male";
            male.UseVisualStyleBackColor = true;
            male.CheckedChanged += radioButton1_CheckedChanged;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(13, 12);
            label2.Name = "label2";
            label2.Size = new Size(147, 20);
            label2.TabIndex = 0;
            label2.Text = "Citizen Card Number";
            // 
            // textBox1
            // 
            textBox1.Location = new Point(223, 9);
            textBox1.Margin = new Padding(3, 4, 3, 4);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(200, 27);
            textBox1.TabIndex = 1;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(17, 335);
            label8.Name = "label8";
            label8.Size = new Size(71, 20);
            label8.TabIndex = 12;
            label8.Text = "Insurance";
            // 
            // checkBox1
            // 
            checkBox1.AutoSize = true;
            checkBox1.Location = new Point(223, 338);
            checkBox1.Margin = new Padding(3, 4, 3, 4);
            checkBox1.Name = "checkBox1";
            checkBox1.Size = new Size(18, 17);
            checkBox1.TabIndex = 13;
            checkBox1.UseVisualStyleBackColor = true;
            checkBox1.CheckedChanged += checkBox1_CheckedChanged;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(17, 284);
            label7.Name = "label7";
            label7.Size = new Size(62, 20);
            label7.TabIndex = 10;
            label7.Text = "Address";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(13, 67);
            label3.Name = "label3";
            label3.Size = new Size(49, 20);
            label3.TabIndex = 2;
            label3.Text = "Name";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(13, 230);
            label6.Name = "label6";
            label6.Size = new Size(142, 20);
            label6.TabIndex = 8;
            label6.Text = "Contact Information";
            // 
            // textBox2
            // 
            textBox2.Location = new Point(223, 64);
            textBox2.Margin = new Padding(3, 4, 3, 4);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(200, 27);
            textBox2.TabIndex = 3;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(223, 281);
            textBox5.Margin = new Padding(3, 4, 3, 4);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(200, 27);
            textBox5.TabIndex = 11;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(13, 122);
            label4.Name = "label4";
            label4.Size = new Size(57, 20);
            label4.TabIndex = 4;
            label4.Text = "Gender";
            // 
            // textBox4
            // 
            textBox4.Location = new Point(223, 227);
            textBox4.Margin = new Padding(3, 4, 3, 4);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(200, 27);
            textBox4.TabIndex = 9;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(13, 178);
            label5.Name = "label5";
            label5.Size = new Size(94, 20);
            label5.TabIndex = 6;
            label5.Text = "Date of Birth";
            // 
            // dateTimePicker1
            // 
            dateTimePicker1.Location = new Point(223, 173);
            dateTimePicker1.Margin = new Padding(3, 4, 3, 4);
            dateTimePicker1.Name = "dateTimePicker1";
            dateTimePicker1.Size = new Size(200, 27);
            dateTimePicker1.TabIndex = 7;
            // 
            // updatePanel
            // 
            updatePanel.Controls.Add(updateInsurance);
            updatePanel.Controls.Add(addressUpdate);
            updatePanel.Controls.Add(contactUpdate);
            updatePanel.Controls.Add(label11);
            updatePanel.Controls.Add(label10);
            updatePanel.Controls.Add(label9);
            updatePanel.Location = new Point(310, 225);
            updatePanel.Name = "updatePanel";
            updatePanel.Size = new Size(455, 163);
            updatePanel.TabIndex = 18;
            // 
            // updateInsurance
            // 
            updateInsurance.AutoSize = true;
            updateInsurance.Location = new Point(223, 117);
            updateInsurance.Name = "updateInsurance";
            updateInsurance.Size = new Size(18, 17);
            updateInsurance.TabIndex = 5;
            updateInsurance.UseVisualStyleBackColor = true;
            updateInsurance.CheckedChanged += checkBox2_CheckedChanged;
            // 
            // addressUpdate
            // 
            addressUpdate.Location = new Point(223, 57);
            addressUpdate.Name = "addressUpdate";
            addressUpdate.Size = new Size(200, 27);
            addressUpdate.TabIndex = 4;
            // 
            // contactUpdate
            // 
            contactUpdate.Location = new Point(223, 6);
            contactUpdate.Name = "contactUpdate";
            contactUpdate.Size = new Size(200, 27);
            contactUpdate.TabIndex = 3;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(18, 114);
            label11.Name = "label11";
            label11.Size = new Size(71, 20);
            label11.TabIndex = 2;
            label11.Text = "Insurance";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(18, 60);
            label10.Name = "label10";
            label10.Size = new Size(62, 20);
            label10.TabIndex = 1;
            label10.Text = "Address";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(13, 9);
            label9.Name = "label9";
            label9.Size = new Size(142, 20);
            label9.TabIndex = 0;
            label9.Text = "Contact Information";
            // 
            // save_record
            // 
            save_record.Location = new Point(405, 484);
            save_record.Margin = new Padding(3, 4, 3, 4);
            save_record.Name = "save_record";
            save_record.Size = new Size(119, 38);
            save_record.TabIndex = 14;
            save_record.Text = "Save";
            save_record.UseVisualStyleBackColor = true;
            save_record.Click += button1_Click;
            // 
            // cancel
            // 
            cancel.Location = new Point(557, 484);
            cancel.Margin = new Padding(3, 4, 3, 4);
            cancel.Name = "cancel";
            cancel.Size = new Size(119, 38);
            cancel.TabIndex = 15;
            cancel.Text = "Cancel";
            cancel.UseVisualStyleBackColor = true;
            cancel.Click += button2_Click;
            // 
            // updatePatientInfo
            // 
            updatePatientInfo.Location = new Point(405, 484);
            updatePatientInfo.Name = "updatePatientInfo";
            updatePatientInfo.Size = new Size(119, 38);
            updatePatientInfo.TabIndex = 16;
            updatePatientInfo.Text = "Update";
            updatePatientInfo.UseVisualStyleBackColor = true;
            updatePatientInfo.Click += updatePatientInfo_Click;
            // 
            // PatientManagementForm
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 562);
            Controls.Add(updatePanel);
            Controls.Add(updatePatientInfo);
            Controls.Add(cancel);
            Controls.Add(panel1);
            Controls.Add(save_record);
            Controls.Add(label1);
            Controls.Add(comboBox1);
            Controls.Add(listBox1);
            Controls.Add(btnViewPatientProfile);
            Controls.Add(btnDeletePatient);
            Controls.Add(btnUpdatePatient);
            Controls.Add(btnAddPatient);
            Margin = new Padding(3, 4, 3, 4);
            Name = "PatientManagementForm";
            Text = "Patient Management";
            Load += PatientManagementForm_Load;
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            updatePanel.ResumeLayout(false);
            updatePanel.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Button btnAddPatient;
        private System.Windows.Forms.Button btnUpdatePatient;
        private System.Windows.Forms.Button btnDeletePatient;
        private System.Windows.Forms.Button btnViewPatientProfile;
        private ListBox listBox1;
        private ComboBox comboBox1;
        private Label label1;
        private Panel panel1;
        private Label label2;
        private TextBox textBox1;
        private Label label3;
        private TextBox textBox2;
        private Label label4;
        private Label label5;
        private DateTimePicker dateTimePicker1;
        private TextBox textBox4;
        private TextBox textBox5;
        private CheckBox checkBox1;
        private Label label6;
        private Label label8;
        private Label label7;
        private Button save_record;
        private Button cancel;
        private RadioButton male;
        private RadioButton Female;
        private Panel updatePanel;
        private Label label9;
        private CheckBox updateInsurance;
        private TextBox addressUpdate;
        private TextBox contactUpdate;
        private Label label11;
        private Label label10;
        private Button updatePatientInfo;
    }
}
