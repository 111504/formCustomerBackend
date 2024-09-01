package formCustomer.demo.entity.system;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;

    @Column(name="staff_code" ,nullable = false, unique = true)
    private String staffCode;

    @Column(name="staff_name" ,nullable = false, length = 100)
    private String staffName;

    @Column(length = 100)
    private String position;

    public Staff(String staffCode, String staffName, String position) {
        this.position = position;
        this.staffCode = staffCode;
        this.staffName = staffName;
    }
}
