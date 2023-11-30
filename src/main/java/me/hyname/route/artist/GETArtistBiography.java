package me.hyname.route.artist;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Artist;
import me.hyname.model.Biography;
import me.hyname.model.Feed;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETArtistBiography extends AbstractRoute {

    public GETArtistBiography(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Biography", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        Artist artist = storage.readArtist(id.toLowerCase());
        Biography bio = new Biography(new Date(System.currentTimeMillis()), artist.getName(), artist.getDbId(), artist.getBio(), "Microsoft Corporation");
        Feed<Biography> que = new Feed<>();

        que.setEntries(Collections.singletonList(bio));

        marshallerObj.marshal(que, result);

        return result;
    }
}
