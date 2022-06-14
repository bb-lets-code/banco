public class ClientePF extends Client{
    String cpf = "";

    public ClientePF(String fullName, String cpf) {
        super(fullName);
        if(cpf.equals("")){
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }
    
}
