package com.mirror.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class People {
    private List<String> names;
    public void setNames(List<String> names) {
        this.names = names;
    }

    private Set<String> phones;

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }
    private Map<Integer, String> addrs;

    public void setAddrs(Map<Integer, String> addrs) {
        this.addrs = addrs;
    }

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "People{" +
                "names=" + names +
                ", phones=" + phones +
                ", addrs=" + addrs +
                ", properties=" + properties +
                '}';
    }

}
