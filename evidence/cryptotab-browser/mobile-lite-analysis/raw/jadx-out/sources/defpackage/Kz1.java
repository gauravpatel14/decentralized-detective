package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Kz1 extends u implements qO {
    public final yN v;

    public Kz1(InterfaceC0577eO interfaceC0577eO, yN yNVar) {
        super(interfaceC0577eO, true);
        this.v = yNVar;
    }

    @Override // defpackage.YA0
    public final boolean C() {
        return true;
    }

    @Override // defpackage.qO
    public final qO b() {
        yN yNVar = this.v;
        if (yNVar != null) {
            return yNVar;
        }
        return null;
    }

    @Override // defpackage.YA0
    public void e(Object obj) {
        AbstractC0554e00.a(oz0.b(this.v), QH.a(obj), null);
    }

    @Override // defpackage.YA0
    public void f(Object obj) {
        this.v.d(QH.a(obj));
    }
}
