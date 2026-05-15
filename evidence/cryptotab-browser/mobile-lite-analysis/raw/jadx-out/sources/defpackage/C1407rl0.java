package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: rl0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1407rl0 {
    public static C1407rl0 b;
    public final gf a = new gf(0);

    public final synchronized void a(String str, String str2) {
        Map map = (Map) this.a.get(str2);
        if (map != null && map.remove(str) != null && map.isEmpty()) {
            this.a.remove(str2);
        }
    }

    public final synchronized boolean b(String str) {
        return this.a.containsKey(str);
    }

    public final synchronized boolean c(String str, String str2) {
        Map map = (Map) this.a.get(str2);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
