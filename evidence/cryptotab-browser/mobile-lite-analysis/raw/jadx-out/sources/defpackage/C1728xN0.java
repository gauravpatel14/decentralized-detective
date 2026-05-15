package defpackage;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: renamed from: xN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1728xN0 {
    public static final YL2 e = new YL2("MediaLiveSeekableRange");
    public final long a;
    public final long b;
    public final boolean c;
    public final boolean d;

    public C1728xN0(long j, long j2, boolean z, boolean z2) {
        this.a = Math.max(j, 0L);
        this.b = Math.max(j2, 0L);
        this.c = z;
        this.d = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1728xN0)) {
            return false;
        }
        C1728xN0 c1728xN0 = (C1728xN0) obj;
        return this.a == c1728xN0.a && this.b == c1728xN0.b && this.c == c1728xN0.c && this.d == c1728xN0.d;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Long.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
