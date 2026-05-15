package defpackage;

import android.content.res.Resources;
import android.os.Build;

/* JADX INFO: renamed from: Xi2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0285Xi2 {
    public static final AbstractC0493cj2 a;
    public static final MJ0 b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new C0372aj2();
        } else if (i >= 28) {
            a = new C0317Zi2();
        } else {
            a = new C0301Yi2();
        }
        b = new MJ0(16);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r15, defpackage.InterfaceC0923jh0 r16, android.content.res.Resources r17, int r18, java.lang.String r19, int r20, int r21, defpackage.jv1 r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0285Xi2.a(android.content.Context, jh0, android.content.res.Resources, int, java.lang.String, int, int, jv1, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
