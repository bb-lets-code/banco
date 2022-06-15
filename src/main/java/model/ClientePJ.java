package model;

public class ClientePJ extends Client{
    private String cnpj;

    public ClientePJ(String fullName, String cnpj){
        super(fullName);
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
