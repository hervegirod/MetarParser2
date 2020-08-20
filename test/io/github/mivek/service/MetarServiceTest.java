/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mivek.service;

import io.github.mivek.model.Airport;
import io.github.mivek.model.Metar;
import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author scdsahv
 */
public class MetarServiceTest {

    public MetarServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of decode method, of class MetarService.
     */
    @Test
    public void testDecode() throws Exception {
        System.out.println("MetarServiceTest : testDecode");
        String code = "LFPG 131830Z 19005KT 170V250 9999 -SHRA FEW040TCU SCT086 16/08 Q1011";
        MetarService service = MetarService.getInstance();
        Metar metar = service.decode(code);
        
        Airport airport = metar.getAirport();
        assertEquals("Airport", "LFPG", airport.getIcao());
        
        LocalTime time = metar.getTime();
    }
}
