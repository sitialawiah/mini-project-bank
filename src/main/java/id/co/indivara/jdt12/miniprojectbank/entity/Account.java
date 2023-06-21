package id.co.indivara.jdt12.miniprojectbank.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "accounts") //buat kalau nama d db sama nama d sini beda biar nyamain //di db
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId; //di java

    @Column(name = "customer_id", updatable = false, insertable = false) //buat generate d db
    private Integer customerId;
    @JoinColumn(name = "customer_id") //buat join kolom foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION) //buat menghapus di akun ini saja
    private Customer customer;

    @Column (name = "account_number")
    private Integer accountNumber;
    @Column (name = "pin")
    private String pin;
}
