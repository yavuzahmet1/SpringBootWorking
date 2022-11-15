package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateEngineerRequest;
import kodlama.io.rentACar.business.responses.GetAllEngineersResponse;

import java.util.List;

public interface EngineerService {
    List<GetAllEngineersResponse> getAll();
    void add(CreateEngineerRequest createEngineerRequest);
}
