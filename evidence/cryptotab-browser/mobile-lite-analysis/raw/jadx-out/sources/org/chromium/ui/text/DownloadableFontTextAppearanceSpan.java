package org.chromium.ui.text;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import defpackage.AbstractC0305Yp1;
import defpackage.kv1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class DownloadableFontTextAppearanceSpan extends TextAppearanceSpan {
    public final Typeface t;

    public DownloadableFontTextAppearanceSpan(int i, Context context) {
        Typeface typefaceB;
        super(context, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, AbstractC0305Yp1.TextAppearance);
        try {
            typefaceB = kv1.b(typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.TextAppearance_android_fontFamily, 0), context);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            typefaceB = null;
        }
        this.t = typefaceB;
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.text.style.TextAppearanceSpan, android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        super.updateMeasureState(textPaint);
        Typeface typeface = this.t;
        if (typeface == null) {
            return;
        }
        textPaint.setTypeface(Typeface.create(typeface, textPaint.getTypeface().getStyle()));
    }
}
