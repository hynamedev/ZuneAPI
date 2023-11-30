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
import me.hyname.model.MiniImage;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETArtistImages extends AbstractRoute {

    public GETArtistImages(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Artist Images", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Artist artist = storage.readArtist(id.toLowerCase());
        List<MiniImage> images = new ArrayList<>();
        Feed<MiniImage> que = new Feed<>();

        for (MiniImage i : artist.getArtistImages()) {
            images.add(i);
        }

        que.setEntries(images);

        marshallerObj.marshal(que, result);
        return result;
    }
}
