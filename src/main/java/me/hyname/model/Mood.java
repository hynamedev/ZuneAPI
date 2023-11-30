package me.hyname.model;

import org.bson.Document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mood")
public enum Mood {
    UPBEAT("upbeat", "Upbeat"),
    JOYFUL("joyful", "Joyful"),
    EXPERIMENTAL("experimental", "Experimental"),
    EMOTIONAL("emotional", "Emotional"),

    SAD("sad", "Sad"),
    DEFIANT("defiant", "Defiant"),
    BITTERSWEET("bittersweet", "Bittersweet"),
    ANGRY("angry", "Angry"),
    DREAMY("dreamy", "Dreamy"),

    ROMANTIC("romantic", "Romantic"),
    PLAYFUL("playful", "Playful"),
    ENERGETIC("energetic", "Energetic"),
    CALM("calm", "Calm"),
    CHILL("chill", "Chill"),
    DARK("dark", "Dark"),
    AGGRESSIVE("aggressive", "Aggressive");

    @XmlElement(name = "id")
    String id;

    @XmlElement(name = "title")
    String title;

    Mood(String id, String title) {
        this.id = id;
        this.title = title;
    }


    public static Mood fromMongo(Document document) {
        for (Mood mood : values()) {
            if (mood.id.equals(document.getString("id"))) {
                return mood;
            }
        }
        throw new NullPointerException("Mood \"" + document.getString("id") + "\" not found!");
    }

    public Document toMongo() {
        Document document = new Document();

        document.put("id", this.id);
        document.put("title", this.title);

        return document;
    }
}
