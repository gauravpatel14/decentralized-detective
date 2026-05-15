package defpackage;

import org.chromium.ui.base.DeviceFormFactor;

/* JADX INFO: renamed from: jY, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0907jY {
    public static void a() {
        LP1 lp1C = LP1.c();
        try {
            if (!DeviceFormFactor.isTablet()) {
                CH.c().a("use-mobile-user-agent");
            }
            lp1C.close();
        } catch (Throwable th) {
            try {
                lp1C.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
