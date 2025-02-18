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
        } catch (Exception e) {
            System.out.println("ERROR: Properties file not found at the specified location.");
            e.printStackTrace();
        }
    }
}

