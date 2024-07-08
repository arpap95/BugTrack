package FinalProject.BugTrack.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//Setters getters and constructor.
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Bug implements Serializable {

    //Auto generating ID.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    private String description;

    //Foreign key for the user table.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User reporter;

    //Auto generating timestamp.
    @CreationTimestamp
    private LocalDateTime dateAdded;

    private boolean resolved;

    private LocalDateTime dateResolved;

    private int severity;

    //Creating the bug dependencies on the bug class.
    @OneToMany(mappedBy = "bug", cascade=CascadeType.ALL,orphanRemoval = true)
    List<BugDependencies> bugDependencies;
}