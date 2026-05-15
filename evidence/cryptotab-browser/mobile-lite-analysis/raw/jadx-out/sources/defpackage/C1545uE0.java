package defpackage;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: uE0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1545uE0 extends E implements vE0, RandomAccess {
    public final ArrayList u;

    static {
        new C1545uE0(10).t = false;
    }

    public C1545uE0(int i) {
        this(new ArrayList(i));
    }

    @Override // defpackage.vE0
    public final List B1() {
        return Collections.unmodifiableList(this.u);
    }

    @Override // defpackage.vE0
    public final vE0 M0() {
        return this.t ? new C0666fk2(this) : this;
    }

    @Override // defpackage.fz0
    public final fz0 Y(int i) {
        ArrayList arrayList = this.u;
        if (i < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i);
        arrayList2.addAll(arrayList);
        return new C1545uE0(arrayList2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        e();
        this.u.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.E, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.u.size(), collection);
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        this.u.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        String str;
        ArrayList arrayList = this.u;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof C0199Qv) {
            C0199Qv c0199Qv = (C0199Qv) obj;
            c0199Qv.getClass();
            Charset charset = gz0.a;
            str = c0199Qv.size() == 0 ? "" : c0199Qv.v();
            int iS = c0199Qv.s();
            if (AbstractC0104Im2.a.i(c0199Qv.u, iS, c0199Qv.size() + iS)) {
                arrayList.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = new String(bArr, gz0.a);
            C0093Hm2 c0093Hm2 = AbstractC0104Im2.a;
            if (AbstractC0104Im2.a.i(bArr, 0, bArr.length)) {
                arrayList.set(i, str);
            }
        }
        return str;
    }

    @Override // defpackage.vE0
    public final void q(C0199Qv c0199Qv) {
        e();
        this.u.add(c0199Qv);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.vE0
    public final Object q1(int i) {
        return this.u.get(i);
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        e();
        Object objRemove = this.u.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof C0199Qv)) {
            return new String((byte[]) objRemove, gz0.a);
        }
        C0199Qv c0199Qv = (C0199Qv) objRemove;
        c0199Qv.getClass();
        Charset charset = gz0.a;
        return c0199Qv.size() == 0 ? "" : c0199Qv.v();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        Object obj2 = this.u.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof C0199Qv)) {
            return new String((byte[]) obj2, gz0.a);
        }
        C0199Qv c0199Qv = (C0199Qv) obj2;
        c0199Qv.getClass();
        Charset charset = gz0.a;
        return c0199Qv.size() == 0 ? "" : c0199Qv.v();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.u.size();
    }

    public C1545uE0(ArrayList arrayList) {
        this.u = arrayList;
    }

    @Override // defpackage.E, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        e();
        if (collection instanceof vE0) {
            collection = ((vE0) collection).B1();
        }
        boolean zAddAll = this.u.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
