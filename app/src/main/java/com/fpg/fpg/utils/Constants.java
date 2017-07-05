package com.fpg.fpg.utils;

/**
 * Created by jhovany on 5/04/17.
 */

public class Constants {

    public static class GoogleDrive {
        public static final String DRIVE_IMAGE_ROUTE = "http://drive.google.com/uc?export=view&id=";
    }

    public static class TypeFonts {
        public static final String ROBOTO_BOLD = "Font/Roboto/Roboto-Bold.ttf";
        public static final String ROBOTO_MEDIUM = "Font/Roboto/Roboto-Medium.ttf";
        public static final String ROBOTO_LIGHT = "Font/Roboto/Roboto-Light.ttf";
        public static final String OPENSANS_REGULAR = "Font/OpenSans/OpenSans-Regular.ttf";
        public static final String DOSIS_BOLD = "Font/Dosis/Dosis-Bold.ttf";
        public static final String DOSIS_MEDIUM = "Font/Dosis/Dosis-Medium.ttf";
    }

    public static class ConstanTypeFont {
        public static final String ROBOTO_BOLD = "ROBOTO_BOLD";
        public static final String ROBOTO_MEDIUM = "ROBOTO_MEDIUM";
        public static final String ROBOTO_LIGHT = "ROBOTO_LIGHT";
        public static final String OPENSANS_REGULAR = "OPENSANS_REGULAR";
        public static final String DOSIS_BOLD = "DOSIS_BOLD";
        public static final String DOSIS_MEDIUM = "DOSIS_MEDIUM";
    }


    public static class Host {
        //public static final String HOME_PATH = "http://tes000development.000webhostapp.com";
        //public static final String HOME_SCRIPTS = "/scripts";
        public static final String HOME_PATH = "https://raw.githubusercontent.com";
        public static final String HOME_SCRIPTS = "/JhovanyOlvera/000/develop/scripts";

    }

    public static class Section {
        public static final String ONBOARGING = "/onboarding";
        public static final String CARD = "/card";
        public static final String NEWS = "/news";
        public static final String DATE = "/date";
        public static final String GROUP_NEWS = "/groupNews";
    }

    public static class Script {
        public static final String JSON_ONBOARDING = "/onBoarding.json";
        public static final String JSON_TYPE_CARD = "/typeCard.json";
        public static final String JSON_DATE_NEWS = "/dateNews.json";
        public static final String JSON_GROUP_NEWS = "/groupNews.json";
        public static final String JSON_NEWS = "/news.json";
    }

    public static class Group {
        public static final String GROUP_NEWS = "Grupo de noticia";
    }

    public static class FirebaseCatalog {
        public static final String FIREBASE_CATALOG_DATE_NEWS = "catalog/dateNews";
        public static final String FIREBASE_CATALOG_ON_BOARDING = "onboarding/items";
        public static final String FIREBASE_CATALOG_TYPE_CARD = "catalog/typeCard";
        public static final String FIREBASE_CATALOG_GROUP_NEWS = "catalog/groupNews";
        public static final String FIREBASE_CATALOG_NEWS = "catalog/news";

    }
}
