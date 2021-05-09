package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="job_positions")
public class JobPosition {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name = "position")
    private String position;

    public JobPosition() { }

    public JobPosition(int id, String position) {
        this.id = id;
        this.position = position;
    }
}
