package defpackage;

import android.view.MotionEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class s80 {
    public final r80 a;

    public s80(r80 r80Var) {
        this.a = r80Var;
    }

    public final void a(int i) {
        if (i == 6 || i == 4 || i == 3) {
            r80 r80Var = this.a;
            r80Var.b(0.0f);
            r80Var.c(0.0f, 0.0f);
        }
    }

    public final void b(MotionEvent motionEvent, boolean z) {
        int iA = AbstractC1704wx1.a(motionEvent.getActionMasked());
        r80 r80Var = this.a;
        if (iA == 0 || iA == 9 || iA == 7) {
            r80Var.b(-r80Var.a());
            return;
        }
        if (z) {
            if (iA == 1 || iA == 3 || iA == 10) {
                r80Var.b(0.0f);
            }
        }
    }
}
