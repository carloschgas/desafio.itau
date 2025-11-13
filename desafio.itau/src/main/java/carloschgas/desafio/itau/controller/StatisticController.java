package carloschgas.desafio.itau.controller;

import carloschgas.desafio.itau.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    private final TransactionService service;

    public StatisticController(TransactionService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<DoubleSummaryStatistics> getStatistics(){
        return ResponseEntity.ok(service.getStatistics());
    }
}
