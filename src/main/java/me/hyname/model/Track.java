package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

@XmlRootElement(name = "entry")
public class Track {

    @XmlElement(name = "title")
    public String sortTitle;

    @XmlElement(name = "sortTitle")
    public String title;

    @XmlElement(name = "id")
    public UUID id;

    @XmlElement(name = "length")
    public int lengthSeconds;

    @XmlElement(name = "trackNumber")
    public int trackNumber;

    @XmlElement(name = "discNumber")
    public int discNumber;

    @XmlElement(name = "album")
    public MiniAlbum album;

    @XmlElement(name = "albumArtist")
    public MiniArtist albumArtist;

    @XmlElement(name = "playCount")
    public int playCount;

    @XmlElement(name = "musicVideoId")
    public UUID musicVideoId;

    @XmlElement(name = "PointsPrice")
    public int pointsPrice;

    @XmlElement(name = "CanPlay")
    public boolean canPlay;

    @XmlElement(name = "CanDownload")
    public boolean canDownload;

    @XmlElement(name = "CanPurchase")
    public boolean canPurchase;

    @XmlElement(name = "CanPurchaseMP3")
    public boolean canPurchaseMP3;

    @XmlElement(name = "CanPurchaseAlbumOnly")
    public boolean canPurchaseAlbumOnly;

    @XmlElement(name = "CanSync")
    public boolean canSync;

    @XmlElement(name = "CanBurn")
    public boolean canBurn;

    @XmlElement(name = "InCollection")
    public boolean inCollection;

    @XmlElement(name = "IsDownloading")
    public boolean isDownloading;

    public Track(String sortTitle, String title, UUID id, Integer lengthSeconds, Integer trackNumber, Integer discNumber, MiniAlbum album, MiniArtist albumArtist, Integer playCount, String musicVideoId, Integer pointsPrice, Boolean canPlay, Boolean canDownload, Boolean canPurchase, Boolean canPurchaseMP3, Boolean canPurchaseAlbumOnly, Boolean canSync, Boolean canBurn, Boolean inCollection, Boolean isDownloading) {
        this.sortTitle = sortTitle;
        this.title = title;
        this.id = id;
        this.lengthSeconds = lengthSeconds;
        this.trackNumber = trackNumber;
        this.discNumber = discNumber;
        this.album = album;
        this.albumArtist = albumArtist;
        this.playCount = playCount;
        this.musicVideoId = UUID.fromString(musicVideoId);
        this.pointsPrice = pointsPrice;
        this.canPlay = canPlay;
        this.canDownload = canDownload;
        this.canPurchase = canPurchase;
        this.canPurchaseMP3 = canPurchaseMP3;
        this.canPurchaseAlbumOnly = canPurchaseAlbumOnly;
        this.canSync = canSync;
        this.canBurn = canBurn;
        this.inCollection = inCollection;
        this.isDownloading = isDownloading;
    }

    public Track() {

    }

    public Document toMongo() {
        Document toDb = new Document();
        toDb.put("sortTitle", this.sortTitle);
        toDb.put("id", this.id.toString());
        toDb.put("lengthSeconds", this.lengthSeconds);
        toDb.put("trackNumber", this.trackNumber);
        toDb.put("discNumber", this.discNumber);
        toDb.put("album", this.album.toMongo());
        toDb.put("albumArtist", this.albumArtist.toMongo());
        toDb.put("playCount", this.playCount);
        toDb.put("musicVideoId", this.musicVideoId.toString());
        toDb.put("pointsPrice", this.pointsPrice);
        toDb.put("canPlay", canPlay);
        toDb.put("canDownload", canDownload);
        toDb.put("canPurchase", canPurchase);
        toDb.put("canPurchaseMP3", canPurchaseMP3);
        toDb.put("canPurchaseAlbumOnly", canPurchaseAlbumOnly);
        toDb.put("canSync", canSync);
        toDb.put("canBurn", canBurn);
        toDb.put("inCollection", inCollection);
        toDb.put("isDownloading", isDownloading);
        return toDb;
    }

}
