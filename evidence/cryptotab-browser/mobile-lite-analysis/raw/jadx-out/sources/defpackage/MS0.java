package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MS0 implements Cz1 {
    public static final int[] o = new int[0];
    public static final Unsafe p = AbstractC1633vk2.l();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final InterfaceC1787yS0 e;
    public final boolean f;
    public final boolean g;
    public final int[] h;
    public final int i;
    public final int j;
    public final xY0 k;
    public final AbstractC0764hG0 l;
    public final C0373ak2 m;
    public final AL0 n;

    public MS0(int[] iArr, Object[] objArr, int i, int i2, InterfaceC1787yS0 interfaceC1787yS0, boolean z, int[] iArr2, int i3, int i4, xY0 xy0, AbstractC0764hG0 abstractC0764hG0, C0373ak2 c0373ak2, C1252p90 c1252p90, AL0 al0) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.f = interfaceC1787yS0 instanceof AbstractC0003Al0;
        this.g = z;
        this.h = iArr2;
        this.i = i3;
        this.j = i4;
        this.k = xy0;
        this.l = abstractC0764hG0;
        this.m = c0373ak2;
        this.e = interfaceC1787yS0;
        this.n = al0;
    }

    public static MS0 A(rq1 rq1Var, xY0 xy0, AbstractC0764hG0 abstractC0764hG0, C0373ak2 c0373ak2, C1252p90 c1252p90, AL0 al0) {
        if (rq1Var instanceof rq1) {
            return B(rq1Var, xy0, abstractC0764hG0, c0373ak2, c1252p90, al0);
        }
        rq1Var.getClass();
        throw new ClassCastException();
    }

    public static MS0 B(rq1 rq1Var, xY0 xy0, AbstractC0764hG0 abstractC0764hG0, C0373ak2 c0373ak2, C1252p90 c1252p90, AL0 al0) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int iObjectFieldOffset2;
        int i21;
        Field fieldO;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        Field fieldO2;
        Field fieldO3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        int i29 = 0;
        boolean z = rq1Var.d() == 2;
        String strC = rq1Var.c();
        int length = strC.length();
        if (strC.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strC.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt4 = strC.charAt(i);
        if (iCharAt4 >= 55296) {
            int i32 = iCharAt4 & 8191;
            int i33 = 13;
            while (true) {
                i28 = i31 + 1;
                cCharAt13 = strC.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i28;
            }
            iCharAt4 = i32 | (cCharAt13 << i33);
            i31 = i28;
        }
        if (iCharAt4 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            iCharAt3 = 0;
            iArr = o;
            i3 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt5 = strC.charAt(i31);
            if (iCharAt5 >= 55296) {
                int i35 = iCharAt5 & 8191;
                int i36 = 13;
                while (true) {
                    i12 = i34 + 1;
                    cCharAt8 = strC.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i12;
                }
                iCharAt5 = i35 | (cCharAt8 << i36);
                i34 = i12;
            }
            int i37 = i34 + 1;
            int iCharAt6 = strC.charAt(i34);
            if (iCharAt6 >= 55296) {
                int i38 = iCharAt6 & 8191;
                int i39 = 13;
                while (true) {
                    i11 = i37 + 1;
                    cCharAt7 = strC.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i11;
                }
                iCharAt6 = i38 | (cCharAt7 << i39);
                i37 = i11;
            }
            int i40 = i37 + 1;
            int iCharAt7 = strC.charAt(i37);
            if (iCharAt7 >= 55296) {
                int i41 = iCharAt7 & 8191;
                int i42 = 13;
                while (true) {
                    i10 = i40 + 1;
                    cCharAt6 = strC.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i10;
                }
                iCharAt7 = i41 | (cCharAt6 << i42);
                i40 = i10;
            }
            int i43 = i40 + 1;
            iCharAt = strC.charAt(i40);
            if (iCharAt >= 55296) {
                int i44 = iCharAt & 8191;
                int i45 = 13;
                while (true) {
                    i9 = i43 + 1;
                    cCharAt5 = strC.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i9;
                }
                iCharAt = i44 | (cCharAt5 << i45);
                i43 = i9;
            }
            int i46 = i43 + 1;
            int iCharAt8 = strC.charAt(i43);
            if (iCharAt8 >= 55296) {
                int i47 = iCharAt8 & 8191;
                int i48 = 13;
                while (true) {
                    i8 = i46 + 1;
                    cCharAt4 = strC.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i8;
                }
                iCharAt8 = i47 | (cCharAt4 << i48);
                i46 = i8;
            }
            int i49 = i46 + 1;
            iCharAt2 = strC.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i7 = i49 + 1;
                    cCharAt3 = strC.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i7;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i7;
            }
            int i52 = i49 + 1;
            int iCharAt9 = strC.charAt(i49);
            if (iCharAt9 >= 55296) {
                int i53 = iCharAt9 & 8191;
                int i54 = 13;
                while (true) {
                    i6 = i52 + 1;
                    cCharAt2 = strC.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i6;
                }
                iCharAt9 = i53 | (cCharAt2 << i54);
                i52 = i6;
            }
            int i55 = i52 + 1;
            iCharAt3 = strC.charAt(i52);
            if (iCharAt3 >= 55296) {
                int i56 = iCharAt3 & 8191;
                int i57 = i55;
                int i58 = 13;
                while (true) {
                    i5 = i57 + 1;
                    cCharAt = strC.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i57 = i5;
                }
                iCharAt3 = i56 | (cCharAt << i58);
                i55 = i5;
            }
            int[] iArr2 = new int[iCharAt3 + iCharAt2 + iCharAt9];
            i2 = (iCharAt5 * 2) + iCharAt6;
            i3 = iCharAt7;
            i4 = iCharAt8;
            iArr = iArr2;
            i29 = iCharAt5;
            i31 = i55;
        }
        Unsafe unsafe = p;
        Object[] objArrB = rq1Var.b();
        Class<?> cls = rq1Var.a().getClass();
        int[] iArr3 = new int[i4 * 3];
        Object[] objArr = new Object[i4 * 2];
        int i59 = iCharAt2 + iCharAt3;
        int i60 = i59;
        int i61 = iCharAt3;
        int i62 = 0;
        int i63 = 0;
        while (i31 < length) {
            int i64 = i31 + 1;
            int iCharAt10 = strC.charAt(i31);
            if (iCharAt10 >= 55296) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i27 = i66 + 1;
                    cCharAt12 = strC.charAt(i66);
                    i13 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i27;
                    length = i13;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i14 = i27;
            } else {
                i13 = length;
                i14 = i64;
            }
            int i68 = i14 + 1;
            int iCharAt11 = strC.charAt(i14);
            if (iCharAt11 >= 55296) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i26 = i70 + 1;
                    cCharAt11 = strC.charAt(i70);
                    i15 = i59;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i26;
                    i59 = i15;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i16 = i26;
            } else {
                i15 = i59;
                i16 = i68;
            }
            int i72 = iCharAt11 & 255;
            int i73 = iCharAt3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i63;
                i62++;
            }
            if (i72 >= 51) {
                int i74 = i16 + 1;
                int iCharAt12 = strC.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i75 = iCharAt12 & 8191;
                    int i76 = i74;
                    int i77 = 13;
                    while (true) {
                        i25 = i76 + 1;
                        cCharAt10 = strC.charAt(i76);
                        i17 = iCharAt;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i77;
                        i77 += 13;
                        i76 = i25;
                        iCharAt = i17;
                    }
                    iCharAt12 = i75 | (cCharAt10 << i77);
                    i23 = i25;
                } else {
                    i17 = iCharAt;
                    i23 = i74;
                }
                int i78 = i72 - 51;
                int i79 = i23;
                if (i78 == 9 || i78 == 17) {
                    i24 = 2;
                    objArr[((i63 / 3) * 2) + 1] = objArrB[i2];
                    i2++;
                } else {
                    if (i78 == 12 && !z) {
                        objArr[((i63 / 3) * 2) + 1] = objArrB[i2];
                        i2++;
                    }
                    i24 = 2;
                }
                int i80 = iCharAt12 * i24;
                Object obj = objArrB[i80];
                if (obj instanceof Field) {
                    fieldO2 = (Field) obj;
                } else {
                    fieldO2 = O((String) obj, cls);
                    objArrB[i80] = fieldO2;
                }
                int i81 = i2;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO2);
                int i82 = i80 + 1;
                Object obj2 = objArrB[i82];
                if (obj2 instanceof Field) {
                    fieldO3 = (Field) obj2;
                } else {
                    fieldO3 = O((String) obj2, cls);
                    objArrB[i82] = fieldO3;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO3);
                i20 = 0;
                i18 = i3;
                i21 = i81;
                i19 = i79;
            } else {
                i17 = iCharAt;
                int i83 = i2 + 1;
                Field fieldO4 = O((String) objArrB[i2], cls);
                i18 = i3;
                if (i72 == 9 || i72 == 17) {
                    objArr[((i63 / 3) * 2) + 1] = fieldO4.getType();
                } else {
                    if (i72 == 27 || i72 == 49) {
                        i22 = i2 + 2;
                        objArr[((i63 / 3) * 2) + 1] = objArrB[i83];
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        if (!z) {
                            i22 = i2 + 2;
                            objArr[((i63 / 3) * 2) + 1] = objArrB[i83];
                        }
                    } else if (i72 == 50) {
                        int i84 = i61 + 1;
                        iArr[i61] = i63;
                        int i85 = (i63 / 3) * 2;
                        int i86 = i2 + 2;
                        objArr[i85] = objArrB[i83];
                        if ((iCharAt11 & 2048) != 0) {
                            i83 = i2 + 3;
                            objArr[i85 + 1] = objArrB[i86];
                            i61 = i84;
                        } else {
                            i61 = i84;
                            i83 = i86;
                        }
                    }
                    i83 = i22;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO4);
                if ((iCharAt11 & 4096) != 4096 || i72 > 17) {
                    iObjectFieldOffset = 1048575;
                    i19 = i16;
                    i20 = 0;
                } else {
                    int i87 = i16 + 1;
                    int iCharAt13 = strC.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i88 = iCharAt13 & 8191;
                        int i89 = 13;
                        while (true) {
                            i19 = i87 + 1;
                            cCharAt9 = strC.charAt(i87);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i88 |= (cCharAt9 & 8191) << i89;
                            i89 += 13;
                            i87 = i19;
                        }
                        iCharAt13 = i88 | (cCharAt9 << i89);
                    } else {
                        i19 = i87;
                    }
                    int i90 = (iCharAt13 / 32) + (i29 * 2);
                    Object obj3 = objArrB[i90];
                    if (obj3 instanceof Field) {
                        fieldO = (Field) obj3;
                    } else {
                        fieldO = O((String) obj3, cls);
                        objArrB[i90] = fieldO;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO);
                    i20 = iCharAt13 % 32;
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i60] = iObjectFieldOffset3;
                    i60++;
                }
                int i91 = i83;
                iObjectFieldOffset2 = iObjectFieldOffset3;
                i21 = i91;
            }
            int i92 = i63 + 1;
            iArr3[i63] = iCharAt10;
            int i93 = i63 + 2;
            String str = strC;
            iArr3[i92] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i72 << 20) | iObjectFieldOffset2;
            i63 += 3;
            iArr3[i93] = (i20 << 20) | iObjectFieldOffset;
            i2 = i21;
            iCharAt3 = i73;
            strC = str;
            i3 = i18;
            length = i13;
            i59 = i15;
            i31 = i19;
            iCharAt = i17;
        }
        return new MS0(iArr3, objArr, i3, iCharAt, rq1Var.a(), z, iArr, iCharAt3, i59, xy0, abstractC0764hG0, c0373ak2, c1252p90, al0);
    }

    public static long C(int i) {
        return i & 1048575;
    }

    public static int D(long j, Object obj) {
        return ((Integer) AbstractC1633vk2.b.k(j, obj)).intValue();
    }

    public static long E(long j, Object obj) {
        return ((Long) AbstractC1633vk2.b.k(j, obj)).longValue();
    }

    public static Field O(String str, Class cls) {
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

    public static int S(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void W(int i, Object obj, DG dg) {
        if (!(obj instanceof String)) {
            dg.b(i, (C0199Qv) obj);
        } else {
            dg.a.M(i, (String) obj);
        }
    }

    public static int l(byte[] bArr, int i, int i2, EnumC1415rw2 enumC1415rw2, Class cls, We we) {
        switch (enumC1415rw2.ordinal()) {
            case 0:
                we.c = Double.valueOf(AbstractC0282Xe.d(i, bArr));
                return i + 8;
            case 1:
                we.c = Float.valueOf(AbstractC0282Xe.j(i, bArr));
                return i + 4;
            case 2:
            case 3:
                int I = AbstractC0282Xe.I(bArr, i, we);
                we.c = Long.valueOf(we.b);
                return I;
            case 4:
            case 12:
            case 13:
                int iG = AbstractC0282Xe.G(bArr, i, we);
                we.c = Integer.valueOf(we.a);
                return iG;
            case 5:
            case 15:
                we.c = Long.valueOf(AbstractC0282Xe.h(i, bArr));
                return i + 8;
            case 6:
            case 14:
                we.c = Integer.valueOf(AbstractC0282Xe.f(i, bArr));
                return i + 4;
            case 7:
                int I2 = AbstractC0282Xe.I(bArr, i, we);
                we.c = Boolean.valueOf(we.b != 0);
                return I2;
            case 8:
                return AbstractC0282Xe.D(bArr, i, we);
            case ConnectionResult.SERVICE_INVALID /* 9 */:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return AbstractC0282Xe.n(C0734gn1.c.a(cls), bArr, i, i2, we);
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                return AbstractC0282Xe.b(bArr, i, we);
            case 16:
                int iG2 = AbstractC0282Xe.G(bArr, i, we);
                we.c = Integer.valueOf(yG.b(we.a));
                return iG2;
            case 17:
                int I3 = AbstractC0282Xe.I(bArr, i, we);
                we.c = Long.valueOf(yG.c(we.b));
                return I3;
        }
    }

    public static Zj2 q(Object obj) {
        AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) obj;
        Zj2 zj2 = abstractC0003Al0.b;
        if (zj2 != Zj2.f) {
            return zj2;
        }
        Zj2 zj2B = Zj2.b();
        abstractC0003Al0.b = zj2B;
        return zj2B;
    }

    public static List v(A a, long j) {
        return (List) AbstractC1633vk2.b.k(j, a);
    }

    public final int F(Object obj, byte[] bArr, int i, int i2, int i3, long j, We we) throws InvalidProtocolBufferException {
        Unsafe unsafe = p;
        Object objO = o(i3);
        Object object = unsafe.getObject(obj, j);
        this.n.getClass();
        if (AL0.d(object)) {
            C1778yL0 c1778yL0F = AL0.f();
            AL0.e(c1778yL0F, object);
            unsafe.putObject(obj, j, c1778yL0F);
            object = c1778yL0F;
        }
        C1667wL0 c1667wL0A = AL0.a(objO);
        C1778yL0 c1778yL0B = AL0.b(object);
        int iG = AbstractC0282Xe.G(bArr, i, we);
        int i4 = we.a;
        if (i4 < 0 || i4 > i2 - iG) {
            throw InvalidProtocolBufferException.j();
        }
        int i5 = iG + i4;
        Object obj2 = c1667wL0A.c;
        Object obj3 = 0;
        Object obj4 = obj2;
        while (iG < i5) {
            int iF = iG + 1;
            int i6 = bArr[iG];
            if (i6 < 0) {
                iF = AbstractC0282Xe.F(i6, bArr, iF, we);
                i6 = we.a;
            }
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i7 != 1) {
                if (i7 == 2) {
                    C1299pw2 c1299pw2 = c1667wL0A.b;
                    if (i8 == c1299pw2.u) {
                        iG = l(bArr, iF, i2, c1299pw2, obj2.getClass(), we);
                        obj4 = we.c;
                    }
                }
                iG = AbstractC0282Xe.K(i6, bArr, iF, i2, we);
            } else {
                EnumC1415rw2 enumC1415rw2 = c1667wL0A.a;
                if (i8 == enumC1415rw2.u) {
                    iG = l(bArr, iF, i2, enumC1415rw2, null, we);
                    obj3 = we.c;
                } else {
                    iG = AbstractC0282Xe.K(i6, bArr, iF, i2, we);
                }
            }
        }
        if (iG != i5) {
            throw InvalidProtocolBufferException.i();
        }
        c1778yL0B.put(obj3, obj4);
        return i5;
    }

    public final int G(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, We we) throws InvalidProtocolBufferException {
        Unsafe unsafe = p;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(AbstractC0282Xe.d(i, bArr)));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(AbstractC0282Xe.j(i, bArr)));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int I = AbstractC0282Xe.I(bArr, i, we);
                unsafe.putObject(obj, j, Long.valueOf(we.b));
                unsafe.putInt(obj, j2, i4);
                return I;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iG = AbstractC0282Xe.G(bArr, i, we);
                unsafe.putObject(obj, j, Integer.valueOf(we.a));
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(AbstractC0282Xe.h(i, bArr)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(AbstractC0282Xe.f(i, bArr)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int I2 = AbstractC0282Xe.I(bArr, i, we);
                unsafe.putObject(obj, j, Boolean.valueOf(we.b != 0));
                unsafe.putInt(obj, j2, i4);
                return I2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iG2 = AbstractC0282Xe.G(bArr, i, we);
                int i13 = we.a;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !AbstractC0104Im2.e(bArr, iG2, iG2 + i13)) {
                        throw InvalidProtocolBufferException.b();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iG2, i13, gz0.a));
                    iG2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iG2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iN = AbstractC0282Xe.n(p(i8), bArr, i, i2, we);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, we.c);
                } else {
                    unsafe.putObject(obj, j, gz0.c(object, we.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iN;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iB = AbstractC0282Xe.b(bArr, i, we);
                unsafe.putObject(obj, j, we.c);
                unsafe.putInt(obj, j2, i4);
                return iB;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iG3 = AbstractC0282Xe.G(bArr, i, we);
                int i14 = we.a;
                dz0 dz0VarN = n(i8);
                if (dz0VarN == null || dz0VarN.a(i14)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i14));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    q(obj).c(i3, Long.valueOf(i14));
                }
                return iG3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iG4 = AbstractC0282Xe.G(bArr, i, we);
                unsafe.putObject(obj, j, Integer.valueOf(yG.b(we.a)));
                unsafe.putInt(obj, j2, i4);
                return iG4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int I3 = AbstractC0282Xe.I(bArr, i, we);
                unsafe.putObject(obj, j, Long.valueOf(yG.c(we.b)));
                unsafe.putInt(obj, j2, i4);
                return I3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iL = AbstractC0282Xe.l(p(i8), bArr, i, i2, (i3 & (-8)) | 4, we);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, we.c);
                } else {
                    unsafe.putObject(obj, j, gz0.c(object2, we.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iL;
            default:
                return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x03b4, code lost:
    
        if (r0 != r33) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03b6, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r3 = r33;
        r13 = r34;
        r11 = r35;
        r9 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03d0, code lost:
    
        r7 = r33;
        r6 = r35;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0408, code lost:
    
        if (r0 != r15) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x042b, code lost:
    
        if (r0 != r15) goto L127;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x00ae. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int H(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, defpackage.We r36) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instruction units count: 1230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.H(java.lang.Object, byte[], int, int, int, We):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x02b3, code lost:
    
        if (r0 != r19) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02b5, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r6 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02cd, code lost:
    
        r6 = r33;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0305, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0326, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00a1. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(java.lang.Object r31, byte[] r32, int r33, int r34, defpackage.We r35) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instruction units count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.I(java.lang.Object, byte[], int, int, We):void");
    }

    public final int J(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, We we) {
        int iH;
        Unsafe unsafe = p;
        E e = (E) ((fz0) unsafe.getObject(obj, j2));
        boolean zF = e.f();
        E e2 = e;
        if (!zF) {
            int size = e.size();
            fz0 fz0VarY = e.Y(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j2, fz0VarY);
            e2 = fz0VarY;
        }
        switch (i7) {
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
            case 35:
                return i5 == 2 ? AbstractC0282Xe.q(bArr, i, e2, we) : i5 == 1 ? AbstractC0282Xe.e(i3, bArr, i, i2, e2, we) : i;
            case 19:
            case 36:
                return i5 == 2 ? AbstractC0282Xe.t(bArr, i, e2, we) : i5 == 5 ? AbstractC0282Xe.k(i3, bArr, i, i2, e2, we) : i;
            case 20:
            case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
            case 37:
            case 38:
                return i5 == 2 ? AbstractC0282Xe.x(bArr, i, e2, we) : i5 == 0 ? AbstractC0282Xe.J(i3, bArr, i, i2, e2, we) : i;
            case 22:
            case 29:
            case 39:
            case 43:
                return i5 == 2 ? AbstractC0282Xe.w(bArr, i, e2, we) : i5 == 0 ? AbstractC0282Xe.H(i3, bArr, i, i2, e2, we) : i;
            case ConnectionResult.API_DISABLED /* 23 */:
            case 32:
            case 40:
            case 46:
                return i5 == 2 ? AbstractC0282Xe.s(bArr, i, e2, we) : i5 == 1 ? AbstractC0282Xe.i(i3, bArr, i, i2, e2, we) : i;
            case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
            case 31:
            case 41:
            case 45:
                return i5 == 2 ? AbstractC0282Xe.r(bArr, i, e2, we) : i5 == 5 ? AbstractC0282Xe.g(i3, bArr, i, i2, e2, we) : i;
            case 25:
            case 42:
                return i5 == 2 ? AbstractC0282Xe.p(bArr, i, e2, we) : i5 == 0 ? AbstractC0282Xe.a(i3, bArr, i, i2, e2, we) : i;
            case 26:
                return i5 == 2 ? (j & 536870912) == 0 ? AbstractC0282Xe.B(i3, bArr, i, i2, e2, we) : AbstractC0282Xe.C(i3, bArr, i, i2, e2, we) : i;
            case 27:
                return i5 == 2 ? AbstractC0282Xe.o(p(i6), i3, bArr, i, i2, e2, we) : i;
            case 28:
                return i5 == 2 ? AbstractC0282Xe.c(i3, bArr, i, i2, e2, we) : i;
            case 30:
            case 44:
                if (i5 == 2) {
                    iH = AbstractC0282Xe.w(bArr, i, e2, we);
                } else {
                    if (i5 != 0) {
                        return i;
                    }
                    iH = AbstractC0282Xe.H(i3, bArr, i, i2, e2, we);
                }
                AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) obj;
                Zj2 zj2 = abstractC0003Al0.b;
                if (zj2 == Zj2.f) {
                    zj2 = null;
                }
                Zj2 zj22 = (Zj2) Fz1.z(i4, e2, n(i6), zj2, this.m);
                if (zj22 != null) {
                    abstractC0003Al0.b = zj22;
                }
                return iH;
            case 33:
            case 47:
                return i5 == 2 ? AbstractC0282Xe.u(bArr, i, e2, we) : i5 == 0 ? AbstractC0282Xe.y(i3, bArr, i, i2, e2, we) : i;
            case 34:
            case 48:
                return i5 == 2 ? AbstractC0282Xe.v(bArr, i, e2, we) : i5 == 0 ? AbstractC0282Xe.z(i3, bArr, i, i2, e2, we) : i;
            case 49:
                return i5 == 3 ? AbstractC0282Xe.m(p(i6), i3, bArr, i, i2, e2, we) : i;
            default:
                return i;
        }
    }

    public final void K(Object obj, long j, zG zGVar, Cz1 cz1, C1191o90 c1191o90) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iY;
        List listC = this.l.c(j, obj);
        int i = zGVar.b;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            listC.add(zGVar.r(cz1, c1191o90));
            yG yGVar = zGVar.a;
            if (yGVar.e() || zGVar.d != 0) {
                return;
            } else {
                iY = yGVar.y();
            }
        } while (iY == i);
        zGVar.d = iY;
    }

    public final void L(Object obj, int i, zG zGVar, Cz1 cz1, C1191o90 c1191o90) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iY;
        List listC = this.l.c(i & 1048575, obj);
        int i2 = zGVar.b;
        if ((i2 & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            listC.add(zGVar.x(cz1, c1191o90));
            yG yGVar = zGVar.a;
            if (yGVar.e() || zGVar.d != 0) {
                return;
            } else {
                iY = yGVar.y();
            }
        } while (iY == i2);
        zGVar.d = iY;
    }

    public final void M(Object obj, int i, zG zGVar) {
        if ((536870912 & i) != 0) {
            AbstractC1633vk2.u(i & 1048575, obj, zGVar.J());
        } else if (this.f) {
            AbstractC1633vk2.u(i & 1048575, obj, zGVar.H());
        } else {
            AbstractC1633vk2.u(i & 1048575, obj, zGVar.e());
        }
    }

    public final void N(Object obj, int i, zG zGVar) throws InvalidProtocolBufferException.InvalidWireTypeException {
        boolean z = (536870912 & i) != 0;
        AbstractC0764hG0 abstractC0764hG0 = this.l;
        if (z) {
            zGVar.I(abstractC0764hG0.c(i & 1048575, obj), true);
        } else {
            zGVar.I(abstractC0764hG0.c(i & 1048575, obj), false);
        }
    }

    public final void P(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        AbstractC1633vk2.s((1 << (i2 >>> 20)) | AbstractC1633vk2.b.i(j, obj), j, obj);
    }

    public final void Q(int i, int i2, Object obj) {
        AbstractC1633vk2.s(i, this.a[i2 + 2] & 1048575, obj);
    }

    public final int R(int i, int i2) {
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

    public final int T(int i) {
        return this.a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void U(Object obj, DG dg) {
        int i;
        boolean z;
        int[] iArr = this.a;
        int length = iArr.length;
        Unsafe unsafe = p;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iT = T(i4);
            int i6 = iArr[i4];
            int iS = S(iT);
            if (iS <= 17) {
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
            long j = iT & i2;
            switch (iS) {
                case 0:
                    if ((i5 & i9) != 0) {
                        dg.c(i6, AbstractC1633vk2.b.g(j, obj));
                    }
                    break;
                case 1:
                    if ((i5 & i9) != 0) {
                        dg.g(i6, AbstractC1633vk2.b.h(j, obj));
                    }
                    break;
                case 2:
                    if ((i5 & i9) != 0) {
                        dg.j(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if ((i5 & i9) != 0) {
                        dg.q(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if ((i5 & i9) != 0) {
                        dg.i(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if ((i5 & i9) != 0) {
                        dg.f(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if ((i5 & i9) != 0) {
                        dg.e(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if ((i5 & i9) != 0) {
                        dg.a(i6, AbstractC1633vk2.b.d(j, obj));
                    }
                    break;
                case 8:
                    if ((i5 & i9) != 0) {
                        W(i6, unsafe.getObject(obj, j), dg);
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if ((i5 & i9) != 0) {
                        dg.k(i6, unsafe.getObject(obj, j), p(i4));
                    }
                    break;
                case 10:
                    if ((i5 & i9) != 0) {
                        dg.b(i6, (C0199Qv) unsafe.getObject(obj, j));
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if ((i5 & i9) != 0) {
                        dg.p(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if ((i5 & i9) != 0) {
                        dg.d(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if ((i5 & i9) != 0) {
                        dg.l(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if ((i5 & i9) != 0) {
                        dg.m(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if ((i5 & i9) != 0) {
                        dg.n(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if ((i5 & i9) != 0) {
                        dg.o(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if ((i5 & i9) != 0) {
                        dg.h(i6, unsafe.getObject(obj, j), p(i4));
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    Fz1.G(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 19:
                    Fz1.K(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 20:
                    Fz1.N(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    Fz1.V(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 22:
                    Fz1.M(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    Fz1.J(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    Fz1.I(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 25:
                    Fz1.E(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 26:
                    Fz1.T(iArr[i4], (List) unsafe.getObject(obj, j), dg);
                    break;
                case 27:
                    Fz1.O(iArr[i4], (List) unsafe.getObject(obj, j), dg, p(i4));
                    break;
                case 28:
                    Fz1.F(iArr[i4], (List) unsafe.getObject(obj, j), dg);
                    break;
                case 29:
                    z = false;
                    Fz1.U(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 30:
                    z = false;
                    Fz1.H(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 31:
                    z = false;
                    Fz1.P(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 32:
                    z = false;
                    Fz1.Q(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 33:
                    z = false;
                    Fz1.R(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 34:
                    z = false;
                    Fz1.S(iArr[i4], (List) unsafe.getObject(obj, j), dg, false);
                    break;
                case 35:
                    Fz1.G(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 36:
                    Fz1.K(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 37:
                    Fz1.N(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 38:
                    Fz1.V(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 39:
                    Fz1.M(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 40:
                    Fz1.J(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 41:
                    Fz1.I(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 42:
                    Fz1.E(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 43:
                    Fz1.U(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 44:
                    Fz1.H(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 45:
                    Fz1.P(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 46:
                    Fz1.Q(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 47:
                    Fz1.R(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 48:
                    Fz1.S(iArr[i4], (List) unsafe.getObject(obj, j), dg, true);
                    break;
                case 49:
                    Fz1.L(iArr[i4], (List) unsafe.getObject(obj, j), dg, p(i4));
                    break;
                case 50:
                    V(dg, i6, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (u(i6, i4, obj)) {
                        dg.c(i6, ((Double) AbstractC1633vk2.b.k(j, obj)).doubleValue());
                    }
                    break;
                case 52:
                    if (u(i6, i4, obj)) {
                        dg.g(i6, ((Float) AbstractC1633vk2.b.k(j, obj)).floatValue());
                    }
                    break;
                case 53:
                    if (u(i6, i4, obj)) {
                        dg.j(i6, E(j, obj));
                    }
                    break;
                case 54:
                    if (u(i6, i4, obj)) {
                        dg.q(i6, E(j, obj));
                    }
                    break;
                case 55:
                    if (u(i6, i4, obj)) {
                        dg.i(i6, D(j, obj));
                    }
                    break;
                case 56:
                    if (u(i6, i4, obj)) {
                        dg.f(i6, E(j, obj));
                    }
                    break;
                case 57:
                    if (u(i6, i4, obj)) {
                        dg.e(i6, D(j, obj));
                    }
                    break;
                case 58:
                    if (u(i6, i4, obj)) {
                        dg.a(i6, ((Boolean) AbstractC1633vk2.b.k(j, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (u(i6, i4, obj)) {
                        W(i6, unsafe.getObject(obj, j), dg);
                    }
                    break;
                case 60:
                    if (u(i6, i4, obj)) {
                        dg.k(i6, unsafe.getObject(obj, j), p(i4));
                    }
                    break;
                case 61:
                    if (u(i6, i4, obj)) {
                        dg.b(i6, (C0199Qv) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (u(i6, i4, obj)) {
                        dg.p(i6, D(j, obj));
                    }
                    break;
                case 63:
                    if (u(i6, i4, obj)) {
                        dg.d(i6, D(j, obj));
                    }
                    break;
                case 64:
                    if (u(i6, i4, obj)) {
                        dg.l(i6, D(j, obj));
                    }
                    break;
                case 65:
                    if (u(i6, i4, obj)) {
                        dg.m(i6, E(j, obj));
                    }
                    break;
                case 66:
                    if (u(i6, i4, obj)) {
                        dg.n(i6, D(j, obj));
                    }
                    break;
                case 67:
                    if (u(i6, i4, obj)) {
                        dg.o(i6, E(j, obj));
                    }
                    break;
                case 68:
                    if (u(i6, i4, obj)) {
                        dg.h(i6, unsafe.getObject(obj, j), p(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        this.m.getClass();
        ((AbstractC0003Al0) obj).b.d(dg);
    }

    public final void V(DG dg, int i, Object obj, int i2) {
        if (obj != null) {
            Object objO = o(i2);
            this.n.getClass();
            C1667wL0 c1667wL0 = ((C1725xL0) objO).a;
            CG cg = dg.a;
            cg.getClass();
            for (Map.Entry entry : ((C1778yL0) obj).entrySet()) {
                cg.O(i, 2);
                cg.Q(C1725xL0.a(c1667wL0, entry.getKey(), entry.getValue()));
                C1725xL0.b(cg, c1667wL0, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // defpackage.Cz1
    public final void a(Object obj, DG dg) {
        dg.getClass();
        if (!this.g) {
            U(obj, dg);
            return;
        }
        int[] iArr = this.a;
        int length = iArr.length;
        for (int i = 0; i < length; i += 3) {
            int iT = T(i);
            int i2 = iArr[i];
            switch (S(iT)) {
                case 0:
                    if (t(i, obj)) {
                        dg.c(i2, AbstractC1633vk2.b.g(iT & 1048575, obj));
                    }
                    break;
                case 1:
                    if (t(i, obj)) {
                        dg.g(i2, AbstractC1633vk2.b.h(iT & 1048575, obj));
                    }
                    break;
                case 2:
                    if (t(i, obj)) {
                        dg.j(i2, AbstractC1633vk2.b.j(iT & 1048575, obj));
                    }
                    break;
                case 3:
                    if (t(i, obj)) {
                        dg.q(i2, AbstractC1633vk2.b.j(iT & 1048575, obj));
                    }
                    break;
                case 4:
                    if (t(i, obj)) {
                        dg.i(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 5:
                    if (t(i, obj)) {
                        dg.f(i2, AbstractC1633vk2.b.j(iT & 1048575, obj));
                    }
                    break;
                case 6:
                    if (t(i, obj)) {
                        dg.e(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 7:
                    if (t(i, obj)) {
                        dg.a(i2, AbstractC1633vk2.b.d(iT & 1048575, obj));
                    }
                    break;
                case 8:
                    if (t(i, obj)) {
                        W(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), dg);
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if (t(i, obj)) {
                        dg.k(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), p(i));
                    }
                    break;
                case 10:
                    if (t(i, obj)) {
                        dg.b(i2, (C0199Qv) AbstractC1633vk2.b.k(iT & 1048575, obj));
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (t(i, obj)) {
                        dg.p(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 12:
                    if (t(i, obj)) {
                        dg.d(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 13:
                    if (t(i, obj)) {
                        dg.l(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 14:
                    if (t(i, obj)) {
                        dg.m(i2, AbstractC1633vk2.b.j(iT & 1048575, obj));
                    }
                    break;
                case 15:
                    if (t(i, obj)) {
                        dg.n(i2, AbstractC1633vk2.b.i(iT & 1048575, obj));
                    }
                    break;
                case 16:
                    if (t(i, obj)) {
                        dg.o(i2, AbstractC1633vk2.b.j(iT & 1048575, obj));
                    }
                    break;
                case 17:
                    if (t(i, obj)) {
                        dg.h(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), p(i));
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    Fz1.G(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 19:
                    Fz1.K(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 20:
                    Fz1.N(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    Fz1.V(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 22:
                    Fz1.M(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    Fz1.J(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    Fz1.I(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 25:
                    Fz1.E(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 26:
                    Fz1.T(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg);
                    break;
                case 27:
                    Fz1.O(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, p(i));
                    break;
                case 28:
                    Fz1.F(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg);
                    break;
                case 29:
                    Fz1.U(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 30:
                    Fz1.H(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 31:
                    Fz1.P(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 32:
                    Fz1.Q(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 33:
                    Fz1.R(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 34:
                    Fz1.S(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, false);
                    break;
                case 35:
                    Fz1.G(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 36:
                    Fz1.K(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 37:
                    Fz1.N(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 38:
                    Fz1.V(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 39:
                    Fz1.M(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 40:
                    Fz1.J(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 41:
                    Fz1.I(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 42:
                    Fz1.E(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 43:
                    Fz1.U(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 44:
                    Fz1.H(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 45:
                    Fz1.P(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 46:
                    Fz1.Q(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 47:
                    Fz1.R(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 48:
                    Fz1.S(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, true);
                    break;
                case 49:
                    Fz1.L(iArr[i], (List) AbstractC1633vk2.b.k(iT & 1048575, obj), dg, p(i));
                    break;
                case 50:
                    V(dg, i2, AbstractC1633vk2.b.k(iT & 1048575, obj), i);
                    break;
                case 51:
                    if (u(i2, i, obj)) {
                        dg.c(i2, ((Double) AbstractC1633vk2.b.k(iT & 1048575, obj)).doubleValue());
                    }
                    break;
                case 52:
                    if (u(i2, i, obj)) {
                        dg.g(i2, ((Float) AbstractC1633vk2.b.k(iT & 1048575, obj)).floatValue());
                    }
                    break;
                case 53:
                    if (u(i2, i, obj)) {
                        dg.j(i2, E(iT & 1048575, obj));
                    }
                    break;
                case 54:
                    if (u(i2, i, obj)) {
                        dg.q(i2, E(iT & 1048575, obj));
                    }
                    break;
                case 55:
                    if (u(i2, i, obj)) {
                        dg.i(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 56:
                    if (u(i2, i, obj)) {
                        dg.f(i2, E(iT & 1048575, obj));
                    }
                    break;
                case 57:
                    if (u(i2, i, obj)) {
                        dg.e(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 58:
                    if (u(i2, i, obj)) {
                        dg.a(i2, ((Boolean) AbstractC1633vk2.b.k(iT & 1048575, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (u(i2, i, obj)) {
                        W(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), dg);
                    }
                    break;
                case 60:
                    if (u(i2, i, obj)) {
                        dg.k(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), p(i));
                    }
                    break;
                case 61:
                    if (u(i2, i, obj)) {
                        dg.b(i2, (C0199Qv) AbstractC1633vk2.b.k(iT & 1048575, obj));
                    }
                    break;
                case 62:
                    if (u(i2, i, obj)) {
                        dg.p(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 63:
                    if (u(i2, i, obj)) {
                        dg.d(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 64:
                    if (u(i2, i, obj)) {
                        dg.l(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 65:
                    if (u(i2, i, obj)) {
                        dg.m(i2, E(iT & 1048575, obj));
                    }
                    break;
                case 66:
                    if (u(i2, i, obj)) {
                        dg.n(i2, D(iT & 1048575, obj));
                    }
                    break;
                case 67:
                    if (u(i2, i, obj)) {
                        dg.o(i2, E(iT & 1048575, obj));
                    }
                    break;
                case 68:
                    if (u(i2, i, obj)) {
                        dg.h(i2, AbstractC1633vk2.b.k(iT & 1048575, obj), p(i));
                    }
                    break;
            }
        }
        this.m.getClass();
        ((AbstractC0003Al0) obj).b.d(dg);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.Cz1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(defpackage.AbstractC0003Al0 r12) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.b(Al0):int");
    }

    @Override // defpackage.Cz1
    public final void c(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02) {
        abstractC0003Al02.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i >= iArr.length) {
                Fz1.B(this.m, abstractC0003Al0, abstractC0003Al02);
                return;
            }
            int iT = T(i);
            long j = 1048575 & iT;
            int i2 = iArr[i];
            switch (S(iT)) {
                case 0:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.q(abstractC0003Al0, j, AbstractC1633vk2.b.g(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 1:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.r(AbstractC1633vk2.b.h(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 2:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.t(abstractC0003Al0, j, AbstractC1633vk2.b.j(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 3:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.t(abstractC0003Al0, j, AbstractC1633vk2.b.j(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 4:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 5:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.t(abstractC0003Al0, j, AbstractC1633vk2.b.j(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 6:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 7:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.m(abstractC0003Al0, j, AbstractC1633vk2.b.d(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 8:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.u(j, abstractC0003Al0, AbstractC1633vk2.b.k(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    y(abstractC0003Al0, abstractC0003Al02, i);
                    break;
                case 10:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.u(j, abstractC0003Al0, AbstractC1633vk2.b.k(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 12:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 13:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 14:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.t(abstractC0003Al0, j, AbstractC1633vk2.b.j(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 15:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.s(AbstractC1633vk2.b.i(j, abstractC0003Al02), j, abstractC0003Al0);
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 16:
                    if (t(i, abstractC0003Al02)) {
                        AbstractC1633vk2.t(abstractC0003Al0, j, AbstractC1633vk2.b.j(j, abstractC0003Al02));
                        P(i, abstractC0003Al0);
                    }
                    break;
                case 17:
                    y(abstractC0003Al0, abstractC0003Al02, i);
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
                    this.l.b(abstractC0003Al0, abstractC0003Al02, j);
                    break;
                case 50:
                    Class cls = Fz1.a;
                    AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
                    Object objK = abstractC1577uk2.k(j, abstractC0003Al0);
                    Object objK2 = abstractC1577uk2.k(j, abstractC0003Al02);
                    this.n.getClass();
                    AbstractC1633vk2.u(j, abstractC0003Al0, AL0.e(objK, objK2));
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
                    if (u(i2, i, abstractC0003Al02)) {
                        AbstractC1633vk2.u(j, abstractC0003Al0, AbstractC1633vk2.b.k(j, abstractC0003Al02));
                        Q(i2, i, abstractC0003Al0);
                    }
                    break;
                case 60:
                    z(abstractC0003Al0, abstractC0003Al02, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (u(i2, i, abstractC0003Al02)) {
                        AbstractC1633vk2.u(j, abstractC0003Al0, AbstractC1633vk2.b.k(j, abstractC0003Al02));
                        Q(i2, i, abstractC0003Al0);
                    }
                    break;
                case 68:
                    z(abstractC0003Al0, abstractC0003Al02, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // defpackage.Cz1
    public final void d(Object obj) {
        int[] iArr;
        int i;
        int i2 = this.i;
        while (true) {
            iArr = this.h;
            i = this.j;
            if (i2 >= i) {
                break;
            }
            long jT = T(iArr[i2]) & 1048575;
            Object objK = AbstractC1633vk2.b.k(jT, obj);
            if (objK != null) {
                this.n.getClass();
                ((C1778yL0) objK).t = false;
                AbstractC1633vk2.u(jT, obj, objK);
            }
            i2++;
        }
        int length = iArr.length;
        while (i < length) {
            this.l.a(iArr[i], obj);
            i++;
        }
        this.m.getClass();
        ((AbstractC0003Al0) obj).b.e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // defpackage.Cz1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(defpackage.AbstractC0003Al0 r12, java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.e(Al0, java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d0  */
    @Override // defpackage.Cz1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.f(java.lang.Object):boolean");
    }

    @Override // defpackage.Cz1
    public final void g(Object obj, byte[] bArr, int i, int i2, We we) throws InvalidProtocolBufferException {
        if (this.g) {
            I(obj, bArr, i, i2, we);
        } else {
            H(obj, bArr, i, i2, 0, we);
        }
    }

    @Override // defpackage.Cz1
    public final int h(A a) {
        return this.g ? s(a) : r(a);
    }

    @Override // defpackage.Cz1
    public final void i(Object obj, zG zGVar, C1191o90 c1191o90) throws Throwable {
        c1191o90.getClass();
        w(this.m, obj, zGVar, c1191o90);
    }

    @Override // defpackage.Cz1
    public final Object j() {
        this.k.getClass();
        return ((AbstractC0003Al0) this.e).f(EnumC1862zl0.w, null, null);
    }

    public final boolean k(AbstractC0003Al0 abstractC0003Al0, Object obj, int i) {
        return t(i, abstractC0003Al0) == t(i, obj);
    }

    public final Object m(Object obj, int i, Object obj2, C0373ak2 c0373ak2) {
        dz0 dz0VarN;
        int i2 = this.a[i];
        Object objK = AbstractC1633vk2.b.k(T(i) & 1048575, obj);
        if (objK == null || (dz0VarN = n(i)) == null) {
            return obj2;
        }
        this.n.getClass();
        C1667wL0 c1667wL0 = ((C1725xL0) o(i)).a;
        Iterator it = ((C1778yL0) objK).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!dz0VarN.a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    c0373ak2.getClass();
                    obj2 = Zj2.b();
                }
                int iA = C1725xL0.a(c1667wL0, entry.getKey(), entry.getValue());
                byte[] bArr = new byte[iA];
                boolean z = CG.b;
                AG ag = new AG(iA, bArr);
                try {
                    C1725xL0.b(ag, c1667wL0, entry.getKey(), entry.getValue());
                    if (ag.T() != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    C0199Qv c0199Qv = new C0199Qv(bArr);
                    c0373ak2.getClass();
                    ((Zj2) obj2).c((i2 << 3) | 2, c0199Qv);
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    public final dz0 n(int i) {
        return (dz0) this.b[((i / 3) * 2) + 1];
    }

    public final Object o(int i) {
        return this.b[(i / 3) * 2];
    }

    public final Cz1 p(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        Cz1 cz1 = (Cz1) objArr[i2];
        if (cz1 != null) {
            return cz1;
        }
        Cz1 cz1A = C0734gn1.c.a((Class) objArr[i2 + 1]);
        objArr[i2] = cz1A;
        return cz1A;
    }

    public final int r(A a) {
        int i;
        int iE;
        int iC;
        int i2;
        int iT;
        Unsafe unsafe = p;
        int i3 = 0;
        int iA = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                this.m.getClass();
                return ((AbstractC0003Al0) a).b.a() + iA;
            }
            int iT2 = T(i3);
            int i6 = iArr[i3];
            int iS = S(iT2);
            if (iS <= 17) {
                int i7 = iArr[i3 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i5) {
                    i4 = unsafe.getInt(a, i8);
                    i5 = i8;
                }
            } else {
                i = 0;
            }
            long j = iT2 & 1048575;
            switch (iS) {
                case 0:
                    if ((i & i4) != 0) {
                        iE = CG.e(i6);
                        iA += iE;
                    }
                    break;
                case 1:
                    if ((i & i4) != 0) {
                        iE = CG.i(i6);
                        iA += iE;
                    }
                    break;
                case 2:
                    if ((i & i4) != 0) {
                        iE = CG.m(i6, unsafe.getLong(a, j));
                        iA += iE;
                    }
                    break;
                case 3:
                    if ((i & i4) != 0) {
                        iE = CG.w(i6, unsafe.getLong(a, j));
                        iA += iE;
                    }
                    break;
                case 4:
                    if ((i & i4) != 0) {
                        iE = CG.k(i6, unsafe.getInt(a, j));
                        iA += iE;
                    }
                    break;
                case 5:
                    if ((i & i4) != 0) {
                        iE = CG.h(i6);
                        iA += iE;
                    }
                    break;
                case 6:
                    if ((i & i4) != 0) {
                        iE = CG.g(i6);
                        iA += iE;
                    }
                    break;
                case 7:
                    if ((i & i4) != 0) {
                        iE = CG.b(i6);
                        iA += iE;
                    }
                    break;
                case 8:
                    if ((i & i4) != 0) {
                        Object object = unsafe.getObject(a, j);
                        iC = object instanceof C0199Qv ? CG.c(i6, (C0199Qv) object) : CG.r(i6, (String) object);
                        iA = iC + iA;
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if ((i & i4) != 0) {
                        iE = Fz1.o(i6, unsafe.getObject(a, j), p(i3));
                        iA += iE;
                    }
                    break;
                case 10:
                    if ((i & i4) != 0) {
                        iE = CG.c(i6, (C0199Qv) unsafe.getObject(a, j));
                        iA += iE;
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if ((i & i4) != 0) {
                        iE = CG.u(i6, unsafe.getInt(a, j));
                        iA += iE;
                    }
                    break;
                case 12:
                    if ((i & i4) != 0) {
                        iE = CG.f(i6, unsafe.getInt(a, j));
                        iA += iE;
                    }
                    break;
                case 13:
                    if ((i & i4) != 0) {
                        iE = CG.n(i6);
                        iA += iE;
                    }
                    break;
                case 14:
                    if ((i & i4) != 0) {
                        iE = CG.o(i6);
                        iA += iE;
                    }
                    break;
                case 15:
                    if ((i & i4) != 0) {
                        iE = CG.p(i6, unsafe.getInt(a, j));
                        iA += iE;
                    }
                    break;
                case 16:
                    if ((i & i4) != 0) {
                        iE = CG.q(i6, unsafe.getLong(a, j));
                        iA += iE;
                    }
                    break;
                case 17:
                    if ((i & i4) != 0) {
                        iE = CG.j(i6, (InterfaceC1787yS0) unsafe.getObject(a, j), p(i3));
                        iA += iE;
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    iE = Fz1.h(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 19:
                    iE = Fz1.f(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 20:
                    iE = Fz1.m(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    iE = Fz1.x(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 22:
                    iE = Fz1.k(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    iE = Fz1.h(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    iE = Fz1.f(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 25:
                    iE = Fz1.a(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 26:
                    iE = Fz1.u(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 27:
                    iE = Fz1.p(i6, (List) unsafe.getObject(a, j), p(i3));
                    iA += iE;
                    break;
                case 28:
                    iE = Fz1.c(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 29:
                    iE = Fz1.v(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 30:
                    iE = Fz1.d(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 31:
                    iE = Fz1.f(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 32:
                    iE = Fz1.h(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 33:
                    iE = Fz1.q(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 34:
                    iE = Fz1.s(i6, (List) unsafe.getObject(a, j));
                    iA += iE;
                    break;
                case 35:
                    i2 = Fz1.i((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 36:
                    i2 = Fz1.g((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 37:
                    i2 = Fz1.n((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 38:
                    i2 = Fz1.y((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 39:
                    i2 = Fz1.l((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 40:
                    i2 = Fz1.i((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 41:
                    i2 = Fz1.g((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 42:
                    i2 = Fz1.b((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 43:
                    i2 = Fz1.w((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 44:
                    i2 = Fz1.e((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 45:
                    i2 = Fz1.g((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 46:
                    i2 = Fz1.i((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 47:
                    i2 = Fz1.r((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 48:
                    i2 = Fz1.t((List) unsafe.getObject(a, j));
                    if (i2 > 0) {
                        iT = CG.t(i6);
                        iA = AbstractC1835zL0.a(i2, iT, i2, iA);
                    }
                    break;
                case 49:
                    iE = Fz1.j(i6, (List) unsafe.getObject(a, j), p(i3));
                    iA += iE;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(a, j);
                    Object objO = o(i3);
                    this.n.getClass();
                    iE = AL0.c(i6, object2, objO);
                    iA += iE;
                    break;
                case 51:
                    if (u(i6, i3, a)) {
                        iE = CG.e(i6);
                        iA += iE;
                    }
                    break;
                case 52:
                    if (u(i6, i3, a)) {
                        iE = CG.i(i6);
                        iA += iE;
                    }
                    break;
                case 53:
                    if (u(i6, i3, a)) {
                        iE = CG.m(i6, E(j, a));
                        iA += iE;
                    }
                    break;
                case 54:
                    if (u(i6, i3, a)) {
                        iE = CG.w(i6, E(j, a));
                        iA += iE;
                    }
                    break;
                case 55:
                    if (u(i6, i3, a)) {
                        iE = CG.k(i6, D(j, a));
                        iA += iE;
                    }
                    break;
                case 56:
                    if (u(i6, i3, a)) {
                        iE = CG.h(i6);
                        iA += iE;
                    }
                    break;
                case 57:
                    if (u(i6, i3, a)) {
                        iE = CG.g(i6);
                        iA += iE;
                    }
                    break;
                case 58:
                    if (u(i6, i3, a)) {
                        iE = CG.b(i6);
                        iA += iE;
                    }
                    break;
                case 59:
                    if (u(i6, i3, a)) {
                        Object object3 = unsafe.getObject(a, j);
                        iC = object3 instanceof C0199Qv ? CG.c(i6, (C0199Qv) object3) : CG.r(i6, (String) object3);
                        iA = iC + iA;
                    }
                    break;
                case 60:
                    if (u(i6, i3, a)) {
                        iE = Fz1.o(i6, unsafe.getObject(a, j), p(i3));
                        iA += iE;
                    }
                    break;
                case 61:
                    if (u(i6, i3, a)) {
                        iE = CG.c(i6, (C0199Qv) unsafe.getObject(a, j));
                        iA += iE;
                    }
                    break;
                case 62:
                    if (u(i6, i3, a)) {
                        iE = CG.u(i6, D(j, a));
                        iA += iE;
                    }
                    break;
                case 63:
                    if (u(i6, i3, a)) {
                        iE = CG.f(i6, D(j, a));
                        iA += iE;
                    }
                    break;
                case 64:
                    if (u(i6, i3, a)) {
                        iE = CG.n(i6);
                        iA += iE;
                    }
                    break;
                case 65:
                    if (u(i6, i3, a)) {
                        iE = CG.o(i6);
                        iA += iE;
                    }
                    break;
                case 66:
                    if (u(i6, i3, a)) {
                        iE = CG.p(i6, D(j, a));
                        iA += iE;
                    }
                    break;
                case 67:
                    if (u(i6, i3, a)) {
                        iE = CG.q(i6, E(j, a));
                        iA += iE;
                    }
                    break;
                case 68:
                    if (u(i6, i3, a)) {
                        iE = CG.j(i6, (InterfaceC1787yS0) unsafe.getObject(a, j), p(i3));
                        iA += iE;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    public final int s(A a) {
        int iE;
        int i;
        int iT;
        Unsafe unsafe = p;
        int i2 = 0;
        int iA = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                this.m.getClass();
                return ((AbstractC0003Al0) a).b.a() + iA;
            }
            int iT2 = T(i2);
            int iS = S(iT2);
            int i3 = iArr[i2];
            long j = iT2 & 1048575;
            if (iS >= Nd0.u.a() && iS <= Nd0.v.a()) {
                int i4 = iArr[i2 + 2];
            }
            switch (iS) {
                case 0:
                    if (t(i2, a)) {
                        iE = CG.e(i3);
                        iA = iE + iA;
                    }
                    break;
                case 1:
                    if (t(i2, a)) {
                        iE = CG.i(i3);
                        iA = iE + iA;
                    }
                    break;
                case 2:
                    if (t(i2, a)) {
                        iE = CG.m(i3, AbstractC1633vk2.j(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 3:
                    if (t(i2, a)) {
                        iE = CG.w(i3, AbstractC1633vk2.j(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 4:
                    if (t(i2, a)) {
                        iE = CG.k(i3, AbstractC1633vk2.i(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 5:
                    if (t(i2, a)) {
                        iE = CG.h(i3);
                        iA = iE + iA;
                    }
                    break;
                case 6:
                    if (t(i2, a)) {
                        iE = CG.g(i3);
                        iA = iE + iA;
                    }
                    break;
                case 7:
                    if (t(i2, a)) {
                        iE = CG.b(i3);
                        iA = iE + iA;
                    }
                    break;
                case 8:
                    if (t(i2, a)) {
                        Object objK = AbstractC1633vk2.k(j, a);
                        iE = objK instanceof C0199Qv ? CG.c(i3, (C0199Qv) objK) : CG.r(i3, (String) objK);
                        iA = iE + iA;
                    }
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    if (t(i2, a)) {
                        iE = Fz1.o(i3, AbstractC1633vk2.k(j, a), p(i2));
                        iA = iE + iA;
                    }
                    break;
                case 10:
                    if (t(i2, a)) {
                        iE = CG.c(i3, (C0199Qv) AbstractC1633vk2.k(j, a));
                        iA = iE + iA;
                    }
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    if (t(i2, a)) {
                        iE = CG.u(i3, AbstractC1633vk2.i(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 12:
                    if (t(i2, a)) {
                        iE = CG.f(i3, AbstractC1633vk2.i(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 13:
                    if (t(i2, a)) {
                        iE = CG.n(i3);
                        iA = iE + iA;
                    }
                    break;
                case 14:
                    if (t(i2, a)) {
                        iE = CG.o(i3);
                        iA = iE + iA;
                    }
                    break;
                case 15:
                    if (t(i2, a)) {
                        iE = CG.p(i3, AbstractC1633vk2.i(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 16:
                    if (t(i2, a)) {
                        iE = CG.q(i3, AbstractC1633vk2.j(a, j));
                        iA = iE + iA;
                    }
                    break;
                case 17:
                    if (t(i2, a)) {
                        iE = CG.j(i3, (InterfaceC1787yS0) AbstractC1633vk2.k(j, a), p(i2));
                        iA = iE + iA;
                    }
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    iE = Fz1.h(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 19:
                    iE = Fz1.f(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 20:
                    iE = Fz1.m(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    iE = Fz1.x(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 22:
                    iE = Fz1.k(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    iE = Fz1.h(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    iE = Fz1.f(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 25:
                    iE = Fz1.a(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 26:
                    iE = Fz1.u(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 27:
                    iE = Fz1.p(i3, v(a, j), p(i2));
                    iA = iE + iA;
                    break;
                case 28:
                    iE = Fz1.c(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 29:
                    iE = Fz1.v(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 30:
                    iE = Fz1.d(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 31:
                    iE = Fz1.f(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 32:
                    iE = Fz1.h(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 33:
                    iE = Fz1.q(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 34:
                    iE = Fz1.s(i3, v(a, j));
                    iA = iE + iA;
                    break;
                case 35:
                    i = Fz1.i((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 36:
                    i = Fz1.g((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 37:
                    i = Fz1.n((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 38:
                    i = Fz1.y((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 39:
                    i = Fz1.l((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 40:
                    i = Fz1.i((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 41:
                    i = Fz1.g((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 42:
                    i = Fz1.b((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 43:
                    i = Fz1.w((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 44:
                    i = Fz1.e((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 45:
                    i = Fz1.g((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 46:
                    i = Fz1.i((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 47:
                    i = Fz1.r((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 48:
                    i = Fz1.t((List) unsafe.getObject(a, j));
                    if (i > 0) {
                        iT = CG.t(i3);
                        iA = AbstractC1835zL0.a(i, iT, i, iA);
                    }
                    break;
                case 49:
                    iE = Fz1.j(i3, v(a, j), p(i2));
                    iA = iE + iA;
                    break;
                case 50:
                    Object objK2 = AbstractC1633vk2.k(j, a);
                    Object objO = o(i2);
                    this.n.getClass();
                    iE = AL0.c(i3, objK2, objO);
                    iA = iE + iA;
                    break;
                case 51:
                    if (u(i3, i2, a)) {
                        iE = CG.e(i3);
                        iA = iE + iA;
                    }
                    break;
                case 52:
                    if (u(i3, i2, a)) {
                        iE = CG.i(i3);
                        iA = iE + iA;
                    }
                    break;
                case 53:
                    if (u(i3, i2, a)) {
                        iE = CG.m(i3, E(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 54:
                    if (u(i3, i2, a)) {
                        iE = CG.w(i3, E(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 55:
                    if (u(i3, i2, a)) {
                        iE = CG.k(i3, D(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 56:
                    if (u(i3, i2, a)) {
                        iE = CG.h(i3);
                        iA = iE + iA;
                    }
                    break;
                case 57:
                    if (u(i3, i2, a)) {
                        iE = CG.g(i3);
                        iA = iE + iA;
                    }
                    break;
                case 58:
                    if (u(i3, i2, a)) {
                        iE = CG.b(i3);
                        iA = iE + iA;
                    }
                    break;
                case 59:
                    if (u(i3, i2, a)) {
                        Object objK3 = AbstractC1633vk2.k(j, a);
                        iE = objK3 instanceof C0199Qv ? CG.c(i3, (C0199Qv) objK3) : CG.r(i3, (String) objK3);
                        iA = iE + iA;
                    }
                    break;
                case 60:
                    if (u(i3, i2, a)) {
                        iE = Fz1.o(i3, AbstractC1633vk2.k(j, a), p(i2));
                        iA = iE + iA;
                    }
                    break;
                case 61:
                    if (u(i3, i2, a)) {
                        iE = CG.c(i3, (C0199Qv) AbstractC1633vk2.k(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 62:
                    if (u(i3, i2, a)) {
                        iE = CG.u(i3, D(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 63:
                    if (u(i3, i2, a)) {
                        iE = CG.f(i3, D(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 64:
                    if (u(i3, i2, a)) {
                        iE = CG.n(i3);
                        iA = iE + iA;
                    }
                    break;
                case 65:
                    if (u(i3, i2, a)) {
                        iE = CG.o(i3);
                        iA = iE + iA;
                    }
                    break;
                case 66:
                    if (u(i3, i2, a)) {
                        iE = CG.p(i3, D(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 67:
                    if (u(i3, i2, a)) {
                        iE = CG.q(i3, E(j, a));
                        iA = iE + iA;
                    }
                    break;
                case 68:
                    if (u(i3, i2, a)) {
                        iE = CG.j(i3, (InterfaceC1787yS0) AbstractC1633vk2.k(j, a), p(i2));
                        iA = iE + iA;
                    }
                    break;
            }
            i2 += 3;
        }
    }

    public final boolean t(int i, Object obj) {
        int i2 = this.a[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return ((1 << (i2 >>> 20)) & AbstractC1633vk2.b.i(j, obj)) != 0;
        }
        int iT = T(i);
        long j2 = iT & 1048575;
        switch (S(iT)) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC1633vk2.b.g(j2, obj)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC1633vk2.b.h(j2, obj)) != 0;
            case 2:
                return AbstractC1633vk2.b.j(j2, obj) != 0;
            case 3:
                return AbstractC1633vk2.b.j(j2, obj) != 0;
            case 4:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 5:
                return AbstractC1633vk2.b.j(j2, obj) != 0;
            case 6:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 7:
                return AbstractC1633vk2.b.d(j2, obj);
            case 8:
                Object objK = AbstractC1633vk2.b.k(j2, obj);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof C0199Qv) {
                    return !C0199Qv.v.equals(objK);
                }
                throw new IllegalArgumentException();
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                return AbstractC1633vk2.b.k(j2, obj) != null;
            case 10:
                return !C0199Qv.v.equals(AbstractC1633vk2.b.k(j2, obj));
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 12:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 13:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 14:
                return AbstractC1633vk2.b.j(j2, obj) != 0;
            case 15:
                return AbstractC1633vk2.b.i(j2, obj) != 0;
            case 16:
                return AbstractC1633vk2.b.j(j2, obj) != 0;
            case 17:
                return AbstractC1633vk2.b.k(j2, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean u(int i, int i2, Object obj) {
        return AbstractC1633vk2.b.i((long) (this.a[i2 + 2] & 1048575), obj) == i;
    }

    public final void w(C0373ak2 c0373ak2, Object obj, zG zGVar, C1191o90 c1191o90) throws Throwable {
        int i;
        Zj2 zj2;
        int iS;
        AbstractC0764hG0 abstractC0764hG0;
        int[] iArr = this.h;
        int i2 = this.j;
        int i3 = this.i;
        Object objM = null;
        while (true) {
            try {
                int iA = zGVar.a();
                int iR = (iA < this.c || iA > this.d) ? -1 : R(iA, 0);
                Zj2 zj22 = Zj2.f;
                if (iR >= 0) {
                    int iT = T(iR);
                    try {
                        iS = S(iT);
                        abstractC0764hG0 = this.l;
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        i = i3;
                        zj2 = zj22;
                    }
                    switch (iS) {
                        case 0:
                            i = i3;
                            AbstractC1633vk2.q(obj, C(iT), zGVar.g());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 1:
                            i = i3;
                            AbstractC1633vk2.r(zGVar.p(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 2:
                            i = i3;
                            AbstractC1633vk2.t(obj, C(iT), zGVar.v());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 3:
                            i = i3;
                            AbstractC1633vk2.t(obj, C(iT), zGVar.M());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 4:
                            i = i3;
                            AbstractC1633vk2.s(zGVar.t(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 5:
                            i = i3;
                            AbstractC1633vk2.t(obj, C(iT), zGVar.n());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 6:
                            i = i3;
                            AbstractC1633vk2.s(zGVar.l(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 7:
                            i = i3;
                            AbstractC1633vk2.m(obj, C(iT), zGVar.c());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 8:
                            i = i3;
                            M(obj, iT, zGVar);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case ConnectionResult.SERVICE_INVALID /* 9 */:
                            i = i3;
                            if (t(iR, obj)) {
                                AbstractC1633vk2.u(C(iT), obj, gz0.c(AbstractC1633vk2.k(C(iT), obj), zGVar.y(p(iR), c1191o90)));
                            } else {
                                AbstractC1633vk2.u(C(iT), obj, zGVar.y(p(iR), c1191o90));
                                P(iR, obj);
                            }
                            i3 = i;
                            break;
                        case 10:
                            i = i3;
                            AbstractC1633vk2.u(C(iT), obj, zGVar.e());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                            i = i3;
                            AbstractC1633vk2.s(zGVar.K(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 12:
                            i = i3;
                            int i4 = zGVar.i();
                            dz0 dz0VarN = n(iR);
                            if (dz0VarN == null || dz0VarN.a(i4)) {
                                AbstractC1633vk2.s(i4, C(iT), obj);
                                P(iR, obj);
                            } else {
                                objM = Fz1.D(iA, i4, objM, c0373ak2);
                            }
                            i3 = i;
                            break;
                        case 13:
                            i = i3;
                            AbstractC1633vk2.s(zGVar.z(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 14:
                            i = i3;
                            AbstractC1633vk2.t(obj, C(iT), zGVar.B());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 15:
                            i = i3;
                            AbstractC1633vk2.s(zGVar.D(), C(iT), obj);
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 16:
                            i = i3;
                            AbstractC1633vk2.t(obj, C(iT), zGVar.F());
                            P(iR, obj);
                            i3 = i;
                            break;
                        case 17:
                            i = i3;
                            if (t(iR, obj)) {
                                AbstractC1633vk2.u(C(iT), obj, gz0.c(AbstractC1633vk2.k(C(iT), obj), zGVar.s(p(iR), c1191o90)));
                            } else {
                                AbstractC1633vk2.u(C(iT), obj, zGVar.s(p(iR), c1191o90));
                                P(iR, obj);
                            }
                            i3 = i;
                            break;
                        case ConnectionResult.SERVICE_UPDATING /* 18 */:
                            i = i3;
                            zGVar.h(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 19:
                            i = i3;
                            zGVar.q(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 20:
                            i = i3;
                            zGVar.w(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                            i = i3;
                            zGVar.N(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 22:
                            i = i3;
                            zGVar.u(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case ConnectionResult.API_DISABLED /* 23 */:
                            i = i3;
                            zGVar.o(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                            i = i3;
                            zGVar.m(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 25:
                            i = i3;
                            zGVar.d(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 26:
                            i = i3;
                            N(obj, iT, zGVar);
                            i3 = i;
                            break;
                        case 27:
                            i = i3;
                            L(obj, iT, zGVar, p(iR), c1191o90);
                            i3 = i;
                            break;
                        case 28:
                            i = i3;
                            zGVar.f(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 29:
                            i = i3;
                            zGVar.L(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 30:
                            i = i3;
                            List listC = abstractC0764hG0.c(C(iT), obj);
                            zGVar.j(listC);
                            objM = Fz1.z(iA, listC, n(iR), objM, c0373ak2);
                            i3 = i;
                            break;
                        case 31:
                            i = i3;
                            zGVar.A(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 32:
                            i = i3;
                            zGVar.C(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 33:
                            i = i3;
                            zGVar.E(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 34:
                            i = i3;
                            zGVar.G(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 35:
                            i = i3;
                            zGVar.h(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 36:
                            i = i3;
                            zGVar.q(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 37:
                            i = i3;
                            zGVar.w(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 38:
                            i = i3;
                            zGVar.N(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 39:
                            i = i3;
                            zGVar.u(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 40:
                            i = i3;
                            zGVar.o(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 41:
                            i = i3;
                            zGVar.m(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 42:
                            i = i3;
                            zGVar.d(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 43:
                            i = i3;
                            zGVar.L(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 44:
                            i = i3;
                            List listC2 = abstractC0764hG0.c(C(iT), obj);
                            zGVar.j(listC2);
                            objM = Fz1.z(iA, listC2, n(iR), objM, c0373ak2);
                            i3 = i;
                            break;
                        case 45:
                            i = i3;
                            zGVar.A(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 46:
                            i = i3;
                            zGVar.C(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 47:
                            i = i3;
                            zGVar.E(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 48:
                            i = i3;
                            zGVar.G(abstractC0764hG0.c(C(iT), obj));
                            i3 = i;
                            break;
                        case 49:
                            i = i3;
                            zj2 = zj22;
                            try {
                                try {
                                    K(obj, C(iT), zGVar, p(iR), c1191o90);
                                } catch (Throwable th) {
                                    th = th;
                                    for (int i5 = i; i5 < i2; i5++) {
                                        objM = m(obj, iArr[i5], objM, c0373ak2);
                                    }
                                    if (objM != null) {
                                        c0373ak2.getClass();
                                        C0373ak2.c(obj, objM);
                                    }
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                c0373ak2.getClass();
                                if (objM == null) {
                                    AbstractC0003Al0 abstractC0003Al0 = (AbstractC0003Al0) obj;
                                    Zj2 zj2B = abstractC0003Al0.b;
                                    if (zj2B == zj2) {
                                        zj2B = Zj2.b();
                                        abstractC0003Al0.b = zj2B;
                                    }
                                    objM = zj2B;
                                }
                                if (!C0373ak2.a(objM, zGVar)) {
                                    for (int i6 = i; i6 < i2; i6++) {
                                        objM = m(obj, iArr[i6], objM, c0373ak2);
                                    }
                                    if (objM != null) {
                                        C0373ak2.c(obj, objM);
                                        return;
                                    }
                                    return;
                                }
                            }
                            i3 = i;
                            break;
                        case 50:
                            x(obj, iR, o(iR), c1191o90, zGVar);
                            i = i3;
                            i3 = i;
                            break;
                        case 51:
                            AbstractC1633vk2.u(C(iT), obj, Double.valueOf(zGVar.g()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 52:
                            AbstractC1633vk2.u(C(iT), obj, Float.valueOf(zGVar.p()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 53:
                            AbstractC1633vk2.u(C(iT), obj, Long.valueOf(zGVar.v()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 54:
                            AbstractC1633vk2.u(C(iT), obj, Long.valueOf(zGVar.M()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 55:
                            AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(zGVar.t()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 56:
                            AbstractC1633vk2.u(C(iT), obj, Long.valueOf(zGVar.n()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 57:
                            AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(zGVar.l()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 58:
                            AbstractC1633vk2.u(C(iT), obj, Boolean.valueOf(zGVar.c()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 59:
                            M(obj, iT, zGVar);
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 60:
                            if (u(iA, iR, obj)) {
                                AbstractC1633vk2.u(C(iT), obj, gz0.c(AbstractC1633vk2.k(C(iT), obj), zGVar.y(p(iR), c1191o90)));
                            } else {
                                AbstractC1633vk2.u(C(iT), obj, zGVar.y(p(iR), c1191o90));
                                P(iR, obj);
                            }
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 61:
                            AbstractC1633vk2.u(C(iT), obj, zGVar.e());
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 62:
                            AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(zGVar.K()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 63:
                            int i7 = zGVar.i();
                            dz0 dz0VarN2 = n(iR);
                            if (dz0VarN2 == null || dz0VarN2.a(i7)) {
                                AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(i7));
                                Q(iA, iR, obj);
                            } else {
                                objM = Fz1.D(iA, i7, objM, c0373ak2);
                            }
                            i = i3;
                            i3 = i;
                            break;
                        case 64:
                            AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(zGVar.z()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 65:
                            AbstractC1633vk2.u(C(iT), obj, Long.valueOf(zGVar.B()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 66:
                            AbstractC1633vk2.u(C(iT), obj, Integer.valueOf(zGVar.D()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 67:
                            AbstractC1633vk2.u(C(iT), obj, Long.valueOf(zGVar.F()));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        case 68:
                            AbstractC1633vk2.u(C(iT), obj, zGVar.s(p(iR), c1191o90));
                            Q(iA, iR, obj);
                            i = i3;
                            i3 = i;
                            break;
                        default:
                            if (objM == null) {
                                c0373ak2.getClass();
                                objM = C0373ak2.b();
                            }
                            c0373ak2.getClass();
                            if (!C0373ak2.a(objM, zGVar)) {
                                while (i3 < i2) {
                                    objM = m(obj, iArr[i3], objM, c0373ak2);
                                    i3++;
                                }
                                if (objM != null) {
                                    C0373ak2.c(obj, objM);
                                    return;
                                }
                                return;
                            }
                            i = i3;
                            i3 = i;
                            break;
                    }
                } else {
                    if (iA == Integer.MAX_VALUE) {
                        while (i3 < i2) {
                            objM = m(obj, iArr[i3], objM, c0373ak2);
                            i3++;
                        }
                        if (objM != null) {
                            c0373ak2.getClass();
                            C0373ak2.c(obj, objM);
                            return;
                        }
                        return;
                    }
                    c0373ak2.getClass();
                    if (objM == null) {
                        AbstractC0003Al0 abstractC0003Al02 = (AbstractC0003Al0) obj;
                        Zj2 zj2B2 = abstractC0003Al02.b;
                        if (zj2B2 == zj22) {
                            zj2B2 = Zj2.b();
                            abstractC0003Al02.b = zj2B2;
                        }
                        objM = zj2B2;
                    }
                    if (!C0373ak2.a(objM, zGVar)) {
                        while (i3 < i2) {
                            objM = m(obj, iArr[i3], objM, c0373ak2);
                            i3++;
                        }
                        if (objM != null) {
                            C0373ak2.c(obj, objM);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i = i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        r10.put(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r0.h(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(java.lang.Object r9, int r10, java.lang.Object r11, defpackage.C1191o90 r12, defpackage.zG r13) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r8 = this;
            int r10 = r8.T(r10)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r0
            long r0 = (long) r10
            uk2 r10 = defpackage.AbstractC1633vk2.b
            java.lang.Object r10 = r10.k(r0, r9)
            AL0 r2 = r8.n
            if (r10 != 0) goto L20
            r2.getClass()
            yL0 r10 = defpackage.C1778yL0.u
            yL0 r10 = r10.c()
            defpackage.AbstractC1633vk2.u(r0, r9, r10)
            goto L36
        L20:
            r2.getClass()
            boolean r3 = defpackage.AL0.d(r10)
            if (r3 == 0) goto L36
            yL0 r3 = defpackage.C1778yL0.u
            yL0 r3 = r3.c()
            defpackage.AL0.e(r3, r10)
            defpackage.AbstractC1633vk2.u(r0, r9, r3)
            r10 = r3
        L36:
            r2.getClass()
            yL0 r10 = (defpackage.C1778yL0) r10
            xL0 r11 = (defpackage.C1725xL0) r11
            wL0 r9 = r11.a
            r11 = 2
            r13.P(r11)
            yG r0 = r13.a
            int r1 = r0.z()
            int r1 = r0.i(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r9.c
            r4 = r3
        L55:
            int r5 = r13.a()     // Catch: java.lang.Throwable -> L79
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L9b
            boolean r6 = r0.e()     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L65
            goto L9b
        L65:
            r6 = 1
            java.lang.String r7 = "Unable to parse map entry."
            if (r5 == r6) goto L86
            if (r5 == r11) goto L7b
            boolean r5 = r13.Q()     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            if (r5 == 0) goto L73
            goto L55
        L73:
            com.google.protobuf.InvalidProtocolBufferException r5 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            throw r5     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
        L79:
            r9 = move-exception
            goto La2
        L7b:
            pw2 r5 = r9.b     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            java.lang.Class r6 = r3.getClass()     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            java.lang.Object r4 = r13.k(r5, r6, r12)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            goto L55
        L86:
            rw2 r5 = r9.a     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            r6 = 0
            java.lang.Object r2 = r13.k(r5, r6, r6)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L8e
            goto L55
        L8e:
            boolean r5 = r13.Q()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L95
            goto L55
        L95:
            com.google.protobuf.InvalidProtocolBufferException r9 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L79
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L79
        L9b:
            r10.put(r2, r4)     // Catch: java.lang.Throwable -> L79
            r0.h(r1)
            return
        La2:
            r0.h(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MS0.x(java.lang.Object, int, java.lang.Object, o90, zG):void");
    }

    public final void y(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02, int i) {
        long jT = T(i) & 1048575;
        if (t(i, abstractC0003Al02)) {
            AbstractC1577uk2 abstractC1577uk2 = AbstractC1633vk2.b;
            Object objK = abstractC1577uk2.k(jT, abstractC0003Al0);
            Object objK2 = abstractC1577uk2.k(jT, abstractC0003Al02);
            if (objK != null && objK2 != null) {
                AbstractC1633vk2.u(jT, abstractC0003Al0, gz0.c(objK, objK2));
                P(i, abstractC0003Al0);
            } else if (objK2 != null) {
                AbstractC1633vk2.u(jT, abstractC0003Al0, objK2);
                P(i, abstractC0003Al0);
            }
        }
    }

    public final void z(AbstractC0003Al0 abstractC0003Al0, AbstractC0003Al0 abstractC0003Al02, int i) {
        int iT = T(i);
        int i2 = this.a[i];
        long j = iT & 1048575;
        if (u(i2, i, abstractC0003Al02)) {
            Object objK = u(i2, i, abstractC0003Al0) ? AbstractC1633vk2.b.k(j, abstractC0003Al0) : null;
            Object objK2 = AbstractC1633vk2.b.k(j, abstractC0003Al02);
            if (objK != null && objK2 != null) {
                AbstractC1633vk2.u(j, abstractC0003Al0, gz0.c(objK, objK2));
                Q(i2, i, abstractC0003Al0);
            } else if (objK2 != null) {
                AbstractC1633vk2.u(j, abstractC0003Al0, objK2);
                Q(i2, i, abstractC0003Al0);
            }
        }
    }
}
