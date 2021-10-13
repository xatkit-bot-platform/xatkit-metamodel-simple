package com.xatkit.bot.metamodel.generator

import com.xatkit.core.recognition.dialogflow.DialogFlowConfiguration;

class ConfFileGenerator { 
	def static String confTemplate(BotToCodeConfProperties conf)
    {
      	'''
    	# Configuration properties for the bot
    	
    	«IF conf.getServerPort() !== null»
    	xatkit.server.port = «conf.getServerPort()»
    	«ENDIF»
    	«IF conf.getDialogflowProjectId !== null»
		«DialogFlowConfiguration.PROJECT_ID_KEY» = «conf.getDialogflowProjectId()»
		«DialogFlowConfiguration.GOOGLE_CREDENTIALS_PATH_KEY» = «conf.getDialogflowCredentialsPath()»
		«DialogFlowConfiguration.LANGUAGE_CODE_KEY» = «conf.getDialogflowLanguage()»
		«DialogFlowConfiguration.CLEAN_AGENT_ON_STARTUP_KEY» = «conf.dialogflowCleanOnStartup»
    	«ENDIF»
    	'''
    }
	
}