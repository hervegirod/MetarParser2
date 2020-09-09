package io.github.mivek.command.remark;

import io.github.mivek.model.AbstractWeatherContainer;

/**
 * @author mivek
 */
public interface Command {

   /**
    * @param container the container
    * @param remark the remark to parse.
    * @param stringBuilder the string builder containing the decoded remark
    * @return the remark without the parsed part
    */
   String execute(final AbstractWeatherContainer container, String remark, StringBuilder stringBuilder);

   /**
    * Checks if the string is null.
    *
    * @param string the string to test
    * @return empty string if null string otherwise.
    */
   default String verifyString(final String string) {
      if (string == null) {
         return "";
      }
      return string;
   }

   /**
    * @param input the input string to test.
    * @return true if the input can be handled by the command.
    */
   boolean canParse(String input);
}
