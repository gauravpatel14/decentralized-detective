package defpackage;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: renamed from: Pz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0194Pz2 extends GA2 {
    public final Context a;
    public final /* synthetic */ GoogleApiAvailability b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0194Pz2(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.b = googleApiAvailability;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
        } else {
            GoogleApiAvailability googleApiAvailability = this.b;
            Context context = this.a;
            int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
            if (googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable)) {
                googleApiAvailability.showErrorNotification(context, iIsGooglePlayServicesAvailable);
            }
        }
    }
}
