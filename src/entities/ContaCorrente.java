package entities;

import java.util.Scanner;
public class ContaCorrente {
    protected float  saldoContaCorrente = 0 ;
    protected int numeroContaCorrente;
    protected Cliente titular;

    protected static Scanner sc = new Scanner(System.in);

    public static ContaCorrente contaCorrentes[] = new ContaCorrente[5];

    public ContaCorrente(float saldoContaCorrente, int numeroContaCorrente, Cliente titular){
        this.saldoContaCorrente = saldoContaCorrente;
        this.numeroContaCorrente = numeroContaCorrente;
        this.titular = titular;
    }

    //getter's
    public double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }
    public int getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    //setter's
    public void setSaldoContaCorrente(float saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }
    public void setNumeroContaCorrente(int numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }

    //Métodos
    public boolean sacarContaCorrente(float valor){
        if(valor >= 0){
            if (saldoContaCorrente > valor){
                saldoContaCorrente -= valor;
                System.out.println("Saque realizado com sucesso!");
                System.out.println("Saldo atual: R$ " + saldoContaCorrente);
                System.out.println();
                return true;
            }
            else{
                System.out.println("\nNão há saldo suficiente!\n");
                return false;
            }
        }
        else{
            System.out.println("O valor de saque não pode ser negativo!");
            return false;
        }
    }

    public void depositarContaCorrente(float valor){
        if (valor < 0){
            System.out.println("\nNão é possível depositar valor negativo!");
        }
        else if (valor == 0){
            System.out.println("\nNão é possível depositar valor igual a 0");
        }
        else{
            this.saldoContaCorrente += valor;
            System.out.println("\nProcessando");
            System.out.println("\nDeposito realizado com sucesso!\n");
        }
    }
}