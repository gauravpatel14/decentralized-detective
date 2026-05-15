package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class rs1 extends W {
    public final RecyclerView d;
    public final C1351qs1 e;

    public rs1(RecyclerView recyclerView) {
        this.d = recyclerView;
        W wJ = j();
        if (wJ == null || !(wJ instanceof C1351qs1)) {
            this.e = new C1351qs1(this);
        } else {
            this.e = (C1351qs1) wJ;
        }
    }

    @Override // defpackage.W
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        AbstractC0306Yr1 abstractC0306Yr1;
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.d.S() || (abstractC0306Yr1 = ((RecyclerView) view).G) == null) {
            return;
        }
        abstractC0306Yr1.W(accessibilityEvent);
    }

    @Override // defpackage.W
    public final void d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AbstractC0306Yr1 abstractC0306Yr1;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.a);
        RecyclerView recyclerView = this.d;
        if (recyclerView.S() || (abstractC0306Yr1 = recyclerView.G) == null) {
            return;
        }
        RecyclerView recyclerView2 = abstractC0306Yr1.b;
        abstractC0306Yr1.X(recyclerView2.v, recyclerView2.B0, accessibilityNodeInfoCompat);
    }

    @Override // defpackage.W
    public final boolean g(View view, int i, Bundle bundle) {
        AbstractC0306Yr1 abstractC0306Yr1;
        if (super.g(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.d;
        if (recyclerView.S() || (abstractC0306Yr1 = recyclerView.G) == null) {
            return false;
        }
        return abstractC0306Yr1.k0(i, bundle);
    }

    public W j() {
        return this.e;
    }
}
