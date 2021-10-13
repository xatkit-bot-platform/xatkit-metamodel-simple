package com.xatkit.bot.metamodel;

/**
 * Parameter to recognize entities in a {@link Intent}
 */
public class IntentParameter {

    private String name;
    /*
     * Fragment in the training sentences that should be matched to the parameter
     *
     * For now we assume a single fragment per Parameter
     */
    private String fragment;
    /**
     * {@link IntentParameterType} defining the range of values of entities matching the parameter
     *
     * Type could be either a custom {@link Mapping} or a {@link CoreIntentParameterType}
     */
    private IntentParameterType type;

    public IntentParameter(String name, String fragment, IntentParameterType type) {
        this.name = name;
        this.fragment = fragment;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getFragment() {
        return this.fragment;
    }

    public IntentParameterType getType() {
        return this.type;
    }
}
