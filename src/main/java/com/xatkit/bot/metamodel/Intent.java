package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the Intent concept of a {@link Bot}
 */
public class Intent {

    private String name;
    private String varName;
    private List<String> trainingSentences;
    private List<IntentParameter> parameters;

    public Intent(String name, String varName) {
        this.name = name;
        this.varName = varName;
        this.trainingSentences = new ArrayList<String>();
        this.parameters = new ArrayList<IntentParameter>();
    }

    /**
     * @return the trainingSentences
     */
    public List<String> getTrainingSentences() {
        return this.trainingSentences;
    }

    /**
     * @param trainingSentences the trainingSentences to set
     */
    public void setTrainingSentences(List<String> trainingSentences) {
        this.trainingSentences = trainingSentences;
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
     * @return the name
     */
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
     * @return the parameters
     */
    public List<IntentParameter> getParameters() {
        return this.parameters;
    }

    public void addParameter(IntentParameter p) {
        this.parameters.add(p);
    }

    public void addTrainingSentence(String t) {
        this.trainingSentences.add(t);
    }
}
