package defpackage;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Fy {
    public int a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fy)) {
            return false;
        }
        Fy fy = (Fy) obj;
        fy.getClass();
        return this.a == fy.a;
    }

    public final int hashCode() {
        return Objects.hashCode(0, Integer.valueOf(this.a), 0, 0, 0, Boolean.FALSE);
    }
}
