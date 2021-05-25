package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class employers extends User{

    @NotNull(message = "Company name cannot be null")
    @Column(name="company_name")
    private String companyName;
    @NotNull(message = "Web site  cannot be null")
    @Column(name="web_site")
    private String webSite;
    @NotNull(message = "Phone number cannot be null")
    @Column(name="phone_number")
    private String phoneNumber;


    public String getCompanyName() {
        return this.companyName;
    }

    public String getWebSite() {
        return this.webSite;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof employers)) return false;
        final employers other = (employers) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$companyName = this.getCompanyName();
        final Object other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName))
            return false;
        final Object this$webSite = this.getWebSite();
        final Object other$webSite = other.getWebSite();
        if (this$webSite == null ? other$webSite != null : !this$webSite.equals(other$webSite)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof employers;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $companyName = this.getCompanyName();
        result = result * PRIME + ($companyName == null ? 43 : $companyName.hashCode());
        final Object $webSite = this.getWebSite();
        result = result * PRIME + ($webSite == null ? 43 : $webSite.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        return result;
    }

    public String toString() {
        return "employers(companyName=" + this.getCompanyName() + ", webSite=" + this.getWebSite() + ", phoneNumber=" + this.getPhoneNumber() + ")";
    }
}
