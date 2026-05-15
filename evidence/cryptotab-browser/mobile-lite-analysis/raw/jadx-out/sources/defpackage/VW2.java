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
public final class VW2 extends EU2 implements RandomAccess, XW2 {
    public final ArrayList u;

    static {
        new VW2(10).t = false;
    }

    public VW2(int i) {
        this.u = new ArrayList(i);
    }

    @Override // defpackage.XW2
    public final void C(WU2 wu2) {
        e();
        this.u.add(wu2);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.XW2
    public final XW2 a() {
        return this.t ? new IY2(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        e();
        this.u.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        e();
        if (collection instanceof XW2) {
            collection = ((XW2) collection).b();
        }
        boolean zAddAll = this.u.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // defpackage.XW2
    public final List b() {
        return Collections.unmodifiableList(this.u);
    }

    @Override // defpackage.LW2
    public final LW2 c(int i) {
        ArrayList arrayList = this.u;
        if (i < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i);
        arrayList2.addAll(arrayList);
        return new VW2(arrayList2);
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        this.u.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.XW2
    public final Object d(int i) {
        return this.u.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        String str;
        ArrayList arrayList = this.u;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof WU2)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, NW2.a);
            PY2 py2 = AbstractC0850iZ2.a;
            int length = bArr.length;
            AbstractC0850iZ2.a.getClass();
            if (PY2.a(bArr, 0, length)) {
                arrayList.set(i, str2);
            }
            return str2;
        }
        WU2 wu2 = (WU2) obj;
        Charset charset = NW2.a;
        wu2.getClass();
        Charset charset2 = NW2.a;
        if (wu2.j() == 0) {
            str = "";
        } else {
            str = new String(wu2.u, 0, wu2.j(), charset2);
        }
        int iJ = wu2.j();
        AbstractC0850iZ2.a.getClass();
        if (PY2.a(wu2.u, 0, iJ)) {
            arrayList.set(i, str);
        }
        return str;
    }

    @Override // defpackage.EU2, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        Object objRemove = this.u.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof WU2)) {
            return new String((byte[]) objRemove, NW2.a);
        }
        WU2 wu2 = (WU2) objRemove;
        Charset charset = NW2.a;
        wu2.getClass();
        Charset charset2 = NW2.a;
        if (wu2.j() == 0) {
            return "";
        }
        return new String(wu2.u, 0, wu2.j(), charset2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        Object obj2 = this.u.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof WU2)) {
            return new String((byte[]) obj2, NW2.a);
        }
        WU2 wu2 = (WU2) obj2;
        Charset charset = NW2.a;
        wu2.getClass();
        Charset charset2 = NW2.a;
        if (wu2.j() == 0) {
            return "";
        }
        return new String(wu2.u, 0, wu2.j(), charset2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.u.size();
    }

    public VW2(ArrayList arrayList) {
        this.u = arrayList;
    }

    @Override // defpackage.EU2, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.u.size(), collection);
    }
}
