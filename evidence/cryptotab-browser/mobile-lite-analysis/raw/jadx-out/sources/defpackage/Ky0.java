package defpackage;

import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ky0 implements Ny0 {
    public final Jy0 t;

    public Ky0(CoreImpl coreImpl, LS0 ls0) {
        this.t = new Jy0(coreImpl, ls0);
    }

    public abstract Jy0 a();

    @Override // defpackage.Ny0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.t.close();
    }

    @Override // defpackage.DJ
    public final void d(MojoException mojoException) {
    }
}
