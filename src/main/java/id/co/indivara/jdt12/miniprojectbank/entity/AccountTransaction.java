package id.co.indivara.jdt12.miniprojectbank.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trx_account_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountTransaction {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    @Column(name = "account_id", updatable = false, insertable = false)
    private Integer accountId;
    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Account account;

    @Column(name = "target_account_id")
    private Integer targetAccountId;
    @Column(name = "transaction_type")
    private Enum transactionType;
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdDate;
    @Column(name = "amount")
    private Integer amount;
}
