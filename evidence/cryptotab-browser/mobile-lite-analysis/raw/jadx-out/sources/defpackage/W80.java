package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class W80 extends p0 {
    public final /* synthetic */ X80 u;

    public W80(X80 x80) {
        this.u = x80;
    }

    @Override // defpackage.p0
    public final AccessibilityNodeInfoCompat j(int i) {
        return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(this.u.l(i).a));
    }

    @Override // defpackage.p0
    public final AccessibilityNodeInfoCompat l(int i) {
        X80 x80 = this.u;
        int i2 = i == 2 ? x80.k : x80.l;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return j(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // defpackage.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            X80 r0 = r6.u
            android.view.View r1 = r0.i
            r2 = -1
            if (r7 == r2) goto L8a
            r9 = 8
            r2 = 1
            r3 = 0
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r8 == r2) goto L68
            r5 = 2
            if (r8 == r5) goto L5d
            r9 = 64
            r5 = 65536(0x10000, float:9.1835E-41)
            if (r8 == r9) goto L32
            r9 = 128(0x80, float:1.8E-43)
            if (r8 == r9) goto L22
            boolean r7 = r0.m(r7, r8)
            goto L8e
        L22:
            int r8 = r0.k
            if (r8 != r7) goto L2f
            r0.k = r4
            r1.invalidate()
            r0.p(r7, r5)
            goto L30
        L2f:
            r2 = r3
        L30:
            r7 = r2
            goto L8e
        L32:
            android.view.accessibility.AccessibilityManager r8 = r0.h
            boolean r9 = r8.isEnabled()
            if (r9 == 0) goto L2f
            boolean r8 = r8.isTouchExplorationEnabled()
            if (r8 != 0) goto L41
            goto L2f
        L41:
            int r8 = r0.k
            if (r8 == r7) goto L2f
            if (r8 == r4) goto L51
            r0.k = r4
            android.view.View r9 = r0.i
            r9.invalidate()
            r0.p(r8, r5)
        L51:
            r0.k = r7
            r1.invalidate()
            r8 = 32768(0x8000, float:4.5918E-41)
            r0.p(r7, r8)
            goto L30
        L5d:
            int r8 = r0.l
            if (r8 == r7) goto L62
            goto L2f
        L62:
            r0.l = r4
            r0.p(r7, r9)
            goto L30
        L68:
            boolean r8 = r1.isFocused()
            if (r8 != 0) goto L75
            boolean r8 = r1.requestFocus()
            if (r8 != 0) goto L75
        L74:
            goto L2f
        L75:
            int r8 = r0.l
            if (r8 != r7) goto L7a
            goto L74
        L7a:
            if (r8 == r4) goto L81
            r0.l = r4
            r0.p(r8, r9)
        L81:
            if (r7 != r4) goto L84
            goto L74
        L84:
            r0.l = r7
            r0.p(r7, r9)
            goto L30
        L8a:
            boolean r7 = r1.performAccessibilityAction(r8, r9)
        L8e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.W80.n(int, int, android.os.Bundle):boolean");
    }
}
