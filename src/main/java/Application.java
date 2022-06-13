import model.Client;
import service.ClientService;

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
        optionMenu = menuPrincipal();
        CriarConta();
        imprimir();


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

    public static int menuPrincipal(){
        List<Integer> opcoes = new ArrayList<Integer>();
        opcoes.add(1);
        opcoes.add(2);
        opcoes.add(3);
        int opcao;
        do {
            System.out.println("##################################################");
            System.out.println("###### - Banco BB Lets-Code seja bem vindo - ######");
            System.out.println("##################################################");
            System.out.println("###### -     Opções Disponíveis           - ######");
            System.out.println("###### -     1 - Abri Conta               - ######");
            System.out.println("###### -     2 - listar Contas            - ######");
            System.out.println("###### -     3 - Realizar Operação        - ######");
            System.out.println("###### -     4 - encerrar                 - ######");
            System.out.println("##################################################");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcoes.contains(opcao)){
                selectedMenu(opcao);
            }

            if (!opcoes.contains(opcao) && opcao != 4){
                System.out.println("Opção invalida tente novamente");
            }
        }while (opcao != 4);

        return opcao;
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
                realizarOperacoesContas();
                break;
            case 4:
                System.exit(0);
            default:
                menuPrincipal();
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
            System.out.println("###### -     Banco BB Lets-Code seja bem vindo     - ######");
            System.out.println("##################################################");
            System.out.println("digite 1 para conta corrente ou 2 para investimento");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(!opcoes.contains(opcao)){
                System.out.println("tipo de conta escolhido não disponível! Tente novamente.");
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
            System.out.println("###### -     Banco BB Lets-Code seja bem vindo     - ######");
            System.out.println("##################################################");
            System.out.println("digite 1 para conta corrente, 2 para conta investimento ou 3 para Poupança");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if(!opcoes.contains(opcao)){
                System.out.println("tipo de conta escolhido não disponível! Tente novamente.");
            }

        }while (!opcoes.contains(opcao));
    }

    public static void criarConta(int tipoConta){

    }

    public static void listarContas(){
        imprimir();
        System.out.println("Contas encontradas: ");
        System.out.println("######################################################");
        for (Account account: accounts) {
            account.toString();
            System.out.println("---------------------------------------------------");
        }
        System.out.println("#########################################################");
    }

    public static void imprimir(){
        System.out.println(client.toString());
    }

    public static void realizarOperacoesContas(){

    }
}