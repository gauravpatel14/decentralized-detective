package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: zo2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1867zo2 {
    public final C0005Ao2 a = new C0005Ao2();

    public final void a() {
        C0005Ao2 c0005Ao2 = this.a;
        if (c0005Ao2 != null && !c0005Ao2.d) {
            c0005Ao2.d = true;
            synchronized (c0005Ao2.a) {
                try {
                    Iterator it = c0005Ao2.b.values().iterator();
                    while (it.hasNext()) {
                        C0005Ao2.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = c0005Ao2.c.iterator();
                    while (it2.hasNext()) {
                        C0005Ao2.a((AutoCloseable) it2.next());
                    }
                    c0005Ao2.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b();
    }

    public void b() {
    }
}
