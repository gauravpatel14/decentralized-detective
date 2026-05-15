package defpackage;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kz0 {
    public static final PathInterpolator a = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    public static final DecelerateInterpolator b;
    public static final InterpolatorC0659fb0 c;
    public static final PathInterpolator d;
    public static final PathInterpolator e;
    public static final InterpolatorC0723gb0 f;
    public static final InterpolatorC0789hb0 g;
    public static final InterpolatorC1826zF0 h;
    public static final LinearInterpolator i;

    static {
        new AccelerateInterpolator();
        b = new DecelerateInterpolator();
        c = new InterpolatorC0659fb0();
        d = new PathInterpolator(0.3f, 0.0f, 0.8f, 0.15f);
        e = new PathInterpolator(0.05f, 0.7f, 0.1f, 1.0f);
        f = new InterpolatorC0723gb0();
        g = new InterpolatorC0789hb0();
        h = new InterpolatorC1826zF0();
        i = new LinearInterpolator();
        new OvershootInterpolator();
    }
}
