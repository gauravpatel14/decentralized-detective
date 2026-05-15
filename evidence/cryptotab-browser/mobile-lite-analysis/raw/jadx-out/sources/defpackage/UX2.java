package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzkm;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UX2 implements InterfaceC0784hY2 {
    public static final int[] l = new int[0];
    public static final Unsafe m = NY2.j();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final CU2 e;
    public final boolean f;
    public final int[] g;
    public final int h;
    public final int i;
    public final AbstractC0716gX2 j;
    public final FY2 k;

    public UX2(int[] iArr, Object[] objArr, int i, int i2, CU2 cu2, boolean z, int[] iArr2, int i3, int i4, AbstractC0716gX2 abstractC0716gX2, FY2 fy2, NV2 nv2, JX2 jx2) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = z;
        this.g = iArr2;
        this.h = i3;
        this.i = i4;
        this.j = abstractC0716gX2;
        this.k = fy2;
        this.e = cu2;
    }

    public static UX2 A(C0718gY2 c0718gY2, AbstractC0716gX2 abstractC0716gX2, FY2 fy2, NV2 nv2, JX2 jx2) {
        if (c0718gY2 instanceof C0718gY2) {
            return B(c0718gY2, abstractC0716gX2, fy2, nv2, jx2);
        }
        c0718gY2.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x037a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.UX2 B(defpackage.C0718gY2 r32, defpackage.AbstractC0716gX2 r33, defpackage.FY2 r34, defpackage.NV2 r35, defpackage.JX2 r36) {
        /*
            Method dump skipped, instruction units count: 1004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UX2.B(gY2, gX2, FY2, NV2, JX2):UX2");
    }

    public static int E(long j, Object obj) {
        return ((Integer) NY2.c.m(j, obj)).intValue();
    }

    public static int j(int i) {
        return (i >>> 20) & 255;
    }

    public static long l(long j, Object obj) {
        return ((Long) NY2.c.m(j, obj)).longValue();
    }

    public static Field p(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static final void x(int i, Object obj, FV2 fv2) throws zzjh {
        if (!(obj instanceof String)) {
            fv2.f(i, (WU2) obj);
        } else {
            fv2.a.j(i, (String) obj);
        }
    }

    public static EY2 z(Object obj) {
        AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) obj;
        EY2 ey2 = abstractC1852zW2.zzc;
        if (ey2 != EY2.f) {
            return ey2;
        }
        EY2 ey2B = EY2.b();
        abstractC1852zW2.zzc = ey2B;
        return ey2B;
    }

    public final int C(Object obj) {
        int i;
        int iA;
        int iB;
        int iA2;
        int iP;
        int iK;
        Unsafe unsafe = m;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int iA3 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i4 >= iArr.length) {
                this.k.getClass();
                return FY2.a(FY2.b(obj)) + iA3;
            }
            int iK2 = k(i4);
            int i6 = iArr[i4];
            int iJ = j(iK2);
            if (iJ <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            long j = iK2 & i2;
            switch (iJ) {
                case 0:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 2:
                    if ((i & i5) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b(j2);
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 3:
                    if ((i & i5) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b(j3);
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 4:
                    if ((i & i5) != 0) {
                        int i9 = unsafe.getInt(obj, j);
                        iA2 = BV2.a(i6 << 3);
                        iP = BV2.p(i9);
                        iK = iP + iA2;
                        iA3 += iK;
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 1, iA3);
                    }
                    break;
                case 8:
                    if ((i & i5) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (!(object instanceof WU2)) {
                            iA2 = BV2.a(i6 << 3);
                            iP = BV2.q((String) object);
                            iK = iP + iA2;
                            iA3 += iK;
                        } else {
                            int iA4 = BV2.a(i6 << 3);
                            int iJ2 = ((WU2) object).j();
                            iA3 = SX2.b(iJ2, iJ2, iA4, iA3);
                        }
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if ((i & i5) != 0) {
                        iK = AbstractC0849iY2.K(i6, unsafe.getObject(obj, j), n(i4));
                        iA3 += iK;
                    }
                    break;
                case 10:
                    if ((i & i5) != 0) {
                        WU2 wu2 = (WU2) unsafe.getObject(obj, j);
                        int iA5 = BV2.a(i6 << 3);
                        int iJ3 = wu2.j();
                        iA3 = SX2.b(iJ3, iJ3, iA5, iA3);
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if ((i & i5) != 0) {
                        iA3 = SX2.a(unsafe.getInt(obj, j), BV2.a(i6 << 3), iA3);
                    }
                    break;
                case 12:
                    if ((i & i5) != 0) {
                        int i10 = unsafe.getInt(obj, j);
                        iA2 = BV2.a(i6 << 3);
                        iP = BV2.p(i10);
                        iK = iP + iA2;
                        iA3 += iK;
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 15:
                    if ((i & i5) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iA3 = SX2.a((i11 >> 31) ^ (i11 + i11), BV2.a(i6 << 3), iA3);
                    }
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b((j4 >> 63) ^ (j4 + j4));
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 17:
                    if ((i & i5) != 0) {
                        iK = BV2.o(i6, (CU2) unsafe.getObject(obj, j), n(i4));
                        iA3 += iK;
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    iK = AbstractC0849iY2.D(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 19:
                    iK = AbstractC0849iY2.B(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 20:
                    iK = AbstractC0849iY2.I(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    iK = AbstractC0849iY2.T(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 22:
                    iK = AbstractC0849iY2.G(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    iK = AbstractC0849iY2.D(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    iK = AbstractC0849iY2.B(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 25:
                    iK = AbstractC0849iY2.v(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 26:
                    iK = AbstractC0849iY2.Q(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 27:
                    iK = AbstractC0849iY2.L(i6, (List) unsafe.getObject(obj, j), n(i4));
                    iA3 += iK;
                    break;
                case 28:
                    iK = AbstractC0849iY2.y(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 29:
                    iK = AbstractC0849iY2.R(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 30:
                    iK = AbstractC0849iY2.z(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 31:
                    iK = AbstractC0849iY2.B(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 32:
                    iK = AbstractC0849iY2.D(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 33:
                    iK = AbstractC0849iY2.M(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 34:
                    iK = AbstractC0849iY2.O(i6, (List) unsafe.getObject(obj, j));
                    iA3 += iK;
                    break;
                case 35:
                    int iE = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA3 = SX2.b(iE, BV2.r(i6), iE, iA3);
                    }
                    break;
                case 36:
                    int iC = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC > 0) {
                        iA3 = SX2.b(iC, BV2.r(i6), iC, iA3);
                    }
                    break;
                case 37:
                    int iJ4 = AbstractC0849iY2.J((List) unsafe.getObject(obj, j));
                    if (iJ4 > 0) {
                        iA3 = SX2.b(iJ4, BV2.r(i6), iJ4, iA3);
                    }
                    break;
                case 38:
                    int iU = AbstractC0849iY2.U((List) unsafe.getObject(obj, j));
                    if (iU > 0) {
                        iA3 = SX2.b(iU, BV2.r(i6), iU, iA3);
                    }
                    break;
                case 39:
                    int iH = AbstractC0849iY2.H((List) unsafe.getObject(obj, j));
                    if (iH > 0) {
                        iA3 = SX2.b(iH, BV2.r(i6), iH, iA3);
                    }
                    break;
                case 40:
                    int iE2 = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE2 > 0) {
                        iA3 = SX2.b(iE2, BV2.r(i6), iE2, iA3);
                    }
                    break;
                case 41:
                    int iC2 = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC2 > 0) {
                        iA3 = SX2.b(iC2, BV2.r(i6), iC2, iA3);
                    }
                    break;
                case 42:
                    int iX = AbstractC0849iY2.x((List) unsafe.getObject(obj, j));
                    if (iX > 0) {
                        iA3 = SX2.b(iX, BV2.r(i6), iX, iA3);
                    }
                    break;
                case 43:
                    int iS = AbstractC0849iY2.S((List) unsafe.getObject(obj, j));
                    if (iS > 0) {
                        iA3 = SX2.b(iS, BV2.r(i6), iS, iA3);
                    }
                    break;
                case 44:
                    int iA6 = AbstractC0849iY2.A((List) unsafe.getObject(obj, j));
                    if (iA6 > 0) {
                        iA3 = SX2.b(iA6, BV2.r(i6), iA6, iA3);
                    }
                    break;
                case 45:
                    int iC3 = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC3 > 0) {
                        iA3 = SX2.b(iC3, BV2.r(i6), iC3, iA3);
                    }
                    break;
                case 46:
                    int iE3 = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE3 > 0) {
                        iA3 = SX2.b(iE3, BV2.r(i6), iE3, iA3);
                    }
                    break;
                case 47:
                    int iN = AbstractC0849iY2.N((List) unsafe.getObject(obj, j));
                    if (iN > 0) {
                        iA3 = SX2.b(iN, BV2.r(i6), iN, iA3);
                    }
                    break;
                case 48:
                    int iP2 = AbstractC0849iY2.P((List) unsafe.getObject(obj, j));
                    if (iP2 > 0) {
                        iA3 = SX2.b(iP2, BV2.r(i6), iP2, iA3);
                    }
                    break;
                case 49:
                    iK = AbstractC0849iY2.F(i6, (List) unsafe.getObject(obj, j), n(i4));
                    iA3 += iK;
                    break;
                case 50:
                    JX2.a(unsafe.getObject(obj, j), o(i4));
                    break;
                case 51:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 52:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 53:
                    if (w(i6, i4, obj)) {
                        long jL = l(j, obj);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b(jL);
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 54:
                    if (w(i6, i4, obj)) {
                        long jL2 = l(j, obj);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b(jL2);
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 55:
                    if (w(i6, i4, obj)) {
                        int iE4 = E(j, obj);
                        iA2 = BV2.a(i6 << 3);
                        iP = BV2.p(iE4);
                        iK = iP + iA2;
                        iA3 += iK;
                    }
                    break;
                case 56:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 57:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 58:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 1, iA3);
                    }
                    break;
                case 59:
                    if (w(i6, i4, obj)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (!(object2 instanceof WU2)) {
                            iA2 = BV2.a(i6 << 3);
                            iP = BV2.q((String) object2);
                            iK = iP + iA2;
                            iA3 += iK;
                        } else {
                            int iA7 = BV2.a(i6 << 3);
                            int iJ5 = ((WU2) object2).j();
                            iA3 = SX2.b(iJ5, iJ5, iA7, iA3);
                        }
                    }
                    break;
                case 60:
                    if (w(i6, i4, obj)) {
                        iK = AbstractC0849iY2.K(i6, unsafe.getObject(obj, j), n(i4));
                        iA3 += iK;
                    }
                    break;
                case 61:
                    if (w(i6, i4, obj)) {
                        WU2 wu22 = (WU2) unsafe.getObject(obj, j);
                        int iA8 = BV2.a(i6 << 3);
                        int iJ6 = wu22.j();
                        iA3 = SX2.b(iJ6, iJ6, iA8, iA3);
                    }
                    break;
                case 62:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(E(j, obj), BV2.a(i6 << 3), iA3);
                    }
                    break;
                case 63:
                    if (w(i6, i4, obj)) {
                        int iE5 = E(j, obj);
                        iA2 = BV2.a(i6 << 3);
                        iP = BV2.p(iE5);
                        iK = iP + iA2;
                        iA3 += iK;
                    }
                    break;
                case 64:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 4, iA3);
                    }
                    break;
                case 65:
                    if (w(i6, i4, obj)) {
                        iA3 = SX2.a(i6 << 3, 8, iA3);
                    }
                    break;
                case 66:
                    if (w(i6, i4, obj)) {
                        int iE6 = E(j, obj);
                        iA3 = SX2.a((iE6 >> 31) ^ (iE6 + iE6), BV2.a(i6 << 3), iA3);
                    }
                    break;
                case 67:
                    if (w(i6, i4, obj)) {
                        long jL3 = l(j, obj);
                        iA = BV2.a(i6 << 3);
                        iB = BV2.b((jL3 >> 63) ^ (jL3 + jL3));
                        iK = iB + iA;
                        iA3 += iK;
                    }
                    break;
                case 68:
                    if (w(i6, i4, obj)) {
                        iK = BV2.o(i6, (CU2) unsafe.getObject(obj, j), n(i4));
                        iA3 += iK;
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
    }

    public final int D(Object obj) {
        int iA;
        int iB;
        int iA2;
        int iP;
        int iK;
        int iA3;
        int iB2;
        Unsafe unsafe = m;
        int i = 0;
        int iA4 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                this.k.getClass();
                return FY2.a(FY2.b(obj)) + iA4;
            }
            int iK2 = k(i);
            int iJ = j(iK2);
            int i2 = iArr[i];
            long j = iK2 & 1048575;
            if (iJ >= TV2.u.a() && iJ <= TV2.v.a()) {
                int i3 = iArr[i + 2];
            }
            switch (iJ) {
                case 0:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 1:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 2:
                    if (v(i, obj)) {
                        long jG = NY2.g(j, obj);
                        iA = BV2.a(i2 << 3);
                        iB = BV2.b(jG);
                        iK = iB + iA;
                        iA4 = iK + iA4;
                    }
                    break;
                case 3:
                    if (v(i, obj)) {
                        long jG2 = NY2.g(j, obj);
                        iA = BV2.a(i2 << 3);
                        iB = BV2.b(jG2);
                        iK = iB + iA;
                        iA4 = iK + iA4;
                    }
                    break;
                case 4:
                    if (v(i, obj)) {
                        int iF = NY2.f(j, obj);
                        iA2 = BV2.a(i2 << 3);
                        iP = BV2.p(iF);
                        iK = iP + iA2;
                        iA4 = iK + iA4;
                    }
                    break;
                case 5:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 6:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 7:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 1, iA4);
                    }
                    break;
                case 8:
                    if (v(i, obj)) {
                        Object objI = NY2.i(j, obj);
                        if (!(objI instanceof WU2)) {
                            iA2 = BV2.a(i2 << 3);
                            iP = BV2.q((String) objI);
                            iK = iP + iA2;
                            iA4 = iK + iA4;
                        } else {
                            int iA5 = BV2.a(i2 << 3);
                            int iJ2 = ((WU2) objI).j();
                            iA4 = SX2.b(iJ2, iJ2, iA5, iA4);
                        }
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if (v(i, obj)) {
                        iK = AbstractC0849iY2.K(i2, NY2.i(j, obj), n(i));
                        iA4 = iK + iA4;
                    }
                    break;
                case 10:
                    if (v(i, obj)) {
                        WU2 wu2 = (WU2) NY2.i(j, obj);
                        int iA6 = BV2.a(i2 << 3);
                        int iJ3 = wu2.j();
                        iA4 = SX2.b(iJ3, iJ3, iA6, iA4);
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (v(i, obj)) {
                        iA4 = SX2.a(NY2.f(j, obj), BV2.a(i2 << 3), iA4);
                    }
                    break;
                case 12:
                    if (v(i, obj)) {
                        int iF2 = NY2.f(j, obj);
                        iA2 = BV2.a(i2 << 3);
                        iP = BV2.p(iF2);
                        iK = iP + iA2;
                        iA4 = iK + iA4;
                    }
                    break;
                case 13:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 14:
                    if (v(i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 15:
                    if (v(i, obj)) {
                        int iF3 = NY2.f(j, obj);
                        iA4 = SX2.a((iF3 >> 31) ^ (iF3 + iF3), BV2.a(i2 << 3), iA4);
                    }
                    break;
                case 16:
                    if (v(i, obj)) {
                        long jG3 = NY2.g(j, obj);
                        iA3 = BV2.a(i2 << 3);
                        iB2 = BV2.b((jG3 + jG3) ^ (jG3 >> 63));
                        iA4 = iB2 + iA3 + iA4;
                    }
                    break;
                case 17:
                    if (v(i, obj)) {
                        iK = BV2.o(i2, (CU2) NY2.i(j, obj), n(i));
                        iA4 = iK + iA4;
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    iK = AbstractC0849iY2.D(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 19:
                    iK = AbstractC0849iY2.B(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 20:
                    iK = AbstractC0849iY2.I(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    iK = AbstractC0849iY2.T(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 22:
                    iK = AbstractC0849iY2.G(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    iK = AbstractC0849iY2.D(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    iK = AbstractC0849iY2.B(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 25:
                    iK = AbstractC0849iY2.v(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 26:
                    iK = AbstractC0849iY2.Q(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 27:
                    iK = AbstractC0849iY2.L(i2, (List) NY2.i(j, obj), n(i));
                    iA4 = iK + iA4;
                    break;
                case 28:
                    iK = AbstractC0849iY2.y(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 29:
                    iK = AbstractC0849iY2.R(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 30:
                    iK = AbstractC0849iY2.z(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 31:
                    iK = AbstractC0849iY2.B(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 32:
                    iK = AbstractC0849iY2.D(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 33:
                    iK = AbstractC0849iY2.M(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 34:
                    iK = AbstractC0849iY2.O(i2, (List) NY2.i(j, obj));
                    iA4 = iK + iA4;
                    break;
                case 35:
                    int iE = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE > 0) {
                        iA4 = SX2.b(iE, BV2.r(i2), iE, iA4);
                    }
                    break;
                case 36:
                    int iC = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC > 0) {
                        iA4 = SX2.b(iC, BV2.r(i2), iC, iA4);
                    }
                    break;
                case 37:
                    int iJ4 = AbstractC0849iY2.J((List) unsafe.getObject(obj, j));
                    if (iJ4 > 0) {
                        iA4 = SX2.b(iJ4, BV2.r(i2), iJ4, iA4);
                    }
                    break;
                case 38:
                    int iU = AbstractC0849iY2.U((List) unsafe.getObject(obj, j));
                    if (iU > 0) {
                        iA4 = SX2.b(iU, BV2.r(i2), iU, iA4);
                    }
                    break;
                case 39:
                    int iH = AbstractC0849iY2.H((List) unsafe.getObject(obj, j));
                    if (iH > 0) {
                        iA4 = SX2.b(iH, BV2.r(i2), iH, iA4);
                    }
                    break;
                case 40:
                    int iE2 = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE2 > 0) {
                        iA4 = SX2.b(iE2, BV2.r(i2), iE2, iA4);
                    }
                    break;
                case 41:
                    int iC2 = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC2 > 0) {
                        iA4 = SX2.b(iC2, BV2.r(i2), iC2, iA4);
                    }
                    break;
                case 42:
                    int iX = AbstractC0849iY2.x((List) unsafe.getObject(obj, j));
                    if (iX > 0) {
                        iA4 = SX2.b(iX, BV2.r(i2), iX, iA4);
                    }
                    break;
                case 43:
                    int iS = AbstractC0849iY2.S((List) unsafe.getObject(obj, j));
                    if (iS > 0) {
                        iA4 = SX2.b(iS, BV2.r(i2), iS, iA4);
                    }
                    break;
                case 44:
                    int iA7 = AbstractC0849iY2.A((List) unsafe.getObject(obj, j));
                    if (iA7 > 0) {
                        iA4 = SX2.b(iA7, BV2.r(i2), iA7, iA4);
                    }
                    break;
                case 45:
                    int iC3 = AbstractC0849iY2.C((List) unsafe.getObject(obj, j));
                    if (iC3 > 0) {
                        iA4 = SX2.b(iC3, BV2.r(i2), iC3, iA4);
                    }
                    break;
                case 46:
                    int iE3 = AbstractC0849iY2.E((List) unsafe.getObject(obj, j));
                    if (iE3 > 0) {
                        iA4 = SX2.b(iE3, BV2.r(i2), iE3, iA4);
                    }
                    break;
                case 47:
                    int iN = AbstractC0849iY2.N((List) unsafe.getObject(obj, j));
                    if (iN > 0) {
                        iA4 = SX2.b(iN, BV2.r(i2), iN, iA4);
                    }
                    break;
                case 48:
                    int iP2 = AbstractC0849iY2.P((List) unsafe.getObject(obj, j));
                    if (iP2 > 0) {
                        iA4 = SX2.b(iP2, BV2.r(i2), iP2, iA4);
                    }
                    break;
                case 49:
                    iK = AbstractC0849iY2.F(i2, (List) NY2.i(j, obj), n(i));
                    iA4 = iK + iA4;
                    break;
                case 50:
                    JX2.a(NY2.i(j, obj), o(i));
                    break;
                case 51:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 52:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 53:
                    if (w(i2, i, obj)) {
                        long jL = l(j, obj);
                        iA = BV2.a(i2 << 3);
                        iB = BV2.b(jL);
                        iK = iB + iA;
                        iA4 = iK + iA4;
                    }
                    break;
                case 54:
                    if (w(i2, i, obj)) {
                        long jL2 = l(j, obj);
                        iA = BV2.a(i2 << 3);
                        iB = BV2.b(jL2);
                        iK = iB + iA;
                        iA4 = iK + iA4;
                    }
                    break;
                case 55:
                    if (w(i2, i, obj)) {
                        int iE4 = E(j, obj);
                        iA2 = BV2.a(i2 << 3);
                        iP = BV2.p(iE4);
                        iK = iP + iA2;
                        iA4 = iK + iA4;
                    }
                    break;
                case 56:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 57:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 58:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 1, iA4);
                    }
                    break;
                case 59:
                    if (w(i2, i, obj)) {
                        Object objI2 = NY2.i(j, obj);
                        if (!(objI2 instanceof WU2)) {
                            iA2 = BV2.a(i2 << 3);
                            iP = BV2.q((String) objI2);
                            iK = iP + iA2;
                            iA4 = iK + iA4;
                        } else {
                            int iA8 = BV2.a(i2 << 3);
                            int iJ5 = ((WU2) objI2).j();
                            iA4 = SX2.b(iJ5, iJ5, iA8, iA4);
                        }
                    }
                    break;
                case 60:
                    if (w(i2, i, obj)) {
                        iK = AbstractC0849iY2.K(i2, NY2.i(j, obj), n(i));
                        iA4 = iK + iA4;
                    }
                    break;
                case 61:
                    if (w(i2, i, obj)) {
                        WU2 wu22 = (WU2) NY2.i(j, obj);
                        int iA9 = BV2.a(i2 << 3);
                        int iJ6 = wu22.j();
                        iA4 = SX2.b(iJ6, iJ6, iA9, iA4);
                    }
                    break;
                case 62:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(E(j, obj), BV2.a(i2 << 3), iA4);
                    }
                    break;
                case 63:
                    if (w(i2, i, obj)) {
                        int iE5 = E(j, obj);
                        iA2 = BV2.a(i2 << 3);
                        iP = BV2.p(iE5);
                        iK = iP + iA2;
                        iA4 = iK + iA4;
                    }
                    break;
                case 64:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 4, iA4);
                    }
                    break;
                case 65:
                    if (w(i2, i, obj)) {
                        iA4 = SX2.a(i2 << 3, 8, iA4);
                    }
                    break;
                case 66:
                    if (w(i2, i, obj)) {
                        int iE6 = E(j, obj);
                        iA4 = SX2.a((iE6 >> 31) ^ (iE6 + iE6), BV2.a(i2 << 3), iA4);
                    }
                    break;
                case 67:
                    if (w(i2, i, obj)) {
                        long jL3 = l(j, obj);
                        iA3 = BV2.a(i2 << 3);
                        iB2 = BV2.b((jL3 + jL3) ^ (jL3 >> 63));
                        iA4 = iB2 + iA3 + iA4;
                    }
                    break;
                case 68:
                    if (w(i2, i, obj)) {
                        iK = BV2.o(i2, (CU2) NY2.i(j, obj), n(i));
                        iA4 = iK + iA4;
                    }
                    break;
            }
            i += 3;
        }
    }

    public final void F(int i, long j, Object obj) {
        Unsafe unsafe = m;
        Object objO = o(i);
        Object object = unsafe.getObject(obj, j);
        if (!((HX2) object).c()) {
            HX2 hx2B = HX2.a().b();
            JX2.b(hx2B, object);
            unsafe.putObject(obj, j, hx2B);
        }
        yi1.a(objO);
        throw null;
    }

    public final int G(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, HU2 hu2) throws zzkm {
        Unsafe unsafe = m;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(JU2.n(i, bArr))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(JU2.b(i, bArr))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iM = JU2.m(bArr, i, hu2);
                unsafe.putObject(obj, j, Long.valueOf(hu2.b));
                unsafe.putInt(obj, j2, i4);
                return iM;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iJ = JU2.j(bArr, i, hu2);
                unsafe.putObject(obj, j, Integer.valueOf(hu2.a));
                unsafe.putInt(obj, j2, i4);
                return iJ;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(JU2.n(i, bArr)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(JU2.b(i, bArr)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iM2 = JU2.m(bArr, i, hu2);
                unsafe.putObject(obj, j, Boolean.valueOf(hu2.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iM2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iJ2 = JU2.j(bArr, i, hu2);
                int i9 = hu2.a;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !AbstractC0850iZ2.d(bArr, iJ2, iJ2 + i9)) {
                        throw zzkm.a();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iJ2, i9, NW2.a));
                    iJ2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iJ2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iD = JU2.d(n(i8), bArr, i, i2, hu2);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, hu2.c);
                } else {
                    unsafe.putObject(obj, j, NW2.b(object, hu2.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iD;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA = JU2.a(bArr, i, hu2);
                unsafe.putObject(obj, j, hu2.c);
                unsafe.putInt(obj, j2, i4);
                return iA;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iJ3 = JU2.j(bArr, i, hu2);
                int i10 = hu2.a;
                FW2 fw2M = m(i8);
                if (fw2M == null || fw2M.a(i10)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    z(obj).c(i3, Long.valueOf(i10));
                }
                return iJ3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iJ4 = JU2.j(bArr, i, hu2);
                unsafe.putObject(obj, j, Integer.valueOf(AbstractC1736xV2.a(hu2.a)));
                unsafe.putInt(obj, j2, i4);
                return iJ4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iM3 = JU2.m(bArr, i, hu2);
                unsafe.putObject(obj, j, Long.valueOf(AbstractC1736xV2.b(hu2.b)));
                unsafe.putInt(obj, j2, i4);
                return iM3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iC = JU2.c(n(i8), bArr, i, i2, (i3 & (-8)) | 4, hu2);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, hu2.c);
                } else {
                    unsafe.putObject(obj, j, NW2.b(object2, hu2.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iC;
            default:
                return i;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00a2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(java.lang.Object r32, byte[] r33, int r34, int r35, defpackage.HU2 r36) throws com.google.android.gms.internal.measurement.zzkm {
        /*
            Method dump skipped, instruction units count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UX2.H(java.lang.Object, byte[], int, int, HU2):void");
    }

    public final int I(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, HU2 hu2) throws zzkm {
        int i8;
        int i9;
        int iL;
        int iJ = i;
        Unsafe unsafe = m;
        EU2 eu2 = (EU2) ((LW2) unsafe.getObject(obj, j2));
        boolean zF = eu2.f();
        EU2 eu22 = eu2;
        if (!zF) {
            int size = eu2.size();
            LW2 lw2C = eu2.c(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, lw2C);
            eu22 = lw2C;
        }
        switch (i7) {
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
            case 35:
                if (i5 == 2) {
                    SX2.c(eu22);
                    int iJ2 = JU2.j(bArr, iJ, hu2);
                    int i10 = hu2.a + iJ2;
                    if (iJ2 < i10) {
                        Double.longBitsToDouble(JU2.n(iJ2, bArr));
                        throw null;
                    }
                    if (iJ2 == i10) {
                        return iJ2;
                    }
                    throw zzkm.d();
                }
                if (i5 == 1) {
                    SX2.c(eu22);
                    Double.longBitsToDouble(JU2.n(iJ, bArr));
                    throw null;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    SX2.c(eu22);
                    int iJ3 = JU2.j(bArr, iJ, hu2);
                    int i11 = hu2.a + iJ3;
                    if (iJ3 < i11) {
                        Float.intBitsToFloat(JU2.b(iJ3, bArr));
                        throw null;
                    }
                    if (iJ3 == i11) {
                        return iJ3;
                    }
                    throw zzkm.d();
                }
                if (i5 == 5) {
                    SX2.c(eu22);
                    Float.intBitsToFloat(JU2.b(iJ, bArr));
                    throw null;
                }
                break;
            case 20:
            case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
            case 37:
            case 38:
                if (i5 == 2) {
                    C0847iX2 c0847iX2 = (C0847iX2) eu22;
                    int iJ4 = JU2.j(bArr, iJ, hu2);
                    int i12 = hu2.a + iJ4;
                    while (iJ4 < i12) {
                        iJ4 = JU2.m(bArr, iJ4, hu2);
                        c0847iX2.g(hu2.b);
                    }
                    if (iJ4 == i12) {
                        return iJ4;
                    }
                    throw zzkm.d();
                }
                if (i5 == 0) {
                    C0847iX2 c0847iX22 = (C0847iX2) eu22;
                    int iM = JU2.m(bArr, iJ, hu2);
                    c0847iX22.g(hu2.b);
                    while (iM < i2) {
                        int iJ5 = JU2.j(bArr, iM, hu2);
                        if (i3 != hu2.a) {
                            return iM;
                        }
                        iM = JU2.m(bArr, iJ5, hu2);
                        c0847iX22.g(hu2.b);
                    }
                    return iM;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return JU2.f(bArr, iJ, eu22, hu2);
                }
                if (i5 == 0) {
                    return JU2.l(i3, bArr, i, i2, eu22, hu2);
                }
                break;
            case ConnectionResult.API_DISABLED /* 23 */:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    C0847iX2 c0847iX23 = (C0847iX2) eu22;
                    int iJ6 = JU2.j(bArr, iJ, hu2);
                    int i13 = hu2.a + iJ6;
                    while (iJ6 < i13) {
                        c0847iX23.g(JU2.n(iJ6, bArr));
                        iJ6 += 8;
                    }
                    if (iJ6 == i13) {
                        return iJ6;
                    }
                    throw zzkm.d();
                }
                if (i5 == 1) {
                    C0847iX2 c0847iX24 = (C0847iX2) eu22;
                    c0847iX24.g(JU2.n(iJ, bArr));
                    while (true) {
                        i8 = iJ + 8;
                        if (i8 < i2) {
                            iJ = JU2.j(bArr, i8, hu2);
                            if (i3 == hu2.a) {
                                c0847iX24.g(JU2.n(iJ, bArr));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    BW2 bw2 = (BW2) eu22;
                    int iJ7 = JU2.j(bArr, iJ, hu2);
                    int i14 = hu2.a + iJ7;
                    while (iJ7 < i14) {
                        bw2.g(JU2.b(iJ7, bArr));
                        iJ7 += 4;
                    }
                    if (iJ7 == i14) {
                        return iJ7;
                    }
                    throw zzkm.d();
                }
                if (i5 == 5) {
                    BW2 bw22 = (BW2) eu22;
                    bw22.g(JU2.b(iJ, bArr));
                    while (true) {
                        i9 = iJ + 4;
                        if (i9 < i2) {
                            iJ = JU2.j(bArr, i9, hu2);
                            if (i3 == hu2.a) {
                                bw22.g(JU2.b(iJ, bArr));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    SX2.c(eu22);
                    int iJ8 = JU2.j(bArr, iJ, hu2);
                    int i15 = hu2.a + iJ8;
                    if (iJ8 < i15) {
                        JU2.m(bArr, iJ8, hu2);
                        throw null;
                    }
                    if (iJ8 == i15) {
                        return iJ8;
                    }
                    throw zzkm.d();
                }
                if (i5 == 0) {
                    SX2.c(eu22);
                    JU2.m(bArr, iJ, hu2);
                    throw null;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iJ9 = JU2.j(bArr, iJ, hu2);
                        int i16 = hu2.a;
                        if (i16 < 0) {
                            throw zzkm.b();
                        }
                        if (i16 == 0) {
                            eu22.add("");
                        } else {
                            eu22.add(new String(bArr, iJ9, i16, NW2.a));
                            iJ9 += i16;
                        }
                        while (iJ9 < i2) {
                            int iJ10 = JU2.j(bArr, iJ9, hu2);
                            if (i3 != hu2.a) {
                                return iJ9;
                            }
                            iJ9 = JU2.j(bArr, iJ10, hu2);
                            int i17 = hu2.a;
                            if (i17 < 0) {
                                throw zzkm.b();
                            }
                            if (i17 == 0) {
                                eu22.add("");
                            } else {
                                eu22.add(new String(bArr, iJ9, i17, NW2.a));
                                iJ9 += i17;
                            }
                        }
                        return iJ9;
                    }
                    int iJ11 = JU2.j(bArr, iJ, hu2);
                    int i18 = hu2.a;
                    if (i18 < 0) {
                        throw zzkm.b();
                    }
                    if (i18 == 0) {
                        eu22.add("");
                    } else {
                        int i19 = iJ11 + i18;
                        if (!AbstractC0850iZ2.d(bArr, iJ11, i19)) {
                            throw zzkm.a();
                        }
                        eu22.add(new String(bArr, iJ11, i18, NW2.a));
                        iJ11 = i19;
                    }
                    while (iJ11 < i2) {
                        int iJ12 = JU2.j(bArr, iJ11, hu2);
                        if (i3 != hu2.a) {
                            return iJ11;
                        }
                        iJ11 = JU2.j(bArr, iJ12, hu2);
                        int i20 = hu2.a;
                        if (i20 < 0) {
                            throw zzkm.b();
                        }
                        if (i20 == 0) {
                            eu22.add("");
                        } else {
                            int i21 = iJ11 + i20;
                            if (!AbstractC0850iZ2.d(bArr, iJ11, i21)) {
                                throw zzkm.a();
                            }
                            eu22.add(new String(bArr, iJ11, i20, NW2.a));
                            iJ11 = i21;
                        }
                    }
                    return iJ11;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return JU2.e(n(i6), i3, bArr, i, i2, eu22, hu2);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iJ13 = JU2.j(bArr, iJ, hu2);
                    int i22 = hu2.a;
                    if (i22 < 0) {
                        throw zzkm.b();
                    }
                    if (i22 > bArr.length - iJ13) {
                        throw zzkm.d();
                    }
                    if (i22 == 0) {
                        eu22.add(WU2.v);
                    } else {
                        eu22.add(WU2.p(bArr, iJ13, i22));
                        iJ13 += i22;
                    }
                    while (iJ13 < i2) {
                        int iJ14 = JU2.j(bArr, iJ13, hu2);
                        if (i3 != hu2.a) {
                            return iJ13;
                        }
                        iJ13 = JU2.j(bArr, iJ14, hu2);
                        int i23 = hu2.a;
                        if (i23 < 0) {
                            throw zzkm.b();
                        }
                        if (i23 > bArr.length - iJ13) {
                            throw zzkm.d();
                        }
                        if (i23 == 0) {
                            eu22.add(WU2.v);
                        } else {
                            eu22.add(WU2.p(bArr, iJ13, i23));
                            iJ13 += i23;
                        }
                    }
                    return iJ13;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iL = JU2.f(bArr, iJ, eu22, hu2);
                } else if (i5 == 0) {
                    iL = JU2.l(i3, bArr, i, i2, eu22, hu2);
                }
                AbstractC1852zW2 abstractC1852zW2 = (AbstractC1852zW2) obj;
                EY2 ey2 = abstractC1852zW2.zzc;
                Object objA = AbstractC0849iY2.a(i4, eu22, m(i6), ey2 != EY2.f ? ey2 : null, this.k);
                if (objA == null) {
                    return iL;
                }
                abstractC1852zW2.zzc = (EY2) objA;
                return iL;
            case 33:
            case 47:
                if (i5 == 2) {
                    BW2 bw23 = (BW2) eu22;
                    int iJ15 = JU2.j(bArr, iJ, hu2);
                    int i24 = hu2.a + iJ15;
                    while (iJ15 < i24) {
                        iJ15 = JU2.j(bArr, iJ15, hu2);
                        bw23.g(AbstractC1736xV2.a(hu2.a));
                    }
                    if (iJ15 == i24) {
                        return iJ15;
                    }
                    throw zzkm.d();
                }
                if (i5 == 0) {
                    BW2 bw24 = (BW2) eu22;
                    int iJ16 = JU2.j(bArr, iJ, hu2);
                    bw24.g(AbstractC1736xV2.a(hu2.a));
                    while (iJ16 < i2) {
                        int iJ17 = JU2.j(bArr, iJ16, hu2);
                        if (i3 != hu2.a) {
                            return iJ16;
                        }
                        iJ16 = JU2.j(bArr, iJ17, hu2);
                        bw24.g(AbstractC1736xV2.a(hu2.a));
                    }
                    return iJ16;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    C0847iX2 c0847iX25 = (C0847iX2) eu22;
                    int iJ18 = JU2.j(bArr, iJ, hu2);
                    int i25 = hu2.a + iJ18;
                    while (iJ18 < i25) {
                        iJ18 = JU2.m(bArr, iJ18, hu2);
                        c0847iX25.g(AbstractC1736xV2.b(hu2.b));
                    }
                    if (iJ18 == i25) {
                        return iJ18;
                    }
                    throw zzkm.d();
                }
                if (i5 == 0) {
                    C0847iX2 c0847iX26 = (C0847iX2) eu22;
                    int iM2 = JU2.m(bArr, iJ, hu2);
                    c0847iX26.g(AbstractC1736xV2.b(hu2.b));
                    while (iM2 < i2) {
                        int iJ19 = JU2.j(bArr, iM2, hu2);
                        if (i3 != hu2.a) {
                            return iM2;
                        }
                        iM2 = JU2.m(bArr, iJ19, hu2);
                        c0847iX26.g(AbstractC1736xV2.b(hu2.b));
                    }
                    return iM2;
                }
                break;
            default:
                if (i5 == 3) {
                    InterfaceC0784hY2 interfaceC0784hY2N = n(i6);
                    int i26 = (i3 & (-8)) | 4;
                    int iC = JU2.c(interfaceC0784hY2N, bArr, i, i2, i26, hu2);
                    eu22.add(hu2.c);
                    while (iC < i2) {
                        int iJ20 = JU2.j(bArr, iC, hu2);
                        if (i3 != hu2.a) {
                            return iC;
                        }
                        iC = JU2.c(interfaceC0784hY2N, bArr, iJ20, i2, i26, hu2);
                        eu22.add(hu2.c);
                    }
                    return iC;
                }
                break;
        }
        return iJ;
    }

    public final int J(int i, int i2) {
        int[] iArr = this.a;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final Object a() {
        return ((AbstractC1852zW2) this.e).k(4);
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void b(Object obj) {
        int[] iArr;
        int i;
        int i2 = this.h;
        while (true) {
            iArr = this.g;
            i = this.i;
            if (i2 >= i) {
                break;
            }
            long jK = k(iArr[i2]) & 1048575;
            Object objM = NY2.c.m(jK, obj);
            if (objM != null) {
                ((HX2) objM).t = false;
                NY2.o(jK, obj, objM);
            }
            i2++;
        }
        int length = iArr.length;
        while (i < length) {
            this.j.a(iArr[i], obj);
            i++;
        }
        this.k.getClass();
        ((AbstractC1852zW2) obj).zzc.e = false;
    }

    @Override // defpackage.InterfaceC0784hY2
    public final int c(Object obj) {
        return this.f ? D(obj) : C(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    @Override // defpackage.InterfaceC0784hY2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UX2.d(java.lang.Object):boolean");
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void e(Object obj, FV2 fv2) throws zzjh {
        if (!this.f) {
            t(obj, fv2);
            return;
        }
        int[] iArr = this.a;
        int length = iArr.length;
        for (int i = 0; i < length; i += 3) {
            int iK = k(i);
            int i2 = iArr[i];
            switch (j(iK)) {
                case 0:
                    if (v(i, obj)) {
                        fv2.g(i2, NY2.c.a(iK & 1048575, obj));
                    }
                    break;
                case 1:
                    if (v(i, obj)) {
                        fv2.k(i2, NY2.c.b(iK & 1048575, obj));
                    }
                    break;
                case 2:
                    if (v(i, obj)) {
                        fv2.n(i2, NY2.c.k(iK & 1048575, obj));
                    }
                    break;
                case 3:
                    if (v(i, obj)) {
                        fv2.d(i2, NY2.c.k(iK & 1048575, obj));
                    }
                    break;
                case 4:
                    if (v(i, obj)) {
                        fv2.m(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 5:
                    if (v(i, obj)) {
                        fv2.j(i2, NY2.c.k(iK & 1048575, obj));
                    }
                    break;
                case 6:
                    if (v(i, obj)) {
                        fv2.i(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 7:
                    if (v(i, obj)) {
                        fv2.e(i2, NY2.c.g(iK & 1048575, obj));
                    }
                    break;
                case 8:
                    if (v(i, obj)) {
                        x(i2, NY2.c.m(iK & 1048575, obj), fv2);
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if (v(i, obj)) {
                        fv2.o(i2, NY2.c.m(iK & 1048575, obj), n(i));
                    }
                    break;
                case 10:
                    if (v(i, obj)) {
                        fv2.f(i2, (WU2) NY2.c.m(iK & 1048575, obj));
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (v(i, obj)) {
                        fv2.c(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 12:
                    if (v(i, obj)) {
                        fv2.h(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 13:
                    if (v(i, obj)) {
                        fv2.p(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 14:
                    if (v(i, obj)) {
                        fv2.q(i2, NY2.c.k(iK & 1048575, obj));
                    }
                    break;
                case 15:
                    if (v(i, obj)) {
                        fv2.a(i2, NY2.c.j(iK & 1048575, obj));
                    }
                    break;
                case 16:
                    if (v(i, obj)) {
                        fv2.b(i2, NY2.c.k(iK & 1048575, obj));
                    }
                    break;
                case 17:
                    if (v(i, obj)) {
                        fv2.l(i2, NY2.c.m(iK & 1048575, obj), n(i));
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    AbstractC0849iY2.e(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 19:
                    AbstractC0849iY2.i(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 20:
                    AbstractC0849iY2.l(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    AbstractC0849iY2.t(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 22:
                    AbstractC0849iY2.k(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    AbstractC0849iY2.h(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    AbstractC0849iY2.g(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 25:
                    AbstractC0849iY2.c(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 26:
                    AbstractC0849iY2.r(i2, (List) NY2.c.m(iK & 1048575, obj), fv2);
                    break;
                case 27:
                    AbstractC0849iY2.m(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, n(i));
                    break;
                case 28:
                    AbstractC0849iY2.d(i2, (List) NY2.c.m(iK & 1048575, obj), fv2);
                    break;
                case 29:
                    AbstractC0849iY2.s(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 30:
                    AbstractC0849iY2.f(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 31:
                    AbstractC0849iY2.n(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 32:
                    AbstractC0849iY2.o(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 33:
                    AbstractC0849iY2.p(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 34:
                    AbstractC0849iY2.q(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, false);
                    break;
                case 35:
                    AbstractC0849iY2.e(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 36:
                    AbstractC0849iY2.i(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 37:
                    AbstractC0849iY2.l(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 38:
                    AbstractC0849iY2.t(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 39:
                    AbstractC0849iY2.k(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 40:
                    AbstractC0849iY2.h(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 41:
                    AbstractC0849iY2.g(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 42:
                    AbstractC0849iY2.c(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 43:
                    AbstractC0849iY2.s(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 44:
                    AbstractC0849iY2.f(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 45:
                    AbstractC0849iY2.n(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 46:
                    AbstractC0849iY2.o(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 47:
                    AbstractC0849iY2.p(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 48:
                    AbstractC0849iY2.q(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, true);
                    break;
                case 49:
                    AbstractC0849iY2.j(i2, (List) NY2.c.m(iK & 1048575, obj), fv2, n(i));
                    break;
                case 50:
                    if (NY2.c.m(iK & 1048575, obj) != null) {
                        o(i).getClass();
                        throw new ClassCastException();
                    }
                    break;
                    break;
                case 51:
                    if (w(i2, i, obj)) {
                        fv2.g(i2, ((Double) NY2.c.m(iK & 1048575, obj)).doubleValue());
                    }
                    break;
                case 52:
                    if (w(i2, i, obj)) {
                        fv2.k(i2, ((Float) NY2.c.m(iK & 1048575, obj)).floatValue());
                    }
                    break;
                case 53:
                    if (w(i2, i, obj)) {
                        fv2.n(i2, l(iK & 1048575, obj));
                    }
                    break;
                case 54:
                    if (w(i2, i, obj)) {
                        fv2.d(i2, l(iK & 1048575, obj));
                    }
                    break;
                case 55:
                    if (w(i2, i, obj)) {
                        fv2.m(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 56:
                    if (w(i2, i, obj)) {
                        fv2.j(i2, l(iK & 1048575, obj));
                    }
                    break;
                case 57:
                    if (w(i2, i, obj)) {
                        fv2.i(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 58:
                    if (w(i2, i, obj)) {
                        fv2.e(i2, ((Boolean) NY2.c.m(iK & 1048575, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (w(i2, i, obj)) {
                        x(i2, NY2.c.m(iK & 1048575, obj), fv2);
                    }
                    break;
                case 60:
                    if (w(i2, i, obj)) {
                        fv2.o(i2, NY2.c.m(iK & 1048575, obj), n(i));
                    }
                    break;
                case 61:
                    if (w(i2, i, obj)) {
                        fv2.f(i2, (WU2) NY2.c.m(iK & 1048575, obj));
                    }
                    break;
                case 62:
                    if (w(i2, i, obj)) {
                        fv2.c(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 63:
                    if (w(i2, i, obj)) {
                        fv2.h(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 64:
                    if (w(i2, i, obj)) {
                        fv2.p(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 65:
                    if (w(i2, i, obj)) {
                        fv2.q(i2, l(iK & 1048575, obj));
                    }
                    break;
                case 66:
                    if (w(i2, i, obj)) {
                        fv2.a(i2, E(iK & 1048575, obj));
                    }
                    break;
                case 67:
                    if (w(i2, i, obj)) {
                        fv2.b(i2, l(iK & 1048575, obj));
                    }
                    break;
                case 68:
                    if (w(i2, i, obj)) {
                        fv2.l(i2, NY2.c.m(iK & 1048575, obj), n(i));
                    }
                    break;
            }
        }
        this.k.getClass();
        ((AbstractC1852zW2) obj).zzc.d(fv2);
    }

    @Override // defpackage.InterfaceC0784hY2
    public final boolean f(AbstractC1852zW2 abstractC1852zW2, Object obj) {
        boolean zU;
        int[] iArr = this.a;
        int length = iArr.length;
        for (int i = 0; i < length; i += 3) {
            int iK = k(i);
            long j = iK & 1048575;
            switch (j(iK)) {
                case 0:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my2 = NY2.c;
                        if (Double.doubleToLongBits(my2.a(j, abstractC1852zW2)) == Double.doubleToLongBits(my2.a(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 1:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my22 = NY2.c;
                        if (Float.floatToIntBits(my22.b(j, abstractC1852zW2)) == Float.floatToIntBits(my22.b(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 2:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my23 = NY2.c;
                        if (my23.k(j, abstractC1852zW2) == my23.k(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 3:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my24 = NY2.c;
                        if (my24.k(j, abstractC1852zW2) == my24.k(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 4:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my25 = NY2.c;
                        if (my25.j(j, abstractC1852zW2) == my25.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 5:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my26 = NY2.c;
                        if (my26.k(j, abstractC1852zW2) == my26.k(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 6:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my27 = NY2.c;
                        if (my27.j(j, abstractC1852zW2) == my27.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 7:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my28 = NY2.c;
                        if (my28.g(j, abstractC1852zW2) == my28.g(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 8:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my29 = NY2.c;
                        if (AbstractC0849iY2.u(my29.m(j, abstractC1852zW2), my29.m(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my210 = NY2.c;
                        if (AbstractC0849iY2.u(my210.m(j, abstractC1852zW2), my210.m(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 10:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my211 = NY2.c;
                        if (AbstractC0849iY2.u(my211.m(j, abstractC1852zW2), my211.m(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my212 = NY2.c;
                        if (my212.j(j, abstractC1852zW2) == my212.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 12:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my213 = NY2.c;
                        if (my213.j(j, abstractC1852zW2) == my213.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 13:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my214 = NY2.c;
                        if (my214.j(j, abstractC1852zW2) == my214.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 14:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my215 = NY2.c;
                        if (my215.k(j, abstractC1852zW2) == my215.k(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 15:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my216 = NY2.c;
                        if (my216.j(j, abstractC1852zW2) == my216.j(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 16:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my217 = NY2.c;
                        if (my217.k(j, abstractC1852zW2) == my217.k(j, obj)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 17:
                    if (u(abstractC1852zW2, obj, i)) {
                        MY2 my218 = NY2.c;
                        if (AbstractC0849iY2.u(my218.m(j, abstractC1852zW2), my218.m(j, obj))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                case 22:
                case ConnectionResult.API_DISABLED /* 23 */:
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    MY2 my219 = NY2.c;
                    zU = AbstractC0849iY2.u(my219.m(j, abstractC1852zW2), my219.m(j, obj));
                    break;
                case 50:
                    MY2 my220 = NY2.c;
                    zU = AbstractC0849iY2.u(my220.m(j, abstractC1852zW2), my220.m(j, obj));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long j2 = iArr[i + 2] & 1048575;
                    MY2 my221 = NY2.c;
                    if (my221.j(j2, abstractC1852zW2) != my221.j(j2, obj) || !AbstractC0849iY2.u(my221.m(j, abstractC1852zW2), my221.m(j, obj))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zU) {
                return false;
            }
        }
        this.k.getClass();
        return abstractC1852zW2.zzc.equals(((AbstractC1852zW2) obj).zzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.InterfaceC0784hY2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(defpackage.AbstractC1852zW2 r12) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UX2.g(zW2):int");
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void h(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22) {
        abstractC1852zW22.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                AbstractC0849iY2.b(this.k, abstractC1852zW2, abstractC1852zW22);
                return;
            }
            int iK = k(i);
            long j = iK & 1048575;
            int i2 = iArr[i];
            switch (j(iK)) {
                case 0:
                    if (v(i, abstractC1852zW22)) {
                        NY2.l(abstractC1852zW2, j, NY2.c.a(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 1:
                    if (v(i, abstractC1852zW22)) {
                        NY2.m(NY2.c.b(j, abstractC1852zW22), j, abstractC1852zW2);
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 2:
                    if (v(i, abstractC1852zW22)) {
                        MY2 my2 = NY2.c;
                        my2.o(abstractC1852zW2, j, my2.k(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 3:
                    if (v(i, abstractC1852zW22)) {
                        MY2 my22 = NY2.c;
                        my22.o(abstractC1852zW2, j, my22.k(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 4:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 5:
                    if (v(i, abstractC1852zW22)) {
                        MY2 my23 = NY2.c;
                        my23.o(abstractC1852zW2, j, my23.k(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 6:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 7:
                    if (v(i, abstractC1852zW22)) {
                        NY2.k(abstractC1852zW2, j, NY2.c.g(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 8:
                    if (v(i, abstractC1852zW22)) {
                        NY2.o(j, abstractC1852zW2, NY2.c.m(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    q(abstractC1852zW2, abstractC1852zW22, i);
                    break;
                case 10:
                    if (v(i, abstractC1852zW22)) {
                        NY2.o(j, abstractC1852zW2, NY2.c.m(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 12:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 13:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 14:
                    if (v(i, abstractC1852zW22)) {
                        MY2 my24 = NY2.c;
                        my24.o(abstractC1852zW2, j, my24.k(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 15:
                    if (v(i, abstractC1852zW22)) {
                        NY2.n(abstractC1852zW2, j, NY2.c.j(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 16:
                    if (v(i, abstractC1852zW22)) {
                        MY2 my25 = NY2.c;
                        my25.o(abstractC1852zW2, j, my25.k(j, abstractC1852zW22));
                        s(abstractC1852zW2, i);
                    }
                    break;
                case 17:
                    q(abstractC1852zW2, abstractC1852zW22, i);
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                case 19:
                case 20:
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                case 22:
                case ConnectionResult.API_DISABLED /* 23 */:
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.j.b(abstractC1852zW2, abstractC1852zW22, j);
                    break;
                case 50:
                    Class cls = AbstractC0849iY2.a;
                    MY2 my26 = NY2.c;
                    NY2.o(j, abstractC1852zW2, JX2.b(my26.m(j, abstractC1852zW2), my26.m(j, abstractC1852zW22)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (w(i2, i, abstractC1852zW22)) {
                        NY2.o(j, abstractC1852zW2, NY2.c.m(j, abstractC1852zW22));
                        NY2.n(abstractC1852zW2, iArr[i + 2] & 1048575, i2);
                    }
                    break;
                case 60:
                    r(abstractC1852zW2, abstractC1852zW22, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (w(i2, i, abstractC1852zW22)) {
                        NY2.o(j, abstractC1852zW2, NY2.c.m(j, abstractC1852zW22));
                        NY2.n(abstractC1852zW2, iArr[i + 2] & 1048575, i2);
                    }
                    break;
                case 68:
                    r(abstractC1852zW2, abstractC1852zW22, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // defpackage.InterfaceC0784hY2
    public final void i(Object obj, byte[] bArr, int i, int i2, HU2 hu2) throws zzkm {
        if (this.f) {
            H(obj, bArr, i, i2, hu2);
        } else {
            y(obj, bArr, i, i2, 0, hu2);
        }
    }

    public final int k(int i) {
        return this.a[i + 1];
    }

    public final FW2 m(int i) {
        int i2 = i / 3;
        return (FW2) this.b[i2 + i2 + 1];
    }

    public final InterfaceC0784hY2 n(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.b;
        InterfaceC0784hY2 interfaceC0784hY2 = (InterfaceC0784hY2) objArr[i3];
        if (interfaceC0784hY2 != null) {
            return interfaceC0784hY2;
        }
        InterfaceC0784hY2 interfaceC0784hY2A = C0482cY2.c.a((Class) objArr[i3 + 1]);
        objArr[i3] = interfaceC0784hY2A;
        return interfaceC0784hY2A;
    }

    public final Object o(int i) {
        int i2 = i / 3;
        return this.b[i2 + i2];
    }

    public final void q(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22, int i) {
        long jK = k(i) & 1048575;
        if (v(i, abstractC1852zW22)) {
            MY2 my2 = NY2.c;
            Object objM = my2.m(jK, abstractC1852zW2);
            Object objM2 = my2.m(jK, abstractC1852zW22);
            if (objM != null && objM2 != null) {
                NY2.o(jK, abstractC1852zW2, NW2.b(objM, objM2));
                s(abstractC1852zW2, i);
            } else if (objM2 != null) {
                NY2.o(jK, abstractC1852zW2, objM2);
                s(abstractC1852zW2, i);
            }
        }
    }

    public final void r(AbstractC1852zW2 abstractC1852zW2, AbstractC1852zW2 abstractC1852zW22, int i) {
        int iK = k(i);
        int i2 = this.a[i];
        long j = iK & 1048575;
        if (w(i2, i, abstractC1852zW22)) {
            Object objM = w(i2, i, abstractC1852zW2) ? NY2.c.m(j, abstractC1852zW2) : null;
            Object objM2 = NY2.c.m(j, abstractC1852zW22);
            if (objM != null && objM2 != null) {
                NY2.o(j, abstractC1852zW2, NW2.b(objM, objM2));
                NY2.n(abstractC1852zW2, r1[i + 2] & 1048575, i2);
            } else if (objM2 != null) {
                NY2.o(j, abstractC1852zW2, objM2);
                NY2.n(abstractC1852zW2, r1[i + 2] & 1048575, i2);
            }
        }
    }

    public final void s(AbstractC1852zW2 abstractC1852zW2, int i) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        NY2.n(abstractC1852zW2, j, (1 << (i2 >>> 20)) | NY2.c.j(j, abstractC1852zW2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void t(Object obj, FV2 fv2) throws zzjh {
        int i;
        boolean z;
        int[] iArr = this.a;
        int length = iArr.length;
        Unsafe unsafe = m;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iK = k(i4);
            int i6 = iArr[i4];
            int iJ = j(iK);
            if (iJ <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = i;
            long j = iK & i2;
            switch (iJ) {
                case 0:
                    if ((i5 & i9) != 0) {
                        fv2.g(i6, NY2.d(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 1:
                    if ((i5 & i9) != 0) {
                        fv2.k(i6, NY2.e(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 2:
                    if ((i5 & i9) != 0) {
                        fv2.n(i6, unsafe.getLong(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 3:
                    if ((i5 & i9) != 0) {
                        fv2.d(i6, unsafe.getLong(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 4:
                    if ((i5 & i9) != 0) {
                        fv2.m(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 5:
                    if ((i5 & i9) != 0) {
                        fv2.j(i6, unsafe.getLong(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 6:
                    if ((i5 & i9) != 0) {
                        fv2.i(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 7:
                    if ((i5 & i9) != 0) {
                        fv2.e(i6, NY2.s(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 8:
                    if ((i5 & i9) != 0) {
                        x(i6, unsafe.getObject(obj, j), fv2);
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if ((i5 & i9) != 0) {
                        fv2.o(i6, unsafe.getObject(obj, j), n(i4));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 10:
                    if ((i5 & i9) != 0) {
                        fv2.f(i6, (WU2) unsafe.getObject(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if ((i5 & i9) != 0) {
                        fv2.c(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 12:
                    if ((i5 & i9) != 0) {
                        fv2.h(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 13:
                    if ((i5 & i9) != 0) {
                        fv2.p(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 14:
                    if ((i5 & i9) != 0) {
                        fv2.q(i6, unsafe.getLong(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 15:
                    if ((i5 & i9) != 0) {
                        fv2.a(i6, unsafe.getInt(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 16:
                    if ((i5 & i9) != 0) {
                        fv2.b(i6, unsafe.getLong(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 17:
                    if ((i5 & i9) != 0) {
                        fv2.l(i6, unsafe.getObject(obj, j), n(i4));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    AbstractC0849iY2.e(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 19:
                    AbstractC0849iY2.i(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 20:
                    AbstractC0849iY2.l(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    AbstractC0849iY2.t(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 22:
                    AbstractC0849iY2.k(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    AbstractC0849iY2.h(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    AbstractC0849iY2.g(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 25:
                    AbstractC0849iY2.c(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 26:
                    AbstractC0849iY2.r(iArr[i4], (List) unsafe.getObject(obj, j), fv2);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 27:
                    AbstractC0849iY2.m(iArr[i4], (List) unsafe.getObject(obj, j), fv2, n(i4));
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 28:
                    AbstractC0849iY2.d(iArr[i4], (List) unsafe.getObject(obj, j), fv2);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 29:
                    z = false;
                    AbstractC0849iY2.s(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 30:
                    z = false;
                    AbstractC0849iY2.f(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 31:
                    z = false;
                    AbstractC0849iY2.n(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 32:
                    z = false;
                    AbstractC0849iY2.o(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 33:
                    z = false;
                    AbstractC0849iY2.p(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 34:
                    z = false;
                    AbstractC0849iY2.q(iArr[i4], (List) unsafe.getObject(obj, j), fv2, false);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 35:
                    AbstractC0849iY2.e(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 36:
                    AbstractC0849iY2.i(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 37:
                    AbstractC0849iY2.l(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 38:
                    AbstractC0849iY2.t(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 39:
                    AbstractC0849iY2.k(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 40:
                    AbstractC0849iY2.h(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 41:
                    AbstractC0849iY2.g(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 42:
                    AbstractC0849iY2.c(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 43:
                    AbstractC0849iY2.s(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 44:
                    AbstractC0849iY2.f(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 45:
                    AbstractC0849iY2.n(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 46:
                    AbstractC0849iY2.o(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 47:
                    AbstractC0849iY2.p(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 48:
                    AbstractC0849iY2.q(iArr[i4], (List) unsafe.getObject(obj, j), fv2, true);
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 49:
                    AbstractC0849iY2.j(iArr[i4], (List) unsafe.getObject(obj, j), fv2, n(i4));
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        o(i4).getClass();
                        throw new ClassCastException();
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 51:
                    if (w(i6, i4, obj)) {
                        fv2.g(i6, ((Double) NY2.c.m(j, obj)).doubleValue());
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 52:
                    if (w(i6, i4, obj)) {
                        fv2.k(i6, ((Float) NY2.c.m(j, obj)).floatValue());
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 53:
                    if (w(i6, i4, obj)) {
                        fv2.n(i6, l(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 54:
                    if (w(i6, i4, obj)) {
                        fv2.d(i6, l(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 55:
                    if (w(i6, i4, obj)) {
                        fv2.m(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 56:
                    if (w(i6, i4, obj)) {
                        fv2.j(i6, l(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 57:
                    if (w(i6, i4, obj)) {
                        fv2.i(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 58:
                    if (w(i6, i4, obj)) {
                        fv2.e(i6, ((Boolean) NY2.c.m(j, obj)).booleanValue());
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 59:
                    if (w(i6, i4, obj)) {
                        x(i6, unsafe.getObject(obj, j), fv2);
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 60:
                    if (w(i6, i4, obj)) {
                        fv2.o(i6, unsafe.getObject(obj, j), n(i4));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 61:
                    if (w(i6, i4, obj)) {
                        fv2.f(i6, (WU2) unsafe.getObject(obj, j));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 62:
                    if (w(i6, i4, obj)) {
                        fv2.c(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 63:
                    if (w(i6, i4, obj)) {
                        fv2.h(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 64:
                    if (w(i6, i4, obj)) {
                        fv2.p(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 65:
                    if (w(i6, i4, obj)) {
                        fv2.q(i6, l(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 66:
                    if (w(i6, i4, obj)) {
                        fv2.a(i6, E(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 67:
                    if (w(i6, i4, obj)) {
                        fv2.b(i6, l(j, obj));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                case 68:
                    if (w(i6, i4, obj)) {
                        fv2.l(i6, unsafe.getObject(obj, j), n(i4));
                    }
                    i4 += 3;
                    i2 = 1048575;
                    break;
                default:
                    i4 += 3;
                    i2 = 1048575;
                    break;
            }
        }
        this.k.getClass();
        FY2.c(FY2.b(obj), fv2);
    }

    public final boolean u(AbstractC1852zW2 abstractC1852zW2, Object obj, int i) {
        return v(i, abstractC1852zW2) == v(i, obj);
    }

    public final boolean v(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return (NY2.c.j(j, obj) & (1 << (i2 >>> 20))) != 0;
        }
        int iK = k(i);
        long j2 = iK & 1048575;
        switch (j(iK)) {
            case 0:
                return Double.doubleToRawLongBits(NY2.c.a(j2, obj)) != 0;
            case 1:
                return Float.floatToRawIntBits(NY2.c.b(j2, obj)) != 0;
            case 2:
                return NY2.c.k(j2, obj) != 0;
            case 3:
                return NY2.c.k(j2, obj) != 0;
            case 4:
                return NY2.c.j(j2, obj) != 0;
            case 5:
                return NY2.c.k(j2, obj) != 0;
            case 6:
                return NY2.c.j(j2, obj) != 0;
            case 7:
                return NY2.c.g(j2, obj);
            case 8:
                Object objM = NY2.c.m(j2, obj);
                if (objM instanceof String) {
                    return !((String) objM).isEmpty();
                }
                if (objM instanceof WU2) {
                    return !WU2.v.equals(objM);
                }
                throw new IllegalArgumentException();
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                return NY2.c.m(j2, obj) != null;
            case 10:
                return !WU2.v.equals(NY2.c.m(j2, obj));
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                return NY2.c.j(j2, obj) != 0;
            case 12:
                return NY2.c.j(j2, obj) != 0;
            case 13:
                return NY2.c.j(j2, obj) != 0;
            case 14:
                return NY2.c.k(j2, obj) != 0;
            case 15:
                return NY2.c.j(j2, obj) != 0;
            case 16:
                return NY2.c.k(j2, obj) != 0;
            case 17:
                return NY2.c.m(j2, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean w(int i, int i2, Object obj) {
        return NY2.c.j((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    public final int y(Object obj, byte[] bArr, int i, int i2, int i3, HU2 hu2) {
        int[] iArr;
        Unsafe unsafe;
        int i4;
        Object obj2;
        int i5;
        int iK;
        int i6;
        int iJ;
        int iJ2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        byte b;
        int i17;
        int i18;
        int i19;
        HU2 hu22;
        int i20;
        HU2 hu23;
        int i21;
        int i22;
        HU2 hu24;
        int i23;
        int i24;
        UX2 ux2 = this;
        Object obj3 = obj;
        byte[] bArr2 = bArr;
        int i25 = i2;
        int i26 = i3;
        HU2 hu25 = hu2;
        Unsafe unsafe2 = m;
        int i27 = i;
        int i28 = 0;
        int i29 = -1;
        int i30 = 0;
        int i31 = 0;
        int i32 = 1048575;
        while (true) {
            int[] iArr2 = ux2.a;
            if (i27 < i25) {
                int i33 = i27 + 1;
                byte b2 = bArr2[i27];
                if (b2 < 0) {
                    iK = JU2.k(b2, bArr2, i33, hu25);
                    i5 = hu25.a;
                } else {
                    i5 = b2;
                    iK = i33;
                }
                int i34 = i5 >>> 3;
                int i35 = i5 & 7;
                int i36 = iK;
                int i37 = ux2.d;
                int i38 = i5;
                int i39 = ux2.c;
                if (i34 > i29) {
                    iJ2 = (i34 < i39 || i34 > i37) ? -1 : ux2.J(i34, i30 / 3);
                    i7 = -1;
                    i6 = 0;
                } else {
                    if (i34 < i39 || i34 > i37) {
                        i6 = 0;
                        iJ = -1;
                    } else {
                        i6 = 0;
                        iJ = ux2.J(i34, 0);
                    }
                    iJ2 = iJ;
                    i7 = -1;
                }
                if (iJ2 == i7) {
                    i8 = i36;
                    i9 = i6;
                    i10 = i31;
                    i11 = i32;
                    i12 = i34;
                    iArr = iArr2;
                    unsafe = unsafe2;
                    obj2 = obj3;
                    i13 = i38;
                    i4 = i3;
                } else {
                    int i40 = iArr2[iJ2 + 1];
                    int iJ3 = j(i40);
                    long j = i40 & 1048575;
                    if (iJ3 <= 17) {
                        int i41 = iArr2[iJ2 + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & 1048575;
                        if (i43 != i32) {
                            if (i32 != 1048575) {
                                unsafe2.putInt(obj3, i32, i31);
                            }
                            i15 = i43;
                            i14 = unsafe2.getInt(obj3, i43);
                        } else {
                            i14 = i31;
                            i15 = i32;
                        }
                        switch (iJ3) {
                            case 0:
                                i16 = i36;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 1) {
                                    NY2.l(obj3, j, Double.longBitsToDouble(JU2.n(i16, bArr2)));
                                    i27 = i16 + 8;
                                    i31 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i28 = i18;
                                    i29 = i20;
                                    i25 = i2;
                                    hu25 = hu2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 1:
                                i16 = i36;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 5) {
                                    NY2.m(Float.intBitsToFloat(JU2.b(i16, bArr2)), j, obj3);
                                    i27 = i16 + 4;
                                    i31 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i28 = i18;
                                    i29 = i20;
                                    i25 = i2;
                                    hu25 = hu2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 2:
                            case 3:
                                i16 = i36;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 0) {
                                    int iM = JU2.m(bArr2, i16, hu2);
                                    unsafe2.putLong(obj, j, hu2.b);
                                    i31 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i27 = iM;
                                    i30 = i19;
                                    i28 = i18;
                                    i29 = i20;
                                    i25 = i2;
                                    hu25 = hu2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 4:
                            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                                i16 = i36;
                                hu23 = hu2;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 0) {
                                    i27 = JU2.j(bArr2, i16, hu23);
                                    unsafe2.putInt(obj3, j, hu23.a);
                                    i21 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i29 = i20;
                                    hu25 = hu23;
                                    i31 = i21;
                                    i28 = i18;
                                    i25 = i2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 5:
                            case 14:
                                i16 = i36;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 1) {
                                    unsafe2.putLong(obj, j, JU2.n(i16, bArr2));
                                    i27 = i16 + 8;
                                    i31 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i28 = i18;
                                    i29 = i20;
                                    i25 = i2;
                                    hu25 = hu2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 6:
                            case 13:
                                i16 = i36;
                                hu23 = hu2;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                bArr2 = bArr;
                                i18 = i38;
                                i20 = i34;
                                if (i35 == 5) {
                                    unsafe2.putInt(obj3, j, JU2.b(i16, bArr2));
                                    i27 = i16 + 4;
                                    i21 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i29 = i20;
                                    hu25 = hu23;
                                    i31 = i21;
                                    i28 = i18;
                                    i25 = i2;
                                } else {
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 7:
                                i16 = i36;
                                i17 = i15;
                                i18 = i38;
                                b = -1;
                                bArr2 = bArr;
                                i19 = iJ2;
                                if (i35 == 0) {
                                    int iM2 = JU2.m(bArr2, i16, hu2);
                                    NY2.k(obj3, j, hu2.b != 0);
                                    i32 = i17;
                                    i26 = i3;
                                    i30 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    hu25 = hu2;
                                    i31 = i14 | i42;
                                    i27 = iM2;
                                    i29 = i34;
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 8:
                                i16 = i36;
                                i22 = i2;
                                hu24 = hu2;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                i18 = i38;
                                bArr2 = bArr;
                                if (i35 == 2) {
                                    i27 = (i40 & 536870912) == 0 ? JU2.g(bArr2, i16, hu24) : JU2.h(bArr2, i16, hu24);
                                    unsafe2.putObject(obj3, j, hu24.c);
                                    i26 = i3;
                                    i29 = i34;
                                    i30 = i19;
                                    hu25 = hu24;
                                    i31 = i14 | i42;
                                    i28 = i18;
                                    i25 = i22;
                                    i32 = i17;
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case ConnectionResult.SERVICE_INVALID /* 9 */:
                                i16 = i36;
                                hu24 = hu2;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                i18 = i38;
                                bArr2 = bArr;
                                if (i35 == 2) {
                                    i22 = i2;
                                    i27 = JU2.d(ux2.n(i19), bArr2, i16, i22, hu24);
                                    if ((i14 & i42) == 0) {
                                        unsafe2.putObject(obj3, j, hu24.c);
                                    } else {
                                        unsafe2.putObject(obj3, j, NW2.b(unsafe2.getObject(obj3, j), hu24.c));
                                    }
                                    i26 = i3;
                                    i29 = i34;
                                    i30 = i19;
                                    hu25 = hu24;
                                    i31 = i14 | i42;
                                    i28 = i18;
                                    i25 = i22;
                                    i32 = i17;
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 10:
                                i16 = i36;
                                hu23 = hu2;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                i18 = i38;
                                bArr2 = bArr;
                                if (i35 == 2) {
                                    i27 = JU2.a(bArr2, i16, hu23);
                                    unsafe2.putObject(obj3, j, hu23.c);
                                    i21 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i29 = i34;
                                    i30 = i19;
                                    hu25 = hu23;
                                    i31 = i21;
                                    i28 = i18;
                                    i25 = i2;
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 12:
                                i16 = i36;
                                i17 = i15;
                                b = -1;
                                i19 = iJ2;
                                i18 = i38;
                                bArr2 = bArr;
                                if (i35 == 0) {
                                    int iJ4 = JU2.j(bArr2, i16, hu2);
                                    int i44 = hu2.a;
                                    FW2 fw2M = ux2.m(i19);
                                    if (fw2M == null || fw2M.a(i44)) {
                                        unsafe2.putInt(obj3, j, i44);
                                        i26 = i3;
                                        i29 = i34;
                                        i30 = i19;
                                        i28 = i18;
                                        i25 = i2;
                                        hu25 = hu2;
                                        i31 = i14 | i42;
                                        i27 = iJ4;
                                        i32 = i17;
                                    } else {
                                        z(obj).c(i18, Long.valueOf(i44));
                                        i26 = i3;
                                        i27 = iJ4;
                                        i29 = i34;
                                        i30 = i19;
                                        i28 = i18;
                                        i32 = i17;
                                        i25 = i2;
                                        hu25 = hu2;
                                        i31 = i14;
                                    }
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 15:
                                i16 = i36;
                                hu23 = hu2;
                                i17 = i15;
                                i18 = i38;
                                b = -1;
                                bArr2 = bArr;
                                i19 = iJ2;
                                if (i35 == 0) {
                                    i27 = JU2.j(bArr2, i16, hu23);
                                    unsafe2.putInt(obj3, j, AbstractC1736xV2.a(hu23.a));
                                    i21 = i14 | i42;
                                    i32 = i17;
                                    i26 = i3;
                                    i29 = i34;
                                    i30 = i19;
                                    hu25 = hu23;
                                    i31 = i21;
                                    i28 = i18;
                                    i25 = i2;
                                } else {
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            case 16:
                                i16 = i36;
                                int i45 = iJ2;
                                b = -1;
                                if (i35 == 0) {
                                    bArr2 = bArr;
                                    int iM3 = JU2.m(bArr2, i16, hu2);
                                    unsafe2.putLong(obj, j, AbstractC1736xV2.b(hu2.b));
                                    i31 = i14 | i42;
                                    i32 = i15;
                                    i29 = i34;
                                    i27 = iM3;
                                    i30 = i45;
                                    hu25 = hu2;
                                    i28 = i38;
                                    i25 = i2;
                                    i26 = i3;
                                } else {
                                    i18 = i38;
                                    i17 = i15;
                                    i19 = i45;
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                            default:
                                if (i35 == 3) {
                                    int i46 = iJ2;
                                    i27 = JU2.c(ux2.n(iJ2), bArr, i36, i2, (i34 << 3) | 4, hu2);
                                    if ((i14 & i42) == 0) {
                                        hu22 = hu2;
                                        unsafe2.putObject(obj3, j, hu22.c);
                                    } else {
                                        hu22 = hu2;
                                        unsafe2.putObject(obj3, j, NW2.b(unsafe2.getObject(obj3, j), hu22.c));
                                    }
                                    bArr2 = bArr;
                                    i25 = i2;
                                    i29 = i34;
                                    i32 = i15;
                                    i30 = i46;
                                    i26 = i3;
                                    hu25 = hu22;
                                    i31 = i14 | i42;
                                    i28 = i38;
                                } else {
                                    i16 = i36;
                                    b = -1;
                                    i17 = i15;
                                    i18 = i38;
                                    i19 = iJ2;
                                    i20 = i34;
                                    i11 = i17;
                                    i4 = i3;
                                    i10 = i14;
                                    i9 = i19;
                                    unsafe = unsafe2;
                                    i8 = i16;
                                    i13 = i18;
                                    obj2 = obj3;
                                    iArr = iArr2;
                                    i12 = i20;
                                }
                                break;
                        }
                    } else {
                        int i47 = iJ2;
                        bArr2 = bArr;
                        if (iJ3 != 27) {
                            i10 = i31;
                            i11 = i32;
                            i12 = i34;
                            if (iJ3 <= 49) {
                                iArr = iArr2;
                                i9 = i47;
                                unsafe = unsafe2;
                                i27 = I(obj, bArr, i36, i2, i38, i12, i35, i47, i40, iJ3, j, hu2);
                                if (i27 != i36) {
                                    ux2 = this;
                                    obj3 = obj;
                                    bArr2 = bArr;
                                    i28 = i38;
                                    i25 = i2;
                                    i26 = i3;
                                    hu25 = hu2;
                                    i29 = i12;
                                    i31 = i10;
                                    i32 = i11;
                                    unsafe2 = unsafe;
                                    i30 = i9;
                                } else {
                                    obj2 = obj;
                                    i13 = i38;
                                    i4 = i3;
                                    i8 = i27;
                                }
                            } else {
                                i23 = i36;
                                i9 = i47;
                                unsafe = unsafe2;
                                i24 = i38;
                                iArr = iArr2;
                                if (iJ3 != 50) {
                                    obj2 = obj;
                                    i27 = G(obj, bArr, i23, i2, i24, i12, i35, i40, iJ3, j, i9, hu2);
                                    if (i27 != i23) {
                                        bArr2 = bArr;
                                        i28 = i24;
                                        i25 = i2;
                                        i26 = i3;
                                        hu25 = hu2;
                                        obj3 = obj2;
                                        i29 = i12;
                                        i31 = i10;
                                        i32 = i11;
                                        i30 = i9;
                                        unsafe2 = unsafe;
                                        ux2 = this;
                                    } else {
                                        i13 = i24;
                                        i4 = i3;
                                        i8 = i27;
                                        i9 = i9;
                                    }
                                } else if (i35 == 2) {
                                    F(i9, j, obj);
                                    throw null;
                                }
                            }
                        } else if (i35 == 2) {
                            EU2 eu2 = (EU2) ((LW2) unsafe2.getObject(obj3, j));
                            boolean zF = eu2.f();
                            EU2 eu22 = eu2;
                            if (!zF) {
                                int size = eu2.size();
                                LW2 lw2C = eu2.c(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, lw2C);
                                eu22 = lw2C;
                            }
                            i28 = i38;
                            i27 = JU2.e(ux2.n(i47), i28, bArr, i36, i2, eu22, hu2);
                            i26 = i3;
                            i30 = i47;
                            i29 = i34;
                            i31 = i31;
                            i32 = i32;
                            i25 = i2;
                            hu25 = hu2;
                        } else {
                            i10 = i31;
                            i11 = i32;
                            i12 = i34;
                            i23 = i36;
                            i9 = i47;
                            unsafe = unsafe2;
                            i24 = i38;
                            iArr = iArr2;
                        }
                        i13 = i24;
                        i4 = i3;
                        i8 = i23;
                        obj2 = obj;
                    }
                }
                if (i13 != i4 || i4 == 0) {
                    i27 = JU2.i(i13, bArr, i8, i2, z(obj), hu2);
                    bArr2 = bArr;
                    i25 = i2;
                    hu25 = hu2;
                    i26 = i4;
                    i28 = i13;
                    obj3 = obj2;
                    i29 = i12;
                    i31 = i10;
                    i32 = i11;
                    unsafe2 = unsafe;
                    i30 = i9;
                    ux2 = this;
                } else {
                    i27 = i8;
                    i28 = i13;
                    i31 = i10;
                    i32 = i11;
                }
            } else {
                iArr = iArr2;
                unsafe = unsafe2;
                i4 = i26;
                obj2 = obj3;
            }
        }
        if (i32 != 1048575) {
            unsafe.putInt(obj2, i32, i31);
        }
        for (int i48 = this.h; i48 < this.i; i48++) {
            int i49 = this.g[i48];
            int i50 = iArr[i49];
            Object objI = NY2.i(k(i49) & 1048575, obj2);
            if (objI != null && m(i49) != null) {
                yi1.a(o(i49));
                throw null;
            }
        }
        if (i4 == 0) {
            if (i27 != i2) {
                throw zzkm.c();
            }
        } else if (i27 > i2 || i28 != i4) {
            throw zzkm.c();
        }
        return i27;
    }
}
