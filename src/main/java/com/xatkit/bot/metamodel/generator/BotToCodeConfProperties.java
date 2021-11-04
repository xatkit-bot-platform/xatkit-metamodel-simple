package com.xatkit.bot.metamodel.generator;

import org.apache.commons.configuration2.Configuration;

/**
 * Configuration of the generation template.
 * <p>
 * This class is initialized with sensible default values when not provided by the Configuration object
 */
public class BotToCodeConfProperties {
        private String botName;
        private String outputFolder;
        private String serverPort;
        private String defaultFallbackMsg;
        private String inputDocName;

        private String dialogflowProjectId;
        private String dialogflowCredentialsPath;
        private String dialogflowLanguage;
        private boolean dialogflowCleanOnStartup;

        public BotToCodeConfProperties() {
        
        }
        /**
        * Creates a {@link BotToCodeConfProperties} from the provided {@code configuration}.
        *
        * @param configuration the {@link Configuration}
        * @return the created {@link BotToCodeConfProperties}
        */
        public static BotToCodeConfProperties from(Configuration configuration) {
                BotToCodeConfProperties result = new BotToCodeConfProperties();
                result.setBotName(configuration.getString("xls.generator.bot.name", "TestBot"));
                result.setOutputFolder(configuration.getString("xls.generator.output", "results/"));
                result.setServerPort(configuration.getString("xatkit.server.port", "5000"));
                result.setDefaultFallbackMsg(configuration.getString("xls.generator.bot.fallbackMsg",
                        "Sorry, I didn't get it, please try again rephrasing your question"));
                result.setInputDocName(configuration.getString("xls.importer.xls"));

                result.setDialogflowProjectId(configuration.getString("xatkit.dialogflow.projectId", null));
                result.setDialogflowCredentialsPath(configuration.getString("xatkit.dialogflow.credentials.path", "/"));
                result.setDialogflowLanguage(configuration.getString("xatkit.dialogflow.language", "en-US"));
                result.setDialogflowCleanOnStartup(configuration.getBoolean("xatkit.dialogflow.clean_on_startup", false));

                return result;
        }

        public String getBotName() {
            return botName;
        }

        public void setBotName(String botName) {
            this.botName = botName;
        }

        public String getOutputFolder() {
            return outputFolder;
        }

        public void setOutputFolder(String outputFolder) {
            this.outputFolder = outputFolder;
        }

        public String getServerPort() {
            return serverPort;
        }

        public void setServerPort(String serverPort) {
            this.serverPort = serverPort;
        }

        public String getDefaultFallbackMsg() {
            return defaultFallbackMsg;
        }

        public void setDefaultFallbackMsg(String defaultFallbackMsg) {
            this.defaultFallbackMsg = defaultFallbackMsg;
        }

        public String getInputDocName() {
            return inputDocName;
        }

        public void setInputDocName(String inputDocName) {
            this.inputDocName = inputDocName;
        }

        public String getDialogflowProjectId() {
            return dialogflowProjectId;
        }

        public void setDialogflowProjectId(String dialogflowProjectId) {
            this.dialogflowProjectId = dialogflowProjectId;
        }

        public String getDialogflowCredentialsPath() {
            return dialogflowCredentialsPath;
        }

        public void setDialogflowCredentialsPath(String dialogflowCredentialsPath) {
            this.dialogflowCredentialsPath = dialogflowCredentialsPath;
        }

        public String getDialogflowLanguage() {
            return dialogflowLanguage;
        }

        public void setDialogflowLanguage(String dialogflowLanguage) {
            this.dialogflowLanguage = dialogflowLanguage;
        }

        public boolean isDialogflowCleanOnStartup() {
            return dialogflowCleanOnStartup;
        }

        public void setDialogflowCleanOnStartup(boolean dialogflowCleanOnStartup) {
            this.dialogflowCleanOnStartup = dialogflowCleanOnStartup;
        }

}
