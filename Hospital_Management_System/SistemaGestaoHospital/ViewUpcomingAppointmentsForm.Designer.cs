namespace SistemaGestaoHospital
{
    partial class ViewUpcomingAppointmentsForm
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
            btnSearch = new Button();
            dataGridView1 = new DataGridView();
            btnCancel = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // lblCitizenCardNumber
            // 
            lblCitizenCardNumber.Location = new Point(50, 50);
            lblCitizenCardNumber.Name = "lblCitizenCardNumber";
            lblCitizenCardNumber.Size = new Size(302, 20);
            lblCitizenCardNumber.TabIndex = 0;
            lblCitizenCardNumber.Text = "Doctor/Patient Citizen Card Number:";
            // 
            // txtCitizenCardNumber
            // 
            txtCitizenCardNumber.Location = new Point(394, 50);
            txtCitizenCardNumber.Name = "txtCitizenCardNumber";
            txtCitizenCardNumber.Size = new Size(200, 31);
            txtCitizenCardNumber.TabIndex = 1;
            // 
            // btnSearch
            // 
            btnSearch.Location = new Point(50, 100);
            btnSearch.Name = "btnSearch";
            btnSearch.Size = new Size(100, 30);
            btnSearch.TabIndex = 2;
            btnSearch.Text = "Search";
            // 
            // dataGridView1
            // 
            dataGridView1.ColumnHeadersHeight = 34;
            dataGridView1.Location = new Point(50, 150);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.RowHeadersWidth = 62;
            dataGridView1.Size = new Size(700, 250);
            dataGridView1.TabIndex = 3;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(168, 100);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(107, 30);
            btnCancel.TabIndex = 4;
            btnCancel.Text = "Go back";
            btnCancel.Click += btnCancel_Click;
            // 
            // ViewUpcomingAppointmentsForm
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnCancel);
            Controls.Add(lblCitizenCardNumber);
            Controls.Add(txtCitizenCardNumber);
            Controls.Add(btnSearch);
            Controls.Add(dataGridView1);
            Name = "ViewUpcomingAppointmentsForm";
            Text = "ViewUpcomingAppointmentsForm";
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Label lblCitizenCardNumber;
        private System.Windows.Forms.TextBox txtCitizenCardNumber;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.DataGridView dataGridView1;
        private Button btnCancel;
    }
}
