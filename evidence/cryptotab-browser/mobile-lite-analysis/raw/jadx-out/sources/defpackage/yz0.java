package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class yz0 extends AbstractC1474sx {
    public final InterfaceC0926jk0 t;

    public yz0(InterfaceC0926jk0 interfaceC0926jk0) {
        this.t = interfaceC0926jk0;
    }

    @Override // defpackage.AbstractC1474sx
    public final void a(Throwable th) {
        this.t.j(th);
    }

    @Override // defpackage.InterfaceC0926jk0
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        a((Throwable) obj);
        return C0302Yj2.a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.t.getClass().getSimpleName() + '@' + hV.a(this) + ']';
    }
}
