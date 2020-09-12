package io.github.mivek.model.trend;

import io.github.mivek.enums.WeatherChangeType;
import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.trend.validity.AbstractValidity;

/**
 * Class representing a weather change with a given probability.
 *
 * @param <T> a concrete subclass of {@link AbstractValidity}
 * @author f.loris
 */
public abstract class AbstractTafProbTrend<T extends AbstractValidity> extends AbstractTafTrend<T> {

   /**
    * Probability of the trend.
    */
   private Integer probability;

   /**
    * Constructor with parameter.
    *
    * @param type the type to set.
    */
   protected AbstractTafProbTrend(final WeatherChangeType type) {
      super(type);
   }

   /**
    * @return the probability
    */
   public Integer getProbability() {
      return probability;
   }

   /**
    * @param probability the probability to set
    */
   public void setProbability(final Integer probability) {
      this.probability = probability;
   }

   /**
    * @return A description of the object.
    */
   @Override
   public String toString() {
      StringBuilder buf = new StringBuilder();
      Messages messages = Messages.getInstance();
      buf.append(super.toString()).
              append(messages.getContString("ToString.probability", probability + "%"));
      return buf.toString();
   }
}
