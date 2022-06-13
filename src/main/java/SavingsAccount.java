import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal inccome;
    private BigDecimal interestRate = BigDecimal.valueOf(0.005);


    public SavingsAccount(Client client, long number) {
        super( number, client);
        if( client instanceof ClientePJ){
            throw new IllegalArgumentException("Cliente PJ não pode ter conta de poupança");
        }
        this.inccome = BigDecimal.valueOf(0);
        
    }

    //TODO: receber o valor da classe mãe
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    private BigDecimal investment(BigDecimal value) {
        return value.multiply(interestRate);
    }


    


    @Override
    public boolean deposit(double value) {
        if(value > 0){
            double amountTemp = getAmount();
            amountTemp += value;
            setAmount(amountTemp);
            // double incomeTemp = this.inccome.doubleValue();
            BigDecimal incomeTemp = BigDecimal.valueOf(value);
            this.inccome =  this.inccome.add(investment(incomeTemp));
            return true;
        }else{
            throw new IllegalArgumentException("Valor inválido");   
        }
    }
        
    

    @Override
    public boolean withdraw(double value) {
        if(getAmount() + this.inccome.doubleValue() >= value){
            double amountTemp = getAmount();
            amountTemp -= value;
            setAmount(amountTemp);
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
    
    @Override
    public boolean transfer( long toAccount  , double value) {
        
        if(toAccount != 0){
            if(getAmount() < value){
                throw new IllegalArgumentException("Saldo insuficiente");
            }else{
                double amountTemp = getAmount();
                amountTemp -= (value + value*0.05);
                setAmount(amountTemp);
                return true;
            }
        }else{
            throw new IllegalArgumentException("Conta inválida");
        }
    }
    
    
    public String calulateIncome(){
        return "R$ " + this.inccome.toString();
    }

    public String totalBalance(){
        return "Saldo: " + getAmount() + " | Rendimento: " + this.inccome + " | Total: " + (getAmount() + this.inccome.doubleValue());
    }



    @Override
    public boolean openAccount() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean endAccount() {
        // TODO Auto-generated method stub
        return false;
    }


    //TODO: criar toString
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
