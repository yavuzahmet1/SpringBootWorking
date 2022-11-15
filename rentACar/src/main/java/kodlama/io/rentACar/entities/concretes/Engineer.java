package kodlama.io.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enginers")
@Entity
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engineers_id")
    private int enginerId;
    @Column(name = "engineers_name")
    private String engineerName;
    @Column(name = "mobile_no")
    private String mobileNo;

}
