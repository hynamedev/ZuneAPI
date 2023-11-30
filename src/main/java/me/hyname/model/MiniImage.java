package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "image")
public class MiniImage {


    @XmlElement(name = "id")
    private UUID id;

    public MiniImage(UUID id) {
        this.id = id;
    }


    public MiniImage() {

    }
    public static MiniImage fromMongo(Document imageDoc) {
        return new MiniImage(UUID.fromString(imageDoc.getString("id")));
    }

    public Document toMongo() {
        Document document = new Document();

        document.put("id", this.id.toString());

        return document;
    }
}
