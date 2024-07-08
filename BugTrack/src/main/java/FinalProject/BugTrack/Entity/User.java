package FinalProject.BugTrack.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

//Setters getters and constructor.
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bug_user")

public class User implements Serializable {

    //Auto generating ID.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;


}
