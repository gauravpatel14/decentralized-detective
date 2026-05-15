package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FL2 extends UF2 implements RandomAccess, JL2 {
    public final List u;

    static {
        new FL2();
    }

    public FL2(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.u = arrayList;
    }

    @Override // defpackage.JL2
    public final JL2 a() {
        return this.t ? new AP2(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        e();
        this.u.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        e();
        if (collection instanceof JL2) {
            collection = ((JL2) collection).b();
        }
        boolean zAddAll = this.u.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // defpackage.JL2
    public final List b() {
        return Collections.unmodifiableList(this.u);
    }

    @Override // defpackage.InterfaceC1606vK2
    public final InterfaceC1606vK2 c(int i) {
        List list = this.u;
        if (i < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(list);
        return new FL2(arrayList);
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        this.u.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.JL2
    public final Object d(int i) {
        return this.u.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        String str;
        List list = this.u;
        Object obj = list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof C0519dH2)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, WK2.a);
            C0353aQ2 c0353aQ2 = AbstractC0776hQ2.a;
            int length = bArr.length;
            AbstractC0776hQ2.a.getClass();
            if (C0353aQ2.a(bArr, 0, length)) {
                list.set(i, str2);
            }
            return str2;
        }
        C0519dH2 c0519dH2 = (C0519dH2) obj;
        Charset charset = WK2.a;
        c0519dH2.getClass();
        Charset charset2 = WK2.a;
        if (c0519dH2.j() == 0) {
            str = "";
        } else {
            str = new String(c0519dH2.u, 0, c0519dH2.j(), charset2);
        }
        int iJ = c0519dH2.j();
        AbstractC0776hQ2.a.getClass();
        if (C0353aQ2.a(c0519dH2.u, 0, iJ)) {
            list.set(i, str);
        }
        return str;
    }

    @Override // defpackage.UF2, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        Object objRemove = this.u.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof C0519dH2)) {
            return new String((byte[]) objRemove, WK2.a);
        }
        C0519dH2 c0519dH2 = (C0519dH2) objRemove;
        Charset charset = WK2.a;
        c0519dH2.getClass();
        Charset charset2 = WK2.a;
        if (c0519dH2.j() == 0) {
            return "";
        }
        return new String(c0519dH2.u, 0, c0519dH2.j(), charset2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        Object obj2 = this.u.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof C0519dH2)) {
            return new String((byte[]) obj2, WK2.a);
        }
        C0519dH2 c0519dH2 = (C0519dH2) obj2;
        Charset charset = WK2.a;
        c0519dH2.getClass();
        Charset charset2 = WK2.a;
        if (c0519dH2.j() == 0) {
            return "";
        }
        return new String(c0519dH2.u, 0, c0519dH2.j(), charset2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.u.size();
    }

    public FL2(ArrayList arrayList) {
        super(true);
        this.u = arrayList;
    }

    public FL2() {
        super(false);
        this.u = Collections.emptyList();
    }

    @Override // defpackage.UF2, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.u.size(), collection);
    }
}
