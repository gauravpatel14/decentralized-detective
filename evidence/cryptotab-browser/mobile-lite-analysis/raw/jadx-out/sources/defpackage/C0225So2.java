package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: renamed from: So2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0225So2 extends W {
    public final /* synthetic */ ViewPager d;

    public C0225So2(ViewPager viewPager) {
        this.d = viewPager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // defpackage.W
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            super.c(r3, r4)
            java.lang.String r3 = "androidx.viewpager.widget.ViewPager"
            r4.setClassName(r3)
            androidx.viewpager.widget.ViewPager r3 = r2.d
            y81 r0 = r3.x
            if (r0 == 0) goto L16
            int r0 = r0.c()
            r1 = 1
            if (r0 <= r1) goto L16
            goto L17
        L16:
            r1 = 0
        L17:
            r4.setScrollable(r1)
            int r0 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 != r1) goto L37
            y81 r0 = r3.x
            if (r0 == 0) goto L37
            int r0 = r0.c()
            r4.setItemCount(r0)
            int r0 = r3.y
            r4.setFromIndex(r0)
            int r3 = r3.y
            r4.setToIndex(r3)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0225So2.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // defpackage.W
    public final void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.a);
        accessibilityNodeInfoCompat.k("androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = this.d;
        y81 y81Var = viewPager.x;
        accessibilityNodeInfoCompat.m(y81Var != null && y81Var.c() > 1);
        if (viewPager.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.a(4096);
        }
        if (viewPager.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.a(8192);
        }
    }

    @Override // defpackage.W
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        ViewPager viewPager = this.d;
        if (i == 4096) {
            if (!viewPager.canScrollHorizontally(1)) {
                return false;
            }
            viewPager.w(viewPager.y + 1);
            return true;
        }
        if (i != 8192 || !viewPager.canScrollHorizontally(-1)) {
            return false;
        }
        viewPager.w(viewPager.y - 1);
        return true;
    }
}
