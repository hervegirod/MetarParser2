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
 * @since 0.1
 */
public class MetarServiceTest {
   private static String metarEncoded = "LFPG 131830Z 19005KT 170V250 9999 -SHRA FEW040TCU SCT086 16/08 Q1011";
   private static String metarEncoded2 = "KMEM 230853Z AUTO 18014G18KT 10SM CLR 16/M02 A3008 RMK AO2 SLP117\n"
      + "     T01561022 TSNO $";

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
      MetarService service = MetarService.getInstance();
      Metar metar = service.decode(metarEncoded);

      Airport airport = metar.getAirport();
      assertEquals("Airport", "LFPG", airport.getIcao());

      LocalTime time = metar.getTime();
   }
}
