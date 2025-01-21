package conversor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ApiService {

    private static final String BASE_URL = Config.getApiUrl();
    private static final String API_KEY = Config.getApiKey();

    // Lista de monedas admitidas para validación previa
    private static final List<String> MONEDAS_VALIDAS = Arrays.asList(
            "USD", "EUR", "GBP", "JPY", "MXN", "CAD", "BRL", "ARS", "COP", "CHF", "AUD", "CNY"
    );

    public static double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        // Validar las monedas antes de hacer la solicitud
        if (!esMonedaValida(monedaOrigen) || !esMonedaValida(monedaDestino)) {
            System.out.println("⚠️ Moneda inválida. Use códigos como USD, EUR, MXN, etc.");
            return -1;
        }

        // Construcción de la URL de la API
        String url = BASE_URL + API_KEY + "/latest/" + monedaOrigen;
        System.out.println("🔍 URL generada: " + url);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            // Manejar la respuesta HTTP
            if (response.getCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonResponse = mapper.readTree(response.getEntity().getContent());

                if (jsonResponse.has("conversion_rates") && jsonResponse.get("conversion_rates").has(monedaDestino)) {
                    double tasaCambio = jsonResponse.get("conversion_rates").get(monedaDestino).asDouble();
                    System.out.printf("💱 Tasa obtenida: 1 %s = %.2f %s\n", monedaOrigen, tasaCambio, monedaDestino);
                    return tasaCambio;
                } else {
                    System.out.println("⚠️ La moneda de destino '" + monedaDestino + "' no fue encontrada.");
                    return -1;
                }
            } else if (response.getCode() == 404) {
                System.out.println("❌ Error 404: URL no encontrada. Verifique su API Key y la URL.");
            } else {
                System.out.println("❌ Error en la solicitud: Código " + response.getCode());
            }
        } catch (IOException e) {
            System.out.println("❌ Error al conectar con la API: " + e.getMessage());
        }

        return -1;
    }

    // Método para validar si la moneda ingresada es válida
    private static boolean esMonedaValida(String moneda) {
        return MONEDAS_VALIDAS.contains(moneda.toUpperCase());
    }
}
