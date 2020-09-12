package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.trend.AbstractMetarTrend;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Metar class.
 *
 * @author mivek
 */
public class Metar extends AbstractWeatherCode {

   /**
    * Temperature.
    */
   private Integer temperature;
   /**
    * Dew point.
    */
   private Integer dewPoint;
   /**
    * Humidity.
    */
   private Integer humidity;
   /**
    * Altimeter in HPa.
    */
   private Integer altimeter;
   /**
    * Nosig value.
    */
   private boolean nosig;
   /**
    * Auto Value.
    */
   private boolean auto;
   /**
    * List of runways information.
    */
   private final List<RunwayInfo> runways;
   /**
    * List of trends.
    */
   private final List<AbstractMetarTrend> trends;

   /**
    * Constructor.
    */
   public Metar() {
      super();
      runways = new ArrayList<>();
      trends = new ArrayList<>();
   }

   /**
    * Return the temperature.
    *
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
      if (dewPoint != null) {
         computeHumidity();
      }
   }

   /**
    * Return the dewPoint.
    *
    * @return the dewPoint
    */
   public Integer getDewPoint() {
      return dewPoint;
   }

   /**
    * @param dewPoint the dewPoint to set
    */
   public void setDewPoint(final Integer dewPoint) {
      this.dewPoint = dewPoint;
      if (temperature != null) {
         computeHumidity();
      }
   }

   private void computeHumidity() {
      // See https://www.quora.com/Is-there-a-way-to-calculate-relative-humidity
      double e = 6.11f * (float) Math.pow(10, 7.5f * dewPoint / 237.7 + dewPoint);
      double esat = 6.11f * Math.pow(10, (double) (7.5f * temperature) / (237.7f + temperature));
      humidity = (int) (e / esat * 100);
   }

   /**
    * Return the altimeter in HPa.
    *
    * @return the altimeter in HPa.
    */
   public Integer getAltimeter() {
      return altimeter;
   }

   /**
    * @param altimeter the altimeter to set
    */
   public void setAltimeter(final Integer altimeter) {
      this.altimeter = altimeter;
   }

   /**
    * Return the runways.
    *
    * @return the runways
    */
   public List<RunwayInfo> getRunways() {
      return runways;
   }

   /**
    * Adds a runway to the list.
    *
    * @param runwayInformation the runway to add.
    */
   public void addRunwayInfo(final RunwayInfo runwayInformation) {
      runways.add(runwayInformation);
   }

   /**
    * Return the nosig.
    *
    * @return the nosig
    */
   public boolean isNosig() {
      return nosig;
   }

   /**
    * @param nosig the nosig to set
    */
   public void setNosig(final boolean nosig) {
      this.nosig = nosig;
   }

   /**
    * @return the auto
    */
   public boolean isAuto() {
      return auto;
   }

   /**
    * @param auto the auto to set
    */
   public void setAuto(final boolean auto) {
      this.auto = auto;
   }

   /**
    * Adds a trend to the list.
    *
    * @param trend the trend to add.
    */
   public void addTrend(final AbstractMetarTrend trend) {
      trends.add(Validate.notNull(trend));
   }

   /**
    * Return the relative humididy (computed with dew point and temperature)
    *
    * @return the relative humididy
    */
   public Integer getHumidity() {
      return humidity;
   }

   /**
    * Return the list of trends.
    *
    * @return the list of trends.
    */
   public List<AbstractMetarTrend> getTrends() {
      return trends;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();

      buf.append(super.getMessage(level)).
         append(messages.getMessage("ToString.temperature", level, temperature)).
         append(messages.getContMessage("ToString.dew.point", level, dewPoint)).
         append(messages.getContMessage("ToString.altimeter", level, altimeter));
      if (level > MessageLevel.COMPACT) {
         buf.append(messages.getContString("ToString.nosig", nosig)).
            append(messages.getContString("ToString.auto", auto));
      }
      if (level > MessageLevel.NORMAL) {
         buf.append(messages.getContString("ToString.runway.info", runways.toString()))
            .append(messages.getContString("ToString.trends", trends.toString()));
      }

      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
