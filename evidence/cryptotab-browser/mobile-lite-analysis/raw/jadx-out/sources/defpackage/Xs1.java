package defpackage;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xs1 implements IBinder.DeathRecipient {
    public final Messenger a;
    public final at1 b;
    public final Messenger c;
    public int f;
    public int g;
    public final /* synthetic */ ServiceConnectionC0608et1 i;
    public int d = 1;
    public int e = 1;
    public final SparseArray h = new SparseArray();

    public Xs1(ServiceConnectionC0608et1 serviceConnectionC0608et1, Messenger messenger) {
        this.i = serviceConnectionC0608et1;
        this.a = messenger;
        at1 at1Var = new at1(this);
        this.b = at1Var;
        this.c = new Messenger(at1Var);
    }

    public final void a(int i) {
        int i2 = this.d;
        this.d = i2 + 1;
        b(5, i2, i, null, null);
    }

    public final boolean b(int i, int i2, int i3, Bundle bundle, Bundle bundle2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.arg1 = i2;
        messageObtain.arg2 = i3;
        messageObtain.obj = bundle;
        messageObtain.setData(bundle2);
        messageObtain.replyTo = this.c;
        try {
            this.a.send(messageObtain);
            return true;
        } catch (DeadObjectException unused) {
            return false;
        } catch (RemoteException e) {
            if (i == 2) {
                return false;
            }
            Log.e("MediaRouteProviderProxy", "Could not send message to service.", e);
            return false;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        this.i.C.post(new Ws1(this, 1));
    }

    public final void c(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i2);
        int i3 = this.d;
        this.d = i3 + 1;
        b(7, i3, i, null, bundle);
    }

    public final void d(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i2);
        int i3 = this.d;
        this.d = i3 + 1;
        b(8, i3, i, null, bundle);
    }
}
