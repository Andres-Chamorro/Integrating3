package model;

import java.util.Calendar;

public class Regular extends Users {
    private static final int MAX_BOOKS = 5;
    private static final int MAX_MAGAZINES = 2;
    private static final boolean HAS_ADS = true;

    public Regular(String nameUser, String id, Calendar dateVinculation) {
        super(nameUser, id, dateVinculation);
    }

    public int getMaxBooks() {
        return MAX_BOOKS;
    }

    public int getMaxMagazines() {
        return MAX_MAGAZINES;
    }

    public boolean hasAds() {
        return HAS_ADS;
    }
}
