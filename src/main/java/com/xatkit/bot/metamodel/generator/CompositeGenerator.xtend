package com.xatkit.bot.metamodel.generator

import java.util.List
import com.xatkit.bot.metamodel.Mapping
import com.xatkit.bot.metamodel.Composite
import com.xatkit.bot.metamodel.CompositeEntry
import com.xatkit.bot.metamodel.IntentParameterType
import com.xatkit.bot.metamodel.CoreIntentParameterType

/**
 * Generator of the calls to the Fluent API for the generation of {@link Mapping}s.
 */
 
class CompositeGenerator {
	
	def static String compositeTemplate(Composite c)
	{
		'''
		val «c.varName» = composite("«c.getName()»")
			«FOR ce : c.getEntries()»
			«compositeEntryTemplate(ce)»
			«ENDFOR»
		;
		'''
	}
	
	def static String compositeEntryTemplate(CompositeEntry ce)
	{
		'''
		.entry()
			«FOR e : ce.getEntities()»
			«IF e instanceof CoreIntentParameterType »
			.entity(DSL.«e.getName»())
			«ELSEIF e instanceof Mapping»
			.entity(«(e as Mapping).getVarName»)
			«ELSEIF e instanceof Composite»
			.entity((EntityDefinitionReferenceProvider) «(e as Composite).getVarName»)
			«ELSE»
			.entity(«e.getName»)
			«ENDIF»
		«ENDFOR»
		'''
		
	}
	
	def static String compositesTemplate(List<IntentParameterType> types)
	{
		'''
		«FOR t : types»
			«IF t instanceof Composite» 
			«compositeTemplate(t)»
			«ENDIF»
		«ENDFOR»
		'''
	}
	

	
}