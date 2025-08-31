package classes;

import java.io.*;
import java.util.*;
import lombok.*;

@NoArgsConstructor
@Data
public class Transicao {
    private int origem;
    private char letra;
    private int destino;
    private List<Transicao> lista;
    private String palavra;
    private char[] caracter;
    
    public void fill(){
        System.out.println("Digite uma palavra");
        try (Scanner scanner = new Scanner(System.in)) {
            this.palavra = scanner.nextLine();
        }
    }
   
    private void cvsParaAtributo(String csv){
       String vetor[]=csv.split(",");
       this.origem = Integer.parseInt(vetor[0]);
       this.letra = vetor[1].charAt(0);
       this.destino = Integer.parseInt(vetor[2]);
    }

    public void loadTransicao(String arquivo) throws FileNotFoundException, IOException{
        this.lista = new ArrayList<>();

        try (FileReader f = new FileReader(arquivo); Scanner arquivoLido = new Scanner(f)) {
            if (arquivoLido.hasNextLine()) arquivoLido.nextLine(); 
            while (arquivoLido.hasNextLine()) {
                String linha = arquivoLido.nextLine().replaceAll("q", "").replaceAll("f", "-1");
                Transicao t = new Transicao();
                t.cvsParaAtributo(linha);
                lista.add(t);
            }
        }
    }
   
    public void imprimeTabela() {
        System.out.println("Lista de transicoes:");
        System.out.printf("+------------+------------+------------+\n");
        System.out.printf("|   Origem   |   Letra    |  Destino   |\n");
        System.out.printf("+------------+------------+------------+\n");

        for (Transicao t : lista) {
            if(t.destino!=-1) System.out.printf("| q%-10d| %10c | q%-10d|\n",t.origem,t.letra,t.destino);
            else System.out.printf("| q%-10d| %10c | %-10s |\n",t.origem,t.letra,"qf");
            System.out.printf("+------------+------------+------------+\n");
        }
    }
    
    private int encontrarTransicao(int origemPalavra,char letraPalavra){
        for (Transicao t : lista) if(t.origem==origemPalavra && t.letra==letraPalavra && t.destino!=-1) return t.destino;
        return -1;
    }
    
    private boolean verificaEstado(int estadoFinalPalavra){
        for (Transicao t : lista)  if(estadoFinalPalavra==t.origem && t.destino==-1) return true;
        return false;
    }

    public boolean verificaCaracter() {
        int estadoAtual = 0; 
        for (char c : palavra.toCharArray()) {
            estadoAtual = encontrarTransicao(estadoAtual, c);
            System.out.println("Caractere: '" + c + "' -> Estado: " + (estadoAtual == -1 ? "INVÁLIDO" : estadoAtual));
            if (estadoAtual == -1) return false;           
        }
        return verificaEstado(estadoAtual);
    }
}   