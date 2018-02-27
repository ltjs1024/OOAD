package com.stone.guitar;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 乐器一般特性
 */
public class InstrumentSpec {
    private Map<String, Object> properties = null;

    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new LinkedHashMap<>();
        } else {
            this.properties = new LinkedHashMap<>(properties);
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }


    public boolean matches(InstrumentSpec otherSpec) {
        for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext(); ) {
            String propertyName = (String) i.next();
            if (!otherSpec.getProperty(propertyName).equals(properties.get(propertyName))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Iterator i = properties.keySet().iterator(); i.hasNext(); ) {
            String propertyName = (String) i.next();
            sb.append(" ");
            sb.append(propertyName).append("='");
            sb.append(properties.get(propertyName)).append("',");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
