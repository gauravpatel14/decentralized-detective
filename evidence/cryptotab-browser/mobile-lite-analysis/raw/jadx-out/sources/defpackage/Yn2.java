package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Yn2 implements View.OnApplyWindowInsetsListener {
    public C0383aw2 t = null;
    public final /* synthetic */ View u;
    public final /* synthetic */ y41 v;

    public Yn2(View view, y41 y41Var) {
        this.u = view;
        this.v = y41Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        C0383aw2 c0383aw2G = C0383aw2.g(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        y41 y41Var = this.v;
        if (i < 30) {
            int i2 = AbstractC0132Lp1.tag_window_insets_animation_callback;
            View view2 = this.u;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(i2);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
            if (c0383aw2G.equals(this.t)) {
                return y41Var.c(view, c0383aw2G).f();
            }
        }
        this.t = c0383aw2G;
        C0383aw2 c0383aw2C = y41Var.c(view, c0383aw2G);
        if (i >= 30) {
            return c0383aw2C.f();
        }
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        view.requestApplyInsets();
        return c0383aw2C.f();
    }
}
