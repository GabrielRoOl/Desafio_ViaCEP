package application;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        String cep = "";

        while (cep.length() != 8) {
            System.out.print("CEP: ");
            cep = sc.nextLine();
        }

        try {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
                    .create();
            String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println("\n" + json);

            FileWriter escritaJson = new FileWriter("copiaCep.json");
            FileWriter escritaTxt = new FileWriter("copia.txt");

            escritaJson.write(gson.toJson(json));
            escritaTxt.write(gson.toJson(json));

        } catch (Exception e) {
            e.getMessage();
        } finally {
            sc.close();
        }
        System.out.println("\n\nPrograma finalizado com sucesso...");
    }
}
