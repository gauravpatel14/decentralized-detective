package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class F9 {
    public final Animatable b;
    public boolean d;
    public final Handler a = new Handler();
    public final E9 c = new E9(this);

    /* JADX WARN: Multi-variable type inference failed */
    public F9(Drawable drawable) {
        this.b = (Animatable) drawable;
    }
}
