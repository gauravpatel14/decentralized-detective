package defpackage;

import android.app.Notification;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat$Token;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G01 extends H01 {
    public int[] d;
    public MediaSessionCompat$Token e;

    @Override // defpackage.H01
    public final void a(L01 l01) {
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = l01.b;
        if (i >= 34) {
            Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
            int[] iArr = this.d;
            MediaSessionCompat$Token mediaSessionCompat$Token = this.e;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            if (mediaSessionCompat$Token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) mediaSessionCompat$Token.u);
            }
            builder.setStyle(mediaStyle);
            return;
        }
        Notification.MediaStyle mediaStyle2 = new Notification.MediaStyle();
        int[] iArr2 = this.d;
        MediaSessionCompat$Token mediaSessionCompat$Token2 = this.e;
        if (iArr2 != null) {
            mediaStyle2.setShowActionsInCompactView(iArr2);
        }
        if (mediaSessionCompat$Token2 != null) {
            mediaStyle2.setMediaSession((MediaSession.Token) mediaSessionCompat$Token2.u);
        }
        builder.setStyle(mediaStyle2);
    }
}
