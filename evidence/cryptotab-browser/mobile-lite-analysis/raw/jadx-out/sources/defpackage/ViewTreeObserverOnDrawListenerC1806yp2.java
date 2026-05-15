package defpackage;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: yp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnDrawListenerC1806yp2 implements ViewTreeObserver.OnDrawListener {
    public final /* synthetic */ AbstractC1868zp2 t;

    public ViewTreeObserverOnDrawListenerC1806yp2(AbstractC1868zp2 abstractC1868zp2) {
        this.t = abstractC1868zp2;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        C1755xp2 c1755xp2;
        AbstractC1868zp2 abstractC1868zp2 = this.t;
        if (!abstractC1868zp2.B || abstractC1868zp2.z == null || (c1755xp2 = abstractC1868zp2.y) == null) {
            return;
        }
        abstractC1868zp2.B = false;
        c1755xp2.g(null);
    }
}
