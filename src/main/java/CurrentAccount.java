public class CurrentAccount extends Account {

    public CurrentAccount(Client client, long number) {
        super( number, client);
    }
    @Override
    public boolean deposit(double value) {
        setAmount(getAmount() + value);
        return true;
    }
    @Override
    public boolean withdraw(double value) {
        if(getAmount() >= value){
            if (getClient() instanceof ClientePF){
                setAmount(getAmount() - value);
            }else if ( getClient() instanceof ClientePJ){
                double valueTax = value * (1 + getTransferWithdrawTax());
                setAmount( getAmount() - valueTax);
            }
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
                System.out.println("Saldo insuficiente");
            }else{
                if( getClient() instanceof ClientePF){
                    setAmount(getAmount() - value);
                }else if(getClient() instanceof ClientePJ){
                    double valueTax = value * (1 + getTransferWithdrawTax());
                    setAmount( getAmount() - valueTax);
                }
            }
            return true;
        }else{
            System.out.println("Conta não encontrada");
            return false;
        }
    }
}

