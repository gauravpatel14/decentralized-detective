package defpackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pz0 implements InterfaceC1749xk2, FS0, NT, PT, jH1 {
    public static final pz0 t = new pz0();

    @Override // defpackage.InterfaceC1409rn0
    public final long Q() {
        return 0L;
    }

    @Override // defpackage.NT
    public final ResultAnd a0(ByteBuffer byteBuffer) {
        throw new MojoException(3);
    }

    @Override // defpackage.InterfaceC1409rn0
    public final boolean f() {
        return false;
    }

    @Override // defpackage.InterfaceC1409rn0
    public final CoreImpl f0() {
        return null;
    }

    @Override // defpackage.FS0
    public final void g0(ByteBuffer byteBuffer, ArrayList arrayList) {
        throw new MojoException(3);
    }

    @Override // defpackage.FS0
    public final ResultAnd l0() {
        throw new MojoException(3);
    }

    @Override // defpackage.jH1
    public final ByteBuffer x(long j) {
        throw new MojoException(3);
    }

    @Override // defpackage.jH1
    public final void z0(ByteBuffer byteBuffer) {
        throw new MojoException(3);
    }

    @Override // defpackage.InterfaceC1749xk2
    public final NT O1() {
        return this;
    }

    @Override // defpackage.InterfaceC1749xk2
    public final PT W0() {
        return this;
    }

    @Override // defpackage.InterfaceC1749xk2
    public final FS0 a1() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // defpackage.FS0
    public final FS0 n1() {
        return this;
    }

    @Override // defpackage.InterfaceC1409rn0
    public final InterfaceC1749xk2 s0() {
        return this;
    }

    @Override // defpackage.InterfaceC1749xk2
    public final jH1 w0() {
        return this;
    }
}
