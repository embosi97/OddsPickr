package com.projects.oddsPickr;

import com.projects.oddsPickr.service.OddsPickrServiceImpl;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OddsPickrApplicationTests {

    @Autowired
    public OddsPickrServiceImpl service;

    @Test
    void usdToGBPTest() {
        assertTrue(service.convertPayoutCurrency(555, "2.04", "USD", "GBP") > 555);
    }

    @Test
    void currencyGBPToStringTest() {
        assertEquals(service.payoutAsString(555, "GBP"), "£555.0");
    }

    @Test
    void parseJsonArrayTest() {
        assertFalse(service.getAllOdds(new JSONArray("[{\"markets\":[{\"outcomes\":[{\"price\":1.61,\"name\":\"Team A\"},{\"price\":5.2,\"name\":\"Team B\"},{\"price\":4.2,\"name\":\"Draw\"}],\"last_update\":\"2024-01-11T01:11:11Z\",\"key\":\"h2h\"}],\"last_update\":\"2024-01-13T04:29:15Z\",\"title\":\"FanDuel\",\"key\":\"fanduel\"}]")).isEmpty());
    }

}
