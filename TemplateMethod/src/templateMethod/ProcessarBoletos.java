
package templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ProcessarBoletos {

    private LeituraRetorno leituraRetorno;

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

     public ProcessarBoletos() {

    }
    
      public final List<Boleto> lerArquivo(String nomeArquivo) {

     try {
          List<Boleto> boletos = new ArrayList();
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = leituraRetorno.processarLinhaArquivo(vetor);
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }  
 
       
    }


    
      public void processar(String nomeArquivo ){
          List<Boleto> lista = lerArquivo(nomeArquivo);
          
          
          for (Boleto b : lista) {
            System.out.println(b);
        }
    }
    
}
