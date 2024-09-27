# Hospital Management System

## Overview

This is a Spring Boot-based Hospital Management System with the following features:
- Appointment management
- Patient admission and management
- Doctor registration and management

The application exposes REST API endpoints to handle hospital operations such as booking an appointment, finding patient and doctor details, and managing records.

**Note**: Login functionality will be added in future updates using Spring Security to provide user authentication and authorization.

## Technologies Used
- Backend: Spring Boot
- Database: PostgreSQL

## How to Run
- Clone the repository.
- Set up the database in PostgreSQL and update the `application.yml` file with the correct credentials.
- Run the application using Maven or your preferred build tool.
- Access the API endpoints via Postman or any other API testing tool.

---

## API Endpoints

### Appointment Management

#### 1. Book an Appointment

- **URL**: `/appointment`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "patient_id": 1,
    "doctor_id": 1,
    "day": 13,
    "month": 9,
    "year": 2024
  }
  ```
- **Response**:
    ```json
    {
        "patient_id": 1,
        "patient_name": "null null",
        "doctor_id": 1,
        "doctor_name": "null null",
        "day": 13,
        "month": 9,
        "year": 2024
    }
    ```
- **Description**: This endpoint allows booking an appointment.

#### 2. Find Appointment by ID
- **URL**: `/appointment/{id}`
- **Method**: `GET`
- **Response**:
    ```json
    {
        "patient_id": 1,
        "patient_name": "John Smith",
        "doctor_id": 1,
        "doctor_name": "Helen Cho",
        "day": 13,
        "month": 9,
        "year": 2024
    }
    ```
- **Description**: This endpoint retrieves an appointment by its ID.

#### 3. Find Appointment by Patient Name
- **URL**: `/appointment/patient-{name}`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "patient_id": 1,
        "patient_name": "John Smith",
        "doctor_id": 1,
        "doctor_name": "Helen Cho",
        "day": 13,
        "month": 9,
        "year": 2024
      }
    ]
    ```
- **Description**: Retrieves appointments associated with a specific patient by their name.

#### 4. Find Appointment by Doctor Name
- **URL**: `/appointment/doctor-{name}`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "patient_id": 1,
        "patient_name": "John Smith",
        "doctor_id": 1,
        "doctor_name": "Helen Cho",
        "day": 13,
        "month": 9,
        "year": 2024
      }
    ]
    ```
- **Description**: Retrieves appointments associated with a specific doctor by their name.

#### 5. Find Appointment by Date
- **URL**: `/appointment/{year}-{month}-{day}`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "patient_id": 1,
        "patient_name": "John Smith",
        "doctor_id": 1,
        "doctor_name": "Helen Cho",
        "day": 13,
        "month": 9,
        "year": 2024
      }
    ]
    ```
- **Description**: Retrieves appointments scheduled for a specific date.

#### 6. Get All Appointments
- **URL**: `/appointment`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "patient_id": 1,
        "patient_name": "John Smith",
        "doctor_id": 1,
        "doctor_name": "Helen Cho",
        "day": 13,
        "month": 9,
        "year": 2024
      }
    ]
    ```
- **Description**: Retrieves all appointments in the system.

#### 7. Delete an Appointment
- **URL**: `/appointment/{id}`
- **Method**: `DELETE`
- **Description**: Deletes an appointment by its ID.


### Patient Management

#### 1. Admit a Patient
- **URL**: `/patient`
- **Method**: `POST`
- **Request Body**:
    ```json
     {
        "firstname": "John",
        "lastname": "Smith",
        "gender": "Male",
        "age": 22
     }
     ```
- **Response**:
    ```json
     {
        "firstname": "John",
        "lastname": "Smith",
        "gender": "Male",
        "age": 22
     }
     ```
- **Description**: This endpoint allows admitting a new patient.

#### 2. Find Patient by ID
- **URL**: `/patient/{id}`
- **Method**: `GET`
- **Response**:
     ```json
     {
        "firstname": "John",
        "lastname": "Smith",
        "gender": "Male",
        "age": 22
     }
     ```
- **Description**: Retrieves a patient's details by their ID.

#### 3. Find Patient by Name
- **URL**: `/patient/search/{name}`
- **Method**: `GET`
- **Response**:
     ```json
     [
       {
         "firstname": "John",
         "lastname": "Smith",
         "gender": "Male",
         "age": 22
       }
     ]
     ```
- **Description**: Retrieves patients by their name.

#### 4. Get All Patients
- **URL**: `/patient`
- **Method**: `GET`
- **Response**:
    ```json
    [
      {
        "firstname": "John",
        "lastname": "Smith",
        "gender": "Male",
        "age": 22
      }
    ]
    ```
- **Description**: Retrieves all patients in the system.

#### 5. Remove a Patient
- **URL**: `/patient/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a patient by their ID.


### Doctor Management

#### 1. Register a Doctor
- **URL**: `/doctor`
- **Method**: `POST`
- **Request Body**:
    ```json
      {
        "firstname": "Helen",
        "lastname": "Cho",
        "specialization": "Cardiologist"
      }
    ```
- **Response**:
    ```json
      {
        "firstname": "Helen",
        "lastname": "Cho",
        "specialization": "Cardiologist"
      }
    ```
- **Description**: This endpoint allows registering a new doctor.

#### 2. Find Doctor by ID
- **URL**: `/doctor/{id}`
- **Method**: `GET`
- **Response**:
    ```json
      {
        "firstname": "Helen",
        "lastname": "Cho",
        "specialization": "Cardiologist"
      }
    ```
- **Description**: Retrieves a doctor's details by their ID.

#### 3. Find Doctor by Name
- **URL**: `/doctor/search/{name}`
- **Method**: `GET`
- **Response**:
    ```json
      [
        {
            "firstname": "Helen",
            "lastname": "Cho",
            "specialization": "Cardiologist"
        }
      ]
    ```
- **Description**: Retrieves doctors by their name.

#### 4. Find Doctor by Specialization
- **URL**: `/doctor/specialization-{specialization}`
- **Method**: `GET`
- **Response**:
    ```json
      [
        {
            "firstname": "Helen",
            "lastname": "Cho",
            "specialization": "Cardiologist"
        }
      ]
    ```
- **Description**: Retrieves doctors by their specialization.

#### 5. Get All Doctors
- **URL**: `/doctor`
- **Method**: `GET`
- **Response**:
    ```json
      [
        {
            "firstname": "Helen",
            "lastname": "Cho",
            "specialization": "Cardiologist"
        }
      ]
    ```
- **Description**: Retrieves all doctors in the system.

#### 6. Remove a Doctor
- **URL**: `/doctor/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a doctor by their ID.

---

## Conclusion
This Hospital Management System provides APIs for handling hospital appointments, patients, and doctors. Each API is designed with simplicity and security in mind.
