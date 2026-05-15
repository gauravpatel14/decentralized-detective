package defpackage;

import java.util.Iterator;
import org.chromium.ui.accessibility.AccessibilityState;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TA implements y0 {
    public static TA u;
    public M21 t;

    public static TA a() {
        if (u == null) {
            TA ta = new TA();
            u = ta;
            AccessibilityState.y.add(ta);
        }
        return u;
    }

    @Override // defpackage.y0
    public final void c(A0 a0) {
        boolean zC = AccessibilityState.c();
        if (this.t == null) {
            this.t = new M21();
        }
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((C0) l21.next()).a(zC);
            }
        }
    }
}
