using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaGestaoHospital.Models
{
    public class Patient
    {
        public string CitizenCardNumber { get; set; }
        public string Name { get; set; }
        public char Gender { get; set; }
        public int Age { get; set; }
        public string ContactInformation { get; set; }
        public string Address { get; set; }
        public bool Insurance { get; set; } 

        public Patient(string citizenCardNumber, string name, string gender, int age, string contactInformation, string address, bool insurance)
        {
            CitizenCardNumber = citizenCardNumber;
            Name = name;
            Gender = ConvertToChar(gender);
            Age = age;
            ContactInformation = contactInformation;
            Address = address;
            Insurance = insurance;
        }
        public override string ToString()
        {
            return $"{Name} - {CitizenCardNumber}";
        }

        private char ConvertToChar(string input)
        {
            if (!string.IsNullOrEmpty(input) && input.Length == 1)
            {
                return input[0];
            }
            else
            {
                throw new ArgumentException("Input is not a valid single character string.");
            }
        }
    }
}
