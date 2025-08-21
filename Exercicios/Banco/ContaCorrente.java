package Exercicios.Banco;

            import java.time.Duration;
            import java.time.LocalDateTime;

            public class ContaCorrente extends Conta {
                private boolean bloqueada = false;
                private LocalDateTime tempoNegativo = null;

                public ContaCorrente(Cliente cliente, double saldo){
                    super(cliente, saldo);
                }

                private void verificarBloqueio() {
                    if (saldo <= -200) {
                        if (tempoNegativo == null) {
                            tempoNegativo = LocalDateTime.now();
                        } else {
                            Duration duracao = Duration.between(tempoNegativo, LocalDateTime.now());
                            if (duracao.toMinutes() >= 1) {
                                bloqueada = true;
                                System.out.println("Conta bloqueada por saldo negativo prolongado!");
                            }
                        }
                    } else {
                        tempoNegativo = null;
                    }
                }

                @Override
                public void sacar(double valor) {
                    if (bloqueada) {
                        System.out.println("Conta bloqueada! Operação não permitida.");
                        return;
                    }
                    if (valor > 0 && (saldo - valor) >= -200) {
                        saldo -= valor;
                        historico.add(new Operacao("Saque", valor, null));
                        if (saldo < 0) {
                            System.out.println("Atenção: seu saldo está negativo em R$ " + saldo);
                        }
                        verificarBloqueio();
                    } else {
                        System.out.println("Operação não permitida! Saldo não pode ficar abaixo de -200.");
                    }
                }

                @Override
                public void transferir(Conta contaDestino, double valor) {
                    if (bloqueada) {
                        System.out.println("Conta bloqueada! Operação não permitida.");
                        return;
                    }
                    if (valor > 0 && (saldo - valor) >= -200) {
                        this.sacar(valor);
                        contaDestino.depositar(valor);
                        historico.add(new Operacao("Transferência Enviada", valor, "Para: " + contaDestino.getNomeTitular()));
                        contaDestino.historico.add(new Operacao("Transferência Recebida", valor, "De: " + this.getNomeTitular()));
                        verificarBloqueio();
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido para transferência! Limite excedido.");
                    }
                }
            }