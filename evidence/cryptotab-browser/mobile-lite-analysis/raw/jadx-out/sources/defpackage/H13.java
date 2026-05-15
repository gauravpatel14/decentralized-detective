package defpackage;

import android.util.Log;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H13 implements Runnable {
    public final /* synthetic */ HashSet t;
    public final /* synthetic */ NM1 u;

    public H13(NM1 nm1, HashSet hashSet) {
        this.u = nm1;
        this.t = hashSet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.u.a(this.t);
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
