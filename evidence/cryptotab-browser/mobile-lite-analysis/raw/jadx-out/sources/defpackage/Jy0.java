package defpackage;

import java.io.Closeable;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jy0 implements DJ, Closeable {
    public final CoreImpl t;
    public final LS0 u;
    public int v;

    public Jy0(CoreImpl coreImpl, LS0 ls0) {
        this.t = coreImpl;
        this.u = ls0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.u.close();
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
    }
}
