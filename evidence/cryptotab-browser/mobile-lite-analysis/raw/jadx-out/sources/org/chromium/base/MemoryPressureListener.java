package org.chromium.base;

import defpackage.M21;
import defpackage.XP0;
import defpackage.YP0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MemoryPressureListener {
    public static M21 a;

    public static void a(XP0 xp0) {
        if (a == null) {
            a = new M21();
        }
        a.e(xp0);
    }

    public static void addNativeCallback() {
        a(new YP0());
    }
}
