package id.co.indivara.jdt12.miniprojectbank.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "trx_account_balance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountBalance {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "balance_id")
    private String balanceId;

    @Column(name = "account_id")
    private String  accountId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", updatable = false, insertable = false)
    private Account account;
    @Column(name = "balance")
    private BigDecimal balance;
}
