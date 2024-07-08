package FinalProject.BugTrack.Model;

import FinalProject.BugTrack.Entity.Bug;
import FinalProject.BugTrack.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

//We use this model for the request body containing all the necessary fields.
public class BugRequest {
    private String name;
    private String description;
    private User reporter;
    private int severity;
    private ArrayList<Bug> dependencies;

}
