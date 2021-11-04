package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

public class CompositeEntry {

    private List<IntentParameterType> entities;

    public CompositeEntry(List<IntentParameterType> entities) {
        this.entities = entities;
    }
    
    public CompositeEntry() {
        this.entities = new ArrayList<IntentParameterType>();
    }

    /**
     * @return the synonyms
     */
    public List<IntentParameterType> getEntities() {
        return this.entities;
    }

}
