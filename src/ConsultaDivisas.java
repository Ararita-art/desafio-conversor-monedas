import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsultaDivisas {
    private static final String API_KEY = "507e245e42716742c0f1c331";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    private static final JsonParser jsonParser = new JsonParser();

    public Divisas solicitaDivisas(String divisaVenta, String divisaCompra) {
        URI direccion = URI.create(BASE_URL + API_KEY + "/pair/" + divisaVenta + "/" + divisaCompra);

        HttpRequest consulta = HttpRequest.newBuilder()
                .uri(direccion)
                .timeout(Duration.ofSeconds(10))
                .build();

        try {
            HttpResponse<String> respuesta = httpClient.send(consulta, HttpResponse.BodyHandlers.ofString());

            if (respuesta.statusCode() != 200) {
                throw new RuntimeException("Se produjo un error en la API: Código " + respuesta.statusCode());
            }

            JsonElement jsonElement = jsonParser.parse(respuesta.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String baseCode = jsonObject.get("base_code").getAsString();
            String targetCode = jsonObject.get("target_code").getAsString();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();

            return new Divisas(baseCode, targetCode, conversionRate);

        } catch (Exception e) {
            throw new RuntimeException("Se produjo un error en el proceso de consulta de divisas: "  + e.getMessage());
        }
    }
}