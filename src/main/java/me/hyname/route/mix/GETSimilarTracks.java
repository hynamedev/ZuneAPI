package me.hyname.route.mix;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Artist;
import me.hyname.model.Feed;
import me.hyname.model.Genre;
import me.hyname.model.Track;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETSimilarTracks extends AbstractRoute {

    public GETSimilarTracks(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Simiar Tracks Mix", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Track sourceTrack = storage.readTrack(id.toLowerCase());
        Artist primaryArtist = storage.readArtist(sourceTrack.albumArtist.id.toString());

        List<Track> documents = storage.getTracks();
        List<Track> similarTracks = new ArrayList<>();

        for(Track t : documents) {
            if(Objects.equals(sourceTrack.id.toString(), t.id.toString())) continue;
            Artist trackArtist = storage.readArtist(t.albumArtist.id.toString());
            if (t.albumArtist == sourceTrack.albumArtist) {
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

        Feed<Track> results = new Feed<>();

        results.setEntries(similarTracks);

        marshallerObj.marshal(results, result);

        return result;
    }
}
