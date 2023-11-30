package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

@XmlRootElement(name = "entry")
public class MiniTrack {

    @XmlElement(name = "title")
    public String title;

    @XmlElement(name = "sortTitle")
    public String sortTitle;

    @XmlElement(name = "id")
    public UUID id;

    @XmlElement(name = "trackNumber")
    public int trackNumber;

    @XmlElement(name = "canPurchase")
    public boolean canPurchase;


    @XmlElement(name = "canPurchaseAlbumOnly")
    public boolean canPurchaseAlbumOnly;

    @XmlElement(name = "length")
    public int lengthSeconds;

    @XmlElement(name = "PointsPrice")
    public int pointsPrice;

    public static MiniTrack fromMongo(Document track) {
        return new MiniTrack(
                track.getString("title"),
                track.getString("sortTitle"),
                UUID.fromString(track.getString("id")),
                track.getInteger("trackNumber"),
                track.getBoolean("canPurchase"),
                track.getBoolean("albumOnly"),
                track.getInteger("lengthSeconds"),
                track.getInteger("pointsPrice"));
    }


    public Document toMongo() {
        Document document = new Document();

        document.put("title", this.title);
        document.put("id", this.id.toString());
        document.put("sortTitle", this.sortTitle);
        document.put("trackNumber", this.trackNumber);
        document.put("canPurchase", this.canPurchase);
        document.put("albumOnly", this.canPurchaseAlbumOnly);
        document.put("lengthSeconds", this.lengthSeconds);
        document.put("pointsPrice", this.pointsPrice);

        return document;
    }

    public MiniTrack(String title, String sortTitle, UUID id, int trackNumber, boolean canPurchase, boolean canPurchaseAlbumOnly, int lengthSeconds, int pointsPrice) {
        this.title = title;
        this.sortTitle = sortTitle;
        this.id = id;
        this.trackNumber = trackNumber;
        this.canPurchase = canPurchase;
        this.canPurchaseAlbumOnly = canPurchaseAlbumOnly;
        this.lengthSeconds = lengthSeconds;
        this.pointsPrice = pointsPrice;
    }

    public MiniTrack() {
    }
}
