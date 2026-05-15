package org.chromium.base.task;

import defpackage.AbstractC1872zv;
import defpackage.C1464sj2;
import defpackage.FE1;
import defpackage.GE1;
import defpackage.IK1;
import defpackage.JE;
import defpackage.U62;
import defpackage.X62;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PostTask {
    public static final Object a;
    public static ArrayList b;
    public static volatile boolean c;
    public static final JE d;
    public static final U62[] e;

    static {
        int i = AbstractC1872zv.a;
        a = new Object();
        b = new ArrayList();
        JE je = new JE(JE.t, JE.u, 30L, TimeUnit.SECONDS, JE.w, JE.v);
        je.allowCoreThreadTimeOut(true);
        d = je;
        e = new U62[9];
        for (int i2 = 0; i2 <= 5; i2++) {
            e[i2] = new X62(i2);
        }
        for (int i3 = 6; i3 <= 8; i3++) {
            e[i3] = new C1464sj2(i3, "UiThreadTaskRunner", 2);
        }
    }

    public static FE1 a(int i) {
        if (i >= 6) {
            return (FE1) e[i];
        }
        GE1 ge1 = new GE1(i, "SequencedTaskRunnerImpl", 1);
        ge1.l = new AtomicInteger();
        return ge1;
    }

    public static void b(int i, Runnable runnable, long j) {
        ((X62) e[i]).e(runnable, j);
    }

    public static void c(int i, Runnable runnable) {
        b(i, runnable, 0L);
    }

    public static void d(int i, Runnable runnable) {
        if (i >= 6 ? ((IK1) e[i]).a() : false) {
            runnable.run();
        } else {
            c(i, runnable);
        }
    }

    public static void e(Runnable runnable) {
        FutureTask futureTask = new FutureTask(runnable, null);
        d(7, futureTask);
        try {
            futureTask.get();
        } catch (Exception e2) {
            throw new RuntimeException(e2.getCause());
        }
    }

    public static void onNativeSchedulerReady() {
        ArrayList arrayList;
        if (c) {
            return;
        }
        c = true;
        synchronized (a) {
            arrayList = b;
            b = null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((X62) it.next()).c();
        }
    }
}
