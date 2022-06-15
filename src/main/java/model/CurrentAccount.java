package model;

// import java.util.Objects;
public class CurrentAccount extends Account {
    Double valueTax;

    public CurrentAccount(Client client, long number) {
        super( number, client);
    }

    public void calculateValue(Double value){
        if(getClient() instanceof ClientePF){
            this.valueTax = value;
        } else if(getClient() instanceof ClientePJ) {
            this.valueTax = value * (1 + getTransferWithdrawTax());
        }
    }

    @Override
    public boolean deposit(double value) {
        setAmount(getAmount() + value);
        return true;
    }
    @Override
    public boolean withdraw(double value) {
        calculateValue(value);
        if(getAmount() >= valueTax){
            if (getClient() instanceof ClientePF){
                setAmount(getAmount() - value);
            }else if ( getClient() instanceof ClientePJ){
                double valueT = value * (1 + getTransferWithdrawTax());
                setAmount( getAmount() - valueT);
            }
            return true;
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }
    }
    @Override
    public boolean transfer( Account toAccount  , double value) {
        calculateValue(value);
        if(toAccount != null){
            if(getAmount() < valueTax){
                System.out.println("Saldo insuficiente");
                return false;
            }else{
                if( getClient() instanceof ClientePF){
                    setAmount(getAmount() - value);
                    toAccount.deposit(value);
                }else if(getClient() instanceof ClientePJ){
                    double valueT = value * (1 + getTransferWithdrawTax());
                    setAmount( getAmount() - valueT);
                    toAccount.deposit(value);
                    }
                }
                return true;
        }else{
            System.out.println("Conta inválida");
            return false;
        }
    }
    
    @Override
    public String toString(){
        return  "=== Conta Corrente === \n" +
                "Nome do Cliente - " + getClient().getFullName() + "\n" +
                "Número da Conta - " + getNumber() + "\n" +
                "Saldo Disponível - R$" + String.format("%.2f",getAmount()) + "\n";
    }
}

