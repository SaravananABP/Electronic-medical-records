package electronic.medical.records.patientDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails,Long> {
    Optional<List<PatientDetails>> findByMobileNo(String mobileNo);
    Optional<List<PatientDetails>> findByUuEmailId(String emailId);
}
