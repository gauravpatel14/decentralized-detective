package defpackage;

import android.view.View;

/* JADX INFO: renamed from: v40, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnLayoutChangeListenerC1594v40 implements View.OnLayoutChangeListener {
    public final /* synthetic */ C1711x40 t;

    public ViewOnLayoutChangeListenerC1594v40(C1711x40 c1711x40) {
        this.t = c1711x40;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        C1711x40 c1711x40 = this.t;
        if (view == c1711x40.u) {
            c1711x40.b();
        }
    }
}
