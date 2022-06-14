import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal income;
    private final BigDecimal interestRate = BigDecimal.valueOf(0.005);


    public SavingsAccount(Client client, long number) {
        super( number, client);
        if( client instanceof ClientePJ ){
            throw new IllegalArgumentException("Cliente PJ não pode ter conta de poupança");
        }

        this.income = BigDecimal.valueOf(0);
        
    }


    private BigDecimal investment(BigDecimal value) {
        return value.multiply(interestRate);
    }


    @Override
    public boolean deposit(double value) {
        if(value > 0){
            BigDecimal amountTemp = BigDecimal.valueOf(getAmount());
            amountTemp = amountTemp.add(BigDecimal.valueOf(value));
            setAmount(amountTemp.doubleValue());
            BigDecimal incomeTemp = BigDecimal.valueOf(value);
            this.income =  this.income.add(investment(incomeTemp));
            return true;
        }else{
            throw new IllegalArgumentException("Valor inválido");   
        }
    }
        
    

    @Override
    public boolean withdraw(double value) {
        if(getAmount() + this.income.doubleValue() >= value){
            double amountTemp = getAmount();
            amountTemp -= value;
            setAmount(amountTemp);
            return true;
        }else{
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
    
    @Override
    public boolean transfer( Account toAccount  , double value) {
        
        if(toAccount != null){
            if(getAmount() < value){
                throw new IllegalArgumentException("Saldo insuficiente");
            }else{
                double amountTemp = getAmount();
                amountTemp -= value;
                setAmount(amountTemp);
                toAccount.deposit(value);
                return true;
            }
        }else{
            throw new IllegalArgumentException("Conta inválida");
        }
    }
    
    
    public String calculateIncome(){
        return "R$ " + this.income.toString();
    }

    private String totalBalance(){
        return "N° da Conta: "+ this.getNumber() +" Saldo: " + getAmount() + " | Rendimento: " + this.income + " | Total: " + (getAmount() + this.income.doubleValue());
    }



    // @Override
    // public boolean openAccount() {
    //     // TODO Auto-generated method stub
    //     return false;
    // }
    // @Override
    // public boolean endAccount() {
    //     // TODO Auto-generated method stub
    //     return false;
    // }


    //TODO: criar toString
    @Override
    public String toString() {
        // TODO Auto-generated method stub

        return totalBalance();
    }
}
