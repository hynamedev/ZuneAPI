package me.hyname.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Feature;
import me.hyname.model.Genre;
import me.hyname.model.MediaLink;
import me.hyname.model.MiniArtist;
import me.hyname.model.MiniImage;
import me.hyname.model.MiniTrack;
import me.hyname.model.Mood;

// literally just here for debugging
public class ArtistStorage {


    public Artist taylorSwift;
    public Album ts1989;
    public Album tsRed;
    public Album tsRep;

    public List<Feature> features = new ArrayList<>();

    public ArtistStorage() {
        init();
        
        // storage.saveArtist(taylorSwift);
        // storage.saveAlbum(ts1989);
        // storage.saveAlbum(tsRed);
        // storage.saveAlbum(tsRep);
    }

    public void init() {
        features = Arrays.asList(
                new Feature(
                    "df2f08ac-4fdb-4ea8-8665-6193b0b26b9e",
                    new MediaLink("artist", "10450000-0200-11db-89ca-0019b92a3933/"),
                    "Taylor Swift",
                    "Taylor Swift changes her tune on '1989'",
                    1,
                    new MiniImage(UUID.fromString("3951a617-1281-45a1-9a7f-76a25bf75ae2")),
                    new MiniImage(UUID.fromString("f77adb33-8917-4c42-bfb3-f32a6f9d96b5")),
                    false
                ),
                new Feature(
                        "10075000-0200-11db-89ca-0019b92a3933",
                        new MediaLink("artist", "10075000-0200-11db-89ca-0019b92a3933/"),
                        "Kanye West",
                        "My Beautiful Dark Twisted Fantasy",
                        2,
                        new MiniImage(UUID.fromString("10075000-0200-11db-89ca-0019b92a3933")),
                        new MiniImage(UUID.fromString("10075000-0200-11db-89ca-0019b92a3933")),
                        false
                ),
                new Feature(
                        "df2f08ac-4fdb-4ea8-8665-6193b5b26b7e",
                        new MediaLink("album", "b1fef50e-eb67-4419-93f6-f22a03551a6d/"),
                        "Taylor Swift",
                        "Taylor Swift Leaps Into Pop With 'Red'",
                        3,
                        new MiniImage(UUID.fromString("df2f08ac-4fdb-4ea8-8665-6193b5b26b7e")),
                        new MiniImage(UUID.fromString("b1fef50e-eb67-4419-93f6-f22a03551a6d")),
                        false
                ),
                new Feature(
                        "fce11e83-6404-4fa9-a06c-17ea5770449c",
                        new MediaLink("album", "fce11e83-6404-4fa9-a06c-17ea5770449c/"),
                        "Blackout",
                        "Britney is back.",
                        4,
                        new MiniImage(UUID.fromString("fce11e83-6404-4fa9-a06c-17ea5770449c")),
                        new MiniImage(UUID.fromString("fce11e83-6404-4fa9-a06c-17ea5770449c")),
                        false
                ),

                new Feature(
                        "bc9a9d79-8e88-487c-88e7-67fd2a960713",
                        new MediaLink("artist", "bc9a9d79-8e88-487c-88e7-67fd2a960713/"),
                        "Owl City",
                        "The Midsummer Station",
                        5,
                        new MiniImage(UUID.fromString("bc9a9d79-8e88-487c-88e7-67fd2a960713")),
                        new MiniImage(UUID.fromString("bc9a9d79-8e88-487c-88e7-67fd2a960713")),
                        false
                ),
                new Feature(
                        "b9df75ed-d53e-490b-8ba2-acfe3074bb61",
                        new MediaLink("artist", "b1fef50e-eb67-4419-93f6-f22a03551a6d/"),
                        "Charli XCX",
                        "Sucker",
                        6,
                        new MiniImage(UUID.fromString("b9df75ed-d53e-490b-8ba2-acfe3074bb61")),
                        new MiniImage(UUID.fromString("b9df75ed-d53e-490b-8ba2-acfe3074bb61")),
                        false
                ),
                new Feature(
                        "df2f08ac-4fdb-4ea8-8665-6193b0b26b9e",
                        new MediaLink("artist", "10450000-0200-11db-89ca-0019b92a3933/"),
                        "Taylor Swift",
                        "Taylor Swift changes her tune on '1989'",
                        7,
                        new MiniImage(UUID.fromString("3951a617-1281-45a1-9a7f-76a25bf75ae2")),
                        new MiniImage(UUID.fromString("f77adb33-8917-4c42-bfb3-f32a6f9d96b5")),
                        false
                ),
                new Feature(
                        "df2f08ac-4fdb-4ea8-8665-6193b5b26b7e",
                        new MediaLink("album", "b1fef50e-eb67-4419-93f6-f22a03551a6d/"),
                        "Taylor Swift",
                        "Taylor Swift Leaps Into Pop With 'Red'",
                        8,
                        new MiniImage(UUID.fromString("df2f08ac-4fdb-4ea8-8665-6193b5b26b7e")),
                        new MiniImage(UUID.fromString("b1fef50e-eb67-4419-93f6-f22a03551a6d")),
                        false
                ),
                new Feature(
                        "df2f08ac-4fdb-4ea8-8665-6193b0b26b9e",
                        new MediaLink("artist", "10450000-0200-11db-89ca-0019b92a3933/"),
                        "Taylor Swift",
                        "Taylor Swift changes her tune on '1989'",
                        9,
                        new MiniImage(UUID.fromString("3951a617-1281-45a1-9a7f-76a25bf75ae2")),
                        new MiniImage(UUID.fromString("f77adb33-8917-4c42-bfb3-f32a6f9d96b5")),
                        false
                )
        );



        taylorSwift = new Artist(
                "Taylor Swift",
                "Taylor Swift",
                UUID.fromString("10450000-0200-11db-89ca-0019b92a3933"),
                UUID.fromString("10450000-0200-11db-89ca-0019b92a3933"),
                10d,
                false,
                "/v3.2/en-US/music/artist/10450000-0200-11db-89ca-0019b92a3933/biography/",
                "bbb",
                "aaa",
                1000,
                Genre.POP,
                Arrays.asList(Genre.POP, Genre.ALTERNATIVE, Genre.COUNTRY),
                Arrays.asList(Mood.UPBEAT, Mood.JOYFUL),
                new MiniImage(UUID.fromString("10450000-0200-11db-89ca-0019b92a3933")),
                false,
                Arrays.asList(
                        new MiniImage(UUID.fromString("10450000-0200-11db-89ca-0019b92a3933"))
                )
        );



        ts1989 = new Album(
                "1989",
                "1989",
                UUID.fromString("ea1ecbf2-baaf-4a48-a2b4-13d3c79d0530"),
                new MiniArtist("Taylor Swift",
                        UUID.fromString("10450000-0200-11db-89ca-0019b92a3933")
                ),
                Genre.POP,
                10,
                false,
                false,
                Arrays.asList(
                        new MiniImage(UUID.fromString("f77adb33-8917-4c42-bfb3-f32a6f9d96b5"))
                ),
                new Date(1414373526000l),
                Arrays.asList(
                        new MiniTrack("Welcome To New York", "Welcome To New York", UUID.randomUUID(), 1, true, false, 213, 0),
                        new MiniTrack("Blank Space", "Blank Space", UUID.randomUUID(), 2, true, false, 213, 0),
                        new MiniTrack("Style", "Style", UUID.randomUUID(), 3, true, false, 213, 0),
                        new MiniTrack("Out of the Woods", "Out of the Woods", UUID.randomUUID(), 4, true, false, 213, 0),
                        new MiniTrack("Shake It Off", "Shake It Off", UUID.randomUUID(), 6, true, false, 213, 0),
                        new MiniTrack("Bad Blood", "Bad Blood", UUID.randomUUID(), 8, true, false, 213, 0),
                        new MiniTrack("Wildest Dreams", "Wildest Dreams", UUID.randomUUID(), 9, true, false, 213, 0)
                )
        );

        tsRed = new Album(
                "Red",
                "Red",
                UUID.fromString("b1fef50e-eb67-4419-93f6-f22a03551a6d"),
                new MiniArtist("Taylor Swift",
                        UUID.fromString("10450000-0200-11db-89ca-0019b92a3933")
                ),
                Genre.COUNTRY,
                10,
                false,
                false,
                Arrays.asList(
                        new MiniImage(UUID.fromString("b1fef50e-eb67-4419-93f6-f22a03551a6d"))
                ),
                new Date(1351313047000l),
                Arrays.asList(
                        new MiniTrack("State of Grace", "State of Grace", UUID.randomUUID(), 1, true, false, 295, 0),
                        new MiniTrack("Treacherous", "Treacherous", UUID.randomUUID(), 2, true, false, 213, 0),
                        new MiniTrack("I Knew You Were Trouble", "I Knew You Were Trouble", UUID.randomUUID(), 3, true, false, 213, 0),
                        new MiniTrack("All Too Well", "All Too Well", UUID.randomUUID(), 4, true, false, 213, 0),
                        new MiniTrack("22", "22", UUID.randomUUID(), 6, true, false, 213, 0),
                        new MiniTrack("I Almost Do", "I Almost Do", UUID.randomUUID(), 8, true, false, 213, 0),
                        new MiniTrack("We Are Never Ever Getting Back Together", "We Are Never Ever Getting Back Together", UUID.randomUUID(), 9, true, false, 213, 0)
                )
        );

        tsRep = new Album(
                "reputation",
                "reputation",
                UUID.fromString("6d4a5d4f-e785-4c8e-9ab6-97083803208f"),
                new MiniArtist("Taylor Swift",
                        UUID.fromString("10450000-0200-11db-89ca-0019b92a3933")
                ),
                Genre.POP,
                10,
                false,
                true,
                Arrays.asList(
                        new MiniImage(UUID.fromString("6d4a5d4f-e785-4c8e-9ab6-97083803208f"))
                ),
                new Date(1510275113000l),
                Arrays.asList(
                        new MiniTrack("...Ready for It?", "...Ready for It?", UUID.randomUUID(), 1, true, true, 295, 0),
                        new MiniTrack("End Game", "End Game", UUID.randomUUID(), 2, true, false, 213, 0),
                        new MiniTrack("I Did Something Bad", "I Did Something Bad", UUID.randomUUID(), 3, true, false, 213, 0),
                        new MiniTrack("Don't Blame Me", "Don't Blame Me", UUID.randomUUID(), 4, true, false, 213, 0),
                        new MiniTrack("Delicate", "Delicate", UUID.randomUUID(), 6, true, false, 213, 0),
                        new MiniTrack("Look What You Made Me Do", "Look What You Made Me Do", UUID.randomUUID(), 8, true, false, 213, 0),
                        new MiniTrack("So It Goes...", "So It Goes...", UUID.randomUUID(), 9, true, false, 213, 0)
                )
        );
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
