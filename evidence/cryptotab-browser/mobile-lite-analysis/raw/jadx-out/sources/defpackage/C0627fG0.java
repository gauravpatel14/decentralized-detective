package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: fG0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0627fG0 extends AbstractC0764hG0 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public static List d(int i, long j, Object obj) {
        List list;
        List list2 = (List) AbstractC1633vk2.b.k(j, obj);
        if (list2.isEmpty()) {
            List c1545uE0 = list2 instanceof vE0 ? new C1545uE0(i) : ((list2 instanceof Yk1) && (list2 instanceof fz0)) ? ((fz0) list2).Y(i) : new ArrayList(i);
            AbstractC1633vk2.u(j, obj, c1545uE0);
            return c1545uE0;
        }
        if (c.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            AbstractC1633vk2.u(j, obj, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof C0666fk2)) {
                if (!(list2 instanceof Yk1) || !(list2 instanceof fz0)) {
                    return list2;
                }
                fz0 fz0Var = (fz0) list2;
                if (((E) fz0Var).t) {
                    return list2;
                }
                fz0 fz0VarY = fz0Var.Y(list2.size() + i);
                AbstractC1633vk2.u(j, obj, fz0VarY);
                return fz0VarY;
            }
            C1545uE0 c1545uE02 = new C1545uE0(list2.size() + i);
            c1545uE02.addAll((C0666fk2) list2);
            AbstractC1633vk2.u(j, obj, c1545uE02);
            list = c1545uE02;
        }
        return list;
    }

    @Override // defpackage.AbstractC0764hG0
    public final void a(long j, Object obj) {
        Object objUnmodifiableList;
        List list = (List) AbstractC1633vk2.b.k(j, obj);
        if (list instanceof vE0) {
            objUnmodifiableList = ((vE0) list).M0();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof Yk1) && (list instanceof fz0)) {
                E e = (E) ((fz0) list);
                if (e.t) {
                    e.t = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        AbstractC1633vk2.u(j, obj, objUnmodifiableList);
    }

    @Override // defpackage.AbstractC0764hG0
    public final void b(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02, long j) {
        List list = (List) AbstractC1633vk2.b.k(j, abstractC0003Al02);
        List listD = d(list.size(), j, abstractC0003Al0);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        AbstractC1633vk2.u(j, abstractC0003Al0, list);
    }

    @Override // defpackage.AbstractC0764hG0
    public final List c(long j, Object obj) {
        return d(10, j, obj);
    }
}
