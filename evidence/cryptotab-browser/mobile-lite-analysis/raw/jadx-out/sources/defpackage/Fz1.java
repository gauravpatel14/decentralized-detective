package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Fz1 {
    public static final Class a;
    public static final C0373ak2 b;
    public static final C0373ak2 c;
    public static final C0373ak2 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        b = A(false);
        c = A(true);
        d = new C0373ak2();
    }

    public static C0373ak2 A(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (C0373ak2) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void B(C0373ak2 c0373ak2, AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02) {
        c0373ak2.getClass();
        Zj2 zj2 = abstractC0003Al0.b;
        Zj2 zj22 = abstractC0003Al02.b;
        if (!zj22.equals(Zj2.f)) {
            int i = zj2.a + zj22.a;
            int[] iArrCopyOf = Arrays.copyOf(zj2.b, i);
            System.arraycopy(zj22.b, 0, iArrCopyOf, zj2.a, zj22.a);
            Object[] objArrCopyOf = Arrays.copyOf(zj2.c, i);
            System.arraycopy(zj22.c, 0, objArrCopyOf, zj2.a, zj22.a);
            zj2 = new Zj2(i, iArrCopyOf, objArrCopyOf, true);
        }
        abstractC0003Al0.b = zj2;
    }

    public static boolean C(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object D(int i, int i2, Object obj, C0373ak2 c0373ak2) {
        if (obj == null) {
            c0373ak2.getClass();
            obj = Zj2.b();
        }
        c0373ak2.getClass();
        ((Zj2) obj).c(i << 3, Long.valueOf(i2));
        return obj;
    }

    public static void E(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.A(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3++;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.z(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void F(int i, List list, DG dg) {
        if (list == null || list.isEmpty()) {
            return;
        }
        dg.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            dg.a.C(i, (C0199Qv) list.get(i2));
        }
    }

    public static void G(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                cg.getClass();
                cg.G(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 8;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.H(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void H(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.I(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iL = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iL += CG.l(((Integer) list.get(i3)).intValue());
        }
        cg.Q(iL);
        while (i2 < list.size()) {
            cg.J(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void I(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.E(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 4;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.F(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void J(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.G(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 8;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.H(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void K(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                float fFloatValue = ((Float) list.get(i2)).floatValue();
                cg.getClass();
                cg.E(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 4;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.F(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void L(int i, List list, DG dg, Cz1 cz1) {
        if (list == null || list.isEmpty()) {
            return;
        }
        dg.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            dg.h(i, list.get(i2), cz1);
        }
    }

    public static void M(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.I(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iL = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iL += CG.l(((Integer) list.get(i3)).intValue());
        }
        cg.Q(iL);
        while (i2 < list.size()) {
            cg.J(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void N(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX += CG.x(((Long) list.get(i3)).longValue());
        }
        cg.Q(iX);
        while (i2 < list.size()) {
            cg.S(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void O(int i, List list, DG dg, Cz1 cz1) {
        if (list == null || list.isEmpty()) {
            return;
        }
        dg.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            dg.k(i, list.get(i2), cz1);
        }
    }

    public static void P(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.E(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 4;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.F(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void Q(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.G(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            boolean z2 = CG.b;
            i3 += 8;
        }
        cg.Q(i3);
        while (i2 < list.size()) {
            cg.H(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void R(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                cg.P(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iV = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iV += CG.v((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        cg.Q(iV);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            cg.Q((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void S(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                cg.R(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iX += CG.x((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        cg.Q(iX);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            cg.S((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void T(int i, List list, DG dg) {
        if (list == null || list.isEmpty()) {
            return;
        }
        dg.getClass();
        boolean z = list instanceof vE0;
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.M(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        vE0 ve0 = (vE0) list;
        while (i2 < list.size()) {
            Object objQ1 = ve0.q1(i2);
            if (objQ1 instanceof String) {
                cg.M(i, (String) objQ1);
            } else {
                cg.C(i, (C0199Qv) objQ1);
            }
            i2++;
        }
    }

    public static void U(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.P(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iV = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iV += CG.v(((Integer) list.get(i3)).intValue());
        }
        cg.Q(iV);
        while (i2 < list.size()) {
            cg.Q(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void V(int i, List list, DG dg, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        CG cg = dg.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                cg.R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        cg.O(i, 2);
        int iX = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iX += CG.x(((Long) list.get(i3)).longValue());
        }
        cg.Q(iX);
        while (i2 < list.size()) {
            cg.S(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CG.b(i) * size;
    }

    public static int b(List list) {
        return list.size();
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = CG.t(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            iT += CG.d((C0199Qv) list.get(i2));
        }
        return iT;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + e(list);
    }

    public static int e(List list) {
        int iL;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1118my0) {
            C1118my0 c1118my0 = (C1118my0) list;
            iL = 0;
            while (i < size) {
                c1118my0.h(i);
                iL += CG.l(c1118my0.u[i]);
                i++;
            }
        } else {
            iL = 0;
            while (i < size) {
                iL += CG.l(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iL;
    }

    public static int f(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CG.g(i) * size;
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CG.h(i) * size;
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i, List list, Cz1 cz1) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iJ += CG.j(i, (InterfaceC1787yS0) list.get(i2), cz1);
        }
        return iJ;
    }

    public static int k(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + l(list);
    }

    public static int l(List list) {
        int iL;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1118my0) {
            C1118my0 c1118my0 = (C1118my0) list;
            iL = 0;
            while (i < size) {
                c1118my0.h(i);
                iL += CG.l(c1118my0.u[i]);
                i++;
            }
        } else {
            iL = 0;
            while (i < size) {
                iL += CG.l(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iL;
    }

    public static int m(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (CG.t(i) * list.size()) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1077mJ0) {
            AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
            if (size <= 0) {
                return 0;
            }
            abstractC1077mJ0.h(0);
            throw null;
        }
        int iX = 0;
        for (int i = 0; i < size; i++) {
            iX += CG.x(((Long) list.get(i)).longValue());
        }
        return iX;
    }

    public static int o(int i, Object obj, Cz1 cz1) {
        int iT = CG.t(i);
        int iA = ((A) ((InterfaceC1787yS0) obj)).a(cz1);
        return CG.v(iA) + iA + iT;
    }

    public static int p(int i, List list, Cz1 cz1) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = CG.t(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            int iA = ((A) ((InterfaceC1787yS0) list.get(i2))).a(cz1);
            iT += CG.v(iA) + iA;
        }
        return iT;
    }

    public static int q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + r(list);
    }

    public static int r(List list) {
        int iV;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1118my0) {
            C1118my0 c1118my0 = (C1118my0) list;
            iV = 0;
            while (i < size) {
                c1118my0.h(i);
                int i2 = c1118my0.u[i];
                iV += CG.v((i2 >> 31) ^ (i2 << 1));
                i++;
            }
        } else {
            iV = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iV += CG.v((iIntValue >> 31) ^ (iIntValue << 1));
                i++;
            }
        }
        return iV;
    }

    public static int s(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + t(list);
    }

    public static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1077mJ0) {
            AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
            if (size <= 0) {
                return 0;
            }
            abstractC1077mJ0.h(0);
            throw null;
        }
        int iX = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iX += CG.x((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iX;
    }

    public static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iT = CG.t(i) * size;
        if (list instanceof vE0) {
            vE0 ve0 = (vE0) list;
            while (i2 < size) {
                Object objQ1 = ve0.q1(i2);
                iT = (objQ1 instanceof C0199Qv ? CG.d((C0199Qv) objQ1) : CG.s((String) objQ1)) + iT;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iT = (obj instanceof C0199Qv ? CG.d((C0199Qv) obj) : CG.s((String) obj)) + iT;
                i2++;
            }
        }
        return iT;
    }

    public static int v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + w(list);
    }

    public static int w(List list) {
        int iV;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1118my0) {
            C1118my0 c1118my0 = (C1118my0) list;
            iV = 0;
            while (i < size) {
                c1118my0.h(i);
                iV += CG.v(c1118my0.u[i]);
                i++;
            }
        } else {
            iV = 0;
            while (i < size) {
                iV += CG.v(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iV;
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CG.t(i) * size) + y(list);
    }

    public static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1077mJ0) {
            AbstractC1077mJ0 abstractC1077mJ0 = (AbstractC1077mJ0) list;
            if (size <= 0) {
                return 0;
            }
            abstractC1077mJ0.h(0);
            throw null;
        }
        int iX = 0;
        for (int i = 0; i < size; i++) {
            iX += CG.x(((Long) list.get(i)).longValue());
        }
        return iX;
    }

    public static Object z(int i, List list, dz0 dz0Var, Object obj, C0373ak2 c0373ak2) {
        if (dz0Var == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (dz0Var.a(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = D(i, iIntValue, obj, c0373ak2);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!dz0Var.a(iIntValue2)) {
                    obj = D(i, iIntValue2, obj, c0373ak2);
                    it.remove();
                }
            }
        }
        return obj;
    }
}
