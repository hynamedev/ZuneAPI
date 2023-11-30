package me.hyname.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.route.genre.GETGenres;
import me.hyname.storage.Storage;

@RestController
public class GenreController {
    GETGenres getGenres;

    public GenreController(Storage storage, JAXBContext jaxb) {
        getGenres = new GETGenres(storage, jaxb);
    }

    @RequestMapping(value = {"${routes.genre.get.genre.path}/", "${routes.genre.get.genre.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getGenres() {
        return getGenres.handle(new HashMap<>());
    }
}
