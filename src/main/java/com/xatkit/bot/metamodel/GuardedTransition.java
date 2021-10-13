package com.xatkit.bot.metamodel;

/**
 * Type of {@link Transition} triggered by the matching of an {@link Intent}
 */

public class GuardedTransition extends Transition {

    private Intent when;

    /**
     * @return the when
     */
    public Intent getWhen() {
        return this.when;
    }

    /**
     * @param when the when to set
     */
    public void setWhen(Intent when) {
        this.when = when;
    }

    public GuardedTransition(State origin, State target, Intent when) {
        super(origin, target);
        this.when = when;

    }
}
