package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Yt1 extends np {
    public final kW0 t;

    public Yt1(kW0 kw0) {
        this.t = kw0;
    }

    @Override // defpackage.AbstractC1474sx
    public final void a(Throwable th) {
        this.t.t();
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        a((Throwable) obj);
        return C0302Yj2.a;
    }

    public final String toString() {
        return "RemoveOnCancel[" + this.t + ']';
    }
}
