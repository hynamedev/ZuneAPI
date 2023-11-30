package me.hyname.route.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETDeviceBackgroundImage extends AbstractRoute {

    public GETDeviceBackgroundImage(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String id = params.getOrDefault(ParamEnum.ID, "");
        try {
            return fetchItem(id).toByteArray();
        } catch (IOException e) {
            logger.error("Failed to capture image information for '" + id + "' when fetching Device Background Image", e);
            return errorGen.generateErrorResponse(500, e.getMessage(), "");
        }
    }

    private ByteArrayOutputStream fetchItem(String id) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fileInStr = new FileInputStream("image/background/" + id + ".jpg")) {
            BufferedImage image = ImageIO.read(fileInStr);
            ImageIO.write(image, "jpg", baos);
        } catch (IOException e) {
            logger.error("Failed for id '" + id + "' to read image from cache and/or failed write requested image to ByteArray", e);
        }

        return baos;
    }
}
