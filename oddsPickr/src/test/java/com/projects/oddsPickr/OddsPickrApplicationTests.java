package com.projects.oddsPickr;

import com.projects.oddsPickr.service.OddsPickrServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
