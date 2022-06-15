import model.Client;
import model.Account;
import model.ClientePF;
import model.ClientePJ;
import service.AccountFactory;
import service.AccountService;
import service.ClientService;
import service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    static List<Account> accounts = new ArrayList<Account>();
    static Client client;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int optionMenu;


        bemVindo();
        menuPrincipal();


    }

    public static void bemVindo(){
        System.out.println("##################################################");
        System.out.println("###### - Banco BB Lets-Code Seja Bem Vindo - ######");
        System.out.println("##################################################");
        if (Objects.isNull(client)){
            client = ClientService.criarCliente();
        }
    }

    public static void menuPrincipal(){
        List<Integer> opcoes = new ArrayList<Integer>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);
        int opcao;
        do {
            System.out.println("##################################################");
            System.out.println("###### - Banco BB Lets-Code Seja Bem Vindo - ######");
            System.out.println("##################################################");
            System.out.println("###### -     Opções Disponíveis           - ######");
            System.out.println("###### -     1 - Abri Conta               - ######");
            System.out.println("###### -     2 - Listar Contas            - ######");
            System.out.println("###### -     3 - Realizar Operação        - ######");
            System.out.println("###### -     4 - Encerrar                 - ######");
            System.out.println("##################################################");
            System.out.println("Escolha uma das opções acima: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcoes.contains(opcao)){
                selectedMenu(opcao);
            }

            if (!opcoes.contains(opcao) && opcao != 4){
                System.out.println("Opção invalida tente novamente");
            }
        }while (opcao != 4);
    }

    private static void selectedMenu(int opcao){
        switch (opcao){
            case 1:
                menuConta();
                break;
            case 2:
                AccountService.listarContas(client, accounts);
                break;
            case 3:
                AccountService.operacaoAccount(accounts);
                break;
            default:
                System.exit(0);
        }
    }

    public static void menuConta(){
        if(client instanceof ClientePJ){
            menuCriarContaPJ();
        }else{
            menuCriarConta();
        }
    }

    public static void menuCriarContaPJ(){
        List<Integer> opcoes = new ArrayList<Integer>();
        opcoes.add(1);
        opcoes.add(2);
        int opcao;
        do {
            System.out.println("##################################################");
            System.out.println("###### - Banco BB Lets-Code => Abrir conta - #####");
            System.out.println("##################################################");
            System.out.println("Digite 1 para conta corrente ou 2 para investimento");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(!opcoes.contains(opcao)){
                System.out.println("Tipo de conta escolhido não disponível! Tente novamente.");
            }else {
                criarConta(opcao);
            }

        }while (!opcoes.contains(opcao));
    }

    public static void menuCriarConta(){
        List<Integer> opcoes = new ArrayList<Integer>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);
        int opcao;
        do {
            System.out.println("##################################################");
            System.out.println("###### - Banco BB Lets-Code => Abrir conta - #####");
            System.out.println("##################################################");
            System.out.println("Digite 1 para conta corrente, 2 para conta investimento ou 3 para Poupança");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(!opcoes.contains(opcao)){
                System.out.println("Tipo de conta escolhido não disponível! Tente novamente.");
            }else {
                criarConta(opcao);
            }

        }while (!opcoes.contains(opcao));
    }

    public static void criarConta(int tipoConta){
        accounts.add(AccountFactory.openAccount(tipoConta, client));
        AccountService.dadosContaCriada(accounts.get(accounts.size() - 1));
    }


}