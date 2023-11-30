package me.hyname.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.image.GETArtistThumbnailImage;
import me.hyname.route.image.GETBackgroundImage;
import me.hyname.route.image.GETDeviceBackgroundImage;
import me.hyname.route.image.GETOtherImage;
import me.hyname.route.image.GETPrimaryImageRoute;
import me.hyname.storage.Storage;

@RestController
public class ImageController {
    GETArtistThumbnailImage getArtistThumbnailImage;
    GETBackgroundImage getBackgroundImage;
    GETDeviceBackgroundImage getDeviceBackgroundImage;
    GETOtherImage getOtherImage;
    GETPrimaryImageRoute getPrimaryImageRoute;

    public ImageController(Storage storage, JAXBContext jaxb) {
        getArtistThumbnailImage = new GETArtistThumbnailImage(storage, jaxb);
        getBackgroundImage = new GETBackgroundImage(storage, jaxb);
        getDeviceBackgroundImage = new GETDeviceBackgroundImage(storage, jaxb);
        getOtherImage = new GETOtherImage(storage, jaxb);
        getPrimaryImageRoute = new GETPrimaryImageRoute(storage, jaxb);
    }

    @RequestMapping(value = {"${routes.image.get.devicebackground.path}/", "${routes.image.get.devicebackground.path}"}, method = RequestMethod.GET, produces = "image/jpg")
    public byte[] getDeviceBackgroundImage(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getDeviceBackgroundImage.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.image.get.primary.path}/", "${routes.image.get.primary.path}"}, method = RequestMethod.GET, produces = "image/jpg")
    public byte[] getPrimaryImageRoute(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getPrimaryImageRoute.handle(methodParams);
    }
}
