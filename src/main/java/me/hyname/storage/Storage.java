package me.hyname.storage;

import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Track;

import java.util.List;


public abstract class Storage {

    public abstract void init();

    public abstract boolean saveArtist(Artist artist);
    public abstract Artist readArtist(String id);

    public abstract boolean saveTrack(Track track);
    public abstract Track readTrack(String id);

    public abstract boolean saveAlbum(Album album);
    public abstract Album readAlbum(String id);

    public abstract List<Album> readAlbumsByArtist(Artist artist);

    public abstract List<Track> readTracksByArtist(Artist artist);

    public abstract List<Album> getAlbums();

    public abstract List<Track> getTracks();

    public abstract List<Artist> getArtists();

    public abstract boolean shutdown();
}
