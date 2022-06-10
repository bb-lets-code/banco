public class SavingsAccount extends Account {
    private double inccome;

    public SavingsAccount(Client client, long number) {
        super( number, client);
        this.inccome = 0;
    }

    @Override
    public boolean openAccount() {
        if(client instanceof ClientePF){
            this.inccome = 0.0;
            this.amount = 0.0;
            return true;
        }else if(client instanceof ClientePJ){
            System.out.println("Não é possível abrir conta para Pessoa Jurídica");
            return false;
        }
        return false;
    }


    @Override
    public boolean deposit(double value) {
        this.amount += value;
        this.inccome += (this.amount * 0.05);
        return true;
    }
        
    

    @Override
    public boolean withdraw(double value) {
        if(this.amount >= value){
            if (this.client instanceof ClientePF){
                this.amount -= value;
            }else if ( this.client instanceof ClientePJ){
                this.amount -= value + (value * 0.05);
            }
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }

    }

    @Override
    public boolean endAccount() {
        return true;
        
    }

    @Override
    public boolean transfer( long toAccount, double value) {

        if(toAccount == 0){
            if(this.amount < value){
                System.out.println("Saldo insuficiente");
            }else{
                if( client instanceof ClientePJ){
                    this.amount -= (value + value*0.05);
                    
                }else if(client instanceof ClientePF){
                    this.amount -= value;
                    
                }
            }
            return true;
        }else{
            System.out.println("Conta não encontrada");
            return false;
        }
    }

}
