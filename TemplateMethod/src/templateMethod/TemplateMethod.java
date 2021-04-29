
package templateMethod;


import templateMethod.ProcessarBoletos;

public class TemplateMethod {

   
    public static void main(String[] args) {
   
         String nomeArquivoBradesco = "bradesco-1.csv";
         String nomeArquivoBB = "banco-brasil-1.csv";
         
         
    ProcessarBoletos processador = new ProcessarBoletos();
    processador.setLeituraRetorno(new LeituraRetornoBB());
        processador.processar(nomeArquivoBB);
        
         System.out.println("\n\n\n\n\n");
         
      processador.setLeituraRetorno(new LeituraRetornoBradesco());
        processador.processar(nomeArquivoBradesco);

        
    }
    
}
