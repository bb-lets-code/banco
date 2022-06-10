public class ClientePJ extends Client{
    private String cnpj;
    private Double transferWithdrawIncomeRate;
    private Double savingsIncomeRate;

    public ClientePJ(String cnpj, String nomeCliente, Double transferWithdrawIncomeRate, Double savingsIncomeRate){
        super(nomeCliente);
        this.cnpj = cnpj;
        this.transferWithdrawIncomeRate = transferWithdrawIncomeRate;
        this.savingsIncomeRate  = savingsIncomeRate;
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
