package FinalProject.BugTrack.Repository;

import FinalProject.BugTrack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

//Created the repository for the user.
public interface UserRepository extends JpaRepository<User,Long>{
    
}
