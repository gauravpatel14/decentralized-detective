package org.chromium.content_public.app;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import defpackage.AbstractC1872zv;
import defpackage.CA;
import defpackage.NE0;
import defpackage.OE0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ZygotePreload implements android.app.ZygotePreload {
    public final void doPreload(ApplicationInfo applicationInfo) {
        int i = AbstractC1872zv.a;
        Log.i("cr_ZygotePreload", "version=128.0.6613.148 (260119) minSdkVersion=26 isBundle=" + Boolean.TRUE);
        try {
            int iMyPid = Process.myPid();
            long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            CA.q = iMyPid;
            CA.r = jCurrentThreadTimeMillis;
            OE0 oe0 = OE0.h;
            NE0 ne0 = oe0.d;
            ne0.c.getClass();
            ne0.c.getClass();
            ne0.b = 1;
            synchronized (oe0.e) {
                oe0.e(applicationInfo, true);
                oe0.b = 2;
                oe0.f = true;
            }
        } catch (Throwable th) {
            Log.w("cr_ZygotePreload", "Exception in zygote", th);
        }
    }
}
