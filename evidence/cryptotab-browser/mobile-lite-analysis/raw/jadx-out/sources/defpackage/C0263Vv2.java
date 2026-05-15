package defpackage;

import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: renamed from: Vv2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C0263Vv2 extends C0241Tv2 {
    @Override // defpackage.C0307Yv2
    public final C0383aw2 a() {
        return C0383aw2.g(null, this.c.consumeDisplayCutout());
    }

    @Override // defpackage.C0307Yv2
    public final v00 e() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new v00(displayCutout);
    }

    @Override // defpackage.C0241Tv2, defpackage.C0307Yv2
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0263Vv2)) {
            return false;
        }
        C0263Vv2 c0263Vv2 = (C0263Vv2) obj;
        return Objects.equals(this.c, c0263Vv2.c) && Objects.equals(this.g, c0263Vv2.g);
    }

    @Override // defpackage.C0307Yv2
    public final int hashCode() {
        return this.c.hashCode();
    }
}
