public class ClientePJ extends Client{
    private String cnpj;
    private final Double transferWithdrawTax = 0.005;
    private final Double investmentBonus = 0.02;

    public ClientePJ(String cnpj, String nomeCliente){
        super(nomeCliente);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getInvestmentBonus() {
        return investmentBonus;
    }
    public Double getTransferWithdrawTax() {
        return transferWithdrawTax;
    }
}
