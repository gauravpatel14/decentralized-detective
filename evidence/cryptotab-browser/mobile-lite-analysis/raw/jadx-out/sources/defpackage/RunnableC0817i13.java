package defpackage;

import android.util.Log;

/* JADX INFO: renamed from: i13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0817i13 implements Runnable {
    public final /* synthetic */ NM1 t;

    public RunnableC0817i13(NM1 nm1) {
        this.t = nm1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.t.a.b();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
