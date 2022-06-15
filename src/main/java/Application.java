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
        System.out.println("###### - Banco BB Lets-Code seja bem vindo - ######");
        System.out.println("##################################################");
        if (Objects.isNull(client)){
            criarCliente();
        }
    }

    static public void criarCliente(){
        int tipo = ClientService.lerTipoCliente();
        if(tipo == 1){
            client = new ClientePF(ClientService.validaString("CPF", 11), ClientService.validaString("Digite no nome do cliente", 5));
        }else{
            client = new ClientePJ(ClientService.validaString("cnpj", 14), ClientService.validaString("Digite o  nome do cliente", 5));
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
                listarContas();
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
        dadosContaCriada();
    }


    public static void listarContas(){
        imprimir();
        System.out.println("Contas encontradas: ");
        System.out.println("######################################################");
        for (Account account: accounts) {
            System.out.println(account.toString());
            System.out.println("---------------------------------------------------");
        }
        System.out.println("#########################################################");
    }

    public static void imprimir(){
        System.out.println(client.toString());
    }

    public static void dadosContaCriada(){
        System.out.println("Conta Criada com sucesso");
        System.out.println(accounts.get(accounts.size() - 1).toString());
        System.out.println("Voltando para o menu principal");
    }
}