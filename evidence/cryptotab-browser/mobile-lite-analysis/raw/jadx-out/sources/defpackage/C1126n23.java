package defpackage;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: n23, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1126n23 {
    public final HashSet a = new HashSet();

    public final synchronized void a(Object obj) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1267pN1) it.next()).a(obj);
        }
    }
}
