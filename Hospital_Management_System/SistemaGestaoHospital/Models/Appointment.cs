namespace SistemaGestaoHospital.Models
{
    internal class Appointment(int appointmentId, string doctorID, string patientID, DateTime appointmentDateTime, string reason)
    {
        public int AppointmentID { get; set; } = appointmentId;
        public string DoctorID { get; set; } = doctorID;
        public string PatientID { get; set; } = patientID;
        public DateTime AppointmentDateTime { get; set; } = appointmentDateTime;
        public string Reason { get; set; } = reason;

        public string DisplayText
        {
            get
            {
                if (AppointmentID == 0)
                    return Reason;
                else
                    return $"{AppointmentID}";
            }
        }
        public override string ToString()
        {
            return DisplayText;
        }
    }
}
