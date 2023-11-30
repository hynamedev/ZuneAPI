package me.hyname.route.track;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import me.hyname.enums.ParamEnum;
import me.hyname.model.Track;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETTrackOverview extends AbstractRoute {

    public GETTrackOverview(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            ByteArrayOutputStream baos = fetchItem(id);

            return baos.toByteArray();
        } catch (JAXBException e) {
            logger.error("Failed to marshal XML information for Track '" + id + "' when fetching Overview", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws JAXBException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        Marshaller marshallerObj = jaxb.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Track que = storage.readTrack(id.toLowerCase());

        marshallerObj.marshal(que, baos);

        return result;
    }
}
