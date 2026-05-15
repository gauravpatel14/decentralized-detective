package defpackage;

/* JADX INFO: renamed from: y3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1765y3 implements SQ0 {
    public final /* synthetic */ C3 t;

    public /* synthetic */ C1765y3(C3 c3) {
        this.t = c3;
    }

    @Override // defpackage.SQ0
    public void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        if (menuC0775hQ0 instanceof SubMenuC1273pR1) {
            ((SubMenuC1273pR1) menuC0775hQ0).z.k().c(false);
        }
        SQ0 sq0 = this.t.x;
        if (sq0 != null) {
            sq0.b(menuC0775hQ0, z);
        }
    }

    @Override // defpackage.SQ0
    public boolean d(MenuC0775hQ0 menuC0775hQ0) {
        C3 c3 = this.t;
        if (menuC0775hQ0 == c3.v) {
            return false;
        }
        ((SubMenuC1273pR1) menuC0775hQ0).A.getClass();
        c3.getClass();
        SQ0 sq0 = c3.x;
        if (sq0 != null) {
            return sq0.d(menuC0775hQ0);
        }
        return false;
    }
}
