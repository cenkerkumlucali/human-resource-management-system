package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
public class JobPosition {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name = "position")
    private String position;

    public int getId() {
        return this.id;
    }

    public String getPosition() {
        return this.position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof JobPosition)) return false;
        final JobPosition other = (JobPosition) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof JobPosition;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        return result;
    }

    public String toString() {
        return "JobPosition(id=" + this.getId() + ", position=" + this.getPosition() + ")";
    }
}
