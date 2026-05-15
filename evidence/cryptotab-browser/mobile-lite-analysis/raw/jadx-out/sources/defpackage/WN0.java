package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WN0 {
    public String a;
    public String b;
    public int c;
    public String d;
    public VN0 e;
    public int f;
    public ArrayList g;
    public int h;
    public long i;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WN0)) {
            return false;
        }
        WN0 wn0 = (WN0) obj;
        return TextUtils.equals(this.a, wn0.a) && TextUtils.equals(this.b, wn0.b) && this.c == wn0.c && TextUtils.equals(this.d, wn0.d) && Objects.equal(this.e, wn0.e) && this.f == wn0.f && Objects.equal(this.g, wn0.g) && this.h == wn0.h && this.i == wn0.i;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b, Integer.valueOf(this.c), this.d, this.e, Integer.valueOf(this.f), this.g, Integer.valueOf(this.h), Long.valueOf(this.i));
    }
}
