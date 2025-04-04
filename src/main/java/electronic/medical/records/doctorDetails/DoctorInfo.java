package electronic.medical.records.doctorDetails;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class DoctorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id; // Unique ID for the doctor
//    @ManyToOne
//    @JoinColumn(name = "doctor_details", referencedColumnName = "emailId", nullable = false)
//    private UserDetailsInfo emailId;
    private String uuEmailId;

    private String hospital_id;

    private String detailsDomain;
    private int experience;
    private String address;
    private Date joinDate;

    private String location;
    private String mobileNo;
    private String doctorCertificate;
    private String aadharCardNo;
    private String licenseNo;
    private boolean isVerified;
    private String specialization;
    private Gender gender;

//    @ManyToOne
//    @JoinColumn(name = "hospital_id") // Foreign key to hospital table
//    private HospitalInfo hospitalDetails;

    // Enum for Gender
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    // Getters and setters...
}

