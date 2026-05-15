package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MR2 implements Callable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ MS2 d;

    public MR2(MS2 ms2, String str, String str2, String str3) {
        this.d = ms2;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MS2 ms2 = this.d;
        ms2.t.a();
        C0513dE2 c0513dE2 = ms2.t.c;
        QX2.H(c0513dE2);
        return c0513dE2.G(this.a, this.b, this.c);
    }
}
