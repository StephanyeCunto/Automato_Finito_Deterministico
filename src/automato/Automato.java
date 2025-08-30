package automato;

import classes.Transicao;
import java.io.*;
import java.util.*;
public class Automato {
    private static final Map<Integer, String> OPCOES = Map.of(
        1, "src/transicoes/subPalavraaabb.csv",
        2, "src/transicoes/doisaParb.csv",
        3, "src/transicoes/subPalavraaaaba.csv",
        4, "src/transicoes/doisbImpara.csv",
        5, "src/transicoes/testeEntrega.csv"
    );

    private static int printOpcoes() {
        System.out.println("Escolha uma das opcoes para o conjunto L:");
        System.out.println();
        System.out.println("1. L = {w | w possua aa ou bb como subpalavra }");
        System.out.println("2. L = {w | entre dois a's de w, ha quantidade par de b's }");
        System.out.println("3. L = {w | w tenha aa ou aba, como subpalavra }");
        System.out.println("4. L = {w | entre dois b's de w, ha quantidade impar de a's }");
        System.out.println("5. L = {Automato para teste}");
        System.out.print("Digite a opcao escolhida: ");
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }

    private static void executarAutomato(Transicao t,String endereco)throws FileNotFoundException, IOException{
        t.loadTransicao(endereco);        
        t.imprimeTabela();
        t.fill();
        if(t.verificaCaracter()) System.out.println("Palavra aceita");
        else System.out.println("Palavra nao aceita");
    }


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Transicao t=new Transicao();
        executarAutomato(t,OPCOES.get(printOpcoes()));
    }
}