package br.com.cbgomes.controller;


import br.com.cbgomes.ports.input.InputPort;
import br.com.cbgomes.request.HospitalRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospitais")
public class HospitalController {

    private final InputPort inputPort;

    public HospitalController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public void criarHospital(@RequestBody HospitalRequest request) {
       this.inputPort.save(request.convertHospitalInputPort(request));
    }
}
