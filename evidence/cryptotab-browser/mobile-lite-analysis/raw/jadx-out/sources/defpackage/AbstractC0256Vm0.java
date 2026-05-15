package defpackage;

import android.util.SparseIntArray;

/* JADX INFO: renamed from: Vm0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0256Vm0 {
    public final SparseIntArray a = new SparseIntArray();
    public final SparseIntArray b = new SparseIntArray();

    public final int a(int i, int i2) {
        int iC = c(i);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int iC2 = c(i5);
            i3 += iC2;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = iC2;
            }
        }
        return i3 + iC > i2 ? i4 + 1 : i4;
    }

    public int b(int i, int i2) {
        int iC = c(i);
        if (iC == i2) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int iC2 = c(i4);
            i3 += iC2;
            if (i3 == i2) {
                i3 = 0;
            } else if (i3 > i2) {
                i3 = iC2;
            }
        }
        if (iC + i3 <= i2) {
            return i3;
        }
        return 0;
    }

    public abstract int c(int i);

    public final void d() {
        this.a.clear();
    }
}
