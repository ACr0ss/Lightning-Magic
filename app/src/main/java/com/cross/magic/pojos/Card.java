package com.cross.magic.pojos;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cross.magic.db.DBSchema;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Card {
    @Expose
    @SerializedName("purchase_uris")
    @Nullable
    private Purchase_urisEntity purchase_uris;

    @Expose
    @SerializedName("related_uris")
    @Nullable
    private Related_urisEntity related_uris;

    @Expose
    @SerializedName("prices")
    @Nullable
    private PricesEntity prices;

    @Expose
    @SerializedName("tix")
    @Nullable
    private String tix;

    @Expose
    @SerializedName("eur")
    @Nullable
    private String eur;

    @Expose
    @SerializedName("usd")
    @Nullable
    private String usd;

    @Expose
    @SerializedName("edhrec_rank")
    @Nullable
    private int edhrec_rank;

    @Expose
    @SerializedName("story_spotlight")
    @Nullable
    private boolean story_spotlight;

    @Expose
    @SerializedName("full_art")
    @Nullable
    private boolean full_art;

    @Expose
    @SerializedName("frame")
    @Nullable
    private String frame;

    @Expose
    @SerializedName("border_color")
    @Nullable
    private String border_color;

    @Expose
    @SerializedName("color_indicator")
    @Nullable
    private List<String> color_indicator;

    @Expose
    @SerializedName("artist")
    @Nullable
    private String artist;

    @Expose
    @SerializedName("illustration_id")
    @Nullable
    private String illustration_id;

    @Expose
    @SerializedName("flavor_text")
    @Nullable
    private String flavor_text;

    @Expose
    @SerializedName("rarity")
    @Nullable
    private String rarity;

    @Expose
    @SerializedName("digital")
    @Nullable
    private boolean digital;

    @Expose
    @SerializedName("collector_number")
    @Nullable
    private String collector_number;

    @Expose
    @SerializedName("prints_search_uri")
    @Nullable
    private String prints_search_uri;

    @Expose
    @SerializedName("rulings_uri")
    @Nullable
    private String rulings_uri;

    @Expose
    @SerializedName("scryfall_set_uri")
    @Nullable
    private String scryfall_set_uri;

    @Expose
    @SerializedName("set_search_uri")
    @Nullable
    private String set_search_uri;

    @Expose
    @SerializedName("set_uri")
    @Nullable
    private String set_uri;

    @Expose
    @SerializedName("set_name")
    @Nullable
    private String set_name;

    @Expose
    @SerializedName("set")
    @Nullable
    private String set;

    @Expose
    @SerializedName("reprint")
    @Nullable
    private boolean reprint;

    @Expose
    @SerializedName("promo")
    @Nullable
    private boolean promo;

    @Expose
    @SerializedName("oversized")
    @Nullable
    private boolean oversized;

    @Expose
    @SerializedName("nonfoil")
    @Nullable
    private boolean nonfoil;

    @Expose
    @SerializedName("foil")
    @Nullable
    private boolean foil;

    @Expose
    @SerializedName("reserved")
    @Nullable
    private boolean reserved;

    @Expose
    @SerializedName("games")
    @Nullable
    private List<String> games;

    @Expose
    @SerializedName("legalities")
    @Nullable
    private LegalitiesEntity legalities;

    @Expose
    @SerializedName("color_identity")
    @Nullable
    private List<String> color_identity;

    @Expose
    @SerializedName("colors")
    @Nullable
    private List<String> colors;
    @Expose
    @SerializedName("toughness")
    @Nullable
    private String toughness;

    @Expose
    @SerializedName("power")
    @Nullable
    private String power;

    @Expose
    @SerializedName("loyalty")
    @Nullable
    private String loyalty;

    @Expose
    @SerializedName("hand_modifier")
    @Nullable
    private String hand_modifier;

    @Expose
    @SerializedName("life_modifier")
    @Nullable
    private String life_modifier;

    @Expose
    @SerializedName("oracle_text")
    @Nullable
    private String oracle_text;

    @Expose
    @SerializedName("type_line")
    @Nullable
    private String type_line;

    @Expose
    @SerializedName("cmc")
    @Nullable
    private double cmc;

    @Expose
    @SerializedName("mana_cost")
    @Nullable
    private String mana_cost;

    @Expose
    @SerializedName("image_uris")
    @Nullable
    private Image_urisEntity image_uris;

    @Expose
    @SerializedName("highres_image")
    @Nullable
    private boolean highres_image;

    @Expose
    @SerializedName("layout")
    @Nullable
    private String layout;

    @Expose
    @SerializedName("frame_effect")
    @Nullable
    private String frame_effect;

    @Expose
    @SerializedName("watermark")
    @Nullable
    private String watermark;

    @Expose
    @SerializedName("printed_name")
    @Nullable
    private String printed_name;

    @Expose
    @SerializedName("printed_text")
    @Nullable
    private String printed_text;

    @Expose
    @SerializedName("printed_type_line")
    @Nullable
    private String printed_type_line;

    @Expose
    @SerializedName("all_parts")
    @Nullable
    private List<All_partsEntity> all_parts;

    @Expose
    @SerializedName("all_parts_ids")
    @Nullable
    private List<Long> all_parts_ids;

    @Expose
    @SerializedName("card_faces")
    @Nullable
    private List<Card_facesEntity> card_faces;

    @Expose
    @SerializedName("card_faces_ids")
    @Nullable
    private List<Long> card_faces_ids;

    @Expose
    @SerializedName("scryfall_uri")
    @Nullable
    private String scryfall_uri;

    @Expose
    @SerializedName("uri")
    @Nullable
    private String uri;

    @Expose
    @SerializedName("released_at")
    @Nullable
    private String released_at;

    @Expose
    @SerializedName("lang")
    @Nullable
    private String lang;

    @Expose
    @SerializedName("name")
    @Nullable
    private String name;

    @Expose
    @SerializedName("tcgplayer_id")
    @Nullable
    private int tcgplayer_id;

    @Expose
    @SerializedName("mtgo_foil_id")
    @Nullable
    private int mtgo_foil_id;

    @Expose
    @SerializedName("mtgo_id")
    @Nullable
    private int mtgo_id;

    @Expose
    @SerializedName("arena_id")
    @Nullable
    private int arena_id;

    @Expose
    @SerializedName("multiverse_ids")
    @Nullable
    private List<Integer> multiverse_ids;

    @Expose
    @SerializedName("oracle_id")
    @Nullable
    private String oracle_id;

    @Expose
    @SerializedName("id")
    @Nullable
    private String id;

    @Expose
    @SerializedName("object")
    @Nullable
    private String object;

    public Card() {

    }

    public Card(@Nullable String type_line, @Nullable String mana_cost, @Nullable String name) {
        this.type_line = type_line;
        this.mana_cost = mana_cost;
        this.name = name;
    }

    public Card(@Nullable String name) {
        this.name = name;
    }

    public Card(@Nullable Purchase_urisEntity purchase_uris, @Nullable Related_urisEntity related_uris, @Nullable PricesEntity prices, @Nullable String tix, @Nullable String eur, @Nullable String usd, int edhrec_rank, boolean story_spotlight, boolean full_art, @Nullable String frame, @Nullable String border_color, @Nullable List<String> color_indicator, @Nullable String artist, @Nullable String illustration_id, @Nullable String flavor_text, @Nullable String rarity, boolean digital, @Nullable String collector_number, @Nullable String prints_search_uri, @Nullable String rulings_uri, @Nullable String scryfall_set_uri, @Nullable String set_search_uri, @Nullable String set_uri, @Nullable String set_name, @Nullable String set, boolean reprint, boolean promo, boolean oversized, boolean nonfoil, boolean foil, boolean reserved, @Nullable List<String> games, @Nullable LegalitiesEntity legalities, @Nullable List<String> color_identity, @Nullable List<String> colors, @Nullable String toughness, @Nullable String power, @Nullable String loyalty, @Nullable String hand_modifier, @Nullable String life_modifier, @Nullable String oracle_text, @Nullable String type_line, double cmc, @Nullable String mana_cost, @Nullable Image_urisEntity image_uris, boolean highres_image, @Nullable String layout, @Nullable String frame_effect, @Nullable String watermark, @Nullable String printed_name, @Nullable String printed_text, @Nullable String printed_type_line, @Nullable List<All_partsEntity> all_parts, @Nullable List<Long> all_parts_ids, @Nullable List<Card_facesEntity> card_faces, @Nullable List<Long> card_faces_ids, @Nullable String scryfall_uri, @Nullable String uri, @Nullable String released_at, @Nullable String lang, @Nullable String name, int tcgplayer_id, int mtgo_foil_id, int mtgo_id, int arena_id, @Nullable List<Integer> multiverse_ids, @Nullable String oracle_id, @Nullable String id, @Nullable String object) {
        this.purchase_uris = purchase_uris;
        this.related_uris = related_uris;
        this.prices = prices;
        this.tix = tix;
        this.eur = eur;
        this.usd = usd;
        this.edhrec_rank = edhrec_rank;
        this.story_spotlight = story_spotlight;
        this.full_art = full_art;
        this.frame = frame;
        this.border_color = border_color;
        this.color_indicator = color_indicator;
        this.artist = artist;
        this.illustration_id = illustration_id;
        this.flavor_text = flavor_text;
        this.rarity = rarity;
        this.digital = digital;
        this.collector_number = collector_number;
        this.prints_search_uri = prints_search_uri;
        this.rulings_uri = rulings_uri;
        this.scryfall_set_uri = scryfall_set_uri;
        this.set_search_uri = set_search_uri;
        this.set_uri = set_uri;
        this.set_name = set_name;
        this.set = set;
        this.reprint = reprint;
        this.promo = promo;
        this.oversized = oversized;
        this.nonfoil = nonfoil;
        this.foil = foil;
        this.reserved = reserved;
        this.games = games;
        this.legalities = legalities;
        this.color_identity = color_identity;
        this.colors = colors;
        this.toughness = toughness;
        this.power = power;
        this.loyalty = loyalty;
        this.hand_modifier = hand_modifier;
        this.life_modifier = life_modifier;
        this.oracle_text = oracle_text;
        this.type_line = type_line;
        this.cmc = cmc;
        this.mana_cost = mana_cost;
        this.image_uris = image_uris;
        this.highres_image = highres_image;
        this.layout = layout;
        this.frame_effect = frame_effect;
        this.watermark = watermark;
        this.printed_name = printed_name;
        this.printed_text = printed_text;
        this.printed_type_line = printed_type_line;
        this.all_parts = all_parts;
        this.all_parts_ids = all_parts_ids;
        this.card_faces = card_faces;
        this.card_faces_ids = card_faces_ids;
        this.scryfall_uri = scryfall_uri;
        this.uri = uri;
        this.released_at = released_at;
        this.lang = lang;
        this.name = name;
        this.tcgplayer_id = tcgplayer_id;
        this.mtgo_foil_id = mtgo_foil_id;
        this.mtgo_id = mtgo_id;
        this.arena_id = arena_id;
        this.multiverse_ids = multiverse_ids;
        this.oracle_id = oracle_id;
        this.id = id;
        this.object = object;
    }

    @Nullable
    public List<Long> getAll_parts_ids() {
        return all_parts_ids;
    }

    public void setAll_parts_ids(@Nullable List<Long> all_parts_ids) {
        this.all_parts_ids = all_parts_ids;
    }

    @Nullable
    public List<Long> getCard_faces_ids() {
        return card_faces_ids;
    }

    public void setCard_faces_ids(@Nullable List<Long> card_faces_ids) {
        this.card_faces_ids = card_faces_ids;
    }

    @Nullable
    public List<String> getColor_indicator() {
        return color_indicator;
    }

    public void setColor_indicator(@Nullable List<String> color_indicator) {
        this.color_indicator = color_indicator;
    }

    @Nullable
    public Purchase_urisEntity getPurchase_uris() {
        return purchase_uris;
    }

    public void setPurchase_uris(@Nullable Purchase_urisEntity purchase_uris) {
        this.purchase_uris = purchase_uris;
    }

    @Nullable
    public Related_urisEntity getRelated_uris() {
        return related_uris;
    }

    public void setRelated_uris(@Nullable Related_urisEntity related_uris) {
        this.related_uris = related_uris;
    }

    @Nullable
    public PricesEntity getPrices() {
        return prices;
    }

    public void setPrices(@Nullable PricesEntity prices) {
        this.prices = prices;
    }

    @Nullable
    public String getTix() {
        return tix;
    }

    public void setTix(@Nullable String tix) {
        this.tix = tix;
    }

    @Nullable
    public String getEur() {
        return eur;
    }

    public void setEur(@Nullable String eur) {
        this.eur = eur;
    }

    @Nullable
    public String getUsd() {
        return usd;
    }

    public void setUsd(@Nullable String usd) {
        this.usd = usd;
    }

    @Nullable
    public int getEdhrec_rank() {
        return edhrec_rank;
    }

    public void setEdhrec_rank(@Nullable int edhrec_rank) {
        this.edhrec_rank = edhrec_rank;
    }

    @Nullable
    public boolean isStory_spotlight() {
        return story_spotlight;
    }

    public void setStory_spotlight(@Nullable boolean story_spotlight) {
        this.story_spotlight = story_spotlight;
    }

    @Nullable
    public boolean isFull_art() {
        return full_art;
    }

    public void setFull_art(@Nullable boolean full_art) {
        this.full_art = full_art;
    }

    @Nullable
    public String getFrame() {
        return frame;
    }

    public void setFrame(@Nullable String frame) {
        this.frame = frame;
    }

    @Nullable
    public String getBorder_color() {
        return border_color;
    }

    public void setBorder_color(@Nullable String border_color) {
        this.border_color = border_color;
    }

    @Nullable
    public String getArtist() {
        return artist;
    }

    public void setArtist(@Nullable String artist) {
        this.artist = artist;
    }

    @Nullable
    public String getIllustration_id() {
        return illustration_id;
    }

    public void setIllustration_id(@Nullable String illustration_id) {
        this.illustration_id = illustration_id;
    }

    @Nullable
    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(@Nullable String flavor_text) {
        this.flavor_text = flavor_text;
    }

    @Nullable
    public String getRarity() {
        return rarity;
    }

    public void setRarity(@Nullable String rarity) {
        this.rarity = rarity;
    }

    @Nullable
    public boolean isDigital() {
        return digital;
    }

    public void setDigital(@Nullable boolean digital) {
        this.digital = digital;
    }

    @Nullable
    public String getCollector_number() {
        return collector_number;
    }

    public void setCollector_number(@Nullable String collector_number) {
        this.collector_number = collector_number;
    }

    @Nullable
    public String getPrints_search_uri() {
        return prints_search_uri;
    }

    public void setPrints_search_uri(@Nullable String prints_search_uri) {
        this.prints_search_uri = prints_search_uri;
    }

    @Nullable
    public String getRulings_uri() {
        return rulings_uri;
    }

    public void setRulings_uri(@Nullable String rulings_uri) {
        this.rulings_uri = rulings_uri;
    }

    @Nullable
    public String getScryfall_set_uri() {
        return scryfall_set_uri;
    }

    public void setScryfall_set_uri(@Nullable String scryfall_set_uri) {
        this.scryfall_set_uri = scryfall_set_uri;
    }

    @Nullable
    public String getSet_search_uri() {
        return set_search_uri;
    }

    public void setSet_search_uri(@Nullable String set_search_uri) {
        this.set_search_uri = set_search_uri;
    }

    @Nullable
    public String getSet_uri() {
        return set_uri;
    }

    public void setSet_uri(@Nullable String set_uri) {
        this.set_uri = set_uri;
    }

    @Nullable
    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(@Nullable String set_name) {
        this.set_name = set_name;
    }

    @Nullable
    public String getSet() {
        return set;
    }

    public void setSet(@Nullable String set) {
        this.set = set;
    }

    @Nullable
    public boolean isReprint() {
        return reprint;
    }

    public void setReprint(@Nullable boolean reprint) {
        this.reprint = reprint;
    }

    @Nullable
    public boolean isPromo() {
        return promo;
    }

    public void setPromo(@Nullable boolean promo) {
        this.promo = promo;
    }

    @Nullable
    public boolean isOversized() {
        return oversized;
    }

    public void setOversized(@Nullable boolean oversized) {
        this.oversized = oversized;
    }

    @Nullable
    public boolean isNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(@Nullable boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    @Nullable
    public boolean isFoil() {
        return foil;
    }

    public void setFoil(@Nullable boolean foil) {
        this.foil = foil;
    }

    @Nullable
    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(@Nullable boolean reserved) {
        this.reserved = reserved;
    }

    @Nullable
    public List<String> getGames() {
        return games;
    }

    public void setGames(@Nullable List<String> games) {
        this.games = games;
    }

    @Nullable
    public LegalitiesEntity getLegalities() {
        return legalities;
    }

    public void setLegalities(@Nullable LegalitiesEntity legalities) {
        this.legalities = legalities;
    }

    @Nullable
    public List<String> getColor_identity() {
        return color_identity;
    }

    public void setColor_identity(@Nullable List<String> color_identity) {
        this.color_identity = color_identity;
    }

    @Nullable
    public List<String> getColors() {
        return colors;
    }

    public void setColors(@Nullable List<String> colors) {
        this.colors = colors;
    }

    @Nullable
    public String getToughness() {
        return toughness;
    }

    public void setToughness(@Nullable String toughness) {
        this.toughness = toughness;
    }

    @Nullable
    public String getPower() {
        return power;
    }

    public void setPower(@Nullable String power) {
        this.power = power;
    }

    @Nullable
    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(@Nullable String loyalty) {
        this.loyalty = loyalty;
    }

    @Nullable
    public String getHand_modifier() {
        return hand_modifier;
    }

    public void setHand_modifier(@Nullable String hand_modifier) {
        this.hand_modifier = hand_modifier;
    }

    @Nullable
    public String getLife_modifier() {
        return life_modifier;
    }

    public void setLife_modifier(@Nullable String life_modifier) {
        this.life_modifier = life_modifier;
    }

    @Nullable
    public String getOracle_text() {
        return oracle_text;
    }

    public void setOracle_text(@Nullable String oracle_text) {
        this.oracle_text = oracle_text;
    }

    @Nullable
    public String getType_line() {
        return type_line;
    }

    public void setType_line(@Nullable String type_line) {
        this.type_line = type_line;
    }

    @Nullable
    public double getCmc() {
        return cmc;
    }

    public void setCmc(@Nullable double cmc) {
        this.cmc = cmc;
    }

    @Nullable
    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(@Nullable String mana_cost) {
        this.mana_cost = mana_cost;
    }

    @Nullable
    public Image_urisEntity getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(@Nullable Image_urisEntity image_uris) {
        this.image_uris = image_uris;
    }

    @Nullable
    public boolean isHighres_image() {
        return highres_image;
    }

    public void setHighres_image(@Nullable boolean highres_image) {
        this.highres_image = highres_image;
    }

    @Nullable
    public String getLayout() {
        return layout;
    }

    public void setLayout(@Nullable String layout) {
        this.layout = layout;
    }

    @Nullable
    public String getFrame_effect() {
        return frame_effect;
    }

    public void setFrame_effect(@Nullable String frame_effect) {
        this.frame_effect = frame_effect;
    }

    @Nullable
    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(@Nullable String watermark) {
        this.watermark = watermark;
    }

    @Nullable
    public String getPrinted_name() {
        return printed_name;
    }

    public void setPrinted_name(@Nullable String printed_name) {
        this.printed_name = printed_name;
    }

    @Nullable
    public String getPrinted_text() {
        return printed_text;
    }

    public void setPrinted_text(@Nullable String printed_text) {
        this.printed_text = printed_text;
    }

    @Nullable
    public String getPrinted_type_line() {
        return printed_type_line;
    }

    public void setPrinted_type_line(@Nullable String printed_type_line) {
        this.printed_type_line = printed_type_line;
    }

    @Nullable
    public List<All_partsEntity> getAll_parts() {
        return all_parts;
    }

    public void setAll_parts(@Nullable List<All_partsEntity> all_parts) {
        this.all_parts = all_parts;
    }

    @Nullable
    public List<Card_facesEntity> getCard_faces() {
        return card_faces;
    }

    public void setCard_faces(@Nullable List<Card_facesEntity> card_faces) {
        this.card_faces = card_faces;
    }

    @Nullable
    public String getScryfall_uri() {
        return scryfall_uri;
    }

    public void setScryfall_uri(@Nullable String scryfall_uri) {
        this.scryfall_uri = scryfall_uri;
    }

    @Nullable
    public String getUri() {
        return uri;
    }

    public void setUri(@Nullable String uri) {
        this.uri = uri;
    }

    @Nullable
    public String getReleased_at() {
        return released_at;
    }

    public void setReleased_at(@Nullable String released_at) {
        this.released_at = released_at;
    }

    @Nullable
    public String getLang() {
        return lang;
    }

    public void setLang(@Nullable String lang) {
        this.lang = lang;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public int getTcgplayer_id() {
        return tcgplayer_id;
    }

    public void setTcgplayer_id(@Nullable int tcgplayer_id) {
        this.tcgplayer_id = tcgplayer_id;
    }

    @Nullable
    public int getMtgo_foil_id() {
        return mtgo_foil_id;
    }

    public void setMtgo_foil_id(@Nullable int mtgo_foil_id) {
        this.mtgo_foil_id = mtgo_foil_id;
    }

    @Nullable
    public int getMtgo_id() {
        return mtgo_id;
    }

    public void setMtgo_id(@Nullable int mtgo_id) {
        this.mtgo_id = mtgo_id;
    }

    @Nullable
    public int getArena_id() {
        return arena_id;
    }

    public void setArena_id(@Nullable int arena_id) {
        this.arena_id = arena_id;
    }

    @Nullable
    public List<Integer> getMultiverse_ids() {
        return multiverse_ids;
    }

    public void setMultiverse_ids(@Nullable List<Integer> multiverse_ids) {
        this.multiverse_ids = multiverse_ids;
    }

    @Nullable
    public String getOracle_id() {
        return oracle_id;
    }

    public void setOracle_id(@Nullable String oracle_id) {
        this.oracle_id = oracle_id;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable String id) {
        this.id = id;
    }

    @Nullable
    public String getObject() {
        return object;
    }

    public void setObject(@Nullable String object) {
        this.object = object;
    }

    public static class Purchase_urisEntity {
        @Expose
        @Nullable
        @SerializedName("cardhoarder")
        private String cardhoarder;

        @Expose
        @Nullable
        @SerializedName("cardmarket")
        private String cardmarket;

        @Expose
        @Nullable
        @SerializedName("tcgplayer")
        private String tcgplayer;

        @Nullable
        public String getCardhoarder() {
            return cardhoarder;
        }

        public void setCardhoarder(@Nullable String cardhoarder) {
            this.cardhoarder = cardhoarder;
        }

        @Nullable
        public String getCardmarket() {
            return cardmarket;
        }

        public void setCardmarket(@Nullable String cardmarket) {
            this.cardmarket = cardmarket;
        }

        @Nullable
        public String getTcgplayer() {
            return tcgplayer;
        }

        public void setTcgplayer(@Nullable String tcgplayer) {
            this.tcgplayer = tcgplayer;
        }
    }

    public static class Related_urisEntity {
        @Expose
        @Nullable
        @SerializedName("mtgtop8")
        private String mtgtop8;

        @Expose
        @Nullable
        @SerializedName("edhrec")
        private String edhrec;

        @Expose
        @Nullable
        @SerializedName("tcgplayer_decks")
        private String tcgplayer_decks;

        @Expose
        @Nullable
        @SerializedName("gatherer")
        private String gatherer;

        @Nullable
        public String getMtgtop8() {
            return mtgtop8;
        }

        public void setMtgtop8(@Nullable String mtgtop8) {
            this.mtgtop8 = mtgtop8;
        }

        @Nullable
        public String getEdhrec() {
            return edhrec;
        }

        public void setEdhrec(@Nullable String edhrec) {
            this.edhrec = edhrec;
        }

        @Nullable
        public String getTcgplayer_decks() {
            return tcgplayer_decks;
        }

        public void setTcgplayer_decks(@Nullable String tcgplayer_decks) {
            this.tcgplayer_decks = tcgplayer_decks;
        }

        @Nullable
        public String getGatherer() {
            return gatherer;
        }

        public void setGatherer(@Nullable String gatherer) {
            this.gatherer = gatherer;
        }
    }

    public static class PricesEntity {
        @Expose
        @Nullable
        @SerializedName("tix")
        private String tix;

        @Expose
        @Nullable
        @SerializedName("eur")
        private String eur;

        @Expose
        @Nullable
        @SerializedName("usd")
        private String usd;

        @Nullable
        public String getTix() {
            return tix;
        }

        public void setTix(@Nullable String tix) {
            this.tix = tix;
        }

        @Nullable
        public String getEur() {
            return eur;
        }

        public void setEur(@Nullable String eur) {
            this.eur = eur;
        }

        @Nullable
        public String getUsd() {
            return usd;
        }

        public void setUsd(@Nullable String usd) {
            this.usd = usd;
        }
    }

    public static class LegalitiesEntity {
        @Expose
        @Nullable
        @SerializedName("oldschool")
        private String oldschool;

        @Expose
        @Nullable
        @SerializedName("duel")
        private String duel;

        @Expose
        @Nullable
        @SerializedName("commander")
        private String commander;

        @Expose
        @Nullable
        @SerializedName("penny")
        private String penny;

        @Expose
        @Nullable
        @SerializedName("vintage")
        private String vintage;

        @Expose
        @Nullable
        @SerializedName("pauper")
        private String pauper;

        @Expose
        @Nullable
        @SerializedName("legacy")
        private String legacy;

        @Expose
        @Nullable
        @SerializedName("modern")
        private String modern;

        @Expose
        @Nullable
        @SerializedName("frontier")
        private String frontier;

        @Expose
        @Nullable
        @SerializedName("future")
        private String future;

        @Expose
        @Nullable
        @SerializedName("standard")
        private String standard;

        @Nullable
        public String getOldschool() {
            return oldschool;
        }

        public void setOldschool(@Nullable String oldschool) {
            this.oldschool = oldschool;
        }

        @Nullable
        public String getDuel() {
            return duel;
        }

        public void setDuel(@Nullable String duel) {
            this.duel = duel;
        }

        @Nullable
        public String getCommander() {
            return commander;
        }

        public void setCommander(@Nullable String commander) {
            this.commander = commander;
        }

        @Nullable
        public String getPenny() {
            return penny;
        }

        public void setPenny(@Nullable String penny) {
            this.penny = penny;
        }

        @Nullable
        public String getVintage() {
            return vintage;
        }

        public void setVintage(@Nullable String vintage) {
            this.vintage = vintage;
        }

        @Nullable
        public String getPauper() {
            return pauper;
        }

        public void setPauper(@Nullable String pauper) {
            this.pauper = pauper;
        }

        @Nullable
        public String getLegacy() {
            return legacy;
        }

        public void setLegacy(@Nullable String legacy) {
            this.legacy = legacy;
        }

        @Nullable
        public String getModern() {
            return modern;
        }

        public void setModern(@Nullable String modern) {
            this.modern = modern;
        }

        @Nullable
        public String getFrontier() {
            return frontier;
        }

        public void setFrontier(@Nullable String frontier) {
            this.frontier = frontier;
        }

        @Nullable
        public String getFuture() {
            return future;
        }

        public void setFuture(@Nullable String future) {
            this.future = future;
        }

        @Nullable
        public String getStandard() {
            return standard;
        }

        public void setStandard(@Nullable String standard) {
            this.standard = standard;
        }
    }

    public static class Image_urisEntity {
        @Expose
        @Nullable
        @SerializedName("border_crop")
        private String border_crop;

        @Expose
        @Nullable
        @SerializedName("art_crop")
        private String art_crop;

        @Expose
        @Nullable
        @SerializedName("png")
        private String png;

        @Expose
        @Nullable
        @SerializedName("large")
        private String large;

        @Expose
        @Nullable
        @SerializedName("normal")
        private String normal;

        @Expose
        @Nullable
        @SerializedName("small")
        private String small;

        @Nullable
        public String getBorder_crop() {
            return border_crop;
        }

        public void setBorder_crop(@Nullable String border_crop) {
            this.border_crop = border_crop;
        }

        @Nullable
        public String getArt_crop() {
            return art_crop;
        }

        public void setArt_crop(@Nullable String art_crop) {
            this.art_crop = art_crop;
        }

        @Nullable
        public String getPng() {
            return png;
        }

        public void setPng(@Nullable String png) {
            this.png = png;
        }

        @Nullable
        public String getLarge() {
            return large;
        }

        public void setLarge(@Nullable String large) {
            this.large = large;
        }

        @Nullable
        public String getNormal() {
            return normal;
        }

        public void setNormal(@Nullable String normal) {
            this.normal = normal;
        }

        @Nullable
        public String getSmall() {
            return small;
        }

        public void setSmall(@Nullable String small) {
            this.small = small;
        }
    }

    public static class Card_facesEntity {
        @Expose
        @Nullable
        @SerializedName("image_uris")
        private Image_urisEntity image_uris;

        @Expose
        @Nullable
        @SerializedName("illustration_id")
        private String illustration_id;

        @Expose
        @Nullable
        @SerializedName("artist")
        private String artist;

        @Expose
        @Nullable
        @SerializedName("flavor_text")
        private String flavor_text;

        @Expose
        @Nullable
        @SerializedName("toughness")
        private String toughness;

        @Expose
        @Nullable
        @SerializedName("power")
        private String power;

        @Expose
        @Nullable
        @SerializedName("loyalty")
        private String loyalty;

        @Expose
        @Nullable
        @SerializedName("printed_name")
        private String printed_name;

        @Expose
        @Nullable
        @SerializedName("printed_text")
        private String printed_text;

        @Expose
        @Nullable
        @SerializedName("printed_type_line")
        private String printed_type_line;

        @Expose
        @Nullable
        @SerializedName("color_indicator")
        private List<String> color_indicator;

        @Expose
        @Nullable
        @SerializedName("watermark")
        //private List<String> watermark;
        private String watermark;

        @Expose
        @Nullable
        @SerializedName("colors")
        private List<String> colors;

        @Expose
        @Nullable
        @SerializedName("oracle_text")
        private String oracle_text;

        @Expose
        @Nullable
        @SerializedName("type_line")
        private String type_line;

        @Expose
        @Nullable
        @SerializedName("mana_cost")
        private String mana_cost;

        @Expose
        @Nullable
        @SerializedName("name")
        private String name;

        @Expose
        @Nullable
        @SerializedName("object")
        private String object;

        @Nullable
        public Image_urisEntity getImage_uris() {
            return image_uris;
        }

        public void setImage_uris(@Nullable Image_urisEntity image_uris) {
            this.image_uris = image_uris;
        }

        @Nullable
        public String getIllustration_id() {
            return illustration_id;
        }

        public void setIllustration_id(@Nullable String illustration_id) {
            this.illustration_id = illustration_id;
        }

        @Nullable
        public String getArtist() {
            return artist;
        }

        public void setArtist(@Nullable String artist) {
            this.artist = artist;
        }

        @Nullable
        public String getFlavor_text() {
            return flavor_text;
        }

        public void setFlavor_text(@Nullable String flavor_text) {
            this.flavor_text = flavor_text;
        }

        @Nullable
        public String getToughness() {
            return toughness;
        }

        public void setToughness(@Nullable String toughness) {
            this.toughness = toughness;
        }

        @Nullable
        public String getPower() {
            return power;
        }

        public void setPower(@Nullable String power) {
            this.power = power;
        }

        @Nullable
        public String getLoyalty() {
            return loyalty;
        }

        public void setLoyalty(@Nullable String loyalty) {
            this.loyalty = loyalty;
        }

        @Nullable
        public String getPrinted_name() {
            return printed_name;
        }

        public void setPrinted_name(@Nullable String printed_name) {
            this.printed_name = printed_name;
        }

        @Nullable
        public String getPrinted_text() {
            return printed_text;
        }

        public void setPrinted_text(@Nullable String printed_text) {
            this.printed_text = printed_text;
        }

        @Nullable
        public String getPrinted_type_line() {
            return printed_type_line;
        }

        public void setPrinted_type_line(@Nullable String printed_type_line) {
            this.printed_type_line = printed_type_line;
        }

        @Nullable
        public List<String> getColor_indicator() {
            return color_indicator;
        }

        public void setColor_indicator(@Nullable List<String> color_indicator) {
            this.color_indicator = color_indicator;
        }

        @Nullable
        public String getWatermark() {
            return watermark;
        }

        public void setWatermark(@Nullable String watermark) {
            this.watermark = watermark;
        }

        @Nullable
        public List<String> getColors() {
            return colors;
        }

        public void setColors(@Nullable List<String> colors) {
            this.colors = colors;
        }

        @Nullable
        public String getOracle_text() {
            return oracle_text;
        }

        public void setOracle_text(@Nullable String oracle_text) {
            this.oracle_text = oracle_text;
        }

        @Nullable
        public String getType_line() {
            return type_line;
        }

        public void setType_line(@Nullable String type_line) {
            this.type_line = type_line;
        }

        @Nullable
        public String getMana_cost() {
            return mana_cost;
        }

        public void setMana_cost(@Nullable String mana_cost) {
            this.mana_cost = mana_cost;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public String getObject() {
            return object;
        }

        public void setObject(@Nullable String object) {
            this.object = object;
        }

        public ContentValues toContentValues() {
            ContentValues values = new ContentValues();
            try {
                values.put(DBSchema.CardEntry.CARD_FACES_NAME, name);
                values.put(DBSchema.CardEntry.CARD_FACES_MANA_COST, mana_cost);
                values.put(DBSchema.CardEntry.CARD_FACES_ILLUSTRATION_ID, illustration_id);
                if (getColor_indicator() != null) {
                    values.put(DBSchema.CardEntry.CARD_FACES_COLOR_INDICATOR, getColor_indicator().toString());
                }
                if(getColors() != null) {
                    values.put(DBSchema.CardEntry.CARD_FACES_COLORS, getColors().toString());
                }
                values.put(DBSchema.CardEntry.CARD_FACES_TYPE_LINE, type_line);
                values.put(DBSchema.CardEntry.CARD_FACES_ORACLE_TEXT, oracle_text);
                values.put(DBSchema.CardEntry.CARD_FACES_FLAVOR_TEXT, flavor_text);
                if(getWatermark() != null) {
                    values.put(DBSchema.CardEntry.CARD_FACES_WATERMARK, getWatermark().toString());
                }
                values.put(DBSchema.CardEntry.CARD_FACES_ARTIST, artist);
                values.put(DBSchema.CardEntry.CARD_FACES_POWER, power);
                values.put(DBSchema.CardEntry.CARD_FACES_TOUGHNESS, toughness);
                values.put(DBSchema.CardEntry.CARD_FACES_LOYALTY, loyalty);
                values.put(DBSchema.CardEntry.CARD_FACES_OBJECT, object);
                if(getImage_uris() != null) {
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_SMALL, image_uris.small);
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_NORMAL, image_uris.large);
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_LARGE, image_uris.large);
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_PNG, image_uris.png);
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_ART_CROP, image_uris.art_crop);
                    values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_BORDER_CROP, image_uris.border_crop);
                }
            }catch (NullPointerException e){
                Log.d("Error", e.toString());
            }

            return values;

        }
    }

    public static class All_partsEntity {
        @Expose
        @Nullable
        @SerializedName("uri")
        private String uri;

        @Expose
        @Nullable
        @SerializedName("type_line")
        private String type_line;

        @Expose
        @Nullable
        @SerializedName("name")
        private String name;

        @Expose
        @Nullable
        @SerializedName("component")
        private String component;

        @Expose
        @Nullable
        @SerializedName("id")
        private String id;

        @Expose
        @Nullable
        @SerializedName("object")
        private String object;

        @Nullable
        public String getUri() {
            return uri;
        }

        public void setUri(@Nullable String uri) {
            this.uri = uri;
        }

        @Nullable
        public String getType_line() {
            return type_line;
        }

        public void setType_line(@Nullable String type_line) {
            this.type_line = type_line;
        }

        @Nullable
        public String getName() {
            return name;
        }

        public void setName(@Nullable String name) {
            this.name = name;
        }

        @Nullable
        public String getComponent() {
            return component;
        }

        public void setComponent(@Nullable String component) {
            this.component = component;
        }

        @Nullable
        public String getId() {
            return id;
        }

        public void setId(@Nullable String id) {
            this.id = id;
        }

        @Nullable
        public String getObject() {
            return object;
        }

        public void setObject(@Nullable String object) {
            this.object = object;
        }

        public ContentValues toContentValues() {
            ContentValues values = new ContentValues();
            try {
                values.put(DBSchema.CardEntry.ALL_PARTS_ID, id);
                values.put(DBSchema.CardEntry.ALL_PARTS_NAME, name);
                values.put(DBSchema.CardEntry.ALL_PARTS_TYPE_LINE, type_line);
                values.put(DBSchema.CardEntry.ALL_PARTS_COMPONENTS, component);
                values.put(DBSchema.CardEntry.ALL_PARTS_OBJECT, object);
                values.put(DBSchema.CardEntry.ALL_PARTS_URI, uri);
        }catch (NullPointerException e){
            Log.d("Error", e.toString());
        }

        return values;

        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "purchase_uris=" + purchase_uris +
                ", related_uris=" + related_uris +
                ", prices=" + prices +
                ", tix='" + tix + '\'' +
                ", eur='" + eur + '\'' +
                ", usd='" + usd + '\'' +
                ", edhrec_rank=" + edhrec_rank +
                ", story_spotlight=" + story_spotlight +
                ", full_art=" + full_art +
                ", frame='" + frame + '\'' +
                ", border_color='" + border_color + '\'' +
                ", color_indicator='" + color_indicator + '\'' +
                ", artist='" + artist + '\'' +
                ", illustration_id='" + illustration_id + '\'' +
                ", flavor_text='" + flavor_text + '\'' +
                ", rarity='" + rarity + '\'' +
                ", digital=" + digital +
                ", collector_number='" + collector_number + '\'' +
                ", prints_search_uri='" + prints_search_uri + '\'' +
                ", rulings_uri='" + rulings_uri + '\'' +
                ", scryfall_set_uri='" + scryfall_set_uri + '\'' +
                ", set_search_uri='" + set_search_uri + '\'' +
                ", set_uri='" + set_uri + '\'' +
                ", set_name='" + set_name + '\'' +
                ", set='" + set + '\'' +
                ", reprint=" + reprint +
                ", promo=" + promo +
                ", oversized=" + oversized +
                ", nonfoil=" + nonfoil +
                ", foil=" + foil +
                ", reserved=" + reserved +
                ", games=" + games +
                ", legalities=" + legalities +
                ", color_identity=" + color_identity +
                ", colors=" + colors +
                ", toughness='" + toughness + '\'' +
                ", power='" + power + '\'' +
                ", loyalty='" + loyalty + '\'' +
                ", hand_modifier='" + hand_modifier + '\'' +
                ", life_modifier='" + life_modifier + '\'' +
                ", oracle_text='" + oracle_text + '\'' +
                ", type_line='" + type_line + '\'' +
                ", cmc=" + cmc +
                ", mana_cost='" + mana_cost + '\'' +
                ", image_uris=" + image_uris +
                ", highres_image=" + highres_image +
                ", layout='" + layout + '\'' +
                ", frame_effect='" + frame_effect + '\'' +
                ", watermark='" + watermark + '\'' +
                ", printed_name='" + printed_name + '\'' +
                ", printed_text='" + printed_text + '\'' +
                ", printed_type_line='" + printed_type_line + '\'' +
                ", all_parts=" + all_parts +
                ", card_faces=" + card_faces +
                ", scryfall_uri='" + scryfall_uri + '\'' +
                ", uri='" + uri + '\'' +
                ", released_at='" + released_at + '\'' +
                ", lang='" + lang + '\'' +
                ", name='" + name + '\'' +
                ", tcgplayer_id=" + tcgplayer_id +
                ", mtgo_foil_id=" + mtgo_foil_id +
                ", mtgo_id=" + mtgo_id +
                ", arena_id=" + arena_id +
                ", multiverse_ids=" + multiverse_ids +
                ", oracle_id='" + oracle_id + '\'' +
                ", id='" + id + '\'' +
                ", object='" + object + '\'' +
                '}';
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        try {
            values.put(DBSchema.CardEntry.ID, id);
            values.put(DBSchema.CardEntry.NAME, name);
            values.put(DBSchema.CardEntry.MANA_COST, mana_cost);
            values.put(DBSchema.CardEntry.CMC, cmc);
            if (getColors() != null) {
                values.put(DBSchema.CardEntry.COLORS, getColors().toString());
            }
            if (getColor_identity() != null) {
                values.put(DBSchema.CardEntry.COLOR_IDENTITY, getColor_identity().toString());
            }
            if (getColor_indicator() != null) {
                values.put(DBSchema.CardEntry.COLOR_INDICATOR, getColor_indicator().toString());
            }
            values.put(DBSchema.CardEntry.TYPE_LINE, type_line);
            values.put(DBSchema.CardEntry.RARITY, rarity);
            values.put(DBSchema.CardEntry.COLLECTOR_NUMBER, collector_number);
            values.put(DBSchema.CardEntry.FOIL, foil);
            values.put(DBSchema.CardEntry.PROMO, promo);
            values.put(DBSchema.CardEntry.FULL_ART, full_art);
            values.put(DBSchema.CardEntry.NONFOIL, nonfoil);
            values.put(DBSchema.CardEntry.SET, set);
            values.put(DBSchema.CardEntry.SET_NAME, set_name);
            values.put(DBSchema.CardEntry.ORACLE_TEXT, oracle_text);
            values.put(DBSchema.CardEntry.FLAVOR_TEXT, flavor_text);
            values.put(DBSchema.CardEntry.WATERMARK, watermark);
            values.put(DBSchema.CardEntry.STORY_SPOTLIGHT, story_spotlight);
            values.put(DBSchema.CardEntry.POWER, power);
            values.put(DBSchema.CardEntry.TOUGHNESS, toughness);
            values.put(DBSchema.CardEntry.LOYALTY, loyalty);
            values.put(DBSchema.CardEntry.ARTIST, artist);
            if (getPrices() != null) {
                values.put(DBSchema.CardEntry.PRICES, getPrices().toString());
                values.put(DBSchema.CardEntry.PRICES_EUR, prices.eur);
                values.put(DBSchema.CardEntry.PRICES_USD, prices.usd);
                values.put(DBSchema.CardEntry.PRICES_TIX, prices.tix);
            }
            if (getGames() != null) {
                values.put(DBSchema.CardEntry.GAMES, getGames().toString());
            }
            values.put(DBSchema.CardEntry.LANG, lang);
            values.put(DBSchema.CardEntry.RELEASED_AT, released_at);
            values.put(DBSchema.CardEntry.REPRINT, reprint);
            values.put(DBSchema.CardEntry.PRINTED_NAME, printed_name);
            values.put(DBSchema.CardEntry.PRINTED_TEXT, printed_text);
            values.put(DBSchema.CardEntry.PRINTED_TYPE_LINE, printed_type_line);
            values.put(DBSchema.CardEntry.OBJECT, object);
            values.put(DBSchema.CardEntry.EDHREC_RANK, edhrec_rank);
            values.put(DBSchema.CardEntry.LAYOUT, layout);
            values.put(DBSchema.CardEntry.OVERSIZED, oversized);
            values.put(DBSchema.CardEntry.FRAME, frame);
            values.put(DBSchema.CardEntry.FRAME_EFFECT, frame_effect);
            values.put(DBSchema.CardEntry.BORDER_COLOR, border_color);
            values.put(DBSchema.CardEntry.URI, uri);
            values.put(DBSchema.CardEntry.SET_URI, set_uri);
            if (getImage_uris() != null) {
                values.put(DBSchema.CardEntry.IMAGE_URIS, getImage_uris().toString());
                values.put(DBSchema.CardEntry.IMAGE_URIS_SMALL, image_uris.small);
                values.put(DBSchema.CardEntry.IMAGE_URIS_NORMAL, image_uris.normal);
                values.put(DBSchema.CardEntry.IMAGE_URIS_LARGE, image_uris.large);
                values.put(DBSchema.CardEntry.IMAGE_URIS_PNG, image_uris.png);
                values.put(DBSchema.CardEntry.IMAGE_URIS_ART_CROP, image_uris.art_crop);
                values.put(DBSchema.CardEntry.IMAGE_URIS_BORDER_CROP, image_uris.border_crop);
            }
            values.put(DBSchema.CardEntry.HIGHRES_IMAGE, highres_image);
            if (getMultiverse_ids() != null) {
                values.put(DBSchema.CardEntry.MULTIVERSE_IDS, getMultiverse_ids().toString());
            }
            values.put(DBSchema.CardEntry.ORACLE_ID, oracle_id);
            values.put(DBSchema.CardEntry.TCGPLAYER_ID, tcgplayer_id);
            values.put(DBSchema.CardEntry.ILLUSTRATION_ID, illustration_id);
            values.put(DBSchema.CardEntry.ARENA_ID, arena_id);
            values.put(DBSchema.CardEntry.MTGO_ID, mtgo_id);
            values.put(DBSchema.CardEntry.MTGO_FOIL_ID, mtgo_foil_id);
            values.put(DBSchema.CardEntry.DIGITAL, digital);
            if (getAll_parts() != null) {
                values.put(DBSchema.CardEntry.ALL_PARTS_IDS, all_parts_ids.toString());
            }
            if (getCard_faces() != null) {
                values.put(DBSchema.CardEntry.CARD_FACES_IDS, card_faces_ids.toString());
            }
            /*for (int i = 0; i < all_parts.size(); i++) {
                values.put(DBSchema.CardEntry.ALL_PARTS_ID, all_parts.get(i).id);
                values.put(DBSchema.CardEntry.ALL_PARTS_NAME, all_parts.get(i).name);
                values.put(DBSchema.CardEntry.ALL_PARTS_TYPE_LINE, all_parts.get(i).type_line);
                values.put(DBSchema.CardEntry.ALL_PARTS_COMPONENTS, all_parts.get(i).component);
                values.put(DBSchema.CardEntry.ALL_PARTS_OBJECT, all_parts.get(i).object);
                values.put(DBSchema.CardEntry.ALL_PARTS_URI, all_parts.get(i).uri);
            }
            values.put(DBSchema.CardEntry.CARD_FACES, card_faces.toString());
            for (int i = 0; i < card_faces.size(); i++) {
                values.put(DBSchema.CardEntry.CARD_FACES_NAME, card_faces.get(i).name);
                values.put(DBSchema.CardEntry.CARD_FACES_MANA_COST, card_faces.get(i).mana_cost);
                values.put(DBSchema.CardEntry.CARD_FACES_ILLUSTRATION_ID, card_faces.get(i).illustration_id);
                values.put(DBSchema.CardEntry.CARD_FACES_COLOR_INDICATOR, card_faces.get(i).getColor_indicator().toString());
                values.put(DBSchema.CardEntry.CARD_FACES_COLORS, card_faces.get(i).getColors().toString());
                values.put(DBSchema.CardEntry.CARD_FACES_TYPE_LINE, card_faces.get(i).type_line);
                values.put(DBSchema.CardEntry.CARD_FACES_ORACLE_TEXT, card_faces.get(i).oracle_text);
                values.put(DBSchema.CardEntry.CARD_FACES_FLAVOR_TEXT, card_faces.get(i).flavor_text);
                values.put(DBSchema.CardEntry.CARD_FACES_WATERMARK, card_faces.get(i).getWatermark().toString());
                values.put(DBSchema.CardEntry.CARD_FACES_ARTIST, card_faces.get(i).artist);
                values.put(DBSchema.CardEntry.CARD_FACES_POWER, card_faces.get(i).power);
                values.put(DBSchema.CardEntry.CARD_FACES_TOUGHNESS, card_faces.get(i).toughness);
                values.put(DBSchema.CardEntry.CARD_FACES_LOYALTY, card_faces.get(i).loyalty);
                values.put(DBSchema.CardEntry.CARD_FACES_OBJECT, card_faces.get(i).object);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_SMALL, card_faces.get(i).image_uris.small);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_NORMAL, card_faces.get(i).image_uris.large);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_LARGE, card_faces.get(i).image_uris.large);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_PNG, card_faces.get(i).image_uris.png);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_ART_CROP, card_faces.get(i).image_uris.art_crop);
                values.put(DBSchema.CardEntry.CARD_FACES_IMAGE_URIS_BORDER_CROP, card_faces.get(i).image_uris.border_crop);
            }*/
            values.put(DBSchema.CardEntry.SET_SEARCH_URI, set_search_uri);
            values.put(DBSchema.CardEntry.PRINTS_SEARCH_URI, prints_search_uri);
            values.put(DBSchema.CardEntry.RULINGS_URI, rulings_uri);
            values.put(DBSchema.CardEntry.SCRYFALL_URI, scryfall_uri);
            values.put(DBSchema.CardEntry.SCRYFALL_SET_URI, scryfall_set_uri);
            if (getPurchase_uris() != null) {
                values.put(DBSchema.CardEntry.PURCHASE_URIS, getPurchase_uris().toString());
                values.put(DBSchema.CardEntry.PURCHASE_URIS_CARDMARKET, purchase_uris.cardmarket);
                values.put(DBSchema.CardEntry.PURCHASE_URIS_TCGPLAYER, purchase_uris.tcgplayer);
                values.put(DBSchema.CardEntry.PURCHASE_URIS_CARDHORADER, purchase_uris.cardhoarder);
            }
            if (getRelated_uris() != null) {
                values.put(DBSchema.CardEntry.RELATED_URIS, related_uris.toString());
                values.put(DBSchema.CardEntry.RELATED_URIS_GATHERER, related_uris.gatherer);
                values.put(DBSchema.CardEntry.RELATED_URIS_TCG_PLAYER_DECKS, related_uris.tcgplayer_decks);
                values.put(DBSchema.CardEntry.RELATED_URIS_EDHREC, related_uris.edhrec);
                values.put(DBSchema.CardEntry.RELATED_URIS_MTG_TOP8, related_uris.mtgtop8);
            }
            if (getLegalities() != null) {
                values.put(DBSchema.CardEntry.LEGALITIES, getLegalities().toString());
                values.put(DBSchema.CardEntry.LEGALITIES_STANDARD, legalities.standard);
                values.put(DBSchema.CardEntry.LEGALITIES_FRONTIER, legalities.frontier);
                values.put(DBSchema.CardEntry.LEGALITIES_MODERN, legalities.modern);
                values.put(DBSchema.CardEntry.LEGALITIES_LEGACY, legalities.legacy);
                values.put(DBSchema.CardEntry.LEGALITIES_VINTAGE, legalities.vintage);
                values.put(DBSchema.CardEntry.LEGALITIES_COMMANDER, legalities.commander);
                values.put(DBSchema.CardEntry.LEGALITIES_PAUPER, legalities.pauper);
                values.put(DBSchema.CardEntry.LEGALITIES_PENNY, legalities.penny);
                values.put(DBSchema.CardEntry.LEGALITIES_FUTURE, legalities.future);
                values.put(DBSchema.CardEntry.LEGALITIES_OLDSCHOOL, legalities.oldschool);
                values.put(DBSchema.CardEntry.LEGALITIES_DUEL, legalities.duel);
            }
            values.put(DBSchema.CardEntry.RESERVED, reserved);
            values.put(DBSchema.CardEntry.LIFE_MODIFIER, life_modifier);
            values.put(DBSchema.CardEntry.HAND_MODIFIER, hand_modifier);
        }catch (NullPointerException e){
            Log.d("Error", e.toString());
        }

        return values;
    }

}