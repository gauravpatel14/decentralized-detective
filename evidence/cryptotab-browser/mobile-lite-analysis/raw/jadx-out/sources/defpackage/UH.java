package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UH {
    public final Set a;
    public final Set b;
    public final int c;
    public final int d;
    public final nI e;
    public final Set f;

    public UH(HashSet hashSet, HashSet hashSet2, int i, int i2, nI nIVar, HashSet hashSet3) {
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = i;
        this.d = i2;
        this.e = nIVar;
        this.f = Collections.unmodifiableSet(hashSet3);
    }

    public static TH a(Class cls) {
        return new TH(cls, new Class[0]);
    }

    public static UH b(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            pj1.a(cls2, "Null interface");
        }
        Collections.addAll(hashSet, clsArr);
        return new UH(new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new SH(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
