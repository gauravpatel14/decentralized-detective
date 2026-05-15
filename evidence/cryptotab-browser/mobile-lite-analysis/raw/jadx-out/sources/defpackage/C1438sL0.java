package defpackage;

import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: sL0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1438sL0 implements Map, Serializable, CB0 {
    public static final C1438sL0 G;
    public int A;
    public int B;
    public C1552uL0 C;
    public C1607vL0 D;
    public C1497tL0 E;
    public boolean F;
    public Object[] t;
    public Object[] u;
    public int[] v;
    public int[] w;
    public int x;
    public int y;
    public int z;

    static {
        C1438sL0 c1438sL0 = new C1438sL0(0);
        c1438sL0.F = true;
        G = c1438sL0;
    }

    public C1438sL0() {
        this(8);
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int iJ = j(obj);
            int i = this.x * 2;
            int length = this.w.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.w;
                int i3 = iArr[iJ];
                if (i3 <= 0) {
                    int i4 = this.y;
                    Object[] objArr = this.t;
                    if (i4 < objArr.length) {
                        int i5 = i4 + 1;
                        this.y = i5;
                        objArr[i4] = obj;
                        this.v[i4] = iJ;
                        iArr[iJ] = i5;
                        this.B++;
                        this.A++;
                        if (i2 > this.x) {
                            this.x = i2;
                        }
                        return i4;
                    }
                    f(1);
                } else {
                    if (lz0.a(this.t[i3 - 1], obj)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > i) {
                        l(this.w.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.w.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final void b() {
        if (this.F) {
            throw new UnsupportedOperationException();
        }
    }

    public final void c(boolean z) {
        int i;
        Object[] objArr = this.u;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.y;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.v;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.t;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.w[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        AbstractC0517dG0.c(this.t, i3, i);
        if (objArr != null) {
            AbstractC0517dG0.c(objArr, i3, this.y);
        }
        this.y = i3;
    }

    @Override // java.util.Map
    public final void clear() {
        b();
        int i = this.y - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.v;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.w[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        AbstractC0517dG0.c(this.t, 0, this.y);
        Object[] objArr = this.u;
        if (objArr != null) {
            AbstractC0517dG0.c(objArr, 0, this.y);
        }
        this.B = 0;
        this.y = 0;
        this.A++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return i(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        int i;
        int i2 = this.y;
        while (true) {
            i = -1;
            i2--;
            if (i2 >= 0) {
                if (this.v[i2] >= 0 && lz0.a(this.u[i2], obj)) {
                    i = i2;
                    break;
                }
            } else {
                break;
            }
        }
        return i >= 0;
    }

    public final boolean d(Collection collection) {
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int i = i(entry.getKey());
                    if (!(i < 0 ? false : lz0.a(this.u[i], entry.getValue()))) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        C1497tL0 c1497tL0 = this.E;
        if (c1497tL0 != null) {
            return c1497tL0;
        }
        C1497tL0 c1497tL02 = new C1497tL0(this);
        this.E = c1497tL02;
        return c1497tL02;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.B != map.size() || !d(map.entrySet())) {
                }
            }
            return false;
        }
        return true;
    }

    public final void f(int i) {
        Object[] objArr = this.t;
        int length = objArr.length;
        int i2 = this.y;
        int i3 = length - i2;
        int i4 = i2 - this.B;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            c(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 2147483639;
            }
            this.t = Arrays.copyOf(objArr, i6);
            Object[] objArr2 = this.u;
            this.u = objArr2 != null ? Arrays.copyOf(objArr2, i6) : null;
            this.v = Arrays.copyOf(this.v, i6);
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.w.length) {
                l(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int i = i(obj);
        if (i < 0) {
            return null;
        }
        return this.u[i];
    }

    @Override // java.util.Map
    public final int hashCode() {
        C1322qL0 c1322qL0 = new C1322qL0(this, 0);
        int i = 0;
        while (c1322qL0.hasNext()) {
            int i2 = c1322qL0.u;
            C1438sL0 c1438sL0 = c1322qL0.t;
            if (i2 >= c1438sL0.y) {
                throw new NoSuchElementException();
            }
            c1322qL0.u = i2 + 1;
            c1322qL0.v = i2;
            Object obj = c1438sL0.t[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object obj2 = c1438sL0.u[c1322qL0.v];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            c1322qL0.b();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        int iJ = j(obj);
        int i = this.x;
        while (true) {
            int i2 = this.w[iJ];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (lz0.a(this.t[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.w.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.B == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.z;
    }

    @Override // java.util.Map
    public final Set keySet() {
        C1552uL0 c1552uL0 = this.C;
        if (c1552uL0 != null) {
            return c1552uL0;
        }
        C1552uL0 c1552uL02 = new C1552uL0(this);
        this.C = c1552uL02;
        return c1552uL02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.v[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
            int r0 = r5.A
            int r0 = r0 + 1
            r5.A = r0
            int r0 = r5.y
            int r1 = r5.B
            r2 = 0
            if (r0 <= r1) goto L10
            r5.c(r2)
        L10:
            int[] r0 = new int[r6]
            r5.w = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.z = r6
        L1c:
            int r6 = r5.y
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.t
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.x
        L2c:
            int[] r3 = r5.w
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.v
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1438sL0.l(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x001f->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.t
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.u
            if (r0 == 0) goto Lb
            r0[r12] = r1
        Lb:
            int[] r0 = r11.v
            r0 = r0[r12]
            int r1 = r11.x
            int r1 = r1 * 2
            int[] r2 = r11.w
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1b
            r1 = r2
        L1b:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1f:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L29
            int[] r0 = r11.w
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2a
        L29:
            r0 = r5
        L2a:
            int r4 = r4 + 1
            int r5 = r11.x
            r6 = -1
            if (r4 <= r5) goto L36
            int[] r0 = r11.w
            r0[r1] = r2
            goto L67
        L36:
            int[] r5 = r11.w
            r7 = r5[r0]
            if (r7 != 0) goto L3f
            r5[r1] = r2
            goto L67
        L3f:
            if (r7 >= 0) goto L46
            r5[r1] = r6
        L43:
            r1 = r0
            r4 = r2
            goto L60
        L46:
            java.lang.Object[] r5 = r11.t
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.w
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L60
            r9[r1] = r7
            int[] r4 = r11.v
            r4[r8] = r1
            goto L43
        L60:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1f
            int[] r0 = r11.w
            r0[r1] = r6
        L67:
            int[] r0 = r11.v
            r0[r12] = r6
            int r12 = r11.B
            int r12 = r12 + r6
            r11.B = r12
            int r12 = r11.A
            int r12 = r12 + 1
            r11.A = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1438sL0.p(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.u;
        if (objArr == null) {
            int length = this.t.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.u = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.u;
            if (objArr == null) {
                int length = this.t.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.u = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!lz0.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int i = i(obj);
        if (i < 0) {
            return null;
        }
        Object obj2 = this.u[i];
        p(i);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.B;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.B * 3) + 2);
        sb.append("{");
        C1322qL0 c1322qL0 = new C1322qL0(this, 0);
        int i = 0;
        while (c1322qL0.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = c1322qL0.u;
            C1438sL0 c1438sL0 = c1322qL0.t;
            if (i2 >= c1438sL0.y) {
                throw new NoSuchElementException();
            }
            c1322qL0.u = i2 + 1;
            c1322qL0.v = i2;
            Object obj = c1438sL0.t[i2];
            if (obj == c1438sL0) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object obj2 = c1438sL0.u[c1322qL0.v];
            if (obj2 == c1438sL0) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            c1322qL0.b();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        C1607vL0 c1607vL0 = this.D;
        if (c1607vL0 != null) {
            return c1607vL0;
        }
        C1607vL0 c1607vL02 = new C1607vL0(this);
        this.D = c1607vL02;
        return c1607vL02;
    }

    public C1438sL0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.t = objArr;
        this.u = null;
        this.v = iArr;
        this.w = new int[iHighestOneBit];
        this.x = 2;
        this.y = 0;
        this.z = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
