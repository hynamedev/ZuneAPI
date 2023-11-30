package me.hyname.route.misc;

import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETHomeRoute extends AbstractRoute {

    public GETHomeRoute(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String result =
        "                            __               _ \n" +
        " ____  __  ______  ___     / /  ____ _____  (_)\n" +
        "/_  / / / / / __ \\/ _ \\   / /  / __ `/ __ \\/ / \n" +
        " / /_/ /_/ / / / /  __/  / /  / /_/ / /_/ / /  \n" +
        "/___/\\__,_/_/ /_/\\___/  / /   \\__,_/ .___/_/   \n" +
        "                       /_/        /_/          \n"+
        "\"don't be anti-social\"\n" +
        "\n" +
        "git:                    https://github.com/hynamedev/zuneapi\n" +
        "contributors:           https://github.com/hynamedev/zuneapi/contributors\n" +
        "zune community discord: https://discord.gg/MdH8fyGn8t";

        return result.getBytes();

    }
}
