package defpackage;

import java.util.HashMap;

/* JADX INFO: renamed from: zN0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1838zN0 {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();

    public final void a(int i, String str, String str2) {
        this.a.put(str, str2);
        this.b.put(str2, str);
        this.c.put(str, Integer.valueOf(i));
    }
}
