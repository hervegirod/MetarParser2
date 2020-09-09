package io.github.mivek.parser;

import io.github.mivek.command.remark.RemarkCommandSupplier;

import java.util.MissingResourceException;
import io.github.mivek.model.AbstractWeatherContainer;

/**
 * @author mivek
 */
public final class RemarkParser {

   /** The instance of the parser. */
   private static final RemarkParser INSTANCE = new RemarkParser();

   /** The command supplier. */
   private final RemarkCommandSupplier supplier;

   /** *
    * Private constructor.
    */
   private RemarkParser() {
      supplier = new RemarkCommandSupplier();
   }

   /**
    * @param container the container
    * @param remark the remark to parse.
    * @return the remark string
    */
   public String parse(final AbstractWeatherContainer container, final String remark) {
      String rmk = remark;
      StringBuilder sb = new StringBuilder();
      while (!"".equals(rmk)) {
         try {
            rmk = supplier.get(rmk).execute(container, rmk, sb);
         } catch (MissingResourceException e) {
            rmk = supplier.getDefaultCommand().execute(container, rmk, sb);
         }
      }
      return sb.toString();
   }

   /**
    * @return the instance of the parser.
    */
   public static RemarkParser getInstance() {
      return INSTANCE;
   }
}
