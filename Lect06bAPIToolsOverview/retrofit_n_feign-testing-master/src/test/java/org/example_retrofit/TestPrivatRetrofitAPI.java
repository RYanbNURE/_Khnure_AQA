package org.example_retrofit;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.example_feign.dto.ExchangeRateDTO;
import org.example_feign.dto.ExchangeRatesResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

/**
 * <p style="color: green; font-size: 1.5em">
 * Testing Privat24 exchange rates api using Retrofit framework</p>
 */
public class TestPrivatRetrofitAPI {

    private BasicApi basicApi;

    @Before
    public void init() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        basicApi = retrofit.create(BasicApi.class);
    }

    @SneakyThrows
    @Test
    public void checkThatExchangeRatesNotNull() throws IOException {
        ExchangeRatesResponse response;

        response = basicApi.getExchangeRates("01.12.2014").execute().body();

        response.exchangeRate.stream()
                .map(ExchangeRateDTO::toString)
                .forEach(Assert::assertNotNull);
    }

    @SneakyThrows
    @Test
    public void checkServerUnavailableError() throws IOException {
        int statusCode;

        statusCode = basicApi.getExchangeRates("01.12.2030").execute().code();
        Assert.assertEquals(500, statusCode);
        System.out.println(basicApi.getExchangeRates("01.12.2030").execute().message());
    }
}
