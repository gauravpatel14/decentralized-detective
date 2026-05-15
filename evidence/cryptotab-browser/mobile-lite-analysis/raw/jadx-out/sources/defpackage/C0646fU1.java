package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: fU1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0646fU1 implements lE0, Serializable {
    public RC0 t;
    public volatile Object u = C0797hj2.a;
    public final Object v = this;

    /* JADX WARN: Multi-variable type inference failed */
    public C0646fU1(InterfaceC0798hk0 interfaceC0798hk0) {
        this.t = (RC0) interfaceC0798hk0;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [RC0, hk0] */
    @Override // defpackage.lE0
    public final Object getValue() {
        Object objC;
        Object obj = this.u;
        C0797hj2 c0797hj2 = C0797hj2.a;
        if (obj != c0797hj2) {
            return obj;
        }
        synchronized (this.v) {
            objC = this.u;
            if (objC == c0797hj2) {
                objC = this.t.c();
                this.u = objC;
                this.t = null;
            }
        }
        return objC;
    }

    public final String toString() {
        return this.u != C0797hj2.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
