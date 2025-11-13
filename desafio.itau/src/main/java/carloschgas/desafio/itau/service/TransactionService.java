package carloschgas.desafio.itau.service;

import carloschgas.desafio.itau.model.Transaction;
import carloschgas.desafio.itau.model.TransactionRequest;
import carloschgas.desafio.itau.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }

    public Boolean createTransaction(TransactionRequest request){

        if (request.getDataHora().isBefore(OffsetDateTime.now())){
            Transaction newTransaction = new Transaction(request.getValor(),request.getDataHora());
            repository.createTransaction(newTransaction);
            return true;
        }

        System.out.println("DEBUG: Transação inválida");
        return false;

    }

    public DoubleSummaryStatistics getStatistics(){
        return repository.getRepository().stream()
                .filter(transaction -> transaction.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(transaction -> transaction.getValor())
                .summaryStatistics();
    }


    public void deleteAll(){
        repository.deleteAll();
    }

}
