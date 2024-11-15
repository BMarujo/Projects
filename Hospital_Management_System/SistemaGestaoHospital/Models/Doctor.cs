namespace SistemaGestaoHospital.Models
{
    internal class Doctor(string citizenCardNumber, string name, char gender, int? dateOfBirth, string contactInformation,
                      string address, string licenseDetails, string shiftSchedule, int? departmentID, int? specialization)

    {
        public string CitizenCardNumber { get; set; } = citizenCardNumber;
        public string Name { get; set; } = name;
        public char Gender { get; set; } = gender;  
        public int? DateOfBirth { get; set; } = dateOfBirth;
        public string ContactInformation { get; set; } = contactInformation;
        public string Address { get; set; } = address;
        public string LicenseDetails { get; set; } = licenseDetails;    
        public string ShiftSchedule { get; set; } = shiftSchedule;
        public int? DepartmentID { get; set; } = departmentID; // Nullable for cases when there's no department
        public int? Specialization { get; set; } = specialization; // Nullable for cases when there's no specialization

        public override string ToString()
        {
            return $"CitizenCardNumber: {CitizenCardNumber}, Name: {Name}, Gender: {Gender}, " +
                   $"DOB: {DateOfBirth}, Contact Info: {ContactInformation}, " +
                   $"Address: {Address}, License Details: {LicenseDetails}, Shift Schedule: {ShiftSchedule}, " +
                   $"Department ID: {DepartmentID}, Specialization: {Specialization}";
        }
    }
}
