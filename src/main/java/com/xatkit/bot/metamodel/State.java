package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the State concept of a {@link Bot}
 */
public class State {
    private String name;
    private String varName;
    private StateBody body; // For now the body is just a simple text reply
    private List<Transition> outTransitions = new ArrayList<Transition>();

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
     * @return the body
     */
    public StateBody getBody() {
        return this.body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(StateBody body) {
        this.body = body;
    }

    /**
     * @return the outTransitions
     */
    public List<Transition> getOutTransitions() {
        return this.outTransitions;
    }

    /**
     * @param t the transition to add
     */
    public void addOutTransition(Transition t) {
        this.outTransitions.add(t);
    }
}
