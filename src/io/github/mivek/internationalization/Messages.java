package io.github.mivek.internationalization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Messages class for internationalization.
 *
 * @author mivek
 * @author girod
 */
public final class Messages {
   /**
    * The singleton instance.
    */
   private static final Messages INSTANCE = new Messages();
   /**
    * Name of the bundle.
    */
   private static final String BUNDLE_NAME = "internationalization.messages"; //$NON-NLS-1$
   /**
    * Bundle variable.
    */
   private ResourceBundle fResourceBundle;
   private final Map<String, String> messages = new HashMap<>();

   /**
    * Private constructor.
    */
   private Messages() {
      initialize("messages_en.properties");
   }

   private void initialize(String name) {
      messages.clear();
      InputStream stream;
      try {
         stream = this.getClass().getResource(name).openStream();
         fResourceBundle = new PropertyResourceBundle(stream);
         initialize();
      } catch (IOException ex) {
      }
   }

   /**
    * @return the Messages instance.
    */
   public static Messages getInstance() {
      return INSTANCE;
   }

   /**
    * Sets the locale of the bundle.
    *
    * @param locale the locale to set.
    */
   public static void setLocale(final Locale locale) {
      INSTANCE.setLocaleImpl(locale);
   }

   private void setLocaleImpl(final Locale locale) {
      String lang = locale.getLanguage();
      switch (lang) {
         case "en":
            initialize("messages_en.properties");
            break;
         case "fr":
            initialize("messages_fr.properties");
            break;
         case "de":
            initialize("messages_de.properties");
            break;
      }
   }

   /**
    * Initialize the bundle with a specified URL.
    *
    * @param url the URL used for the bundle creation
    */
   private void initialize() {
      Enumeration<String> it = fResourceBundle.getKeys();
      while (it.hasMoreElements()) {
         String key = it.nextElement();
         String message = fResourceBundle.getString(key);
         messages.put(key, message);
      }
   }

   /**
    * Return a String.
    *
    * @param key the string key to get
    * @return the translation of message
    */
   public String getString(final String key) {
      if (messages.containsKey(key)) {
         return messages.get(key);
      } else {
         // we will go there if the user code has set a wrong key for the message
         return "Undefined message for key " + key;
      }
   }

   /**
    * Return a message with variables. This is valid for messages in the list with variables declaration. A key
    * which does not exist in the bundle will return the message "Undefined message for key" followed by the key.
    *
    * For example:
    * <ul>
    * <li>The message for the key "type.undef" is "No type of name $1"</li>
    * <li><code>getMessage("type.undef", "myValue")</code> returns "No type of name myValue"</li>
    * </ul>
    *
    * <h1>Message elaboration</h1>
    * Any String can be used for the value of the property bundle for the key. Tags $&lt;n&gt; represent the
    * n-th variable in the vararg variables array. For example:
    * <ul>
    * <li>The message for the key "my.tag" is "No type of name $1 or name $2"</li>
    * <li><code>getMessage("type.undef", "myValue", 3)</code> returns "No type of name myValue or 3"</li>
    * </ul>
    *
    * If there are more variables than n, the remaining variables will be omitted in the result. For example:
    * <ul>
    * <li>The message for the key "my.tag" is "No type of name $1"</li>
    * <li><code>getMessage("type.undef", "myValue", 3)</code> returns "No type of name myValue"</li>
    * </ul>
    * If there are less variables than n, the remaining tags will be omitted in the result. For example:
    * <ul>
    * <li>The message for the key "my.tag" is "No type of name $1 or $2"</li>
    * <li><code>getMessage("type.undef", "myValue")</code> returns "No type of name myValue or"</li>
    * </ul>
    *
    * @param key the message key
    * @param arguments the arguments to fill
    * @return the translation of the message with the arguments.
    */
   public String getString(final String key, final Object... arguments) {
      if (messages.containsKey(key)) {
         String message = messages.get(key);
         return MessageConstructor.getText(message, arguments);
      } else {
         // we will go there if the user code has set a wrong key for the message
         return "Undefined message for " + key;
      }
   }

   public String getMessage(final String key, short level, final Object... arguments) {
      if (messages.containsKey(key)) {
         String message = messages.get(key);
         return MessageConstructor.getText(message, level, arguments);
      } else {
         // we will go there if the user code has set a wrong key for the message
         return "Undefined message for " + key;
      }
   }

   public String getContMessage(final String key, short level, final Object... arguments) {
      if (messages.containsKey(key)) {
         String message = messages.get(key);
         return " " + MessageConstructor.getText(message, level, arguments);
      } else {
         // we will go there if the user code has set a wrong key for the message
         return "Undefined message for " + key;
      }
   }

   public String getContString(final String key, final Object... arguments) {
      if (messages.containsKey(key)) {
         String message = messages.get(key);
         return " " + MessageConstructor.getText(message, arguments);
      } else {
         // we will go there if the user code has set a wrong key for the message
         return "Undefined message for " + key;
      }
   }
}
