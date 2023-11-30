package me.hyname.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import me.hyname.model.Album;
import me.hyname.model.Artist;
import me.hyname.model.Biography;
import me.hyname.model.ErrorResponse;
import me.hyname.model.Feature;
import me.hyname.model.Feed;
import me.hyname.model.Genre;
import me.hyname.model.GenreInstance;
import me.hyname.model.Image;
import me.hyname.model.ImageInstance;
import me.hyname.model.MediaLink;
import me.hyname.model.MiniAlbum;
import me.hyname.model.MiniArtist;
import me.hyname.model.MiniImage;
import me.hyname.model.Mood;
import me.hyname.model.Track;

@Component
public class JAXBContextProducer {
    Logger logger = LogManager.getRootLogger();

    JAXBContext contextImpl;

    @PostConstruct
    void init() {
        try {
            contextImpl = JAXBContext.newInstance(Album.class,
            Artist.class,
            Biography.class,
            ErrorResponse.class,
            Feature.class,
            Feed.class,
            Genre.class,
            GenreInstance.class,
            Image.class,
            ImageInstance.class,
            MediaLink.class,
            MiniAlbum.class,
            MiniArtist.class,
            MiniImage.class,
            Mood.class,
            Track.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to initialize JAXBContext", e);
        }
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JAXBContext produceJaxbContext() {
        return contextImpl;
    }
}
