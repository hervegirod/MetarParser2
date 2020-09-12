package io.github.mivek.model.trend.validity;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.MessageLevel;
import io.github.mivek.model.WeatherElement;

/**
 * Abstract class for the validity of a TAF.
 *
 * @author mivek
 */
public abstract class AbstractValidity implements IValidity, WeatherElement {
   /**
    * Beginning day of the taf's validity.
    */
   private Integer startDay;
   /**
    * Beginning hour of the taf's validity.
    */
   private Integer startHour;

   @Override
   public final Integer getStartDay() {
      return startDay;
   }

   @Override
   public final void setStartDay(final Integer startDay) {
      this.startDay = startDay;
   }

   @Override
   public final Integer getStartHour() {
      return startHour;
   }

   @Override
   public final void setStartHour(final Integer startHour) {
      this.startHour = startHour;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();

      buf.append(messages.getString("ToString.start.day.month", startDay)).
         append(messages.getContString("ToString.start.hour.day", startHour));
      return buf.toString();
   }

   /**
    * @return a string describing the object.
    */
   @Override
   public String toString() {
      return getMessage(MessageLevel.FULL);
   }

}
