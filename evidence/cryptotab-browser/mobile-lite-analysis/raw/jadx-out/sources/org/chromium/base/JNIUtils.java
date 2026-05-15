package org.chromium.base;

import android.util.Log;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class JNIUtils {
    public static ClassLoader a;

    public static ClassLoader getSplitClassLoader(String str) {
        if (!str.isEmpty()) {
            boolean zF = BundleUtils.f(str);
            Log.i("cr_JNIUtils", "Init JNI Classloader for " + str + ". isInstalled=" + zF);
            if (zF) {
                return BundleUtils.b(str);
            }
        }
        ClassLoader classLoader = a;
        return classLoader != null ? classLoader : JNIUtils.class.getClassLoader();
    }
}
