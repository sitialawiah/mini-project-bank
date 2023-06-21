package id.co.indivara.jdt12.miniprojectbank.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name= "mst_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private Instant password;
    @Column(name = "no_ktp")
    private String noKtp;
    @Column(name = "no_telp")
    private String noTelp;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
}
