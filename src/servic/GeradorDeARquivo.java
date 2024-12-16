package servic;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import records.REndereco;

public class GeradorDeARquivo {

    public void salvarJson(REndereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritaCep = new FileWriter(endereco.cep() + ".json");
        escritaCep.write(gson.toJson(endereco));
        escritaCep.close();
    }
}
