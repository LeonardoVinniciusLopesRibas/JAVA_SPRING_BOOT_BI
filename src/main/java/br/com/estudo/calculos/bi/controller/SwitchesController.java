package br.com.estudo.calculos.bi.controller;

import br.com.estudo.calculos.bi.model.Switches;
import br.com.estudo.calculos.bi.repository.SwitchesRepository;
import br.com.estudo.calculos.bi.service.SwitchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/switches")
@CrossOrigin("*")
public class SwitchesController {

    @Autowired
    private SwitchesService switchesService;

    @GetMapping("/get")
    public ResponseEntity<List<Switches>> get(@RequestParam String query){

        List<Switches> switchesList = switchesService.get(query);

        if(switchesList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(switchesList);
    }

}
