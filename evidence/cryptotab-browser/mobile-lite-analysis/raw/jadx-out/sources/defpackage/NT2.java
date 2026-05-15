package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NT2 {
    public static final gf a = new gf(0);

    public static synchronized void a() {
        gf gfVar = a;
        Iterator it = ((ff) gfVar.values()).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            throw null;
        }
        gfVar.clear();
    }
}
