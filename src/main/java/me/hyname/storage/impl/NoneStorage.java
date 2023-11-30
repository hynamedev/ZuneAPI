package me.hyname.storage.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Track;
import me.hyname.storage.Storage;

public class NoneStorage extends Storage {

    Logger logger = LogManager.getRootLogger();

    @Override
    public void init() {
        logger.info("Debugging database initialized.  No queries will actually return anything in this mode");
    }

    @Override
    public boolean saveArtist(Artist artist) {
        return true;
    }

    @Override
    public Artist readArtist(String id) {
        return new Artist();
    }

    @Override
    public boolean saveTrack(Track track) {
        return true;
    }

    @Override
    public Track readTrack(String id) {
        return new Track();
    }

    @Override
    public boolean saveAlbum(Album album) {
        return true;
    }

    @Override
    public Album readAlbum(String id) {
        return new Album();
    }

    @Override
    public List<Album> readAlbumsByArtist(Artist artist) {
        return new ArrayList<>();
    }

    @Override
    public List<Track> readTracksByArtist(Artist artist) {
        return new ArrayList<>();
    }

    @Override
    public List<Album> getAlbums() {
        return new ArrayList<>();
    }

    @Override
    public List<Track> getTracks() {
        return new ArrayList<>();
    }

    @Override
    public List<Artist> getArtists() {
        return new ArrayList<>();
    }

    @Override
    public boolean shutdown() {
        return true;
    }  
}
