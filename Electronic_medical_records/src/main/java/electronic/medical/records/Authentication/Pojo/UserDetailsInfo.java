package electronic.medical.records.Authentication.Pojo;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "users_info")
@Data
public class UserDetailsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( nullable = false,name = "userName")
    private String userName;

    @Column(unique = true, nullable = false,name = "password")
    private String password;

    @Column(name = "role")
    private String role;

//    @Property(name = "dateOfBirth")
////    private LocalDate DoB;
//    private String DoB;

    @Column( nullable = false,name = "Address")
    private String address;

    @Column(unique = true, nullable = true, name = "mobileNo")
    private Long mobileNo;

    @Column(unique = true, nullable = false,name = "emailId")
    private String emailId;
    private  String DateOfbirth;

    // One UserDetailsInfo can have many PatientDetails
//    @OneToMany(mappedBy = "emailId")
//    private List<DoctorInfo> doctorInfos;

//    @OneToOne(mappedBy = "userInfo",cascade = CascadeType.MERGE, orphanRemoval = true)
//    private PatientDetails patientDetails; // A doctor can have many patients


}
