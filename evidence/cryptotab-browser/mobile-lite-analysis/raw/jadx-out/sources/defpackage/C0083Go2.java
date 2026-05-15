package defpackage;

/* JADX INFO: renamed from: Go2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0083Go2 {
    public final C0094Ho2 a;
    public final InterfaceC0048Do2 b;
    public final FO c;
    public final C0711gU1 d = new C0711gU1();

    public C0083Go2(C0094Ho2 c0094Ho2, InterfaceC0048Do2 interfaceC0048Do2, FO fo) {
        this.a = c0094Ho2;
        this.b = interfaceC0048Do2;
        this.c = fo;
    }

    public final AbstractC1867zo2 a(iF iFVar, String str) {
        AbstractC1867zo2 abstractC1867zo2;
        AbstractC1867zo2 abstractC1867zo2A;
        wz1 wz1Var;
        AbstractC0514dF0 abstractC0514dF0;
        synchronized (this.d) {
            try {
                abstractC1867zo2 = (AbstractC1867zo2) this.a.a.get(str);
                if (iFVar.c(abstractC1867zo2)) {
                    InterfaceC0048Do2 interfaceC0048Do2 = this.b;
                    if ((interfaceC0048Do2 instanceof wz1) && (abstractC0514dF0 = (wz1Var = (wz1) interfaceC0048Do2).d) != null) {
                        BE0.a(abstractC1867zo2, wz1Var.e, abstractC0514dF0);
                    }
                } else {
                    C0533dW0 c0533dW0 = new C0533dW0(this.c);
                    c0533dW0.a(AbstractC0070Fo2.a, str);
                    InterfaceC0048Do2 interfaceC0048Do22 = this.b;
                    try {
                        try {
                            abstractC1867zo2A = interfaceC0048Do22.c(iFVar, c0533dW0);
                        } catch (AbstractMethodError unused) {
                            abstractC1867zo2A = interfaceC0048Do22.b(iFVar.a(), c0533dW0);
                        }
                    } catch (AbstractMethodError unused2) {
                        abstractC1867zo2A = interfaceC0048Do22.a(iFVar.a());
                    }
                    abstractC1867zo2 = abstractC1867zo2A;
                    AbstractC1867zo2 abstractC1867zo22 = (AbstractC1867zo2) this.a.a.put(str, abstractC1867zo2);
                    if (abstractC1867zo22 != null) {
                        abstractC1867zo22.a();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC1867zo2;
    }
}
