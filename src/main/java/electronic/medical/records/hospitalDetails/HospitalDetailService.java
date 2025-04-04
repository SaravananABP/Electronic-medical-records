package electronic.medical.records.hospitalDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalDetailService {

    @Autowired
    private HospitalDetailRepository hospitalDetailRepository;

    // Create or Update HospitalDetail
    public HospitalInfo saveHospitalDetail(HospitalInfo hospitalDetail) {
        return hospitalDetailRepository.save(hospitalDetail);
    }

    // Get All HospitalDetails
    public List<HospitalInfo> getAllHospitalDetails() {
        return hospitalDetailRepository.findAll();
    }

    // Get a particular HospitalDetail by id
    public Optional<HospitalInfo> getHospitalDetailById(Long id) {
        return hospitalDetailRepository.findById(id);
    }

    // Delete a particular HospitalDetail by id
    public void deleteHospitalDetail(Long id) {
        hospitalDetailRepository.deleteById(id);
    }
    public Optional<List<HospitalInfo>> getHospitalDetailsByUuEmailId(String emailId) {
        return hospitalDetailRepository.findByUuEmailId(emailId);
    }
}

