package defpackage;

import android.graphics.Canvas;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class S30 extends K30 {
    public boolean u;

    @Override // defpackage.K30, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.u) {
            super.draw(canvas);
        }
    }

    @Override // defpackage.K30, android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        if (this.u) {
            super.setHotspot(f, f2);
        }
    }

    @Override // defpackage.K30, android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.u) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // defpackage.K30, android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (this.u) {
            return this.t.setState(iArr);
        }
        return false;
    }

    @Override // defpackage.K30, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        if (this.u) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
