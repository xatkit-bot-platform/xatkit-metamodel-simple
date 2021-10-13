package com.xatkit.bot.metamodel;

public class ResourceEntry {

    private String name;
    private String url;

    public ResourceEntry(String name, String url) {
        this.setName(name);
        this.setUrl(url);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }
}
