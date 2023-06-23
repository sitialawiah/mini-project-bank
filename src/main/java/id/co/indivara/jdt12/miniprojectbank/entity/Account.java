package id.co.indivara.jdt12.miniprojectbank.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity //menunjukan kalau itu entity
@Table(name="mst_account") //bikin tabel
@Data //getter setter sama nunjukin itu lombok juga
@NoArgsConstructor //ga perlu bikin constructor kosong
@AllArgsConstructor //udah include karena udah pake lombok
@Builder //api buat class nya kayaknya
public class Account {
    @Id
    @Column(name = "account_id") //buat kalau nama d db sama nama d sini beda biar nyamain //di db
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String accountId; //di java

    @Column(name = "customer_id")
    private String customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //buat menghapus di akun ini saja
    @JsonIgnore
    private Customer customer;

    @Column (name = "account_number")
    private Integer accountNumber;
    @Column (name = "pin")
    private String pin;
}
