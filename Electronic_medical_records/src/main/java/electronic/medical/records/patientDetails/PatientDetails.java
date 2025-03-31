package electronic.medical.records.patientDetails;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany
//    @JoinColumn(name = "doctor_details", referencedColumnName = "emailId", nullable = false)
//    private UserDetailsInfo userInfo;
//

//
//    private String doctorName;
    private String mobileNo;

    private String uuEmailId;

    private String nextVisitDate;
    private String dischargeDate;
    private Date visitDate;
    private Date createdAt;
    private Date updatedAt;
    private String problem;
    private String report;
    private String criticalLevel;
    private String remarks;

    private String problemPercentage; // Low, Medium, High
//    @Lob
//    private byte[] fileContent; // Store the encrypted file content as bytes
    private String fileType; // Type of file (PDF, Image, etc.)
    private String location; // Location of the hospital or clinic

    // Additional columns for patient history and other info
    private String patientHistory; // History of why the patient came to the hospital
    private String allergies; // Any known allergies
    private String medications; // Medications prescribed to the patient
    private String emergencyContact; // Emergency contact number
    private String previousVisitDetails; // Any previous visits or treatments



}

