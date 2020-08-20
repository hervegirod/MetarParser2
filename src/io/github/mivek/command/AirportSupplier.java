package io.github.mivek.command;

import io.github.mivek.model.Airport;
import io.github.mivek.provider.airport.AirportProvider;
import io.github.mivek.provider.airport.impl.DefaultAirportProvider;

import java.util.ServiceLoader;

/**
 * @author mivek
 */
public final class AirportSupplier implements Supplier<Airport> {
    private final AirportProvider provider;

    /**
     * Constructor.
     */
    public AirportSupplier() {
        provider = new DefaultAirportProvider();
    }

    @Override
    public Airport get(final String string) {
        return provider.getAirports().get(string);
    }
}
