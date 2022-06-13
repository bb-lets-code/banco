public class ClientePF extends Client{
    private String cpf;

    public ClientePF(String fullName, String cpf) {
        super(fullName);
        if (cpf.equals("")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: "  + getFullName() + "\n" +
                "CNPJ: " + getCpf() + "\n";
    }
}
