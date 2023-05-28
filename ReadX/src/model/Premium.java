package model;

import java.util.Calendar;

public class Premium extends Users {
    private static final boolean HAS_ADS = false;

    public Premium(String nameUser, String id, Calendar dateVinculation) {
        super(nameUser, id, dateVinculation);
    }

    public boolean hasAds() {
        return HAS_ADS;
    }

}