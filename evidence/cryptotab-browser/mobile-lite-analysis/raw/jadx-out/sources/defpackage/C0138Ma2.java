package defpackage;

/* JADX INFO: renamed from: Ma2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0138Ma2 implements InterfaceC0099Ia2 {
    public final C0125La2 a;

    public C0138Ma2(RunnableC0089Ha2 runnableC0089Ha2) {
        this.a = new C0125La2(runnableC0089Ha2);
    }

    @Override // defpackage.InterfaceC0099Ia2
    public final void b(C0064Fa2 c0064Fa2) {
        c0064Fa2.a.addCallback(this.a);
    }

    @Override // defpackage.InterfaceC0099Ia2
    public final void a() {
    }
}
