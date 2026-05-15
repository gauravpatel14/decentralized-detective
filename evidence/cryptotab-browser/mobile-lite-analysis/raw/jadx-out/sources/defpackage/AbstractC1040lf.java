package defpackage;

import java.util.ConcurrentModificationException;

/* JADX INFO: renamed from: lf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1040lf {
    public static final int a(C0978kf c0978kf, Object obj, int i) {
        int i2 = c0978kf.v;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = AbstractC0699gL.a(i2, i, c0978kf.t);
            if (iA < 0 || lz0.a(obj, c0978kf.u[iA])) {
                return iA;
            }
            int i3 = iA + 1;
            while (i3 < i2 && c0978kf.t[i3] == i) {
                if (lz0.a(obj, c0978kf.u[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iA - 1; i4 >= 0 && c0978kf.t[i4] == i; i4--) {
                if (lz0.a(obj, c0978kf.u[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
