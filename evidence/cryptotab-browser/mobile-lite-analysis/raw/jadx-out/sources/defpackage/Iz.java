package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Iz implements InterfaceC0558eA {
    public final /* synthetic */ InterfaceC0558eA a;
    public final /* synthetic */ Mz b;

    public Iz(Mz mz, InterfaceC0558eA interfaceC0558eA) {
        this.b = mz;
        this.a = interfaceC0558eA;
    }

    @Override // defpackage.InterfaceC0558eA
    public final void a(C0619fA c0619fA) {
        Mz mz = this.b;
        mz.c.post(new Hz(this, c0619fA, 0));
        mz.c.postDelayed(new Hz(this, c0619fA, 1), 1L);
    }

    @Override // defpackage.InterfaceC0558eA
    public final void b() {
        if (this.a != null) {
            this.b.c.post(new Gz(this));
        }
    }
}
