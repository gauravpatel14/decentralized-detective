package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class jz1 implements InterfaceC0564eF0, Closeable {
    public final String t;
    public final hz1 u;
    public boolean v;

    public jz1(String str, hz1 hz1Var) {
        this.t = str;
        this.u = hz1Var;
    }

    @Override // defpackage.InterfaceC0564eF0
    public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
        if (bf0 == bF0.ON_DESTROY) {
            this.v = false;
            interfaceC0762hF0.getLifecycle().b(this);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
