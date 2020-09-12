/*------------------------------------------------------------------------------
 * Copyright (C) 2020 Herve Girod
 *
 * Distributable under the terms of either the Apache License (Version 2.0) or
 * the GNU Lesser General Public License, as specified in the COPYING file.
 ------------------------------------------------------------------------------*/
package io.github.mivek.internationalization;

import java.util.Iterator;
import java.util.List;
import io.github.mivek.model.WeatherElement;

/**
 *
 * @since 0.2
 */
public class MessageUtils {
   private MessageUtils() {
   }

   public static String getString(List<?> list) {
      return getString(list, false);
   }

   public static String getMessage(short level, List<?> list) {
      return getMessage(level, list, false);
   }

   public static String getContMessage(String key, short level, List<?> list) {
      Messages messages = Messages.getInstance();
      String str = messages.getContString(key);
      str += getString(list, true);
      return str;
   }

   public static String getContString(String key, List<?> list) {
      Messages messages = Messages.getInstance();
      String str = messages.getContString(key);
      str += getString(list, true);
      return str;
   }

   public static String getContString(List<?> list) {
      return getString(list, true);
   }

   private static String getMessage(short level, List<?> list, boolean isContinued) {
      if (list == null || list.isEmpty()) {
         return "";
      }
      StringBuilder buf = new StringBuilder();
      Iterator it = list.iterator();
      boolean isFirst = !isContinued;
      while (it.hasNext()) {
         Object o = it.next();
         if (isFirst) {
            isFirst = false;
         } else {
            buf.append(" ");
         }
         if (o instanceof WeatherElement) {
            WeatherElement elt = (WeatherElement) o;
            buf.append(elt.getMessage(level));
         } else {
            buf.append(o.toString());
         }
      }
      return buf.toString();
   }

   private static String getString(List<?> list, boolean isContinued) {
      if (list == null || list.isEmpty()) {
         return "";
      }
      StringBuilder buf = new StringBuilder();
      Iterator it = list.iterator();
      boolean isFirst = !isContinued;
      while (it.hasNext()) {
         Object o = it.next();
         if (isFirst) {
            isFirst = false;
         } else {
            buf.append(" ");
         }
         buf.append(o.toString());
      }
      return buf.toString();
   }
}
