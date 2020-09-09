package io.github.mivek.command.remark;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.utils.Regex;

import java.util.regex.Pattern;
import io.github.mivek.model.AbstractWeatherContainer;

/**
 * @author mivek
 */
public final class SmallHailSizeCommand implements Command {
   /** Hail size less than. */
   private static final Pattern HAIL_SIZE_LESS_THAN = Pattern.compile("^GR LESS THAN ((\\d )?(\\d/\\d)?)");

   /** The message instance. */
   private final Messages messages;

   /**
    * Default constructor.
    */
   SmallHailSizeCommand() {
      messages = Messages.getInstance();
   }

   @Override
   public String execute(final AbstractWeatherContainer container, final String remark, final StringBuilder stringBuilder) {
      String[] hailParts = Regex.pregMatch(HAIL_SIZE_LESS_THAN, remark);
      stringBuilder.append(messages.getString("Remark.Hail.LesserThan", hailParts[1])).append(" ");
      return remark.replaceFirst(HAIL_SIZE_LESS_THAN.pattern(), "").trim();
   }

   @Override
   public boolean canParse(final String input) {
      return Regex.find(HAIL_SIZE_LESS_THAN, input);
   }
}
