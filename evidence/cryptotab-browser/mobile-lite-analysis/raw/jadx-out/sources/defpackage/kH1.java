package defpackage;

import J.N;
import java.nio.ByteBuffer;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kH1 extends AbstractC1468sn0 implements jH1 {
    @Override // defpackage.jH1
    public final ByteBuffer x(long j) {
        iH1 ih1 = iH1.c;
        CoreImpl coreImpl = this.u;
        coreImpl.getClass();
        ResultAnd resultAnd = (ResultAnd) N._O_IJJJO(0, ih1.a, this.t, 0L, j, coreImpl);
        if (resultAnd.a == 0) {
            return (ByteBuffer) resultAnd.b;
        }
        throw new MojoException(resultAnd.a);
    }

    @Override // defpackage.jH1
    public final void z0(ByteBuffer byteBuffer) {
        CoreImpl coreImpl = this.u;
        coreImpl.getClass();
        int i_I_OO = N._I_OO(2, coreImpl, byteBuffer);
        if (i_I_OO != 0) {
            throw new MojoException(i_I_OO);
        }
    }
}
