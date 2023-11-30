package me.hyname.route.album;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Feed;
import me.hyname.model.Genre;
import me.hyname.model.Mood;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETRelatedAlbums extends AbstractRoute {

    public GETRelatedAlbums(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Album '" + id + "' when fetching Related Albums", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }
    
    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Album album = storage.readAlbum(id.toLowerCase());
        Artist primaryArtist = storage.readArtist(album.primaryArtist.id.toString());

        List<Artist> similarArtists = new ArrayList<>();

        List<Artist> documents = storage.getArtists();

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

        for(Artist a : similarArtists) {
            for(Album al : storage.readAlbumsByArtist(a)) {
                if(related.contains(al)) continue;
                related.add(al);
            }
        }

        Feed<Album> que=  new Feed<>();

        que.setEntries(related);

        marshallerObj.marshal(que, result);

        return result;
    }

}
