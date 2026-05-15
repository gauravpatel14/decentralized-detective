package defpackage;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Xl {
    public static int a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{Ep1.actionBarSize});
        int iRound = Math.round(typedArrayObtainStyledAttributes.getDimension(0, 0.0f));
        typedArrayObtainStyledAttributes.recycle();
        return (int) ((iRound / o00.a(context).d) + 0.5f);
    }

    public static int b(Context context) {
        return c(context) ? AbstractC0189Pp1.automotive_layout_with_vertical_back_button_toolbar : AbstractC0189Pp1.automotive_layout_with_horizontal_back_button_toolbar;
    }

    public static boolean c(Context context) {
        return C1296pv.a().a && context.getResources().getConfiguration().orientation == 2;
    }
}
