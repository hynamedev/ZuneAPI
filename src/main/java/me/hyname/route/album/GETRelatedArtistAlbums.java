package me.hyname.route.album;

import me.hyname.Main;
import me.hyname.model.*;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GETRelatedArtistAlbums implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {

        response.type("text/xml");
        response.raw().setContentType("text/xml");
        JAXBContext contextObj = JAXBContext.newInstance(Feed.class, Album.class, MiniAlbum.class, MiniArtist.class, MiniImage.class, Track.class, Artist.class, Genre.class, Mood.class, MiniTrack.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Artist primaryArtist = Main.getStorage().readArtist(request.params(":id").toLowerCase());

        List<Artist> similarArtists = new ArrayList<>();

        List<Artist> documents = Main.getStorage().getArtists();

        List<Album> related = new ArrayList<>();

        for(Artist a : documents) {
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

        similarArtists.remove(primaryArtist);

        for(Artist a : similarArtists) {
            if(a == primaryArtist) continue;
            for(Album al : Main.getStorage().readAlbumsByArtist(a)) {
                if(related.contains(al)) continue;
                if(Objects.equals(al.primaryArtist.id.toString(), primaryArtist.id.toString())) continue;
                related.add(al);
            }
        }

        Feed<Album> que=  new Feed<>();

        Collections.shuffle(related);
        que.setEntries(related);






        marshallerObj.marshal(que, baos);

        System.out.println(request.url() + " | " + request.contextPath() + " | " + request.params() + " | " + request.queryParams() + " | " + request.queryString());
        return baos.toString(Charset.defaultCharset().name());
    }
}
