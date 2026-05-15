package defpackage;

/* JADX INFO: renamed from: o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1183o extends np {
    public final C1059m t;
    public final /* synthetic */ AbstractC1302q u;

    public C1183o(C1059m c1059m, AbstractC1302q abstractC1302q) {
        this.u = abstractC1302q;
        this.t = c1059m;
    }

    @Override // defpackage.AbstractC1474sx
    public final void a(Throwable th) {
        if (this.t.t()) {
            this.u.getClass();
        }
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        a((Throwable) obj);
        return C0302Yj2.a;
    }

    public final String toString() {
        return "RemoveReceiveOnCancel[" + this.t + ']';
    }
}
