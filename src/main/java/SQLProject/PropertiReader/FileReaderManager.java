package SQLProject.PropertiReader;
import SQLProject.PropertiReader.PropertiesReader;
public class FileReaderManager {




        private static FileReaderManager fileReaderManager = new FileReaderManager();
        private static PropertiesReader configFileReader;

        private FileReaderManager() {
        }

        public static FileReaderManager getInstance( ) {
            return fileReaderManager;
        }

        public PropertiesReader getConfigReader() {
            return (configFileReader == null) ? new PropertiesReader() : configFileReader;
        }

}
