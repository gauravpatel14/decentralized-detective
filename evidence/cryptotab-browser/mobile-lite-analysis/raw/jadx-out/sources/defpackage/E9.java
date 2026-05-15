package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E9 extends AbstractC0754h9 {
    public final /* synthetic */ F9 b;

    public E9(F9 f9) {
        this.b = f9;
    }

    @Override // defpackage.AbstractC0754h9
    public final void b(Drawable drawable) {
        F9 f9 = this.b;
        Handler handler = f9.a;
        final Animatable animatable = f9.b;
        Objects.requireNonNull(animatable);
        handler.post(new Runnable() { // from class: D9
            @Override // java.lang.Runnable
            public final void run() {
                animatable.start();
            }
        });
    }
}
