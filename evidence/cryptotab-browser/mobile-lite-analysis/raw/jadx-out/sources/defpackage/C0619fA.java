package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.Executor;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: fA, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0619fA {
    public static final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static int f26J;
    public static boolean K;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public Sz F;
    public String G;
    public boolean H;
    public final Object a = new Object();
    public final Handler b = new Handler();
    public final Wz c = new Executor() { // from class: Wz
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.t.b.post(runnable);
        }
    };
    public final ComponentName d;
    public final Bundle e;
    public Iz f;
    public C0510dA g;
    public C1005lA h;
    public C1005lA i;
    public Zq0 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public final Xz p;
    public final Zz q;
    public final String r;
    public DA s;
    public DA t;
    public DA u;
    public DA v;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        I = Build.VERSION.SDK_INT >= 29;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [Wz] */
    public C0619fA(Context context, ComponentName componentName, ComponentName componentName2, Bundle bundle, String str) {
        this.d = componentName2;
        this.e = bundle;
        bundle.putBoolean("org.chromium.base.process_launcher.extra.bind_to_caller", false);
        int i = AbstractC1872zv.a;
        bundle.putString("org.chromium.base.process_launcher.extra.browser_package_name", Bv.a.d);
        this.r = str;
        this.p = new Xz(this, context);
        this.q = new Zz(this);
        if (K && componentName2 != null) {
            componentName = componentName2;
        }
        e(componentName);
    }

    public final void a() {
        if (g()) {
            if (this.w == 0) {
                this.s.a();
                m();
            }
            this.w++;
            return;
        }
        Log.w("cr_ChildProcessConn", "The connection is not bound for " + this.n);
    }

    public final void b() {
        if (g()) {
            if (this.x == 0) {
                this.t.a();
                m();
            }
            this.x++;
            return;
        }
        Log.w("cr_ChildProcessConn", "The connection is not bound for " + this.n);
    }

    public final boolean c(boolean z) {
        boolean zD = d(z);
        boolean z2 = K;
        ComponentName componentName = this.d;
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = z2 && componentName != null;
        boolean z6 = (z2 || componentName == null) ? false : true;
        if (zD || z5 || !z6) {
            z3 = z6;
            z4 = z5;
        } else {
            j();
            zD = d(z);
        }
        if (zD && !z4 && z3) {
            this.b.postDelayed(new Vz(0, this), 10000L);
        }
        return zD;
    }

    public final boolean d(boolean z) {
        boolean zA;
        if (z) {
            zA = this.s.a();
            if (zA) {
                this.w++;
            }
        } else {
            zA = this.t.a();
            if (zA) {
                this.x++;
            }
        }
        if (zA) {
            this.v.a();
            m();
        }
        return zA;
    }

    public final void e(ComponentName componentName) {
        Intent intent = new Intent();
        intent.setComponent(componentName);
        Bundle bundle = this.e;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Xz xz = this.p;
        Zz zz = this.q;
        String str = this.r;
        this.t = xz.a(intent, 1, zz, str);
        if (I) {
            this.u = xz.a(intent, 257, zz, str);
        }
        this.s = xz.a(intent, 65, zz, str);
        this.v = xz.a(intent, 33, zz, str);
    }

    public final void f() {
        try {
            TraceEvent.a("ChildProcessConnection.doConnectionSetup", null);
            BinderC0449cA binderC0449cA = new BinderC0449cA(this);
            try {
                Zq0 zq0 = this.j;
                C0510dA c0510dA = this.g;
                zq0.z0(c0510dA.a, binderC0449cA, c0510dA.b, c0510dA.c);
            } catch (RemoteException e) {
                Log.e("cr_ChildProcessConn", "Failed to setup connection.", e);
            }
            this.g = null;
        } finally {
            TraceEvent.b("ChildProcessConnection.doConnectionSetup");
        }
    }

    public final boolean g() {
        return this.j != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x0050, TRY_ENTER, TryCatch #0 {all -> 0x0050, blocks: (B:6:0x0009, B:15:0x002a, B:17:0x002e, B:19:0x0045, B:31:0x0078, B:33:0x007c, B:34:0x007f, B:36:0x0085, B:37:0x0094, B:39:0x0098, B:24:0x0052, B:26:0x0064, B:30:0x0073, B:42:0x009f, B:43:0x00a6, B:27:0x0069, B:9:0x0014, B:11:0x001c, B:13:0x0020, B:14:0x0023), top: B:47:0x0009 }] */
    /* JADX WARN: Type inference failed for: r9v7, types: [Sz] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.os.IBinder r9) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "ChildProcessConnection.ChildServiceConnection.onServiceConnected"
            boolean r2 = r8.k
            if (r2 == 0) goto L8
            return
        L8:
            r2 = 0
            org.chromium.base.TraceEvent.a(r1, r2)     // Catch: java.lang.Throwable -> L50
            r3 = 1
            r8.k = r3     // Catch: java.lang.Throwable -> L50
            int r4 = defpackage.BA.u     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L14
            goto L2a
        L14:
            java.lang.String r2 = "org.chromium.base.process_launcher.IChildProcessService"
            android.os.IInterface r2 = r9.queryLocalInterface(r2)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L23
            boolean r4 = r2 instanceof defpackage.Zq0     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto L23
            Zq0 r2 = (defpackage.Zq0) r2     // Catch: java.lang.Throwable -> L50
            goto L2a
        L23:
            Yq0 r2 = new Yq0     // Catch: java.lang.Throwable -> L50
            r2.<init>()     // Catch: java.lang.Throwable -> L50
            r2.t = r9     // Catch: java.lang.Throwable -> L50
        L2a:
            r8.j = r2     // Catch: java.lang.Throwable -> L50
            java.lang.String r9 = "cr_ChildProcessConn"
            android.content.pm.ApplicationInfo r2 = r2.P0()     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            int r4 = defpackage.AbstractC1872zv.a     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            org.chromium.base.BuildInfo r4 = defpackage.Bv.a     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            r4.getClass()     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            android.content.pm.ApplicationInfo r4 = org.chromium.base.BuildInfo.q     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            java.lang.String r5 = r4.sourceDir     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            java.lang.String r6 = r2.sourceDir     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            boolean r5 = java.util.Objects.equals(r5, r6)     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            if (r5 == 0) goto L52
            java.lang.String[] r4 = r4.sharedLibraryFiles     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            java.lang.String[] r2 = r2.sharedLibraryFiles     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            boolean r2 = java.util.Arrays.equals(r4, r2)     // Catch: java.lang.Throwable -> L50 android.os.RemoteException -> L52
            if (r2 == 0) goto L52
            goto L78
        L50:
            r9 = move-exception
            goto La7
        L52:
            char[] r2 = defpackage.C61.a     // Catch: java.lang.Throwable -> L50
            int r2 = defpackage.AbstractC1872zv.a     // Catch: java.lang.Throwable -> L50
            org.chromium.base.BuildInfo r2 = defpackage.Bv.a     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = r2.d     // Catch: java.lang.Throwable -> L50
            android.content.pm.PackageInfo r2 = defpackage.C61.c(r2, r0)     // Catch: java.lang.Throwable -> L50
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L50
            r5 = 28
            if (r4 < r5) goto L69
            long r4 = defpackage.XD2.a(r2)     // Catch: java.lang.Throwable -> L50
            goto L6c
        L69:
            int r2 = r2.versionCode     // Catch: java.lang.Throwable -> L50
            long r4 = (long) r2     // Catch: java.lang.Throwable -> L50
        L6c:
            r6 = 260119(0x3f817, double:1.28516E-318)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L9f
            java.lang.String r2 = "Child process's classpath doesn't match, but main process's package hasn't changed; the child is likely to be broken!"
            android.util.Log.e(r9, r2)     // Catch: java.lang.Throwable -> L50
        L78:
            Iz r9 = r8.f     // Catch: java.lang.Throwable -> L50
            if (r9 == 0) goto L7f
            r9.b()     // Catch: java.lang.Throwable -> L50
        L7f:
            r8.l = r3     // Catch: java.lang.Throwable -> L50
            Sz r9 = r8.F     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L94
            Sz r9 = new Sz     // Catch: java.lang.Throwable -> L50
            r9.<init>()     // Catch: java.lang.Throwable -> L50
            Tz r2 = new Tz     // Catch: java.lang.Throwable -> L50
            r2.<init>(r9, r0)     // Catch: java.lang.Throwable -> L50
            org.chromium.base.ThreadUtils.d(r2)     // Catch: java.lang.Throwable -> L50
            r8.F = r9     // Catch: java.lang.Throwable -> L50
        L94:
            dA r9 = r8.g     // Catch: java.lang.Throwable -> L50
            if (r9 == 0) goto L9b
            r8.f()     // Catch: java.lang.Throwable -> L50
        L9b:
            org.chromium.base.TraceEvent.b(r1)
            return
        L9f:
            org.chromium.base.process_launcher.ChildProcessConnection$ChildProcessMismatchException r9 = new org.chromium.base.process_launcher.ChildProcessConnection$ChildProcessMismatchException     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "Child process's classpath doesn't match, and main process's package has been updated since process launch; process needs restarting!"
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L50
            throw r9     // Catch: java.lang.Throwable -> L50
        La7:
            org.chromium.base.TraceEvent.b(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0619fA.h(android.os.IBinder):void");
    }

    public final void i() {
        if (this.m) {
            return;
        }
        this.m = true;
        int i = this.n;
        StringBuilder sb = new StringBuilder("bindings:");
        sb.append(this.v.A ? "W" : " ");
        sb.append(this.t.A ? "V" : " ");
        sb.append((I && this.u.A) ? "N" : " ");
        sb.append(this.s.A ? "S" : " ");
        Log.w("cr_ChildProcessConn", "onServiceDisconnected (crash or killed by oom): pid=" + i + " " + sb.toString());
        l();
        Iz iz = this.f;
        if (iz != null) {
            this.f = null;
            iz.a(this);
        }
        C1005lA c1005lA = this.h;
        if (c1005lA != null) {
            c1005lA.c();
            this.h = null;
        }
    }

    public final void j() {
        StringBuilder sb = new StringBuilder("Fallback to ");
        ComponentName componentName = this.d;
        sb.append(componentName);
        Log.w("cr_ChildProcessConn", sb.toString());
        DA da = this.s;
        da.y = null;
        da.b();
        DA da2 = this.t;
        da2.y = null;
        da2.b();
        if (I) {
            DA da3 = this.u;
            da3.y = null;
            da3.b();
        }
        DA da4 = this.v;
        da4.y = null;
        da4.b();
        e(componentName);
    }

    public final void k(boolean z, Iz iz) {
        try {
            TraceEvent.a("ChildProcessConnection.start", null);
            this.f = iz;
            if (!c(z)) {
                Log.e("cr_ChildProcessConn", "Failed to establish the service connection.");
                Iz iz2 = this.f;
                if (iz2 != null) {
                    this.f = null;
                    iz2.a(this);
                }
            }
        } finally {
            TraceEvent.b("ChildProcessConnection.start");
        }
    }

    public final void l() {
        this.j = null;
        this.g = null;
        this.B = true;
        this.s.b();
        this.v.b();
        if (I) {
            this.u.b();
        }
        this.t.b();
        m();
        Sz sz = this.F;
        if (sz != null) {
            ThreadUtils.d(new Tz(sz, 1));
            this.F = null;
        }
    }

    public final void m() {
        int i = this.B ? 0 : this.s.A ? 4 : this.t.A ? 3 : (I && this.u.A) ? 2 : 1;
        synchronized (this.a) {
            try {
                this.C = i;
                if (!this.B) {
                    this.D = i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(int i, int i2) {
        if (this.z == i && this.A == i2) {
            return;
        }
        this.z = i;
        this.A = i2;
        if (g()) {
            DA da = this.v;
            if (da.A && Ep.c()) {
                try {
                    da.t.updateServiceGroup(da, i, i2);
                    Handler handler = da.w;
                    Ep.b(da.t, da.u, da, da.v, handler, da.x, da.z);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }
}
