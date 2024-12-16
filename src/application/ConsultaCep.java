package application;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import records.REndereco;

public class ConsultaCep {

    public REndereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), REndereco.class);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;

    }
}
