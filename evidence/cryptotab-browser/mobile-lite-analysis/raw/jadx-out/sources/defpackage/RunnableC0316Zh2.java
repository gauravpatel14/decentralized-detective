package defpackage;

import android.net.Uri;

/* JADX INFO: renamed from: Zh2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0316Zh2 implements Runnable {
    public final /* synthetic */ C0432bi2 t;
    public final /* synthetic */ Uri u;

    public /* synthetic */ RunnableC0316Zh2(C0432bi2 c0432bi2, Uri uri) {
        this.t = c0432bi2;
        this.u = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.b.remove(this.u);
    }
}
