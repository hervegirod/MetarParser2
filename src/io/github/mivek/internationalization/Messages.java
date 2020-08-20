package io.github.mivek.internationalization;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Messages class for internationalization.
 *
 * @author mivek
 */
public final class Messages {
    /** The singleton instance. */
    private static final Messages INSTANCE = new Messages();
    /** Name of the bundle. */
    private static final String BUNDLE_NAME = "internationalization.messages"; //$NON-NLS-1$
    /** Bundle variable. */
    private ResourceBundle fResourceBundle;

    /**
     * Private constructor.
     */
    private Messages() {
        InputStream stream;
        try {
            stream = this.getClass().getResource("messages_en.properties").openStream();
            fResourceBundle = new PropertyResourceBundle(stream);
        } catch (IOException ex) {
        }
        
    }

    /**
     * @return the Messages instance.
     */
    public static Messages getInstance() {
        return INSTANCE;
    }

    /**
     * Sets the locale of the bundle.
     *
     * @param locale the locale to set.
     */
    public void setLocale(final Locale locale) {
        Locale.setDefault(locale);
        ResourceBundle.clearCache();
        fResourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    /**
     * @param message the string to get
     * @return the translation of message
     */
    public String getString(final String message) {
        return fResourceBundle.getString(message);
    }

    /**
     * @param message   the translation to get
     * @param arguments the arguments to fill
     * @return the translation of ;essqge with the arguments.
     */
    public String getString(final String message, final Object... arguments) {
        return MessageFormat.format(getString(message), arguments);
    }
}
