package me.hyname.route.artist;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.OrderByEnum;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Feed;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

/**
 * Get a list of an artist's albums
 */
public class GETArtistAlbums extends AbstractRoute {

    public GETArtistAlbums(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        String orderBy = params.getOrDefault(ParamEnum.ORDERBY, "");
        logger.trace("Received request for Artist '{}' with query param `{}`", id, orderBy);

        try {
            ByteArrayOutputStream baos = fetchItem(id, orderBy);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Album(s)", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    /**
     * Fetch the album based on the submitted ID, ordering the albums based on the selected order type
     * @param id ID of the artist
     * @param orderBy Method by which to order the albums
     * @return XML representation of the albums in a (possibly) defined order
     * @throws JAXBException in the event that there is an error trying to marshal
     */
    private ByteArrayOutputStream fetchItem(String id, String orderBy) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Artist artist = storage.readArtist(id.toLowerCase());
        List<Album> albumList = storage.readAlbumsByArtist(artist);
        Feed<Album> que = new Feed<>();

        albumList.sort(Comparator.comparing(o -> o.releaseDate));
        Collections.reverse(albumList);

        OrderByEnum order = EnumUtils.getEnum(OrderByEnum.class, orderBy);

        if (order != null) {
            switch (order) {
                case TITLE:
                    albumList.sort(Comparator.comparing(o -> o.title));
                    break;
                case RELEASEDATE:
                    albumList.sort(Comparator.comparing(o -> o.releaseDate));
                    Collections.reverse(albumList);
                    break;
                case PLAYRANK:
                    albumList.sort(Comparator.comparingInt(o -> o.popularity));
                    break;
            }
        } else {
            logger.trace("Query for albums for Artist '{}' did not provide an orderBy query param");
        }

        que.setEntries(albumList);

        marshallerObj.marshal(que, result);

        return result;
    }
}
