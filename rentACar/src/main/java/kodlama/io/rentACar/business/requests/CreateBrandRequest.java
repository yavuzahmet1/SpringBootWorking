package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {//İstek
    //niye name isteğinde bulunduk? çünkü id otomatik artarak kayıt ediliyor o yüzden ona gerek yok
    private String name;
}
