package me.hyname.model;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
public class Feature {
    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "link")
    private MediaLink link;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "content")
    private String content;

    @XmlElement(name = "sequenceNumber")
    private int sequenceNumber;

    @XmlElement(name = "image")
    private MiniImage image;

    @XmlElement(name = "backgroundImage")
    private MiniImage backgroundImage;

    @XmlElement(name = "isExplicit")
    private boolean isExplicit;

    public Feature() {
    }

    public Feature(String id, MediaLink link, String title, String content, int sequenceNumber, MiniImage image, MiniImage backgroundImage, boolean isExplicit) {
        this.id = id;
        this.link = link;
        this.title = title;
        this.content = content;
        this.sequenceNumber = sequenceNumber;
        this.image = image;
        this.backgroundImage = backgroundImage;
        this.isExplicit = isExplicit;
    }
}
