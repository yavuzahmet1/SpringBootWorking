package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.EngineerService;
import kodlama.io.rentACar.business.requests.CreateEngineerRequest;
import kodlama.io.rentACar.business.responses.GetAllEngineersResponse;
import kodlama.io.rentACar.dataAccess.abstracts.EngineerRepository;
import kodlama.io.rentACar.entities.concretes.Engineer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerManager implements EngineerService {
    private final EngineerRepository engineerRepository;

    @Autowired
    public EngineerManager(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    @Override
    public List<GetAllEngineersResponse> getAll() {
        return null;
    }

    @Override
    public void add(CreateEngineerRequest createEngineerRequest) {
        Engineer engineer = new Engineer();
        engineer.setEngineerName(createEngineerRequest.getEngineerName());
        engineer.setMobileNo(createEngineerRequest.getMobileNo());
        engineerRepository.save(engineer);

    }
}
