public class ClientePJ extends Client{
    private String cnpj;
    private Double transferWithdrawIncomeRate;
    private Double savingsIncomeRate;

    public ClientePJ(String cnpj, String nomeCliente){
        super(nomeCliente);
        this.cnpj = cnpj;
        this.transferWithdrawIncomeRate = 0.05;
        this.savingsIncomeRate  = 0.05;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getTransferWithdrawIncomeRate() {
        return transferWithdrawIncomeRate;
    }

    public Double getSavingsIncomeRate() {
        return savingsIncomeRate;
    }
}
