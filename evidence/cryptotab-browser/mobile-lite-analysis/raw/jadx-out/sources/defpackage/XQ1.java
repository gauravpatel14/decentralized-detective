package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class XQ1 {
    public static void a(Context context, TextPaint textPaint, int i, boolean z) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, AbstractC0305Yp1.TextAppearance);
        int i2 = AbstractC0305Yp1.TextAppearance_android_fontFamily;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, -1);
        textPaint.setTypeface(resourceId != -1 ? kv1.b(resourceId, context) : Typeface.create(typedArrayObtainStyledAttributes.getString(i2), 0));
        textPaint.setTextSize(typedArrayObtainStyledAttributes.getDimension(AbstractC0305Yp1.TextAppearance_android_textSize, -1.0f));
        if (z) {
            textPaint.setColor(typedArrayObtainStyledAttributes.getColor(AbstractC0305Yp1.TextAppearance_android_textColor, -1));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
