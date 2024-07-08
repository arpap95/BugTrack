package FinalProject.BugTrack.Controller;

import FinalProject.BugTrack.Entity.Bug;
import FinalProject.BugTrack.Entity.User;
import FinalProject.BugTrack.Model.BugRequest;
import FinalProject.BugTrack.Service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Creating the controller.
@RestController
@RequestMapping("/bug")
public class BugsController {
    //Adding the service.
    @Autowired
    private BugService bugService;

    @GetMapping("/resolved-bugs")
    public ResponseEntity<List<Bug>> getResolvedBugs() {
        return ResponseEntity.ok(bugService.showResolvedBugs());
    }

    @GetMapping("/active-bugs")
    public ResponseEntity<List<Bug>> getActiveBugs() {
        return ResponseEntity.ok(bugService.showActiveBugs());
    }

    @GetMapping("/all-bugs")
    public ResponseEntity<List<Bug>> getAllBugs() {
        return ResponseEntity.ok(bugService.showAllBugs());
    }

    //Using the bug request for the response body.
    @PostMapping("/add")
    public ResponseEntity<String> addNewBug(@RequestBody BugRequest bugRequest) {
        String name = bugRequest.getName();
        String description = bugRequest.getDescription();
        User reporter = bugRequest.getReporter();
        int severity = bugRequest.getSeverity();
        ArrayList<Bug> dependencies = bugRequest.getDependencies();

        return ResponseEntity.ok(bugService.addNewBug(name, description, reporter, severity, dependencies));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBug(@PathVariable Long id, @RequestParam String name,@RequestParam String description,@RequestParam int severity) {

       return ResponseEntity.ok(bugService.updateBug(id, name, description,severity));
    }
    @PutMapping("/resolve/{id}")
    public ResponseEntity<String> resolveBug(@PathVariable Long id) {
        return ResponseEntity.ok(bugService.resolveBug(id));
    }


}




