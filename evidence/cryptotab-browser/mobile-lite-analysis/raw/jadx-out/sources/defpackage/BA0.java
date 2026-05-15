package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BA0 {
    public static final BA0 b = new BA0(1);
    public static final BA0 c = new BA0(3);
    public static final BA0 d = new BA0(9);
    public final int a;

    public BA0(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof BA0) && this.a == ((BA0) obj).a;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), -1L);
    }
}
