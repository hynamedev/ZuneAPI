package me.hyname.model;

import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feed", namespace = "http://www.w3.org/2005/Atom")
public class Feed<T> {
    private List<T> entries;

    @XmlElement(name = "entry")
    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
}
