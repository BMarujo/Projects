namespace SistemaGestaoHospital
{
    partial class CancelAppointmentForm
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
            btnCancelAppointment = new Button();
            btnCancel = new Button();
            SuspendLayout();
            // 
            // lblAppointmentID
            // 
            lblAppointmentID.Location = new Point(50, 30);
            lblAppointmentID.Name = "lblAppointmentID";
            lblAppointmentID.Size = new Size(200, 31);
            lblAppointmentID.TabIndex = 0;
            lblAppointmentID.Text = "Appointment ID:";
            // 
            // txtAppointmentID
            // 
            txtAppointmentID.Location = new Point(50, 73);
            txtAppointmentID.Name = "txtAppointmentID";
            txtAppointmentID.Size = new Size(200, 31);
            txtAppointmentID.TabIndex = 1;
            // 
            // btnCancelAppointment
            // 
            btnCancelAppointment.Location = new Point(41, 125);
            btnCancelAppointment.Name = "btnCancelAppointment";
            btnCancelAppointment.Size = new Size(209, 36);
            btnCancelAppointment.TabIndex = 2;
            btnCancelAppointment.Text = "Cancel Appointment";
            btnCancelAppointment.Click += btnCancelAppointment_Click;
            // 
            // btnCancel
            // 
            btnCancel.Location = new Point(271, 125);
            btnCancel.Name = "btnCancel";
            btnCancel.Size = new Size(163, 36);
            btnCancel.TabIndex = 3;
            btnCancel.Text = "Go back";
            btnCancel.Click += btnCancel_Click_1;
            // 
            // CancelAppointmentForm
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lblAppointmentID);
            Controls.Add(txtAppointmentID);
            Controls.Add(btnCancelAppointment);
            Controls.Add(btnCancel);
            Name = "CancelAppointmentForm";
            Text = "CancelAppointmentForm";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.Label lblAppointmentID;
        private System.Windows.Forms.TextBox txtAppointmentID;
        private System.Windows.Forms.Button btnCancelAppointment;
        private Button btnCancel;
    }
}
