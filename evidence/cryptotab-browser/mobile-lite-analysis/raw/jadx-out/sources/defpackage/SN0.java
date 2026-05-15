package defpackage;

import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SN0 extends Ht1 {
    public final /* synthetic */ UN0 a;

    public SN0(UN0 un0) {
        this.a = un0;
    }

    @Override // defpackage.Ht1
    public final void b() {
        UN0 un0 = this.a;
        long jD = UN0.d(un0.c);
        if (jD != un0.b) {
            un0.b = jD;
            un0.a();
            if (un0.b != 0) {
                un0.b();
            }
        }
    }

    @Override // defpackage.Ht1
    public final void c(int[] iArr) {
        ArrayList arrayListC = AbstractC0700gL2.c(iArr);
        UN0 un0 = this.a;
        if (un0.e.equals(arrayListC)) {
            return;
        }
        un0.f();
        un0.g.evictAll();
        un0.h.clear();
        un0.e = arrayListC;
        UN0.e(un0);
        Iterator it = un0.q.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        un0.g();
    }

    @Override // defpackage.Ht1
    public final void d(int[] iArr, int i) {
        int size;
        UN0 un0 = this.a;
        if (i == 0) {
            size = un0.e.size();
        } else {
            size = un0.f.get(i, -1);
            if (size == -1) {
                un0.b();
                return;
            }
        }
        un0.f();
        un0.e.addAll(size, AbstractC0700gL2.c(iArr));
        UN0.e(un0);
        Iterator it = un0.q.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        un0.g();
    }

    @Override // defpackage.Ht1
    public final void e(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        while (true) {
            UN0 un0 = this.a;
            if (i >= length) {
                Collections.sort(arrayList);
                un0.f();
                AbstractC0700gL2.b(arrayList);
                Iterator it = un0.q.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                un0.g();
                return;
            }
            int i2 = iArr[i];
            un0.g.remove(Integer.valueOf(i2));
            int i3 = un0.f.get(i2, -1);
            if (i3 == -1) {
                un0.b();
                return;
            } else {
                arrayList.add(Integer.valueOf(i3));
                i++;
            }
        }
    }

    @Override // defpackage.Ht1
    public final void f(MediaQueueItem[] mediaQueueItemArr) {
        HashSet hashSet = new HashSet();
        UN0 un0 = this.a;
        un0.h.clear();
        int length = mediaQueueItemArr.length;
        int i = 0;
        while (true) {
            SparseIntArray sparseIntArray = un0.f;
            if (i >= length) {
                ArrayList arrayList = un0.h;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int i2 = sparseIntArray.get(((Integer) it.next()).intValue(), -1);
                    if (i2 != -1) {
                        hashSet.add(Integer.valueOf(i2));
                    }
                }
                arrayList.clear();
                ArrayList arrayList2 = new ArrayList(hashSet);
                Collections.sort(arrayList2);
                un0.f();
                AbstractC0700gL2.b(arrayList2);
                Iterator it2 = un0.q.iterator();
                if (it2.hasNext()) {
                    it2.next().getClass();
                    throw new ClassCastException();
                }
                un0.g();
                return;
            }
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
            int i3 = mediaQueueItem.u;
            un0.g.put(Integer.valueOf(i3), mediaQueueItem);
            int i4 = sparseIntArray.get(i3, -1);
            if (i4 == -1) {
                un0.b();
                return;
            } else {
                hashSet.add(Integer.valueOf(i4));
                i++;
            }
        }
    }

    @Override // defpackage.Ht1
    public final void g(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        while (true) {
            UN0 un0 = this.a;
            if (i >= length) {
                if (arrayList.isEmpty()) {
                    return;
                }
                Collections.sort(arrayList);
                un0.f();
                un0.e.removeAll(AbstractC0700gL2.c(iArr));
                UN0.e(un0);
                AbstractC0700gL2.b(arrayList);
                Iterator it = un0.q.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                un0.g();
                return;
            }
            int i2 = iArr[i];
            un0.g.remove(Integer.valueOf(i2));
            SparseIntArray sparseIntArray = un0.f;
            int i3 = sparseIntArray.get(i2, -1);
            if (i3 == -1) {
                un0.b();
                return;
            } else {
                sparseIntArray.delete(i2);
                arrayList.add(Integer.valueOf(i3));
                i++;
            }
        }
    }
}
