//Desenvolvido por Allan Gomes
//Canoas, 18 de Março de 2020

package application;
import entities.*;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static int contCC = 0, contCCE=0;

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        char opcao = '0';
        do {
            System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - - - - |");
            System.out.println("|                 Bem-vindo ao banco ACME             |");
            System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - - - - |\n");
            System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - - - - |");
            System.out.println("|Escolha uma das opções a seguir do menu:             |");
            System.out.println("|[1] - Criar Conta Corrente                           |");
            System.out.println("|[2] - Criar Conta Corrente Especial                  |");
            System.out.println("|[3] - Sacar Conta Corrente                           |");
            System.out.println("|[4] - Sacar Conta Corrente Especial                  |");
            System.out.println("|[5] - Depositar Conta Corrente                       |");
            System.out.println("|[6] - Depositar Conta Corrente Especial              |");
            System.out.println("|[7] - Sair                                           |");
            System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - - - - |");
            System.out.print("\nInsira uma opção: ");  opcao = sc.next().charAt(0);
            switch(opcao){
                case '1':
                    criarContaCorrente();
                    break;
                case '2':
                    criarContaCorrenteEspecial();
                    break;
                case '3':
                    sacarContaCorrente();
                    break;
                case '4':
                    sacarContaCorrenteEspecial();
                    break;
                case '5':
                    depositarContaCorrente();
                    break;
                case '6':
                    depositarContaCorrenteEspecial();
                    break;
                case '7':
                    System.out.println("Você finalizou o atendimento!\nO banco ACME agradece a preferência");
                    break;
                default:
                    System.out.println("Você inseriu uma opção incorreta...");
                    System.out.println("Para voltar ao menu digite 1, para finalizar qualquer outra tecla");
                    char opcaoDefault = sc.next().charAt(0);
                    if(opcaoDefault != '1'){
                        System.out.println("Você finalizou seu atendimento\nO banco ACME agradece a preferência!");
                        opcao = '7';
                    }
            }
        }while(opcao!='7');
    }

    public static void criarContaCorrente(){
        String nomeAux, cpfAux;
        int numeroContaAux;
        float saldoAux;
        System.out.println("\nCadastro de Conta Corrente");
        if (contCC < 5){
            System.out.print("Insira o nome do cliente: ");
            sc.nextLine();
            nomeAux = sc.nextLine();
            System.out.print("Insira o CPF: ");
            cpfAux = sc.nextLine();
            System.out.print("Insira o número da conta: ");
            numeroContaAux = sc.nextInt();
            System.out.print("Insira o saldo: R$ ");
            saldoAux = sc.nextFloat();
            Cliente cli = new Cliente(nomeAux, cpfAux); //instancia cliente com construtor
            Cliente.clientesCC[contCC] = new Cliente(nomeAux, cpfAux);
            ContaCorrente.contaCorrentes[contCC] = new ContaCorrente(saldoAux, numeroContaAux, cli); //instancia a conta corrente com construtor, informando o cliente
            System.out.println("\nConta cadastrada com sucesso!");
            System.out.println();
            contCC++;
        }
        else{
            System.out.println("Número máximo de clientes do tipo Conta Corrente excedido!");
            System.out.println();
        }
    }

    private static void criarContaCorrenteEspecial(){
        //variáveis do método
        String nomeAux, cpfAux;
        int numeroContaAux;
        float saldoAux, limiteAux;
        System.out.println("\nCadastro de Conta Corrente Especial");
        if (contCCE < 5){
            System.out.print("Insira o nome do cliente: ");
            sc.nextLine();
            nomeAux = sc.nextLine();
            System.out.print("Insira o CPF: ");
            cpfAux = sc.nextLine();;
            System.out.print("Insira o número da conta: ");
            numeroContaAux = sc.nextInt();
            System.out.print("Insira o saldo: R$ ");
            saldoAux = sc.nextFloat();
            System.out.print("Insira o limite: R$ ");
            limiteAux = sc.nextFloat();
            Cliente cli = new Cliente(nomeAux, cpfAux); //instancia cliente com construtor
            Cliente.clientesCCE[contCCE] = new Cliente(nomeAux, cpfAux);
            ContaCorrenteEspecial.contaCorrenteEspecials[contCCE] = new ContaCorrenteEspecial(saldoAux, numeroContaAux, limiteAux, cli ); //instancia a conta corrente com construtor, informando o cliente
            System.out.println("\nConta cadastrada com sucesso!");
            System.out.println();
            contCCE++;
        }
        else{
            System.out.println("Número máximo de cliente Conta Corrente Especial excedido");
        }
    }

    private static void sacarContaCorrente(){
        float valorSaqueAux;
        int numeroContaAux, i;
        System.out.println("Saques");
        if(contCC != 0){
            System.out.print("\nInsira o número da conta que deseja realizar o saque: ");
            numeroContaAux = sc.nextInt();
            for(i=0; i < contCC; i++){
                if(ContaCorrente.contaCorrentes[i].getNumeroContaCorrente() == numeroContaAux){
                    System.out.println("Conta encontrada...");
                    System.out.println("Titular da conta: " + Cliente.clientesCC[i].getNomeCliente());
                    System.out.println("Saldo disponível: R$ " + ContaCorrente.contaCorrentes[i].getSaldoContaCorrente());
                    System.out.print("\nInsira o valor do saque: ");
                    valorSaqueAux = sc.nextFloat();
                    ContaCorrente.contaCorrentes[i].sacarContaCorrente(valorSaqueAux);
                    break;
                }
                else {
                    System.out.println("Não foi encontrado nenhuma Conta Corrente com este número...\n");
                }
            }
        }
        else{
            System.out.println("\nNão há nenhuma Conta Corrente cadastrada...\n");
        }
    }

    private static void sacarContaCorrenteEspecial(){
        float valorSaqueAux;
        int numeroContaAux, i;
        System.out.println("\nSaques");
        if(contCCE != 0){
            System.out.print("Insira o número da conta que deseja realizar o saque: ");
            numeroContaAux = sc.nextInt();
            for(i=0; i < contCCE; i++){
                if(ContaCorrenteEspecial.contaCorrenteEspecials[i].getNumeroContaCorrente() == numeroContaAux){
                    System.out.println("Conta encontrada...");
                    System.out.println("Titular da conta: " + Cliente.clientesCCE[i].getNomeCliente());
                    System.out.println("Saldo disponível: R$ " + ContaCorrenteEspecial.contaCorrenteEspecials[i].getSaldoContaCorrente());
                    System.out.println("Limite disponível: R$ " + ContaCorrenteEspecial.contaCorrenteEspecials[i].getLimite());
                    System.out.print("\nInsira o valor do saque: ");
                    valorSaqueAux = sc.nextFloat();
                    ContaCorrenteEspecial.contaCorrenteEspecials[i].sacarContaCorrente(valorSaqueAux);
                    break;
                }
                else {
                    System.out.println("Não foi encontrado nenhuma Conta Corrente Especial com este número...\n");
                }
            }

        }
        else{
            System.out.println("\nNão há nenhuma Conta Corrente Especial cadastrada...\n");
        }
    }

    public static void depositarContaCorrente(){
        int i=0, numeroContaAux, confirmacao;
        float valorDepositoAux;

        System.out.println("\nDepositos!");

        if(contCC != 0){
            System.out.print("\nInsira o número da conta desejada: ");
            numeroContaAux = sc.nextInt();
            for (i=0; i < contCC; i++){
                if(ContaCorrente.contaCorrentes[i].getNumeroContaCorrente() == numeroContaAux){
                    System.out.print("Insira o valor a ser depositado: ");
                    valorDepositoAux = sc.nextFloat();

                    System.out.println("\nTitular da conta: " + Cliente.clientesCC[i].getNomeCliente());
                    System.out.println("CPF: " + Cliente.clientesCC[i].getCpfCliente());
                    System.out.println("Valor do depósito: R$ " + valorDepositoAux);
                    System.out.print("\nConfirma o depósito para essa conta? [1] sim ou [2] não: ");
                    confirmacao = sc.nextInt();
                    switch(confirmacao){
                        case 1:
                            ContaCorrente.contaCorrentes[i].depositarContaCorrente(valorDepositoAux);
                            break;
                        case 2:
                            System.out.println("\nDepósito negado pelo usuário!\n");
                            break;
                        default:
                            System.out.println("Opção inválida...");
                    }
                }
                else{
                    System.out.println("\nNão há nenhuma conta corrente com este número!\n");
                }
            }
        }
        else{
            System.out.println("\nNão há nenhuma Conta Corrente cadastrada...\n");
        }
    }

    public static void depositarContaCorrenteEspecial(){
        int i=0, numeroContaAux, confirmacao;
        float valorDepositoAux;
        System.out.println("Depositos!");
        if(contCCE != 0){
            System.out.print("Insira o número da conta desejada: ");
            numeroContaAux = sc.nextInt();
            for (i=0; i < contCCE; i++){
                if(ContaCorrenteEspecial.contaCorrenteEspecials[i].getNumeroContaCorrente() == numeroContaAux){
                    System.out.print("\nInsira o valor a ser depositado: ");
                    valorDepositoAux = sc.nextFloat();
                    System.out.println("\nTitular da conta: " + Cliente.clientesCCE[i].getNomeCliente());
                    System.out.println("CPF: " + Cliente.clientesCCE[i].getCpfCliente());
                    System.out.println("Valor do depósito: R$ " + valorDepositoAux);
                    System.out.print("\nConfirma o depósito para essa conta? [1] sim ou [2] não: ");
                    confirmacao = sc.nextInt();
                    switch(confirmacao){
                        case 1:
                            ContaCorrenteEspecial.contaCorrenteEspecials[i].depositarContaCorrente(valorDepositoAux);
                            break;
                        case 2:
                            System.out.println("\nDepósito negado pelo usuário!\n");
                            break;
                        default:
                            System.out.println("Opção inválida...");
                    }
                }
                else{
                    System.out.println("\nNão há nenhuma conta corrente com este número!\n");
                }
            }
        }
        else{
            System.out.println("\nNão há nenhuma Conta Corrente cadastrada...\n");
        }
    }
}