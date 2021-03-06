package com.cross.magic.db;

import android.provider.BaseColumns;

public class DBSchema {
    public static abstract class CardEntry implements BaseColumns {
        //public static final String TABLE_NAME ="cards";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String MANA_COST = "mana_cost";
        public static final String CMC = "cmc";
        public static final String COLORS = "colors";
        public static final String COLOR_IDENTITY = "color_identity";
        public static final String COLOR_INDICATOR = "color_indicator";
        public static final String TYPE_LINE = "type_line";
        public static final String RARITY = "rarity";
        public static final String COLLECTOR_NUMBER = "collector_number";
        public static final String FOIL = "foil";
        public static final String PROMO = "promo";
        public static final String FULL_ART = "full_art";
        public static final String NONFOIL = "nonfoil";
        public static final String SET = "`set`";
        public static final String SET_NAME = "set_name";
        public static final String ORACLE_TEXT = "oracle_text";
        public static final String FLAVOR_TEXT = "flavor_text";
        public static final String WATERMARK = "watermark";
        public static final String STORY_SPOTLIGHT = "story_spotlight";
        public static final String POWER = "power";
        public static final String TOUGHNESS = "toughness";
        public static final String LOYALTY = "loyalty";
        public static final String ARTIST = "artist";
        public static final String PRICES = "prices";
        public static final String PRICES_EUR = "prices_eur";
        public static final String PRICES_USD = "prices_usd";
        public static final String PRICES_TIX = "prices_tix";
        public static final String GAMES = "games";
        public static final String LANG = "lang";
        public static final String RELEASED_AT = "released_at";
        public static final String REPRINT = "reprint";
        public static final String PRINTED_NAME = "printed_name";
        public static final String PRINTED_TEXT = "printed_text";
        public static final String PRINTED_TYPE_LINE = "printed_type_line";
        public static final String OBJECT = "object";
        public static final String EDHREC_RANK = "edhrec_rank";
        public static final String LAYOUT = "layout";
        public static final String OVERSIZED = "oversized";
        public static final String FRAME = "frame";
        public static final String FRAME_EFFECT = "frame_effect";
        public static final String BORDER_COLOR = "border_color";
        public static final String URI = "uri";
        public static final String SET_URI = "set_uri";
        public static final String IMAGE_URIS = "image_uris";
        public static final String IMAGE_URIS_SMALL = "image_uris_small";
        public static final String IMAGE_URIS_NORMAL = "image_uris_normal";
        public static final String IMAGE_URIS_LARGE = "image_uris_large";
        public static final String IMAGE_URIS_PNG = "image_uris_png";
        public static final String IMAGE_URIS_ART_CROP = "image_uris_art_crop";
        public static final String IMAGE_URIS_BORDER_CROP = "image_uris_border_crop";
        public static final String HIGHRES_IMAGE = "highres_image";
        public static final String MULTIVERSE_IDS = "multiverse_ids";
        public static final String ORACLE_ID = "oracle_id";
        public static final String TCGPLAYER_ID = "tcgplayer_id";
        public static final String ILLUSTRATION_ID = "illustration_id";
        public static final String ARENA_ID = "arena_id";
        public static final String MTGO_ID = "mtgo_id";
        public static final String MTGO_FOIL_ID = "mtgo_foil_id";
        public static final String DIGITAL = "digital";
        public static final String ALL_PARTS_IDS = "all_parts_ids";
        public static final String ALL_PARTS_ID = "all_parts_id";
        public static final String ALL_PARTS_NAME = "all_parts_name";
        public static final String ALL_PARTS_TYPE_LINE = "all_parts_type_line";
        public static final String ALL_PARTS_COMPONENTS = "all_parts_component";
        public static final String ALL_PARTS_OBJECT = "all_parts_object";
        public static final String ALL_PARTS_URI = "all_parts_uri";
        public static final String CARD_FACES_IDS = "card_faces_ids";
        public static final String CARD_FACES_NAME = "card_faces_name";
        public static final String CARD_FACES_MANA_COST = "card_faces_mana_cost";
        public static final String CARD_FACES_ILLUSTRATION_ID = "card_faces_illustration_id";
        public static final String CARD_FACES_COLOR_INDICATOR = "card_faces_color_indicator";
        public static final String CARD_FACES_COLORS = "card_faces_colors";
        public static final String CARD_FACES_TYPE_LINE = "card_faces_type_line";
        public static final String CARD_FACES_ORACLE_TEXT= "card_faces_oracle_text";
        public static final String CARD_FACES_FLAVOR_TEXT = "card_faces_flavor_text";
        public static final String CARD_FACES_WATERMARK = "card_faces_watermark";
        public static final String CARD_FACES_ARTIST = "card_faces_artist";
        public static final String CARD_FACES_POWER = "card_faces_power";
        public static final String CARD_FACES_TOUGHNESS = "card_faces_toughness";
        public static final String CARD_FACES_LOYALTY = "card_faces_loyalty";
        public static final String CARD_FACES_OBJECT = "card_faces_object";
        public static final String CARD_FACES_IMAGE_URIS_SMALL = "card_faces_image_uris_small";
        public static final String CARD_FACES_IMAGE_URIS_NORMAL = "card_faces_image_uris_normal";
        public static final String CARD_FACES_IMAGE_URIS_LARGE = "card_faces_image_uris_large";
        public static final String CARD_FACES_IMAGE_URIS_PNG = "card_faces_image_uris_png";
        public static final String CARD_FACES_IMAGE_URIS_ART_CROP = "card_faces_image_uris_art_crop";
        public static final String CARD_FACES_IMAGE_URIS_BORDER_CROP = "card_faces_image_uris_border_crop";
        public static final String SET_SEARCH_URI = "set_search_uri";
        public static final String PRINTS_SEARCH_URI = "prints_search_uri";
        public static final String RULINGS_URI = "rulings_uri";
        public static final String SCRYFALL_URI = "scryfall_uri";
        public static final String SCRYFALL_SET_URI = "scryfall_set_uri";
        public static final String PURCHASE_URIS = "purchase_uris";
        public static final String PURCHASE_URIS_CARDMARKET = "purchase_uris_cardmarket";
        public static final String PURCHASE_URIS_TCGPLAYER = "purchase_uris_tcgplayer";
        public static final String PURCHASE_URIS_CARDHORADER = "purchase_uris_cardhoarder";
        public static final String RELATED_URIS = "related_uris";
        public static final String RELATED_URIS_GATHERER = "related_uris_gatherer";
        public static final String RELATED_URIS_TCG_PLAYER_DECKS = "related_uris_tcgplayer_decks";
        public static final String RELATED_URIS_EDHREC = "related_uris_edhrec";
        public static final String RELATED_URIS_MTG_TOP8 = "related_uris_mtgtop8";
        public static final String LEGALITIES = "legalities";
        public static final String LEGALITIES_STANDARD = "legalities_standard";
        public static final String LEGALITIES_FRONTIER = "legalities_frontier";
        public static final String LEGALITIES_MODERN = "legalities_modern";
        public static final String LEGALITIES_LEGACY = "legalities_legacy";
        public static final String LEGALITIES_VINTAGE = "legalities_vintage";
        public static final String LEGALITIES_COMMANDER = "legalities_commander";
        public static final String LEGALITIES_PAUPER = "legalities_pauper";
        public static final String LEGALITIES_PENNY = "legalities_penny";
        public static final String LEGALITIES_FUTURE = "legalities_future";
        public static final String LEGALITIES_OLDSCHOOL = "legalities_oldschool";
        public static final String LEGALITIES_DUEL = "legalities_duel";
        public static final String RESERVED = "reserved";
        public static final String LIFE_MODIFIER = "life_modifier";
        public static final String HAND_MODIFIER = "hand_modifier";
    }
}