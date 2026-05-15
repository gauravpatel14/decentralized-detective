package org.chromium.content.browser;

import J.N;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.os.Trace;
import defpackage.AbstractC0907jY;
import defpackage.AbstractC1872zv;
import defpackage.Gr1;
import defpackage.InterfaceC0550dv;
import defpackage.OE0;
import defpackage.RunnableC0609ev;
import defpackage.RunnableC0741gv;
import defpackage.RunnableC0807hv;
import defpackage.YE1;
import defpackage.iv;
import java.util.ArrayList;
import org.chromium.base.BuildInfo;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BrowserStartupControllerImpl {
    public static BrowserStartupControllerImpl l;
    public static boolean m;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean i;
    public boolean j;
    public TracingControllerAndroidImpl k;
    public int h = 0;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();

    public BrowserStartupControllerImpl() {
        if (BuildInfo.a()) {
            if (Build.VERSION.SDK_INT >= 33 ? Process.isSdkSandbox() : false) {
                return;
            }
            PostTask.c(7, new RunnableC0741gv(this));
        }
    }

    public static void browserStartupComplete(int i) {
        BrowserStartupControllerImpl browserStartupControllerImpl = l;
        if (browserStartupControllerImpl != null) {
            browserStartupControllerImpl.b(i);
        }
    }

    public static BrowserStartupControllerImpl d() {
        if (l == null) {
            l = new BrowserStartupControllerImpl();
        }
        return l;
    }

    public static void g() {
        YE1 ye1 = YE1.c;
        ye1.b = true;
        for (int i = 0; i < 4; i++) {
            int[] iArr = ye1.a;
            if (iArr[i] > 0) {
                for (int i2 = 0; i2 < iArr[i]; i2++) {
                    Gr1.h(i, 4, "Servicification.Startup2");
                }
                iArr[i] = 0;
            }
        }
    }

    public static void minimalBrowserStartupComplete() {
        BrowserStartupControllerImpl browserStartupControllerImpl = l;
        if (browserStartupControllerImpl != null) {
            browserStartupControllerImpl.j = true;
            if (!browserStartupControllerImpl.i) {
                if (browserStartupControllerImpl.h == 1) {
                    browserStartupControllerImpl.c(-1);
                }
                g();
            } else {
                browserStartupControllerImpl.h = 0;
                if (browserStartupControllerImpl.a() > 0) {
                    PostTask.c(7, new RunnableC0609ev(browserStartupControllerImpl));
                }
            }
        }
    }

    public static boolean shouldStartGpuProcessOnBrowserStartup() {
        return m;
    }

    public final int a() {
        boolean z = this.h == 1;
        int i_I_Z = N._I_Z(0, z);
        if (!z) {
            this.i = false;
        }
        this.e = true;
        return i_I_Z;
    }

    public final void b(int i) {
        this.f = true;
        this.g = i <= 0;
        ArrayList<InterfaceC0550dv> arrayList = this.a;
        for (InterfaceC0550dv interfaceC0550dv : arrayList) {
            if (this.g) {
                interfaceC0550dv.b();
            } else {
                interfaceC0550dv.a();
            }
        }
        arrayList.clear();
        c(i);
        g();
    }

    public final void c(int i) {
        this.g = i <= 0;
        ArrayList<InterfaceC0550dv> arrayList = this.b;
        for (InterfaceC0550dv interfaceC0550dv : arrayList) {
            if (this.g) {
                interfaceC0550dv.b();
            } else {
                interfaceC0550dv.a();
            }
        }
        arrayList.clear();
    }

    public final boolean e() {
        return this.f && this.g;
    }

    public final void f(RunnableC0807hv runnableC0807hv) {
        if (this.d) {
            return;
        }
        int i = AbstractC1872zv.a;
        this.d = true;
        Trace.beginSection("prepareToStartBrowserProcess");
        try {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                OE0.h.a();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                AbstractC0907jY.a();
                N._V_Z(7, false);
                Trace.endSection();
                if (runnableC0807hv != null) {
                    PostTask.c(8, runnableC0807hv);
                }
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                Trace.endSection();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    public final void h(boolean z, boolean z2, InterfaceC0550dv interfaceC0550dv) {
        OE0.h.getClass();
        YE1 ye1 = YE1.c;
        int iA = YE1.a(this.f, this.j, z2);
        if (iA >= 0) {
            if (ye1.b) {
                Gr1.h(iA, 4, "Servicification.Startup2");
            } else {
                int[] iArr = ye1.a;
                iArr[iA] = iArr[iA] + 1;
            }
        }
        if (this.f || (z2 && this.j)) {
            PostTask.c(7, new iv(this, interfaceC0550dv));
            return;
        }
        if (z2) {
            this.b.add(interfaceC0550dv);
        } else {
            this.a.add(interfaceC0550dv);
        }
        boolean z3 = this.i | (this.h == 1 && !z2);
        this.i = z3;
        if (!this.c) {
            this.c = true;
            m = z | m;
            f(new RunnableC0807hv(this, z2));
        } else if (this.j && z3) {
            this.h = 0;
            if (a() > 0) {
                PostTask.c(7, new RunnableC0609ev(this));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(boolean r6) {
        /*
            r5 = this;
            OE0 r0 = defpackage.OE0.h
            r0.getClass()
            boolean r0 = org.chromium.content.browser.BrowserStartupControllerImpl.m
            r6 = r6 | r0
            org.chromium.content.browser.BrowserStartupControllerImpl.m = r6
            YE1 r6 = defpackage.YE1.c
            boolean r0 = r5.f
            boolean r1 = r5.j
            r2 = 0
            int r0 = defpackage.YE1.a(r0, r1, r2)
            r1 = 1
            r3 = 4
            if (r0 >= 0) goto L1a
            goto L2b
        L1a:
            boolean r4 = r6.b
            if (r4 == 0) goto L24
            java.lang.String r6 = "Servicification.Startup2"
            defpackage.Gr1.h(r0, r3, r6)
            goto L2b
        L24:
            int[] r6 = r6.a
            r4 = r6[r0]
            int r4 = r4 + r1
            r6[r0] = r4
        L2b:
            boolean r6 = r5.f
            if (r6 != 0) goto L52
            r6 = 0
            r5.f(r6)
            boolean r6 = r5.e
            if (r6 == 0) goto L3b
            int r6 = r5.h
            if (r6 != r1) goto L4d
        L3b:
            r5.h = r2
            int r6 = r5.a()
            if (r6 <= 0) goto L4d
            ev r6 = new ev
            r6.<init>(r5)
            r0 = 7
            org.chromium.base.task.PostTask.c(r0, r6)
            goto L52
        L4d:
            r6 = 37
            J.N._V(r6)
        L52:
            boolean r6 = r5.g
            if (r6 == 0) goto L57
            return
        L57:
            org.chromium.base.library_loader.ProcessInitException r6 = new org.chromium.base.library_loader.ProcessInitException
            r6.<init>(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.content.browser.BrowserStartupControllerImpl.i(boolean):void");
    }
}
