package me.hyname.adapter.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.hyname.adapter.Adapter;
import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Track;

public class NoneAdapter extends Adapter {

    Logger logger = LogManager.getRootLogger();

    @Override
    public void init() {
        logger.info("None Adapter selected.  No outside communication will occur");
    }

    @Override
    public Artist convertArtist(String name) {
        return new Artist();
    }

    @Override
    public Album convertAlbum(String name, String artistName) {
        return new Album();
    }

    @Override
    public Track convertTrack(String name, String artistName, String albumName) {
        return new Track();
    }
    
}
