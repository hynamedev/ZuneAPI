package me.hyname.route.featured;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Album;
import me.hyname.model.Feed;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETNewlyReleasedAlbums extends AbstractRoute {

    public GETNewlyReleasedAlbums(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public String handle(Map<ParamEnum, String> params) {
        try {
            ByteArrayOutputStream baos = fetchItem();

            return baos.toString(Charset.defaultCharset().name());
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Newly Released Albums", e);
            return "";
        } catch (UnsupportedEncodingException e) {
            logger.error("Failed to convert binary to XML for Newly Released Albums", e);
            return "";
        }
    }

    private ByteArrayOutputStream fetchItem() throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Feed<Album> que = new Feed<>();
        List<Album> albums = storage.getAlbums();

        albums.sort(Comparator.comparing(o -> o.releaseDate));
        Collections.reverse(albums);

        que.setEntries(albums);

        marshallerObj.marshal(que, result);

        return result;
    }
}