package me.hyname.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
public class Biography {
    @XmlElement(name = "updated")
    Date updated;

    @XmlElement(name = "title")
    String title;

    @XmlElement(name = "id")
    UUID id;
    @XmlElement(name = "content")
    String content;

    @XmlElement(name = "author")
    String authorName;

    public Biography() {
    }

    public Biography(Date updated, String title, UUID id, String content, String authorName) {
        this.updated = updated;
        this.title = title;
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
}

