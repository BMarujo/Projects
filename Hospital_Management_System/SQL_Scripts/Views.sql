CREATE VIEW ViewPatientDetails
AS
SELECT p.CitizenCardNumber, p.Name, p.Gender, dbo.GetAge(p.DateOfBirth) AS Age,
       p.ContactInformation, p.Address, p.Insurance
FROM Patient p;
GO

CREATE VIEW ViewPatientIllnessDetails
AS
SELECT 
    p.CitizenCardNumber, p.Name, p.Gender, dbo.GetAge(p.DateOfBirth) AS Age,
    p.ContactInformation, p.Address, p.Insurance,
    i.IllnessName, i.Description AS IllnessDescription
FROM 
    Patient p
JOIN 
    Illness i ON p.CitizenCardNumber = i.PatientID;
GO

-- To easily view upcoming appointments
CREATE VIEW vw_UpcomingAppointments
AS
SELECT a.AppointmentDateTime, a.Reason, p.Name AS PatientName, d.Name AS DoctorName
FROM Appointment a
JOIN Patient p ON a.PatientID = p.CitizenCardNumber
JOIN Doctor d ON a.DoctorID = d.CitizenCardNumber
WHERE a.AppointmentDateTime > GETDATE();
GO

CREATE VIEW ViewUnpaidBills
AS
SELECT
    b.BillID,
    p.CitizenCardNumber AS PatientID,
    d.CitizenCardNumber AS DoctorID,
    b.AppointmentID,         
    b.PaymentStatus,
    b.TotalAmount,
    b.BillDate
FROM
    Bill b
JOIN
    Patient p ON b.PatientID = p.CitizenCardNumber
JOIN
    Doctor d ON b.DoctorID = d.CitizenCardNumber
WHERE
    b.PaymentStatus = 'Unpaid' OR b.PaymentStatus = 'Pending';
GO