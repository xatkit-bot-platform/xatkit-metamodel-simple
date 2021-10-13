package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MappingEntry {

    private String value;
    private List<String> synonyms;

    public MappingEntry(String value, List<String> synonyms) {
        this.value = value;
        this.synonyms = synonyms;
    }

    public MappingEntry(String value) {
        this.value = value;
        this.synonyms = new ArrayList<String>();
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the synonyms
     */
    public List<String> getSynonyms() {
        return this.synonyms;
    }

}
