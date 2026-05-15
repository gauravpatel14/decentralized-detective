package defpackage;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ig1 implements ComponentCallbacks {
    public final /* synthetic */ jg1 t;

    public ig1(jg1 jg1Var) {
        this.t = jg1Var;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.t.e();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }
}
