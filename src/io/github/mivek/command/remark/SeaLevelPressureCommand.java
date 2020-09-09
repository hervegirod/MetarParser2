package io.github.mivek.command.remark;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.utils.Regex;

import java.util.regex.Pattern;
import io.github.mivek.model.AbstractWeatherContainer;

/**
 * @author mivek
 */
public final class SeaLevelPressureCommand implements Command {
   /** Sea level pressure. */
   private static final Pattern SEAL_LEVEL_PRESSURE = Pattern.compile("^SLP(\\d{2})(\\d)");

   /** The message instance. */
   private final Messages messages;

   /**
    * Default constructor.
    */
   SeaLevelPressureCommand() {
      messages = Messages.getInstance();
   }

   @Override
   public String execute(final AbstractWeatherContainer container, final String remark, final StringBuilder stringBuilder) {
      String[] sealevelParts = Regex.pregMatch(SEAL_LEVEL_PRESSURE, remark);
      StringBuilder pressure = new StringBuilder();
      if (sealevelParts[1].startsWith("9")) {
         pressure.append("9");
      } else {
         pressure.append("10");
      }
      pressure.append(sealevelParts[1]).append(".").append(sealevelParts[2]);
      try {
         container.setSeaLevelPressure(Float.parseFloat(pressure.toString()));
      } catch (NumberFormatException e) {
      }
      stringBuilder.append(messages.getString("Remark.Sea.Level.Pressure", pressure)).append(" ");
      return remark.replaceFirst(SEAL_LEVEL_PRESSURE.pattern(), "").trim();
   }

   @Override
   public boolean canParse(final String input) {
      return Regex.find(SEAL_LEVEL_PRESSURE, input);
   }
}
