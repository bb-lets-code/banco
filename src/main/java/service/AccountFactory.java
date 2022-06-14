package service;

import model.*;

import java.util.Random;

public class AccountFactory {
    final static int typeAccountCurrent = 1;
    final static int typeAccountInvestiment = 2;
    final static int typeSavings = 3;
    public static Account openAccount(int tipoAccount, Client client){
        switch (tipoAccount){
            case (typeAccountCurrent):
                return new CurrentAccount(client, Account.getNumberSequence());
            case (typeAccountInvestiment):
                return new InvestimentAccount(client, Account.getNumberSequence());
            case (typeSavings):
            default:
                return new SavingsAccount(client, Account.getNumberSequence());
        }
    }
}
