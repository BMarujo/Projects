CREATE TRIGGER LogPatientUpdates
ON Patient
AFTER UPDATE
AS
BEGIN
    IF UPDATE(ContactInformation)
    BEGIN
        INSERT INTO PatientUpdateLog(PatientID, OldContact, NewContact, UpdateDate)
        SELECT i.CitizenCardNumber, d.ContactInformation, i.ContactInformation, GETDATE()
        FROM inserted i
        JOIN deleted d ON i.CitizenCardNumber = d.CitizenCardNumber;
    END
END;
GO

CREATE TRIGGER CheckAppointmentConflict
ON Appointment
INSTEAD OF INSERT
AS
BEGIN
    IF EXISTS (
        SELECT 1 FROM Appointment 
        WHERE DoctorID IN (SELECT DoctorID FROM inserted) 
        AND AppointmentDateTime IN (SELECT AppointmentDateTime FROM inserted)
    )
    BEGIN
        RAISERROR ('This doctor has another appointment at the same time', 16, 1);
    END
    ELSE
    BEGIN
        INSERT INTO Appointment (AppointmentDateTime, DoctorID, PatientID, Reason, Status)
        SELECT AppointmentDateTime, DoctorID, PatientID, Reason, Status FROM inserted;
    END
END;
GO

CREATE TRIGGER AutoGenerateBill
ON Appointment
AFTER INSERT
AS
BEGIN
    -- Assuming there's a way to retrieve Specialization directly from the Doctor table
    DECLARE @Fee DECIMAL(10,2);
    DECLARE @Specialization INT;

    SELECT @Specialization = d.Specialization
    FROM Doctor d
    JOIN inserted i ON i.DoctorID = d.CitizenCardNumber;  -- Adjust the join if necessary based on your schema

    -- Calculate the fee using the function
    SELECT @Fee = dbo.CalculateConsultationFee(i.PatientID, @Specialization)
    FROM inserted i;

    INSERT INTO Bill(PatientID, DoctorID, AppointmentID, PaymentStatus, BillDate, TotalAmount)
    SELECT PatientID, DoctorID, AppointmentID, 'Pending', GETDATE(), @Fee
    FROM inserted;
END;
GO