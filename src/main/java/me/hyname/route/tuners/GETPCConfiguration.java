package me.hyname.route.tuners;

import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import me.hyname.enums.ParamEnum;
import me.hyname.route.AbstractRoute;
import me.hyname.storage.Storage;

public class GETPCConfiguration extends AbstractRoute {

    public GETPCConfiguration(Storage storage, JAXBContext jaxb) {
        super(storage, jaxb);
    }

    @Override
    public byte[] handle(Map<ParamEnum, String> params) {
        String result =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<clientConfiguration xmlns=\"http://schemas.zune.net/ZunePCClient/2008/09\">\n" +
                "    <targetedClient>PC,v4.8</targetedClient>\n" +
                "    <documentVersion>0.7</documentVersion>\n" +
                "    <modifiedDate type=\"text\">2022-12-18T00:00:00Z</modifiedDate>\n" +
                "    <rights>Copyright (c) Microsoft Corporation. All rights reserved.</rights>\n" +
                "    <mappingFlush>\n" +
                "        <previousMappingExpirationDate>2023-01-01T00:00:00Z</previousMappingExpirationDate>\n" +
                "    </mappingFlush>\n" +
                "    <individualizationVersions>\n" +
                "        <vista>\n" +
                "            <securityVersion>2.9.0.1</securityVersion>\n" +
                "            <robustnessVersion>3.8.0.1</robustnessVersion>\n" +
                "        </vista>\n" +
                "        <XP>\n" +
                "            <securityVersion>2.9.0.1</securityVersion>\n" +
                "            <robustnessVersion>3.8.0.1</robustnessVersion>\n" +
                "        </XP>\n" +
                "    </individualizationVersions>\n" +
                "    <featureEnablement>\n" +
                "        <marketplace>\n" +
                "            <status>enabled</status>\n" +
                "            <culture>en-US</culture>\n" +
                "            <taxString> plus applicable taxes</taxString>\n" +
                "            <creditCardValidationString/>\n" +
                "        </marketplace>\n" +
                "        <music>\n" +
                "            <status>enabled</status>\n" +
                "        </music>\n" +
                "        <mixview>\n" +
                "            <status>enabled</status>\n" +
                "        </mixview>\n" +
                "        <picks>\n" +
                "            <status>enabled</status>\n" +
                "        </picks>\n" +
                "        <videos>\n" +
                "            <status>enabled</status>\n" +
                "        </videos>\n" +
                "        <tv>\n" +
                "            <status>enabled</status>\n" +
                "        </tv>\n" +
                "        <movieTrailers>\n" +
                "            <status>enabled</status>\n" +
                "        </movieTrailers>\n" +
                "        <social>\n" +
                "            <culture>en-US</culture>\n" +
                "        </social>\n" +
                "        <musicVideos>\n" +
                "            <status>enabled</status>\n" +
                "        </musicVideos>\n" +
                "        <podcastMarketplace>\n" +
                "            <status>enabled</status>\n" +
                "        </podcastMarketplace>\n" +
                "        <channels>\n" +
                "            <status>enabled</status>\n" +
                "        </channels>\n" +
                "        <games>\n" +
                "            <status>enabled</status>\n" +
                "        </games>\n" +
                "        <apps>\n" +
                "            <status>enabled</status>\n" +
                "        </apps>\n" +
                "        <quickMixLocal>\n" +
                "            <status>enabled</status>\n" +
                "        </quickMixLocal>\n" +
                "        <quickMixZmp>\n" +
                "            <status>enabled</status>\n" +
                "        </quickMixZmp>\n" +
                "        <social>\n" +
                "            <status>enabled</status>\n" +
                "        </social>\n" +
                "        <socialMarketplace>\n" +
                "            <status>enabled</status>\n" +
                "        </socialMarketplace>\n" +
                "        <signInAvailable>\n" +
                "            <status>enabled</status>\n" +
                "        </signInAvailable>\n" +
                "        <subscription>\n" +
                "            <status>enabled</status>\n" +
                "            <music>\n" +
                "                <download>\n" +
                "                    <status>enabled</status>\n" +
                "                </download>\n" +
                "                <freeTracks>\n" +
                "                    <status>enabled</status>\n" +
                "                </freeTracks>\n" +
                "            </music>\n" +
                "            <musicVideo>\n" +
                "                <musicVideoStreaming>\n" +
                "                    <status>enabled</status>\n" +
                "                </musicVideoStreaming>\n" +
                "            </musicVideo>\n" +
                "            <trial>\n" +
                "                <status>enabled</status>\n" +
                "                <duration>14</duration>\n" +
                "            </trial>\n" +
                "        </subscription>\n" +
                "        <videoAllHub>\n" +
                "            <status>enabled</status>\n" +
                "        </videoAllHub>\n" +
                "        <ratingSystem>\n" +
                "            zunepcclient/v4.8/RatingsUS.xml\n" +
                "        </ratingSystem>\n" +
                "    </featureEnablement>\n" +
                "    <accountCountries>\n" +
                "        <accountCountry>\n" +
                "            <!-- United States -->\n" +
                "            <abbreviation>US</abbreviation>\n" +
                "            <languages>\n" +
                "                <language>en</language>\n" +
                "            </languages>\n" +
                "            <teenagerAge>13</teenagerAge>\n" +
                "            <adultAge>18</adultAge>\n" +
                "            <showNewsletterOptions>true</showNewsletterOptions>\n" +
                "            <usageCollection>true</usageCollection>\n" +
                "            <fieldValidators>\n" +
                "                <fieldValidator>\n" +
                "                    <name>firstName</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_ACCOUNT_CREATION_FIRST_NAME</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>lastName</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_ACCOUNT_CREATION_LAST_NAME</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>accountHolderName</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_NAME</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>street1</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_STREET1</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>street2</name>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_STREET2</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>city</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_CITY</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>state</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_ACCOUNT_CREATION_STATE</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>postalCode</name>\n" +
                "                    <regex>^\\d{5,5}(-\\d{4,4})?$</regex>\n" +
                "                    <!-- ex 98052 or 98052-1234 -->\n" +
                "                    <friendlyFormat>XXXXX</friendlyFormat>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_POSTALCODE</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>country</name>\n" +
                "                    <regex>^.*[\\S]+.*$</regex>\n" +
                "                    <nameStringId>IDS_ACCOUNT_CREATION_COUNTRY_ENTRY</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>phoneNumber</name>\n" +
                "                    <regex>^(\\+?1[-\\.\\s]?)?(\\(\\d{3}\\)\\s?|\\d{3}[-\\.\\s]?)\\d{3}[-\\.\\s]?\\d{4}$</regex>\n"
                +
                "                    <friendlyFormat>XXX-XXX-XXXX</friendlyFormat>\n" +
                "                    <nameStringId>IDS_CONTACT_PHONE_LABEL</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "                <fieldValidator>\n" +
                "                    <name>phoneExtension</name>\n" +
                "                    <nameStringId>IDS_BILLING_EDIT_CC_PHONE_EXT</nameStringId>\n" +
                "                </fieldValidator>\n" +
                "            </fieldValidators>\n" +
                "        </accountCountry>\n" +
                "    </accountCountries>\n" +
                "    <serviceThrottling>\n" +
                "        <endpointThrottling>\n" +
                "            <endpoint>catalog</endpoint>\n" +
                "            <backoffTime>0</backoffTime>\n" +
                "        </endpointThrottling>\n" +
                "        <endpointThrottling>\n" +
                "            <endpoint>mix</endpoint>\n" +
                "            <backoffTime>0</backoffTime>\n" +
                "        </endpointThrottling>\n" +
                "    </serviceThrottling>\n" +
                "    <smartDJ>\n" +
                "        <coordinates>\n" +
                "            <coordinate>\n" +
                "                <type>cf</type>\n" +
                "                <weight>2.0</weight>\n" +
                "                <threshold>0.6</threshold>\n" +
                "            </coordinate>\n" +
                "            <coordinate>\n" +
                "                <type>metadata</type>\n" +
                "                <weight>1.0</weight>\n" +
                "                <threshold>0.4</threshold>\n" +
                "            </coordinate>\n" +
                "            <thresholdAverage>0.2</thresholdAverage>\n" +
                "        </coordinates>\n" +
                "    </smartDJ>\n" +
                "    <liveUpgradeCodes>\n" +
                "        <MovieMaker>\n" +
                "            <ProductCode>D12D72AE-1B05-4DD3-8EAD-06A40BE6E02F</ProductCode>\n" +
                "            <MajorVersion>15</MajorVersion>\n" +
                "            <MinorVersion>4</MinorVersion>\n" +
                "        </MovieMaker>\n" +
                "        <PhotoGallery>\n" +
                "            <ProductCode>F81F501C-236B-4B4A-8E92-0575EAAD06FA</ProductCode>\n" +
                "            <MajorVersion>14</MajorVersion>\n" +
                "            <MinorVersion>0</MinorVersion>\n" +
                "        </PhotoGallery>\n" +
                "    </liveUpgradeCodes>\n" +
                "    <videoRentalTerms>\n" +
                "        <daysToWatch>14</daysToWatch>\n" +
                "        <hoursToWatch>24</hoursToWatch>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.bandai</id>\n" +
                "                <name>BandaiChannel</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.contentFilm</id>\n" +
                "                <name>Content Media Corporation</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.dimensionFilms</id>\n" +
                "                <name>Dimension Films</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.disneynature</id>\n" +
                "                <name>Disneynature</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.filmBuff</id>\n" +
                "                <name>Filmbuff</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.hollywoodPictures</id>\n" +
                "                <name>Hollywood Pictures</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.egamiFilms</id>\n" +
                "                <name>Image Entertainment</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.millennium</id>\n" +
                "                <name>Millennium Entertainment</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.miramaxFilms</id>\n" +
                "                <name>Miramax Films</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.mpi</id>\n" +
                "                <name>MPI</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.relativityMedia</id>\n" +
                "                <name>Relativity Media</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.theOrchard</id>\n" +
                "                <name>The Orchard</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.scottEntertainment</id>\n" +
                "                <name>Scott Entertainment</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.screenMedia</id>\n" +
                "                <name>Screen Media</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.shoutFactory</id>\n" +
                "                <name>Shout! Factory</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.slamdanceFilmFestival</id>\n" +
                "                <name>Slamdance Film Festival</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.theWeinsteinCompany</id>\n" +
                "                <name>The Weinstein Company</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.touchstonePictures</id>\n" +
                "                <name>Touchstone Pictures</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "        <studioOverride>\n" +
                "            <studioInfo>\n" +
                "                <id>studio.waltDisneyPictures</id>\n" +
                "                <name>Walt Disney Pictures</name>\n" +
                "            </studioInfo>\n" +
                "            <daysToWatch>14</daysToWatch>\n" +
                "            <hoursToWatch>48</hoursToWatch>\n" +
                "        </studioOverride>\n" +
                "    </videoRentalTerms>\n" +
                "    <phoneClientType>\n" +
                "        <defaultClientType>WinMobile 7.1</defaultClientType>\n" +
                "        <clientTypeMapping>\n" +
                "            <osVersion>7.0</osVersion>\n" +
                "            <ypvVersion>WinMobile 7.0</ypvVersion>\n" +
                "        </clientTypeMapping>\n" +
                "        <clientTypeMapping>\n" +
                "            <osVersion>7.1</osVersion>\n" +
                "            <ypvVersion>WinMobile 7.1</ypvVersion>\n" +
                "        </clientTypeMapping>\n" +
                "        <clientTypeMapping>\n" +
                "            <osVersion>7.10</osVersion>\n" +
                "            <ypvVersion>WinMobile 7.1</ypvVersion>\n" +
                "        </clientTypeMapping>\n" +
                "    </phoneClientType>\n" +
                "</clientConfiguration>";

        return result.getBytes();
    }
}
