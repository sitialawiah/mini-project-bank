package id.co.indivara.jdt12.miniprojectbank.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.math.BigDecimal;
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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;
    @JoinColumn(name = "account_id", updatable = false, insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Account account;

    @Column(name = "account_number")
    private Integer accountNumber;


    @Column(name = "created_date") //tanggal pembuatan transaksi
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdDate;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name="type_transaction")
    private EnumTransaction typeTransaction;

    public enum EnumTransaction {
        DEPOSIT ("Deposit"),
        WITHDRAW("Withdraw"),
        TRANSFER("Transfer");
        private String text;
        EnumTransaction(String text) {this.text=text;}
        public String getText() {return text;}
    }
}
