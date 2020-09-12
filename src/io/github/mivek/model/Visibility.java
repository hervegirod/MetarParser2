package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;

/**
 * Visisbility class.
 *
 * @author mivek
 */
public class Visibility implements WeatherElement {
   /**
    * mainVisibility of the metar.
    */
   private String mainVisibility;
   /**
    * mainVisibility of the metar.
    */
   private Integer mainVisibilityMeters;
   /**
    * minimal visibility of the metar.
    */
   private Integer minVisibility;
   /**
    * Direction of the minimal visibility.
    */
   private String minDirection;

   /**
    * Getter of the mainVisibility.
    *
    * @return the mainvisibility.
    */
   public String getMainVisibility() {
      return mainVisibility;
   }

   /**
    * Getter of the mainVisibility in meters.
    *
    * @return the mainvisibility in meters
    */
   public Integer getMainVisibilityMeters() {
      return mainVisibilityMeters;
   }

   /**
    * Setter of the main visibility.
    *
    * @param mainVisibility the main visibility to set.
    * @param mainVisibilityMeters the main visibility in meters
    */
   public void setMainVisibility(final String mainVisibility, final Integer mainVisibilityMeters) {
      this.mainVisibility = mainVisibility;
      this.mainVisibilityMeters = mainVisibilityMeters;
   }

   /**
    * Getter of the minimal visibility.
    *
    * @return the minimal visibility.
    */
   public Integer getMinVisibility() {
      return minVisibility;
   }

   /**
    * Setter of the minimal visibility.
    *
    * @param minVisibility the minimal visibility to set.
    */
   public void setMinVisibility(final Integer minVisibility) {
      this.minVisibility = minVisibility;
   }

   /**
    * Getter of direction.
    *
    * @return the direction.
    */
   public String getMinDirection() {
      return minDirection;
   }

   /**
    * Setter of the minimal direction.
    *
    * @param minDirection the minimal direction to set.
    */
   public void setMinDirection(final String minDirection) {
      this.minDirection = minDirection;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(messages.getMessage("ToString.visibility.main", level, mainVisibility));
      if (minVisibility != null) {
         buf.append(messages.getContMessage("ToString.visibility.min", level, minVisibility));
      }
      if (minDirection != null) {
         buf.append(messages.getContMessage("ToString.visibility.min.direction", level, minDirection));
      }
      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
