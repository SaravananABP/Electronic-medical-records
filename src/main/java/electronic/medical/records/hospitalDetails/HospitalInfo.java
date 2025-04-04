package electronic.medical.records.hospitalDetails;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class HospitalInfo {
    @Transient
    public static Enum Department;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospital_id;

    private String uuEmailId;

    @Column(nullable = false)
    private String hospitalName;

    @Column(nullable = false)
    private String hospitalAddress;

    @Column(nullable = false)
    private String hospitalContactNo;

    @Column(nullable = false)
    private String hospitalEmail;

    @Column(nullable = true)
    private String hospitalWebsite;

    @Enumerated(EnumType.STRING)  // To store the enum as a string in the database
    private Department hospitalType;  // Enum type for hospital specialization

    private String emergencyContact;

    @Enumerated(EnumType.STRING)  // Assuming you want to track which department it belongs to
    private Department department;

    // Additional Hospital Details

    @Column(nullable = true)
    private String hospitalDirector;  // Name of the hospital director

    @Column(nullable = true)
    private String hospitalLicenseNo; // Hospital license number

    @Column(nullable = true)
    private int numberOfBeds; // Number of beds in the hospital

    @Column(nullable = true)
    private String hospitalAccreditation; // Hospital accreditation (e.g., ISO certification)

    @Column(nullable = true)
    private String hospitalEmergencyNumber; // Emergency number for the hospital

    @Column(nullable = true)
    private String hospitalFax; // Hospital fax number

    @Column(nullable = true)
    private String hospitalHours; // Working hours for the hospital

    @Column(nullable = true)
    private String hospitalEmergencyServices; // Details about emergency services offered

    private boolean isVerified=false;
//    @OneToMany(mappedBy = "hospitalDetails") // One hospital can have many doctors
//    private DoctorInfo doctors;
    // Enum for Department (could be the same department enum or different, depending on your requirement)
    public enum Department {
        CARDIOLOGY,
        NEUROLOGY,
        PEDIATRICS,
        ORTHOPEDICS,
        DERMATOLOGY,
        GYNECOLOGY,
        GENERAL_MEDICINE,
        SURGERY,
        ENT,
        OPHTHALMOLOGY,
        PSYCHIATRY,
        RADIOLOGY,
        UROLOGY,
        ANESTHESIOLOGY,
        PATHOLOGY,
        EMERGENCY_MEDICINE
    }

    // Constructors, getters, setters, and other methods would be generated automatically by Lombok's @Data annotation.
}

