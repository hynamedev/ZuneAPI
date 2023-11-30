package me.hyname.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.route.misc.GETHomeRoute;
import me.hyname.storage.Storage;

@RestController
public class MiscController {
    GETHomeRoute getHomeRoute;

    public MiscController(Storage storage, JAXBContext jaxb) {
        getHomeRoute = new GETHomeRoute(storage, jaxb);
    }

    @RequestMapping(value = {"${routes.misc.get.home.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getHome() {
        return getHomeRoute.handle(new HashMap<>());
    }
}
