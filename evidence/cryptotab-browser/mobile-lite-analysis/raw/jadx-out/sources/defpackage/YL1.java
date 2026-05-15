package defpackage;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YL1 {
    public final UL1 a;

    public YL1(View view) {
        if (Build.VERSION.SDK_INT < 30) {
            this.a = new UL1(view);
            return;
        }
        XL1 xl1 = new XL1(view);
        xl1.b = view;
        this.a = xl1;
    }
}
