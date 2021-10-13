package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Mapping concept that can be used in the {@link IntentParameter}s Ii is a specialized
 * {@link IntentParameterType} representing an enumeration of values.
 *
 * @see MappingEntry
 */
public class Mapping extends IntentParameterType {

    private String varName;
    private List<MappingEntry> entries;

    public Mapping(String name, String varName) {
        super(name);
        this.varName = varName;
        this.entries = new ArrayList<MappingEntry>();
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    public List<MappingEntry> getEntries() {
        return this.entries;
    }

    public void addMappingEntry(MappingEntry me) {
        this.entries.add(me);
    }
}
