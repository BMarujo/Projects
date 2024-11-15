-- Useful for queries filtering patients by age / date of birth and Name
CREATE INDEX idx_patient_name ON Patient(Name);
CREATE INDEX idx_patient_dateofbirth ON Patient(DateOfBirth);

-- Facilitates quick lookups of illnesses associated with specific patients
CREATE INDEX idx_illness_patientid ON Illness(PatientID);

-- Helps in quickly finding all nurses in a specific department
CREATE INDEX idx_nurse_departmentid ON Nurse(DepartmentID);

-- Useful for queries involving doctors in specific departments
CREATE INDEX idx_doctor_departmentid ON Doctor(DepartmentID);

-- Enhances performance of queries involving surgeries specific to a doctor or patient
CREATE INDEX idx_surgeries_patientid ON Surgeries(PatientID);
CREATE INDEX idx_surgeries_doctorid ON Surgeries(DoctorID);

-- Helps in fetching appointments by doctor, patient, or date
CREATE INDEX idx_appointment_doctorid ON Appointment(DoctorID);
CREATE INDEX idx_appointment_patientid ON Appointment(PatientID);
CREATE INDEX idx_appointment_datetime ON Appointment(AppointmentDateTime);

-- Useful for retrieving billing information by patient, doctor, or specific appointments
CREATE INDEX idx_bill_patientid ON Bill(PatientID);
CREATE INDEX idx_bill_doctorid ON Bill(DoctorID);
CREATE INDEX idx_bill_appointmentid ON Bill(AppointmentID);
CREATE INDEX idx_bill_paymentstatus ON Bill(PaymentStatus);

-- Facilitates faster retrieval of test results related to specific doctors or patients
CREATE INDEX idx_medicaltest_patientid ON MedicalTest(PatientID);
CREATE INDEX idx_medicaltest_doctorid ON MedicalTest(DoctorID);

-- Assists in quickly locating prescriptions tied to specific appointments, medications, doctors, or patients
CREATE INDEX idx_prescriptions_patientid ON Prescriptions(PatientID);
CREATE INDEX idx_prescriptions_doctorid ON Prescriptions(DoctorID);
CREATE INDEX idx_prescriptions_appointmentid ON Prescriptions(AppointmentID);
CREATE INDEX idx_prescriptions_medicationid ON Prescriptions(MedicationID);