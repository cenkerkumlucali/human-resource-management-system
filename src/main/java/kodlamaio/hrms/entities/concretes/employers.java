package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="employers")
@Data
public class employers {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="web_site")
    private String webSite;
    @Column(name="email")
    private String ePosta;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="password")
    private String password;

    public employers() { }
    public employers(int id, String companyName, String webSite, String ePosta, String phoneNumber, String password) {
        this.id = id;
        this.companyName = companyName;
        this.webSite = webSite;
        this.ePosta = ePosta;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
