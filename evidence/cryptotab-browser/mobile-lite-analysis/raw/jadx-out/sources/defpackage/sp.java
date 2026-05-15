package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class sp implements AutoCloseable {
    public final jH1 t;
    public final ByteBuffer u;

    public sp(jH1 jh1, ByteBuffer byteBuffer) {
        this.t = jh1;
        this.u = byteBuffer;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        jH1 jh1 = this.t;
        if (jh1 != null) {
            jh1.z0(this.u);
        }
    }
}
