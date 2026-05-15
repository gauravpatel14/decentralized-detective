package defpackage;

import J.N;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GS0 extends AbstractC1468sn0 implements FS0 {
    @Override // defpackage.FS0
    public final void g0(ByteBuffer byteBuffer, ArrayList arrayList) {
        ByteBuffer byteBuffer2;
        ES0 es0 = ES0.c;
        CoreImpl coreImpl = this.u;
        coreImpl.getClass();
        if (arrayList == null || arrayList.isEmpty()) {
            byteBuffer2 = null;
        } else {
            ByteBuffer byteBufferA = coreImpl.a(arrayList.size() * 8);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byteBufferA.putLong(((InterfaceC1409rn0) it.next()).Q());
            }
            byteBuffer2 = byteBufferA;
        }
        int i_I_IIJOOO = N._I_IIJOOO(0, byteBuffer == null ? 0 : byteBuffer.limit(), es0.a, this.t, coreImpl, byteBuffer, byteBuffer2);
        if (i_I_IIJOOO != 0) {
            throw new MojoException(i_I_IIJOOO);
        }
    }

    @Override // defpackage.FS0
    public final ResultAnd l0() {
        CS0 cs0 = CS0.c;
        CoreImpl coreImpl = this.u;
        coreImpl.getClass();
        ResultAnd resultAnd = (ResultAnd) N._O_IJO(6, cs0.a, this.t, coreImpl);
        int i = resultAnd.a;
        if (i != 0 && i != 17) {
            throw new MojoException(resultAnd.a);
        }
        DS0 ds0 = (DS0) resultAnd.b;
        long[] jArr = ds0.b;
        if (jArr == null || jArr.length == 0) {
            ds0.c = new ArrayList(0);
        } else {
            ds0.c = new ArrayList(jArr.length);
            for (long j : jArr) {
                ds0.c.add(new C1801yk2(coreImpl, j));
            }
        }
        return resultAnd;
    }

    @Override // defpackage.FS0
    public final FS0 n1() {
        return new GS0(this);
    }
}
