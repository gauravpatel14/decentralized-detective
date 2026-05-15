package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MG extends TG {
    public static boolean f(Iterable iterable, Object obj) {
        int iIndexOf;
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                if (lz0.a(obj, next)) {
                    iIndexOf = i;
                    break;
                }
                i++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static final void g(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0926jk0 interfaceC0926jk0) {
        sb.append(charSequence2);
        int i2 = 0;
        for (Object obj : collection) {
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            } else {
                SP1.a(sb, obj, interfaceC0926jk0);
            }
        }
        if (i >= 0 && i2 > i) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String h(Collection collection, String str, String str2, String str3, s sVar, int i) {
        String str4 = (i & 2) != 0 ? "" : str2;
        String str5 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            sVar = null;
        }
        StringBuilder sb = new StringBuilder();
        g(collection, sb, str, str4, str5, -1, "...", sVar);
        return sb.toString();
    }

    public static List i(AbstractList abstractList) {
        if (abstractList == null) {
            List listL = l(abstractList);
            if (((ArrayList) listL).size() > 1) {
                Collections.sort(listL);
            }
            return listL;
        }
        if (abstractList.size() <= 1) {
            return k(abstractList);
        }
        Object[] array = abstractList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return Arrays.asList(array);
    }

    public static List j(Iterable iterable, Comparator comparator) {
        if (!(iterable instanceof Collection)) {
            List listL = l(iterable);
            if (((ArrayList) listL).size() > 1) {
                Collections.sort(listL, comparator);
            }
            return listL;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return k(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return Arrays.asList(array);
    }

    public static List k(Iterable iterable) {
        boolean z = iterable instanceof Collection;
        U60 u60 = U60.t;
        if (!z) {
            List listL = l(iterable);
            ArrayList arrayList = (ArrayList) listL;
            int size = arrayList.size();
            return size != 0 ? size != 1 ? listL : Collections.singletonList(arrayList.get(0)) : u60;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return u60;
        }
        if (size2 != 1) {
            return new ArrayList(collection);
        }
        return Collections.singletonList(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List l(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static Set m(ArrayList arrayList) {
        X60 x60 = X60.t;
        int size = arrayList.size();
        if (size == 0) {
            return x60;
        }
        if (size == 1) {
            return Collections.singleton(arrayList.get(0));
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(EL0.b(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }
}
