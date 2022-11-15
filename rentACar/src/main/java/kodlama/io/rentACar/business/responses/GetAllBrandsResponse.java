package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {//verilen data
    private int id;                 //İki datayı vermek istediğimizden bunları tanımladık
    private String name;
}
    /*Şimdi bu tabloda 2 adet kolon ile çalışmaktayız, 50 tanede de colonla da çalışabilirdik ama her
        kolonu son kullanıcıya bildirmek yani öğrenmesini engellemek durumundayız.

        son kullanıcıya bütün kolonu vermek zorunda değilsin
        işte son kullanıcıya Entitiy'ye erişmesini engeleyeceğiz.

        Bunun için Response ve Request yapısından faydalanacağız.

        BrandService interfacesi'nin içinde;

        List<Brand> getAll(); --> Brand tablosunu direk kullanıcıya sunmuştuk bunu
        belli datalar seviyesinde açmak istemek için*/