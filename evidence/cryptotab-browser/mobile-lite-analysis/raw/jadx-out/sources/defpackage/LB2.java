package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LB2 {
    public Integer a;
    public Map b;

    public final C0830iI2 a() {
        Map map = this.b;
        if (map == null) {
            throw new IllegalStateException("Property \"splitInstallErrorCodeByModule\" has not been set");
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        if (mapUnmodifiableMap == null) {
            throw new NullPointerException("Null splitInstallErrorCodeByModule");
        }
        this.b = mapUnmodifiableMap;
        return new C0830iI2(this.a, this.b);
    }
}
