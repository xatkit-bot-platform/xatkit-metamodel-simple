package com.xatkit.bot.metamodel;

public class CustomBody implements StateBody {
    /**
     * The string representing the textual answer to be printed by the bot via the ReactPlatform
     */
    private String bodyDefinition;

    public CustomBody(String bodyDefinition) {
        this.bodyDefinition = bodyDefinition;
    }

    /**
     * @return the value
     */
    public String getBodyDefinition() {
        return this.bodyDefinition;
    }

}
