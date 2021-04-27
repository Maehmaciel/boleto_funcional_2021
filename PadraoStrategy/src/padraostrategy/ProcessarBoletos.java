
package padraostrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ProcessarBoletos {
      public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Function<String,List<Boleto>> lerArquivo;

    public ProcessarBoletos(Function<String, List<Boleto>> lerArquivo) {
        this.lerArquivo = lerArquivo;
    }
     public ProcessarBoletos() {

    }
    public void setLerArquivo(Function<String, List<Boleto>> lerArquivo) {
         this.lerArquivo = lerArquivo;
    }
    
    
    //metodo ler Arquivo de leituraRetornoBancoBrasil
    public static List<Boleto> lerBancoBrasil(String nomeArquivo) {

           System.out.println("Arquivo do Banco do Brasil");
     try {
          List<Boleto> boletos = new ArrayList();
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);

                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }  
 
       
    }
    
    //metodo ler Arquivo de leituraBradesco
    public static List<Boleto> lerBradesco(String nomeArquivo) {
        System.out.println("Arquivo do Bradesco");
            try {
          List<Boleto> boletos = new ArrayList();
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);

                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(0, 0, 0));

                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }  
    
    }

    
      public void processar(String nomeArquivo ){
          List<Boleto> lista = lerArquivo.apply(nomeArquivo);
          
          
          for (Boleto b : lista) {
            System.out.println(b);
        }
    }
    
}
