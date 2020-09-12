package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;

/**
 * Class representing the wind shear.
 *
 * @author mivek
 */
public class WindShear extends Wind {
   /**
    * The height of the wind shear in feet.
    */
   private int height;

   /**
    * @return the height
    */
   public int getHeight() {
      return height;
   }

   /**
    * @param height the height to set
    */
   public void setHeight(final int height) {
      this.height = height;
   }

   @Override
   public String getMessage(short level) {
      Messages messages = Messages.getInstance();
      StringBuilder buf = new StringBuilder();
      buf.append(super.getMessage(level));
      if (level > MessageLevel.COMPACT) {
         buf.append(messages.getContString("ToString.height.feet", height));
      }
      return buf.toString();
   }

   @Override
   public final String toString() {
      return getMessage(MessageLevel.FULL);
   }
}
