package com.xatkit.bot.metamodel;

/**
 * A primitive intent parameter type.
 * <p>
 * Primitive types are natively supported by the underlying NLP system, and don't need to contain additional information
 * to enable information extraction.
 */
public class CoreIntentParameterType extends IntentParameterType {

    /**
     * Creates a {@link CoreIntentParameterType} with the provided {@code name}.
     *
     * @param name the name of the primitive type
     */
    public CoreIntentParameterType(String name) {
        super(name);
    }
}
