package service;

import model.Client;
import model.ClientePF;
import model.ClientePJ;

import java.util.Scanner;

public class ClientService {
    static Scanner scanner = new Scanner(System.in);
    private static String lerString(String mensagem){
        System.out.println("Digite " + mensagem + ": ");
        return scanner.nextLine();
    }

    public static String validaString(String mensagem, int tamanho){
        String stringLeitura;
        do{
            stringLeitura = lerString(mensagem).trim();
            if(stringLeitura.length() < tamanho){
                System.out.println(mensagem + " deve ter pelo menos " + tamanho + " caracteres");
            }
        }while (stringLeitura.length() < tamanho);

        return stringLeitura;
    }

    public static int lerTipoCliente(){
        int tipo;
        do {
            System.out.println("Digite 1 para PF ou 2 para PJ");
            tipo = scanner.nextInt();
            scanner.nextLine();
            if(tipo != 1 && tipo != 2){
                System.out.println("Tipo Invalido. Tente novamente");
            }
        }while (tipo != 1 && tipo != 2);
        return tipo;
    }

    public static double lerValue(String mensagem){
        double value;
        do {
            System.out.println("Digite o valor para" + mensagem);
            value = scanner.nextDouble();
            scanner.nextLine();
            if(value < 0){
                System.out.println("Valor Invalido. Tente novamente");
            }
        }while (value <  0);

        return value;
    }

    static public Client criarCliente(){
        int tipo = lerTipoCliente();
        if(tipo == 1){
            return new ClientePF(validaString("o nome do cliente", 5), validaString("CPF", 11));
        }else{
            return new ClientePJ(validaString("o nome do cliente", 5), validaString("cnpj", 14));
        }
    }

    public static void imprimir(Client client){
        System.out.println(client.toString());
    }


}
