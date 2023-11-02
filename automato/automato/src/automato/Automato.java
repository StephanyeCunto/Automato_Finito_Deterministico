package automato;

import classes.transicao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 14418115676
 */
public class Automato {

    private static int printOpcoes() {
        System.out.println("Escolha uma das opcoes para o conjunto L:");
        System.out.println();
        System.out.println("1. L = {w | w possua aa ou bb como subpalavra }");
        System.out.println("2. L = {w | entre dois a's de w, ha quantidade par de b's }");
        System.out.println("3. L = {w | w tenha aa ou aba, como subpalavra }");
        System.out.println("4. L = {w | entre dois b's de w, ha quantidade impar de a's }");
        System.out.print("Digite a opcao escolhida: ");
        Scanner Scanner=new Scanner(System.in);
        return (Scanner.nextInt());
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    transicao t=new transicao();
    switch (printOpcoes()) {
        case 1:
            t.loadTransicao("subPalavraaabb.csv");        
            t.imprimeTabela();
            t.fill();
            t.verificaCaracter("subPalavraaabb.csv");
            break;
        case 2:
            t.loadTransicao("doisaParb.csv");        
            t.imprimeTabela();
            t.fill();
            t.verificaCaracter("doisaParb.csv");
            break;
        case 3:
            t.loadTransicao("subPalavraaaaba.csv");        
            t.imprimeTabela();
            t.fill();
            t.verificaCaracter("subPalavraaaaba.csv");
            break;
        case 4:
            t.loadTransicao("doisbImpara.csv");        
            t.imprimeTabela();
            t.fill();
            t.verificaCaracter("doisbImpara.csv");
            break;
        default:
          System.out.println("Opção inválida.");
      }
    } 
}