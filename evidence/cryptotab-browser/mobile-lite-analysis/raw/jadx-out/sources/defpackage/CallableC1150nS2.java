package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: nS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC1150nS2 implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ MS2 b;

    public CallableC1150nS2(MS2 ms2, String str) {
        this.b = ms2;
        this.a = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MS2 ms2 = this.b;
        ms2.t.a();
        C0513dE2 c0513dE2 = ms2.t.c;
        QX2.H(c0513dE2);
        return c0513dE2.I(this.a);
    }
}
