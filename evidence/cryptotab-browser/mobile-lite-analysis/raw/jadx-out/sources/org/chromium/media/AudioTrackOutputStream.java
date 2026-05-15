package org.chromium.media;

import J.N;
import android.media.AudioTrack;
import android.util.Log;
import defpackage.AbstractC1872zv;
import defpackage.C0127Lg;
import defpackage.C0142Mg;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioTrackOutputStream {
    public long a;
    public C0127Lg b;
    public AudioTrack c;
    public int d;
    public C0142Mg e;
    public int f;
    public long g;
    public long h;
    public ByteBuffer i;
    public ByteBuffer j;
    public int k;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public final class AudioBufferInfo {
        public final int a;
        public final int b;

        public AudioBufferInfo(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static AudioTrackOutputStream create() {
        AudioTrackOutputStream audioTrackOutputStream = new AudioTrackOutputStream();
        audioTrackOutputStream.b = new C0127Lg(audioTrackOutputStream);
        return audioTrackOutputStream;
    }

    public void close() {
        int i = AbstractC1872zv.a;
        AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            audioTrack.release();
            this.c = null;
        }
    }

    public AudioBufferInfo createAudioBufferInfo(int i, int i2) {
        return new AudioBufferInfo(i, i2);
    }

    public boolean open(int i, int i2, int i3) {
        int i4;
        int i5 = 4;
        if (i == 1) {
            i4 = i5;
        } else {
            if (i == 2) {
                i5 = 12;
            } else if (i == 4) {
                i5 = 204;
            } else if (i == 6) {
                i5 = 252;
            } else if (i != 8) {
                i4 = 1;
            } else {
                i5 = 6396;
            }
            i4 = i5;
        }
        C0127Lg c0127Lg = this.b;
        c0127Lg.getClass();
        this.d = AudioTrack.getMinBufferSize(i2, i4, i3) * 3;
        try {
            int i6 = AbstractC1872zv.a;
            int i7 = this.d;
            c0127Lg.getClass();
            AudioTrack audioTrack = new AudioTrack(3, i2, i4, i3, i7, 1);
            this.c = audioTrack;
            if (audioTrack.getState() == 0) {
                Log.e("cr_AudioTrackOutput", "Cannot create AudioTrack");
                this.c = null;
                return false;
            }
            this.f = 0;
            this.g = 0L;
            return true;
        } catch (IllegalArgumentException e) {
            Log.e("cr_AudioTrackOutput", "Exception creating AudioTrack for playback: ", e);
            return false;
        }
    }

    public void setVolume(double d) {
        float maxVolume = (float) (d * ((double) AudioTrack.getMaxVolume()));
        this.c.setStereoVolume(maxVolume, maxVolume);
    }

    public void start(long j) {
        int i = AbstractC1872zv.a;
        if (this.e != null) {
            return;
        }
        this.a = j;
        this.h = 0L;
        int i2 = this.d;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i2 + 15);
        AudioTrackOutputStream audioTrackOutputStream = this.b.a;
        int i_J_JOO = 15 & (16 - ((int) (N._J_JOO(1, audioTrackOutputStream.a, audioTrackOutputStream, byteBufferAllocateDirect) & ((long) 15))));
        this.i = byteBufferAllocateDirect.slice();
        this.c.play();
        C0142Mg c0142Mg = new C0142Mg(this);
        this.e = c0142Mg;
        c0142Mg.start();
    }

    public void stop() {
        int i = AbstractC1872zv.a;
        C0142Mg c0142Mg = this.e;
        if (c0142Mg != null) {
            c0142Mg.t = true;
            try {
                this.e.interrupt();
                this.e.join();
            } catch (InterruptedException e) {
                Log.e("cr_AudioTrackOutput", "Exception while waiting for AudioTrack worker thread finished: ", e);
            } catch (SecurityException e2) {
                Log.e("cr_AudioTrackOutput", "Exception while waiting for AudioTrack worker thread finished: ", e2);
            }
            this.e = null;
        }
        this.c.pause();
        this.c.flush();
        this.f = 0;
        this.g = 0L;
        this.a = 0L;
    }
}
