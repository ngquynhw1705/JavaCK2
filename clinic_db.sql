CREATE DATABASE IF NOT EXISTS clinic_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE clinic_db;

DROP TABLE IF EXISTS InvoiceDetail;
DROP TABLE IF EXISTS Invoice;
DROP TABLE IF EXISTS PrescriptionDetail;
DROP TABLE IF EXISTS Prescription;
DROP TABLE IF EXISTS Treatment;
DROP TABLE IF EXISTS MedicalRecord;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS Medicine;
DROP TABLE IF EXISTS Service;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Account;

CREATE TABLE Account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100),
    role VARCHAR(30),
    status VARCHAR(30)
);

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    birth_date DATE,
    gender VARCHAR(10),
    phone VARCHAR(20),
    address VARCHAR(255),
    customer_type VARCHAR(30) DEFAULT 'Thường',
    points INT DEFAULT 0,
    account_id INT NULL,
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100),
    specialty VARCHAR(100),
    work_schedule VARCHAR(255),
    patient_count INT DEFAULT 0,
    account_id INT NULL,
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    status VARCHAR(30),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE MedicalRecord (
    record_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_id INT NULL,
    examination_date DATE,
    symptoms TEXT,
    diagnosis TEXT,
    treatment_method TEXT,
    prescription TEXT,
    note TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);

CREATE TABLE Medicine (
    medicine_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    type VARCHAR(50),
    quantity INT,
    minimum_quantity INT DEFAULT 5,
    price DOUBLE,
    expiry_date DATE,
    description TEXT
);

CREATE TABLE Service (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    price DOUBLE,
    duration VARCHAR(50),
    description TEXT
);

CREATE TABLE Treatment (
    treatment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    treatment_name VARCHAR(100),
    start_date DATE,
    end_date DATE,
    initial_condition TEXT,
    result TEXT,
    evaluation TEXT,
    before_image VARCHAR(255),
    after_image VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY AUTO_INCREMENT,
    record_id INT,
    patient_id INT,
    doctor_id INT,
    created_date DATE,
    status VARCHAR(30) DEFAULT 'Chưa cấp thuốc',
    FOREIGN KEY (record_id) REFERENCES MedicalRecord(record_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE PrescriptionDetail (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    prescription_id INT,
    medicine_id INT,
    quantity INT,
    dosage VARCHAR(255),
    FOREIGN KEY (prescription_id) REFERENCES Prescription(prescription_id),
    FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id)
);

CREATE TABLE Invoice (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    invoice_date DATE,
    examination_fee DOUBLE,
    medicine_fee DOUBLE,
    service_fee DOUBLE,
    discount DOUBLE,
    total_amount DOUBLE,
    payment_method VARCHAR(50),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);

CREATE TABLE InvoiceDetail (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    invoice_id INT,
    item_type VARCHAR(30),
    item_name VARCHAR(100),
    quantity INT,
    price DOUBLE,
    total DOUBLE,
    FOREIGN KEY (invoice_id) REFERENCES Invoice(invoice_id)
);

INSERT INTO Account(username,password,full_name,role,status) VALUES
('admin','123','Quản trị viên','ADMIN','ACTIVE'),
('doctor','123','Bác sĩ mẫu','DOCTOR','ACTIVE'),
('reception','123','Nhân viên lễ tân','RECEPTIONIST','ACTIVE'),
('pharma','123','Nhân viên cấp thuốc','PHARMACIST','ACTIVE'),
('customer','123','Khách hàng mẫu','CUSTOMER','ACTIVE');

INSERT INTO Doctor(full_name,phone,email,specialty,work_schedule,patient_count,account_id)
VALUES ('Bác sĩ Nguyễn Văn A','0900000001','doctor@example.com','Mụn, Nám, Laser','Thứ 2 - Thứ 6',0,2);

INSERT INTO Patient(full_name,birth_date,gender,phone,address,customer_type,points,account_id)
VALUES ('Khách hàng mẫu','2005-01-01','Nữ','0900000002','Đà Nẵng','Thường',0,5);

INSERT INTO Medicine(name,type,quantity,minimum_quantity,price,expiry_date,description) VALUES
('Serum trị mụn','Serum',50,5,150000,'2027-12-31','Serum hỗ trợ điều trị mụn'),
('Kem chống nắng','Kem',40,5,200000,'2027-10-10','Bảo vệ da');

INSERT INTO Service(name,price,duration,description) VALUES
('Điều trị mụn',300000,'60 phút','Dịch vụ điều trị mụn cơ bản'),
('Laser nám',800000,'90 phút','Điều trị nám bằng laser');
