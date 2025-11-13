package carloschgas.desafio.itau.repository;

import carloschgas.desafio.itau.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    List<Transaction> repository = new ArrayList<>();

    public void createTransaction(Transaction newTransaction) {
        System.out.println("added transaction");
        repository.add(newTransaction);
        debugRepository();


    }

    public void deleteAll() {
        System.out.println("deleted all transactions");
        repository.clear();
        debugRepository();
    }

    public void debugRepository() {
        for (Transaction transaction : repository) {
            System.out.println("{ valor:" + transaction.getValor() + " -- " + "dataHora: " + transaction.getDataHora());

        }

    }

    public List<Transaction> getRepository() {
        return repository;
    }

}
