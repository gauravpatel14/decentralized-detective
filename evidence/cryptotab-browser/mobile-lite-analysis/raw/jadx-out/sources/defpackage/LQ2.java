package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LQ2 {
    public final F13 a;
    public final Context b;

    public LQ2(F13 f13, Context context) {
        new Handler(Looper.getMainLooper());
        this.a = f13;
        this.b = context;
    }

    public static boolean a(Gd gd, Activity activity) throws IntentSender.SendIntentException {
        byte b = (byte) (((byte) 1) | 2);
        if (b != 3) {
            StringBuilder sb = new StringBuilder();
            if ((b & 1) == 0) {
                sb.append(" appUpdateType");
            }
            if ((b & 2) == 0) {
                sb.append(" allowAssetPackDeletion");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        if (gd != null) {
            PendingIntent pendingIntent = gd.b;
            if ((pendingIntent != null ? pendingIntent : null) != null && !gd.c) {
                gd.c = true;
                activity.startIntentSenderForResult((pendingIntent != null ? pendingIntent : null).getIntentSender(), 9100, null, 0, 0, 0, null);
                return true;
            }
        }
        return false;
    }
}
