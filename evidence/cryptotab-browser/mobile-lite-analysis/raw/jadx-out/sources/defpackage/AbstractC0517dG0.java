package defpackage;

import java.util.List;

/* JADX INFO: renamed from: dG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0517dG0 {
    public static final boolean a(Object[] objArr, int i, int i2, List list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!lz0.a(objArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final String b(Object[] objArr, int i, int i2, B b) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == b) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static final void c(Object[] objArr, int i, int i2) {
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }
}
