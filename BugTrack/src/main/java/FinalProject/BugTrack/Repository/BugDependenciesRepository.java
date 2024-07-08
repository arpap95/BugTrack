package FinalProject.BugTrack.Repository;

import FinalProject.BugTrack.Entity.Bug;
import FinalProject.BugTrack.Entity.BugDependencies;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//Created the repository for the bugs dependencies.
@Repository
public interface BugDependenciesRepository extends JpaRepository<BugDependencies, Long> {
    List<BugDependencies> findAllByBugId(Long bugId);

    //Create a query to delete the dependencies after the bug is solved.
    @Transactional
    long deleteByDependsOn(Bug dependsOn);
}

