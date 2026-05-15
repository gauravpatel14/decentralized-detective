package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: gw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0742gw2 {
    public final AbstractC0676fw2 a;

    public C0742gw2(Window window, View view) {
        YL1 yl1 = new YL1(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            this.a = new C0610ew2(window, yl1);
        } else if (i >= 30) {
            this.a = new C0551dw2(window, yl1);
        } else {
            this.a = new C0439bw2(window, yl1);
        }
    }

    public final void a(int i) {
        this.a.b(i);
    }
}
