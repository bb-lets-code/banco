package model;

public abstract class Account {

    private static long numberSequence = 999l;
    private long number;
    private Client client;
    private double amount;
    private final Double transferWithdrawTax = 0.005;

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

    protected void setAmount(double amount){
        this.amount = amount;
    }

    public Double getTransferWithdrawTax() {
        return transferWithdrawTax;
    }
    
    public abstract boolean transfer(Account toAccount , double value);
    
    public abstract boolean deposit(double value);

    public abstract boolean withdraw(double value);

    public static long getNumberSequence(){
        incrementNumberSequence();
        return numberSequence;
    }

    private static void incrementNumberSequence(){
        numberSequence++;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}