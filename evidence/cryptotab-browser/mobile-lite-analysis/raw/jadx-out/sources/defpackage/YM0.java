package defpackage;

import android.content.Context;
import android.media.session.MediaController;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.b;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YM0 {
    public final b a;
    public final Set b;

    public YM0(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.b = Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.a = new TM0(context, mediaSessionCompat$Token);
        } else {
            this.a = new b(context, mediaSessionCompat$Token);
        }
    }

    public final WM0 a() {
        MediaController.TransportControls transportControls = this.a.a.getTransportControls();
        return Build.VERSION.SDK_INT >= 29 ? new XM0(transportControls) : new WM0(transportControls);
    }

    public final void b(GO0 go0) {
        if (go0 == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (!this.b.remove(go0)) {
            Log.w("MediaControllerCompat", "the callback has never been registered");
            return;
        }
        try {
            this.a.b(go0);
        } finally {
            go0.e(null);
        }
    }
}
