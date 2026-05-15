package defpackage;

import android.media.VolumeProvider;
import android.os.Build;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Yl0 {
    public final int a;
    public final int b;
    public final String c;
    public int d;
    public VolumeProvider e;
    public final /* synthetic */ Zl0 f;

    public Yl0(Zl0 zl0, int i, int i2, int i3, String str) {
        this.f = zl0;
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = str;
    }

    public final VolumeProvider a() {
        if (this.e == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.e = new C1640vq2(this, this.a, this.b, this.d, this.c);
            } else {
                this.e = new C1698wq2(this, this.a, this.b, this.d);
            }
        }
        return this.e;
    }
}
