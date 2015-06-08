
package projetobasquete;
// @author Jonathan Dutra
 import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 class MegaSena 
 {
    int a=0;
      
  int []sorteio ()
   {
    int [] sorte= new int[6];
    boolean repetido = false;
    
    for(int i = 0; (i < sorte.length);i++)
    {
      a= (int) Math.ceil(1 + Math.random()*60);
      for (int j=0; j <=i ; j++)
      {
          if (sorte[j]== a)
          {
              i--;
              repetido = true;
              break;
          }
              
      }
      
      if (!repetido)
      {
          if(i<0)
          {
              i = 0;
          }
          sorte[i]=a;
      }else
        {
            i--;
        }
      
      repetido = false;
      
    }   
    
    return sorte;
}
  

boolean repetido(int[] valor)
{
    boolean repetido = false;
    
    
    for(int i=0; i<valor.length; i++)
    {
        for(int j=i+1 ; j < valor.length ; j++)
        {
            if(valor[i]==valor[j])
            {
                return true;
            }
        }
    }
    
    return repetido;
}

boolean ganhador (int []aposta , int []jogo)
{
    a=0;
    for(int i=0; i < aposta.length;i++)
    {
        if(aposta[i]==jogo[i])
        {
            a++;
        }
    }
    if (a == 6)
    {
        return true;
    }else
    {
        return false;    
    }
}

    int[] ordem (int [] aposta)
{
    int controle;
    for (int i=0;i < aposta.length;i++)
    {
        for (int j = 0; j < aposta.length;j++)
        {
            if (aposta[i] < aposta[j])
            {
                controle = aposta[j];
                aposta[j]=aposta[i];
                aposta[i] = controle;
            }
        }
               
    }
   return aposta;
}

    String [] famaG (String ganhador , int classificacao)
    {
        try 
        {
            String conteudo = famaL();
            
            String texto = "<tr><td width=250 align='center'>"+ganhador +"</td><td width=250 align='center'>"+classificacao+"</td></tr>"+ conteudo;
            
            PrintWriter guardar = new PrintWriter(new File ("halloffame.txt"));
            
            guardar.println(texto);
                       
            guardar.close();
            
            
        }catch (Exception e)
        {
            System.out.println("Ocorreu um erro ");
        }
        
        
        
        return null;
    }
    
    String famaL ()
    {
        String texto = "";
        try {
            Scanner leitor = new Scanner(new FileReader("halloffame.txt")).useDelimiter("\\|");
            while(leitor.hasNext())
            {
                texto += leitor.next();
            }
            return texto;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MegaSena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
       /* BufferedReader cache = null;
        try
        {
            FileReader leitor = new FileReader("halloffame.txt");
            cache = new BufferedReader(leitor);
            String nome= "",linha="";
            
            while ((linha=cache.readLine())!=null)
                    {
                        if(linha.startsWith("Nome="))
                        {
                            nome=linha.substring(5,linha.length()-1);
                            return nome;
                        }
                        
                    }
            
            
            
        }catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "errou viado tenta de novo" +e);
        }
        */
        return null;
    }
    
    int cont (int [] jogo1, int [] jogo2 )
    {
       int [] jogo = ordem(jogo1);
       int [] aposta = ordem(jogo2);
       a=0;
    for(int i=0; i < aposta.length;i++)
    {
        if(aposta[i]==jogo[i])
        {
            a++;
        }
    }
        return a;
    }
 }


