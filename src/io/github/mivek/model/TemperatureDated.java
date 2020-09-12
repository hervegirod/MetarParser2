package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;

/**
 * Class representing a temperature with its date.
 *
 * @author mivek
 */
public class TemperatureDated implements WeatherElement {
   /**
    * The temperature.
    */
   private Integer temperature;
   /**
    * The day.
    */
   private Integer day;
   /**
    * The hour.
    */
   private Integer hour;

   /**
    * @return the temperature
    */
   public Integer getTemperature() {
      return temperature;
   }

   /**
    * @param temperature the temperature to set
    */
   public void setTemperature(final Integer temperature) {
      this.temperature = temperature;
   }

   /**
    * @return the day
    */
   public Integer getDay() {
      return day;
   }

   /**
    * @param day the day to set
    */
   public void setDay(final Integer day) {
      this.day = day;
   }

   /**
    * @return the hour
    */
   public Integer getHour() {
      return hour;
   }

   /**
    * @param hour the hour to set
    */
   public void setHour(final Integer hour) {
      this.hour = hour;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(messages.getMessage("ToString.temperature", level, temperature)).
         append(messages.getContMessage("ToString.day.month", level, day)).
         append(messages.getContMessage("ToString.day.hour", level, hour + ":00"));
      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
