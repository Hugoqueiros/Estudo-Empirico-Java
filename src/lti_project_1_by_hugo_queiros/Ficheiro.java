
package lti_project_1_by_hugo_queiros;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Ficheiro {

    public static BufferedReader fr;
    public static BufferedWriter fw;

    public static void criaFicheiro(String nomeDoFicheiro) throws IOException {
        File f = new File(nomeDoFicheiro);
    }

    public static void abreLeitura(String nomeDoFicheiro) throws IOException {
        fr = new BufferedReader(new FileReader(nomeDoFicheiro));
    }

    public static void abreEscrita(String nomeDoFicheiro) throws IOException {
        fw = new BufferedWriter(new FileWriter(nomeDoFicheiro));
    }

    public static void fechaEscrita() throws IOException {
        fw.close();
    }

    public static void escreveValores(String linha, String coluna) throws IOException {
        fw.write(linha);
        fw.write(";");
        fw.write(coluna);
        fw.newLine();
    }
}
