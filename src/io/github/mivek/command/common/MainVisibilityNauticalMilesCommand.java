package io.github.mivek.command.common;

import io.github.mivek.model.AbstractWeatherContainer;
import io.github.mivek.model.Visibility;
import io.github.mivek.utils.Regex;

import java.util.regex.Pattern;

/**
 * @author mivek
 */
public final class MainVisibilityNauticalMilesCommand implements Command {
   /** Pattern for the main visibility in SM. */
   private static final Pattern MAIN_VISIBILITY_SM_REGEX = Pattern.compile("^(\\d)*(\\s)?((\\d\\/\\d)?SM)$");

   /**
    * constructor.
    */
   MainVisibilityNauticalMilesCommand() {
   }

   @Override
   public boolean execute(final AbstractWeatherContainer container, final String part) {
      String[] matches = Regex.pregMatch(MAIN_VISIBILITY_SM_REGEX, part);
      if (container.getVisibility() == null) {
         container.setVisibility(new Visibility());
      }
      String valueS = matches[0];
      int value = 0;
      try {
         value = Integer.parseInt(valueS.substring(0, valueS.indexOf("S")));
      } catch (NumberFormatException e) {
      }
      container.getVisibility().setMainVisibility(matches[0], value);
      return getReturnValue();
   }

   @Override
   public boolean canParse(final String input) {
      return Regex.find(MAIN_VISIBILITY_SM_REGEX, input);
   }
}
