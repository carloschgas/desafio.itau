package carloschgas.desafio.itau.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public class TransactionRequest {

    @NotNull
    @Positive
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public TransactionRequest(Double valor){
        this.valor = valor;
        this.dataHora = OffsetDateTime.now();
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
