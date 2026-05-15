package defpackage;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class XE {
    public static boolean a(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context, 20415000) == 0;
    }
}
