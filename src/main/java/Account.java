abstract class Account {
    private long number;
    protected Client client;
    protected double amount;

    public Account(long number, Client client){
        this.number = number;
        this.client = client;
    }

    public long getNumber(){
        return number;
    }

    public Client getClient(){
        return client;
    }

    public double getAmount(){
        return amount;
    }

    

    public abstract boolean openAccount();
        
    public abstract boolean transfer( long account , double value);
    
    public abstract boolean deposit(double value);

    public abstract boolean withdraw(double value);

    public abstract boolean endAccount();
}