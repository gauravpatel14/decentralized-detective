package org.chromium.base;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.Bv;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BuildInfo {
    public static ApplicationInfo q;
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final int p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BuildInfo() {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.base.BuildInfo.<init>():void");
    }

    public static boolean a() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }

    public static String[] getAll() {
        int i = AbstractC1872zv.a;
        BuildInfo buildInfo = Bv.a;
        buildInfo.getClass();
        String str = Build.BRAND;
        String str2 = Build.DEVICE;
        String str3 = Build.ID;
        String str4 = Build.MANUFACTURER;
        String str5 = Build.MODEL;
        int i2 = Build.VERSION.SDK_INT;
        return new String[]{str, str2, str3, str4, str5, String.valueOf(i2), Build.TYPE, Build.BOARD, buildInfo.a, String.valueOf(buildInfo.c), buildInfo.b, buildInfo.d, String.valueOf(buildInfo.e), buildInfo.f, buildInfo.j, buildInfo.h, buildInfo.g, buildInfo.i, buildInfo.k, buildInfo.l, String.valueOf(AbstractC1499tM.a.getApplicationInfo().targetSdkVersion), a() ? "1" : "0", buildInfo.m ? "1" : "0", Build.VERSION.INCREMENTAL, Build.HARDWARE, i2 >= 33 ? "1" : "0", buildInfo.n ? "1" : "0", i2 >= 34 ? "1" : "0", AbstractC1499tM.a.getApplicationInfo().targetSdkVersion >= 34 ? "1" : "0", Build.VERSION.CODENAME, String.valueOf(buildInfo.p), buildInfo.o ? "1" : "0", i2 >= 31 ? Build.SOC_MANUFACTURER : "", (AbstractC1499tM.a.getApplicationInfo().flags & 2) != 0 ? "1" : "0"};
    }
}
