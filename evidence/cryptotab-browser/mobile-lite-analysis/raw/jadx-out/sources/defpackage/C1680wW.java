package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: wW, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1680wW {
    public final String a;
    public final Tl0 b;

    public C1680wW(Set set, Tl0 tl0) {
        this.a = b(set);
        this.b = tl0;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C1523ti c1523ti = (C1523ti) it.next();
            sb.append(c1523ti.a);
            sb.append('/');
            sb.append(c1523ti.b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        Tl0 tl0 = this.b;
        synchronized (tl0.a) {
            setUnmodifiableSet = Collections.unmodifiableSet(tl0.a);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.a;
        if (zIsEmpty) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (tl0.a) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(tl0.a);
        }
        sb.append(b(setUnmodifiableSet2));
        return sb.toString();
    }
}
