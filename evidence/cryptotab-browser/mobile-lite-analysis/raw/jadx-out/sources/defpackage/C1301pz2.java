package defpackage;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: renamed from: pz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1301pz2 {
    public final ApiKey a;
    public final Feature b;

    public /* synthetic */ C1301pz2(ApiKey apiKey, Feature feature) {
        this.a = apiKey;
        this.b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1301pz2)) {
            C1301pz2 c1301pz2 = (C1301pz2) obj;
            if (Objects.equal(this.a, c1301pz2.a) && Objects.equal(this.b, c1301pz2.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, this.b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.a).add("feature", this.b).toString();
    }
}
