package defpackage;

import J.N;
import android.util.Log;
import java.nio.ByteBuffer;
import org.chromium.media.AudioTrackOutputStream;

/* JADX INFO: renamed from: Mg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0142Mg extends Thread {
    public volatile boolean t;
    public final /* synthetic */ AudioTrackOutputStream u;

    public C0142Mg(AudioTrackOutputStream audioTrackOutputStream) {
        this.u = audioTrackOutputStream;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        while (!this.t) {
            AudioTrackOutputStream audioTrackOutputStream = this.u;
            int i2 = audioTrackOutputStream.k;
            int iWrite = 0;
            if (i2 != 0) {
                iWrite = audioTrackOutputStream.c.write(audioTrackOutputStream.j, i2, 0);
                if (iWrite < 0) {
                    Log.e("cr_AudioTrackOutput", "AudioTrack.write() failed. Error:" + iWrite);
                    AudioTrackOutputStream audioTrackOutputStream2 = audioTrackOutputStream.b.a;
                    N._V_JO(263, audioTrackOutputStream2.a, audioTrackOutputStream2);
                } else {
                    iWrite = audioTrackOutputStream.k - iWrite;
                    audioTrackOutputStream.k = iWrite;
                }
            }
            if (iWrite < 0) {
                return;
            }
            if (iWrite <= 0) {
                AudioTrackOutputStream audioTrackOutputStream3 = this.u;
                int playbackHeadPosition = audioTrackOutputStream3.c.getPlaybackHeadPosition();
                long j = audioTrackOutputStream3.g + ((long) (playbackHeadPosition - audioTrackOutputStream3.f));
                audioTrackOutputStream3.g = j;
                audioTrackOutputStream3.f = playbackHeadPosition;
                long j2 = audioTrackOutputStream3.h - j;
                long j3 = j2 < 0 ? 0L : j2;
                ByteBuffer byteBufferDuplicate = audioTrackOutputStream3.i.duplicate();
                AudioTrackOutputStream audioTrackOutputStream4 = audioTrackOutputStream3.b.a;
                AudioTrackOutputStream.AudioBufferInfo audioBufferInfo = (AudioTrackOutputStream.AudioBufferInfo) N._O_JJOO(0, audioTrackOutputStream4.a, j3, audioTrackOutputStream4, byteBufferDuplicate);
                if (audioBufferInfo != null && (i = audioBufferInfo.b) > 0) {
                    audioTrackOutputStream3.h += (long) audioBufferInfo.a;
                    audioTrackOutputStream3.j = audioTrackOutputStream3.i.asReadOnlyBuffer();
                    audioTrackOutputStream3.k = i;
                }
            }
        }
    }
}
