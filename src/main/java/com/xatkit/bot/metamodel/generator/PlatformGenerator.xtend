package com.xatkit.bot.metamodel.generator

class PlatformGenerator {
	
	def static String platformDefTemplate()
	{
	   	'''
		ReactPlatform reactPlatform = new ReactPlatform();
		ReactEventProvider reactEventProvider = reactPlatform.getReactEventProvider();
		ReactIntentProvider reactIntentProvider = reactPlatform.getReactIntentProvider();
		
		'''
	}
	
	def static String platformUsageTemplate()
	{
	   	'''
        .usePlatform(reactPlatform)
        .listenTo(reactEventProvider)
        .listenTo(reactIntentProvider)
		'''
	}
	
	
	
}