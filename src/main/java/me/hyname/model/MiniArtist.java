package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "artist")
public class MiniArtist {

    @XmlElement(name = "name")
    public String title;

    @XmlElement(name = "id")
    public UUID id;

    public MiniArtist(String name, UUID dbId) {
        this.title = name;
        this.id = dbId;
    }

    public MiniArtist() {
    }

    public static MiniArtist fromMongo(Document artist) {
        return new MiniArtist(artist.getString("title"), UUID.fromString(artist.getString("id")));
    }


    public Document toMongo() {
        Document document = new Document();

        document.put("name", this.title);
        document.put("id", this.id.toString());

        return document;
    }
}
