abstract class Account {
    private long number;
    private Client client;
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

    public abstract void openAccount(Client client);
        
    public abstract void transfer(Client client , Account toAccount , double value);
    
    public abstract void deposit(double value);

    public abstract void withdraw(Client client);

    public abstract void endAccount(Client client);
}