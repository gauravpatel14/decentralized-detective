package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class T extends ClickableSpan {
    public final int t;
    public final AccessibilityNodeInfoCompat u;
    public final int v;

    public T(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i, int i2) {
        this.t = i;
        this.u = accessibilityNodeInfoCompat;
        this.v = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.t);
        this.u.a.performAction(this.v, bundle);
    }
}
