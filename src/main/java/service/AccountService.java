package service;

import model.Account;
import model.InvestimentAccount;

import java.util.List;


public class AccountService {
    final private static int withdraw = 1;
    final private static int depositInvestiment = 2;
    final private static int transfer = 3;
    final private static int visualization = 4;

    public static void operacaoAccount(List<Account> accounts){
        Account account = MenuService.selectAccount(accounts);
        int operacao = MenuService.menuOperacaoContas(account.getNumber());
        switch (operacao) {
            case withdraw:
                withdraw(account);
                break;
            case depositInvestiment:
                depositInvestiment(account);
                break;
            case transfer:
                transfer(account, accounts);
                break;
            case visualization:
            default:
                exibirInformacoes(account);
        }
    }

    private static void withdraw(Account account){
        account.withdraw(ClientService.lerValue("Sacar"));
    }

    private static void depositInvestiment(Account account){
        if(account instanceof InvestimentAccount){
            InvestimentAccount investiment = (InvestimentAccount) account;
            investiment.invest(ClientService.lerValue("Investir"));
        }else {
            account.deposit(ClientService.lerValue("Depositar"));
        }
    }

    private static void transfer(Account account, List<Account> accounts){
        if (accounts.size() > 1) {
            Account toAccount;
            do {
                toAccount = MenuService.selectAccount(accounts);
                if (toAccount.equals(account)) {
                    System.out.println("A conta destino é a mesma conta de origem, selecione outra conta");
                }
            } while (toAccount.equals(account));


            account.transfer(toAccount, ClientService.lerValue("Transferir"));
        }else {
            System.out.println("Sem contas cadastradas para realizar a transferência");
        }
    }

    private static void exibirInformacoes(Account account){
        System.out.println(account.toString());
    }

}
