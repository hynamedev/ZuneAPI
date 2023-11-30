package me.hyname.route.artist;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Artist;
import me.hyname.model.Feed;
import me.hyname.model.Track;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

/**
 * Fetch any/all tracks related to the requested artist
 */
public class GETArtistTracks extends AbstractRoute{

    public GETArtistTracks(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    /**
     * Handles the request to get tracks for a specific artist, based on UUID
     * 
     * @param id The ID of the artist
     * @return XML formatted document containing a list of tracks
     */
    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        
        logger.trace("Received request for Artist '{}'", id);

        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Track(s)", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    /**
     * Fetch all of the tracks under a specific artist
     * 
     * @param id Artist UUID
     * @return XML ByteArray containing all of the track information
     * @throws JAXBException
     */
    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Artist artist = storage.readArtist(id.toLowerCase());

        List<Track> tracks = new ArrayList<>();

        if (artist != null && artist.id != null) {
            tracks = storage.readTracksByArtist(artist);
        }

        Feed<Track> que = new Feed<>();
        que.setEntries(tracks);

        marshallerObj.marshal(que, result);
        
        return result;
    }
}