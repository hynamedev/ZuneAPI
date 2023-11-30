package me.hyname.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link", namespace = "http://schemas.zune.net/catalog/music/2007/10")
public class MediaLink {
    @XmlElement(name = "type")
    public String type;

    @XmlElement(name = "target")
    public String target;

    public MediaLink(String type, String target) {
        this.type = type;
        this.target = target;
    }

    public MediaLink() {
    }
}
