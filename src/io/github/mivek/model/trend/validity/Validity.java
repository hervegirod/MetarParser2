package io.github.mivek.model.trend.validity;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.MessageLevel;

/**
 * Class representing the validity of a TAF message.
 *
 * @author mivek
 */
public final class Validity extends AbstractValidity {

   /**
    * Ending day of the taf's validity.
    */
   private Integer endDay;
   /**
    * Ending hour of the taf's validity.
    */
   private Integer endHour;

   /**
    * @return the endDay
    */
   public Integer getEndDay() {
      return endDay;
   }

   /**
    * @param endDay the endDay to set
    */
   public void setEndDay(final Integer endDay) {
      this.endDay = endDay;
   }

   /**
    * @return the endHour
    */
   public Integer getEndHour() {
      return endHour;
   }

   /**
    * @param endHour the endHour to set
    */
   public void setEndHour(final Integer endHour) {
      this.endHour = endHour;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(super.getMessage(level)).
         append(messages.getContString("ToString.end.day.month", endDay)).
         append(messages.getContString("ToString.end.hour.day", endHour + ":00"));
      return buf.toString();
   }

   @Override
   public String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
