package electronic.medical.records.hospitalDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalDetailRepository extends JpaRepository<HospitalInfo, Long> {
    // You can add custom query methods if needed, like:
    Optional<HospitalInfo> findByHospitalName(String hospitalName);
    Optional<List<HospitalInfo>> findByIsVerified(boolean b);
    @Query("SELECT d FROM DoctorInfo d WHERE d.hospital_id = :id")
    Optional<HospitalInfo> findByHospitalId(@Param("id") Long id);
    Optional<List<HospitalInfo>> findByUuEmailId(String emailId);

}
