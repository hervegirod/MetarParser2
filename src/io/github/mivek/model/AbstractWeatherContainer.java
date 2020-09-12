package io.github.mivek.model;

import io.github.mivek.internationalization.MessageUtils;
import io.github.mivek.internationalization.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mivek
 */
public abstract class AbstractWeatherContainer implements WeatherElement {
   /**
    * The wind.
    */
   private Wind wind;
   /**
    * The visibility.
    */
   private Visibility visibility;
   /**
    * The list of clouds.
    */
   private final List<Cloud> clouds;
   /**
    * The list of weatherConditions.
    */
   private final List<WeatherCondition> weatherConditions;
   /**
    * the vertical Visibility in feet.
    */
   private Integer verticalVisibility;
   /**
    * the sea level pressure in HPA.
    */
   private Float seaLevelPressure;
   /**
    * The wind shear.
    */
   private WindShear windShear;
   /**
    * Indicates whether the event contains CAVOK (ceiling and visibility ok).
    */
   private boolean cavok;
   /**
    * Contains the remarks.
    */
   private String remark;

   /**
    * Constructor to initialize the lists.
    */
   public AbstractWeatherContainer() {
      clouds = new ArrayList<>();
      weatherConditions = new ArrayList<>();
   }

   /**
    * Return the wind.
    *
    * @return the wind
    */
   public final Wind getWind() {
      return wind;
   }

   /**
    * @param wind the wind element to set.
    */
   public final void setWind(final Wind wind) {
      this.wind = wind;
   }

   /**
    * @return the visibility
    */
   public final Visibility getVisibility() {
      return visibility;
   }

   /**
    * @param visibility the visibility to set
    */
   public final void setVisibility(final Visibility visibility) {
      this.visibility = visibility;
   }

   /**
    * @return the clouds
    */
   public final List<Cloud> getClouds() {
      return clouds;
   }

   /**
    * @return the weatherConditions
    */
   public final List<WeatherCondition> getWeatherConditions() {
      return weatherConditions;
   }

   /**
    * Adds a cloud to the list.
    *
    * @param cloud the cloud to add.
    * @return true if the cloud has been added in the list, false otherwise.
    */
   public boolean addCloud(final Cloud cloud) {
      if (cloud == null) {
         return false;
      }
      clouds.add(cloud);
      return true;
   }

   /**
    * Adds a weather condition to the list.
    *
    * @param weatherCondition the weather condition to add.
    * @return true if the weather condition has been added to the list, false otherwise.
    */
   public boolean addWeatherCondition(final WeatherCondition weatherCondition) {
      if (weatherCondition == null) {
         return false;
      }
      weatherConditions.add(weatherCondition);
      return true;
   }

   /**
    * @return the verticalVisibility in feet.
    */
   public Integer getVerticalVisibility() {
      return verticalVisibility;
   }

   /**
    * @param verticalVisibility the verticalVisibility to set
    */
   public void setVerticalVisibility(final Integer verticalVisibility) {
      this.verticalVisibility = verticalVisibility;
   }

   /**
    * Set the seaLevelPressure.
    *
    * @param seaLevelPressure the sea level pressure
    */
   public void setSeaLevelPressure(final Float seaLevelPressure) {
      this.seaLevelPressure = seaLevelPressure;
   }

   /**
    * Return the seaLevelPressure.
    *
    * @return the seaLevelPressure
    */
   public Float getSeaLevelPressure() {
      return seaLevelPressure;
   }

   /**
    * @return the windShear
    */
   public WindShear getWindShear() {
      return windShear;
   }

   /**
    * @param windShear the windShear to set
    */
   public void setWindShear(final WindShear windShear) {
      this.windShear = windShear;
   }

   /**
    * @return the cavok
    */
   public boolean isCavok() {
      return cavok;
   }

   /**
    * @param cavok the cavok to set
    */
   public void setCavok(final boolean cavok) {
      this.cavok = cavok;
   }

   /**
    * @return the remark
    */
   public String getRemark() {
      return remark;
   }

   /**
    * @param remark the remark to set
    */
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();

      if (wind != null) {
         buf.append(" ").append(wind.getMessage(level));
      }
      if (visibility != null) {
         buf.append(" ").append(visibility.getMessage(level));
      }
      if (verticalVisibility != null && level > MessageLevel.NORMAL) {
         buf.append(messages.getContString("ToString.vertical.visibility", verticalVisibility));
      }
      if (clouds != null && level > MessageLevel.NORMAL) {
         buf.append(messages.getContString("ToString.clouds", clouds));
      }
      if (weatherConditions != null && level > MessageLevel.NORMAL) {
         buf.append(MessageUtils.getContString("ToString.weather.conditions", weatherConditions));
      }
      if (windShear != null) {
         buf.append(" ").append(windShear.getMessage(level));
      }
      buf.append(messages.getContString("ToString.cavok", cavok));
      if (remark != null && level > MessageLevel.NORMAL) {
         buf.append(messages.getContString("ToString.remark", remark));
      }
      return buf.toString();
   }

   /**
    * @return string describing the object.
    */
   @Override
   public String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
