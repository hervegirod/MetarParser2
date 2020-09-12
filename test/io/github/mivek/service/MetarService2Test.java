package io.github.mivek.service;

import static org.junit.Assert.assertEquals;
import io.github.mivek.model.Metar;
import org.junit.After;
import org.junit.AfterClass;
import io.github.mivek.model.MessageLevel;
import io.github.mivek.model.Wind;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @since 0.1
 */
public class MetarService2Test {
   private static String metarEncoded = "KMEM 230853Z AUTO 18014G18KT 10SM CLR 16/M02 A3008 RMK AO2 SLP117\n"
      + "     T01561022 TSNO $";

   public MetarService2Test() {
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
   public void testWindToString() throws Exception {
      System.out.println("MetarService2Test : testWindToString");

      MetarService service = MetarService.getInstance();
      Metar metar = service.decode(metarEncoded);
      Wind wind = metar.getWind();

      String str = wind.getMessage(MessageLevel.COMPACT);
      assertEquals("speed 14 KT direction 180", str);

      str = wind.getMessage(MessageLevel.NORMAL);
      assertEquals("speed 14 KT direction 180 gusts 18", str);
   }
}
