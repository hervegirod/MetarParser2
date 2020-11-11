package io.github.mivek.command.common;

import io.github.mivek.model.AbstractWeatherContainer;
import io.github.mivek.model.Visibility;
import io.github.mivek.utils.Regex;

import java.util.regex.Pattern;

/**
 * @author mivek
 * @version 0.4
 */
public final class MainVisibilityCommand implements Command {
   /** Pattern for the main visibility. */
   private static final Pattern MAIN_VISIBILITY_REGEX = Pattern.compile("^(\\d{4})(|NDV)$");

   /**
    * constructor.
    */
   MainVisibilityCommand() {
   }

   @Override
   public boolean execute(final AbstractWeatherContainer container, final String part) {
      String[] matches = Regex.pregMatch(MAIN_VISIBILITY_REGEX, part);
      if (container.getVisibility() == null) {
         container.setVisibility(new Visibility());
      }
      int value = 0;
      String valueS = matches[1];
      if ("9999".equals(valueS)) {
         valueS = "CAVOK";
         value = 10000;
      } else {
         value = Integer.parseInt(valueS);
         valueS = value + "m";
      }
      container.getVisibility().setMainVisibility(valueS, value);
      return getReturnValue();
   }

   @Override
   public boolean canParse(final String input) {
      return Regex.find(MAIN_VISIBILITY_REGEX, input);
   }
}
