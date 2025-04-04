package electronic.medical.records.doctorDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorInfoRepository doctorRepository;

    // Create a new Doctor
    public DoctorInfo createDoctor(DoctorInfo doctor) {
        return doctorRepository.save(doctor);
    }

    // Update an existing Doctor
    public DoctorInfo updateDoctor(Long id, DoctorInfo doctorDetails) {
        Optional<DoctorInfo> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            DoctorInfo existingDoctor = doctorOptional.get();
//            existingDoctor.setEmailId(doctorDetails.getEmailId());
            existingDoctor.setDetailsDomain(doctorDetails.getDetailsDomain());
            existingDoctor.setExperience(doctorDetails.getExperience());
            existingDoctor.setAddress(doctorDetails.getAddress());
            existingDoctor.setJoinDate(doctorDetails.getJoinDate());
            existingDoctor.setLocation(doctorDetails.getLocation());
            existingDoctor.setMobileNo(doctorDetails.getMobileNo());
            existingDoctor.setDoctorCertificate(doctorDetails.getDoctorCertificate());
            existingDoctor.setAadharCardNo(doctorDetails.getAadharCardNo());
            existingDoctor.setLicenseNo(doctorDetails.getLicenseNo());
            existingDoctor.setVerified(doctorDetails.isVerified());
            existingDoctor.setSpecialization(doctorDetails.getSpecialization());
            existingDoctor.setGender(doctorDetails.getGender());
            return doctorRepository.save(existingDoctor);
        } else {
            throw new RuntimeException("Doctor not found with id " + id);
        }
    }

    // Delete a Doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public Optional<List<DoctorInfo>> getDoctorDetailsByUuEmailId(String emailId) {
        return doctorRepository.findByUuEmailId(emailId);
    }
}

