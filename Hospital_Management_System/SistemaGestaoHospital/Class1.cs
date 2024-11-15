using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace SistemaGestaoHospital
{
    public class Patient
    {
        public string CitizenCardNumber { get; set; }
        public string Name { get; set; }
        public char Gender { get; set; }
        public DateTime DateOfBirth { get; set; }
        public string ContactInformation { get; set; }
        public string Address { get; set; }
        public bool Insurance { get; set; }

        // Constructor for initializing a new patient object
        public Patient(string citizenCardNumber, string name, char gender, DateTime dateOfBirth, string contactInformation, string address, bool insurance)
        {
            CitizenCardNumber = citizenCardNumber;
            Name = name;
            Gender = gender;
            DateOfBirth = dateOfBirth;
            ContactInformation = contactInformation;
            Address = address;
            Insurance = insurance;
        }
    }
}