package electronic.medical.records.doctorDetails;

import jakarta.websocket.server.PathParam;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import electronic.medical.records.hospitalDetails.HospitalInfo;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/gov")
public class GovernmentController {
    @Autowired
    GovernmentService governmentService;
    @GetMapping("/pending/doctor/approval")
    public ResponseEntity<Optional<List<DoctorInfo>>> wantToApprove(){
        Optional<List<DoctorInfo>> pendingApprove=governmentService.getAllPendingApproval();
        return new ResponseEntity<>(pendingApprove, HttpStatus.OK);
    }
    @GetMapping("/doctor/AllApproval")
    public ResponseEntity<Optional<List<DoctorInfo>>> Approved(){
        Optional<List<DoctorInfo>> pendingApprove=governmentService.getAllApproved();
        return new ResponseEntity<>(pendingApprove, HttpStatus.OK);
    }
    @PutMapping("/update/doctor/{id}")
    public ResponseEntity<JSONObject> updateVerification(
            @PathVariable("id") Long id,
            @PathParam("status") boolean status) {

        JSONObject response = new JSONObject();
        boolean result = governmentService.wantToApprove(id, status);

        response.put("status", result ? "success" : "failed");
        response.put("updated_id", id);

        return new ResponseEntity<>(response, result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }



    @GetMapping("/pending/hospital/approval")
    public ResponseEntity<Optional<List<HospitalInfo>>> hospitalWantToApprove(){
        Optional<List<HospitalInfo>> pendingApprove=governmentService.getAllPendingHospitalApproval();
        return new ResponseEntity<>(pendingApprove, HttpStatus.OK);
    }
    @GetMapping("/hospital/AllApproval")
    public ResponseEntity<Optional<List<HospitalInfo>>> allHospitalApproved(){
        Optional<List<HospitalInfo>> pendingApprove=governmentService.getAllHospitalApproved();
        return new ResponseEntity<>(pendingApprove, HttpStatus.OK);
    }
    @PutMapping("/update/hospital/{id}")
    public ResponseEntity<JSONObject> updateHospitalVerification(
            @PathVariable("id") Long id,
            @PathParam("status") boolean status) {

        JSONObject response = new JSONObject();
        boolean result = governmentService.wantToApproveHospital(id, status);

        response.put("status", result ? "success" : "failed");
        response.put("updated_id", id);

        return new ResponseEntity<>(response, result ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
