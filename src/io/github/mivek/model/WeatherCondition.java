package io.github.mivek.model;

import io.github.mivek.enums.Descriptive;
import io.github.mivek.enums.Intensity;
import io.github.mivek.enums.Phenomenon;
import io.github.mivek.internationalization.MessageUtils;
import io.github.mivek.internationalization.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather condition class.
 *
 * @author mivek
 */
public class WeatherCondition implements WeatherElement {
   /**
    * Intensity of the condition (optional).
    */
   private Intensity intensity;
   /**
    * Descriptive of the condition (optional).
    */
   private Descriptive descriptive;
   /**
    * List of phenomenons of the condition.
    */
   private final List<Phenomenon> phenomenons;

   /**
    * Constructor.
    */
   public WeatherCondition() {
      phenomenons = new ArrayList<>();
   }

   /**
    * Return the intensity.
    *
    * @return the Intensity of the condition.
    */
   public Intensity getIntensity() {
      return intensity;
   }

   /**
    * Setter of intensity.
    *
    * @param intensity The intensity to set.
    */
   public void setIntensity(final Intensity intensity) {
      this.intensity = intensity;
   }

   /**
    * Return the descriptive.
    *
    * @return the descriptive.
    */
   public Descriptive getDescriptive() {
      return descriptive;
   }

   /**
    * Setter of the descriptive.
    *
    * @param descriptive the descriptive to set.
    */
   public void setDescriptive(final Descriptive descriptive) {
      this.descriptive = descriptive;
   }

   /**
    * Return the phenomenons.
    *
    * @return a list of phenomenons.
    */
   public List<Phenomenon> getPhenomenons() {
      return phenomenons;
   }

   /**
    * Adds a phenomenon to the list.
    *
    * @param phenomenon The Phenomenon to add.
    */
   public void addPhenomenon(final Phenomenon phenomenon) {
      phenomenons.add(phenomenon);
   }

   /**
    * Checks if the weather condition is valid.
    *
    * @return true if there is at least phenomenon.
    */
   public boolean isValid() {
      return !phenomenons.isEmpty() || Descriptive.THUNDERSTORM == descriptive;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      if (intensity != null) {
         buf.append(messages.getMessage("ToString.intensity", level, intensity));
      }
      if (descriptive != null && level > MessageLevel.COMPACT) {
         buf.append(messages.getContMessage("ToString.descriptive", level, descriptive));
      }
      if (phenomenons != null && level > MessageLevel.NORMAL) {
         buf.append(MessageUtils.getContMessage("ToString.phenomenons", level, phenomenons));
      }
      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
