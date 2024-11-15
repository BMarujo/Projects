using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaGestaoHospital.Models
{
    internal class Prescription(int PrescriptionId, string PatientId, string DoctorId, int AppointmentId, DateTime date, string dosageInstruct, int MedicationId)
    {
        public int PrescriptionID { get; set; } = PrescriptionId;
        public string PatientID { get; set; } = PatientId;
        public string DoctorID { get; set; } = DoctorId;
        public int AppointmentID { get; set; } = AppointmentId;
        public DateTime PrescriptionDate { get; set; } = date; 
        public string DosageInstructions { get; set; } = dosageInstruct;
        public int MedicationID { get; set; } = MedicationId;

        public override string ToString()
        {
            // use store procedure for this ones
            string patName = $"{PatientID}";
            string MedName = $"{DoctorID}";

            return $"{MedName} prescribed to {patName}";
        }
    }
}
