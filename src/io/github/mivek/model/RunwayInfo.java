package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;

/**
 * Runway class.
 *
 * @author mivek
 */
public class RunwayInfo implements WeatherElement {
   /**
    * The name of the runway.
    */
   private String name;
   /**
    * The minimal visibility on the runway.
    */
   private int minRange;
   /**
    * The maximal visibility on the runway.
    */
   private int maxRange;
   /**
    * The tread.
    */
   private String trend;

   /**
    * Getter of name.
    *
    * @return the name.
    */
   public String getName() {
      return name;
   }

   /**
    * Setter of name.
    *
    * @param name the name to set.
    */
   public void setName(final String name) {
      this.name = name;
   }

   /**
    * Getter of minimal range.
    *
    * @return the minRange.
    */
   public int getMinRange() {
      return minRange;
   }

   /**
    * The setter of minRange.
    *
    * @param minRange the minRange to set.
    */
   public void setMinRange(final int minRange) {
      this.minRange = minRange;
   }

   /**
    * Getter of maxRange.
    *
    * @return maxRange.
    */
   public int getMaxRange() {
      return maxRange;
   }

   /**
    * Setter of maxRange.
    *
    * @param maxRange the maxrange to set.
    */
   public void setMaxRange(final int maxRange) {
      this.maxRange = maxRange;
   }

   /**
    * Getter of the trend.
    *
    * @return the trend.
    */
   public String getTrend() {
      return trend;
   }

   /**
    * Setter of the trend.
    *
    * @param trend Trend to set.
    */
   public void setTrend(final String trend) {
      this.trend = trend;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(messages.getString("ToString.name", name)).
         append(messages.getContString("ToString.visibility.min", minRange)).
         append(messages.getContString("ToString.visibility.max", maxRange));
      if (level > MessageLevel.COMPACT) {
         buf.append(messages.getContMessage("ToString.trend", level, trend));
      }

      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
