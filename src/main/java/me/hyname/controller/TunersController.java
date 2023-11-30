package me.hyname.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.route.tuners.GETPCConfiguration;
import me.hyname.storage.Storage;

@RestController
public class TunersController {

    GETPCConfiguration getPcConfiguration;

    public TunersController(Storage storage, JAXBContext jaxb) {
        getPcConfiguration = new GETPCConfiguration(storage, jaxb);
    }
    
    @RequestMapping(value = {"${routes.tuners.get.pcconfig.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getPcConfiguration() {
        return getPcConfiguration.handle(new HashMap<>());
    }
}