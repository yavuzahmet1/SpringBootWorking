package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.EngineerService;
import kodlama.io.rentACar.business.requests.CreateEngineerRequest;
import kodlama.io.rentACar.business.responses.GetAllEngineersResponse;
import kodlama.io.rentACar.dataAccess.abstracts.EngineerRepository;
import kodlama.io.rentACar.entities.concretes.Engineer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<Engineer> engineers = engineerRepository.findAll();
        List<GetAllEngineersResponse> engineersResponses = new ArrayList<>();

        for (Engineer engineer : engineers) {

            GetAllEngineersResponse engineersResponse = new GetAllEngineersResponse();

            engineersResponse.setEngineerId(engineer.getEnginerId());
            engineersResponse.setEngineerName(engineer.getEngineerName());
            engineersResponse.setMobileNo(engineer.getMobileNo());
        }
        return engineersResponses;
    }

    @Override
    public void add(CreateEngineerRequest createEngineerRequest) {
        Engineer engineer = new Engineer();
        engineer.setEngineerName(createEngineerRequest.getEngineerName());
        engineer.setMobileNo(createEngineerRequest.getMobileNo());
        engineerRepository.save(engineer);

    }
}
