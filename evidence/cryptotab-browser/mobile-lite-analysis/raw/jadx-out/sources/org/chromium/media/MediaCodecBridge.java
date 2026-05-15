package org.chromium.media;

import J.N;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import defpackage.AbstractC1872zv;
import defpackage.HM0;
import defpackage.IM0;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecBridge {
    public static HandlerThread m;
    public static Handler n;
    public MediaCodec a;
    public final int b;
    public int c;
    public final boolean d;
    public final LinkedList e;
    public MediaFormatWrapper f;
    public boolean g;
    public boolean h;
    public long i;
    public int j;
    public final LinkedList k;
    public final LinkedList l;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class DequeueInputResult {
        public final int a;
        public final int b;

        public DequeueInputResult(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int index() {
            return this.b;
        }

        public final int status() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class DequeueOutputResult {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final long e;
        public final int f;

        public DequeueOutputResult(int i, int i2, int i3, int i4, int i5, long j) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = j;
            this.f = i5;
        }

        public final int flags() {
            return this.c;
        }

        public final int index() {
            return this.b;
        }

        public final int numBytes() {
            return this.f;
        }

        public final int offset() {
            return this.d;
        }

        public final long presentationTimeMicroseconds() {
            return this.e;
        }

        public final int status() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class MediaFormatWrapper {
        public final MediaFormat a;

        public MediaFormatWrapper(MediaFormat mediaFormat) {
            this.a = mediaFormat;
        }

        public final boolean a() {
            MediaFormat mediaFormat = this.a;
            return mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        }

        public final int channelCount() {
            return this.a.getInteger("channel-count");
        }

        public final int colorRange() {
            MediaFormat mediaFormat = this.a;
            if (mediaFormat.containsKey("color-range")) {
                return mediaFormat.getInteger("color-range");
            }
            return -1;
        }

        public final int colorStandard() {
            MediaFormat mediaFormat = this.a;
            if (mediaFormat.containsKey("color-standard")) {
                return mediaFormat.getInteger("color-standard");
            }
            return -1;
        }

        public final int colorTransfer() {
            MediaFormat mediaFormat = this.a;
            if (mediaFormat.containsKey("color-transfer")) {
                return mediaFormat.getInteger("color-transfer");
            }
            return -1;
        }

        public final int height() {
            boolean zA = a();
            MediaFormat mediaFormat = this.a;
            return zA ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }

        public final int sampleRate() {
            return this.a.getInteger("sample-rate");
        }

        public final int stride() {
            MediaFormat mediaFormat = this.a;
            return !mediaFormat.containsKey("stride") ? width() : mediaFormat.getInteger("stride");
        }

        public final int width() {
            boolean zA = a();
            MediaFormat mediaFormat = this.a;
            return zA ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        }

        public final int yPlaneHeight() {
            MediaFormat mediaFormat = this.a;
            return !mediaFormat.containsKey("slice-height") ? height() : mediaFormat.getInteger("slice-height");
        }
    }

    public MediaCodecBridge(MediaCodec mediaCodec, int i, boolean z) {
        this.a = mediaCodec;
        this.b = i;
        this.d = z;
        if (z) {
            this.g = false;
            this.e = new LinkedList();
            this.k = new LinkedList();
            this.l = new LinkedList();
            MediaCodec mediaCodec2 = this.a;
            IM0 im0 = new IM0();
            im0.a = this;
            mediaCodec2.setCallback(im0, n);
            d();
        }
    }

    public static void createCallbackHandlerForTesting() {
        if (m != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("TestCallbackThread");
        m = handlerThread;
        handlerThread.start();
        n = new Handler(m.getLooper());
    }

    public static int f(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                Log.e("cr_MediaCodecBridge", "Unsupported cipher mode: " + i);
                return -1;
            }
        }
        return i2;
    }

    public final boolean a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        try {
            this.a.configure(mediaFormat, surface, mediaCrypto, i);
            MediaFormat inputFormat = this.a.getInputFormat();
            this.c = mediaFormat.getInteger("max-input-size");
            if (i != 1) {
                if (inputFormat.containsKey("max-input-size")) {
                    this.c = inputFormat.getInteger("max-input-size");
                }
                return true;
            }
            if (inputFormat.containsKey("stride") && inputFormat.containsKey("slice-height")) {
                return true;
            }
            int integer = inputFormat.getInteger("width");
            int i2 = integer & (-16);
            int integer2 = inputFormat.getInteger("height");
            int i3 = integer2 & (-16);
            if (i3 != 0 && i2 != 0) {
                if (i2 == integer && i3 == integer2) {
                    return true;
                }
                this.a.reset();
                mediaFormat.setInteger("width", i2);
                mediaFormat.setInteger("height", i3);
                this.a.configure(mediaFormat, surface, mediaCrypto, i);
                return true;
            }
            Log.e("cr_MediaCodecBridge", "MediaCodec requires 16x16 alignment, which is not possible for: " + integer + "x" + integer2);
            return false;
        } catch (MediaCodec.CryptoException e) {
            Log.e("cr_MediaCodecBridge", "Cannot configure the video codec: DRM error", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("cr_MediaCodecBridge", "Cannot configure the video codec, wrong format or surface", e2);
            return false;
        } catch (IllegalStateException e3) {
            Log.e("cr_MediaCodecBridge", "Cannot configure the video codec", e3);
            return false;
        } catch (Exception e4) {
            Log.e("cr_MediaCodecBridge", "Cannot configure the video codec", e4);
            return false;
        }
    }

    public int b(MediaCodec.BufferInfo bufferInfo, long j) {
        return this.a.dequeueOutputBuffer(bufferInfo, j);
    }

    public final synchronized void c() {
        long j = this.i;
        if (j != 0) {
            N._V_JO(264, j, this);
        }
    }

    public final synchronized void d() {
        this.e.clear();
        this.k.clear();
        this.l.clear();
        this.h = true;
        this.f = null;
        this.j++;
    }

    public final DequeueInputResult dequeueInputBuffer(long j) {
        int i = 1;
        int i2 = 5;
        int i3 = -1;
        if (this.d) {
            synchronized (this) {
                try {
                    if (this.g) {
                        return new DequeueInputResult(5, -1);
                    }
                    if (!this.h && !this.k.isEmpty()) {
                        return (DequeueInputResult) this.k.remove();
                    }
                    return new DequeueInputResult(1, -1);
                } finally {
                }
            }
        }
        try {
            int iDequeueInputBuffer = this.a.dequeueInputBuffer(j);
            if (iDequeueInputBuffer >= 0) {
                i = 0;
                i3 = iDequeueInputBuffer;
            } else if (iDequeueInputBuffer != -1) {
                Log.e("cr_MediaCodecBridge", "Unexpected index_or_status: " + iDequeueInputBuffer);
                i = 5;
            }
            i2 = i;
        } catch (Exception e) {
            Log.e("cr_MediaCodecBridge", "Failed to dequeue input buffer", e);
        }
        return new DequeueInputResult(i2, i3);
    }

    public final DequeueOutputResult dequeueOutputBuffer(long j) {
        int i;
        int i2;
        int i3 = 3;
        if (this.d) {
            synchronized (this) {
                try {
                    if (this.g) {
                        return new DequeueOutputResult(5, -1, 0, 0, 0, 0L);
                    }
                    if (this.l.isEmpty()) {
                        return new DequeueOutputResult(1, -1, 0, 0, 0, 0L);
                    }
                    if (((DequeueOutputResult) this.l.peek()).status() == 3) {
                        this.f = (MediaFormatWrapper) this.e.remove();
                    }
                    return (DequeueOutputResult) this.l.remove();
                } finally {
                }
            }
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i4 = -1;
        try {
            int iB = b(bufferInfo, j);
            if (iB >= 0) {
                i3 = 0;
                i4 = iB;
            } else if (iB == -3) {
                i3 = 2;
            } else if (iB != -2) {
                if (iB == -1) {
                    i3 = 1;
                } else {
                    Log.e("cr_MediaCodecBridge", "Unexpected index_or_status: " + iB);
                    i3 = 5;
                }
            }
            i2 = i3;
            i = i4;
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to dequeue output buffer", e);
            i = -1;
            i2 = 5;
        }
        return new DequeueOutputResult(i2, i, bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
    }

    public final boolean e() {
        try {
            if (this.d) {
                synchronized (this) {
                    try {
                        if (this.g) {
                            return false;
                        }
                        Handler handler = n;
                        if (handler == null) {
                            handler = new Handler(Looper.getMainLooper());
                        }
                        handler.post(new HM0(this, this.j));
                    } finally {
                    }
                }
            }
            this.a.start();
            return true;
        } catch (IllegalArgumentException e) {
            Log.e("cr_MediaCodecBridge", "Cannot start the media codec", e);
            return false;
        } catch (IllegalStateException e2) {
            Log.e("cr_MediaCodecBridge", "Cannot start the media codec", e2);
            return false;
        }
    }

    public final int flush() {
        try {
            this.a.flush();
            if (!this.d) {
                return 0;
            }
            d();
            return !e() ? 5 : 0;
        } catch (Exception e) {
            Log.e("cr_MediaCodecBridge", "Failed to flush MediaCodec", e);
            return 5;
        }
    }

    public final ByteBuffer getInputBuffer(int i) {
        if (this.d) {
            synchronized (this) {
                try {
                    if (this.g) {
                        return null;
                    }
                } finally {
                }
            }
        }
        try {
            return this.a.getInputBuffer(i);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to get input buffer", e);
            return null;
        }
    }

    public final MediaFormatWrapper getInputFormat() {
        try {
            MediaFormat inputFormat = this.a.getInputFormat();
            if (inputFormat != null) {
                return new MediaFormatWrapper(inputFormat);
            }
            return null;
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to get input format", e);
            return null;
        }
    }

    public final int getMaxInputSize() {
        return this.c;
    }

    public final String getName() {
        try {
            return this.a.getName();
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Cannot get codec name", e);
            return "unknown";
        }
    }

    public ByteBuffer getOutputBuffer(int i) {
        try {
            return this.a.getOutputBuffer(i);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to get output buffer", e);
            return null;
        }
    }

    public final MediaFormatWrapper getOutputFormat() {
        MediaFormatWrapper mediaFormatWrapper;
        if (this.d && (mediaFormatWrapper = this.f) != null) {
            return mediaFormatWrapper;
        }
        try {
            MediaFormat outputFormat = this.a.getOutputFormat();
            if (outputFormat != null) {
                return new MediaFormatWrapper(outputFormat);
            }
            return null;
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to get output format", e);
            return null;
        }
    }

    public final int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.a.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            Log.e("cr_MediaCodecBridge", "Failed to queue input buffer", e);
            return 5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int queueSecureInputBuffer(int r17, int r18, byte[] r19, byte[] r20, int[] r21, int[] r22, int r23, int r24, int r25, int r26, long r27) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.media.MediaCodecBridge.queueSecureInputBuffer(int, int, byte[], byte[], int[], int[], int, int, int, int, long):int");
    }

    public void release() {
        if (this.d) {
            synchronized (this) {
                this.i = 0L;
            }
        }
        try {
            Log.w("cr_MediaCodecBridge", "Releasing: " + this.a.getName());
            this.a.release();
            Log.w("cr_MediaCodecBridge", "Codec released");
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Cannot release media codec", e);
        }
        this.a = null;
    }

    public void releaseOutputBuffer(int i, boolean z) {
        try {
            this.a.releaseOutputBuffer(i, z);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to release output buffer", e);
        }
    }

    public final void requestKeyFrameSoon() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        try {
            this.a.setParameters(bundle);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to set MediaCodec parameters", e);
        }
    }

    public final synchronized void setBuffersAvailableListener(long j) {
        try {
            this.i = j;
            if (!this.k.isEmpty() || !this.l.isEmpty() || this.g) {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean setSurface(Surface surface) {
        try {
            this.a.setOutputSurface(surface);
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Cannot set output surface", e);
            return false;
        }
    }

    public final void setVideoBitrate(int i, int i2) {
        int i3 = this.b;
        if (i3 != 0) {
            if (i3 != 1) {
                i = 0;
            } else if (i2 != 0) {
                i = (i * 30) / i2;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("video-bitrate", i);
        try {
            this.a.setParameters(bundle);
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to set MediaCodec parameters", e);
        }
        int i4 = AbstractC1872zv.a;
    }

    public final void stop() {
        try {
            this.a.stop();
            if (this.d) {
                d();
            }
        } catch (IllegalStateException e) {
            Log.e("cr_MediaCodecBridge", "Failed to stop MediaCodec", e);
        }
    }
}
