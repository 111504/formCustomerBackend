package formCustomer.demo.vo.request;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormInfoRequest {
    private Long formId;
}
