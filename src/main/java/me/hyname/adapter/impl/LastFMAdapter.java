package me.hyname.adapter.impl;

import de.umass.lastfm.Authenticator;
import de.umass.lastfm.Session;
import me.hyname.adapter.Adapter;
import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Track;

public class LastFMAdapter extends Adapter {
    String key;
    String secret;
    String token;
    Session session;

    public LastFMAdapter(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    @Override
    public void init() {
        token = Authenticator.getToken(key);
        session = Authenticator.getSession(token, key, secret);
    }

    @Override
    public Artist convertArtist(String name) {
        return null;
    }

    @Override
    public Album convertAlbum(String name, String artistName) {
        return null;
    }

    @Override
    public Track convertTrack(String name, String artistName, String albumName) {
        return null;
    }
}
