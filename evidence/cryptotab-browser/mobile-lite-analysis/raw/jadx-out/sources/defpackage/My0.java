package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class My0 implements LS0 {
    public final CoreImpl t;
    public final Ny0 u;

    public My0(CoreImpl coreImpl, Ny0 ny0) {
        this.t = coreImpl;
        this.u = ny0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.u.close();
    }
}
