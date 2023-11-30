package me.hyname.route.artist;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import me.hyname.enums.ParamEnum;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETSimliarArtists extends AbstractRoute {

    public GETSimliarArtists(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Artist '" + id + "' when fetching Similar Artists", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {

        return null;
    }
}
