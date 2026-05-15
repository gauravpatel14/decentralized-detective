package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: o33, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1189o33 {
    public static C1189o33 j;
    public final C23 a;
    public final IntentFilter b;
    public final Context c;
    public final HashSet d;
    public J13 e;
    public volatile boolean f;
    public final Handler g;
    public final GZ2 h;
    public final LinkedHashSet i;

    public C1189o33(Context context) {
        GZ2 gz2 = GZ2.t;
        C23 c23 = new C23("SplitInstallListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService");
        this.d = new HashSet();
        this.e = null;
        this.f = false;
        this.a = c23;
        this.b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext != null ? applicationContext : context;
        this.g = new Handler(Looper.getMainLooper());
        this.i = new LinkedHashSet();
        this.h = gz2;
    }

    public static synchronized C1189o33 b(Context context) {
        try {
            if (j == null) {
                GZ2 gz2 = GZ2.t;
                j = new C1189o33(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return j;
    }

    public final void a() {
        J13 j13;
        if ((this.f || !this.d.isEmpty()) && this.e == null) {
            J13 j132 = new J13(this);
            this.e = j132;
            if (Build.VERSION.SDK_INT >= 33) {
                this.c.registerReceiver(j132, this.b, 2);
            }
            this.c.registerReceiver(this.e, this.b);
        }
        if (this.f || !this.d.isEmpty() || (j13 = this.e) == null) {
            return;
        }
        this.c.unregisterReceiver(j13);
        this.e = null;
    }

    public final synchronized void c(IB2 ib2) {
        try {
            Iterator it = new LinkedHashSet(this.i).iterator();
            while (it.hasNext()) {
                ((InterfaceC1267pN1) it.next()).a(ib2);
            }
            synchronized (this) {
                Iterator it2 = new HashSet(this.d).iterator();
                while (it2.hasNext()) {
                    ((InterfaceC1267pN1) it2.next()).a(ib2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
