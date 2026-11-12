package utils;

import java.io.IOException;
import java.util.Scanner;

public class MenuPadrao {

    public static final Scanner sc = new Scanner(System.in);

    public static void limparTela() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("O comando retornou um erro:" + e);
        }
    }

    public static void esperarEnter(){
        System.out.printf("Digite qualquer tecla para continuar...");
        sc.nextLine();
    }

    private static void exibirItens(String[] itens){
        for(int i = 0; i < itens.length; i++){
            System.out.printf("%d - %s\n", i+1, itens[i]);
        }
    }

    public static int exibirMenu(String titulo, String[] itens, boolean sair){
        limparTela();
        System.out.println("=".repeat(titulo.length()));
        System.out.println(titulo);
        System.out.println("=".repeat(titulo.length()));

        exibirItens(itens);
        System.out.println(sair ? "* - Sair" : "* - Voltar");
        System.out.print("\nEscolha uma opção: ");


        String linha = sc.nextLine().trim();

        try {
            return Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
