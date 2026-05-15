package defpackage;

import android.graphics.Rect;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp0 extends LayerDrawable {
    public static final /* synthetic */ int t = 0;

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        setLayerInset(0, 0, rect.height() - getDrawable(0).getIntrinsicHeight(), 0, 0);
        super.onBoundsChange(rect);
    }
}
