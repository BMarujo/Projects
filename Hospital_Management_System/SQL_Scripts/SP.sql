
CREATE PROCEDURE AddPatient
    @CitizenCardNumber VARCHAR(255),
    @Name VARCHAR(255),
    @Gender CHAR(1),
    @DateOfBirth DATE,
    @ContactInformation VARCHAR(255),
    @Address TEXT,
    @Insurance BIT
AS
BEGIN
    INSERT INTO Patient (CitizenCardNumber, Name, Gender, DateOfBirth, ContactInformation, Address, Insurance)
    VALUES (@CitizenCardNumber, @Name, @Gender, @DateOfBirth, @ContactInformation, @Address, @Insurance);
END
GO

CREATE PROCEDURE DeletePatient
    @CitizenCardNumber VARCHAR(255)
AS
BEGIN
    DELETE FROM Patient WHERE CitizenCardNumber = @CitizenCardNumber;
END
GO

CREATE PROCEDURE ScheduleAppointment
    @DoctorID VARCHAR(255),	
    @PatientID VARCHAR(255),
    @AppointmentDateTime DATETIME,
    @Reason TEXT,
    @Status VARCHAR(100)
AS
BEGIN
    INSERT INTO Appointment (DoctorID, PatientID, AppointmentDateTime, Reason, Status)
    VALUES (@DoctorID, @PatientID, @AppointmentDateTime, @Reason, @Status);
END

GO
CREATE PROCEDURE UpdateAppointment
    @AppointmentID INT,
    @NewAppointmentDateTime DATETIME,
    @NewStatus VARCHAR(100)
AS
BEGIN
    -- Update the appointment details in the Appointment table
    UPDATE Appointment
    SET AppointmentDateTime = @NewAppointmentDateTime,
        Status = @NewStatus
    WHERE AppointmentID = @AppointmentID;
END
GO

CREATE PROCEDURE CancelAppointment
    @AppointmentID INT
AS
BEGIN
    -- Delete the appointment from the Appointment table
    DELETE FROM Appointment
    WHERE AppointmentID = @AppointmentID;
END
GO

CREATE PROCEDURE UpdatePatientContact
    @CitizenCardNumber VARCHAR(255),
    @NewContactInformation VARCHAR(255),
	@NewAddress TEXT,
	@NewInsurance BIT
AS
BEGIN
    UPDATE Patient
    SET ContactInformation = @NewContactInformation,
		Address = @NewAddress,
		Insurance = @NewInsurance
    WHERE CitizenCardNumber = @CitizenCardNumber;
END
GO

CREATE PROCEDURE RecordMedicalTest
    @PatientID VARCHAR(255),
    @DoctorID VARCHAR(255),
    @TestType VARCHAR(255),
    @TestDate DATE,
    @Results TEXT
AS
BEGIN
    INSERT INTO MedicalTest (PatientID, DoctorID, TestType, TestDate, Results)
    VALUES (@PatientID, @DoctorID, @TestType, @TestDate, @Results);
END
GO

-- Record treatment outcome
CREATE PROCEDURE RecordTreatment
    @DoctorID VARCHAR(255),
    @PatientID VARCHAR(255),
    @Description TEXT,
    @RecordDate DATE
AS
BEGIN
    INSERT INTO MedicalRecords (DoctorID, PatientID, Description, RecordDate)
    VALUES (@DoctorID, @PatientID, @Description, @RecordDate);
END
GO

CREATE PROCEDURE CompleteSurgery
    @SurgeryDate DATE,
    @PatientID VARCHAR(255),
    @DoctorID VARCHAR(255),
    @SurgeryType VARCHAR(255),
    @OperationRoom VARCHAR(255)
AS
BEGIN
    INSERT INTO Surgeries (SurgeryDate, PatientID, DoctorID, SurgeryType, OperationRoom)
    VALUES (@SurgeryDate, @PatientID, @DoctorID, @SurgeryType, @OperationRoom);
END
GO

CREATE PROCEDURE ProcessPayment
    @BillID INT,
    @PaymentStatus VARCHAR(100)
AS
BEGIN
    UPDATE Bill
    SET PaymentStatus = @PaymentStatus
    WHERE BillID = @BillID;
END
GO
-- Prescribe medication

CREATE PROCEDURE PrescribeMedication
    @PatientID VARCHAR(255),
    @DoctorID VARCHAR(255),
    @AppointmentID INT,
    @MedicationID INT,
    @PrescriptionDate DATE,
    @DosageInstructions TEXT
AS
BEGIN
    INSERT INTO Prescriptions (PatientID, DoctorID, AppointmentID, MedicationID, PrescriptionDate, DosageInstructions)
    VALUES (@PatientID, @DoctorID, @AppointmentID, @MedicationID, @PrescriptionDate, @DosageInstructions);
END
GO

CREATE PROCEDURE GetPatientsByIllness
    @IllnessName VARCHAR(255)
AS
BEGIN
    SELECT 
	p.CitizenCardNumber,
    p.Name,
    p.Gender,
    dbo.GetAge(p.DateOfBirth) AS Age,
    p.ContactInformation,
    p.Address,
    p.Insurance
    FROM Patient p 
	JOIN Illness i ON p.CitizenCardNumber = i.PatientID
    WHERE i.IllnessName = @IllnessName
	ORDER BY p.Name;
END
GO

CREATE PROCEDURE ListAllIllnesses
AS
BEGIN
    -- Selects all illness records
    SELECT DISTINCT IllnessName
    FROM Illness;
END
GO

CREATE PROCEDURE UpdateBillPaymentStatus
    @BillID INT
AS
BEGIN
    -- Update the payment status of the specified bill
    UPDATE Bill
    SET PaymentStatus = 'Paid'
    WHERE BillID = @BillID;
END
GO


CREATE PROCEDURE ListPrescriptionsByPatient
    @PatientID VARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;

    -- Query to list all prescriptions for a specific patient
    SELECT 
        p.PrescriptionID,
        p.PatientID,
        p.DoctorID,
        p.AppointmentID,
        p.PrescriptionDate,
        p.DosageInstructions,
        p.MedicationID,
        m.MedicationName,
        m.Description AS MedicationDescription,
        m.SideEffects
    FROM 
        Prescriptions p
        INNER JOIN Medications m ON p.MedicationID = m.MedicationID
    WHERE 
        p.PatientID = @PatientID
    ORDER BY 
        p.PrescriptionDate DESC;
END
GO

CREATE PROCEDURE GetAppointmentsByCitizenCardNumber
    @CitizenCardNumber VARCHAR(255)
AS
BEGIN
    SELECT 
        AppointmentID,
        DoctorID,
        PatientID,
        AppointmentDateTime,
        Reason,
        Status
    FROM 
        Appointment
    WHERE 
        DoctorID = @CitizenCardNumber OR
        PatientID = @CitizenCardNumber
    ORDER BY 
        AppointmentDateTime;
END
GO
