package io.github.mivek.service;

import io.github.mivek.model.TAF;
import io.github.mivek.model.Wind;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;
import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.MessageLevel;

/**
 *
 * @author scdsahv
 */
public class TAFServiceFRTest {
   private static String tafEncoded = "TAF LFPG 150500Z 1506/1612 17005KT 6000 SCT012 \n"
      + "TEMPO 1506/1509 3000 BR BKN006 PROB40 \n"
      + "TEMPO 1506/1508 0400 BCFG BKN002 PROB40 \n"
      + "TEMPO 1512/1516 4000 -SHRA FEW030TCU BKN040 \n"
      + "BECMG 1520/1522 CAVOK \n"
      + "TEMPO 1603/1608 3000 BR BKN006 PROB40 \n"
      + "TEMPO 1604/1607 0400 BCFG BKN002 TX17/1512Z TN07/1605Z";

   public TAFServiceFRTest() {
   }

   @BeforeClass
   public static void setUpClass() {
      Messages.setLocale(Locale.FRENCH);
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
   public void testWindToString() throws Exception {
      System.out.println("TAFServiceFRTest : testWindToString");

      TAFService service = TAFService.getInstance();
      TAF taf = service.decode(tafEncoded);
      Wind wind = taf.getWind();

      String str = wind.getMessage(MessageLevel.COMPACT);
      assertEquals("vitesse 5 KT direction 170", str);

      str = wind.getMessage(MessageLevel.NORMAL);
      assertEquals("vitesse 5 KT direction 170", str);
   }
}
