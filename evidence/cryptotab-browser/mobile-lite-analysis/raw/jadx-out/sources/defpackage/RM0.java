package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RM0 extends Handler {
    public boolean a;
    public final /* synthetic */ GO0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RM0(GO0 go0, Looper looper) {
        super(looper);
        this.b = go0;
        this.a = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.a) {
            int i = message.what;
            GO0 go0 = this.b;
            switch (i) {
                case 1:
                    CP0.a(message.getData());
                    go0.getClass();
                    break;
                case 2:
                    go0.b((PlaybackStateCompat) message.obj);
                    break;
                case 3:
                    go0.a((MediaMetadataCompat) message.obj);
                    break;
                case 4:
                    go0.getClass();
                    break;
                case 5:
                    go0.getClass();
                    break;
                case 6:
                    go0.getClass();
                    break;
                case 7:
                    CP0.a((Bundle) message.obj);
                    go0.getClass();
                    break;
                case 8:
                    go0.c();
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    ((Integer) message.obj).getClass();
                    go0.getClass();
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    ((Boolean) message.obj).getClass();
                    go0.getClass();
                    break;
                case 12:
                    ((Integer) message.obj).getClass();
                    go0.getClass();
                    break;
                case 13:
                    go0.getClass();
                    break;
            }
        }
    }
}
