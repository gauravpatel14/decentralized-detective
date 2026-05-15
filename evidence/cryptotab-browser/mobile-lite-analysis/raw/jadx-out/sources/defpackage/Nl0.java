package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Nl0 implements InterfaceC1269pO1 {
    public final Km2 a;
    public final H62 b;

    public Nl0(Km2 km2, H62 h62) {
        this.a = km2;
        this.b = h62;
    }

    @Override // defpackage.InterfaceC1269pO1
    public final boolean a(Exception exc) {
        this.b.c(exc);
        return true;
    }

    @Override // defpackage.InterfaceC1269pO1
    public final boolean b(C1631vi c1631vi) {
        if (c1631vi.b != 4 || this.a.a(c1631vi)) {
            return false;
        }
        String str = c1631vi.c;
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.b.b(new C1462si(str, c1631vi.e, c1631vi.f));
        return true;
    }
}
