package com.xatkit.bot.metamodel.generator

import com.xatkit.bot.metamodel.State
import java.util.List
import com.xatkit.bot.metamodel.GuardedTransition

class DOTGenerator {
   def static String dotTemplate(List<State> states)
   {
   	'''
   	digraph transitionGraph {
   		
   		«FOR s : states»
   			«FOR t : s.outTransitions»
   				«IF t instanceof GuardedTransition»
   				    «t.origin.name» -> «t.target.name» [label="«(t as GuardedTransition).getWhen().name»"] 
   		    	«ELSE»		
   					 «t.origin.name» -> «t.target.name»
	            «ENDIF»
   			«ENDFOR»
   		«ENDFOR»
   		
   	}
   	  	
   	'''
   	  	
   	
   }
}