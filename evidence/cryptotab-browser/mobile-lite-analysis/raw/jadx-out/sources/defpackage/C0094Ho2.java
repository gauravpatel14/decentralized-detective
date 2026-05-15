package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: Ho2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0094Ho2 {
    public final LinkedHashMap a = new LinkedHashMap();

    public final void a() {
        LinkedHashMap linkedHashMap = this.a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1867zo2) it.next()).a();
        }
        linkedHashMap.clear();
    }
}
