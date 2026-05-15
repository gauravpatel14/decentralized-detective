package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LX0 extends W {
    @Override // defpackage.W
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        accessibilityEvent.setScrollable(nestedScrollView.l() > 0);
        accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
        accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setMaxScrollY(nestedScrollView.l());
    }

    @Override // defpackage.W
    public final void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int iL;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.a);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityNodeInfoCompat.k(ScrollView.class.getName());
        if (!nestedScrollView.isEnabled() || (iL = nestedScrollView.l()) <= 0) {
            return;
        }
        accessibilityNodeInfoCompat.m(true);
        if (nestedScrollView.getScrollY() > 0) {
            accessibilityNodeInfoCompat.b(C0814i0.p);
            accessibilityNodeInfoCompat.b(C0814i0.z);
        }
        if (nestedScrollView.getScrollY() < iL) {
            accessibilityNodeInfoCompat.b(C0814i0.o);
            accessibilityNodeInfoCompat.b(C0814i0.B);
        }
    }

    @Override // defpackage.W
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int height = nestedScrollView.getHeight();
        Rect rect = new Rect();
        if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
            height = rect.height();
        }
        if (i != 4096) {
            if (i == 8192 || i == 16908344) {
                int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (iMax == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.w(0 - nestedScrollView.getScrollX(), true, iMax - nestedScrollView.getScrollY());
                return true;
            }
            if (i != 16908346) {
                return false;
            }
        }
        int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.l());
        if (iMin == nestedScrollView.getScrollY()) {
            return false;
        }
        nestedScrollView.w(0 - nestedScrollView.getScrollX(), true, iMin - nestedScrollView.getScrollY());
        return true;
    }
}
