package me.hyname.util;

import me.hyname.adapter.Adapter;
import me.hyname.model.*;
import me.hyname.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

//todo: impl
@Component
public class SimilarityUtil {

    Storage storage;
    Adapter adapater;

    SimilarityUtil(Storage storage, Adapter adapter) {
        
    }

    public List<Artist> getSimilarArtists(Artist primaryArtist) {
        List<Artist> similarArtists = new ArrayList<>();

        List<Artist> documents = storage.getArtists();

        for(Artist a : documents) {
            if(Objects.equals(primaryArtist.id.toString(), a.id.toString())) continue;
            if (a.getArtistPrimaryGenre() == primaryArtist.getArtistPrimaryGenre()) {
                similarArtists.add(a);
            } else {
                for (Genre genres : a.getArtistGenres()) {
                    for (Genre otherGenres : primaryArtist.getArtistGenres()) {
                        if (genres == primaryArtist.getArtistPrimaryGenre() || otherGenres == a.getArtistPrimaryGenre()) {
                            if(similarArtists.contains(a)) continue;
                            similarArtists.add(a);
                            break;
                        }
                    }
                }
            }
        }

        for(Artist a : documents) {
            if(Objects.equals(primaryArtist.id.toString(), a.id.toString())) continue;
            for (Mood moods : a.getArtistMoods()) {
                for (Mood otherMoods : primaryArtist.getArtistMoods()) {
                    if (moods == otherMoods) {
                        if(similarArtists.contains(a)) continue;
                        similarArtists.add(a);
                        break;
                    }
                }
            }
        }

        return similarArtists;
    }

    public List<Album> getSimilarAlbums(Album primaryAlbum) {
        Artist primaryArtist = storage.readArtist(primaryAlbum.primaryArtist.id.toString());

        List<Artist> similarArtists = getSimilarArtists(primaryArtist);

        List<Album> related = new ArrayList<>();


        for(Artist a : similarArtists) {
            for(Album al : storage.readAlbumsByArtist(a)) {
                if(related.contains(al)) continue;
                related.add(al);
            }
        }

        return related;
    }

    public List<Track> getSimilarTracks(Track primaryTrack) {
        Artist primaryArtist = storage.readArtist(primaryTrack.albumArtist.id.toString());

        List<Track> documents = storage.getTracks();
        List<Track> similarTracks = new ArrayList<>();

        for(Track t : documents) {
            if(Objects.equals(primaryTrack.id.toString(), t.id.toString())) continue;
            Artist trackArtist = storage.readArtist(t.albumArtist.id.toString());
            if (t.albumArtist == primaryTrack.albumArtist) {
                similarTracks.add(t);
            } else {
                for (Genre genre : trackArtist.getArtistGenres()) {
                    for (Genre otherGenres : primaryArtist.getArtistGenres()) {
                        if (genre == primaryArtist.getArtistPrimaryGenre() || otherGenres == trackArtist.getArtistPrimaryGenre()) {
                            if(similarTracks.contains(t)) continue;
                            similarTracks.add(t);
                            break;
                        }
                    }
                }
            }
        }

        return similarTracks;
    }
}
