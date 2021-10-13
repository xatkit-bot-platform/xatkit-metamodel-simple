package com.xatkit.bot.metamodel.generator
 
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.io.File
import com.xatkit.bot.metamodel.Bot

class BotToCode {
	
	def static createBot(Bot bot, BotToCodeConfProperties conf)
	{
		var String botName = conf.getBotName();
		var String outputFolder = conf.getOutputFolder();
		println("Attempting to create the bot " + botName + " in " + outputFolder);
	    try	{
		    deleteFolder(new File(outputFolder)); //Cleaning the folder before we start the generation
		} catch (Exception e) {
			println("Error deleting the existing content of the " + outputFolder + " folder. Maybe it does not exist?")
		}
			
		//Creating the project folder structure
		System.out.println("Creating the project structure");
		Files.createDirectories(Paths.get(outputFolder));
		Files.createDirectories(Paths.get(outputFolder+"/src/main/java/"));
		Files.createDirectories(Paths.get(outputFolder+"/src/main/resources/"));
		Files.createDirectories(Paths.get(outputFolder+"/src/test/java/"));
		Files.createDirectories(Paths.get(outputFolder+"/src/test/resources/"));
				
		//Creating the pom.xml file		
		System.out.println("Creating the pom file");
		var Path pomFile = Files.createFile(Paths.get(outputFolder+"pom.xml"));
		Files.write(pomFile,POMBotGenerator.pomTemplate(botName).getBytes());
			
		System.out.println("Creating the bot configuration file");	
		//Creating the bot configuration file	
		var Path confFile = Files.createFile(Paths.get(outputFolder+"/src/main/resources/bot.properties"));
		Files.write(confFile,ConfFileGenerator.confTemplate(conf).getBytes());		
			
		System.out.println("Creating the bot definition file");			
		//Creating the actual bot file
		var Path botFile = Files.createFile(Paths.get(outputFolder+"/src/main/java/"+botName+".java"));
		Files.write(botFile,CoreBotGenerator.botTemplate(conf,bot).getBytes());
		
		System.out.println("Creating the Dot visualization file");		
		var Path dotFile = Files.createFile(Paths.get(outputFolder+"/src/main/resources/"+botName+".gv"));
		Files.write(dotFile,DOTGenerator.dotTemplate(bot.getStates).getBytes());	
	}
	
	def static void deleteFolder(File file){
      for (File subFile : file.listFiles()) {
         if (subFile.isDirectory()) {
            deleteFolder(subFile);
         } else {
            subFile.delete();
         }
      }
      file.delete();
   }
   			
	
}
