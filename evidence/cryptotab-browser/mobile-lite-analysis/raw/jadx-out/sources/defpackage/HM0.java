package defpackage;

import org.chromium.media.MediaCodecBridge;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HM0 implements Runnable {
    public final int t;
    public final /* synthetic */ MediaCodecBridge u;

    public HM0(MediaCodecBridge mediaCodecBridge, int i) {
        this.u = mediaCodecBridge;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaCodecBridge mediaCodecBridge = this.u;
        int i = this.t;
        synchronized (mediaCodecBridge) {
            if (mediaCodecBridge.j != i) {
                return;
            }
            mediaCodecBridge.h = false;
        }
    }
}
