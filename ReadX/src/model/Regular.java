package model;

import java.util.Calendar;

public class Regular extends Users {
    private int cantMaxBooks;
    private int cantMaxMagazine;
    private static final boolean HAS_ADS = true;

    public Regular(String nameUser, String id, Calendar dateVinculation) {
        super(nameUser, id, dateVinculation);
        this.cantMaxBooks = 5;
        this.cantMaxMagazine = 2;
    }

    public int getMaxBooks() {
        return cantMaxBooks;
    }

    public int getMaxMagazines() {
        return cantMaxMagazine;
    }

    public boolean hasAds() {
        return HAS_ADS;
    }
}
