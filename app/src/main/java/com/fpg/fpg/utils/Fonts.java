package com.fpg.fpg.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by jhovany on 6/04/17.
 */

public class Fonts {

    public static Typeface getFontRoboto(Context context, String font) {

        switch (font) {
            case Constants.ConstanTypeFont.ROBOTO_BOLD:
                return Typeface.createFromAsset(context.getAssets(), Constants.TypeFonts.ROBOTO_BOLD);

            case Constants.ConstanTypeFont.DOSIS_BOLD:
                return Typeface.createFromAsset(context.getAssets(), Constants.TypeFonts.DOSIS_BOLD);

            case Constants.ConstanTypeFont.DOSIS_MEDIUM:
                return Typeface.createFromAsset(context.getAssets(), Constants.TypeFonts.DOSIS_MEDIUM);

            default:
                return null;
        }
    }


}
