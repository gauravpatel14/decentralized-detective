package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import defpackage.AbstractC0146Mm2;
import defpackage.C1730xO0;
import defpackage.Q51;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayListView extends ListView {
    public final ArrayList t;

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new ArrayList();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        boolean z;
        super.onDraw(canvas);
        ArrayList arrayList = this.t;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Q51 q51 = (Q51) it.next();
                BitmapDrawable bitmapDrawable = q51.a;
                if (bitmapDrawable != null) {
                    bitmapDrawable.draw(canvas);
                }
                long drawingTime = getDrawingTime();
                if (q51.k) {
                    z = false;
                } else {
                    float fMax = q51.j ? Math.max(0.0f, Math.min(1.0f, (drawingTime - q51.i) / q51.e)) : 0.0f;
                    Interpolator interpolator = q51.d;
                    float interpolation = interpolator == null ? fMax : interpolator.getInterpolation(fMax);
                    int i = (int) (q51.g * interpolation);
                    Rect rect = q51.f;
                    int i2 = rect.top + i;
                    Rect rect2 = q51.c;
                    rect2.top = i2;
                    rect2.bottom = rect.bottom + i;
                    float fA = AbstractC0146Mm2.a(q51.h, 1.0f, interpolation, 1.0f);
                    q51.b = fA;
                    BitmapDrawable bitmapDrawable2 = q51.a;
                    if (bitmapDrawable2 != null) {
                        bitmapDrawable2.setAlpha((int) (fA * 255.0f));
                        bitmapDrawable2.setBounds(rect2);
                    }
                    if (q51.j && fMax >= 1.0f) {
                        q51.k = true;
                        C1730xO0 c1730xO0 = q51.l;
                        if (c1730xO0 != null) {
                            d dVar = c1730xO0.b;
                            dVar.c0.remove(c1730xO0.a);
                            dVar.Y.notifyDataSetChanged();
                        }
                    }
                    z = !q51.k;
                }
                if (!z) {
                    it.remove();
                }
            }
        }
    }
}
