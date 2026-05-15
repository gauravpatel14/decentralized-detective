package defpackage;

/* JADX INFO: renamed from: sG, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1433sG extends xE1 implements InterfaceC0805hr1 {
    public final Throwable w;

    public C1433sG(Throwable th) {
        this.w = th;
    }

    @Override // defpackage.InterfaceC0805hr1
    public final eT1 b(Object obj) {
        return xx.a;
    }

    @Override // defpackage.PI0
    public final String toString() {
        return "Closed@" + hV.a(this) + '[' + this.w + ']';
    }

    @Override // defpackage.InterfaceC0805hr1
    public final Object e() {
        return this;
    }

    @Override // defpackage.InterfaceC0805hr1
    public final void g() {
    }

    @Override // defpackage.xE1
    public final Object w() {
        return this;
    }
}
