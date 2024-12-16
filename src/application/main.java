package application;

import java.util.Scanner;

import records.REndereco;
import servic.GeradorDeARquivo;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsultaCep consultaCep = new ConsultaCep();

        String cep = "";
        try {

            while (cep.length() != 8) {
                System.out.print("\nCEP: ");
                cep = sc.nextLine();
            }

            REndereco novoEndereco = consultaCep.buscaEndereco(cep);

            GeradorDeARquivo gerador = new GeradorDeARquivo();

            gerador.salvarJson(novoEndereco);

            System.out.println(novoEndereco);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso...");
    }
}
