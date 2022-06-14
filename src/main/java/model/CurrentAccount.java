package model;

import java.util.Objects;
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
    public boolean transfer( Account toAccount  , double value) {
        if(toAccount != null){
            if(getAmount() < value){
                throw new IllegalArgumentException("Saldo insuficiente");
            }else{
                if( getClient() instanceof ClientePF){
                    setAmount(getAmount() - value);
                    toAccount.deposit(value);
                }else if(getClient() instanceof ClientePJ){
                    double valueTax = value * (1 + getTransferWithdrawTax());
                    setAmount( getAmount() - valueTax);
                    toAccount.deposit(value);
                }
            }
            toAccount.deposit(value);
            return true;
        }else{
            throw new IllegalArgumentException("Conta inválida");
        }
    }
    @Override
    public String toString(){
        return  "=== Conta Corrente === \n" +
                "Nome do Cliente - " + getClient().getFullName() + "\n" +
                "Número da Conta - " + getNumber() + "\n" +
                "Saldo Disponível - R$" + getAmount() + "\n";
    }
}

