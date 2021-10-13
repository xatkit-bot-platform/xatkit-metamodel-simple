package com.xatkit.bot.metamodel;

/**
 * Represents the type of a {@link IntentParameter}.
 */
public abstract class IntentParameterType {

    /**
     * The name of the type.
     */
    protected String name;

    /**
     * Creates a {@link IntentParameterType} with the provided {@code name}.
     *
     * @param name the name of the type
     */
    public IntentParameterType(String name) {
        this.name = name;
    }

    /**
     * @return the name of the type
     */
    public String getName() {
        return this.name;
    }
}
