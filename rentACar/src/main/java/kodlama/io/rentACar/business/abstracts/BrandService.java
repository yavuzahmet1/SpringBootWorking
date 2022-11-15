package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll(); // yanıtımız yani Response edilecek
											// yani BrandService'den itibaren veritabanı nesnesi kullanmak yasak

	void add(CreateBrandRequest createBrandRequest);

}
