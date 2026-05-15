package defpackage;

import J.N;
import android.util.Log;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: renamed from: sn0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1468sn0 implements InterfaceC1409rn0 {
    public long t;
    public final CoreImpl u;

    public AbstractC1468sn0(CoreImpl coreImpl, long j) {
        this.u = coreImpl;
        this.t = j;
    }

    @Override // defpackage.InterfaceC1409rn0
    public final long Q() {
        long j = this.t;
        this.t = 0L;
        return j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j = this.t;
        if (j != 0) {
            this.t = 0L;
            CoreImpl coreImpl = this.u;
            coreImpl.getClass();
            int i_I_JO = N._I_JO(13, j, coreImpl);
            if (i_I_JO != 0) {
                throw new MojoException(i_I_JO);
            }
        }
    }

    @Override // defpackage.InterfaceC1409rn0
    public final boolean f() {
        return this.t != 0;
    }

    @Override // defpackage.InterfaceC1409rn0
    public final CoreImpl f0() {
        return this.u;
    }

    public final void finalize() throws Throwable {
        if (f()) {
            Log.w("cr_HandleImpl", "Handle was not closed.");
            long j = this.t;
            CoreImpl coreImpl = this.u;
            coreImpl.getClass();
            N._I_JO(13, j, coreImpl);
        }
        super.finalize();
    }

    @Override // defpackage.InterfaceC1409rn0
    public final InterfaceC1749xk2 s0() {
        return new C1801yk2(this);
    }

    public AbstractC1468sn0(AbstractC1468sn0 abstractC1468sn0) {
        this.u = abstractC1468sn0.u;
        long j = abstractC1468sn0.t;
        abstractC1468sn0.t = 0L;
        this.t = j;
    }
}
