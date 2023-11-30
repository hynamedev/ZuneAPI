package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
public class Artist {

    @XmlElement(name = "sortTitle")
    private String sortTitle;

    @XmlElement(name = "title")
    private String title = sortTitle;


    @XmlElement(name = "id")
    public UUID id;

    @XmlElement(name = "imageId")
    private UUID imageId;

    @XmlElement(name = "popularity")
    private double popularity;

    @XmlElement(name = "isVariousArtist")
    private boolean isVariousArtist;

    @XmlElement(name = "biographyLink")
    private String biographyLink;

    @XmlElement(name = "biography")
    private String biography;

    @XmlElement(name = "shortBiography")
    private String shortBiography;

    @XmlElement(name = "playCount")
    private int playCount;

    @XmlElement(name = "primaryGenre")
    private Genre primaryGenre;

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    private List<Genre> genres;

    @XmlElementWrapper(name = "moods")
    @XmlElement(name = "mood")
    private List<Mood> moods;

    @XmlElement(name = "backgroundImage")
    private MiniImage backgroundImage;

    @XmlElement(name = "hasRadioChannel")
    private boolean hasRadioChannel;

    @XmlElement(name = "image")
    private List<MiniImage> images;

    public Artist(String sortTitle, String title, UUID id, UUID imageId, Double popularity, Boolean isVariousArtist, String biographyLink, String biography, String shortBiography, Integer playCount, Genre primaryGenre, List<Genre> genres, List<Mood> moods, MiniImage backgroundImage, Boolean hasRadioChannel, List<MiniImage> images) {
        this.sortTitle = sortTitle;
        this.title = title;
        this.id = id;
        this.imageId = imageId;
        this.popularity = popularity;
        this.isVariousArtist = isVariousArtist;
        this.biographyLink = biographyLink;
        this.biography = biography;
        this.shortBiography = shortBiography;
        this.playCount = playCount;
        this.primaryGenre = primaryGenre;
        this.genres = genres;
        this.moods = moods;
        this.backgroundImage = backgroundImage;
        this.hasRadioChannel = hasRadioChannel;
        this.images = images;
    }

    public Artist() {

    }

    // yes theres probably a much more efficient way to do this
    // shut up, its 2 AM im tired i dont care
    public Document toMongo() {
        Document toDb = new Document();
        toDb.put("sortTitle", this.sortTitle);
        toDb.put("title", this.title);
        toDb.put("id", this.id.toString());
        toDb.put("imageId", this.imageId.toString());
        toDb.put("popularity", this.popularity);
        toDb.put("isVariousArtist", this.isVariousArtist);
        toDb.put("biographyLink", this.biographyLink);
        //toDb.put("biography", this.biography);
        toDb.put("shortBiography", this.shortBiography);
        toDb.put("playCount", this.playCount);
        toDb.put("primaryGenre", this.primaryGenre.toMongo());

        List<Document> genreArray = new ArrayList<>();
        for(Genre g : this.genres) {
            genreArray.add(g.toMongo());
        }

        toDb.put("genres", genreArray);

        List<Document> moodArray = new ArrayList<>();
        for(Mood m : this.moods) {
            moodArray.add(m.toMongo());
        }

        toDb.put("moods", moodArray);
        toDb.put("backgroundImage", this.backgroundImage.toMongo());
        toDb.put("hasRadioChannel", this.hasRadioChannel);

        List<Document> imageArray = new ArrayList<>();
        for(MiniImage i : this.images) {
            imageArray.add(i.toMongo());
        }

        toDb.put("images", imageArray);
        return toDb;
    }

    public String getName() {
        return this.title;
    }

    public UUID getDbId() {
        return this.id;
    }


    public List<Genre> getArtistGenres() {
        return this.genres;
    }


    public Genre getArtistPrimaryGenre() {
        return this.primaryGenre;
    }

    public List<Mood> getArtistMoods() { return moods; }

    public String getBio() {
        return biography;
    }

    public List<MiniImage> getArtistImages() {
        return images;
    }
}

