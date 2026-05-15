package defpackage;

import android.util.Log;

/* JADX INFO: renamed from: rw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1414rw extends AbstractC1103mg {
    public final /* synthetic */ C1472sw h;

    public C1414rw(C1472sw c1472sw) {
        this.h = c1472sw;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        try {
            C1472sw.a(this.h);
            return null;
        } catch (Exception e) {
            Log.e("cr_Flags", "Exception writing safe values.", e);
            a(true);
            return null;
        }
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        Gr1.h(this.h.a.get(), 5, "Variations.SafeModeCachedFlags.Cached");
    }
}
