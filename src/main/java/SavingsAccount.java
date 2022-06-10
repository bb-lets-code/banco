public class SavingsAccount extends Account {
    private double inccome;


    public SavingsAccount(Client client, long number) {
        super( number, client);
    }
    @Override
    public boolean openAccount() {
        if(getClient() instanceof ClientePF){
            this.inccome = 0.0;
            setAmount(0.0);
            return true;
        }else if(getClient() instanceof ClientePJ){
            System.out.println("Não é possível abrir Conta Poupança para Pessoa Jurídica");
            return false;
        }
        return false;
    }


    @Override
    public boolean deposit(double value) {
        double amountTemp = getAmount();
        amountTemp += value;
        setAmount(amountTemp);
        this.inccome += (getAmount() * 0.05);
        return true;
    }
        
    

    @Override
    public boolean withdraw(double value) {
        if(getAmount() + this.inccome >= value){
            if (getClient() instanceof ClientePF){
                double amountTemp = getAmount();
                amountTemp -= value;
                setAmount(amountTemp);
            }else if ( getClient() instanceof ClientePJ){
                double amountTemp = getAmount();
                amountTemp -= value + (value * 0.05);
                setAmount( amountTemp);

            }
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public boolean endAccount() {
        setAmount(0.0);
        this.inccome = 0.0;
        return true;
    }

    @Override
    public boolean transfer( long toAccount  , double value) {

        if(toAccount != 0){
            if(getAmount() < value){
                System.out.println("Saldo insuficiente");
            }else{
                if( getClient() instanceof ClientePJ){
                    double amountTemp = getAmount();
                    amountTemp -= (value + value*0.05);
                    setAmount(amountTemp);
                }else if(getClient() instanceof ClientePF){
                    double amountTemp = getAmount();
                    amountTemp -= value;
                    setAmount(amountTemp);
                }
            }
            return true;
        }else{
            System.out.println("Conta não encontrada");
            return false;
        }
    }

    public String totalBalance(){
        return "Saldo: " + getAmount() + " | Rendimento: " + this.inccome + " | Total: " + (getAmount() + this.inccome);
    }

}
