package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="jobSeekers")
@Data
public class JobSeeker {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="date_of_birth")
    private int dateOfBirth;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="national_identity")
    private String nationalIdentity;

    public JobSeeker() {
    }

    public JobSeeker(int id, String name, String surname, String nationalIdentity, int dateOfBirth, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationalIdentity = nationalIdentity;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }
}
