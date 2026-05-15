package defpackage;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: renamed from: rP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1387rP0 {
    public final long a;

    public C1387rP0(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1387rP0) {
            return this.a == ((C1387rP0) obj).a && Objects.equal(null, null);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), 0, Boolean.FALSE, null);
    }
}
