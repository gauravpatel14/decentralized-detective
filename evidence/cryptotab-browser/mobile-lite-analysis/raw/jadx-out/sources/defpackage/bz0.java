package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bz0 implements InterfaceC1527tn0 {
    public final FS0 t;

    public bz0(FS0 fs0) {
        this.t = fs0;
    }

    @Override // defpackage.InterfaceC1527tn0
    public final FS0 F1() {
        return this.t.n1();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.t.close();
    }
}
