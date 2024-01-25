package org.example.factory;

import org.example.Main;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class DIFramework {
    public static HashMap<String, Object> beanRegistry;

    static {
        Properties properties = new Properties();
        try {
            InputStream input = Main.class.getResourceAsStream("/dependencies.properties");
            if (input == null) {
                System.out.println("Sorry, unable to find dependencies.properties");
            }

            properties.load(input);  // This is where the issue may occur
            beanRegistry = new HashMap<>();

            for (Object key : properties.keySet()) {
                var keyName = key.toString();
                var val = properties.getProperty(keyName);

                if (keyName.startsWith("object.")) {
                    var beanName = keyName.replace("object.", "");
                    Class clz = Class.forName(val);
                    beanRegistry.put(beanName, clz.getDeclaredConstructor().newInstance());
                } else {
                    String[] keys = keyName.split("\\.");
                    Object obj = beanRegistry.get(keys[0]);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(keys[1], obj.getClass());
                    System.out.println(propertyDescriptor.getName());
                    propertyDescriptor.getWriteMethod().invoke(obj, beanRegistry.get(val));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
