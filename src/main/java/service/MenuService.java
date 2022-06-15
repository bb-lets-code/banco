package service;

import model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuService {

    private static Scanner scanner = new Scanner(System.in);
    public static Account selectAccount(List<Account> accounts) {
        int opcao;
        do {
            System.out.println("#######################################################");
            System.out.println("###### - Banco BB Lets-Code => Selecionar Conta - #####");
            System.out.println("########################################################");
            for (int i = 0; i < accounts.size(); i++)
                System.out.println("Digite " + i + " para selecionar a conta " + accounts.get(i).getNumber());
            System.out.println("########################################################");
            System.out.print("Escolha uma opção acima: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (Objects.isNull(accounts.get(opcao))) {
                System.out.println("conta escolhido não existe! Tente novamente.");
            }

        } while (Objects.isNull(accounts.get(opcao)));

        return accounts.get(opcao);
    }
    public static int menuOperacaoContas(long accountNumber){
        List<Integer> opcoes = new ArrayList<Integer>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);
        opcoes.add(4);
        opcoes.add(5);
        int opcao;
        do {
                System.out.println("#######################################################");
                System.out.println("###### - Banco BB Lets-Code => Conta " + accountNumber + " - #####");
                System.out.println("########################################################");
                System.out.println("#################### - 1 - Sacar - #####################");
                System.out.println("#################### - 2 - Investir/depositar - ########");
                System.out.println("#################### - 3 - Transferir - ################");
                System.out.println("#################### - 4 - Visualizar dados - ##########");
                System.out.println("#################### - 5 - Voltar ao menu anterior - ###");
                System.out.println("########################################################");
                System.out.print("Escolha uma opção acima: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if(!opcoes.contains(opcao)){
                    System.out.println("Opção escolhida não existe! Tente novamente.");
                }
        }while (!opcoes.contains(opcao));
        return opcao;
    }
}
