package FinalProject.BugTrack.Controller;


import FinalProject.BugTrack.Service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Creating the controller.
@RestController
@RequestMapping("/user")
public class UserController {

    //Adding the service.
    @Autowired
    private BugService bugService;

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam String userName) {
        return ResponseEntity.ok(bugService.addUser(userName));
    }
}
