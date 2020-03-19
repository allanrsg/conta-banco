package entities;

public class ContaCorrenteEspecial extends ContaCorrente{
    protected float limite;

    public static ContaCorrenteEspecial contaCorrenteEspecials[] = new ContaCorrenteEspecial[5];

    public ContaCorrenteEspecial(float saldoContaCorrente, int numeroContaCorrente, float limite, Cliente titular){
        super(saldoContaCorrente,numeroContaCorrente,titular);
        this.limite = limite;
        this.titular = titular;
    }

    //getter's
    public double getLimite() {
        return limite;
    }

    //setter's
    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacarContaCorrente(float valor) {
        if (valor > 0){

            if(this.saldoContaCorrente + this.limite >= valor){
                if (this.saldoContaCorrente < valor){
                    this.saldoContaCorrente -= valor;
                    this.limite += this.saldoContaCorrente;
                }
                else {
                    this.saldoContaCorrente -= valor;
                }
                System.out.println("Saque realizado com sucesso!");
                System.out.println("Saldo atual: R$ " + saldoContaCorrente);
                System.out.println("Limite atual: R$ " + limite);
                System.out.println();
                return true;
            }
            else{
                System.out.println("Não há limite necessário para sacar!");
                return false;
            }
        }
        else{
            System.out.println("O valor de saque não pode ser negativo!");
            return false;
        }
    }
}
