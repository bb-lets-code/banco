package service;

import model.Account;
import model.Client;
import model.InvestimentAccount;

import java.util.List;

public class AccountService {
    final private static int withdraw = 1;
    final private static int depositInvestiment = 2;
    final private static int transfer = 3;
    final private static int visualization = 4;

    public static void operacaoAccount(List<Account> accounts){
        if(accounts.size() > 0) {
            Account account = MenuService.selectAccount(accounts);
            int operacao;
            do {
                operacao = MenuService.menuOperacaoContas(account.getNumber());
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
            }while (operacao != 5);
        }else {
            System.out.println("Você não tem uma conta em nosso banco, abra uma conta primeiro");
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
                if(account.getAmount() > 0){ // Verifica se há saldo na conta
                    Account toAccount;
                    do {
                        toAccount = MenuService.selectAccount(accounts);
                        if (toAccount.equals(account)) {
                            System.out.println("A conta destino é a mesma conta de origem, selecione outra conta");
                        }
                    } while (toAccount.equals(account));
                    
                    
                    boolean success = false;
                    do {
                        try{

                            success = account.transfer(toAccount, ClientService.lerValue("Transferir")); 
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            System.out.println("Tente novamente.");
                            success = false;
                        }
                    } while (success == false);
                }
                else{ 
                    System.out.println("Você não tem saldo suficiente para transferir");
                }
        }else {
            System.out.println("Sem contas cadastradas para realizar a transferência");
        }
    }

    private static void exibirInformacoes(Account account){
        System.out.println(account.toString());
    }

    public static void listarContas(Client client, List<Account> accounts){
        ClientService.imprimir(client);
        System.out.println("Contas encontradas: ");
        System.out.println("######################################################");
        for (Account account: accounts) {
            System.out.println(account.toString());
            System.out.println("---------------------------------------------------");
        }
        System.out.println("#########################################################");
    }

    public static void dadosContaCriada(Account account){
        System.out.println("Conta Criada com sucesso");
        System.out.println(account.toString());
        System.out.println("Voltando para o menu principal");
    }

}
