package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: qs1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1351qs1 extends W {
    public final rs1 d;
    public final WeakHashMap e = new WeakHashMap();

    public C1351qs1(rs1 rs1Var) {
        this.d = rs1Var;
    }

    @Override // defpackage.W
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        W w = (W) this.e.get(view);
        return w != null ? w.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // defpackage.W
    public final p0 b(View view) {
        W w = (W) this.e.get(view);
        return w != null ? w.b(view) : super.b(view);
    }

    @Override // defpackage.W
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        W w = (W) this.e.get(view);
        if (w != null) {
            w.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // defpackage.W
    public final void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AbstractC0306Yr1 abstractC0306Yr1;
        rs1 rs1Var = this.d;
        boolean zS = rs1Var.d.S();
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.a;
        if (zS || (abstractC0306Yr1 = rs1Var.d.G) == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        abstractC0306Yr1.Z(view, accessibilityNodeInfoCompat);
        W w = (W) this.e.get(view);
        if (w != null) {
            w.d(view, accessibilityNodeInfoCompat);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // defpackage.W
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        W w = (W) this.e.get(view);
        if (w != null) {
            w.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // defpackage.W
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        W w = (W) this.e.get(viewGroup);
        return w != null ? w.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // defpackage.W
    public final boolean g(View view, int i, Bundle bundle) {
        rs1 rs1Var = this.d;
        if (!rs1Var.d.S()) {
            RecyclerView recyclerView = rs1Var.d;
            if (recyclerView.G != null) {
                W w = (W) this.e.get(view);
                if (w != null) {
                    if (w.g(view, i, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i, bundle)) {
                    return true;
                }
                C0738gs1 c0738gs1 = recyclerView.G.b.v;
                return false;
            }
        }
        return super.g(view, i, bundle);
    }

    @Override // defpackage.W
    public final void h(View view, int i) {
        W w = (W) this.e.get(view);
        if (w != null) {
            w.h(view, i);
        } else {
            super.h(view, i);
        }
    }

    @Override // defpackage.W
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        W w = (W) this.e.get(view);
        if (w != null) {
            w.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
