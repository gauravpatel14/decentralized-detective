package defpackage;

import J.N;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;

/* JADX INFO: renamed from: aQ0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0352aQ0 implements ComponentCallbacks2 {
    public final /* synthetic */ C0410bQ0 t;

    public ComponentCallbacks2C0352aQ0(C0410bQ0 c0410bQ0) {
        this.t = c0410bQ0;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        C0410bQ0 c0410bQ0 = this.t;
        if (c0410bQ0.c) {
            c0410bQ0.b = 2;
        } else {
            c0410bQ0.c(2);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        Integer numA = C0410bQ0.a(i);
        if (numA != null) {
            int iIntValue = numA.intValue();
            C0410bQ0 c0410bQ0 = this.t;
            if (c0410bQ0.c) {
                c0410bQ0.b = numA;
            } else {
                c0410bQ0.c(iIntValue);
            }
        }
        if (i == 40 && Build.VERSION.SDK_INT >= 34 && OE0.h.d()) {
            N._V(1);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
