package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GO0 implements IBinder.DeathRecipient {
    public final QM0 a = new QM0(this);
    public RM0 b;
    public SM0 c;
    public final /* synthetic */ d d;

    public GO0(d dVar) {
        this.d = dVar;
    }

    public final void a(MediaMetadataCompat mediaMetadataCompat) {
        MediaDescriptionCompat mediaDescriptionCompatA = mediaMetadataCompat == null ? null : mediaMetadataCompat.a();
        d dVar = this.d;
        dVar.o0 = mediaDescriptionCompatA;
        dVar.u();
        dVar.t(false);
    }

    public final void b(PlaybackStateCompat playbackStateCompat) {
        d dVar = this.d;
        dVar.n0 = playbackStateCompat;
        dVar.t(false);
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        d(8, null, null);
    }

    public final void c() {
        d dVar = this.d;
        YM0 ym0 = dVar.l0;
        if (ym0 != null) {
            ym0.b(dVar.m0);
            dVar.l0 = null;
        }
    }

    public final void d(int i, Object obj, Bundle bundle) {
        RM0 rm0 = this.b;
        if (rm0 != null) {
            Message messageObtainMessage = rm0.obtainMessage(i, obj);
            messageObtainMessage.setData(bundle);
            messageObtainMessage.sendToTarget();
        }
    }

    public final void e(Handler handler) {
        if (handler != null) {
            RM0 rm0 = new RM0(this, handler.getLooper());
            this.b = rm0;
            rm0.a = true;
        } else {
            RM0 rm02 = this.b;
            if (rm02 != null) {
                rm02.a = false;
                rm02.removeCallbacksAndMessages(null);
                this.b = null;
            }
        }
    }
}
