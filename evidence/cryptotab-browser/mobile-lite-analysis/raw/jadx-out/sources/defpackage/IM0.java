package defpackage;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import org.chromium.media.MediaCodecBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IM0 extends MediaCodec.Callback {
    public MediaCodecBridge a;

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        Log.e("cr_MediaCodecBridge", "MediaCodec.onError: " + codecException.getDiagnosticInfo());
        MediaCodecBridge mediaCodecBridge = this.a;
        synchronized (mediaCodecBridge) {
            mediaCodecBridge.g = true;
            mediaCodecBridge.k.clear();
            mediaCodecBridge.l.clear();
            mediaCodecBridge.c();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        MediaCodecBridge mediaCodecBridge = this.a;
        synchronized (mediaCodecBridge) {
            if (mediaCodecBridge.h) {
                return;
            }
            mediaCodecBridge.k.add(new MediaCodecBridge.DequeueInputResult(0, i));
            mediaCodecBridge.c();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        MediaCodecBridge mediaCodecBridge = this.a;
        synchronized (mediaCodecBridge) {
            if (mediaCodecBridge.h) {
                return;
            }
            mediaCodecBridge.l.add(new MediaCodecBridge.DequeueOutputResult(0, i, bufferInfo.flags, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs));
            mediaCodecBridge.c();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        MediaCodecBridge mediaCodecBridge = this.a;
        synchronized (mediaCodecBridge) {
            mediaCodecBridge.l.add(new MediaCodecBridge.DequeueOutputResult(3, -1, 0, 0, 0, 0L));
            mediaCodecBridge.e.add(new MediaCodecBridge.MediaFormatWrapper(mediaFormat));
            mediaCodecBridge.c();
        }
    }
}
