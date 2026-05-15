package defpackage;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: renamed from: cQ0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0470cQ0 implements ComponentCallbacks2 {
    public final String t;

    public ComponentCallbacks2C0470cQ0(String str) {
        this.t = "Android.MemoryPressureNotification.".concat(str);
    }

    public final void a(int i) {
        Gr1.h(i, 9, this.t);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        a(8);
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 5) {
            a(7);
            return;
        }
        if (i == 10) {
            a(6);
            return;
        }
        if (i == 15) {
            a(5);
            return;
        }
        if (i == 20) {
            a(4);
            return;
        }
        if (i == 40) {
            a(3);
            return;
        }
        if (i == 60) {
            a(2);
        } else if (i != 80) {
            a(0);
        } else {
            a(1);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
