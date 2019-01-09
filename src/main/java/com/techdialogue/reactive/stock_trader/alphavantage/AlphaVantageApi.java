package com.techdialogue.reactive.stock_trader.alphavantage;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AlphaVantageApi {

    private final HttpResponse.BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
    private final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL).proxy(ProxySelector.getDefault()).build();

    public Crypto getCurrentExchangeRate(String ticker) throws IOException, InterruptedException {

        var HTTP_REQUEST = HttpRequest.newBuilder()
                .uri(URI.create( //Set the appropriate endpoint
                        new StringBuilder(Common.ALPHAVATAGE_API_ENDPOINT)
                                .append("query?")
                                .append("&function=DIGITAL_CURRENCY_DAILY")
                                .append("&symbol=BTC")
                                .append("&market=GBP")
                                .append("&apikey=").append(Common.ALPHA_VANTAGE_API_KEY)
                                .toString() ) )
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .build();

        var HTTP_RESPONSE = HTTP_CLIENT.send(HTTP_REQUEST, asString);
        System.out.println(HTTP_RESPONSE);
        System.out.println("Body: "+HTTP_RESPONSE.body());
        return new Crypto();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        AlphaVantageApi api = new AlphaVantageApi();
        api.getCurrentExchangeRate("BTC");
    }
}
