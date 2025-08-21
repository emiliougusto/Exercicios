package Exercicios.Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;
    private String detalhes;

    public Operacao(String tipo, double valor, String detalhes) {
        this.tipo = tipo;
        this.valor = valor;
        this.detalhes = detalhes;
        this.dataHora = LocalDateTime.now();
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("[%s] %s: R$ %.2f %s",
                dataHora.format(formatter), tipo, valor, detalhes != null ? detalhes : "");
    }
}