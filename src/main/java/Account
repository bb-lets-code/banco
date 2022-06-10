abstract class Account{
    private long number;
    Client client;
    private double amount;

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
        
    public abstract void transfer(Client client);
    
    public abstract void deposit(Client client);

    public abstract void withdraw(Client client);

    public abstract void endAccount(Client client);
}