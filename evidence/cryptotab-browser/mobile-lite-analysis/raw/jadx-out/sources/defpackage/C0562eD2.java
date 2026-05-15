package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.splitinstall.internal.zzag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: eD2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0562eD2 {
    public static final HashMap m = new HashMap();
    public final Context a;
    public final C23 b;
    public final String c;
    public final ArrayList d;
    public final HashSet e;
    public final Object f;
    public boolean g;
    public final WeakReference h;
    public final C1250p33 i;
    public final AtomicInteger j;
    public LC2 k;
    public InterfaceC0889jH2 l;

    /* JADX WARN: Type inference failed for: r0v4, types: [p33] */
    public C0562eD2(Context context, C23 c23) {
        C23 c232 = C0765hG2.c;
        this.d = new ArrayList();
        this.e = new HashSet();
        this.f = new Object();
        this.i = new IBinder.DeathRecipient() { // from class: p33
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                C0562eD2 c0562eD2 = this.a;
                c0562eD2.b.c("reportBinderDeath", new Object[0]);
                if (c0562eD2.h.get() != null) {
                    throw new ClassCastException();
                }
                String str = c0562eD2.c;
                c0562eD2.b.c("%s : Binder has died.", str);
                ArrayList<P23> arrayList = c0562eD2.d;
                for (P23 p23 : arrayList) {
                    RemoteException remoteException = new RemoteException(String.valueOf(str).concat(" : Binder has died."));
                    H62 h62 = p23.t;
                    if (h62 != null) {
                        h62.c(remoteException);
                    }
                }
                arrayList.clear();
                c0562eD2.e();
            }
        };
        this.j = new AtomicInteger(0);
        this.a = context;
        this.b = c23;
        this.c = "SplitInstallService";
        this.h = new WeakReference(null);
    }

    public static void b(C0562eD2 c0562eD2, P23 p23) {
        InterfaceC0889jH2 interfaceC0889jH2 = c0562eD2.l;
        ArrayList<P23> arrayList = c0562eD2.d;
        C23 c23 = c0562eD2.b;
        if (interfaceC0889jH2 != null || c0562eD2.g) {
            if (!c0562eD2.g) {
                p23.run();
                return;
            } else {
                c23.c("Waiting to bind to the service.", new Object[0]);
                arrayList.add(p23);
                return;
            }
        }
        c23.c("Initiate binding to the service.", new Object[0]);
        arrayList.add(p23);
        LC2 lc2 = new LC2(c0562eD2);
        c0562eD2.k = lc2;
        c0562eD2.g = true;
        if (c0562eD2.a.bindService(C0765hG2.d, lc2, 1)) {
            return;
        }
        c23.c("Failed to bind to the service.", new Object[0]);
        c0562eD2.g = false;
        for (P23 p232 : arrayList) {
            zzag zzagVar = new zzag("Failed to bind to the service.");
            H62 h62 = p232.t;
            if (h62 != null) {
                h62.c(zzagVar);
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

    public final void c(P23 p23, final H62 h62) {
        synchronized (this.f) {
            this.e.add(h62);
            h62.a.a(new N41() { // from class: b33
                @Override // defpackage.N41
                public final void onComplete(G62 g62) {
                    C0562eD2 c0562eD2 = this.a;
                    H62 h622 = h62;
                    synchronized (c0562eD2.f) {
                        c0562eD2.e.remove(h622);
                    }
                }
            });
        }
        synchronized (this.f) {
            try {
                if (this.j.getAndIncrement() > 0) {
                    this.b.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a().post(new B33(this, p23.t, p23));
    }

    public final void d(H62 h62) {
        synchronized (this.f) {
            this.e.remove(h62);
        }
        synchronized (this.f) {
            try {
                if (this.j.get() > 0 && this.j.decrementAndGet() > 0) {
                    this.b.c("Leaving the connection open for other ongoing calls.", new Object[0]);
                } else {
                    a().post(new S33(this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        synchronized (this.f) {
            try {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    ((H62) it.next()).c(new RemoteException(String.valueOf(this.c).concat(" : Binder has died.")));
                }
                this.e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
