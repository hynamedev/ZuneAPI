package me.hyname.route.featured;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Feature;
import me.hyname.model.Feed;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;
import me.hyname.store.ArtistStorage;

public class GETFeaturedCards extends AbstractRoute {

    ArtistStorage artStor = new ArtistStorage();

    public GETFeaturedCards(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        try {
            ByteArrayOutputStream baos = fetchItem();

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Feature", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    // TODO: Implement
    private ByteArrayOutputStream fetchItem() throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Feed<Feature> que = new Feed<>();
        List<Feature> albums = artStor.getFeatures();

        que.setEntries(albums);

        marshallerObj.marshal(que, baos);

        return result;
    }
}
