package electronic.medical.records.patientDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientDetailsController {

    @Autowired
    private PatientDetailsService patientDetailsService;

    @GetMapping
    public List<PatientDetails> getAllPatientDetails() {
        return patientDetailsService.getAllPatientDetails();
    }

    @GetMapping("/{mobileNo}")
    public ResponseEntity<List<PatientDetails>> getPatientDetailsById(@PathVariable String mobileNo) {
        Optional<List<PatientDetails>> patientDetails = patientDetailsService.getPatientDetailsByMobile(mobileNo);
        return patientDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PatientDetails> createPatientDetails(@RequestBody PatientDetails patientDetails) {
        PatientDetails createdPatientDetails = patientDetailsService.createPatientDetails(patientDetails);
        return new ResponseEntity<>(createdPatientDetails, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDetails> updatePatientDetails(@PathVariable Long id, @RequestBody PatientDetails patientDetails) {
        PatientDetails updatedPatientDetails = patientDetailsService.updatePatientDetails(id, patientDetails);
        return updatedPatientDetails != null
                ? ResponseEntity.ok(updatedPatientDetails)
                : ResponseEntity.notFound().build();
    }
    @GetMapping("all/record/{emailId}")
    public ResponseEntity<List<PatientDetails>> getPatientDetailsByUuEmailId(@PathVariable String emailId) {
        Optional<List<PatientDetails>> patientDetails = patientDetailsService.getPatientDetailsByUuEmailId(emailId);
        return patientDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePatientDetails(@PathVariable Long id) {
//        patientDetailsService.deletePatientDetails(id);
//        return ResponseEntity.noContent().build();
//    }
}
