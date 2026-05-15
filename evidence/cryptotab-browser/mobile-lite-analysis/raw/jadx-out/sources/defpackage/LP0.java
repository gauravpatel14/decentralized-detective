package defpackage;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class LP0 {
    public final String a;
    public final int b;
    public final int c;

    public LP0(int i, int i2, String str) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LP0)) {
            return false;
        }
        LP0 lp0 = (LP0) obj;
        int i = this.c;
        String str = this.a;
        int i2 = this.b;
        return (i2 < 0 || lp0.b < 0) ? TextUtils.equals(str, lp0.a) && i == lp0.c : TextUtils.equals(str, lp0.a) && i2 == lp0.b && i == lp0.c;
    }

    public final int hashCode() {
        return Objects.hash(this.a, Integer.valueOf(this.c));
    }
}
