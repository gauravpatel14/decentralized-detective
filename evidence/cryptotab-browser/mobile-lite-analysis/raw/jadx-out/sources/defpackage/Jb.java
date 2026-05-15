package defpackage;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Jb extends jv1 {
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ WeakReference f;
    public final /* synthetic */ Mb g;

    public Jb(Mb mb, int i, int i2, WeakReference weakReference) {
        this.g = mb;
        this.d = i;
        this.e = i2;
        this.f = weakReference;
    }

    @Override // defpackage.jv1
    public final void c(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.d) != -1) {
            typeface = Lb.a(typeface, i, (this.e & 2) != 0);
        }
        Mb mb = this.g;
        if (mb.m) {
            mb.k = typeface;
            TextView textView = (TextView) this.f.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new Kb(textView, typeface, mb.i));
                } else {
                    textView.setTypeface(typeface, mb.i);
                }
            }
        }
    }

    @Override // defpackage.jv1
    public final void b(int i) {
    }
}
