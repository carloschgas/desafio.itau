package carloschgas.desafio.itau.controller;

import carloschgas.desafio.itau.model.TransactionRequest;
import carloschgas.desafio.itau.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")

public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequest request){

        if(service.createTransaction(request)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.unprocessableEntity().build();
    }

    @DeleteMapping
    ResponseEntity<Void> deleteAll(){
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
