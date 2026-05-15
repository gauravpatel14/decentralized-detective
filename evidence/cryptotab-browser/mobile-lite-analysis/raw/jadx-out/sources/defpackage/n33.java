package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.appupdate.internal.zzy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class n33 {
    public static final HashMap m = new HashMap();
    public final Context a;
    public final C1224oY2 b;
    public final String c;
    public final ArrayList d;
    public final HashSet e;
    public final Object f;
    public boolean g;
    public final WeakReference h;
    public final C1478t03 i;
    public final AtomicInteger j;
    public ServiceConnectionC1001l33 k;
    public HO2 l;

    /* JADX WARN: Type inference failed for: r0v4, types: [t03] */
    public n33(Context context, C1224oY2 c1224oY2) {
        C1224oY2 c1224oY22 = F13.e;
        this.d = new ArrayList();
        this.e = new HashSet();
        this.f = new Object();
        this.i = new IBinder.DeathRecipient() { // from class: t03
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                n33 n33Var = this.a;
                n33Var.b.b("reportBinderDeath", new Object[0]);
                if (n33Var.h.get() != null) {
                    throw new ClassCastException();
                }
                n33Var.b.b("%s : Binder has died.", n33Var.c);
                for (UY2 uy2 : n33Var.d) {
                    RemoteException remoteException = new RemoteException(String.valueOf(n33Var.c).concat(" : Binder has died."));
                    H62 h62 = uy2.t;
                    if (h62 != null) {
                        h62.c(remoteException);
                    }
                }
                n33Var.d.clear();
                synchronized (n33Var.f) {
                    n33Var.d();
                }
            }
        };
        this.j = new AtomicInteger(0);
        this.a = context;
        this.b = c1224oY2;
        this.c = "AppUpdateService";
        this.h = new WeakReference(null);
    }

    public static void b(n33 n33Var, UY2 uy2) {
        HO2 ho2 = n33Var.l;
        ArrayList<UY2> arrayList = n33Var.d;
        C1224oY2 c1224oY2 = n33Var.b;
        if (ho2 != null || n33Var.g) {
            if (!n33Var.g) {
                uy2.run();
                return;
            } else {
                c1224oY2.b("Waiting to bind to the service.", new Object[0]);
                arrayList.add(uy2);
                return;
            }
        }
        c1224oY2.b("Initiate binding to the service.", new Object[0]);
        arrayList.add(uy2);
        ServiceConnectionC1001l33 serviceConnectionC1001l33 = new ServiceConnectionC1001l33(n33Var);
        n33Var.k = serviceConnectionC1001l33;
        n33Var.g = true;
        if (n33Var.a.bindService(F13.f, serviceConnectionC1001l33, 1)) {
            return;
        }
        c1224oY2.b("Failed to bind to the service.", new Object[0]);
        n33Var.g = false;
        for (UY2 uy22 : arrayList) {
            zzy zzyVar = new zzy("Failed to bind to the service.");
            H62 h62 = uy22.t;
            if (h62 != null) {
                h62.c(zzyVar);
            }
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = m;
        synchronized (map) {
            try {
                if (!map.containsKey(this.c)) {
                    HandlerThread handlerThread = new HandlerThread(this.c, 10);
                    handlerThread.start();
                    map.put(this.c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(H62 h62) {
        synchronized (this.f) {
            this.e.remove(h62);
        }
        a().post(new G13(this));
    }

    public final void d() {
        HashSet hashSet = this.e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((H62) it.next()).c(new RemoteException(String.valueOf(this.c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
