-- Drop tables that have foreign keys pointing to them first
IF OBJECT_ID('MedicalTest', 'U') IS NOT NULL
    DROP TABLE MedicalTest;

IF OBJECT_ID('Surgeries', 'U') IS NOT NULL
    DROP TABLE Surgeries;

IF OBJECT_ID('Prescriptions', 'U') IS NOT NULL
    DROP TABLE Prescriptions;

IF OBJECT_ID('MedicalRecords', 'U') IS NOT NULL
    DROP TABLE MedicalRecords;

IF OBJECT_ID('Bill', 'U') IS NOT NULL
    DROP TABLE Bill;

IF OBJECT_ID('Nurse', 'U') IS NOT NULL
    DROP TABLE Nurse;

IF OBJECT_ID('Illness', 'U') IS NOT NULL
    DROP TABLE Illness;

IF OBJECT_ID('Medications', 'U') IS NOT NULL
    DROP TABLE Medications;

IF OBJECT_ID('Appointment', 'U') IS NOT NULL
    DROP TABLE Appointment;

IF OBJECT_ID('Doctor', 'U') IS NOT NULL
    DROP TABLE Doctor;

IF OBJECT_ID('PatientUpdateLog', 'U') IS NOT NULL
    DROP TABLE PatientUpdateLog;

IF OBJECT_ID('Patient', 'U') IS NOT NULL
    DROP TABLE Patient;

IF OBJECT_ID('Department', 'U') IS NOT NULL
    DROP TABLE Department;

IF OBJECT_ID('Specializations', 'U') IS NOT NULL
    DROP TABLE Specializations;

-- Patient table
CREATE TABLE Patient (
    CitizenCardNumber VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255),
    Gender CHAR(1),
    DateOfBirth DATE,
    ContactInformation VARCHAR(255),
    Address TEXT,
    Insurance BIT
);

CREATE TABLE PatientUpdateLog (
    LogID INT IDENTITY(1,1) PRIMARY KEY,
    PatientID VARCHAR(255),
    OldContact VARCHAR(255),
    NewContact VARCHAR(255),
    UpdateDate DATETIME,
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
);

CREATE TABLE Specializations (
	SpecializationID INT PRIMARY KEY IDENTITY(1,1),
    Specialization VARCHAR(255),
    ConsultationCost DECIMAL(10,2)
);

CREATE TABLE Illness (
    IllnessID INT PRIMARY KEY IDENTITY(1,1),
    PatientID VARCHAR(255),
    IllnessName VARCHAR(255),
    Description TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
);

-- Department table
CREATE TABLE Department (
    DepartmentID INT PRIMARY KEY IDENTITY(1,1),
    DepartmentName VARCHAR(255)
);

-- Nurse table
CREATE TABLE Nurse (
    CitizenCardNumber VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255),
    Gender CHAR(1),
    DateOfBirth DATE,
    ContactInformation VARCHAR(255),
    Address TEXT,
    LicenseDetails VARCHAR(255),
    ShiftSchedule TEXT,
    DepartmentID INT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

-- Doctor table
CREATE TABLE Doctor (
    CitizenCardNumber VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255),
    Gender CHAR(1),
    DateOfBirth DATE,
    ContactInformation VARCHAR(255),
    Address TEXT,
    LicenseDetails VARCHAR(255),
    ShiftSchedule TEXT,
    DepartmentID INT NULL,
    Specialization INT,
	FOREIGN KEY (Specialization) REFERENCES Specializations(SpecializationID),
	FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID)
);

-- Surgeries table
CREATE TABLE Surgeries (
    SurgeryDate DATE,
    SurgeryID INT PRIMARY KEY IDENTITY(1,1),
    SurgeryType VARCHAR(255),
    PatientID VARCHAR(255),
    OperationRoom VARCHAR(255),
    DoctorID VARCHAR(255),
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber)
);

-- Appointment table
CREATE TABLE Appointment (
    AppointmentID INT PRIMARY KEY IDENTITY(1,1),
    DoctorID VARCHAR(255),
    PatientID VARCHAR(255),
    AppointmentDateTime DATETIME,
    Reason TEXT,
    Status VARCHAR(100),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber),
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
);

-- Bill table
CREATE TABLE Bill (
    BillID INT PRIMARY KEY IDENTITY(1,1),
    PatientID VARCHAR(255),
    DoctorID VARCHAR(255),
    AppointmentID INT,
    PaymentStatus VARCHAR(100),
    BillDate DATE,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber),
    FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID)
);

-- Medical test table
CREATE TABLE MedicalTest (
    TestID INT PRIMARY KEY IDENTITY(1,1),
    PatientID VARCHAR(255),
    DoctorID VARCHAR(255),
    TestType VARCHAR(255),
    TestDate DATE,
    Results TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber)
);

-- Medical Records table
CREATE TABLE MedicalRecords (
    RecordID INT PRIMARY KEY IDENTITY(1,1),
    DoctorID VARCHAR(255),
    PatientID VARCHAR(255),
    RecordDate DATE,
    Description TEXT,
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber),
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
);

-- Medications table
CREATE TABLE Medications (
    MedicationID INT PRIMARY KEY identity(1,1),
    Description TEXT,
    MedicationName VARCHAR(255),
    UsageInstructions TEXT,
    SideEffects TEXT,
    Manufacturer VARCHAR(255)
);

-- Prescriptions table
CREATE TABLE Prescriptions (
    PrescriptionID INT PRIMARY KEY IDENTITY(1,1),
    PatientID VARCHAR(255),
    DoctorID VARCHAR(255),
    AppointmentID INT,
    PrescriptionDate DATE,
    DosageInstructions TEXT,
    MedicationID INT,
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber),
    FOREIGN KEY (DoctorID) REFERENCES Doctor(CitizenCardNumber),
    FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID),
	FOREIGN KEY (MedicationID) REFERENCES Medications(MedicationID)
);

ALTER TABLE PatientUpdateLog
ADD CONSTRAINT FK_PatientID
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE Illness
ADD CONSTRAINT FK_Illness_Patient
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE Surgeries
ADD CONSTRAINT FK_Surgeries_Patient
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE Appointment
ADD CONSTRAINT FK_Appointment_Patient
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE Bill
ADD CONSTRAINT FK_Bill_Patient
    FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID)
    ON DELETE CASCADE;

ALTER TABLE MedicalTest
ADD CONSTRAINT FK_MedicalTest_Patient
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE MedicalRecords
ADD CONSTRAINT FK_MedicalRecords_Patient
    FOREIGN KEY (PatientID) REFERENCES Patient(CitizenCardNumber)
    ON DELETE CASCADE;

ALTER TABLE Prescriptions
ADD CONSTRAINT FK_Prescriptions_Patient
     FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID)
    ON DELETE CASCADE;