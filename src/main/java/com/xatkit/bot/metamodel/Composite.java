package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Mapping concept that can be used in the {@link IntentParameter}s Ii is a specialized
 * {@link IntentParameterType} representing an enumeration of values.
 *
 * @see MappingEntry
 */
public class Composite extends IntentParameterType {

    private String varName;
    private List<CompositeEntry> entries;

    public Composite(String name, String varName) {
        super(name);
        this.varName = varName;
        this.entries = new ArrayList<CompositeEntry>();
    }

    /**
     * @return the varName
     */
    public String getVarName() {
        return this.varName;
    }

    /**
     * @param varName the varName to set
     */
    public void setVarName(String varName) {
        this.varName = varName;
    }

    /**
     * @return the entries
     */
    public List<CompositeEntry> getEntries() {
        return this.entries;
    }

    public void addCompositeEntry(CompositeEntry ce) {
        this.entries.add(ce);
    }
}
