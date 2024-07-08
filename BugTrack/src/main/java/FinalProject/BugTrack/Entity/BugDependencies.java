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


public class BugDependencies implements Serializable {
    //Auto generating ID.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Foreign key for the bug table.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bug_id",referencedColumnName = "id")
    private Bug bug;

    //The bug dependency for the bug.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depends_on_id",referencedColumnName = "id")
    private Bug dependsOn;



}