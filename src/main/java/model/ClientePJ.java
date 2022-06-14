package model;

public class ClientePJ extends Client{
    private String cnpj;

    public ClientePJ(String cnpj, String nomeCliente){
        super(nomeCliente);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "Nome: "  + getFullName() + "\n" +
        "CNPJ: " + getCnpj() + "\n";
    }
}
