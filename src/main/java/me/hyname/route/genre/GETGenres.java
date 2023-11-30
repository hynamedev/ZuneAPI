package me.hyname.route.genre;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Feed;
import me.hyname.model.Genre;
import me.hyname.model.GenreInstance;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETGenres extends AbstractRoute {

    public GETGenres(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        try {
            ByteArrayOutputStream baos = fetchItem();

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Genres", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem() throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Feed<GenreInstance> que = new Feed<>();
        List<GenreInstance> genres = new ArrayList<>();

        for (Genre g : Genre.values()) {
            genres.add(new GenreInstance(g.id, g.title));
        }

        que.setEntries(genres);

        marshallerObj.marshal(que, baos);

        return result;
    }
}
