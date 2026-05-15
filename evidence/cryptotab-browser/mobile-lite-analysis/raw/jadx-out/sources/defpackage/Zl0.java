package defpackage;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zl0 {
    public final CP0 a;
    public Yl0 b;
    public final /* synthetic */ bm0 c;

    public Zl0(bm0 bm0Var, CP0 cp0) {
        this.c = bm0Var;
        this.a = cp0;
    }

    public final void a() {
        CP0 cp0 = this.a;
        if (cp0 != null) {
            int i = this.c.l.d;
            wP0 wp0 = cp0.a;
            wp0.getClass();
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i);
            wp0.a.setPlaybackToLocal(builder.build());
            this.b = null;
        }
    }
}
