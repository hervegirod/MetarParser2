/*------------------------------------------------------------------------------
 * Copyright (C) 2020 Herve Girod
 *
 * Distributable under the terms of either the Apache License (Version 2.0) or
 * the GNU Lesser General Public License, as specified in the COPYING file.
 ------------------------------------------------------------------------------*/
package io.github.mivek.internationalization;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @since 0.1
 */
public class MessageConstructorTest {
   
   public MessageConstructorTest() {
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
    * Test of getText method, of class MessageConstructor.
    */
   @Test
   public void testGetText() {
      System.out.println("MessageConstructorTest : testGetText");
      String result = MessageConstructor.getText("my {1} cents", 2);
      assertEquals("my 2 cents", result);
   }
   
   /**
    * Test of getText method, of class MessageConstructor.
    */
   @Test
   public void testGetText2() {
      System.out.println("MessageConstructorTest : testGetText2");
      String result = MessageConstructor.getText("my {1} or {2} cents", 2, 4);
      assertEquals("my 2 or 4 cents", result);
   }   
   
   /**
    * Test of getText method, of class MessageConstructor.
    */
   @Test
   public void testGetText3() {
      System.out.println("MessageConstructorTest : testGetText2");
      String result = MessageConstructor.getText("my {1} friend", "great");
      assertEquals("my great friend", result);
   }      
   
}
