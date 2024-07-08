package FinalProject.BugTrack.Repository;

import FinalProject.BugTrack.Entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Created the repository for the bugs.
@Repository
public interface BugsRepository extends JpaRepository<Bug, Long> {

//I will use find by resolved for active bugs and resolved bugs.
    List<Bug> findByResolved(boolean resolved);
}

