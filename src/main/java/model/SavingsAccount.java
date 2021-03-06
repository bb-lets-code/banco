package model;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal income;
    private final BigDecimal interestRate = BigDecimal.valueOf(0.005);


    public SavingsAccount(Client client, long number) {
        super( number, client);
        if( client instanceof ClientePJ )
            throw new IllegalArgumentException(
                    "Cliente PJ não pode ter conta de poupança"
            );
        else this.income = BigDecimal.valueOf(0);
    }


    private BigDecimal investment(BigDecimal value) {
        return value.multiply(interestRate); // calcula juros
    }


    @Override
    public boolean deposit(double valueDeposit) {
        if(valueDeposit > 0){
            setAmount(
                    BigDecimal.valueOf(getAmount()) //Valor atual do saldo
                            .add(BigDecimal.valueOf(valueDeposit)) //Adicionando o valor do depósito
                            .doubleValue() //Convertendo para double
            );
            this.income =  this.income.add( //Adicionando o valor do juros
                    investment(BigDecimal.valueOf(valueDeposit)) //Calculando o valor do rendimento
            );

            return true;
        }else{
            throw new IllegalArgumentException("Valor inválido");
        }
    }



    @Override
    public boolean withdraw(double value) {
        BigDecimal valueDeposit = BigDecimal.valueOf(value); //Valor do saque
        BigDecimal totalBalance = BigDecimal.valueOf(getAmount()).add(this.income); //Saldo total

        if(totalBalance.compareTo(valueDeposit) >= 0){ //Verifica se o saldo é maior ou igual ao valor do saque

            setAmount(totalBalance.subtract(valueDeposit).doubleValue()); //Atualizando o saldo
            return true;
        }else{
            System.out.println("Saldo insuficiente.");
            // throw new IllegalArgumentException("Saldo insuficiente");
        }
        return false;
    }

    @Override
    public boolean transfer( Account toAccount  , double value) {
        BigDecimal valueDeposit = BigDecimal.valueOf(value); //Valor do depósito
        BigDecimal totalBalance = BigDecimal.valueOf(getAmount()).add(this.income); //Saldo total
        if(toAccount != null){ //Verificando se a conta de destino existe
            if(totalBalance.compareTo(valueDeposit) <= 0){ //Verificando se o saldo é suficiente
                System.out.println("Saldo insuficiente.");
                // throw new IllegalArgumentException("Saldo insuficiente");
            }else{
                setAmount(
                        totalBalance //Valor atual do saldo
                                .subtract(valueDeposit) //Subtraindo o valor do depósito
                                .doubleValue() //Convertendo para double
                );
                toAccount.deposit(value); //Adicionando o valor do depósito na conta de destino
                return true;
            }
        }else{
            throw new IllegalArgumentException("Conta inválida"); //Conta de destino não existe
        }
        return false;
    }


    // public String calculateIncome(){
    //     return "R$ " + this.income.toString();
    // }



    @Override
    public String toString(){
        return  "=== Conta Poupança === \n" +
                "Nome do Cliente - " + getClient().getFullName() + "\n" +
                "Número da Conta - " + getNumber() + "\n" +
                "Dinheiro investido - R$" + getAmount() + "\n" +
                "Rendimento obtido - R$" + getIncome() + "\n" +
                "Balanço Total - R$" + getTotalBalance();
    }

    
    private BigDecimal getTotalBalance() {
        return this.income.add(BigDecimal.valueOf(getAmount()));
    }


    private BigDecimal getIncome() {
        return this.income;
    }
}
