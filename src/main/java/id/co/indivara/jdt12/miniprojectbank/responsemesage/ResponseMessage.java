package id.co.indivara.jdt12.miniprojectbank.responsemesage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ResponseMessage {
    private int code;
    private String message;
}
