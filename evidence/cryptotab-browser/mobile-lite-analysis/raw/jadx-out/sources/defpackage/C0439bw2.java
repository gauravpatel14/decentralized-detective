package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: bw2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0439bw2 extends AbstractC0676fw2 {
    public final Window a;
    public final YL1 b;

    public C0439bw2(Window window, YL1 yl1) {
        this.a = window;
        this.b = yl1;
    }

    @Override // defpackage.AbstractC0676fw2
    public final int a() {
        return 0;
    }

    @Override // defpackage.AbstractC0676fw2
    public final void b(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                if (i2 == 1) {
                    e(4);
                } else if (i2 == 2) {
                    e(2);
                } else if (i2 == 8) {
                    this.b.a.a();
                }
            }
        }
    }

    @Override // defpackage.AbstractC0676fw2
    public final void c(int i) {
        if (i == 0) {
            f(6144);
            return;
        }
        if (i == 1) {
            f(4096);
            e(2048);
        } else {
            if (i != 2) {
                return;
            }
            f(2048);
            e(4096);
        }
    }

    @Override // defpackage.AbstractC0676fw2
    public final void d(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                if (i2 == 1) {
                    f(4);
                    this.a.clearFlags(1024);
                } else if (i2 == 2) {
                    f(2);
                } else if (i2 == 8) {
                    this.b.a.b();
                }
            }
        }
    }

    public final void e(int i) {
        View decorView = this.a.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void f(int i) {
        View decorView = this.a.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
