package br.com.cbgomes.controller;


import br.com.cbgomes.ports.input.InputPort;
import br.com.cbgomes.request.HospitalRequest;
import br.com.cbgomes.response.HospitalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public HospitalResponse criarHospital(@RequestBody HospitalRequest request) {
       var response = this.inputPort.save(request.convertHospitalInputPort(request));
       return HospitalResponse.converteHospitalOutputPortHospitalResponse(response);
    }

//    @GetMapping
//    public List<HospitalResponse> hospitais(){
//        // TODO: 22/01/22
//    }
}
