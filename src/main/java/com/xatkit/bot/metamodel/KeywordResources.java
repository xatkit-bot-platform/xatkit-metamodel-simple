package com.xatkit.bot.metamodel;

import java.util.ArrayList;
import java.util.List;

public class KeywordResources {

    private String keyword;
    private List<ResourceEntry> resources = new ArrayList<>();

    public KeywordResources(String name) {
        this.setKeyword(name);
    }

    public void addResourceEntry(ResourceEntry resourceEntry) {
        this.resources.add(resourceEntry);
    }
    
    public List<ResourceEntry> getResources() {
	return resources;
    }

    public String getKeyword() {
	return keyword;
    }

    public void setKeyword(String keyword) {
	this.keyword = keyword;
    }
}
