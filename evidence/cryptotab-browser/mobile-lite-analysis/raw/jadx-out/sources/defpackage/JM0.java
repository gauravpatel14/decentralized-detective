package defpackage;

import android.media.MediaCodec;
import android.util.Log;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import org.chromium.media.MediaCodecBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JM0 extends MediaCodecBridge {
    public SparseArray o;
    public ByteBuffer p;

    @Override // org.chromium.media.MediaCodecBridge
    public final int b(MediaCodec.BufferInfo bufferInfo, long j) {
        ByteBuffer byteBuffer;
        boolean z = true;
        int iDequeueOutputBuffer = -1;
        try {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, j);
            if (iDequeueOutputBuffer >= 0 && (bufferInfo.flags & 2) != 0) {
                int i = AbstractC1872zv.a;
                ByteBuffer outputBuffer = super.getOutputBuffer(iDequeueOutputBuffer);
                if (outputBuffer == null) {
                    throw new IllegalStateException("Got null output buffer");
                }
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                this.p = byteBufferAllocateDirect;
                byteBufferAllocateDirect.put(outputBuffer);
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = bufferInfo.size;
                    if (i3 >= 8) {
                        i3 = 8;
                    }
                    if (i2 >= i3) {
                        break;
                    }
                    sb.append(Integer.toHexString(this.p.get(i2) & 255));
                    sb.append(" ");
                    i2++;
                }
                String str = "cr_MediaCodecEncoder";
                Log.i(str, "spsData: " + sb.toString());
                this.a.releaseOutputBuffer(iDequeueOutputBuffer, false);
                iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, j);
            }
            if (iDequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer2 = super.getOutputBuffer(iDequeueOutputBuffer);
                if (outputBuffer2 == null) {
                    throw new IllegalStateException("Got null output buffer");
                }
                if ((bufferInfo.flags & 1) == 0) {
                    z = false;
                }
                if (z) {
                    int i4 = AbstractC1872zv.a;
                }
                SparseArray sparseArray = this.o;
                if (!z || (byteBuffer = this.p) == null) {
                    sparseArray.put(iDequeueOutputBuffer, outputBuffer2);
                } else {
                    byteBuffer.capacity();
                    int i5 = AbstractC1872zv.a;
                    ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(this.p.capacity() + bufferInfo.size);
                    byteBufferAllocateDirect2.put(this.p);
                    byteBufferAllocateDirect2.put(outputBuffer2);
                    bufferInfo.offset = 0;
                    bufferInfo.size += this.p.capacity();
                    sparseArray.put(iDequeueOutputBuffer, byteBufferAllocateDirect2);
                }
            }
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecEncoder", "Failed to dequeue output buffer", e);
        }
        return iDequeueOutputBuffer;
    }

    @Override // org.chromium.media.MediaCodecBridge
    public final ByteBuffer getOutputBuffer(int i) {
        return (ByteBuffer) this.o.get(i);
    }

    @Override // org.chromium.media.MediaCodecBridge
    public final void releaseOutputBuffer(int i, boolean z) {
        try {
            this.a.releaseOutputBuffer(i, z);
            this.o.remove(i);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecEncoder", "Failed to release output buffer", e);
        }
    }
}
