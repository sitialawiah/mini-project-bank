package id.co.indivara.jdt12.miniprojectbank.model;
import lombok.Data;

@Data
public class SaveAccount {
    private String accountId;
    private String customerId;
    private Integer accountNumber;
    private Integer pin;
}
