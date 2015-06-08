package projetobasquete.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    File jogador = new File("jogador.txt");

    public void gravarArquivo(String texto) {
        try {

            PrintWriter cadastroJogador = new PrintWriter(jogador);
      
            cadastroJogador.printf(texto +" \n" );
            
            cadastroJogador.close();

            JOptionPane.showMessageDialog(null, "Cadasro Realizado com Sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerArquivo() {
        String listadeJogadores=" ";
        FileReader LerAquivo;
        String linha="";
        BufferedReader temporario = null;
       
        try {
         LerAquivo = new FileReader(jogador);
               
          temporario= new BufferedReader(LerAquivo);

             while((linha = temporario.readLine())!= null) {
               
              listadeJogadores += linha;
            }

            LerAquivo.close();
            temporario.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipularArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return listadeJogadores;
        }

    }

}
