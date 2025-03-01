package org.example_feign;

import feign.Response;
import feign.RetryableException;
import org.example_feign.dto.ExchangeRateDTO;
import org.example_feign.dto.ExchangeRatesResponse;
import org.example_feign.dto.ExchangeTwoCurrencyDTO;
import org.example_feign.feign.PrivatBankApiClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class TestPrivatBankAPI {

    @Autowired
    public PrivatBankApiClient client;

    @BeforeEach
    public void setup() {
        /*client = Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(PrivatBankApiClient.class, "https://api.privatbank.ua");
        /**/
    }

    @Test
    public void getExchangeRates() {
        ExchangeRatesResponse response = client.getExchangeRatesPBAndNB("01.12.2014");
        System.out.println(response);
        response.exchangeRate.stream()
                .map(ExchangeRateDTO::toString)
                .forEach(Assert::assertNotNull);
    }

    @Test(expected = RetryableException.class)
    public void getError() {
        client.getExchangeRatesPBAndNB("");
    }

    @Test
    public void getResponse() throws IOException {
        Response response = client.getResponse("01.12.2014");
        Assert.assertEquals(200, response.status());
        Assert.assertFalse(new String(response.body().asInputStream().readAllBytes()).isEmpty());
        response = client.getResponse("");
        Assert.assertEquals(500, response.status());
        Assert.assertFalse(new String(response.body().asInputStream().readAllBytes()).isEmpty());
    }

    @Test
    public void getCurrentExchange() {
        List<ExchangeTwoCurrencyDTO> response = client.getExchangeCurrent(11);
        System.out.println(response.stream()
                .map(ExchangeTwoCurrencyDTO::toString)
                .collect(Collectors.joining("\n")));
        response.stream()
                .map(ExchangeTwoCurrencyDTO::toString)
                .forEach(Assert::assertNotNull);
    }
}
