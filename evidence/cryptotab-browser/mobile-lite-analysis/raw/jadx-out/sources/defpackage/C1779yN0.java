package defpackage;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.common.internal.Objects;
import java.util.Arrays;

/* JADX INFO: renamed from: yN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1779yN0 {
    public MediaInfo a;
    public Boolean b;
    public long c;
    public double d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1779yN0)) {
            return false;
        }
        C1779yN0 c1779yN0 = (C1779yN0) obj;
        return Objects.equal(this.a, c1779yN0.a) && Objects.equal(null, null) && Objects.equal(this.b, c1779yN0.b) && this.c == c1779yN0.c && this.d == c1779yN0.d && Arrays.equals((long[]) null, (long[]) null) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, null, this.b, Long.valueOf(this.c), Double.valueOf(this.d), null, null, null, null);
    }
}
