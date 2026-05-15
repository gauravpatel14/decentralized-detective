package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: aX2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0361aX2 extends AbstractC0716gX2 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // defpackage.AbstractC0716gX2
    public final void a(long j, Object obj) {
        Object objUnmodifiableList;
        List list = (List) NY2.c.m(j, obj);
        if (list instanceof XW2) {
            objUnmodifiableList = ((XW2) list).a();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof InterfaceC0421bY2) && (list instanceof LW2)) {
                EU2 eu2 = (EU2) ((LW2) list);
                if (eu2.t) {
                    eu2.t = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        NY2.o(j, obj, objUnmodifiableList);
    }

    @Override // defpackage.AbstractC0716gX2
    public final void b(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22, long j) {
        List list;
        List list2;
        MY2 my2 = NY2.c;
        List list3 = (List) my2.m(j, abstractC1852zW22);
        int size = list3.size();
        List list4 = (List) my2.m(j, abstractC1852zW2);
        if (list4.isEmpty()) {
            List vw2 = list4 instanceof XW2 ? new VW2(size) : ((list4 instanceof InterfaceC0421bY2) && (list4 instanceof LW2)) ? ((LW2) list4).c(size) : new ArrayList(size);
            NY2.o(j, abstractC1852zW2, vw2);
            list2 = vw2;
        } else {
            if (c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                NY2.o(j, abstractC1852zW2, arrayList);
                list = arrayList;
            } else if (list4 instanceof IY2) {
                VW2 vw22 = new VW2(list4.size() + size);
                vw22.addAll(vw22.u.size(), (IY2) list4);
                NY2.o(j, abstractC1852zW2, vw22);
                list = vw22;
            } else {
                boolean z = list4 instanceof InterfaceC0421bY2;
                list2 = list4;
                if (z) {
                    boolean z2 = list4 instanceof LW2;
                    list2 = list4;
                    if (z2) {
                        LW2 lw2 = (LW2) list4;
                        list2 = list4;
                        if (!((EU2) lw2).t) {
                            LW2 lw2C = lw2.c(list4.size() + size);
                            NY2.o(j, abstractC1852zW2, lw2C);
                            list2 = lw2C;
                        }
                    }
                }
            }
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        NY2.o(j, abstractC1852zW2, list3);
    }
}
