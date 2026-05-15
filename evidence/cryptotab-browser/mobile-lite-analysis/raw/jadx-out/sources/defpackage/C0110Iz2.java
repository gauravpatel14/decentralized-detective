package defpackage;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: renamed from: Iz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0110Iz2 {
    public final Uri a;

    public C0110Iz2(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0110Iz2) {
            return Objects.equal(((C0110Iz2) obj).a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }
}
