package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: jk2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0927jk2 {
    public final Class a;
    public final Set b = Collections.newSetFromMap(new WeakHashMap());

    public C0927jk2(Class cls) {
        this.a = cls;
    }

    public final void a(C0865ik2 c0865ik2, InterfaceC0732gk2 interfaceC0732gk2) {
        Objects.requireNonNull(interfaceC0732gk2);
        c0865ik2.getClass();
        int i = AbstractC1872zv.a;
        c0865ik2.a.getClass();
        if (c0865ik2.c.containsKey(this) && !interfaceC0732gk2.equals(c0865ik2.a(this))) {
            c(c0865ik2);
        }
        c0865ik2.c.put(this, new WeakReference(interfaceC0732gk2));
        if (e(c0865ik2) != null) {
            return;
        }
        this.b.add(c0865ik2);
    }

    public final void b(InterfaceC0732gk2 interfaceC0732gk2) {
        int i = AbstractC1872zv.a;
        for (C0865ik2 c0865ik2 : new ArrayList(this.b)) {
            if (interfaceC0732gk2.equals(c0865ik2.a(this))) {
                d(c0865ik2);
            }
        }
    }

    public final void c(C0865ik2 c0865ik2) {
        int i = AbstractC1872zv.a;
        for (C0865ik2 c0865ik22 : new ArrayList(this.b)) {
            if (c0865ik2.equals(c0865ik22)) {
                d(c0865ik22);
            }
        }
    }

    public final void d(final C0865ik2 c0865ik2) {
        final InterfaceC0732gk2 interfaceC0732gk2;
        c0865ik2.getClass();
        int i = AbstractC1872zv.a;
        c0865ik2.a.getClass();
        WeakReference weakReference = (WeakReference) c0865ik2.c.remove(this);
        if (weakReference != null && (interfaceC0732gk2 = (InterfaceC0732gk2) weakReference.get()) != null) {
            c0865ik2.b.post(new Runnable() { // from class: hk2
                @Override // java.lang.Runnable
                public final void run() {
                    c0865ik2.getClass();
                    interfaceC0732gk2.z();
                }
            });
        }
        this.b.remove(c0865ik2);
    }

    public final InterfaceC0732gk2 e(C0865ik2 c0865ik2) {
        int i = AbstractC1872zv.a;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (c0865ik2.equals((C0865ik2) it.next())) {
                return c0865ik2.a(this);
            }
        }
        return null;
    }
}
