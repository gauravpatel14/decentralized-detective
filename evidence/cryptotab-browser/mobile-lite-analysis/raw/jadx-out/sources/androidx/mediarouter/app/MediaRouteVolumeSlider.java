package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.C1744xb;
import defpackage.Ep1;
import defpackage.oP0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
class MediaRouteVolumeSlider extends C1744xb {
    public final float u;
    public boolean v;
    public Drawable w;
    public int x;
    public int y;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, Ep1.seekBarStyle);
        this.u = oP0.d(context);
    }

    public final void a(int i, int i2) {
        if (this.x != i) {
            if (Color.alpha(i) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i));
            }
            this.x = i;
        }
        if (this.y != i2) {
            if (Color.alpha(i2) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i2));
            }
            this.y = i2;
        }
    }

    public final void b(boolean z) {
        if (this.v == z) {
            return;
        }
        this.v = z;
        super.setThumb(z ? null : this.w);
    }

    @Override // defpackage.C1744xb, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int i = isEnabled() ? 255 : (int) (this.u * 255.0f);
        Drawable drawable = this.w;
        int i2 = this.x;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        drawable.setColorFilter(i2, mode);
        this.w.setAlpha(i);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
            layerDrawable.findDrawableByLayerId(R.id.background).setColorFilter(this.y, mode);
            progressDrawable = drawableFindDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.x, mode);
        progressDrawable.setAlpha(i);
    }

    @Override // android.widget.AbsSeekBar
    public final void setThumb(Drawable drawable) {
        this.w = drawable;
        if (this.v) {
            drawable = null;
        }
        super.setThumb(drawable);
    }
}
