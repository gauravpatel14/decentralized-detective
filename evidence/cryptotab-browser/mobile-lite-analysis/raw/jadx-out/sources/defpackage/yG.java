package defpackage;

import com.google.protobuf.InvalidProtocolBufferException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yG {
    public int a;
    public zG b;

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static C1660wG f(byte[] bArr, int i, int i2, boolean z) {
        C1660wG c1660wG = new C1660wG(bArr, i, i2, z);
        try {
            c1660wG.i(i2);
            return c1660wG;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static yG g(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return f(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && AbstractC1633vk2.c) {
            return new xG(byteBuffer, z);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return f(bArr, 0, iRemaining, true);
    }

    public abstract long A();

    public abstract boolean B(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void h(int i);

    public abstract int i(int i);

    public abstract boolean j();

    public abstract C0199Qv k();

    public abstract double l();

    public abstract int m();

    public abstract int n();

    public abstract long o();

    public abstract float p();

    public abstract int q();

    public abstract long r();

    public abstract int s();

    public abstract long t();

    public abstract int u();

    public abstract long v();

    public abstract String w();

    public abstract String x();

    public abstract int y();

    public abstract int z();
}
