package defpackage;

import com.google.android.gms.internal.measurement.zzjh;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: iY2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0849iY2 {
    public static final Class a;
    public static final FY2 b;
    public static final FY2 c;
    public static final FY2 d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        b = w(false);
        c = w(true);
        d = new FY2();
    }

    public static int A(List list) {
        int iP;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof BW2) {
            BW2 bw2 = (BW2) list;
            iP = 0;
            while (i < size) {
                bw2.h(i);
                iP += BV2.p(bw2.u[i]);
                i++;
            }
        } else {
            iP = 0;
            while (i < size) {
                iP += BV2.p(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iP;
    }

    public static int B(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.a(i << 3) + 4) * size;
    }

    public static int C(List list) {
        return list.size() * 4;
    }

    public static int D(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.a(i << 3) + 8) * size;
    }

    public static int E(List list) {
        return list.size() * 8;
    }

    public static int F(int i, List list, InterfaceC0784hY2 interfaceC0784hY2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iO = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iO += BV2.o(i, (CU2) list.get(i2), interfaceC0784hY2);
        }
        return iO;
    }

    public static int G(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + H(list);
    }

    public static int H(List list) {
        int iP;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof BW2) {
            BW2 bw2 = (BW2) list;
            iP = 0;
            while (i < size) {
                bw2.h(i);
                iP += BV2.p(bw2.u[i]);
                i++;
            }
        } else {
            iP = 0;
            while (i < size) {
                iP += BV2.p(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iP;
    }

    public static int I(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (BV2.r(i) * list.size()) + J(list);
    }

    public static int J(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0847iX2) {
            C0847iX2 c0847iX2 = (C0847iX2) list;
            iB = 0;
            while (i < size) {
                c0847iX2.h(i);
                iB += BV2.b(c0847iX2.u[i]);
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += BV2.b(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    public static int K(int i, Object obj, InterfaceC0784hY2 interfaceC0784hY2) {
        CU2 cu2 = (CU2) obj;
        int iA = BV2.a(i << 3);
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) cu2;
        int iC = abstractC1852zW2.zzd;
        if (iC == -1) {
            iC = interfaceC0784hY2.c(cu2);
            abstractC1852zW2.zzd = iC;
        }
        return SX2.a(iC, iC, iA);
    }

    public static int L(int i, List list, InterfaceC0784hY2 interfaceC0784hY2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = BV2.r(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            CU2 cu2 = (CU2) list.get(i2);
            AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) cu2;
            int iC = abstractC1852zW2.zzd;
            if (iC == -1) {
                iC = interfaceC0784hY2.c(cu2);
                abstractC1852zW2.zzd = iC;
            }
            iR = SX2.a(iC, iC, iR);
        }
        return iR;
    }

    public static int M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + N(list);
    }

    public static int N(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof BW2) {
            BW2 bw2 = (BW2) list;
            iA = 0;
            while (i < size) {
                bw2.h(i);
                int i2 = bw2.u[i];
                iA += BV2.a((i2 >> 31) ^ (i2 + i2));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iA += BV2.a((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iA;
    }

    public static int O(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + P(list);
    }

    public static int P(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0847iX2) {
            C0847iX2 c0847iX2 = (C0847iX2) list;
            iB = 0;
            while (i < size) {
                c0847iX2.h(i);
                long j = c0847iX2.u[i];
                iB += BV2.b((j >> 63) ^ (j + j));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iB += BV2.b((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iB;
    }

    public static int Q(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iR = BV2.r(i) * size;
        if (list instanceof XW2) {
            XW2 xw2 = (XW2) list;
            while (i2 < size) {
                Object objD = xw2.d(i2);
                if (objD instanceof WU2) {
                    int iJ = ((WU2) objD).j();
                    iR = SX2.a(iJ, iJ, iR);
                } else {
                    iR = BV2.q((String) objD) + iR;
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof WU2) {
                    int iJ2 = ((WU2) obj).j();
                    iR = SX2.a(iJ2, iJ2, iR);
                } else {
                    iR = BV2.q((String) obj) + iR;
                }
                i2++;
            }
        }
        return iR;
    }

    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + S(list);
    }

    public static int S(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof BW2) {
            BW2 bw2 = (BW2) list;
            iA = 0;
            while (i < size) {
                bw2.h(i);
                iA += BV2.a(bw2.u[i]);
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += BV2.a(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iA;
    }

    public static int T(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + U(list);
    }

    public static int U(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0847iX2) {
            C0847iX2 c0847iX2 = (C0847iX2) list;
            iB = 0;
            while (i < size) {
                c0847iX2.h(i);
                iB += BV2.b(c0847iX2.u[i]);
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += BV2.b(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    public static Object a(int i, LW2 lw2, FW2 fw2, EY2 ey2, FY2 fy2) {
        if (fw2 == null) {
            return ey2;
        }
        if (lw2 != null) {
            int size = lw2.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) lw2.get(i3);
                int iIntValue = num.intValue();
                if (fw2.a(iIntValue)) {
                    if (i3 != i2) {
                        lw2.set(i2, num);
                    }
                    i2++;
                } else {
                    if (ey2 == null) {
                        fy2.getClass();
                        ey2 = EY2.b();
                    }
                    fy2.getClass();
                    ey2.c(i << 3, Long.valueOf(iIntValue));
                }
            }
            if (i2 != size) {
                lw2.subList(i2, size).clear();
                return ey2;
            }
        } else {
            Iterator it = lw2.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!fw2.a(iIntValue2)) {
                    if (ey2 == null) {
                        fy2.getClass();
                        ey2 = EY2.b();
                    }
                    fy2.getClass();
                    ey2.c(i << 3, Long.valueOf(iIntValue2));
                    it.remove();
                }
            }
        }
        return ey2;
    }

    public static void b(FY2 fy2, AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22) {
        fy2.getClass();
        EY2 ey2 = abstractC1852zW2.zzc;
        EY2 ey22 = abstractC1852zW22.zzc;
        if (!ey22.equals(EY2.f)) {
            int i = ey2.a + ey22.a;
            int[] iArrCopyOf = Arrays.copyOf(ey2.b, i);
            System.arraycopy(ey22.b, 0, iArrCopyOf, ey2.a, ey22.a);
            Object[] objArrCopyOf = Arrays.copyOf(ey2.c, i);
            System.arraycopy(ey22.c, 0, objArrCopyOf, ey2.a, ey22.a);
            ey2 = new EY2(i, iArrCopyOf, objArrCopyOf, true);
        }
        abstractC1852zW2.zzc = ey2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void c(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                bv2.l(i << 3);
                bv2.c(zBooleanValue ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.c(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void d(int i, List list, FV2 fv2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        fv2.getClass();
        for (int i2 = 0; i2 < list.size(); i2++) {
            fv2.a.e(i, (WU2) list.get(i2));
        }
    }

    public static void e(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.h(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.i(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void f(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                bv2.l(i << 3);
                if (iIntValue >= 0) {
                    bv2.l(iIntValue);
                } else {
                    bv2.n(iIntValue);
                }
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iP = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iP += BV2.p(((Integer) list.get(i3)).intValue());
        }
        bv2.l(iP);
        while (i2 < list.size()) {
            int iIntValue2 = ((Integer) list.get(i2)).intValue();
            if (iIntValue2 >= 0) {
                bv2.l(iIntValue2);
            } else {
                bv2.n(iIntValue2);
            }
            i2++;
        }
    }

    public static void g(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.f(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.g(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void h(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.h(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.i(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void i(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.f(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.g(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void j(int i, List list, FV2 fv2, InterfaceC0784hY2 interfaceC0784hY2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            fv2.l(i, list.get(i2), interfaceC0784hY2);
        }
    }

    public static void k(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                bv2.l(i << 3);
                if (iIntValue >= 0) {
                    bv2.l(iIntValue);
                } else {
                    bv2.n(iIntValue);
                }
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iP = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iP += BV2.p(((Integer) list.get(i3)).intValue());
        }
        bv2.l(iP);
        while (i2 < list.size()) {
            int iIntValue2 = ((Integer) list.get(i2)).intValue();
            if (iIntValue2 >= 0) {
                bv2.l(iIntValue2);
            } else {
                bv2.n(iIntValue2);
            }
            i2++;
        }
    }

    public static void l(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.m(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += BV2.b(((Long) list.get(i3)).longValue());
        }
        bv2.l(iB);
        while (i2 < list.size()) {
            bv2.n(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void m(int i, List list, FV2 fv2, InterfaceC0784hY2 interfaceC0784hY2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            fv2.o(i, list.get(i2), interfaceC0784hY2);
        }
    }

    public static void n(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.f(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.g(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void o(int i, List list, FV2 fv2, boolean z) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.h(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        bv2.l(i3);
        while (i2 < list.size()) {
            bv2.i(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void p(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                bv2.l(i << 3);
                bv2.l((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iA += BV2.a((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        bv2.l(iA);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            bv2.l((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public static void q(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                bv2.m(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iB += BV2.b((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        bv2.l(iB);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            bv2.n((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public static void r(int i, List list, FV2 fv2) throws zzjh {
        if (list == null || list.isEmpty()) {
            return;
        }
        fv2.getClass();
        boolean z = list instanceof XW2;
        int i2 = 0;
        BV2 bv2 = fv2.a;
        if (!z) {
            while (i2 < list.size()) {
                bv2.j(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        XW2 xw2 = (XW2) list;
        while (i2 < list.size()) {
            Object objD = xw2.d(i2);
            if (objD instanceof String) {
                bv2.j(i, (String) objD);
            } else {
                bv2.e(i, (WU2) objD);
            }
            i2++;
        }
    }

    public static void s(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                bv2.l(i << 3);
                bv2.l(iIntValue);
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += BV2.a(((Integer) list.get(i3)).intValue());
        }
        bv2.l(iA);
        while (i2 < list.size()) {
            bv2.l(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void t(int i, List list, FV2 fv2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        BV2 bv2 = fv2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                bv2.m(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        bv2.k(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += BV2.b(((Long) list.get(i3)).longValue());
        }
        bv2.l(iB);
        while (i2 < list.size()) {
            bv2.n(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static boolean u(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int v(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.a(i << 3) + 1) * size;
    }

    public static FY2 w(boolean z) {
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
            return (FY2) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int x(List list) {
        return list.size();
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = BV2.r(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int iJ = ((WU2) list.get(i2)).j();
            iR = SX2.a(iJ, iJ, iR);
        }
        return iR;
    }

    public static int z(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (BV2.r(i) * size) + A(list);
    }
}
