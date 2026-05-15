package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: iI2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0830iI2 {
    public static final C0830iI2 c;
    public final Integer a;
    public final Map b;

    static {
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap());
        if (mapUnmodifiableMap == null) {
            throw new NullPointerException("Null splitInstallErrorCodeByModule");
        }
        c = new C0830iI2(null, mapUnmodifiableMap);
    }

    public C0830iI2(Integer num, Map map) {
        this.a = num;
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0830iI2) {
            C0830iI2 c0830iI2 = (C0830iI2) obj;
            Integer num = this.a;
            if (num != null ? num.equals(c0830iI2.a) : c0830iI2.a == null) {
                if (this.b.equals(c0830iI2.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.a;
        return (((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "LocalTestingConfig{defaultSplitInstallErrorCode=" + this.a + ", splitInstallErrorCodeByModule=" + String.valueOf(this.b) + "}";
    }
}
