
package padraostrategy;

public class PadraoStrategy {

   
    public static void main(String[] args) {
   
         String nomeArquivoBradesco = "bradesco-1.csv";
         String nomeArquivoBB = "banco-brasil-1.csv";
         
         
    ProcessarBoletos processador = new ProcessarBoletos();
    processador.setLerArquivo(ProcessarBoletos::lerBancoBrasil);
        processador.processar(nomeArquivoBB);
        
         System.out.println("\n\n\n\n\n");
         
     processador.setLerArquivo(ProcessarBoletos::lerBradesco);
        processador.processar(nomeArquivoBradesco);
        
    }
    
}
