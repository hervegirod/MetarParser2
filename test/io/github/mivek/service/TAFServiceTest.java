/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mivek.service;

import io.github.mivek.model.Airport;
import io.github.mivek.model.TAF;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author scdsahv
 */
public class TAFServiceTest {

    public TAFServiceTest() {
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
     * Test of decode method, of class TAFService.
     */
    @Test
    public void testDecode() throws Exception {
        System.out.println("TAFServiceTest : testDecode");
        String message = "TAF LFPG 150500Z 1506/1612 17005KT 6000 SCT012 \n"
                + "TEMPO 1506/1509 3000 BR BKN006 PROB40 \n"
                + "TEMPO 1506/1508 0400 BCFG BKN002 PROB40 \n"
                + "TEMPO 1512/1516 4000 -SHRA FEW030TCU BKN040 \n"
                + "BECMG 1520/1522 CAVOK \n"
                + "TEMPO 1603/1608 3000 BR BKN006 PROB40 \n"
                + "TEMPO 1604/1607 0400 BCFG BKN002 TX17/1512Z TN07/1605Z";
        TAFService service = TAFService.getInstance();
        TAF taf = service.decode(message);
        
        Airport airport = taf.getAirport();
        assertEquals("Airport", "LFPG", airport.getIcao());        
    }

}
