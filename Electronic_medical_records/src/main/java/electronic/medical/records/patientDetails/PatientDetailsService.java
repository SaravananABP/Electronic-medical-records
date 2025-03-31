package electronic.medical.records.patientDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import electronic.medical.records.Authentication.Repository.UserDetailsRepo;
import electronic.medical.records.service.TimeService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsService {
    @Autowired
    TimeService timeService;

    @Autowired
    UserDetailsRepo userDetailsRepo;
    @Autowired
    private PatientDetailsRepository patientDetailsRepository;

    @Autowired
    private FileUploadService fileUploadService;

    // Save PatientDetails with encrypted file content
//    public PatientDetails savePatientDetails(PatientDetails patientDetails, MultipartFile file) throws IOException, Exception {
//        if (file != null && !file.isEmpty()) {
//            // Encrypt and store the file content
//            byte[] encryptedFileContent = fileUploadService.storeEncryptedFile(file);
//            patientDetails.setFileContent(encryptedFileContent); // Store the encrypted file content
//        }
//
//        // Save the patient details in the database
//        return patientDetailsRepository.save(patientDetails);
//    }

    public List<PatientDetails> getAllPatientDetails() {
        return patientDetailsRepository.findAll();
    }

    public Optional<List<PatientDetails>> getPatientDetailsByMobile(String mobileNo) {
        return patientDetailsRepository.findByMobileNo(mobileNo);
    }
    public Optional<List<PatientDetails>> getPatientDetailsByUuEmailId(String emailId) {
        return patientDetailsRepository.findByUuEmailId(emailId);
    }

    @Transactional
    public PatientDetails createPatientDetails(PatientDetails patientDetails) {
//        if (patientDetails.getUserInfo() != null && patientDetails.getUserInfo().getEmailId() != null) {
//            UserDetailsInfo existingUser = userDetailsRepo.findByEmailId(patientDetails.getUserInfo().getEmailId());
//
//            if (existingUser == null) {
//                // Handle the case where the user doesn't exist, for example:
//                // throw an exception or save the UserDetailsInfo first
//                throw new RuntimeException("User not found in the system.");
//            } else {
//                patientDetails.setUserInfo(existingUser);
//            }
//        }
        patientDetails.setCreatedAt(timeService.getCurrentTimeInIndia());
        patientDetails.setVisitDate(timeService.getCurrentTimeInIndia());
        patientDetails.setUpdatedAt(timeService.getCurrentTimeInIndia());
        System.out.println(patientDetails.getCreatedAt());
        return patientDetailsRepository.save(patientDetails);
    }

    @Transactional
    public PatientDetails updatePatientDetails(Long id, PatientDetails patientDetails) {

        if (patientDetailsRepository.existsById(id)) {
            patientDetails.setId(id);
            patientDetails.setUpdatedAt(timeService.getCurrentTimeInIndia());
            return patientDetailsRepository.save(patientDetails);
        }
        return null; // Or throw an exception
    }

    public void deletePatientDetails(Long id) {
        patientDetailsRepository.deleteById(id);
    }

    // Other service methods...
}

