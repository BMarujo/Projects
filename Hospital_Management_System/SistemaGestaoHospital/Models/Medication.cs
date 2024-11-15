using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaGestaoHospital.Models
{
    internal class Medication(int medicationID, string description, string medicationName, string usageInstructions, string sideEffects, string manufacturer)
    {
        public int MedicationID { get; set; } = medicationID;
        public string Description { get; set; } = description;
        public string MedicationName { get; set; } = medicationName;
        public string UsageInstructions { get; set; } = usageInstructions;
        public string SideEffects { get; set; } = sideEffects;
        public string Manufacturer { get; set; } = manufacturer;

        public override string ToString()
        {
            return $"{MedicationName}";
        }
    }
}
