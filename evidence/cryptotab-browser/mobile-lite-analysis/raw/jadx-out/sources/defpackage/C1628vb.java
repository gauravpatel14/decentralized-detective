package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: renamed from: vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1628vb extends RatingBar {
    public final C1521tb t;

    /* JADX WARN: Illegal instructions before constructor call */
    public C1628vb(Context context, AttributeSet attributeSet) {
        int i = Ep1.ratingBarStyle;
        super(context, attributeSet, i);
        Q82.a(getContext(), this);
        C1521tb c1521tb = new C1521tb(this);
        this.t = c1521tb;
        c1521tb.a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.t.b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
