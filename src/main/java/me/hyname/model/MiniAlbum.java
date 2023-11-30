package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.UUID;


@XmlRootElement(name = "album")
public class MiniAlbum {

    @XmlElement(name = "title")
    public String title;

    @XmlElement(name = "id")
    public UUID id;

    public static MiniAlbum fromMongo(Document album) {
        return new MiniAlbum(album.getString("title"), UUID.fromString(album.getString("id")));
    }


    public Document toMongo() {
        Document document = new Document();

        document.put("title", this.title);
        document.put("id", this.id.toString());

        return document;
    }

    public MiniAlbum(String title, UUID id) {
        this.title = title;
        this.id = id;
    }

    public MiniAlbum() {
    }

}
