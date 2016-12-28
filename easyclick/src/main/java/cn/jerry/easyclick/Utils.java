package cn.jerry.easyclick;

import android.graphics.Rect;
import android.view.View;

import java.util.Locale;

/**
 * Created by jerry on 12/28/16.
 */

class Utils {

    public static String genKey(View view) {
        Rect outRect = new Rect();
        view.getHitRect(outRect);
        return String.format(Locale.UK, "l%s-t%s-r%s-b%s-i%s", outRect.left, outRect.top, outRect.right, outRect.bottom, view.getId());
    }
}
