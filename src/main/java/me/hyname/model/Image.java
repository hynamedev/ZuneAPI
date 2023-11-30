package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name = "image")
public class Image {


    @XmlElement(name = "id")
    private UUID id;

    @XmlElementWrapper(name = "instances", namespace = "http://schemas.zune.net/catalog/music/2007/10")
    @XmlElement(name = "imageInstance")
    private List<ImageInstance> instances;

    public static Image fromMongo(Document albumImage) {
        UUID id = UUID.fromString(albumImage.getString("id"));
        List<ImageInstance> instances = new ArrayList<>();
        for(Document instance : albumImage.getList("instances", Document.class)) {
            instances.add(ImageInstance.fromMongo(instance));
        }
        return new Image(id, instances);
    }

    public Document toMongo() {
        Document document = new Document();

        document.put("id", this.id.toString());
        List<Document> instanceArray = new ArrayList<>();
        for(ImageInstance ins : this.instances) {
            instanceArray.add(ins.toMongo());
        }
        document.put("instances", instanceArray);

        return document;
    }

    public Image(UUID id, List<ImageInstance> instances) {
        this.id = id;
        this.instances = instances;
    }

    public Image() {
    }
}
