package defpackage;

import J.N;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.impl.WatcherImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class hK implements KS0, InterfaceC1527tn0 {
    public final gK t = new gK(this);
    public final FS0 u;
    public final WatcherImpl v;
    public ex1 w;
    public DJ x;

    public hK(FS0 fs0, WatcherImpl watcherImpl) {
        this.u = fs0;
        this.v = watcherImpl;
    }

    public static ResultAnd a(FS0 fs0, ex1 ex1Var) {
        CS0 cs0 = CS0.c;
        ResultAnd resultAndL0 = fs0.l0();
        int i = resultAndL0.a;
        if (i != 0) {
            return new ResultAnd(i, Boolean.FALSE);
        }
        DS0 ds0 = (DS0) resultAndL0.b;
        if (ex1Var == null) {
            return new ResultAnd(i, Boolean.FALSE);
        }
        return new ResultAnd(resultAndL0.a, Boolean.valueOf(ex1Var.g(new ER0(ByteBuffer.wrap(ds0.a), ds0.c))));
    }

    @Override // defpackage.InterfaceC1527tn0
    public final FS0 F1() {
        WatcherImpl watcherImpl = this.v;
        long j = watcherImpl.a;
        if (j != 0) {
            watcherImpl.b = null;
            N._V_JO(275, j, watcherImpl);
        }
        long j2 = watcherImpl.a;
        if (j2 != 0) {
            N._V_JO(276, j2, watcherImpl);
            watcherImpl.a = 0L;
        }
        FS0 fs0N1 = this.u.n1();
        ex1 ex1Var = this.w;
        if (ex1Var != null) {
            ex1Var.close();
        }
        return fs0N1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        WatcherImpl watcherImpl = this.v;
        long j = watcherImpl.a;
        if (j != 0) {
            watcherImpl.b = null;
            N._V_JO(275, j, watcherImpl);
        }
        long j2 = watcherImpl.a;
        if (j2 != 0) {
            N._V_JO(276, j2, watcherImpl);
            watcherImpl.a = 0L;
        }
        this.u.close();
        ex1 ex1Var = this.w;
        if (ex1Var != null) {
            this.w = null;
            ex1Var.close();
        }
    }

    @Override // defpackage.KS0
    public final boolean g(ER0 er0) throws IOException {
        try {
            FS0 fs0 = this.u;
            ByteBuffer byteBuffer = er0.a;
            ArrayList arrayList = er0.b;
            ES0 es0 = ES0.c;
            fs0.g0(byteBuffer, arrayList);
            return true;
        } catch (MojoException e) {
            close();
            DJ dj = this.x;
            if (dj == null) {
                return false;
            }
            dj.d(e);
            return false;
        }
    }
}
