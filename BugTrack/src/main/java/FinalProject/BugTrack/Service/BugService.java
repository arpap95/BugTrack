package FinalProject.BugTrack.Service;

import FinalProject.BugTrack.Entity.Bug;
import FinalProject.BugTrack.Entity.BugDependencies;
import FinalProject.BugTrack.Entity.User;
import FinalProject.BugTrack.Repository.BugsRepository;
import FinalProject.BugTrack.Repository.UserRepository;
import FinalProject.BugTrack.Repository.BugDependenciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Creating the service of the application.
@Service
@RequiredArgsConstructor


public class BugService {
//Creating the repository objects.
    private final BugsRepository bugsRepository;
    private final UserRepository userRepository;
    private final BugDependenciesRepository bugDependenciesRepository;

    public List<Bug> showResolvedBugs() {
        return bugsRepository.findByResolved(true);
    }

    public List<Bug> showActiveBugs() {
        return bugsRepository.findByResolved(false);
    }

    public List<Bug> showAllBugs() {
        return bugsRepository.findAll();
    }

    public String addNewBug(String bugName, String bugDescription, User reporter, int bugSeverity, ArrayList<Bug> dependencies) {
        //Creating a new bug.
        Bug newBug = new Bug();
        //Adding the values into the new bug.
        newBug.setName(bugName);
        newBug.setDescription(bugDescription);
        newBug.setReporter(reporter);
        newBug.setSeverity(bugSeverity);
        bugsRepository.save(newBug);

        //Adding the dependencies into the database.
        for (Bug dependency : dependencies) {
            BugDependencies newBugDependency = new BugDependencies();
            newBugDependency.setDependsOn(dependency);
            newBugDependency.setBug(newBug);
            bugDependenciesRepository.save(newBugDependency);
        }

        return "Added Successfully";
    }

    public String addUser(String username) {
        User newUser = new User();
        newUser.setUsername(username);
        userRepository.save(newUser);

        return "Added successfully";

    }

    public String updateBug(Long bugId, String bugName, String bugDescription, int bugSeverity) {
        //Finding the bug by its ID if it exists.
        Bug editedBug = bugsRepository.findById(bugId).orElse(null);
        if (editedBug == null) {
            return "Bug Does Not Exist";
        } else {
            //Setting the new values.
            editedBug.setName(bugName);
            editedBug.setDescription(bugDescription);
            editedBug.setSeverity(bugSeverity);

            bugsRepository.save(editedBug);
            return "Undated Successfully";
        }

    }

    public String resolveBug(Long bugId) {
        //Finding the resolved bug by its ID if it exists.
        Bug resolvedBug = bugsRepository.findById(bugId).orElse(null);
        List<BugDependencies> bugDependencies = bugDependenciesRepository.findAllByBugId(bugId);

        String dependsOnBugsMessage = "Cannot resolve bug because depends on: ";

        //Check if the bug exist.
        if (resolvedBug == null) {
            return "Bug Does Not Exist";
            //Check if the bug depends on other bugs and if it does, print the bugs that depends on.
        }else if (!bugDependencies.isEmpty()) {
            for(BugDependencies dependsOnBug: bugDependencies){
                dependsOnBugsMessage += dependsOnBug.getDependsOn().getName() + " ";
            }
            return dependsOnBugsMessage.trim();
        } else {
            //Setting resolved value true.
            resolvedBug.setResolved(true);
            bugDependenciesRepository.deleteByDependsOn(resolvedBug);
        }

        bugsRepository.save(resolvedBug);
        return "Bug Resolved";
    }


}
