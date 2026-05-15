package defpackage;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

/* JADX INFO: renamed from: gD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0690gD2 extends ZU2 {
    public final /* synthetic */ XC2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0690gD2(XC2 xc2, Looper looper) {
        super(looper);
        this.a = xc2;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        XC2 xc2 = this.a;
        xc2.getClass();
        if (message == null) {
            return;
        }
        Object obj = message.obj;
        if (!(obj instanceof Intent)) {
            Log.w("InstanceID", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                xc2.e = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                xc2.d = (Messenger) parcelableExtra;
            }
        }
        xc2.e((Intent) message.obj);
    }
}
