package defpackage;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: nC1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1130nC1 {
    public Method a;
    public Method b;
    public Method c;

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
