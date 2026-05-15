package defpackage;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Xv1 extends AbstractC1477t {
    public final Set a;
    public final Set b;
    public final Set c;
    public final Set d;
    public final AbstractC1477t e;

    public Xv1(UH uh, AbstractC1477t abstractC1477t) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (TW tw : uh.b) {
            int i = tw.c;
            boolean z = i == 0;
            int i2 = tw.b;
            Class cls = tw.a;
            if (z) {
                if (i2 == 2) {
                    hashSet4.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else if (i == 2) {
                hashSet3.add(cls);
            } else if (i2 == 2) {
                hashSet5.add(cls);
            } else {
                hashSet2.add(cls);
            }
        }
        if (!uh.f.isEmpty()) {
            hashSet.add(yn1.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.c = Collections.unmodifiableSet(hashSet4);
        this.d = Collections.unmodifiableSet(hashSet5);
        this.e = abstractC1477t;
    }

    @Override // defpackage.AbstractC1477t
    public final Object a(Class cls) {
        if (!this.a.contains(cls)) {
            throw new DependencyException("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object objA = this.e.a(cls);
        if (!cls.equals(yn1.class)) {
            return objA;
        }
        return new Wv1();
    }

    @Override // defpackage.AbstractC1477t
    public final InterfaceC0988kn1 b(Class cls) {
        if (this.b.contains(cls)) {
            return this.e.b(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<" + cls + ">.");
    }

    @Override // defpackage.AbstractC1477t
    public final Set c(Class cls) {
        if (this.c.contains(cls)) {
            return this.e.c(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Set<" + cls + ">.");
    }

    @Override // defpackage.AbstractC1477t
    public final InterfaceC0988kn1 d(Class cls) {
        if (this.d.contains(cls)) {
            return this.e.d(cls);
        }
        throw new DependencyException("Attempting to request an undeclared dependency Provider<Set<" + cls + ">>.");
    }
}
