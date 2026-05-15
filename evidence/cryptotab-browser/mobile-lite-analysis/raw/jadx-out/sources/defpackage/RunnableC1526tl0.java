package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: renamed from: tl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1526tl0 implements Runnable {
    public final String t;
    public final C1846zS2 u;
    public final Messenger v;
    public final /* synthetic */ AbstractServiceC1578ul0 w;

    public RunnableC1526tl0(AbstractServiceC1578ul0 abstractServiceC1578ul0, String str, IBinder iBinder, Bundle bundle, long j, ArrayList arrayList) {
        C1846zS2 c1846zS2;
        this.w = abstractServiceC1578ul0;
        this.t = str;
        if (iBinder == null) {
            c1846zS2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
            c1846zS2 = iInterfaceQueryLocalInterface instanceof C1846zS2 ? (C1846zS2) iInterfaceQueryLocalInterface : new C1846zS2(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
        }
        this.u = c1846zS2;
        this.v = null;
    }

    public final void a(int i) {
        AbstractServiceC1578ul0 abstractServiceC1578ul0;
        synchronized (this.w.t) {
            try {
                try {
                    abstractServiceC1578ul0 = this.w;
                } catch (RemoteException unused) {
                    String strValueOf = String.valueOf(this.t);
                    Log.e("GcmTaskService", strValueOf.length() != 0 ? "Error reporting result of operation to scheduler for ".concat(strValueOf) : new String("Error reporting result of operation to scheduler for "));
                    AbstractServiceC1578ul0 abstractServiceC1578ul02 = this.w;
                    abstractServiceC1578ul02.y.a(this.t, abstractServiceC1578ul02.x.getClassName());
                    if (this.v == null) {
                        AbstractServiceC1578ul0 abstractServiceC1578ul03 = this.w;
                        if (!abstractServiceC1578ul03.y.b(abstractServiceC1578ul03.x.getClassName())) {
                            AbstractServiceC1578ul0 abstractServiceC1578ul04 = this.w;
                            abstractServiceC1578ul04.stopSelf(abstractServiceC1578ul04.u);
                        }
                    }
                }
                if (abstractServiceC1578ul0.y.c(this.t, abstractServiceC1578ul0.x.getClassName())) {
                    AbstractServiceC1578ul0 abstractServiceC1578ul05 = this.w;
                    abstractServiceC1578ul05.y.a(this.t, abstractServiceC1578ul05.x.getClassName());
                    if (this.v == null) {
                        AbstractServiceC1578ul0 abstractServiceC1578ul06 = this.w;
                        if (!abstractServiceC1578ul06.y.b(abstractServiceC1578ul06.x.getClassName())) {
                            AbstractServiceC1578ul0 abstractServiceC1578ul07 = this.w;
                            abstractServiceC1578ul07.stopSelf(abstractServiceC1578ul07.u);
                        }
                    }
                    return;
                }
                Messenger messenger = this.v;
                if (messenger != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 3;
                    messageObtain.arg1 = i;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("component", this.w.x);
                    bundle.putString("tag", this.t);
                    messageObtain.setData(bundle);
                    messenger.send(messageObtain);
                } else {
                    this.u.W0(i);
                }
                AbstractServiceC1578ul0 abstractServiceC1578ul08 = this.w;
                abstractServiceC1578ul08.y.a(this.t, abstractServiceC1578ul08.x.getClassName());
                if (this.v == null) {
                    AbstractServiceC1578ul0 abstractServiceC1578ul09 = this.w;
                    if (!abstractServiceC1578ul09.y.b(abstractServiceC1578ul09.x.getClassName())) {
                        AbstractServiceC1578ul0 abstractServiceC1578ul010 = this.w;
                        abstractServiceC1578ul010.stopSelf(abstractServiceC1578ul010.u);
                    }
                }
            } catch (Throwable th) {
                AbstractServiceC1578ul0 abstractServiceC1578ul011 = this.w;
                abstractServiceC1578ul011.y.a(this.t, abstractServiceC1578ul011.x.getClassName());
                if (this.v == null) {
                    AbstractServiceC1578ul0 abstractServiceC1578ul012 = this.w;
                    if (!abstractServiceC1578ul012.y.b(abstractServiceC1578ul012.x.getClassName())) {
                        AbstractServiceC1578ul0 abstractServiceC1578ul013 = this.w;
                        abstractServiceC1578ul013.stopSelf(abstractServiceC1578ul013.u);
                    }
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractServiceC1578ul0 abstractServiceC1578ul0 = this.w;
        String str = this.t;
        String strValueOf = String.valueOf(str);
        C1707x03 c1707x03 = new C1707x03(strValueOf.length() != 0 ? "nts:client:onRunTask:".concat(strValueOf) : new String("nts:client:onRunTask:"));
        try {
            T62 t62 = new T62(str);
            abstractServiceC1578ul0.z.getClass();
            try {
                a(abstractServiceC1578ul0.b(t62));
                c1707x03.close();
            } finally {
            }
        } finally {
        }
    }

    public RunnableC1526tl0(AbstractServiceC1578ul0 abstractServiceC1578ul0, String str, Messenger messenger, Bundle bundle, long j, ArrayList arrayList) {
        this.w = abstractServiceC1578ul0;
        this.t = str;
        this.v = messenger;
        this.u = null;
    }
}
