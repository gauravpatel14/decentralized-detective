package defpackage;

import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Kb implements Runnable {
    public final /* synthetic */ TextView t;
    public final /* synthetic */ Typeface u;
    public final /* synthetic */ int v;

    public Kb(TextView textView, Typeface typeface, int i) {
        this.t = textView;
        this.u = typeface;
        this.v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.setTypeface(this.u, this.v);
    }
}
