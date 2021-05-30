package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
}
