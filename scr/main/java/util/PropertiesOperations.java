package util;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesOperations {

static Properties prop = new Properties();

public static String getPropertyValueByKey(String key) {
// 1. load data from properties file
String propFilePath = System.getProperty("user.dir") + "/src/main/java/config/config.properties";
FileInputStream fis;
try {
fis = new FileInputStream(propFilePath);
prop.load(fis);
} catch (Exception e) {
e.printStackTrace();
}

// 2. read data
String value = prop.get(key).toString();

if (value.isEmpty()) {
try {
throw new Exception("Value is not specified for key: " + key + " in properties file.");
} catch (Exception e) {
}
}

return value;
}
}
