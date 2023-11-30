package me.hyname.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
public class GenreInstance {
    @XmlElement(name = "id")
    public
    String id;

    @XmlElement(name = "title")
    public
    String title;

    public GenreInstance(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public GenreInstance() {
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}

