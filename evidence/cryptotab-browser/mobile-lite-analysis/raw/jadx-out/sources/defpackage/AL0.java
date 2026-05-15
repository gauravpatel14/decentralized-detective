package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AL0 {
    public static C1667wL0 a(Object obj) {
        return ((C1725xL0) obj).a;
    }

    public static C1778yL0 b(Object obj) {
        return (C1778yL0) obj;
    }

    public static int c(int i, Object obj, Object obj2) {
        C1778yL0 c1778yL0 = (C1778yL0) obj;
        C1725xL0 c1725xL0 = (C1725xL0) obj2;
        int iA = 0;
        if (!c1778yL0.isEmpty()) {
            for (Map.Entry entry : c1778yL0.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                c1725xL0.getClass();
                int iT = CG.t(i);
                int iA2 = C1725xL0.a(c1725xL0.a, key, value);
                iA = AbstractC1835zL0.a(iA2, iA2, iT, iA);
            }
        }
        return iA;
    }

    public static boolean d(Object obj) {
        return !((C1778yL0) obj).t;
    }

    public static C1778yL0 e(Object obj, Object obj2) {
        C1778yL0 c1778yL0C = (C1778yL0) obj;
        C1778yL0 c1778yL0 = (C1778yL0) obj2;
        if (!c1778yL0.isEmpty()) {
            if (!c1778yL0C.t) {
                c1778yL0C = c1778yL0C.c();
            }
            c1778yL0C.b();
            if (!c1778yL0.isEmpty()) {
                c1778yL0C.putAll(c1778yL0);
            }
        }
        return c1778yL0C;
    }

    public static C1778yL0 f() {
        return C1778yL0.u.c();
    }
}
