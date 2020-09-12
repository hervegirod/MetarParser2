package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;

/**
 * Wind class.
 *
 * @author mivek
 * @author girod
 */
public class Wind implements WeatherElement {

   /**
    * Speed of the wind.
    */
   private int speed;
   /**
    * Direction of the wind.
    */
   private String direction;
   /**
    * Direction of the wind.
    */
   private Integer directionDegrees;
   /**
    * The speed of the gust.
    */
   private Integer gust;
   /**
    * The minimal variation of the wind.
    */
   private Integer minVariation;
   /**
    * The maximum variation of the wind.
    */
   private Integer maxVariation;
   /**
    * The unit of the speed.
    */
   private String unit;

   /**
    * Getter of the speed.
    *
    * @return the speed.
    */
   public int getSpeed() {
      return speed;
   }

   /**
    * Setter of the speed.
    *
    * @param speed the speed to set.
    */
   public void setSpeed(final int speed) {
      this.speed = speed;
   }

   /**
    * Getter of the direction.
    *
    * @return The Direction of the wind.
    */
   public String getDirection() {
      return direction;
   }

   /**
    * Setter of the direction of the wind.
    *
    * @param direction the direction to set.
    */
   public void setDirection(final String direction) {
      this.direction = direction;
   }

   /**
    * Getter of the gust.
    *
    * @return the gust.
    */
   public Integer getGust() {
      return gust;
   }

   /**
    * Setter of the gust.
    *
    * @param gust the gust to set.
    */
   public void setGust(final Integer gust) {
      this.gust = gust;
   }

   /**
    * Getter of the minimal variation of the wind.
    *
    * @return the minimal variation of the wind.
    */
   public Integer getMinVariation() {
      return minVariation;
   }

   /**
    * @param minVariation the minimal wind variation to set.
    */
   public void setMinVariation(final Integer minVariation) {
      this.minVariation = minVariation;
   }

   /**
    * @return the wind max variation.
    */
   public Integer getMaxVariation() {
      return maxVariation;
   }

   /**
    * @param maxVariation the wind max variation to set.
    */
   public void setMaxVariation(final Integer maxVariation) {
      this.maxVariation = maxVariation;
   }

   /**
    * Getter of the unit.
    *
    * @return the unit.
    */
   public String getUnit() {
      return unit;
   }

   /**
    * Setter.
    *
    * @param unit The unit to set.
    */
   public void setUnit(final String unit) {
      this.unit = unit;
   }

   /**
    * Return direction in degrees.
    *
    * @return the directionDegrees.
    */
   public Integer getDirectionDegrees() {
      return directionDegrees;
   }

   /**
    * @param directionDegrees the directionDegrees to set.
    */
   public void setDirectionDegrees(final Integer directionDegrees) {
      this.directionDegrees = directionDegrees;
   }

   @Override
   public String getMessage(short level) {
      StringBuilder buf = new StringBuilder();
      Messages messages = Messages.getInstance();
      buf.append(messages.getMessage("ToString.wind.speed", level, speed, unit)).
         append(messages.getContMessage("ToString.wind.direction.degrees", level, directionDegrees));
      if (level > MessageLevel.COMPACT) {
         if (gust != null) {
            buf.append(messages.getContMessage("ToString.wind.gusts", level, gust));
         }
         if (minVariation != null) {
            buf.append(messages.getContMessage("ToString.wind.min.variation", level, minVariation));
         }
         if (maxVariation != null) {
            buf.append(messages.getContMessage("ToString.wind.max.variation", level, maxVariation));
         }
      }
      return buf.toString();
   }

   /**
    * @return a description of the wind component.
    */
   @Override
   public String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
