package defpackage;

import com.google.android.gms.common.api.internal.zabq;

/* JADX INFO: renamed from: nz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1182nz2 implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ zabq u;

    public RunnableC1182nz2(zabq zabqVar, int i) {
        this.u = zabqVar;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.zaI(this.t);
    }
}
