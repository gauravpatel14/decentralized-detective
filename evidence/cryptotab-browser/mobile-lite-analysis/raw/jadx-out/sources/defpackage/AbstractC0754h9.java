package defpackage;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: h9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0754h9 {
    public C0685g9 a;

    public final Animatable2.AnimationCallback a() {
        if (this.a == null) {
            this.a = new C0685g9(this);
        }
        return this.a;
    }

    public abstract void b(Drawable drawable);

    public void c(Drawable drawable) {
    }
}
