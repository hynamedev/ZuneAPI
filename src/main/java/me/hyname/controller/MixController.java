package me.hyname.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.mix.GETArtistSimilarTracks;
import me.hyname.route.mix.GETSimilarTracks;
import me.hyname.storage.Storage;

@RestController
public class MixController {
    GETArtistSimilarTracks getArtistSimilarTracks;
    GETSimilarTracks getSimilarTracks;

    public MixController(Storage storage, JAXBContext jaxb) {
        getArtistSimilarTracks = new GETArtistSimilarTracks(storage, jaxb);
        getSimilarTracks = new GETSimilarTracks(storage, jaxb);
    }

    @RequestMapping(value = {"${routes.mix.get.artistsimilartracks.path}/", "${routes.mix.get.artistsimilartracks.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistSimilarTracks(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getArtistSimilarTracks.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.mix.get.similartracks.path}/", "${routes.mix.get.similartracks.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getSimilarTracks(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getSimilarTracks.handle(methodParams);
    }
}
