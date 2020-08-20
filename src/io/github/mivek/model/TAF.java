package io.github.mivek.model;

import io.github.mivek.internationalization.Messages;
import io.github.mivek.model.trend.BECMGTafTrend;
import io.github.mivek.model.trend.FMTafTrend;
import io.github.mivek.model.trend.PROBTafTrend;
import io.github.mivek.model.trend.TEMPOTafTrend;
import io.github.mivek.model.trend.validity.Validity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a TAF.
 *
 * @author mivek
 */
public class TAF extends AbstractWeatherCode {
    /** The valididty of the TAF. */
    private Validity validity;
    /** The maximum temperature. */
    private TemperatureDated maxTemperature;
    /** The minimum temperature. */
    private TemperatureDated minTemperature;
    /** List of BECMG changes. */
    private final List<BECMGTafTrend> bECMGs;
    /** List of From changes. */
    private final List<FMTafTrend> fMs;
    /** List of Tempos changes. */
    private final List<TEMPOTafTrend> tempos;
    /** List of probability changes. */
    private final List<PROBTafTrend> probs;
    /** Indicate if the taf event is ameded. */
    private boolean amendment;

    /**
     * Constructor.
     */
    public TAF() {
        super();
        bECMGs = new ArrayList<>();
        fMs = new ArrayList<>();
        tempos = new ArrayList<>();
        probs = new ArrayList<>();
    }

    /**
     * Return the validity.
     *
     * @return the validity
     */
    public Validity getValidity() {
        return validity;
    }

    /**
     * @param validity the validity to set
     */
    public void setValidity(final Validity validity) {
        this.validity = validity;
    }

    /**
     * Return the maxTemperature.
     *
     * @return the maxTemperature
     */
    public TemperatureDated getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * @param maxTemperature the maxTemperature to set
     */
    public void setMaxTemperature(final TemperatureDated maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * Return the minTemperature.
     *
     * @return the minTemperature
     */
    public TemperatureDated getMinTemperature() {
        return minTemperature;
    }

    /**
     * @param minTemperature the minTemperature to set
     */
    public void setMinTemperature(final TemperatureDated minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * Return the bECMGs.
     *
     * @return the bECMGs
     */
    public List<BECMGTafTrend> getBECMGs() {
        return bECMGs;
    }

    /**
     * Return the fMs.
     *
     * @return the fMs
     */
    public List<FMTafTrend> getFMs() {
        return fMs;
    }

    /**
     * Return the probs.
     *
     * @return the probs
     */
    public List<PROBTafTrend> getProbs() {
        return probs;
    }

    /**
     * Adds a tempo change to the list.
     *
     * @param change the change to add.
     */
    public void addTempo(final TEMPOTafTrend change) {
        tempos.add(change);
    }

    /**
     * Adds a PROB Change to the list.
     *
     * @param change the change to add.
     */
    public void addProb(final PROBTafTrend change) {
        probs.add(change);
    }

    /**
     * Adds a BECMG to the list.
     *
     * @param change the change to add.
     */
    public void addBECMG(final BECMGTafTrend change) {
        bECMGs.add(change);
    }

    /**
     * Adds a FM change to the list.
     *
     * @param change the change to add.
     */
    public void addFM(final FMTafTrend change) {
        fMs.add(change);
    }

    /**
     * Return the tempos.
     *
     * @return the tempos
     */
    public List<TEMPOTafTrend> getTempos() {
        return tempos;
    }

    /**
     * @return the amendment
     */
    public boolean isAmendment() {
        return amendment;
    }

    /**
     * @param amendment the amendment to set
     */
    public void setAmendment(final boolean amendment) {
        this.amendment = amendment;
    }

    @Override
    public final String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).appendToString(validity.toString()).append(Messages.getInstance().getString("ToString.temperature.max"), maxTemperature)
                .append(Messages.getInstance().getString("ToString.temperature.min"), minTemperature).append(Messages.getInstance().getString("ToString.amendment"), amendment)
                .appendToString(bECMGs.toString()).appendToString(fMs.toString()).appendToString(tempos.toString()).appendToString(probs.toString()).toString();
    }
}
