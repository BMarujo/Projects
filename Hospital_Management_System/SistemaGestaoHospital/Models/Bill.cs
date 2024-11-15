using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaGestaoHospital.Models
{
    internal class Bill(int id, string Patient, string Doctor, int appointId, string payStatus, DateTime date, decimal totalAmount)
    {
        public int BillID { get; set; } = id;
        public string PatientID { get; set; } = Patient;
        public string DoctorID { get; set; } = Doctor;
        public int AppointmentID { get; set; } = appointId;
        public string PaymentStatus { get; set; } = payStatus;
        public DateTime BillDate { get; set; } = date;
        public decimal TotalAmount { get; set; } = totalAmount;

        public override string ToString()
        {
            // use store procedure to return patient name based on id
            return $"{PatientID}, " + $"{BillDate.ToShortDateString()}, {TotalAmount:C2}";
        }
    }
}
