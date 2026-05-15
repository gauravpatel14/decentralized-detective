package defpackage;

import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: renamed from: eO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0578eO0 extends XO0 {
    public final String a;
    public final C0526dO0 b;

    public C0578eO0(String str, C0526dO0 c0526dO0) {
        this.a = str;
        this.b = c0526dO0;
    }

    @Override // defpackage.XO0
    public final void f(int i) {
        C0526dO0 c0526dO0;
        MediaRouter2.RoutingController routingController;
        Messenger messenger;
        String str = this.a;
        if (str == null || (c0526dO0 = this.b) == null || (routingController = c0526dO0.g) == null || routingController.isReleased() || (messenger = c0526dO0.h) == null) {
            return;
        }
        int andIncrement = c0526dO0.l.getAndIncrement();
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.arg1 = andIncrement;
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i);
        bundle.putString("routeId", str);
        messageObtain.setData(bundle);
        messageObtain.replyTo = c0526dO0.i;
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e) {
            Log.e("MR2Provider", "Could not send control request to service.", e);
        }
    }

    @Override // defpackage.XO0
    public final void i(int i) {
        C0526dO0 c0526dO0;
        MediaRouter2.RoutingController routingController;
        Messenger messenger;
        String str = this.a;
        if (str == null || (c0526dO0 = this.b) == null || (routingController = c0526dO0.g) == null || routingController.isReleased() || (messenger = c0526dO0.h) == null) {
            return;
        }
        int andIncrement = c0526dO0.l.getAndIncrement();
        Message messageObtain = Message.obtain();
        messageObtain.what = 8;
        messageObtain.arg1 = andIncrement;
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i);
        bundle.putString("routeId", str);
        messageObtain.setData(bundle);
        messageObtain.replyTo = c0526dO0.i;
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e) {
            Log.e("MR2Provider", "Could not send control request to service.", e);
        }
    }
}
