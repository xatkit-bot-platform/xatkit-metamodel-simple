package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Top-level container representing a bot.
 * <p>
 * This class contains a list of {@link Intent}s, {@link IntentParameterType}s and {@link State}s that define the bot.
 *
 * @see Intent
 * @see State
 * @see IntentParameterType
 */

public class Bot {

    /**
     * List of intents for the bot.
     */
    private List<Intent> intents;

    /**
     * List of types used in the {@link Intent}s parameters.
     */
    private List<IntentParameterType> types;

    /**
     * List of states for the bot.
     */
    private List<State> states;

    /**
     * Creates an empty {@link Bot}.
     */
    public Bot() {
        this.intents = new ArrayList<Intent>();
        this.types = new ArrayList<IntentParameterType>();
        this.states = new ArrayList<State>();
    }

    /**
     * @return the intents
     */
    public List<Intent> getIntents() {
        return this.intents;
    }

    /**
     * @return the types
     */
    public List<IntentParameterType> getTypes() {
        return this.types;
    }

    /**
     * Adds the provided {@code type} to the model.
     *
     * @param type the type to add
     */
    public void addType(IntentParameterType type) {
        this.types.add(type);
    }

    /**
     * @return the states
     */
    public List<State> getStates() {
        return this.states;
    }

    /**
     * Adds the provided {@code state} to the model.
     *
     * @param state the states to add
     */
    public void addState(State state) {
        this.states.add(state);
    }

    /**
     * Adds the provided {@code intent} to the model.
     *
     * @param intent the intent to add
     */
    public void addIntent(Intent intent) {
        this.intents.add(intent);
    }
}
