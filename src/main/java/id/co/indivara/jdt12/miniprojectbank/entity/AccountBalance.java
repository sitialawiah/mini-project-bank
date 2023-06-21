package id.co.indivara.jdt12.miniprojectbank.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Entity
@Table(name = "trx_account_balance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "account_id", updatable = false, insertable = false)
    private Integer accountId;

    @JoinColumn(name = "account_id")
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Account account;
    @Column(name = "balance")
    private Integer balance;
}
