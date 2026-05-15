package org.chromium.components.crash.browser;

import android.util.Log;
import defpackage.InterfaceC0881jA;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChildProcessCrashObserver {
    public static InterfaceC0881jA a;

    public static void childCrashed(int i) {
        InterfaceC0881jA interfaceC0881jA = a;
        if (interfaceC0881jA == null) {
            Log.w("cr_ChildCrashObserver", "Ignoring crash observed before a callback was registered...");
        } else {
            interfaceC0881jA.d(i);
        }
    }
}
