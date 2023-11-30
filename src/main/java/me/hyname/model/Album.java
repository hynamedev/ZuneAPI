package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name = "feed")
public class Album {

    @XmlElement(name = "title")
    public String title;

    @XmlElement(name = "sortTitle")
    public String sortTitle;

    @XmlElement(name = "id")
    public UUID id;

    @XmlElement(name = "primaryArtist")
    public MiniArtist primaryArtist;

    @XmlElement(name = "primaryGenre")
    public Genre primaryGenre;

    @XmlElement(name = "playRank")
    public int popularity;

    @XmlElement(name = "isExplicit")
    public boolean explicit;


    @XmlElement(name = "isPremium")
    public boolean premium;

    @XmlElement(name = "image")
    public List<MiniImage> images;

    @XmlElement(name = "releaseDate")
    public Date releaseDate;

    @XmlElement(name = "entry")
    public List<MiniTrack> tracks;

    public Album(String title, String sortTitle, UUID id, MiniArtist primaryArtist, Genre primaryGenre, int popularity, Boolean explicit, Boolean premium, List<MiniImage> images, Date releaseDate, List<MiniTrack> tracks) {
        this.title = title;
        this.sortTitle = sortTitle;
        this.id = id;
        this.primaryArtist = primaryArtist;
        this.primaryGenre = primaryGenre;
        this.popularity = popularity;
        this.explicit = explicit;
        this.premium = premium;
        this.images = images;
        this.releaseDate = releaseDate;
        this.tracks = tracks;
    }

    public Album() {

    }


    public Document toMongo() {
        Document toDb = new Document();
        toDb.put("sortTitle", this.sortTitle);
        toDb.put("title", this.title);
        toDb.put("id", this.id.toString());
        toDb.put("primaryArtist", this.primaryArtist.toMongo());
        toDb.put("primaryGenre", this.primaryGenre.toMongo());
        toDb.put("popularity", this.popularity);
        toDb.put("explicit", this.explicit);
        toDb.put("premium", this.premium);

        List<Document> imageArray = new ArrayList<>();
        for(MiniImage i : this.images) {
            imageArray.add(i.toMongo());
        }

        toDb.put("images", imageArray);
        toDb.put("releaseDate", releaseDate);

        List<Document> trackArray = new ArrayList<>();
        for(MiniTrack t : this.tracks) {
            trackArray.add(t.toMongo());
        }
        toDb.put("tracks", trackArray);
        return toDb;
    }
}
