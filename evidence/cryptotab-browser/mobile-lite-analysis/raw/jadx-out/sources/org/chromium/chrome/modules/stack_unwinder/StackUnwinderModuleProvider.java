package org.chromium.chrome.modules.stack_unwinder;

import defpackage.C0975ka2;
import defpackage.FN1;
import defpackage.GN1;
import defpackage.tU0;
import defpackage.xU0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class StackUnwinderModuleProvider {
    public static void ensureNativeLoaded() {
        FN1.a.a();
    }

    public static long getCreateLibunwindstackUnwinderFunction() {
        return ((GN1) FN1.a.b()).b();
    }

    public static long getCreateMemoryRegionsMapFunction() {
        return ((GN1) FN1.a.b()).c();
    }

    public static long getCreateNativeUnwinderFunction() {
        return ((GN1) FN1.a.b()).a();
    }

    public static void installModule() {
        tU0 tu0 = FN1.a;
        C0975ka2 c0975ka2 = new C0975ka2();
        try {
            ((xU0) tu0.c()).c();
            c0975ka2.close();
        } catch (Throwable th) {
            try {
                c0975ka2.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public static boolean isModuleInstalled() {
        return FN1.a.g();
    }
}
