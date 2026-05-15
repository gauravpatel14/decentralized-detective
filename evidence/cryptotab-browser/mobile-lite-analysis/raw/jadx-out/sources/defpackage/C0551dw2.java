package defpackage;

import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: renamed from: dw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0551dw2 extends AbstractC0676fw2 {
    public final WindowInsetsController a;

    public C0551dw2(Window window, YL1 yl1) {
        this.a = window.getInsetsController();
    }

    @Override // defpackage.AbstractC0676fw2
    public final int a() {
        return this.a.getSystemBarsBehavior();
    }

    @Override // defpackage.AbstractC0676fw2
    public final void b(int i) {
        this.a.hide(i & (-9));
    }

    @Override // defpackage.AbstractC0676fw2
    public final void c(int i) {
        this.a.setSystemBarsBehavior(i);
    }

    @Override // defpackage.AbstractC0676fw2
    public final void d(int i) {
        this.a.show(i & (-9));
    }
}
