package entities;

public class Cliente{
    private String nomeCliente;
    private String cpfCliente;

    public static Cliente clientesCC[] = new Cliente[5];
    public static Cliente clientesCCE[] = new Cliente[5];

    public Cliente(String nomeCliente, String cpfCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    //getter's
    public String getNomeCliente() {
        return nomeCliente;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }

    //setter's
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}