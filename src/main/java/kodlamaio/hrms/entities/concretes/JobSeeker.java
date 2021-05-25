package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {

    @NotNull(message = "Name cannot be null")
    @Column(name="name")
    private String name;
    @NotNull(message = "Surname cannot be null")
    @Column(name="surname")
    private String surname;
    @NotNull(message = "Date of birth cannot be null")
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @NotNull(message = "National identity cannot be null")
    @Column(name="national_identity")
    private String nationalIdentity;

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getNationalIdentity() {
        return this.nationalIdentity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof JobSeeker)) return false;
        final JobSeeker other = (JobSeeker) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        if (this.getDateOfBirth() != other.getDateOfBirth()) return false;
        final Object this$nationalIdentity = this.getNationalIdentity();
        final Object other$nationalIdentity = other.getNationalIdentity();
        if (this$nationalIdentity == null ? other$nationalIdentity != null : !this$nationalIdentity.equals(other$nationalIdentity))
            return false;
        return true;
    }

}
