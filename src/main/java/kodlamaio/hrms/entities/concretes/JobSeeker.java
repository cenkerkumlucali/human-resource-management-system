package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {

    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="date_of_birth")
    private int dateOfBirth;
    @Column(name="national_identity")
    private String nationalIdentity;

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getDateOfBirth() {
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

    public void setDateOfBirth(int dateOfBirth) {
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

    protected boolean canEqual(final Object other) {
        return other instanceof JobSeeker;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        result = result * PRIME + this.getDateOfBirth();
        final Object $nationalIdentity = this.getNationalIdentity();
        result = result * PRIME + ($nationalIdentity == null ? 43 : $nationalIdentity.hashCode());
        return result;
    }

    public String toString() {
        return "JobSeeker(name=" + this.getName() + ", surname=" + this.getSurname() + ", dateOfBirth=" + this.getDateOfBirth() + ", nationalIdentity=" + this.getNationalIdentity() + ")";
    }
}
