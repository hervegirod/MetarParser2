package io.github.mivek.model;

import io.github.mivek.enums.CloudQuantity;
import io.github.mivek.enums.CloudType;
import io.github.mivek.internationalization.Messages;

/**
 * Class representing a cloud element. Clouds are composed of : a quantity a type (optional) an height (optional)
 *
 * @author mivek
 */
public class Cloud implements WeatherElement {
   /**
    * The height of the cloud (unit: feet).
    */
   private int height;
   /**
    * The quantity of the cloud.
    */
   private CloudQuantity quantity;
   /**
    * The type of the cloud.
    */
   private CloudType type;

   /**
    * Getter of the height (unit: feet).
    *
    * @return int of height.
    */
   public int getHeight() {
      return height;
   }

   /**
    * Setter of the height (unit: feet).
    *
    * @param height The height to set.
    */
   public void setHeight(final int height) {
      this.height = height;
   }

   /**
    * Getter of the quantity.
    *
    * @return a CloudQuantity.
    */
   public CloudQuantity getQuantity() {
      return quantity;
   }

   /**
    * Setter of CloudQuantity.
    *
    * @param quantity The CloudQuantity to set.
    */
   public void setQuantity(final CloudQuantity quantity) {
      this.quantity = quantity;
   }

   /**
    * Getter of type.
    *
    * @return a CloudType.
    */
   public CloudType getType() {
      return type;
   }

   /**
    * Setter of cloud type.
    *
    * @param type The CloudType to set.
    */
   public void setType(final CloudType type) {
      this.type = type;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();

      buf.append(messages.getString("ToString.quantity", quantity)).
         append(messages.getContString("ToString.type", type)).
         append(messages.getContString("ToString.height.feet", height));

      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
