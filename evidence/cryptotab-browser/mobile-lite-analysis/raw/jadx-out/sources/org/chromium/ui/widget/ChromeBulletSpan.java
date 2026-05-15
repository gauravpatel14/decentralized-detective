package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.BulletSpan;
import defpackage.Hp1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeBulletSpan extends BulletSpan {
    public final int t;

    public ChromeBulletSpan(Context context) {
        super(context.getResources().getDimensionPixelSize(Hp1.chrome_bullet_gap));
        this.t = context.getResources().getDimensionPixelSize(Hp1.chrome_bullet_leading_offset);
    }

    @Override // android.text.style.BulletSpan, android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        super.drawLeadingMargin(canvas, paint, i + this.t, i2, i3, i4, i5, charSequence, i6, i7, z, layout);
    }
}
