package defpackage;

import com.google.android.gms.internal.play_billing.zzbw;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: lO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1025lO2 {
    public static final Class a;
    public static final C1331qP2 b;
    public static final C1331qP2 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        C1331qP2 c1331qP2 = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                c1331qP2 = (C1331qP2) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        b = c1331qP2;
        c = new C1331qP2();
    }

    public static void A(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC0521dJ2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.d(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        dh2.m(i3);
        while (i2 < list.size()) {
            dh2.e(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void B(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    dh2.h(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int iT = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iT += DH2.t(((Integer) list.get(i3)).intValue());
            }
            dh2.m(iT);
            while (i2 < list.size()) {
                dh2.i(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                dh2.h(i, qj2.g(i2));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iT2 = 0;
        for (int i4 = 0; i4 < qj2.v; i4++) {
            iT2 += DH2.t(qj2.g(i4));
        }
        dh2.m(iT2);
        while (i2 < qj2.v) {
            dh2.i(qj2.g(i2));
            i2++;
        }
    }

    public static void C(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1083mM2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.n(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iT += DH2.t(((Long) list.get(i3)).longValue());
        }
        dh2.m(iT);
        while (i2 < list.size()) {
            dh2.o(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void a(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    dh2.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            dh2.m(i3);
            while (i2 < list.size()) {
                dh2.e(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                dh2.d(i, qj2.g(i2));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < qj2.v; i6++) {
            qj2.g(i6);
            i5 += 4;
        }
        dh2.m(i5);
        while (i2 < qj2.v) {
            dh2.e(qj2.g(i2));
            i2++;
        }
    }

    public static void b(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1083mM2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.f(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        dh2.m(i3);
        while (i2 < list.size()) {
            dh2.g(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void c(int i, List list, OH2 oh2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    dh2.l(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int iS = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iS += DH2.s((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            dh2.m(iS);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                dh2.m((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                int iG = qj2.g(i2);
                dh2.l(i, (iG >> 31) ^ (iG + iG));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iS2 = 0;
        for (int i4 = 0; i4 < qj2.v; i4++) {
            int iG2 = qj2.g(i4);
            iS2 += DH2.s((iG2 >> 31) ^ (iG2 + iG2));
        }
        dh2.m(iS2);
        while (i2 < qj2.v) {
            int iG3 = qj2.g(i2);
            dh2.m((iG3 >> 31) ^ (iG3 + iG3));
            i2++;
        }
    }

    public static void d(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1083mM2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                dh2.n(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iT += DH2.t((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        dh2.m(iT);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            dh2.o((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public static void e(int i, List list, OH2 oh2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    dh2.l(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int iS = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iS += DH2.s(((Integer) list.get(i3)).intValue());
            }
            dh2.m(iS);
            while (i2 < list.size()) {
                dh2.m(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                dh2.l(i, qj2.g(i2));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iS2 = 0;
        for (int i4 = 0; i4 < qj2.v; i4++) {
            iS2 += DH2.s(qj2.g(i4));
        }
        dh2.m(iS2);
        while (i2 < qj2.v) {
            dh2.m(qj2.g(i2));
            i2++;
        }
    }

    public static void f(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1083mM2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.n(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iT = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iT += DH2.t(((Long) list.get(i3)).longValue());
        }
        dh2.m(iT);
        while (i2 < list.size()) {
            dh2.o(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int h(List list) {
        int iT;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof QJ2) {
            QJ2 qj2 = (QJ2) list;
            iT = 0;
            while (i < size) {
                iT += DH2.t(qj2.g(i));
                i++;
            }
        } else {
            iT = 0;
            while (i < size) {
                iT += DH2.t(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iT;
    }

    public static int i(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (DH2.s(i << 3) + 4) * size;
    }

    public static int j(List list) {
        return list.size() * 4;
    }

    public static int k(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (DH2.s(i << 3) + 8) * size;
    }

    public static int l(List list) {
        return list.size() * 8;
    }

    public static int m(List list) {
        int iT;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof QJ2) {
            QJ2 qj2 = (QJ2) list;
            iT = 0;
            while (i < size) {
                iT += DH2.t(qj2.g(i));
                i++;
            }
        } else {
            iT = 0;
            while (i < size) {
                iT += DH2.t(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iT;
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1083mM2) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += DH2.t(((Long) list.get(i)).longValue());
        }
        return iT;
    }

    public static int o(int i, Object obj, InterfaceC0773hO2 interfaceC0773hO2) {
        return DH2.q((AbstractC0948kF2) obj, interfaceC0773hO2) + DH2.s(i << 3);
    }

    public static int p(List list) {
        int iS;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof QJ2) {
            QJ2 qj2 = (QJ2) list;
            iS = 0;
            while (i < size) {
                int iG = qj2.g(i);
                iS += DH2.s((iG >> 31) ^ (iG + iG));
                i++;
            }
        } else {
            iS = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iS += DH2.s((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iS;
    }

    public static int q(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1083mM2) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iT += DH2.t((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iT;
    }

    public static int r(List list) {
        int iS;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof QJ2) {
            QJ2 qj2 = (QJ2) list;
            iS = 0;
            while (i < size) {
                iS += DH2.s(qj2.g(i));
                i++;
            }
        } else {
            iS = 0;
            while (i < size) {
                iS += DH2.s(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iS;
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof AbstractC1083mM2) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iT = 0;
        for (int i = 0; i < size; i++) {
            iT += DH2.t(((Long) list.get(i)).longValue());
        }
        return iT;
    }

    public static Object t(Object obj, int i, int i2, Object obj2, C1331qP2 c1331qP2) {
        Object obj3 = obj2;
        if (obj2 == null) {
            c1331qP2.getClass();
            LJ2 lj2 = (LJ2) obj;
            C1088mP2 c1088mP2 = lj2.zzc;
            obj3 = c1088mP2;
            if (c1088mP2 == C1088mP2.f) {
                C1088mP2 c1088mP2B = C1088mP2.b();
                lj2.zzc = c1088mP2B;
                obj3 = c1088mP2B;
            }
        }
        c1331qP2.getClass();
        ((C1088mP2) obj3).c(i << 3, Long.valueOf(i2));
        return obj3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void u(C1331qP2 c1331qP2, Object obj, Object obj2) {
        c1331qP2.getClass();
        LJ2 lj2 = (LJ2) obj;
        C1088mP2 c1088mP2 = lj2.zzc;
        C1088mP2 c1088mP22 = ((LJ2) obj2).zzc;
        C1088mP2 c1088mP23 = C1088mP2.f;
        if (!c1088mP23.equals(c1088mP22)) {
            if (c1088mP23.equals(c1088mP2)) {
                int i = c1088mP2.a + c1088mP22.a;
                int[] iArrCopyOf = Arrays.copyOf(c1088mP2.b, i);
                System.arraycopy(c1088mP22.b, 0, iArrCopyOf, c1088mP2.a, c1088mP22.a);
                Object[] objArrCopyOf = Arrays.copyOf(c1088mP2.c, i);
                System.arraycopy(c1088mP22.c, 0, objArrCopyOf, c1088mP2.a, c1088mP22.a);
                c1088mP2 = new C1088mP2(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                c1088mP2.getClass();
                if (!c1088mP22.equals(c1088mP23)) {
                    if (!c1088mP2.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i2 = c1088mP2.a + c1088mP22.a;
                    c1088mP2.e(i2);
                    System.arraycopy(c1088mP22.b, 0, c1088mP2.b, c1088mP2.a, c1088mP22.a);
                    System.arraycopy(c1088mP22.c, 0, c1088mP2.c, c1088mP2.a, c1088mP22.a);
                    c1088mP2.a = i2;
                }
            }
        }
        lj2.zzc = c1088mP2;
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
    public static void v(int i, List list, OH2 oh2, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1373rG2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                dh2.m(i << 3);
                dh2.a(zBooleanValue ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        dh2.m(i3);
        while (i2 < list.size()) {
            dh2.a(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void w(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1605vI2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.f(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        dh2.m(i3);
        while (i2 < list.size()) {
            dh2.g(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void x(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    dh2.h(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int iT = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iT += DH2.t(((Integer) list.get(i3)).intValue());
            }
            dh2.m(iT);
            while (i2 < list.size()) {
                dh2.i(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                dh2.h(i, qj2.g(i2));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int iT2 = 0;
        for (int i4 = 0; i4 < qj2.v; i4++) {
            iT2 += DH2.t(qj2.g(i4));
        }
        dh2.m(iT2);
        while (i2 < qj2.v) {
            dh2.i(qj2.g(i2));
            i2++;
        }
    }

    public static void y(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        boolean z2 = list instanceof QJ2;
        int i2 = 0;
        DH2 dh2 = oh2.a;
        if (!z2) {
            if (!z) {
                while (i2 < list.size()) {
                    dh2.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            dh2.k(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            dh2.m(i3);
            while (i2 < list.size()) {
                dh2.e(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        QJ2 qj2 = (QJ2) list;
        if (!z) {
            while (i2 < qj2.v) {
                dh2.d(i, qj2.g(i2));
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < qj2.v; i6++) {
            qj2.g(i6);
            i5 += 4;
        }
        dh2.m(i5);
        while (i2 < qj2.v) {
            dh2.e(qj2.g(i2));
            i2++;
        }
    }

    public static void z(int i, List list, OH2 oh2, boolean z) throws zzbw {
        if (list == null || list.isEmpty()) {
            return;
        }
        oh2.getClass();
        if (list instanceof AbstractC1083mM2) {
            throw new ClassCastException();
        }
        DH2 dh2 = oh2.a;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                dh2.f(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        dh2.k(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        dh2.m(i3);
        while (i2 < list.size()) {
            dh2.g(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
