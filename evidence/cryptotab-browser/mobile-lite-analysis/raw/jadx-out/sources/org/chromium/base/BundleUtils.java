package org.chromium.base;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.util.ArrayMap;
import dalvik.system.BaseDexClassLoader;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.Fv;
import defpackage.LP1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class BundleUtils {
    public static Boolean a;
    public static final Object b = new Object();
    public static final ArrayMap c = new ArrayMap();
    public static final Map d = Collections.synchronizedMap(new ArrayMap());
    public static Fv e;
    public static ArrayList f;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r0 = r6.getClassLoader().getParent();
        r1 = defpackage.AbstractC1499tM.a;
        r2 = defpackage.AbstractC1872zv.a;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r0.equals(org.chromium.base.BundleUtils.class.getClassLoader()) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r0.equals(r1.getClassLoader()) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r2 = org.chromium.base.BundleUtils.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
    
        if (r0 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        if (r2.containsKey(r7) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        r2.put(r7, new dalvik.system.PathClassLoader(d(r7), r1.getClassLoader()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
    
        r1 = (java.lang.ClassLoader) r2.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        if (r1 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        if (r1.equals(r6.getClassLoader()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        h(r6, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r2.put(r7, r6.getClassLoader());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        defpackage.Gr1.b("Android.IsolatedSplits.ClassLoaderReplaced." + r7, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a6, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a8, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Context a(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = r6
        L1:
            boolean r1 = r0 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L21
            boolean r1 = r0 instanceof android.app.Application
            if (r1 == 0) goto L1a
            LP1 r0 = defpackage.LP1.c()
            android.content.Context r6 = r6.createContextForSplit(r7)     // Catch: java.lang.Throwable -> L15
            r0.close()
            goto L30
        L15:
            r6 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L19
        L19:
            throw r6
        L1a:
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            goto L1
        L21:
            java.lang.Object r0 = org.chromium.base.BundleUtils.b
            monitor-enter(r0)
            LP1 r1 = defpackage.LP1.c()     // Catch: java.lang.Throwable -> La9
            android.content.Context r6 = r6.createContextForSplit(r7)     // Catch: java.lang.Throwable -> Lab
            r1.close()     // Catch: java.lang.Throwable -> La9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
        L30:
            java.lang.ClassLoader r0 = r6.getClassLoader()
            java.lang.ClassLoader r0 = r0.getParent()
            android.content.Context r1 = defpackage.AbstractC1499tM.a
            int r2 = defpackage.AbstractC1872zv.a
            java.lang.Class<org.chromium.base.BundleUtils> r2 = org.chromium.base.BundleUtils.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            boolean r2 = r0.equals(r2)
            r3 = 1
            if (r2 != 0) goto L57
            if (r1 == 0) goto L57
            java.lang.ClassLoader r2 = r1.getClassLoader()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L57
            r0 = r3
            goto L58
        L57:
            r0 = 0
        L58:
            android.util.ArrayMap r2 = org.chromium.base.BundleUtils.c
            monitor-enter(r2)
            if (r0 == 0) goto L76
            boolean r4 = r2.containsKey(r7)     // Catch: java.lang.Throwable -> L74
            if (r4 != 0) goto L76
            java.lang.String r4 = d(r7)     // Catch: java.lang.Throwable -> L74
            dalvik.system.PathClassLoader r5 = new dalvik.system.PathClassLoader     // Catch: java.lang.Throwable -> L74
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L74
            r5.<init>(r4, r1)     // Catch: java.lang.Throwable -> L74
            r2.put(r7, r5)     // Catch: java.lang.Throwable -> L74
            goto L76
        L74:
            r6 = move-exception
            goto La7
        L76:
            java.lang.Object r1 = r2.get(r7)     // Catch: java.lang.Throwable -> L74
            java.lang.ClassLoader r1 = (java.lang.ClassLoader) r1     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L8c
            java.lang.ClassLoader r4 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L74
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> L74
            if (r4 != 0) goto L93
            h(r6, r1)     // Catch: java.lang.Throwable -> L74
            goto L94
        L8c:
            java.lang.ClassLoader r1 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L74
            r2.put(r7, r1)     // Catch: java.lang.Throwable -> L74
        L93:
            r3 = r0
        L94:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Android.IsolatedSplits.ClassLoaderReplaced."
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            defpackage.Gr1.b(r7, r3)
            return r6
        La7:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L74
            throw r6
        La9:
            r6 = move-exception
            goto Lb0
        Lab:
            r6 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> Laf
        Laf:
            throw r6     // Catch: java.lang.Throwable -> La9
        Lb0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.chromium.base.BundleUtils.a(android.content.Context, java.lang.String):android.content.Context");
    }

    public static ClassLoader b(String str) {
        ClassLoader classLoader;
        ArrayMap arrayMap = c;
        synchronized (arrayMap) {
            classLoader = (ClassLoader) arrayMap.get(str);
        }
        if (classLoader == null) {
            a(AbstractC1499tM.a, str);
            synchronized (arrayMap) {
                classLoader = (ClassLoader) arrayMap.get(str);
            }
        }
        return classLoader;
    }

    public static String c(String str, String str2) {
        String strD = d(str2);
        if (strD == null) {
            return null;
        }
        ApplicationInfo applicationInfo = AbstractC1499tM.a.getApplicationInfo();
        return strD + "!/lib/" + ((String) applicationInfo.getClass().getField("primaryCpuAbi").get(applicationInfo)) + "/" + System.mapLibraryName(str);
    }

    public static String d(String str) {
        int iBinarySearch;
        ApplicationInfo applicationInfo = AbstractC1499tM.a.getApplicationInfo();
        String[] strArr = applicationInfo.splitNames;
        if (strArr != null && (iBinarySearch = Arrays.binarySearch(strArr, str)) >= 0) {
            return applicationInfo.splitSourceDirs[iBinarySearch];
        }
        return null;
    }

    public static boolean e() {
        int i = AbstractC1872zv.a;
        return a.booleanValue();
    }

    public static boolean f(String str) {
        return d(str) != null;
    }

    public static Object g(Context context, String str) {
        Context context2 = AbstractC1499tM.a;
        if (context2 != null) {
            try {
                Class.forName(str, false, context2.getClassLoader());
                context = context2;
            } catch (ClassNotFoundException unused) {
            }
        }
        return context.getClassLoader().loadClass(str).newInstance();
    }

    public static String getNativeLibraryPath(String str, String str2) {
        LP1 lp1C = LP1.c();
        try {
            String strFindLibrary = ((BaseDexClassLoader) BundleUtils.class.getClassLoader()).findLibrary(str);
            if (strFindLibrary != null) {
                return strFindLibrary;
            }
            ClassLoader classLoader = AbstractC1499tM.a.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                strFindLibrary = ((BaseDexClassLoader) classLoader).findLibrary(str);
            }
            if (strFindLibrary != null) {
                lp1C.close();
                return strFindLibrary;
            }
            String strC = c(str, str2);
            lp1C.close();
            return strC;
        } finally {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void h(Context context, ClassLoader classLoader) throws IllegalAccessException, NoSuchFieldException {
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        Field declaredField = context.getClass().getDeclaredField("mClassLoader");
        declaredField.setAccessible(true);
        declaredField.set(context, classLoader);
    }

    public static boolean isBundleForNative() {
        return e();
    }
}
