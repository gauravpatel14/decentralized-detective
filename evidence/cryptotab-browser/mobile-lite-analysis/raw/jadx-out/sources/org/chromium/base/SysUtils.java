package org.chromium.base;

import android.app.ActivityManager;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.CH;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SysUtils {
    public static Boolean a;
    public static Integer b;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        r4.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int amountOfPhysicalMemoryKB() {
        /*
            java.lang.Integer r0 = org.chromium.base.SysUtils.b
            if (r0 != 0) goto Lb4
            java.lang.String r0 = "cr_"
            java.lang.String r1 = "SysUtils"
            java.lang.String r2 = "^MemTotal:\\s+([0-9]+) kB$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            android.os.StrictMode$ThreadPolicy r3 = android.os.StrictMode.allowThreadDiskReads()
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.lang.String r5 = "/proc/meminfo"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L82
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L82
        L1e:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L36
            if (r6 != 0) goto L38
            java.lang.String r2 = "/proc/meminfo lacks a MemTotal entry?"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L36
            r6.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L36
            android.util.Log.w(r6, r2)     // Catch: java.lang.Throwable -> L36
            goto L74
        L36:
            r2 = move-exception
            goto L8e
        L38:
            java.util.regex.Matcher r6 = r2.matcher(r6)     // Catch: java.lang.Throwable -> L36
            boolean r7 = r6.find()     // Catch: java.lang.Throwable -> L36
            if (r7 != 0) goto L43
            goto L1e
        L43:
            r2 = 1
            java.lang.String r7 = r6.group(r2)     // Catch: java.lang.Throwable -> L36
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L36
            r8 = 1024(0x400, float:1.435E-42)
            if (r7 > r8) goto L84
            java.lang.String r2 = r6.group(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r6.<init>()     // Catch: java.lang.Throwable -> L36
            java.lang.String r7 = "Invalid /proc/meminfo total size in kB: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L36
            r6.append(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L36
            r6.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L36
            android.util.Log.w(r6, r2)     // Catch: java.lang.Throwable -> L36
        L74:
            r5.close()     // Catch: java.lang.Throwable -> L82
            r4.close()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
        L7a:
            android.os.StrictMode.setThreadPolicy(r3)
            goto La8
        L7e:
            r0 = move-exception
            goto Lb0
        L80:
            r2 = move-exception
            goto L96
        L82:
            r2 = move-exception
            goto L92
        L84:
            r5.close()     // Catch: java.lang.Throwable -> L82
            r4.close()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
            android.os.StrictMode.setThreadPolicy(r3)
            goto La9
        L8e:
            r5.close()     // Catch: java.lang.Throwable -> L91
        L91:
            throw r2     // Catch: java.lang.Throwable -> L82
        L92:
            r4.close()     // Catch: java.lang.Throwable -> L95
        L95:
            throw r2     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L80
        L96:
            java.lang.String r4 = "Cannot get total physical size from /proc/meminfo"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L7e
            r5.append(r1)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L7e
            android.util.Log.w(r0, r4, r2)     // Catch: java.lang.Throwable -> L7e
            goto L7a
        La8:
            r7 = 0
        La9:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            org.chromium.base.SysUtils.b = r0
            goto Lb4
        Lb0:
            android.os.StrictMode.setThreadPolicy(r3)
            throw r0
        Lb4:
            java.lang.Integer r0 = org.chromium.base.SysUtils.b
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.base.SysUtils.amountOfPhysicalMemoryKB():int");
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager activityManager = (ActivityManager) AbstractC1499tM.a.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isLowEndDevice() {
        int iAmountOfPhysicalMemoryKB;
        if (a != null) {
            int i = AbstractC1872zv.a;
        } else {
            boolean z = true;
            if (!CH.c().e("enable-low-end-device-mode") && (CH.c().e("disable-low-end-device-mode") || (iAmountOfPhysicalMemoryKB = amountOfPhysicalMemoryKB()) <= 0 || iAmountOfPhysicalMemoryKB / 1024 > 1024)) {
                z = false;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }
}
