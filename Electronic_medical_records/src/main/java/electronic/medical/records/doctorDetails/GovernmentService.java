package electronic.medical.records.doctorDetails;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import electronic.medical.records.hospitalDetails.HospitalDetailRepository;
import electronic.medical.records.hospitalDetails.HospitalInfo;

import java.util.List;
import java.util.Optional;
@Service
public class GovernmentService {

    @Autowired
    DoctorInfoRepository doctorInfoRepository;
    @Autowired
    HospitalDetailRepository hospitalDetailRepository;

    public Optional<List<DoctorInfo>> getAllPendingApproval() {
        return doctorInfoRepository.findByIsVerified(false);
    }
    public Optional<List<DoctorInfo>> getAllApproved() {
        return doctorInfoRepository.findByIsVerified(true);
    }
    @Transactional
    public boolean wantToApprove(Long id, boolean status) {
        Optional<DoctorInfo> doctorInfo = doctorInfoRepository.findByDoctorId(id);

        if (doctorInfo.isPresent()) { // Check if value exists
            DoctorInfo doctor = doctorInfo.get();
            doctor.setVerified(status);
            doctorInfoRepository.save(doctor); // Save updated entity
            return true;
        }
        return false;
    }

    public Optional<List<HospitalInfo>> getAllPendingHospitalApproval() {
        return hospitalDetailRepository.findByIsVerified(false);
    }
    public Optional<List<HospitalInfo>> getAllHospitalApproved() {
        return hospitalDetailRepository.findByIsVerified(true);
    }
    @Transactional
    public boolean wantToApproveHospital(Long id, boolean status) {
        Optional<HospitalInfo> doctorInfo = hospitalDetailRepository.findByHospitalId(id);

        if (doctorInfo.isPresent()) { // Check if value exists
            HospitalInfo hospitalInfo = doctorInfo.get();
            hospitalInfo.setVerified(status);
            hospitalDetailRepository.save(hospitalInfo); // Save updated entity
            return true;
        }
        return false;
    }

}
