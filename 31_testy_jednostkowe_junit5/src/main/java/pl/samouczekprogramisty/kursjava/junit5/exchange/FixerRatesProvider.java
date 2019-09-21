package pl.samouczekprogramisty.kursjava.junit5.exchange;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class FixerRatesProvider implements RatesProvider {

    private static final String API_URL_TEMPLATE = "http://data.fixer.io/api/latest?access_key=%s&base=%s&symbols=%s";

    private static final int SCALE = 4;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private final String apiKey;
    private final Jsonb jsonb;

    public static class FixerResponse {
        private Boolean success;
        private Long timestamp;
        private Currency base;
        private LocalDate date;
        private Map<String, BigDecimal> rates;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public Currency getBase() {
            return base;
        }

        public void setBase(Currency base) {
            this.base = base;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Map<String, BigDecimal> getRates() {
            return rates;
        }

        public void setRates(Map<String, BigDecimal> rates) {
            this.rates = rates;
        }
    }

    private class HttpConnection implements Closeable {
        private final HttpURLConnection connection;

        private HttpConnection(Currency from, Currency to) {
            try {
                URL url = new URL(String.format(API_URL_TEMPLATE, apiKey, from, to));
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private String getResponse() {
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return response.toString();
        }

        @Override
        public void close() {
            connection.disconnect();
        }
    }

    public FixerRatesProvider(String apiKey) {
        this(apiKey, JsonbBuilder.create());
    }

    public FixerRatesProvider(String apiKey, Jsonb jsonb) {
        this.apiKey = apiKey;
        this.jsonb = jsonb;
    }

    @Override
    public BigDecimal getRate(Currency from, Currency to) {
        try (HttpConnection connection = new HttpConnection(from, to)) {
            String textResponse = connection.getResponse();
            FixerResponse response = jsonb.fromJson(textResponse, FixerResponse.class);
            return response.rates.get(to.toString()).setScale(SCALE, ROUNDING_MODE);
        }
    }

    public static void main(String[] args) {
        FixerRatesProvider rates = new FixerRatesProvider(args[0]);
        BigDecimal rate = rates.getRate(Currency.EUR, Currency.PLN);
        System.out.println(rate);
    }
}
