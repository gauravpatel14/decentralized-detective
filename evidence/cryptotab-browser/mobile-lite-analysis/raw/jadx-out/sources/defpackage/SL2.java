package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class SL2 extends AbstractC0769hM2 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // defpackage.AbstractC0769hM2
    public final void a(long j, Object obj) {
        Object objUnmodifiableList;
        List list = (List) SP2.i(j, obj);
        if (list instanceof JL2) {
            objUnmodifiableList = ((JL2) list).a();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof WN2) && (list instanceof InterfaceC1606vK2)) {
                UF2 uf2 = (UF2) ((InterfaceC1606vK2) list);
                boolean z = uf2.t;
                if (z && z) {
                    uf2.t = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        SP2.p(j, obj, objUnmodifiableList);
    }

    @Override // defpackage.AbstractC0769hM2
    public final void b(long j, Object obj, Object obj2) {
        List list;
        List list2;
        List list3 = (List) SP2.i(j, obj2);
        int size = list3.size();
        List list4 = (List) SP2.i(j, obj);
        if (list4.isEmpty()) {
            List fl2 = list4 instanceof JL2 ? new FL2(size) : ((list4 instanceof WN2) && (list4 instanceof InterfaceC1606vK2)) ? ((InterfaceC1606vK2) list4).c(size) : new ArrayList(size);
            SP2.p(j, obj, fl2);
            list2 = fl2;
        } else {
            if (c.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                SP2.p(j, obj, arrayList);
                list = arrayList;
            } else if (list4 instanceof AP2) {
                FL2 fl22 = new FL2(list4.size() + size);
                fl22.addAll(fl22.u.size(), (AP2) list4);
                SP2.p(j, obj, fl22);
                list = fl22;
            } else {
                boolean z = list4 instanceof WN2;
                list2 = list4;
                if (z) {
                    boolean z2 = list4 instanceof InterfaceC1606vK2;
                    list2 = list4;
                    if (z2) {
                        InterfaceC1606vK2 interfaceC1606vK2 = (InterfaceC1606vK2) list4;
                        list2 = list4;
                        if (!((UF2) interfaceC1606vK2).t) {
                            InterfaceC1606vK2 interfaceC1606vK2C = interfaceC1606vK2.c(list4.size() + size);
                            SP2.p(j, obj, interfaceC1606vK2C);
                            list2 = interfaceC1606vK2C;
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
        SP2.p(j, obj, list3);
    }
}
