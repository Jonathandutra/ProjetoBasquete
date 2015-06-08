package projetobasquete;

import java.util.ArrayList;
import java.util.Scanner;
import projetobasquete.arquivo.ManipularArquivo;

public class ProjetoBasquete {

    public static void main(String[] args) {

        ManipularArquivo aquivo = new ManipularArquivo();
        Scanner leitor = new Scanner(System.in);
        String jogador = "";
        int op = 1000;
do{
        System.out.println("====================| Menu Projeto Basquete |====================");
        System.out.println("\t 1-Cadastrar \t\t 2-Listar Jogadores");
        System.out.println("\t 3-Excluir \t\t 4- Atualizar");
        System.out.println("\t 5-Sair");
        System.out.print("Escolha uma opcao:");

        op = leitor.nextInt();
        leitor.nextLine();

        switch (op) 
        {
            case 1:
                System.out.print("Digite um nome do Jogador: ");
                jogador = leitor.nextLine().trim();
                if(!jogador.trim().isEmpty())
                {
                aquivo.gravarArquivo(jogador);
                }else
                {
                    System.out.println("Digite um Nome");
                }
                break;
            case 2:
                ArrayList<String> lista = new ArrayList();
                lista = aquivo.lerArquivoArray();
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(i + "-" + lista.get(i));
                }
                leitor.nextLine();            
            break;
            case 3:

            default:
                System.out.println("Opcao invalida\n \t Digite: Q - Sair D C- Voltar ao Menu");

                if (leitor.nextLine().toUpperCase().charAt(0) == 'Q') {
                    op = 5;
                }
                break;
        }

    }
while(op!=5);
}
}
