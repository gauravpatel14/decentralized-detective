package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YH2 implements Runnable {
    public final /* synthetic */ long t;
    public final /* synthetic */ AK2 u;

    public YH2(AK2 ak2, long j) {
        this.u = ak2;
        this.t = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.u.m(this.t);
    }
}
