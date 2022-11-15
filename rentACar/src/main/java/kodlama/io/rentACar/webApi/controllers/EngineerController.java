package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.EngineerService;
import kodlama.io.rentACar.business.responses.GetAllEngineersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/engineers")
public class EngineerController {
    private EngineerService engineerService;

    @Autowired
    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/getall")
    public List<GetAllEngineersResponse> getAll(){
        return this.engineerService.getAll();
    }
}
