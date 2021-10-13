package com.xatkit.bot.metamodel.generator

import com.xatkit.bot.metamodel.State
import java.util.List
import com.xatkit.bot.metamodel.CustomBody
import com.xatkit.bot.metamodel.ReactReply
import com.xatkit.bot.metamodel.GuardedTransition

class StateGenerator {
	
	def static String statesDefTemplate(List<State> states)
	{
		'''
		val init = state("Init");
		«FOR s : states»
		«stateDefTemplate(s)»
		«ENDFOR»
		'''
	}
	
	def static String stateDefTemplate(State s)
	{
		'''
		val «s.varName» = state("«s.name»");
		'''
	}
	

	def static String statesBodyTemplate(List<State> states)
	{
		'''
		«FOR s : states»
		«stateBodyTemplate(s)»
		«ENDFOR»
		'''
	}
	
	def static String stateBodyTemplate(State s)
	{
		'''
		«s.varName»
			«IF s.getBody() instanceof CustomBody»
			.body(«(s.getBody() as CustomBody).getBodyDefinition()»)
			«ELSEIF s.getBody() instanceof ReactReply»
			.body(context->reactPlatform.reply(context,"«(s.getBody() as ReactReply).getReply()»"))
			«ENDIF»	
			.next()
			«FOR t : s.outTransitions»
			«IF t instanceof GuardedTransition»
			.when(intentIs(«(t as GuardedTransition).getWhen().varName»)).moveTo(«t.target.varName»)
		    «ELSE»
			.moveTo(«t.target.varName»)
			«ENDIF»	 
			«ENDFOR»
		;
		'''
		
	}
		
}