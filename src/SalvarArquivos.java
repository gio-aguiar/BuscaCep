import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class SalvarArquivos {

    public void salvaJson(Endereco endereco) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.getCep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
