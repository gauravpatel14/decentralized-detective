package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class h70 {
    public final CoreImpl a;
    public ByteBuffer b;
    public final ArrayList c = new ArrayList();
    public int d;

    public h70(CoreImpl coreImpl, int i) {
        this.a = coreImpl;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i <= 0 ? 1024 : i);
        this.b = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        this.d = 0;
    }
}
