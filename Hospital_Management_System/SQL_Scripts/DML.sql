INSERT INTO Patient (CitizenCardNumber, Name, Gender, DateOfBirth, ContactInformation, Address, Insurance)
VALUES 
('CCN001', 'John Doe', 'M', '1980-04-25', '555-0101', '123 Main St, Anytown, USA', 0),
('CCN002', 'Jane Smith', 'F', '1992-08-15', '555-0102', '124 Main St, Anytown, USA', 1),
('CCN003', 'Bob Brown', 'M', '1987-03-05', '555-0103', '125 Main St, Anytown, USA', 1),
('CCN004', 'Alice Johnson', 'F', '1978-07-22', '555-0104', '126 Main St, Anytown, USA', 0),
('CCN005', 'Chris Lee', 'M', '1955-12-19', '555-0105', '127 Main St, Anytown, USA', 1),
('CCN006', 'Patricia King', 'F', '1990-01-17', '555-0106', '128 Main St, Anytown, USA', 1),
('CCN007', 'Tim Moore', 'M', '1983-05-11', '555-0107', '129 Main St, Anytown, USA', 1),
('CCN008', 'Laura Taylor', 'F', '1996-09-30', '555-0108', '130 Main St, Anytown, USA', 1),
('CCN009', 'Josh Carter', 'M', '1975-11-06', '555-0109', '131 Main St, Anytown, USA', 1),
('CCN010', 'Samantha Davis', 'F', '1982-02-27', '555-0110', '132 Main St, Anytown, USA', 0),
('CCN011', 'Nick Miller', 'M', '1970-08-14', '555-0111', '133 Main St, Anytown, USA', 1),
('CCN012', 'Nancy White', 'F', '1964-03-30', '555-0112', '134 Main St, Anytown, USA', 0),
('CCN013', 'Derek Wilson', 'M', '1993-06-09', '555-0113', '135 Main St, Anytown, USA', 0),
('CCN014', 'Fiona Green', 'F', '2000-10-05', '555-0114', '136 Main St, Anytown, USA', 0),
('CCN015', 'Oliver Harris', 'M', '1999-12-11', '555-0115', '137 Main St, Anytown, USA', 1);

INSERT INTO Illness (PatientID, IllnessName, Description)
VALUES 
('CCN001', 'Influenza', 'A viral infection that attacks your respiratory system - nose, throat, and lungs. Commonly known as the flu.'),
('CCN001', 'Asthma', 'A condition in which your airways narrow and swell and may produce extra mucus. This can make breathing difficult and trigger coughing, wheezing and shortness of breath.'),
('CCN002', 'Asthma', 'A condition in which your airways narrow and swell and may produce extra mucus. This can make breathing difficult and trigger coughing, wheezing and shortness of breath.'),
('CCN005', 'Diabetes', 'A chronic disease that affects how your body turns food into energy. There are several types of diabetes, including Type 1, Type 2, and gestational diabetes.'),
('CCN005', 'Hypertension', 'Also known as high blood pressure, a condition in which the force of the blood against the artery walls is too high.'),
('CCN002', 'Chickenpox', 'A highly contagious viral infection causing an itchy, blister-like rash on the skin.'),
('CCN006', 'Arthritis', 'A disorder causing inflammation in one or more joints, leading to pain and stiffness that can worsen with age.'),
('CCN007', 'Epilepsy', 'A central nervous system disorder in which brain activity becomes abnormal, causing seizures or periods of unusual behavior, sensations, and sometimes loss of awareness.'),
('CCN008', 'Migraine', 'A neurological condition that can cause multiple symptoms. Frequently characterized by intense, debilitating headaches. Symptoms may include nausea, difficulty speaking, numbness or tingling, and sensitivity to light and sound.'),
('CCN009', 'Coronary Artery Disease', 'A disease caused by the buildup of plaque in the coronary arteries, which supply oxygen-rich blood to the heart muscle.'),
('CCN010', 'Alzheimers Disease', 'A progressive disorder that causes brain cells to waste away and die. The most common cause of dementia is continuous decline in thinking, behavioral and social skills that affects a person''s ability to function independently.'),
('CCN011', 'Dermatitis', 'An inflammation of the skin characterized by itchy, erythematous, vesicular, weeping, and crusting patches. The term eczema is also commonly used to describe this condition.'),
('CCN012', 'Psoriasis', 'A skin disease that causes red, itchy scaly patches, most commonly on the knees, elbows, trunk, and scalp.'),
('CCN013', 'Osteoporosis', 'A bone disease that occurs when the body loses too much bone, makes too little bone, or both, leading to weak and brittle bones.'),
('CCN014', 'Anxiety Disorder', 'A mental health disorder characterized by feelings of worry, anxiety, or fear that are strong enough to interfere with one''s daily activities.');

INSERT INTO Specializations (Specialization, ConsultationCost)
VALUES ('Cardiologist', 80.00),
       ('Dermatologist', 100.00),
       ('Neurologist', 200.00),
	   ('Pediatrician', 70.00),
	   ('Orthopedist', 110.00),
	   ('Oncologist', 85.00),
	   ('Psychiatrist', 60.00),
	   ('Radiologist', 132.00);

INSERT INTO Department (DepartmentName)
VALUES 
('Cardiology'), 
('Neurology'), 
('Pediatrics'), 
('Radiology'),
('Dermatology'),
('Orthopedics'), 
('Oncology'), 
('Psychiatry');

-- Assuming you have enough departments, the DepartmentID should exist before insertion
INSERT INTO Nurse (CitizenCardNumber, Name, Gender, DateOfBirth, ContactInformation, Address, LicenseDetails, ShiftSchedule, DepartmentID)
VALUES 
('CCN020', 'Alice Blue', 'F', '1985-01-15', '555-0201', '140 Oak St, Anytown, USA', 'License 20201', 'Night Shift', 1),
('CCN021', 'Bob Gray', 'M', '1979-02-25', '555-0202', '141 Oak St, Anytown, USA', 'License 20202', 'Day Shift', 1),
('CCN022', 'Charlie Green', 'M', '1983-03-30', '555-0203', '142 Oak St, Anytown, USA', 'License 20203', 'Night Shift', 2),
('CCN023', 'Diana Red', 'F', '1988-04-28', '555-0204', '143 Oak St, Anytown, USA', 'License 20204', 'Day Shift', 2),
('CCN024', 'Ethan Black', 'M', '1980-05-30', '555-0205', '144 Oak St, Anytown, USA', 'License 20205', 'Night Shift', 3),
('CCN025', 'Fiona Violet', 'F', '1991-06-25', '555-0206', '145 Oak St, Anytown, USA', 'License 20206', 'Day Shift', 3),
('CCN026', 'George White', 'M', '1987-07-22', '555-0207', '146 Oak St, Anytown, USA', 'License 20207', 'Night Shift', 3),
('CCN027', 'Heather Yellow', 'F', '1974-08-15', '555-0208', '147 Oak St, Anytown, USA', 'License 20208', 'Day Shift', 3),
('CCN028', 'Ivan Navy', 'M', '1984-09-12', '555-0209', '148 Oak St, Anytown, USA', 'License 20209', 'Night Shift', 5),
('CCN029', 'Judy Magenta', 'F', '1986-10-17', '555-0210', '149 Oak St, Anytown, USA', 'License 20210', 'Day Shift', 5),
('CCN030', 'Kyle Brown', 'M', '1990-11-20', '555-0211', '150 Oak St, Anytown, USA', 'License 20211', 'Night Shift', 5),
('CCN031', 'Linda Orange', 'F', '1995-12-23', '555-0212', '151 Oak St, Anytown, USA', 'License 20212', 'Day Shift', 6),
('CCN032', 'Mason Indigo', 'M', '1978-01-26', '555-0213', '152 Oak St, Anytown, USA', 'License 20213', 'Night Shift', 7),
('CCN033', 'Nora Scarlet', 'F', '1981-02-24', '555-0214', '153 Oak St, Anytown, USA', 'License 20214', 'Day Shift', 7),
('CCN034', 'Oliver Pink', 'M', '1989-03-27', '555-0215', '154 Oak St, Anytown, USA', 'License 20215', 'Night Shift', 8);

INSERT INTO Doctor (CitizenCardNumber, Name, Gender, DateOfBirth, ContactInformation, Address, LicenseDetails, ShiftSchedule, DepartmentID, Specialization)
VALUES 
('D001', 'Jane Smith', 'F', '1975-03-15', '555-0303', '789 Oak St, Anytown, USA', 'License 12345', 'Day shift', 1, 1),
('D002', 'Eric Johnson', 'M', '1980-05-21', '555-0304', '790 Oak St, Anytown, USA', 'License 12346', 'Night shift', 1, 1),
('D003', 'Natalie Port', 'F', '1987-09-09', '555-0305', '791 Oak St, Anytown, USA', 'License 12347', 'Day shift', 2, 3),
('D004', 'Liam Neeson', 'M', '1978-12-06', '555-0306', '792 Oak St, Anytown, USA', 'License 12348', 'Night shift', 2, 3),
('D005', 'Olivia Wilde', 'F', '1985-08-19', '555-0307', '793 Oak St, Anytown, USA', 'License 12349', 'Day shift', 3, 4),
('D006', 'Henry Cavill', 'M', '1991-10-12', '555-0308', '794 Oak St, Anytown, USA', 'License 12350', 'Night shift', 3, 4),
('D007', 'Mia Goth', 'F', '1984-03-30', '555-0309', '795 Oak St, Anytown, USA', 'License 12351', 'Day shift', 4, 2),
('D008', 'Jason Statham', 'M', '1976-07-26', '555-0310', '796 Oak St, Anytown, USA', 'License 12352', 'Night shift', 4, 2),
('D009', 'Zoe Kravitz', 'F', '1990-11-01', '555-0311', '797 Oak St, Anytown, USA', 'License 12353', 'Day shift', 5, 5),
('D010', 'Chris Evans', 'M', '1982-06-13', '555-0312', '798 Oak St, Anytown, USA', 'License 12354', 'Night shift', 5, 5),
('D011', 'Scarlett Johansson', 'F', '1993-04-22', '555-0313', '799 Oak St, Anytown, USA', 'License 12355', 'Day shift', 6, 6),
('D012', 'Robert Downey', 'M', '1979-01-29', '555-0314', '800 Oak St, Anytown, USA', 'License 12356', 'Night shift', 6, 6),
('D013', 'Emma Watson', 'F', '1995-10-15', '555-0315', '801 Oak St, Anytown, USA', 'License 12357', 'Day shift', 7, 7),
('D014', 'Tom Holland', 'M', '1988-07-01', '555-0316', '802 Oak St, Anytown, USA', 'License 12358', 'Night shift', 7, 7),
('D015', 'Gal Gadot', 'F', '1986-04-30', '555-0317', '803 Oak St, Anytown, USA', 'License 12359', 'Day shift', 8, 8);

INSERT INTO Surgeries (SurgeryDate, SurgeryType, PatientID, OperationRoom, DoctorID)
VALUES 
('2023-10-15', 'Heart Bypass', 'CCN001', 'OR1', 'D001'),
('2023-10-16', 'Knee Replacement', 'CCN002', 'OR2', 'D010'),
('2023-10-17', 'Appendectomy', 'CCN003', 'OR3', 'D005'),
('2023-10-18', 'Gallbladder Removal', 'CCN004', 'OR1', 'D007'),
('2023-10-19', 'Cataract Surgery', 'CCN005', 'OR2', 'D009'),
('2023-10-20', 'Tonsillectomy', 'CCN006', 'OR3', 'D005'),
('2023-10-21', 'Coronary Artery Bypass', 'CCN007', 'OR1', 'D001'),
('2023-10-22', 'Hip Replacement', 'CCN008', 'OR2', 'D010'),
('2023-10-23', 'Lumpectomy', 'CCN009', 'OR3', 'D011'),
('2023-10-24', 'Hysterectomy', 'CCN010', 'OR1', 'D006'),
('2023-10-25', 'Spinal Fusion', 'CCN011', 'OR2', 'D009'),
('2023-10-26', 'Brain Surgery', 'CCN012', 'OR3', 'D003'),
('2023-10-27', 'Pacemaker Implantation', 'CCN013', 'OR1', 'D001'),
('2023-10-28', 'Mastectomy', 'CCN014', 'OR2', 'D011'),
('2023-10-29', 'Thyroidectomy', 'CCN015', 'OR3', 'D007');

INSERT INTO Appointment (DoctorID, PatientID, AppointmentDateTime, Reason, Status)
VALUES 
('D001', 'CCN001', '2024-04-01 14:00:00', 'Routine Checkup', 'Scheduled'),
('D002', 'CCN002', '2024-04-02 14:30:00', 'Consultation', 'Scheduled'),
('D003', 'CCN003', '2024-04-03 15:00:00', 'Follow-up', 'Scheduled'),
('D004', 'CCN004', '2024-04-04 15:30:00', 'Annual Physical', 'Scheduled'),
('D005', 'CCN005', '2024-04-05 16:00:00', 'Vaccination', 'Scheduled'),
('D006', 'CCN006', '2024-04-06 16:30:00', 'Health Screening', 'Scheduled'),
('D007', 'CCN007', '2024-04-07 17:00:00', 'Urgent Care Visit', 'Scheduled'),
('D008', 'CCN008', '2024-04-08 17:30:00', 'Prescription Refill', 'Scheduled'),
('D009', 'CCN009', '2024-04-09 18:00:00', 'Specialist Consultation', 'Scheduled'),
('D010', 'CCN010', '2024-04-10 18:30:00', 'Therapy Session', 'Scheduled'),
('D011', 'CCN011', '2024-04-11 19:00:00', 'Diagnostic Testing', 'Scheduled'),
('D012', 'CCN012', '2024-04-12 19:30:00', 'Procedure Preparation', 'Scheduled'),
('D013', 'CCN013', '2024-04-13 20:00:00', 'Post-Operative Check', 'Scheduled'),
('D014', 'CCN014', '2024-04-14 20:30:00', 'Mental Health Assessment', 'Scheduled'),
('D015', 'CCN015', '2024-04-15 21:00:00', 'Routine Checkup', 'Scheduled');

INSERT INTO Bill (PatientID, DoctorID, AppointmentID, PaymentStatus, BillDate, TotalAmount)
VALUES 
('CCN001', 'D001', 1, 'Pending', '2023-11-02', 300.00),
('CCN002', 'D002', 2, 'Paid', '2023-11-03', 150.00),
('CCN003', 'D003', 3, 'Pending', '2023-11-04', 250.00),
('CCN004', 'D004', 4, 'Paid', '2023-11-05', 350.00),
('CCN005', 'D005', 5, 'Pending', '2023-11-06', 400.00),
('CCN006', 'D006', 6, 'Paid', '2023-11-07', 320.00),
('CCN007', 'D007', 7, 'Pending', '2023-11-08', 280.00),
('CCN008', 'D008', 8, 'Paid', '2023-11-09', 220.00),
('CCN009', 'D009', 9, 'Pending', '2023-11-10', 450.00),
('CCN010', 'D010', 10, 'Paid', '2023-11-11', 500.00),
('CCN011', 'D011', 11, 'Pending', '2023-11-12', 360.00),
('CCN012', 'D012', 12, 'Paid', '2023-11-13', 340.00),
('CCN013', 'D013', 13, 'Pending', '2023-11-14', 230.00),
('CCN014', 'D014', 14, 'Paid', '2023-11-15', 150.00),
('CCN015', 'D015', 15, 'Pending', '2023-11-16', 200.00);

INSERT INTO MedicalTest (PatientID, DoctorID, TestType, TestDate, Results)
VALUES 
('CCN001', 'D001', 'Blood Test', '2023-10-20', 'Normal cholesterol levels'),
('CCN002', 'D002', 'X-Ray', '2023-10-21', 'No fractures detected'),
('CCN003', 'D003', 'MRI', '2023-10-22', 'Normal brain function'),
('CCN004', 'D004', 'Ultrasound', '2023-10-23', 'Healthy liver'),
('CCN005', 'D005', 'EKG', '2023-10-24', 'Irregular heartbeat'),
('CCN006', 'D006', 'CT Scan', '2023-10-25', 'Clear lungs'),
('CCN007', 'D007', 'Allergy Test', '2023-10-26', 'Allergic to peanuts'),
('CCN008', 'D008', 'Skin Test', '2023-10-27', 'Positive for dermatitis'),
('CCN009', 'D009', 'Hearing Test', '2023-10-28', 'Slight hearing loss'),
('CCN010', 'D010', 'Vision Test', '2023-10-29', 'Needs prescription glasses'),
('CCN011', 'D011', 'Lung Function Test', '2023-10-30', 'Asthma diagnosis confirmed'),
('CCN012', 'D012', 'Stress Test', '2023-10-31', 'High stress levels detected'),
('CCN013', 'D013', 'Bone Density Scan', '2023-11-01', 'Normal bone density'),
('CCN014', 'D014', 'Thyroid Function Test', '2023-11-02', 'Hyperthyroidism'),
('CCN015', 'D015', 'Cholesterol Test', '2023-11-03', 'Elevated LDL levels');

INSERT INTO MedicalRecords (DoctorID, PatientID, RecordDate, Description)
VALUES 
('D001', 'CCN001', '2023-10-20', 'Patient reported mild chest pain. No symptoms of heart attack.'),
('D002', 'CCN002', '2023-10-21', 'Patient reports improved sleeping patterns.'),
('D003', 'CCN003', '2023-10-22', 'Patient experiencing frequent headaches.'),
('D004', 'CCN004', '2023-10-23', 'Patient diagnosed with Type 2 Diabetes, prescribed metformin.'),
('D005', 'CCN005', '2023-10-24', 'Routine pediatric checkup, vaccinations up to date.'),
('D006', 'CCN006', '2023-10-25', 'Annual health screening, all tests normal.'),
('D007', 'CCN007', '2023-10-26', 'Patient shows signs of recovery from surgery.'),
('D008', 'CCN008', '2023-10-27', 'Consultation for potential cosmetic surgery.'),
('D009', 'CCN009', '2023-10-28', 'Orthopedic consultation, recommended physiotherapy.'),
('D010', 'CCN010', '2023-10-29', 'Patient therapy session notes.'),
('D011', 'CCN011', '2023-10-30', 'Oncology follow-up, no signs of recurrence.'),
('D012', 'CCN012', '2023-10-31', 'Psychiatric evaluation, medication adjusted.'),
('D013', 'CCN013', '2023-11-01', 'Patient recovering well from depression.'),
('D014', 'CCN014', '2023-11-02', 'Diagnosed with arthritis, prescribed NSAIDs.'),
('D015', 'CCN015', '2023-11-03', 'Reviewed cardiac health, EKG performed, normal');

INSERT INTO Medications (Description, MedicationName, UsageInstructions, SideEffects, Manufacturer)
VALUES
('Used to reduce pain and fever.', 'Acetaminophen 500mg', 'Take 1-2 tablets every 4 to 6 hours.', 'Nausea, liver toxicity with excessive use.', 'HealthPharma'),
('Antibiotic used to treat bacterial infections.', 'Amoxicillin 500mg', 'Take one capsule every 8 hours.', 'Diarrhea, allergic reactions.', 'Curex Labs'),
('Lowers cholesterol and reduces risk of heart disease.', 'Atorvastatin 20mg', 'Take one tablet daily.', 'Muscle pain, increased diabetes risk.', 'Global Meds'),
('Anti-inflammatory drug used for pain relief.', 'Ibuprofen 400mg', 'Take 1 tablet every 4 to 6 hours.', 'Stomach ulcers, kidney problems.', 'FastCure Inc.'),
('Used for treating high blood pressure.', 'Lisinopril 10mg', 'Take one tablet daily.', 'Dizziness, persistent cough.', 'BestHealth Pharmaceuticals'),
('Helps control blood sugar levels in diabetics.', 'Metformin 500mg', 'Take one tablet with meals.', 'Gastrointestinal upset, lactic acidosis rare.', 'LifeCare Pharma'),
('Used to treat anxiety and panic disorders.', 'Alprazolam 0.5mg', 'Take one tablet as needed.', 'Drowsiness, dependency risk.', 'Tranquil Solutions'),
('Used to treat depression and anxiety.', 'Sertraline 100mg', 'Take one tablet daily.', 'Insomnia, sexual dysfunction.', 'MindBalance Labs'),
('Used for short-term treatment of insomnia.', 'Zolpidem 10mg', 'Take one tablet at bedtime.', 'Sleepwalking, amnesia.', 'SleepWell Pharma'),
('Antihistamine used to treat allergy symptoms.', 'Cetirizine 10mg', 'Take one tablet daily.', 'Drowsiness, dry mouth.', 'AllergyRelief Inc.');

INSERT INTO Prescriptions (PatientID, DoctorID, AppointmentID, PrescriptionDate, DosageInstructions, MedicationID)
VALUES
('CCN001', 'D001', 1, '2023-11-01', 'Take one tablet daily', 1),
('CCN002', 'D002', 2, '2023-11-02', 'Take one capsule every 8 hours', 2),
('CCN003', 'D003', 3, '2023-11-03', 'Take one tablet daily', 3),
('CCN004', 'D004', 4, '2023-11-04', 'Take 1 tablet every 4 to 6 hours', 4),
('CCN005', 'D005', 5, '2023-11-05', 'Take one tablet daily', 5),
('CCN006', 'D006', 6, '2023-11-06', 'Take one tablet with meals', 6),
('CCN007', 'D007', 7, '2023-11-07', 'Take one tablet as needed', 7),
('CCN008', 'D008', 8, '2023-11-08', 'Take one tablet daily', 8),
('CCN009', 'D009', 9, '2023-11-09', 'Take one tablet at bedtime', 9),
('CCN010', 'D010', 10, '2023-11-10', 'Take one tablet daily', 10);
