package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qI implements Runnable {
    public final /* synthetic */ int t;
    public final /* synthetic */ InterfaceC0988kn1 u;
    public final /* synthetic */ InterfaceC0988kn1 v;

    public /* synthetic */ qI(InterfaceC0988kn1 interfaceC0988kn1, InterfaceC0988kn1 interfaceC0988kn12, int i) {
        this.t = i;
        this.v = interfaceC0988kn1;
        this.u = interfaceC0988kn12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1854zY c1854zY;
        switch (this.t) {
            case 0:
                z51 z51Var = (z51) this.v;
                InterfaceC0988kn1 interfaceC0988kn1 = this.u;
                if (z51Var.b != z51.d) {
                    throw new IllegalStateException("provide() can be called only once.");
                }
                synchronized (z51Var) {
                    c1854zY = z51Var.a;
                    z51Var.a = null;
                    z51Var.b = interfaceC0988kn1;
                    break;
                }
                c1854zY.getClass();
                return;
            default:
                C1487tE0 c1487tE0 = (C1487tE0) this.v;
                InterfaceC0988kn1 interfaceC0988kn12 = this.u;
                synchronized (c1487tE0) {
                    try {
                        if (c1487tE0.b == null) {
                            c1487tE0.a.add(interfaceC0988kn12);
                        } else {
                            c1487tE0.b.add(interfaceC0988kn12.get());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
