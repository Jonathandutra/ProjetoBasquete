package projetobasquete.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    File jogador = new File("jogador.txt");

    public void gravarArquivo(String tex) {
          
        try {
               if (!jogador.exists())
        {
            jogador.createNewFile();
        }
            
            String conteudo = lerArquivo();
            
            String texto = "<tr><td width=250 align='center'>"+tex +"</td> </tr>"+ conteudo;
            
            PrintWriter guardar = new PrintWriter(jogador);
            
            guardar.println(texto);
                       
            guardar.close();

            JOptionPane.showMessageDialog(null, "Cadasro Realizado com Sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerArquivo() {
       
        String texto = "";
        
        try {
            Scanner leitor = new Scanner(new FileReader(jogador)).useDelimiter("\\|");
            while(leitor.hasNext())
            {
                texto += leitor.next();
            }
            return texto;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally
        {
            return  texto;
        }
    }

}
