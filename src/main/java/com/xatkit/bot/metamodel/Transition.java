package com.xatkit.bot.metamodel;

/**
 * Representation of the Transition concept between two {@link State}s in a {@link Bot}
 */
public class Transition {
    private State origin;
    private State target;

    public Transition(State origin, State target) {
        this.origin = origin;
        this.target = target;
    }

    public Transition() {
        this.origin = null;
        this.target = null;
    }

    /**
     * @return the origin state of the transition
     */
    public State getOrigin() {
        return this.origin;
    }

    /**
     * @param origin the state origin of the transition
     */
    public void setOrigin(State origin) {
        this.origin = origin;
    }

    /**
     * @return the target
     */
    public State getTarget() {
        return this.target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(State target) {
        this.target = target;
    }

}
