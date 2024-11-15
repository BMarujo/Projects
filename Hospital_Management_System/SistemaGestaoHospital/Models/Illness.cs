using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaGestaoHospital.Models
{
    public class Illness(int id, string name, string description, int patientId)
    {
        public int ID { get; set; } = id;
        public string Name { get; set; } = name;
        public string Description { get; set; } = description;
        public int PatientId { get; set; } = patientId;
    }
}
