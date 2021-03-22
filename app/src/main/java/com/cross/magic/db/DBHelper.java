package com.cross.magic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cross.magic.db.DBSchema.*;
import com.cross.magic.pojos.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Cards.db";
    private DBHelper helper;
    public final Context context;
    private SQLiteDatabase database;

    private static final Type REVIEW_TYPE = new TypeToken<List<Card>>() {
    }.getType();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cards (" +
                CardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CardEntry.ID + " TEXT NOT NULL," +
                CardEntry.NAME + " TEXT NOT NULL," +
                CardEntry.MANA_COST + " TEXT," +
                CardEntry.CMC + " DOUBLE," +
                CardEntry.COLORS + " TEXT," +
                CardEntry.COLOR_IDENTITY + " TEXT," +
                CardEntry.COLOR_INDICATOR + " TEXT," +
                CardEntry.TYPE_LINE + " TEXT," +
                CardEntry.RARITY + " TEXT," +
                CardEntry.COLLECTOR_NUMBER + " TEXT," +
                CardEntry.FOIL + " BOOLEAN," +
                CardEntry.PROMO + " BOOLEAN," +
                CardEntry.FULL_ART + " BOOLEAN," +
                CardEntry.NONFOIL + " BOOLEAN," +
                CardEntry.SET + " TEXT," +
                CardEntry.SET_NAME + " TEXT," +
                CardEntry.ORACLE_TEXT + " TEXT," +
                CardEntry.FLAVOR_TEXT + " TEXT," +
                CardEntry.WATERMARK + " TEXT," +
                CardEntry.STORY_SPOTLIGHT + " BOOLEAN," +
                CardEntry.POWER + " TEXT," +
                CardEntry.TOUGHNESS + " TEXT," +
                CardEntry.LOYALTY + " TEXT," +
                CardEntry.ARTIST + " TEXT," +
                CardEntry.PRICES + " OBJECT," +
                CardEntry.PRICES_EUR + " TEXT," +
                CardEntry.PRICES_USD + " TEXT," +
                CardEntry.PRICES_TIX + " TEXT," +
                CardEntry.GAMES + " ARRAY," +
                CardEntry.LANG + " TEXT," +
                CardEntry.RELEASED_AT + " DATE," +
                CardEntry.REPRINT + " BOOLEAN," +
                CardEntry.PRINTED_NAME + " TEXT," +
                CardEntry.PRINTED_TEXT + " TEXT," +
                CardEntry.PRINTED_TYPE_LINE + " TEXT," +
                CardEntry.OBJECT + " TEXT," +
                CardEntry.EDHREC_RANK + " INTEGER," +
                CardEntry.OVERSIZED + " BOOLEAN," +
                CardEntry.LAYOUT + " TEXT," +
                CardEntry.FRAME + " TEXT," +
                CardEntry.FRAME_EFFECT + " TEXT," +
                CardEntry.BORDER_COLOR + " TEXT," +
                CardEntry.URI + " TEXT," +
                CardEntry.SET_URI + " TEXT," +
                CardEntry.IMAGE_URIS + " OBJECT," +
                CardEntry.IMAGE_URIS_SMALL + " TEXT," +
                CardEntry.IMAGE_URIS_NORMAL + " TEXT," +
                CardEntry.IMAGE_URIS_LARGE + " TEXT," +
                CardEntry.IMAGE_URIS_PNG + " TEXT," +
                CardEntry.IMAGE_URIS_ART_CROP + " TEXT," +
                CardEntry.IMAGE_URIS_BORDER_CROP + " TEXT," +
                CardEntry.HIGHRES_IMAGE + " BOOLEAN," +
                CardEntry.MULTIVERSE_IDS + " ARRAY," +
                CardEntry.ORACLE_ID + " TEXT," +
                CardEntry.TCGPLAYER_ID + " INTEGER," +
                CardEntry.ILLUSTRATION_ID + " TEXT," +
                CardEntry.ARENA_ID + " INTEGER," +
                CardEntry.MTGO_ID + " INTEGER," +
                CardEntry.MTGO_FOIL_ID + " INTEGER," +
                CardEntry.DIGITAL + " BOOLEAN," +
                CardEntry.ALL_PARTS_IDS + " ARRAY," +
                CardEntry.CARD_FACES_IDS + " ARRAY," +
                CardEntry.SET_SEARCH_URI + " TEXT," +
                CardEntry.PRINTS_SEARCH_URI + " TEXT," +
                CardEntry.RULINGS_URI + " TEXT," +
                CardEntry.SCRYFALL_URI + " TEXT," +
                CardEntry.SCRYFALL_SET_URI + " TEXT," +
                CardEntry.PURCHASE_URIS + " OBJECT," +
                CardEntry.PURCHASE_URIS_CARDMARKET + " TEXT," +
                CardEntry.PURCHASE_URIS_TCGPLAYER + " TEXT," +
                CardEntry.PURCHASE_URIS_CARDHORADER + " TEXT," +
                CardEntry.RELATED_URIS + " OBJECT," +
                CardEntry.RELATED_URIS_GATHERER + " TEXT," +
                CardEntry.RELATED_URIS_TCG_PLAYER_DECKS + " TEXT," +
                CardEntry.RELATED_URIS_EDHREC + " TEXT," +
                CardEntry.RELATED_URIS_MTG_TOP8 + " TEXT," +
                CardEntry.LEGALITIES + " OBJECT," +
                CardEntry.LEGALITIES_STANDARD + " TEXT," +
                CardEntry.LEGALITIES_FRONTIER + " TEXT," +
                CardEntry.LEGALITIES_MODERN + " TEXT," +
                CardEntry.LEGALITIES_LEGACY + " TEXT," +
                CardEntry.LEGALITIES_VINTAGE + " TEXT," +
                CardEntry.LEGALITIES_COMMANDER + " TEXT," +
                CardEntry.LEGALITIES_PAUPER + " TEXT," +
                CardEntry.LEGALITIES_PENNY + " TEXT," +
                CardEntry.LEGALITIES_FUTURE + " TEXT," +
                CardEntry.LEGALITIES_OLDSCHOOL + " TEXT," +
                CardEntry.LEGALITIES_DUEL + " TEXT," +
                CardEntry.RESERVED + " BOOLEAN," +
                CardEntry.LIFE_MODIFIER + " TEXT," +
                CardEntry.HAND_MODIFIER + " TEXT," +
                "UNIQUE (" + CardEntry.ID + "))"
        );

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS card_faces (" +
                CardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CardEntry.CARD_FACES_NAME + " TEXT NOT NULL," +
                CardEntry.CARD_FACES_MANA_COST + " TEXT," +
                CardEntry.CARD_FACES_ILLUSTRATION_ID + " TEXT," +
                CardEntry.CARD_FACES_COLOR_INDICATOR + " TEXT," +
                CardEntry.CARD_FACES_COLORS + " TEXT," +
                CardEntry.CARD_FACES_TYPE_LINE + " TEXT," +
                CardEntry.CARD_FACES_ORACLE_TEXT + " TEXT," +
                CardEntry.CARD_FACES_FLAVOR_TEXT + " TEXT," +
                CardEntry.CARD_FACES_WATERMARK + " TEXT," +
                CardEntry.CARD_FACES_ARTIST + " TEXT," +
                CardEntry.CARD_FACES_POWER + " TEXT," +
                CardEntry.CARD_FACES_TOUGHNESS + " TEXT," +
                CardEntry.CARD_FACES_LOYALTY + " TEXT," +
                CardEntry.CARD_FACES_OBJECT + " OBJECT," +
                CardEntry.CARD_FACES_IMAGE_URIS_SMALL + " TEXT," +
                CardEntry.CARD_FACES_IMAGE_URIS_NORMAL + " TEXT," +
                CardEntry.CARD_FACES_IMAGE_URIS_LARGE + " TEXT," +
                CardEntry.CARD_FACES_IMAGE_URIS_PNG + " TEXT," +
                CardEntry.CARD_FACES_IMAGE_URIS_ART_CROP + " TEXT," +
                CardEntry.CARD_FACES_IMAGE_URIS_BORDER_CROP + " TEXT," +
                "UNIQUE (" + CardEntry.CARD_FACES_NAME + "))"
        );

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS all_parts (" +
                CardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CardEntry.ALL_PARTS_ID + " TEXT," +
                CardEntry.ALL_PARTS_NAME + " TEXT," +
                CardEntry.ALL_PARTS_TYPE_LINE + " TEXT," +
                CardEntry.ALL_PARTS_COMPONENTS + " TEXT," +
                CardEntry.ALL_PARTS_OBJECT + " OBJECT," +
                CardEntry.ALL_PARTS_URI + " TEXT,"+
                "UNIQUE (" + CardEntry.ALL_PARTS_ID +"))"
        );

        ContentValues values = new ContentValues();
        database = getWritableDatabase();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public DBHelper open() throws SQLException {
        helper = this;
        database = helper.getWritableDatabase();
        return this;
    }

    public List<Card> getAllValues() {
        List<Card> cardList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT name FROM cards";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Card card = new Card();
                //card.setId((cursor.getString(0)));
                card.setName(cursor.getString(2));
                cardList.add(card);
            } while (cursor.moveToNext());
        }

        return cardList;
    }

    public long saveCard(Card card) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                "cards",
                null,
                card.toContentValues());
    }

    public long saveFaces(Card.Card_facesEntity card) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long sqliteret = sqLiteDatabase.insert(
                "card_faces",
                null,
                card.toContentValues());
        return sqliteret;
    }

    public long saveParts(Card.All_partsEntity card) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long sqliteret = sqLiteDatabase.insert(
                "all_parts",
                null,
                card.toContentValues());
        return sqliteret;
    }

    public void parseJSON(String path) throws IOException {
        Gson gson = new Gson();
        Reader reader = null;
        File file = new File(path);
        InputStream stream = new FileInputStream(file);
        reader = new BufferedReader(new InputStreamReader(stream), 8092);
        JsonReader jreader = new JsonReader(reader);

        try {
            List<Card> data = gson.fromJson(jreader, REVIEW_TYPE);
            for (Card c : data) {
                Log.d("Current Card", c.toString());
                if (c.getAll_parts() != null) {
                    List<Long> partids = new ArrayList<>();
                    List<Card.All_partsEntity> part;
                    part = c.getAll_parts();
                    for (int i = 0; i < part.size(); i++) {
                        Card.All_partsEntity partAux = part.get(i);
                        partids.add(saveParts(partAux));
                    }
                    c.setAll_parts_ids(partids);
                }
                if (c.getCard_faces() != null) {
                    List<Long> faceids = new ArrayList<>();
                    List<Card.Card_facesEntity> face;
                    face = c.getCard_faces();
                    for (int i = 0; i < face.size(); i++) {
                        Card.Card_facesEntity faceAux = face.get(i);
                        faceids.add(saveFaces(faceAux));
                        //saveFaces(faceAux);
                    }
                    c.setCard_faces_ids(faceids);
                    Log.d("Insertando", c.getName());
                }
                saveCard(c);
            }
        } catch (Exception ex) {
            Log.d("ERRRORRRR", ex.getMessage());
        }
    }
}



