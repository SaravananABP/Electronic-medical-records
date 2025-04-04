package electronic.medical.records.hospitalDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalDetailController {

    @Autowired
    private HospitalDetailService hospitalDetailService;

    // Create or Update a HospitalDetail
    @PostMapping("/create")
    public ResponseEntity<HospitalInfo> createOrUpdateHospital(@RequestBody HospitalInfo hospitalDetail) {
        HospitalInfo savedHospitalDetail = hospitalDetailService.saveHospitalDetail(hospitalDetail);
        return new ResponseEntity<>(savedHospitalDetail, HttpStatus.CREATED);
    }

    // Get all HospitalDetails
    @GetMapping("/getAll")
    public ResponseEntity<List<HospitalInfo>> getAllHospitals() {
        List<HospitalInfo> hospitalDetails = hospitalDetailService.getAllHospitalDetails();
        return new ResponseEntity<>(hospitalDetails, HttpStatus.OK);
    }

    // Get a particular HospitalDetail by ID
    @GetMapping("getDetails/{id}")
    public ResponseEntity<HospitalInfo> getHospitalById(@PathVariable Long id) {
        Optional<HospitalInfo> hospitalDetail = hospitalDetailService.getHospitalDetailById(id);
        if (hospitalDetail.isPresent()) {
            return new ResponseEntity<>(hospitalDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a HospitalDetail by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteHospitalById(@PathVariable Long id) {
        Optional<HospitalInfo> hospitalDetail = hospitalDetailService.getHospitalDetailById(id);
        if (hospitalDetail.isPresent()) {
            hospitalDetailService.deleteHospitalDetail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAllDepartments")
    public Enum getAllDepartments(){
        return HospitalInfo.Department;
    }
    @GetMapping("all/record/{emailId}")
    public ResponseEntity<List<HospitalInfo>> getHospitalDetailsByUuEmailId(@PathVariable String emailId) {
        Optional<List<HospitalInfo>> patientDetails = hospitalDetailService.getHospitalDetailsByUuEmailId(emailId);
        return patientDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

