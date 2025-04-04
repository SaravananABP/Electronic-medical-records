package electronic.medical.records.doctorDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorControllerAPI {

    @Autowired
    private DoctorService doctorService;

    // Create a new doctor
    @PostMapping
    public ResponseEntity<DoctorInfo> createDoctor(@RequestBody DoctorInfo doctor) {
        DoctorInfo createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    // Update an existing doctor
    @PutMapping("/{id}")
    public ResponseEntity<DoctorInfo> updateDoctor(@PathVariable Long id, @RequestBody DoctorInfo doctorDetails) {
        try {
            DoctorInfo updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        try {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("all/record/{emailId}")
    public ResponseEntity<List<DoctorInfo>> getDoctorDetailsByUuEmailId(@PathVariable String emailId) {
        Optional<List<DoctorInfo>> patientDetails = doctorService.getDoctorDetailsByUuEmailId(emailId);
        return patientDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


//    // Get all doctors (optional)
//    @GetMapping
//    public ResponseEntity<List<DoctorInfo>> getAllDoctors() {
//        List<DoctorInfo> doctors = doctorService.getAllDoctors();
//        return new ResponseEntity<>(doctors, HttpStatus.OK);
//    }
}

