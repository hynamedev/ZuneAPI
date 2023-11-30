package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "imageInstance", namespace = "http://schemas.zune.net/catalog/music/2007/10")

public class ImageInstance {

    @XmlElement(name = "id")
    private UUID id;

    @XmlElement(name = "url")
    private String url;

    @XmlElement(name = "format")
    private String format;

    @XmlElement(name = "width")
    private int width;

    @XmlElement(name = "height")
    private int height;

    public static ImageInstance fromMongo(Document instance) {
        UUID id = UUID.fromString(instance.getString("id"));
        String url = instance.getString("url");
        String format = instance.getString("format");
        int width = instance.getInteger("width");
        int height = instance.getInteger("height");
        return new ImageInstance(id, url, format, width, height);
    }

    public Document toMongo() {
        Document document = new Document();

        document.put("id", this.id.toString());
        document.put("url", this.url);
        document.put("format", this.format);
        document.put("width", this.width);
        document.put("height", this.height);

        return document;
    }

    public ImageInstance(UUID id, String url, String format, int width, int height) {
        this.id = id;
        this.url = url;
        this.format = format;
        this.width = width;
        this.height = height;
    }

    public ImageInstance() {
    }
}
