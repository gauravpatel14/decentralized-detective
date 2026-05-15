package org.chromium.chrome.browser.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import defpackage.AbstractC1034lY;
import defpackage.AbstractC1499tM;
import defpackage.C0410bQ0;
import defpackage.C0429bh0;
import defpackage.C1383rN1;
import defpackage.C1443sN1;
import defpackage.ComponentCallbacks2C0352aQ0;
import defpackage.Gr1;
import defpackage.RR1;
import defpackage.SM1;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.chromium.base.BundleUtils;
import org.chromium.base.TraceEvent;
import org.chromium.chrome.browser.base.SplitChromeApplication;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SplitChromeApplication extends Application {
    public static C1443sN1 x;
    public RR1 t;
    public SM1 u;
    public final String v = "DB";
    public Resources w;

    public static Context b(Context context) {
        return !BundleUtils.f("chrome") ? context : BundleUtils.a(context, "chrome");
    }

    public static void c(String str) {
        C1383rN1 c1383rN1;
        C1443sN1 c1443sN1 = x;
        if (c1443sN1 != null) {
            TraceEvent traceEventJ = TraceEvent.j("SplitPreloader.wait", null);
            try {
                synchronized (c1443sN1.a) {
                    c1383rN1 = (C1383rN1) c1443sN1.a.remove(str);
                }
                if (c1383rN1 != null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    c1383rN1.o();
                    Gr1.n(SystemClock.uptimeMillis() - jUptimeMillis, "Android.IsolatedSplits.PreloadWaitTime." + str);
                }
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } catch (Throwable th) {
                if (traceEventJ != null) {
                    try {
                        traceEventJ.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
    }

    public static boolean e() {
        return !AbstractC1499tM.b().contains(":");
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r15) {
        /*
            Method dump skipped, instruction units count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.chrome.browser.base.SplitChromeApplication.a(android.content.Context):void");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        a(context);
        if (!e()) {
            final int i = 1;
            this.t = new RR1(this) { // from class: KM1
                public final /* synthetic */ SplitChromeApplication u;

                {
                    this.u = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    SplitChromeApplication splitChromeApplication = this.u;
                    switch (i) {
                        case 0:
                            C1443sN1 c1443sN1 = SplitChromeApplication.x;
                            splitChromeApplication.getClass();
                            return (SM1) BundleUtils.g(SplitChromeApplication.b(splitChromeApplication), splitChromeApplication.v);
                        default:
                            C1443sN1 c1443sN12 = SplitChromeApplication.x;
                            splitChromeApplication.getClass();
                            return new SM1();
                    }
                }
            };
        } else {
            AbstractC1034lY.a = true;
            final int i2 = 0;
            this.t = new RR1(this) { // from class: KM1
                public final /* synthetic */ SplitChromeApplication u;

                {
                    this.u = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    SplitChromeApplication splitChromeApplication = this.u;
                    switch (i2) {
                        case 0:
                            C1443sN1 c1443sN1 = SplitChromeApplication.x;
                            splitChromeApplication.getClass();
                            return (SM1) BundleUtils.g(SplitChromeApplication.b(splitChromeApplication), splitChromeApplication.v);
                        default:
                            C1443sN1 c1443sN12 = SplitChromeApplication.x;
                            splitChromeApplication.getClass();
                            return new SM1();
                    }
                }
            };
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createContextForSplit(String str) {
        Context contextCreateContextForSplit;
        TraceEvent traceEventJ = TraceEvent.j("SplitChromeApplication.createContextForSplit", null);
        try {
            c(str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (BundleUtils.b) {
                contextCreateContextForSplit = super.createContextForSplit(str);
            }
            Gr1.n(SystemClock.uptimeMillis() - jUptimeMillis, "Android.IsolatedSplits.ContextCreateTime." + str);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return contextCreateContextForSplit;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    public final SM1 d() {
        if (this.u == null) {
            SM1 sm1 = (SM1) this.t.get();
            this.u = sm1;
            sm1.a = this;
        }
        return this.u;
    }

    public final void f() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 28 && Process.isIsolated()) {
            try {
                Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
                if (bundle != null && bundle.containsKey("preloaded_fonts")) {
                    Class<?> cls = Class.forName("android.app.ActivityThread");
                    cls.getMethod("currentActivityThread", null);
                    Method method = cls.getMethod("getPackageManager", null);
                    Field declaredField = cls.getDeclaredField("sPackageManager");
                    declaredField.setAccessible(true);
                    Class<?> cls2 = Class.forName("android.content.pm.IPackageManager");
                    ClassLoader classLoader = cls2.getClassLoader();
                    Object objInvoke = method.invoke(null, null);
                    C0429bh0 c0429bh0 = new C0429bh0();
                    c0429bh0.a = objInvoke;
                    declaredField.set(null, Proxy.newProxyInstance(classLoader, new Class[]{cls2}, c0429bh0));
                }
            } catch (Exception e) {
                Log.w("cr_FontWorkaround", "Installing workaround failed, continuing without", e);
            }
        }
        C0410bQ0 c0410bQ0 = C0410bQ0.f;
        c0410bQ0.getClass();
        AbstractC1499tM.a.registerComponentCallbacks(new ComponentCallbacks2C0352aQ0(c0410bQ0));
        d().b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.w;
        return resources != null ? resources : getBaseContext().getResources();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d().a();
    }

    @Override // android.app.Application
    public final void onCreate() {
        c("chrome");
        f();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        d().c(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }
}
