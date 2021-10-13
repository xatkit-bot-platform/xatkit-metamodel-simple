package com.xatkit.bot.metamodel;

public class ReactReply implements StateBody {
    /**
     * The string representing the textual answer to be printed by the bot via the ReactPlatform
     */
    private String reply;

    public ReactReply(String reply) {
        this.reply = reply;
    }

    /**
     * @return the value
     */
    public String getReply() {
        return this.reply;
    }

}
