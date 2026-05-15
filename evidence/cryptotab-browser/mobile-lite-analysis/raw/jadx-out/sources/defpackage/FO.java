package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FO {
    public final LinkedHashMap a = new LinkedHashMap();

    public final boolean equals(Object obj) {
        return (obj instanceof FO) && lz0.a(this.a, ((FO) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.a + ')';
    }
}
