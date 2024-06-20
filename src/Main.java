import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";

        List<Endereco> enderecos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o CEP do endereço ou sair: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://viacep.com.br/ws/" + busca.replace("-", "") + "/json/";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String jsonCorpo = response.body();

                Endereco cep = gson.fromJson(jsonCorpo, Endereco.class);
                System.out.println(cep.toString());

                SalvarArquivos salvarArquivos = new SalvarArquivos();
                salvarArquivos.salvaJson(cep);
            }
            catch (RuntimeException ex) {
                System.out.println("Aconteceu um erro");
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Programa finalizado corretamente");
    }
}
