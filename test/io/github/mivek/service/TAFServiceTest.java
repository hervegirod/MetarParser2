package io.github.mivek.service;

import io.github.mivek.model.Airport;
import io.github.mivek.model.TAF;
import io.github.mivek.model.TemperatureDated;
import io.github.mivek.model.Wind;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import io.github.mivek.model.MessageLevel;
import io.github.mivek.model.Visibility;

/**
 *
 * @since 0.4
 */
public class TAFServiceTest {
   private static String tafEncoded = "TAF LFPG 150500Z 1506/1612 17005KT CAVOK SCT012 \n"
      + "TEMPO 1506/1509 3000 BR BKN006 PROB40 \n"
      + "TEMPO 1506/1508 0400 BCFG BKN002 PROB40 \n"
      + "TEMPO 1512/1516 4000 -SHRA FEW030TCU BKN040 \n"
      + "BECMG 1520/1522 CAVOK \n"
      + "TEMPO 1603/1608 3000 BR BKN006 PROB40 \n"
      + "TEMPO 1604/1607 0400 BCFG BKN002 TX17/1512Z TN07/1605Z";

   public TAFServiceTest() {
   }

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
      tafEncoded = null;
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
      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);

      Airport airport = taf.getAirport();
      assertEquals("Airport", "LFPG", airport.getIcao());
   }

   /**
    * Test of decode method, of class TAFService.
    */
   @Test
   public void testToString() throws Exception {
      System.out.println("TAFServiceTest : testToString");
      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);

      String str = taf.toString();
      System.out.println(str);
   }

   /**
    * Test of decode method, of class TAFService.
    */
   @Test
   public void testToStringCompact() throws Exception {
      System.out.println("TAFServiceTest : testToStringCompact");
      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);

      String str = taf.getMessage(MessageLevel.COMPACT);
      System.out.println(str);
   }

   /**
    * Test of decode method, of class TAFService.
    */
   @Test
   public void testWindToString() throws Exception {
      System.out.println("TAFServiceTest : testWindToString");

      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);
      Wind wind = taf.getWind();

      String str = wind.getMessage(MessageLevel.COMPACT);
      assertEquals("speed 5 KT direction 170", str);

      str = wind.getMessage(MessageLevel.NORMAL);
      assertEquals("speed 5 KT direction 170", str);
   }

   /**
    * Test of decode method, of class TAFService.
    */
   @Test
   public void testTemperature() throws Exception {
      System.out.println("TAFServiceTest : testTemperature");

      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);
      TemperatureDated temp = taf.getMinTemperature();
      String str = temp.toString();
      assertEquals("temperature 7 °C day 16 at 5:00", str);
      str = temp.getMessage(MessageLevel.COMPACT);
      assertEquals("temperature 7 °C day 16 at 5:00", str);
   }

   /**
    * Test of decode method, of class TAFService.
    */
   @Test
   public void testVisibility() throws Exception {
      System.out.println("testVisibility : testVisibility");

      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);
      Visibility visi = taf.getVisibility();
      String str = visi.getMainVisibility();
      assertEquals("CAVOK", str);

      int visiInt = visi.getMainVisibilityMeters();
      assertEquals("Visivility", 10000, visiInt);
   }
}
