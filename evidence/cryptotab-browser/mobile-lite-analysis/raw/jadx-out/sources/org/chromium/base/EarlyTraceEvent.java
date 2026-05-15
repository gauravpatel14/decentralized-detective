package org.chromium.base;

import J.N;
import defpackage.AbstractC1440sM;
import defpackage.CH;
import defpackage.LP1;
import defpackage.r50;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class EarlyTraceEvent {
    public static volatile int a;
    public static volatile boolean b;
    public static boolean c;
    public static ArrayList e;
    public static ArrayList f;
    public static final Object d = new Object();
    public static final ArrayList g = new ArrayList();
    public static final ArrayList h = new ArrayList();

    public static void a(String str, boolean z) {
        if (d()) {
            r50 r50Var = new r50(str, true, z);
            synchronized (d) {
                try {
                    if (d()) {
                        e.add(r50Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void b(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            r50 r50Var = (r50) it.next();
            boolean z = r50Var.a;
            boolean z2 = r50Var.b;
            if (z) {
                if (z2) {
                    N._V_IJJO(2, r50Var.d, r50Var.e, r50Var.f, r50Var.c);
                } else {
                    N._V_IJJO(0, r50Var.d, r50Var.e, r50Var.f, r50Var.c);
                }
            } else if (z2) {
                N._V_IJJO(3, r50Var.d, r50Var.e, r50Var.f, r50Var.c);
            } else {
                N._V_IJJO(1, r50Var.d, r50Var.e, r50Var.f, r50Var.c);
            }
        }
    }

    public static void c() {
        synchronized (d) {
            try {
                if (a != 0) {
                    return;
                }
                e = new ArrayList();
                f = new ArrayList();
                a = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d() {
        return a == 1;
    }

    public static void e(String str, boolean z) {
        if (d()) {
            r50 r50Var = new r50(str, false, z);
            synchronized (d) {
                try {
                    if (d()) {
                        e.add(r50Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void f() {
        if (b) {
            Object obj = d;
            synchronized (obj) {
                if (CH.c().e("trace-early-java-in-child")) {
                    if (a == 0) {
                        c();
                    }
                } else {
                    synchronized (obj) {
                        a = 0;
                        e = null;
                        f = null;
                    }
                }
            }
        }
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return c;
    }

    public static void setBackgroundStartupTracingFlag(boolean z) {
        LP1 lp1D = LP1.d();
        try {
            AbstractC1440sM.a.edit().putBoolean("bg_startup_tracing", z).apply();
            lp1D.close();
        } catch (Throwable th) {
            try {
                lp1D.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
