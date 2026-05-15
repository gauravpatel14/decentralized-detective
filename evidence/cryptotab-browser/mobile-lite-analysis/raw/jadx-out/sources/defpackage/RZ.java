package defpackage;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RZ {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());

    public final QZ a(Object obj) {
        QZ qz = new QZ();
        qz.a = obj;
        this.a.add(qz);
        return qz;
    }
}
