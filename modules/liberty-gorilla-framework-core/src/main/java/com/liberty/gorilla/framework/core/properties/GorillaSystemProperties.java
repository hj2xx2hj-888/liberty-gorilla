package com.liberty.gorilla.framework.core.properties;

import java.util.Map;
import java.util.Properties;

public class GorillaSystemProperties extends Properties {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> map : this.entrySet()) {
            sb.append(map.getKey()).append("=").append(map.getValue()).append("\n");
        }
        return sb.toString();
    }

}
