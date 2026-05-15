package defpackage;

import J.N;
import java.nio.ByteBuffer;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RT extends AbstractC1468sn0 implements NT {
    @Override // defpackage.NT
    public final ResultAnd a0(ByteBuffer byteBuffer) {
        QT qt = QT.c;
        CoreImpl coreImpl = this.u;
        coreImpl.getClass();
        ResultAnd resultAnd = (ResultAnd) N._O_IIJOO(0, byteBuffer == null ? 0 : byteBuffer.capacity(), qt.a, this.t, coreImpl, byteBuffer);
        int i = resultAnd.a;
        if (i != 0 && i != 17) {
            throw new MojoException(resultAnd.a);
        }
        if (i == 0 && byteBuffer != null) {
        }
        return resultAnd;
    }
}
