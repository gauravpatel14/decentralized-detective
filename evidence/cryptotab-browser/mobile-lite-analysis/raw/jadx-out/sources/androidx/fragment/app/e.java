package androidx.fragment.app;

import android.view.View;
import defpackage.AbstractC1214oR1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public final y a;

    public e(y yVar) {
        this.a = yVar;
    }

    public final boolean a() {
        int i;
        y yVar = this.a;
        View view = yVar.c.mView;
        if (view != null) {
            i = 4;
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility == 0) {
                    i = 2;
                } else if (visibility != 4) {
                    if (visibility != 8) {
                        throw new IllegalArgumentException(AbstractC1214oR1.a(visibility, "Unknown visibility "));
                    }
                    i = 3;
                }
            }
        } else {
            i = 0;
        }
        int i2 = yVar.a;
        return i == i2 || !(i == 2 || i2 == 2);
    }
}
