package electronic.medical.records.doctorDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorInfoRepository extends JpaRepository<DoctorInfo, Long> {
    Optional<List<DoctorInfo>> findByIsVerified(boolean b);

    @Query("SELECT d FROM DoctorInfo d WHERE d.doctor_id = :id")
    Optional<DoctorInfo> findByDoctorId(@Param("id") Long id);

    Optional<List<DoctorInfo>> findByUuEmailId(String emailId);

    // You can define custom queries here if needed
}
