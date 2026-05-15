package org.chromium.media;

import J.N;
import android.media.MediaPlayer;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MediaPlayerListener implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener {
    public long a;

    public static MediaPlayerListener create(long j, MediaPlayerBridge mediaPlayerBridge) {
        MediaPlayerListener mediaPlayerListener = new MediaPlayerListener();
        mediaPlayerListener.a = j;
        if (mediaPlayerBridge != null) {
            mediaPlayerBridge.a().setOnCompletionListener(mediaPlayerListener);
            mediaPlayerBridge.a().setOnErrorListener(mediaPlayerListener);
            mediaPlayerBridge.a().setOnPreparedListener(mediaPlayerListener);
            mediaPlayerBridge.a().setOnVideoSizeChangedListener(mediaPlayerListener);
        }
        return mediaPlayerListener;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        N._V_JO(266, this.a, this);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = 3;
        if (i != 1) {
            if (i == 100) {
                i3 = 4;
            } else if (i == 200) {
                i3 = 2;
            }
        } else if (i2 == -1007) {
            i3 = 1;
        } else if (i2 != -110) {
            i3 = 0;
        }
        N._V_IJO(51, i3, this.a, this);
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        N._V_JO(265, this.a, this);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        N._V_IIJO(12, i, i2, this.a, this);
    }
}
