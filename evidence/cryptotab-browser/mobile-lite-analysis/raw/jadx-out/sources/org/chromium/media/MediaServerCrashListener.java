package org.chromium.media;

import J.N;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;
import defpackage.AbstractC0260Vp1;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaServerCrashListener implements MediaPlayer.OnErrorListener {
    public MediaPlayer a;
    public long b;
    public long c;

    public static MediaServerCrashListener create(long j) {
        MediaServerCrashListener mediaServerCrashListener = new MediaServerCrashListener();
        mediaServerCrashListener.b = -1L;
        mediaServerCrashListener.c = j;
        return mediaServerCrashListener;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            N._V_ZJO(31, true, this.c, this);
            releaseWatchdog();
        }
        return true;
    }

    public void releaseWatchdog() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.a = null;
    }

    public boolean startListening() {
        if (this.a != null) {
            return true;
        }
        try {
            this.a = MediaPlayer.create(AbstractC1499tM.a, AbstractC0260Vp1.empty);
        } catch (IllegalStateException e) {
            Log.e("cr_crMediaCrashListener", "Exception while creating the watchdog player.", e);
        } catch (RuntimeException e2) {
            Log.e("cr_crMediaCrashListener", "Exception while creating the watchdog player.", e2);
        }
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(this);
            this.b = -1L;
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.b;
        if (j == -1 || jElapsedRealtime - j > 5000) {
            Log.e("cr_crMediaCrashListener", "Unable to create watchdog player, treating it as server crash.");
            N._V_ZJO(31, false, this.c, this);
            this.b = jElapsedRealtime;
        }
        return false;
    }
}
