package defpackage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VN0 {
    public int a;
    public String b;
    public ArrayList c;
    public ArrayList d;
    public double e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VN0)) {
            return false;
        }
        VN0 vn0 = (VN0) obj;
        return this.a == vn0.a && TextUtils.equals(this.b, vn0.b) && Objects.equal(this.c, vn0.c) && Objects.equal(this.d, vn0.d) && this.e == vn0.e;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.a), this.b, this.c, this.d, Double.valueOf(this.e));
    }
}
