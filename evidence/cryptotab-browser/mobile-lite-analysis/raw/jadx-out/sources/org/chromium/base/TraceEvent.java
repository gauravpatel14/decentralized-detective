package org.chromium.base;

import J.N;
import android.content.res.Resources;
import android.os.SystemClock;
import defpackage.AbstractC0663ff2;
import defpackage.C0489cf2;
import defpackage.C0858if2;
import defpackage.RunnableC0727gf2;
import defpackage.o50;
import defpackage.p50;
import defpackage.q50;
import java.util.ArrayList;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TraceEvent implements AutoCloseable {
    public static volatile boolean u;
    public static volatile boolean v;
    public static boolean w;
    public final String t;

    public TraceEvent(String str, String str2) {
        this.t = str;
        a(str, str2);
    }

    public static void a(String str, String str2) {
        EarlyTraceEvent.a(str, false);
        if (u) {
            N._V_OO(1, str, str2);
        }
    }

    public static void b(String str) {
        EarlyTraceEvent.e(str, false);
        if (u) {
            N._V_JO(0, 0L, null);
        }
    }

    public static void c(long j, String str) {
        if (EarlyTraceEvent.d()) {
            q50 q50Var = new q50(str, j, false);
            synchronized (EarlyTraceEvent.d) {
                try {
                    if (EarlyTraceEvent.d()) {
                        EarlyTraceEvent.f.add(q50Var);
                    }
                } finally {
                }
            }
        }
        if (u) {
            N._V_J(1, j);
        }
    }

    public static void d(String str) {
        if (u) {
            N._V_OO(2, str, null);
        }
    }

    public static void dumpViewHierarchy(long j, Object obj) {
        String resourceName;
        if (ApplicationStatus.d()) {
            for (C0489cf2 c0489cf2 : (ArrayList) obj) {
                long j_J_JO = N._J_JO(0, j, c0489cf2.a);
                for (C0858if2 c0858if2 : c0489cf2.b) {
                    try {
                        Resources resources = c0858if2.f;
                        if (resources != null) {
                            int i = c0858if2.a;
                            resourceName = (i == 0 || i == -1) ? "__no_id__" : resources.getResourceName(i);
                        } else {
                            resourceName = "__no_resources__";
                        }
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "__name_not_found__";
                    }
                    N._V_ZZIIJOO(0, c0858if2.c, c0858if2.d, c0858if2.a, c0858if2.b, j_J_JO, c0858if2.e, resourceName);
                }
            }
        }
    }

    public static void e(String str, String str2) {
        if (u) {
            N._V_OO(2, str, str2);
        }
    }

    public static TraceEvent j(String str, String str2) {
        if (EarlyTraceEvent.d() || u) {
            return new TraceEvent(str, str2);
        }
        return null;
    }

    public static void k(long j, String str) {
        if (EarlyTraceEvent.d()) {
            q50 q50Var = new q50(str, j, true);
            synchronized (EarlyTraceEvent.d) {
                try {
                    if (EarlyTraceEvent.d()) {
                        EarlyTraceEvent.f.add(q50Var);
                    }
                } finally {
                }
            }
        }
        if (u) {
            N._V_JO(3, j, str);
        }
    }

    public static void l(int i, long j) {
        if (u) {
            N._V_IJJ(0, i, j, SystemClock.uptimeMillis());
            return;
        }
        int i2 = EarlyTraceEvent.a;
        o50 o50Var = new o50(i, j);
        synchronized (EarlyTraceEvent.d) {
            EarlyTraceEvent.h.add(o50Var);
        }
    }

    public static void setEnabled(boolean z) {
        if (z) {
            synchronized (EarlyTraceEvent.d) {
                try {
                    if (EarlyTraceEvent.d()) {
                        if (!EarlyTraceEvent.e.isEmpty()) {
                            EarlyTraceEvent.b(EarlyTraceEvent.e);
                            EarlyTraceEvent.e.clear();
                        }
                        if (!EarlyTraceEvent.f.isEmpty()) {
                            for (q50 q50Var : EarlyTraceEvent.f) {
                                if (q50Var.a) {
                                    N._V_JJO(0, q50Var.c, q50Var.d, q50Var.b);
                                } else {
                                    N._V_JJ(0, q50Var.c, q50Var.d);
                                }
                            }
                            EarlyTraceEvent.f.clear();
                        }
                        EarlyTraceEvent.a = 2;
                        EarlyTraceEvent.e = null;
                        EarlyTraceEvent.f = null;
                    }
                } finally {
                }
            }
        }
        if (u != z) {
            u = z;
            ThreadUtils.c().setMessageLogging(z ? AbstractC0663ff2.a : null);
        }
        if (u) {
            synchronized (EarlyTraceEvent.d) {
                try {
                    ArrayList<p50> arrayList = EarlyTraceEvent.g;
                    if (!arrayList.isEmpty()) {
                        for (p50 p50Var : arrayList) {
                            N._V_JJ(2, p50Var.a, p50Var.b);
                        }
                        EarlyTraceEvent.g.clear();
                    }
                    ArrayList<o50> arrayList2 = EarlyTraceEvent.h;
                    if (!arrayList2.isEmpty()) {
                        for (o50 o50Var : arrayList2) {
                            N._V_IJJ(0, o50Var.c, o50Var.a, o50Var.b);
                        }
                        EarlyTraceEvent.h.clear();
                    }
                } finally {
                }
            }
        }
        if (v) {
            PostTask.d(7, new RunnableC0727gf2());
        }
    }

    public static void setEventNameFilteringEnabled(boolean z) {
        w = z;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        b(this.t);
    }

    public TraceEvent(int i) {
        this.t = "ReportingCUJScenarioData";
        EarlyTraceEvent.a("ReportingCUJScenarioData", false);
        if (u) {
            N._V_IO(1, i, "ReportingCUJScenarioData");
        }
    }
}
