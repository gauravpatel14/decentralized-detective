package org.chromium.mojo.system.impl;

import J.N;
import defpackage.BS0;
import defpackage.DS0;
import defpackage.GS0;
import defpackage.J81;
import defpackage.UN;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class CoreImpl {
    public final int a;

    public CoreImpl() {
        new ThreadLocal();
        this.a = N._I_IOO(1, 8, this, ByteBuffer.allocateDirect(8));
    }

    public static ResultAnd newNativeCreationResult(int i, long j, long j2) {
        return new ResultAnd(i, new UN(Long.valueOf(j), Long.valueOf(j2)));
    }

    public static ResultAnd newReadMessageResult(int i, byte[] bArr, long[] jArr) {
        DS0 ds0 = new DS0();
        if (i == 0) {
            ds0.a = bArr;
            ds0.b = jArr;
        }
        return new ResultAnd(i, ds0);
    }

    public static ResultAnd newResultAndBuffer(int i, ByteBuffer byteBuffer) {
        return new ResultAnd(i, byteBuffer);
    }

    public static ResultAnd newResultAndInteger(int i, int i2) {
        return new ResultAnd(i, Integer.valueOf(i2));
    }

    public static ResultAnd newResultAndLong(int i, long j) {
        return new ResultAnd(i, Long.valueOf(j));
    }

    public final ByteBuffer a(int i) {
        int i2 = this.a;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i + i2);
        if (i2 != 0) {
            byteBufferAllocateDirect = byteBufferAllocateDirect.slice();
        }
        return byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
    }

    public final J81 b(BS0 bs0) {
        ByteBuffer byteBufferA;
        if (bs0 != null) {
            byteBufferA = a(8);
            byteBufferA.putInt(0, 8);
            byteBufferA.putInt(4, bs0.a.a);
        } else {
            byteBufferA = null;
        }
        ResultAnd resultAnd = (ResultAnd) N._O_OO(13, this, byteBufferA);
        if (resultAnd.a != 0) {
            throw new MojoException(resultAnd.a);
        }
        Object obj = resultAnd.b;
        return new J81(new GS0(this, ((Long) ((UN) obj).a).longValue()), new GS0(this, ((Long) ((UN) obj).b).longValue()));
    }
}
