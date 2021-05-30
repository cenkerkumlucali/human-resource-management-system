package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private employers employer;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfOpenPositions")
    private int numberOfOpenPositions;

    @Column(name="creationDate")
    private LocalDate creationDate = LocalDate.now();

    @Column(name="deadline")
    private LocalDate deadline;

    @Column (name="is_deleted")
    private boolean isDeleted = false;

    @Column (name="is_active")
    private boolean isActive = true;
}
