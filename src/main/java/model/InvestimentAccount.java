package model;

public class InvestimentAccount extends Account {
    public static final Double INCOME_RATE_PJ = 0.02;
    public static final Double RATE_PJ = 0.005;
    private Double income;

    public InvestimentAccount(Client client, long number) {
        super( number, client);
    }

    public Double getIncome() {
        return income;
    }

    @Override
    public boolean deposit(double value) {
        invest(value);
        return true;
    }

    public void invest(double value){
        setAmount(getAmount() + value);
        calculateIncome();
    }

    public void calculateIncome(){
        if(getClient() instanceof ClientePF){
            this.income += (getAmount() * getTransferWithdrawTax());
        } else if(getClient() instanceof ClientePJ) {
            this.income += (getAmount() * getTransferWithdrawTax()) + (getAmount() * INCOME_RATE_PJ);
        }
    }

    @Override
    public boolean withdraw(double value) {
        return withdrawMoney(value);
    }

    public boolean withdrawMoney(double value) {
        double valueRate = 0.0;

        if (getClient() instanceof ClientePJ) {
            double rate = RATE_PJ + 1.0;
            valueRate = value * rate;
        } else if (getClient() instanceof ClientePF) {
            valueRate = value;
        }

        if (getAmount() + this.income >= valueRate) {
            setAmount(getAmount() - valueRate);
            return true;

        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public boolean transfer( Account toAccount  , double value) {
        if(toAccount.getNumber() != 0){
            withdrawMoney(value);
            toAccount.deposit(value);
            return true;
        } else {
            System.out.println("Conta não encontrada");
            return false;
        }
    }

    public Double getTotalBalance(){
        return getAmount() + this.income;
    }

    @Override
    public String toString(){
        return  "=== Conta Investimento === \n" +
                "Nome do Cliente - " + getClient().getFullName() + "\n" +
                "Número da Conta - " + getNumber() + "\n" +
                "Dinheiro investido - R$" + getAmount() + "\n" +
                "Rendimento obtido - R$" + getIncome() + "\n" +
                "Balanço Total - R$" + getTotalBalance();
    }

}