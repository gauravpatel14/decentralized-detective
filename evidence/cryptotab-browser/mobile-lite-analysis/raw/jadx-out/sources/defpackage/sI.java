package defpackage;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class sI extends AbstractC1477t {
    public static final oI f = new oI();
    public final C0753h80 d;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final AtomicReference e = new AtomicReference();

    public sI(ExecutorC0367af0 executorC0367af0, ArrayList arrayList, ArrayList arrayList2) {
        C0753h80 c0753h80 = new C0753h80(executorC0367af0);
        this.d = c0753h80;
        ArrayList<UH> arrayList3 = new ArrayList();
        arrayList3.add(UH.b(c0753h80, C0753h80.class, InterfaceC1390rR1.class, yn1.class));
        arrayList3.add(UH.b(this, sI.class, new Class[0]));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            UH uh = (UH) it.next();
            if (uh != null) {
                arrayList3.add(uh);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next());
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((InterfaceC0988kn1) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(componentRegistrar.getComponents());
                        it3.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.a.isEmpty()) {
                CT.a(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.a.keySet());
                arrayList6.addAll(arrayList3);
                CT.a(arrayList6);
            }
            for (final UH uh2 : arrayList3) {
                this.a.put(uh2, new mE0(new InterfaceC0988kn1() { // from class: pI
                    @Override // defpackage.InterfaceC0988kn1
                    public final Object get() {
                        sI sIVar = this.a;
                        sIVar.getClass();
                        UH uh3 = uh2;
                        return uh3.e.a(new Xv1(uh3, sIVar));
                    }
                }));
            }
            arrayList5.addAll(g(arrayList3));
            arrayList5.addAll(h());
            f();
        }
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        Boolean bool = (Boolean) this.e.get();
        if (bool != null) {
            e(this.a, bool.booleanValue());
        }
    }

    @Override // defpackage.AbstractC1477t
    public final synchronized InterfaceC0988kn1 b(Class cls) {
        return (InterfaceC0988kn1) this.b.get(cls);
    }

    @Override // defpackage.AbstractC1477t
    public final synchronized InterfaceC0988kn1 d(Class cls) {
        C1487tE0 c1487tE0 = (C1487tE0) this.c.get(cls);
        if (c1487tE0 != null) {
            return c1487tE0;
        }
        return f;
    }

    public final void e(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            UH uh = (UH) entry.getKey();
            InterfaceC0988kn1 interfaceC0988kn1 = (InterfaceC0988kn1) entry.getValue();
            int i = uh.c;
            if (i == 1 || (i == 2 && z)) {
                interfaceC0988kn1.get();
            }
        }
        C0753h80 c0753h80 = this.d;
        synchronized (c0753h80) {
            arrayDeque = c0753h80.b;
            if (arrayDeque != null) {
                c0753h80.b = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    public final void f() {
        for (UH uh : this.a.keySet()) {
            for (TW tw : uh.b) {
                if (tw.b == 2 && !this.c.containsKey(tw.a)) {
                    HashMap map = this.c;
                    Class cls = tw.a;
                    Set setEmptySet = Collections.emptySet();
                    C1487tE0 c1487tE0 = new C1487tE0();
                    c1487tE0.b = null;
                    c1487tE0.a = Collections.newSetFromMap(new ConcurrentHashMap());
                    c1487tE0.a.addAll(setEmptySet);
                    map.put(cls, c1487tE0);
                } else if (this.b.containsKey(tw.a)) {
                    continue;
                } else {
                    int i = tw.b;
                    if (i == 1) {
                        throw new MissingDependencyException("Unsatisfied dependency for component " + uh + ": " + tw.a);
                    }
                    if (i != 2) {
                        HashMap map2 = this.b;
                        Class cls2 = tw.a;
                        C1854zY c1854zY = z51.c;
                        y51 y51Var = z51.d;
                        z51 z51Var = new z51();
                        z51Var.a = c1854zY;
                        z51Var.b = y51Var;
                        map2.put(cls2, z51Var);
                    }
                }
            }
        }
    }

    public final ArrayList g(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UH uh = (UH) it.next();
            if (uh.d == 0) {
                InterfaceC0988kn1 interfaceC0988kn1 = (InterfaceC0988kn1) this.a.get(uh);
                for (Class cls : uh.a) {
                    HashMap map = this.b;
                    if (map.containsKey(cls)) {
                        arrayList2.add(new qI((z51) ((InterfaceC0988kn1) map.get(cls)), interfaceC0988kn1, 0));
                    } else {
                        map.put(cls, interfaceC0988kn1);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList h() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            UH uh = (UH) entry.getKey();
            if (uh.d != 0) {
                InterfaceC0988kn1 interfaceC0988kn1 = (InterfaceC0988kn1) entry.getValue();
                for (Class cls : uh.a) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(interfaceC0988kn1);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            HashMap map2 = this.c;
            if (map2.containsKey(key)) {
                C1487tE0 c1487tE0 = (C1487tE0) map2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new qI(c1487tE0, (InterfaceC0988kn1) it.next(), 1));
                }
            } else {
                Class cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                C1487tE0 c1487tE02 = new C1487tE0();
                c1487tE02.b = null;
                c1487tE02.a = Collections.newSetFromMap(new ConcurrentHashMap());
                c1487tE02.a.addAll(set);
                map2.put(cls2, c1487tE02);
            }
        }
        return arrayList;
    }
}
