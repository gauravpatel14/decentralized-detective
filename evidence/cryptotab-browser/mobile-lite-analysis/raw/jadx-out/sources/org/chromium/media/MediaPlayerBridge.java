package org.chromium.media;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import defpackage.AbstractC1103mg;
import defpackage.AbstractC1499tM;
import defpackage.QN0;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaPlayerBridge {
    public QN0 a;
    public MediaPlayer b;
    public long c;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class AllowedOperations {
        public final boolean a;
        public final boolean b;

        public AllowedOperations(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public final boolean canSeekBackward() {
            return this.b;
        }

        public final boolean canSeekForward() {
            return this.a;
        }
    }

    public static MediaPlayerBridge create(long j) {
        MediaPlayerBridge mediaPlayerBridge = new MediaPlayerBridge();
        mediaPlayerBridge.c = j;
        return mediaPlayerBridge;
    }

    public final MediaPlayer a() {
        if (this.b == null) {
            this.b = new MediaPlayer();
        }
        return this.b;
    }

    public void destroy() {
        QN0 qn0 = this.a;
        if (qn0 != null) {
            qn0.a(true);
            this.a = null;
        }
        this.c = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.chromium.media.MediaPlayerBridge.AllowedOperations getAllowedOperations() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.media.MediaPlayerBridge.getAllowedOperations():org.chromium.media.MediaPlayerBridge$AllowedOperations");
    }

    public int getCurrentPosition() {
        return a().getCurrentPosition();
    }

    public int getDuration() {
        return a().getDuration();
    }

    public boolean isPlaying() {
        return a().isPlaying();
    }

    public void pause() {
        a().pause();
    }

    public boolean prepareAsync() {
        try {
            a().prepareAsync();
            return true;
        } catch (IllegalStateException e) {
            Log.e("cr_media", "Unable to prepare MediaPlayer.", e);
            return false;
        } catch (Exception e2) {
            Log.e("cr_media", "Unable to prepare MediaPlayer.", e2);
            return false;
        }
    }

    public void release() {
        QN0 qn0 = this.a;
        if (qn0 != null) {
            qn0.a(true);
            this.a = null;
        }
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public void seekTo(int i) {
        a().seekTo(i);
    }

    public boolean setDataSource(String str, String str2, String str3, boolean z, HashMap map) {
        Uri uri = Uri.parse(str);
        final HashMap map2 = new HashMap();
        if (z) {
            map2.put("x-hide-urls-from-log", "true");
        }
        if (!TextUtils.isEmpty(str2)) {
            map2.put("Cookie", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            map2.put("User-Agent", str3);
        }
        map2.put("android-allow-cross-domain-redirect", "0");
        map.forEach(new BiConsumer() { // from class: PN0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                if (TextUtils.isEmpty(obj2.toString())) {
                    return;
                }
                map2.put(obj.toString(), obj2.toString());
            }
        });
        try {
            a().setDataSource(AbstractC1499tM.a, uri, map2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean setDataSourceFromFd(int i, long j, long j2) {
        try {
            ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(i);
            a().setDataSource(parcelFileDescriptorAdoptFd.getFileDescriptor(), j, j2);
            parcelFileDescriptorAdoptFd.close();
            return true;
        } catch (IOException e) {
            Log.e("cr_media", "Failed to set data source from file descriptor: " + e);
            return false;
        }
    }

    public boolean setDataUriDataSource(String str) {
        int iIndexOf;
        QN0 qn0 = this.a;
        if (qn0 != null) {
            qn0.a(true);
            this.a = null;
        }
        if (!str.startsWith("data:") || (iIndexOf = str.indexOf(44)) == -1) {
            return false;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        String[] strArrSplit = strSubstring.substring(5).split(";");
        if (strArrSplit.length != 2 || !"base64".equals(strArrSplit[1])) {
            return false;
        }
        QN0 qn02 = new QN0(this, strSubstring2);
        this.a = qn02;
        qn02.c(AbstractC1103mg.e);
        return true;
    }

    @SuppressLint({"NewApi"})
    public void setPlaybackRate(double d) {
        try {
            MediaPlayer mediaPlayerA = a();
            mediaPlayerA.setPlaybackParams(mediaPlayerA.getPlaybackParams().setSpeed((float) d));
        } catch (IllegalArgumentException e) {
            Log.e("cr_media", "Unable to set playback rate", e);
        } catch (IllegalStateException e2) {
            Log.e("cr_media", "Unable to set playback rate", e2);
        }
    }

    public void setSurface(Surface surface) {
        a().setSurface(surface);
    }

    public void setVolume(double d) {
        float f = (float) d;
        a().setVolume(f, f);
    }

    public void start() {
        a().start();
    }
}
