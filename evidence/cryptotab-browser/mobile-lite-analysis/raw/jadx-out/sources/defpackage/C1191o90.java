package defpackage;

import java.util.Collections;

/* JADX INFO: renamed from: o90, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1191o90 {
    public static volatile C1191o90 a;
    public static final C1191o90 b;

    static {
        C1191o90 c1191o90 = new C1191o90();
        Collections.emptyMap();
        b = c1191o90;
    }

    public static C1191o90 a() {
        C1191o90 c1191o90 = a;
        if (c1191o90 == null) {
            synchronized (C1191o90.class) {
                try {
                    c1191o90 = a;
                    if (c1191o90 == null) {
                        Class cls = n90.a;
                        C1191o90 c1191o902 = null;
                        if (cls != null) {
                            try {
                                c1191o902 = (C1191o90) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                            } catch (Exception unused) {
                            }
                        }
                        if (c1191o902 == null) {
                            c1191o902 = b;
                        }
                        a = c1191o902;
                        c1191o90 = c1191o902;
                    }
                } finally {
                }
            }
        }
        return c1191o90;
    }
}
