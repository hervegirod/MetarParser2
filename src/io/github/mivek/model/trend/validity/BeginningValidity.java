package io.github.mivek.model.trend.validity;

import io.github.mivek.internationalization.Messages;

/**
 * Class representing a validity with start day, start hour and start minutes.
 *
 * @author mivek
 */
public class BeginningValidity extends AbstractValidity {
   /**
    * the minutes.
    */
   private Integer startMinutes;

   /**
    * @return the startMinutes
    */
   public Integer getStartMinutes() {
      return startMinutes;
   }

   /**
    * @param startMinutes the startMinutes to set
    */
   public void setStartMinutes(final Integer startMinutes) {
      this.startMinutes = startMinutes;
   }

   @Override
   public final String toString() {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(super.toString()).
              append(messages.getContString("ToString.start.minute", startMinutes));
      return buf.toString();
   }
}
