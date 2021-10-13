package com.xatkit.bot.metamodel.generator

import java.util.List
import com.xatkit.bot.metamodel.Mapping
import com.xatkit.bot.metamodel.MappingEntry
import com.xatkit.bot.metamodel.IntentParameterType

/**
 * Generator of the calls to the Fluent API for the generation of {@link Mapping}s.
 */
 
class MappingGenerator {
	
	def static String mappingTemplate(Mapping m)
	{
		'''
		val «m.varName» = mapping("«m.getName()»")
			«FOR me : m.getEntries()»
			«mappingEntryTemplate(me)»
			«ENDFOR»
		;
		'''
	}
	
	def static String mappingEntryTemplate(MappingEntry me)
	{
		'''
		.entry().value("«me.getValue()»")
			«FOR s : me.getSynonyms()»
			.synonym("«s»")
			«ENDFOR»
		'''
		
	}
	
	def static String mappingsTemplate(List<IntentParameterType> types)
	{
		'''
		«FOR t : types»
			«IF t instanceof Mapping» 
			«mappingTemplate(t)»
			«ENDIF»
		«ENDFOR»
		'''
	}
	

	
}