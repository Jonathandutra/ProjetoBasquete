
package projetobasquete;

import java.util.ArrayList;
import java.util.Scanner;
import projetobasquete.arquivo.ManipularArquivo;

public class ProjetoBasquete 
{
    
    

    public static void main(String[] args) 
    {
        ManipularArquivo aquivo = new ManipularArquivo();
        Scanner leitor = new Scanner(System.in);
        String jogador="";
              
        System.out.print("Digite um nome que deseja Guardar: ");
        jogador = leitor.nextLine();
        
        aquivo.gravarArquivo(jogador);   
        
        ArrayList <String> lista = new ArrayList();
        
        lista= aquivo.lerArquivoArray();
        
        for(int i=0;i < lista.size();i++)
        {
             System.out.println( i +"-"+lista.get(i));
        }
    }
}