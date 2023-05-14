package model;

import java.util.Calendar;

public class Premium extends Users {
    private static final int MAX_BOOKS = Integer.MAX_VALUE;
    private static final int MAX_MAGAZINES = Integer.MAX_VALUE;
    private static final boolean HAS_ADS = false;

    public Premium(String nameUser, String id, Calendar dateVinculation) {
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