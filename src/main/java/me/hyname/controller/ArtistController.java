package me.hyname.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.artist.GETArtistAlbums;
import me.hyname.route.artist.GETArtistBiography;
import me.hyname.route.artist.GETArtistImages;
import me.hyname.route.artist.GETArtistOverview;
import me.hyname.route.artist.GETSimliarArtists;
import me.hyname.route.artist.GETArtistTracks;
import me.hyname.storage.Storage;

/**
 * Rest Controller for any/all Artist-related operations at the "artist" path
 */
@RestController
public class ArtistController {
    public Logger logger = LogManager.getRootLogger();

    GETArtistBiography getArtistBiography;
    GETArtistAlbums getArtistAlbums;
    GETArtistImages getArtistImages;
    GETArtistOverview getArtistOverview;
    GETArtistTracks getArtistTracks;
    GETSimliarArtists getSimilarArtists;

    public ArtistController(Storage storage, JAXBContext jaxb) {
        getArtistAlbums = new GETArtistAlbums(storage, jaxb);
        getArtistBiography = new GETArtistBiography(storage, jaxb);
        getArtistImages = new GETArtistImages(storage, jaxb);
        getArtistOverview = new GETArtistOverview(storage, jaxb);
        getArtistTracks = new GETArtistTracks(storage, jaxb);
        getSimilarArtists = new GETSimliarArtists(storage, jaxb);
    }

    @RequestMapping(value = {"${routes.artist.get.albums.path}/", "${routes.artist.get.albums.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistAlbums(@PathVariable String id, @RequestParam Map<String, String> params) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);
        methodParams.put(ParamEnum.ORDERBY, params.getOrDefault("orderBy", ""));

        return getArtistAlbums.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.artist.get.biography.path}/", "${routes.artist.get.biography.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistBiography(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getArtistBiography.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.artist.get.images.path}/", "${routes.artist.get.images.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistImages(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getArtistImages.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.artist.get.overview.path}/", "${routes.artist.get.overview.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistOverview(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getArtistOverview.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.artist.get.tracks.path}/", "${routes.artist.get.tracks.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getArtistTracks(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getArtistTracks.handle(methodParams);
    }

    @RequestMapping(value = {"${routes.artist.get.similarartists.path}/", "${routes.artist.get.similarartists.path}"}, method = RequestMethod.GET, produces = "text/xml")
    public byte[] getSimilarArtists(@PathVariable String id) {
        Map<ParamEnum, String> methodParams = new HashMap<>();
        methodParams.put(ParamEnum.ID, id);

        return getSimilarArtists.handle(methodParams);
    }
}
