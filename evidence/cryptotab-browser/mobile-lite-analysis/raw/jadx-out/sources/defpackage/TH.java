package defpackage;

import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TH {
    public final HashSet a;
    public final HashSet b;
    public int c;
    public int d;
    public nI e;
    public final HashSet f;

    public TH(Class cls, Class[] clsArr) {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        this.b = new HashSet();
        this.c = 0;
        this.d = 0;
        this.f = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            pj1.a(cls2, "Null interface");
        }
        Collections.addAll(this.a, clsArr);
    }

    public final void a(TW tw) {
        if (this.a.contains(tw.a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        this.b.add(tw);
    }

    public final UH b() {
        if (this.e != null) {
            return new UH(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public final void c(int i) {
        if (!(this.c == 0)) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        this.c = i;
    }
}
