package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VT2 {
    public final HashMap a = new HashMap();

    public final void a(String str, String str2, String str3) {
        HashMap map = this.a;
        if (!map.containsKey(str2)) {
            map.put(str2, new HashMap());
        }
        ((Map) map.get(str2)).put(str, str3);
    }

    public final C1032lW2 b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            map.put((String) entry.getKey(), Collections.unmodifiableMap(new HashMap((Map) entry.getValue())));
        }
        return new C1032lW2(Collections.unmodifiableMap(map));
    }
}
