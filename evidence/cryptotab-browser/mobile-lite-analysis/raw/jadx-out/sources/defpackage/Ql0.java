package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ql0 implements InterfaceC1269pO1 {
    public final H62 a;

    public Ql0(H62 h62) {
        this.a = h62;
    }

    @Override // defpackage.InterfaceC1269pO1
    public final boolean a(Exception exc) {
        return false;
    }

    @Override // defpackage.InterfaceC1269pO1
    public final boolean b(C1631vi c1631vi) {
        int i = c1631vi.b;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.a.d(c1631vi.a);
        return true;
    }
}
