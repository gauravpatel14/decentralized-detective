package defpackage;

import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FA1 {
    public static int a(ms1 ms1Var, A51 a51, View view, View view2, AbstractC0306Yr1 abstractC0306Yr1, boolean z) {
        if (abstractC0306Yr1.v() == 0 || ms1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(AbstractC0306Yr1.I(view) - AbstractC0306Yr1.I(view2)) + 1;
        }
        return Math.min(a51.k(), a51.b(view2) - a51.e(view));
    }

    public static int b(ms1 ms1Var, A51 a51, View view, View view2, AbstractC0306Yr1 abstractC0306Yr1, boolean z, boolean z2) {
        if (abstractC0306Yr1.v() == 0 || ms1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (ms1Var.b() - Math.max(AbstractC0306Yr1.I(view), AbstractC0306Yr1.I(view2))) - 1) : Math.max(0, Math.min(AbstractC0306Yr1.I(view), AbstractC0306Yr1.I(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(a51.b(view2) - a51.e(view)) / (Math.abs(AbstractC0306Yr1.I(view) - AbstractC0306Yr1.I(view2)) + 1))) + (a51.j() - a51.e(view)));
        }
        return iMax;
    }

    public static int c(ms1 ms1Var, A51 a51, View view, View view2, AbstractC0306Yr1 abstractC0306Yr1, boolean z) {
        if (abstractC0306Yr1.v() == 0 || ms1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return ms1Var.b();
        }
        return (int) (((a51.b(view2) - a51.e(view)) / (Math.abs(AbstractC0306Yr1.I(view) - AbstractC0306Yr1.I(view2)) + 1)) * ms1Var.b());
    }
}
