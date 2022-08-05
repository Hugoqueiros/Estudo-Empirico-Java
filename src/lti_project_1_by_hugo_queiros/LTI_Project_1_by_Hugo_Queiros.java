package lti_project_1_by_hugo_queiros;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.lang.*;

public class LTI_Project_1_by_Hugo_Queiros {

    public static void main(String[] args) throws IOException {

        Scanner leia = new Scanner(System.in);
        Random aleatorio = new Random();
        //nome dado ao ficheiro excel no tipo csv
        String f = "lti_project_1_by_hugo_queiros.csv";
        int menor = 0, maior, n = 2;
        //declaração das variaveis do tempo de ordenação
        double t_inicial, t_final, t, tempo_inicial, tempo_final, tempo;
        //vetor dos números que são gerados automaticamente
        int numero_aleatorio[] = new int[n];
        boolean n_contido = false;
        Ficheiro.criaFicheiro(f);
        Ficheiro.abreEscrita(f);
        //iniciação da pesquisa linear
        System.out.println("|PESQUISA LINEAR|");
        //vetor vai variar os valores desde o 2 até 131073 através de uma operação realizada após a finalização do processo para que se obtenha até ao número pretendido
        while (n < 131073) {
            numero_aleatorio = new int[n];
            //gerador de números aleatórios até ao número 100
            for (int i = 0; i < numero_aleatorio.length; i++) {
                numero_aleatorio[i] = aleatorio.nextInt(100);
            }
            System.out.println("\nNÚMEROS ALEATÓRIOS FORAM GERADOS");
            System.out.println("ORDENAÇÃO DOS NÚMEROS GERADOS: ");
            //início da contagem do tempo de execução da ordenação
            t_inicial = System.nanoTime();
            //processo de ordenação
            for (int i = 0 ;i< numero_aleatorio.length -1; i++){
                int min = i;
                for (int j = i + 1; j< numero_aleatorio.length ; j++){
                    if (numero_aleatorio[j] < numero_aleatorio[min]){
                        min = j;
                    }
                }
                int temp = numero_aleatorio[min];
                numero_aleatorio [min] = numero_aleatorio[i];
                numero_aleatorio [i] = temp;
            }
            for (int i = 0 ; i < numero_aleatorio.length ; i++){
                System.out.print("\n" + numero_aleatorio[i]);
            }
            //finalizado o processo de ordenação damos por concluído respetivo tempo final
            t_final = System.nanoTime();
            int posicao = 0, numero_pesquisa;
            System.out.println("\nDIGITE O NÚMERO PELO QUAL PRETENDE PESQUISAR: ");
            numero_pesquisa = leia.nextInt();
            //processo da pesquisa linear
            tempo_inicial = System.nanoTime();
            while (posicao < numero_aleatorio.length && numero_aleatorio[posicao] != numero_pesquisa) {
                posicao++;
            }
            tempo_final = System.nanoTime();
            if (posicao == n) {
                System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
            } else {
                System.out.println("\nO NÚMERO " + numero_pesquisa + " ESTÁ NA  " + posicao + "ª POSIÇÃO.");
            }
            //calcula o tempo de execução da ordenação
            t = t_final - t_inicial;
            tempo = tempo_final - tempo_inicial;
            System.out.println("\nO TEMPO DE EXECUÇÃO FOI DE " + t + " x 10^-9 SEGUNDOS");
            //passagem dde valores do NetBeans para o ficheiro Excel
            /*String escreveTamanho_Array = "" + numero_aleatorio.length;
            String escreveTempo_Ordenacao = "" + t;*/
            String escreveTamanho_Pesquisa = "" + numero_aleatorio.length;
            String escreveTempo_Pesquisa = "" + tempo;
            //Ficheiro.escreveValores(escreveTamanho_Array, escreveTempo_Ordenacao);
            Ficheiro.escreveValores(escreveTamanho_Pesquisa, escreveTempo_Pesquisa);
            //operação realizada para obtenção de novos tamanhos para o vetor
            n = n * 2;
        }
        
        //referir que o valor n seja igual a 2 para que na pesquisa binária recomeçe com esse valor
        n = 2;
        System.out.println("\n|PESQUISA BINÁRIA|");
        //gerador de números aleatórios até ao número 100
        while (n < 131073) {
            numero_aleatorio = new int[n];
            for (int i = 0; i < numero_aleatorio.length; i++) {
                numero_aleatorio[i] = aleatorio.nextInt(100);
            }
            System.out.println("\nNÚMEROS ALEATÓRIOS FORAM GERADOS");
            System.out.println("ORDENAÇÃO DOS NÚMEROS GERADOS:");
            //início da contagem do tempo de execução da ordenação
            t_inicial = System.nanoTime();
            //processo de ordenação
            for (int i = 0; i < numero_aleatorio.length; i++) {
                for (int j = i + 1; j < numero_aleatorio.length; j++) {
                    if (numero_aleatorio[i] > numero_aleatorio[j]) {
                        int z = numero_aleatorio[i];
                        numero_aleatorio[i] = numero_aleatorio[j];
                        numero_aleatorio[j] = z;
                    }
                }
                System.out.println(numero_aleatorio[i]);
            }
            //finalizado o processo de ordenação damos por concluído respetivo tempo final
            t_final = System.nanoTime();
            System.out.println("\nDIGITE O NÚMERO PELO QUAL PRETENDE PESQUISAR: ");
            int numero_pesquisa = leia.nextInt();
            maior = numero_aleatorio.length - 1;
            //processo da pesquisa binária
            tempo_inicial = System.nanoTime();
            for (int i = 0; i < numero_aleatorio.length; i++) {
                if (numero_aleatorio[i] == numero_pesquisa) {
                    while (menor <= maior) {
                        int valor_medio = (menor + maior) / 2;
                        if (numero_aleatorio[valor_medio] > 0) {
                            maior = valor_medio - 1;
                            System.out.println("\nO NÚMERO " + numero_pesquisa + " APRESENTA-SE NA  " + i + "ª POSIÇÃO.");
                            //afirma que há no vetor o número digitado
                            n_contido = true;
                            break;
                        } else if (numero_aleatorio[valor_medio] == 0) {
                            System.out.println("\nO NÚMERO " + numero_pesquisa + " ESTÁ NA  " + i + "ª POSIÇÃO.");
                            //afirma que há no vetor o número digitado
                            n_contido = true;
                            break;
                        } else {
                            menor = valor_medio + 1;
                            System.out.println("\nO NÚMERO " + numero_pesquisa + " ESTÁ NA  " + i + "ª POSIÇÃO.");
                            //afirma que há no vetor o número digitado
                            n_contido = true;
                            break;
                        }
                    }
                }
            }tempo_final = System.nanoTime();
            //caso o número não esteja contido no vetor
            if (n_contido == false) {
                System.out.println("O NÚMERO PELO QUAL TENTOU PESQUISAR NÃO SE ENCONTRA CONTIDO NO VETOR\nTENTE NOVAMENTE");
            }
            tempo = tempo_final - tempo_inicial;
            //calcula o tempo de execução da ordenação
            t = t_final - t_inicial;
            System.out.println("\nO TEMPO DE EXECUÇÃO FOI DE " + t + " x 10^-9 SEGUNDOS");
            //passagem dde valores do NetBeans para o ficheiro Excel
            /*String escreveTamanho_Array = "" + numero_aleatorio.length;
            String escreveTempo_Ordenacao = "" + t;
            Ficheiro.escreveValores(escreveTamanho_Array, escreveTempo_Ordenacao);*/
            //operação realizada para obtenção de novos tamanhos para o vetor
            String escreveTamanho_Pesquisa = "" + numero_aleatorio.length;
            String escreveTempo_Pesquisa = "" + tempo;
            Ficheiro.escreveValores(escreveTamanho_Pesquisa, escreveTempo_Pesquisa);
            n = n * 2;
        }
        System.out.println("\nPROGRAMA FINALIZADO!");
        System.out.println("ABRIR EXCEL E VERIFIQUE OS RESULTADOS");
        Ficheiro.fechaEscrita();
    }

}
