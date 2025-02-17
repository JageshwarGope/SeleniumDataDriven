package Keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationKeywords extends ValidationKeywords {
    public ApplicationKeywords() {
        prop = new Properties();
        try {
            String filePath = System.getProperty("user.dir")+"/src/main/resources/properties/ProjectKeys.properties";
            System.out.println("Loading properties file from: " + filePath); // Debugging output
            
            FileInputStream fs = new FileInputStream(filePath);
            prop.load(fs);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Properties file not found at the specified location.");
            e.printStackTrace();
        } catch (IOException e) {   // this catch is for prop.load(fs);
            System.out.println("ERROR: Unable to read the properties file.");
            e.printStackTrace();
        }
    }
}

