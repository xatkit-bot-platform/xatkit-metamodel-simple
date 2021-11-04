package com.xatkit.bot.metamodel.generator

import com.xatkit.bot.metamodel.Bot

class CoreBotGenerator {
	def static String botTemplate(BotToCodeConfProperties conf, Bot bot)
	{
		var String botName = conf.getBotName();
		var String defaultFallbackMsg = conf.getDefaultFallbackMsg();
		'''
		import com.opencsv.CSVReader;
		import com.opencsv.exceptions.CsvException;
		import com.xatkit.core.XatkitBot;
		import com.xatkit.dsl.DSL;		
		import com.xatkit.dsl.entity.EntityDefinitionReferenceProvider;
		import com.xatkit.plugins.react.platform.ReactPlatform;
		import com.xatkit.plugins.react.platform.io.ReactEventProvider;
		import com.xatkit.plugins.react.platform.io.ReactIntentProvider;
		import lombok.val;
		import org.apache.commons.configuration2.BaseConfiguration;
		import org.apache.commons.configuration2.Configuration;
		import org.apache.commons.configuration2.builder.fluent.Configurations;
		import org.apache.commons.configuration2.ex.ConfigurationException;
		import org.apache.commons.lang3.tuple.ImmutableTriple;
		
		import java.io.FileReader;
		import java.io.IOException;
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.List;
		import java.util.Map;
		import java.util.stream.Collectors;
		
		import static com.xatkit.dsl.DSL.composite;
		import static com.xatkit.dsl.DSL.eventIs;
		import static com.xatkit.dsl.DSL.fallbackState;
		import static com.xatkit.dsl.DSL.intent;
		import static com.xatkit.dsl.DSL.intentIs;
		import static com.xatkit.dsl.DSL.mapping;
		import static com.xatkit.dsl.DSL.model;
		import static com.xatkit.dsl.DSL.state;
		
		/*
		 * This is a generated bot from «conf.getInputDocName()»
		*/
		public class «botName» {
		
			public static void main(String[] args) {
			
			/*
			 * Define the mapping entities our bot will use.
			 */
			«MappingGenerator.mappingsTemplate(bot.getTypes())»
			
			/*
			 * Define the composite entities our bot will use.
			 */
			«CompositeGenerator.compositesTemplate(bot.getTypes())»
						
			/*
			 * Define the intents our bot will react to.
			 */
			«IntentGenerator.intentsTemplate(bot.getIntents())»
			
			/*
			 * Instantiate the platform and providers we will use in the bot definition.
			 */
			«PlatformGenerator.platformDefTemplate()»
			
			/*
			 * Create the states we want to use in our bot.
			 */
			«StateGenerator.statesDefTemplate(bot.getStates())» 
			
			/*
			 * Specify the content of the bot states (i.e. the behavior of the bot).
			 * 
			 */
			init
				.next()
				/*
				 * We check that the received event matches the ClientReady event defined in the
				 * ReactEventProvider. The list of events defined in a provider is available in the provider's
				 * wiki page.
				 */
				.when(eventIs(ReactEventProvider.ClientReady)).moveTo(awaitingInput)
			;
			«StateGenerator.statesBodyTemplate(bot.getStates())» 
			
			/*
			 * The state that is executed if the engine doesn't find any navigable transition in a state and the state
			 * doesn't contain a fallback.
			 */
			val defaultFallback = fallbackState()
				.body(context -> reactPlatform.reply(context, "«defaultFallbackMsg»"));
			
			/*
			 * Creates the bot model that will be executed by the Xatkit engine.
			 */
			val botModel = model()
				«PlatformGenerator.platformUsageTemplate()» 
				.initState(init)
				.defaultFallbackState(defaultFallback);
			
			Configuration botConfiguration = new BaseConfiguration();
			/*
			 * Add configuration properties (e.g. authentication tokens, platform tuning, intent provider to use).
			 * Check the corresponding platform's wiki page for further information on optional/mandatory parameters and
			 * their values.
			 */
			Configurations configurations = new Configurations();
			try {
				botConfiguration = configurations.properties(«botName».class.getClassLoader().getResource("bot.properties"));
			} catch (ConfigurationException e) {
				e.printStackTrace();
				System.out.println("file not found");
			}
			
			XatkitBot xatkitBot = new XatkitBot(botModel, botConfiguration);
			xatkitBot.run();
			/*
			 * The bot is now started, you can check http://localhost:5000/admin to test it.
			 * The logs of the bot are stored in the logs folder at the root of this project.
			 */
			}
		}
		'''
	}
}