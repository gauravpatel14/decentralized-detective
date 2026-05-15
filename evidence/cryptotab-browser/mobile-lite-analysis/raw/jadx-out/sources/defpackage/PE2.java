package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PE2 implements Map, Serializable {
    public static final PE2 z = new PE2(null, new Object[0], 0);
    public transient C1770yE2 t;
    public transient CE2 u;
    public transient JE2 v;
    public final transient Object w;
    public final transient Object[] x;
    public final transient int y;

    public PE2(Object obj, Object[] objArr, int i) {
        this.w = obj;
        this.x = objArr;
        this.y = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static PE2 a(int i, Object[] objArr, ND2 nd2) {
        int iHighestOneBit;
        short[] sArr;
        char c;
        char c2;
        ?? r4;
        ?? r42;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return z;
        }
        int i3 = 1;
        HD2 hd2 = null;
        ?? r43 = 0;
        HD2 hd22 = null;
        HD2 hd23 = null;
        if (i2 == 1) {
            Objects.requireNonNull(objArrCopyOf[0]);
            Objects.requireNonNull(objArrCopyOf[1]);
            return new PE2(null, objArrCopyOf, 1);
        }
        YB2.b(i2, objArrCopyOf.length >> 1);
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Objects.requireNonNull(objArrCopyOf[0]);
            Objects.requireNonNull(objArrCopyOf[1]);
            i2 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i4 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object obj = objArrCopyOf[i8];
                    Objects.requireNonNull(obj);
                    Object obj2 = objArrCopyOf[i8 ^ i3];
                    Objects.requireNonNull(obj2);
                    int iA = QC2.a(obj.hashCode());
                    while (true) {
                        int i9 = iA & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 == 255) {
                            bArr[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = obj;
                                objArrCopyOf[i7 ^ 1] = obj2;
                            }
                            i6++;
                        } else {
                            if (obj.equals(objArrCopyOf[i10 == true ? 1 : 0])) {
                                int i11 = ~i10;
                                Object obj3 = objArrCopyOf[i11 == true ? 1 : 0];
                                Objects.requireNonNull(obj3);
                                hd22 = new HD2(obj, obj2, obj3);
                                objArrCopyOf[i11 == true ? 1 : 0] = obj2;
                                break;
                            }
                            iA = i9 + 1;
                        }
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    r4 = bArr;
                } else {
                    r42 = new Object[]{bArr, Integer.valueOf(i6), hd22};
                    c2 = 2;
                    c = 1;
                    r43 = r42;
                }
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i12 = 0;
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = i12 + i12;
                    int i15 = i13 + i13;
                    Object obj4 = objArrCopyOf[i15];
                    Objects.requireNonNull(obj4);
                    Object obj5 = objArrCopyOf[i15 ^ 1];
                    Objects.requireNonNull(obj5);
                    int iA2 = QC2.a(obj4.hashCode());
                    while (true) {
                        int i16 = iA2 & i4;
                        char c3 = (char) sArr[i16];
                        if (c3 == 65535) {
                            sArr[i16] = (short) i14;
                            if (i12 < i13) {
                                objArrCopyOf[i14] = obj4;
                                objArrCopyOf[i14 ^ 1] = obj5;
                            }
                            i12++;
                        } else {
                            if (obj4.equals(objArrCopyOf[c3])) {
                                int i17 = c3 ^ 1;
                                Object obj6 = objArrCopyOf[i17 == true ? 1 : 0];
                                Objects.requireNonNull(obj6);
                                HD2 hd24 = new HD2(obj4, obj5, obj6);
                                objArrCopyOf[i17 == true ? 1 : 0] = obj5;
                                hd23 = hd24;
                                break;
                            }
                            iA2 = i16 + 1;
                        }
                    }
                }
                if (i12 != i2) {
                    c2 = 2;
                    r43 = new Object[]{sArr, Integer.valueOf(i12), hd23};
                    c = 1;
                }
                r4 = sArr;
            } else {
                int i18 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i19 = 0;
                int i20 = 0;
                while (i19 < i2) {
                    int i21 = i20 + i20;
                    int i22 = i19 + i19;
                    Object obj7 = objArrCopyOf[i22];
                    Objects.requireNonNull(obj7);
                    Object obj8 = objArrCopyOf[i22 ^ i18];
                    Objects.requireNonNull(obj8);
                    int iA3 = QC2.a(obj7.hashCode());
                    while (true) {
                        int i23 = iA3 & i4;
                        ?? r15 = sArr[i23];
                        if (r15 == b) {
                            sArr[i23] = i21;
                            if (i20 < i19) {
                                objArrCopyOf[i21] = obj7;
                                objArrCopyOf[i21 ^ 1] = obj8;
                            }
                            i20++;
                        } else {
                            if (obj7.equals(objArrCopyOf[r15])) {
                                int i24 = r15 ^ 1;
                                Object obj9 = objArrCopyOf[i24 == true ? 1 : 0];
                                Objects.requireNonNull(obj9);
                                HD2 hd25 = new HD2(obj7, obj8, obj9);
                                objArrCopyOf[i24 == true ? 1 : 0] = obj8;
                                hd2 = hd25;
                                break;
                            }
                            iA3 = i23 + 1;
                            b = -1;
                        }
                    }
                    i19++;
                    b = -1;
                    i18 = 1;
                }
                if (i20 != i2) {
                    c = 1;
                    c2 = 2;
                    r43 = new Object[]{sArr, Integer.valueOf(i20), hd2};
                }
                r4 = sArr;
            }
            c2 = 2;
            r42 = r4;
            c = 1;
            r43 = r42;
        }
        boolean z2 = r43 instanceof Object[];
        ?? r44 = r43;
        if (z2) {
            Object[] objArr2 = (Object[]) r43;
            HD2 hd26 = (HD2) objArr2[c2];
            if (nd2 == null) {
                throw hd26.a();
            }
            nd2.c = hd26;
            Object obj10 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r44 = obj10;
            i2 = iIntValue;
        }
        return new PE2(r44, objArrCopyOf, i2);
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        JE2 je2 = this.v;
        if (je2 == null) {
            je2 = new JE2(this.x, 1, this.y);
            this.v = je2;
        }
        return je2.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        C1770yE2 c1770yE2 = this.t;
        if (c1770yE2 != null) {
            return c1770yE2;
        }
        C1770yE2 c1770yE22 = new C1770yE2(this, this.x, this.y);
        this.t = c1770yE22;
        return c1770yE22;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L6
        L3:
            r10 = r0
            goto L9c
        L6:
            r1 = 1
            int r2 = r9.y
            java.lang.Object[] r3 = r9.x
            if (r2 != r1) goto L20
            r2 = 0
            r2 = r3[r2]
            java.util.Objects.requireNonNull(r2)
            boolean r10 = r2.equals(r10)
            if (r10 == 0) goto L3
            r10 = r3[r1]
            java.util.Objects.requireNonNull(r10)
            goto L9c
        L20:
            java.lang.Object r2 = r9.w
            if (r2 != 0) goto L25
            goto L3
        L25:
            boolean r4 = r2 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L51
            r4 = r2
            byte[] r4 = (byte[]) r4
            int r2 = r4.length
            int r6 = r2 + (-1)
            int r2 = r10.hashCode()
            int r2 = defpackage.QC2.a(r2)
        L38:
            r2 = r2 & r6
            r5 = r4[r2]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L41
            goto L3
        L41:
            r7 = r3[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L4e
            r10 = r5 ^ 1
            r10 = r3[r10]
            goto L9c
        L4e:
            int r2 = r2 + 1
            goto L38
        L51:
            boolean r4 = r2 instanceof short[]
            if (r4 == 0) goto L7d
            r4 = r2
            short[] r4 = (short[]) r4
            int r2 = r4.length
            int r6 = r2 + (-1)
            int r2 = r10.hashCode()
            int r2 = defpackage.QC2.a(r2)
        L63:
            r2 = r2 & r6
            short r5 = r4[r2]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L6d
            goto L3
        L6d:
            r7 = r3[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L7a
            r10 = r5 ^ 1
            r10 = r3[r10]
            goto L9c
        L7a:
            int r2 = r2 + 1
            goto L63
        L7d:
            int[] r2 = (int[]) r2
            int r4 = r2.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = defpackage.QC2.a(r6)
        L89:
            r6 = r6 & r4
            r7 = r2[r6]
            if (r7 != r5) goto L90
            goto L3
        L90:
            r8 = r3[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto La0
            r10 = r7 ^ 1
            r10 = r3[r10]
        L9c:
            if (r10 != 0) goto L9f
            return r0
        L9f:
            return r10
        La0:
            int r6 = r6 + 1
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.PE2.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        C1770yE2 c1770yE2 = this.t;
        if (c1770yE2 == null) {
            c1770yE2 = new C1770yE2(this, this.x, this.y);
            this.t = c1770yE2;
        }
        Iterator it = c1770yE2.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        CE2 ce2 = this.u;
        if (ce2 != null) {
            return ce2;
        }
        CE2 ce22 = new CE2(this, new JE2(this.x, 0, this.y));
        this.u = ce22;
        return ce22;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.y;
    }

    public final String toString() {
        int i = this.y;
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC1214oR1.a(i, "size cannot be negative but was: "));
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry entry : (C1770yE2) entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z2 = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        JE2 je2 = this.v;
        if (je2 != null) {
            return je2;
        }
        JE2 je22 = new JE2(this.x, 1, this.y);
        this.v = je22;
        return je22;
    }
}
