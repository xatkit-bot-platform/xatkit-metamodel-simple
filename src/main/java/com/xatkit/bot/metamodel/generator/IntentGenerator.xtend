package com.xatkit.bot.metamodel.generator

import com.xatkit.bot.metamodel.Intent
import java.util.List
import com.xatkit.bot.metamodel.IntentParameter
import com.xatkit.bot.metamodel.CoreIntentParameterType
import com.xatkit.bot.metamodel.Mapping

class IntentGenerator {
	
	def static String intentTemplate(Intent i)
	{
		'''
		val «i.varName» = intent("«i.name»")
			«FOR t : i.getTrainingSentences()»
			.trainingSentence("«t»")
			«ENDFOR»
			«FOR p : i.getParameters()»
			«parameterTemplate(p)»
			«ENDFOR»
		;
		'''
	}
	

	def static String intentsTemplate(List<Intent> intents)
	{
		'''
		«FOR i : intents»
		«intentTemplate(i)»
		«ENDFOR»
		'''
	}
	
	def static String parameterTemplate(IntentParameter p)
	{
	    '''
		.parameter("«p.getName()»")
		.fromFragment("«p.getFragment()»")
		«IF p.getType() instanceof CoreIntentParameterType » 
		««« Primitive Paremeter types use "()" next to the name in our syntax
		.entity(«p.getType().getName»())
		«ELSEIF p.getType() instanceof Mapping»
		.entity(«(p.getType() as Mapping).getVarName»)
		«ELSE»
		.entity(«p.getType().getName»)
		«ENDIF»
		'''		
	}

	
}