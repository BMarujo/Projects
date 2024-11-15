### Entidades e Atributos:

1. **Pacientes:**
   - PatientID (PK)
   - Name
   - DateOfBirth
   - Gender
   - ContactInformation
   - MedicalHistory
   - InsuranceDetails

2. **Médicos:**
   - DoctorID (PK)
   - Name
   - Specialization
   - ContactInformation
   - Schedule
   - Qualifications
   - LicenseDetails

3. **Consultas:**
   - AppointmentID (PK)
   - DoctorID (FK)
   - PatientID (FK)
   - AppointmentDateTime
   - Reason
   - Status (Scheduled, Confirmed, Canceled, Completed)

4. **Prescrições:**
   - PrescriptionID (PK)
   - AppointmentID (FK)
   - DoctorID (FK)
   - PatientID (FK)
   - PrescriptionDate
   - Medications
   - DosageInstructions

5. **Exames Médicos:**
   - TestID (PK)
   - PatientID (FK)
   - DoctorID (FK)
   - TestType
   - TestDate
   - Results
   - Remarks

6. **Faturamento:**
   - BillID (PK)
   - PatientID (FK)
   - DoctorID (FK)
   - AppointmentID (FK)
   - BillDate
   - TotalAmount
   - PaymentStatus (Paid, Unpaid)

7. **Registros Médicos:**
   - RecordID (PK)
   - PatientID (FK)
   - DoctorID (FK)
   - RecordDate
   - RecordType (Consultation Note, Progress Note, Lab Report, etc.)
   - Description
   - AttachedFiles

8. **Departamentos:**
   - DepartmentID (PK)
   - DepartmentName
   - HeadDoctorID (FK)
   - Description

9. **Enfermeiros:**
   - NurseID (PK)
   - Name
   - DepartmentID (FK)
   - ContactInformation
   - ShiftSchedule

10. **Medicamentos:**
    - MedicationID (PK)
    - MedicationName
    - Description
    - UsageInstructions
    - SideEffects
    - Manufacturer

### Relacionamentos:

1. **Paciente - Consulta (N:1)**
   - Um paciente pode ter várias consultas, mas uma consulta é feita por um único paciente. (Obrigatoriedade: Obrigatório para a consulta, opcional para o paciente)
   
2. **Médico - Consulta (N:1)**
   - Um médico pode realizar várias consultas, mas cada consulta é feita por apenas um médico. (Obrigatoriedade: Obrigatório para a consulta, opcional para o médico)
   
3. **Paciente - Prescrição (N:1)**
   - Um paciente pode receber várias prescrições, mas cada prescrição é feita para um único paciente. (Obrigatoriedade: Obrigatório para a prescrição, opcional para o paciente)
   
4. **Médico - Prescrição (N:1)**
   - Um médico pode fazer várias prescrições, mas cada prescrição é feita por apenas um médico. (Obrigatoriedade: Obrigatório para a prescrição, opcional para o médico)
   
5. **Paciente - Exame Médico (N:1)**
   - Um paciente pode realizar vários exames médicos, mas cada exame é feito para um único paciente. (Obrigatoriedade: Obrigatório para o exame médico, opcional para o paciente)
   
6. **Médico - Exame Médico (N:1)**
   - Um médico pode solicitar vários exames médicos, mas cada exame é solicitado por apenas um médico. (Obrigatoriedade: Obrigatório para o exame médico, opcional para o médico)
   
7. **Paciente - Faturamento (N:1)**
   - Um paciente pode ter várias faturas associadas a ele, mas cada fatura é gerada para um único paciente. (Obrigatoriedade: Obrigatório para a fatura, opcional para o paciente)
   
8. **Médico - Faturamento (N:1)**
   - Um médico pode estar associado a várias faturas, mas cada fatura é relacionada a apenas um médico. (Obrigatoriedade: Obrigatório para a fatura, opcional para o médico)
   
9. **Paciente - Registro Médico (N:1)**
   - Um paciente pode ter vários registros médicos, mas cada registro médico é associado a um único paciente. (Obrigatoriedade: Obrigatório para o registro médico, opcional para o paciente)
   
10. **Médico - Registro Médico (N:1)**
    - Um médico pode estar associado a vários registros médicos, mas cada registro médico é feito por apenas um médico. (Obrigatoriedade: Obrigatório para o registro médico, opcional para o médico)
   
11. **Departamento - Médico (1:N)**
    - Um departamento pode ter vários médicos, mas cada médico pertence a apenas um departamento. (Obrigatoriedade: Obrigatório para o médico, opcional para o departamento)
   
12. **Departamento - Enfermeiro (1:N)**
    - Um departamento pode ter vários enfermeiros, mas cada enfermeiro pertence a apenas um departamento. (Obrigatoriedade: Obrigatório para o enfermeiro, opcional para o departamento)
   
13. **Medicamento - Prescrição (N:M)**
    - Um medicamento pode estar presente em várias prescrições, e uma prescrição pode incluir vários medicamentos. (Obrigatoriedade: Opcional tanto para o medicamento quanto para a prescrição)
