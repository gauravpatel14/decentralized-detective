package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VX2 extends AbstractC0906jX2 {
    public static boolean A(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static final void C(ZP2 zp2, String str, Long l) {
        List listUnmodifiableList = Collections.unmodifiableList(((C0471cQ2) zp2.u).r());
        int i = 0;
        while (true) {
            if (i >= listUnmodifiableList.size()) {
                i = -1;
                break;
            } else if (str.equals(((C1149nQ2) listUnmodifiableList.get(i)).q())) {
                break;
            } else {
                i++;
            }
        }
        C0960kQ2 c0960kQ2P = C1149nQ2.p();
        c0960kQ2P.h(str);
        if (l != null) {
            c0960kQ2P.g(l.longValue());
        }
        if (i < 0) {
            zp2.i(c0960kQ2P);
            return;
        }
        if (zp2.v) {
            zp2.f();
            zp2.v = false;
        }
        C0471cQ2.s((C0471cQ2) zp2.u, i, (C1149nQ2) c0960kQ2P.d());
    }

    public static final C1149nQ2 k(String str, C0471cQ2 c0471cQ2) {
        for (C1149nQ2 c1149nQ2 : c0471cQ2.r()) {
            if (c1149nQ2.q().equals(str)) {
                return c1149nQ2;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r6v9, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable l(String str, C0471cQ2 c0471cQ2) {
        C1149nQ2 c1149nQ2K = k(str, c0471cQ2);
        if (c1149nQ2K == null) {
            return null;
        }
        if (c1149nQ2K.G()) {
            return c1149nQ2K.r();
        }
        if (c1149nQ2K.F()) {
            return Long.valueOf(c1149nQ2K.o());
        }
        if (c1149nQ2K.D()) {
            return Double.valueOf(c1149nQ2K.l());
        }
        if (c1149nQ2K.n() <= 0) {
            return null;
        }
        LW2<C1149nQ2> lw2S = c1149nQ2K.s();
        ArrayList arrayList = new ArrayList();
        for (C1149nQ2 c1149nQ2 : lw2S) {
            if (c1149nQ2 != null) {
                Bundle bundle = new Bundle();
                for (C1149nQ2 c1149nQ22 : c1149nQ2.s()) {
                    if (c1149nQ22.G()) {
                        bundle.putString(c1149nQ22.q(), c1149nQ22.r());
                    } else if (c1149nQ22.F()) {
                        bundle.putLong(c1149nQ22.q(), c1149nQ22.o());
                    } else if (c1149nQ22.D()) {
                        bundle.putDouble(c1149nQ22.q(), c1149nQ22.l());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int m(RQ2 rq2, String str) {
        for (int i = 0; i < ((VQ2) rq2.u).B0(); i++) {
            if (str.equals(((VQ2) rq2.u).G0(i).p())) {
                return i;
            }
        }
        return -1;
    }

    public static AbstractC0360aW2 s(AbstractC0360aW2 abstractC0360aW2, byte[] bArr) throws zzkm {
        KV2 kv2A;
        KV2 kv2 = KV2.b;
        if (kv2 == null) {
            synchronized (KV2.class) {
                try {
                    kv2A = KV2.b;
                    if (kv2A == null) {
                        kv2A = WV2.a();
                        KV2.b = kv2A;
                    }
                } finally {
                }
            }
            kv2 = kv2A;
        }
        if (kv2 != null) {
            abstractC0360aW2.getClass();
            abstractC0360aW2.c(bArr, bArr.length, kv2);
            return abstractC0360aW2;
        }
        abstractC0360aW2.getClass();
        int length = bArr.length;
        KV2 kv22 = KV2.a;
        if (kv22 == null) {
            synchronized (KV2.class) {
                try {
                    kv22 = KV2.a;
                    if (kv22 == null) {
                        kv22 = KV2.c;
                        KV2.a = kv22;
                    }
                } finally {
                }
            }
        }
        abstractC0360aW2.c(bArr, length, kv22);
        return abstractC0360aW2;
    }

    public static ArrayList u(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static boolean y(JW2 jw2, int i) {
        if (i < jw2.size() * 64) {
            return ((1 << (i % 64)) & ((Long) jw2.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public final byte[] B(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.f.b(e, "Failed to gzip content");
            throw e;
        }
    }

    public final long n(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        C1391rR2 c1391rR2 = this.a;
        C0653fY2 c0653fY2 = c1391rR2.l;
        C1391rR2.i(c0653fY2);
        c0653fY2.g();
        MessageDigest messageDigestN = C0653fY2.n();
        if (messageDigestN != null) {
            return C0653fY2.e0(messageDigestN.digest(bArr));
        }
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        wo2.f.a("Failed to get MD5");
        return 0L;
    }

    public final Bundle o(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ((K03) J03.u.t.zza()).getClass();
                if (this.a.g.p(null, AbstractC0579eO2.i0)) {
                    ArrayList arrayList = (ArrayList) obj;
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(o((Map) arrayList.get(i), false));
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
                } else {
                    ArrayList arrayList3 = (ArrayList) obj;
                    ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        arrayList4.add(o((Map) arrayList3.get(i2), false));
                    }
                    bundle.putParcelableArrayList(str, arrayList4);
                }
            }
        }
        return bundle;
    }

    public final Parcelable p(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.f.a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final zzaw q(XB2 xb2) {
        Object obj;
        Bundle bundleO = o(xb2.c, true);
        String string = (!bundleO.containsKey("_o") || (obj = bundleO.get("_o")) == null) ? "app" : obj.toString();
        String strA = RU2.a(xb2.a, AbstractC0355aT2.a, AbstractC0355aT2.c);
        if (strA == null) {
            strA = xb2.a;
        }
        return new zzaw(strA, new zzau(bundleO), string, xb2.b);
    }

    public final C0471cQ2 r(EE2 ee2) {
        ZP2 zp2O = C0471cQ2.o();
        if (zp2O.v) {
            zp2O.f();
            zp2O.v = false;
        }
        C0471cQ2.z(ee2.e, (C0471cQ2) zp2O.u);
        zzau zzauVar = ee2.f;
        for (String str : zzauVar.t.keySet()) {
            C0960kQ2 c0960kQ2P = C1149nQ2.p();
            c0960kQ2P.h(str);
            Object obj = zzauVar.t.get(str);
            Preconditions.checkNotNull(obj);
            w(c0960kQ2P, obj);
            zp2O.i(c0960kQ2P);
        }
        return (C0471cQ2) zp2O.d();
    }

    public final List t(JW2 jw2, List list) {
        int i;
        ArrayList arrayList = new ArrayList(jw2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            C1391rR2 c1391rR2 = this.a;
            if (iIntValue < 0) {
                WO2 wo2 = c1391rR2.i;
                C1391rR2.k(wo2);
                wo2.i.b(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue2 = num.intValue() / 64;
                if (iIntValue2 >= arrayList.size()) {
                    WO2 wo22 = c1391rR2.i;
                    C1391rR2.k(wo22);
                    wo22.i.c(num, Integer.valueOf(arrayList.size()), "Ignoring bit index greater than bitSet size");
                } else {
                    arrayList.set(iIntValue2, Long.valueOf(((Long) arrayList.get(iIntValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.HashMap v(android.os.Bundle r11, boolean r12) {
        /*
            r10 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lae
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r11.get(r2)
            J03 r4 = defpackage.J03.u
            rU2 r4 = r4.t
            java.lang.Object r4 = r4.zza()
            K03 r4 = (defpackage.K03) r4
            r4.getClass()
            rR2 r4 = r10.a
            lD2 r4 = r4.g
            r5 = 0
            cO2 r6 = defpackage.AbstractC0579eO2.i0
            boolean r4 = r4.p(r5, r6)
            if (r4 == 0) goto L44
            boolean r4 = r3 instanceof android.os.Parcelable[]
            if (r4 != 0) goto L57
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 != 0) goto L57
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L51
            goto L57
        L44:
            boolean r4 = r3 instanceof android.os.Bundle[]
            if (r4 != 0) goto L57
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 != 0) goto L57
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L51
            goto L57
        L51:
            if (r3 == 0) goto Ld
            r0.put(r2, r3)
            goto Ld
        L57:
            if (r12 == 0) goto Ld
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r3 instanceof android.os.Parcelable[]
            r6 = 0
            if (r5 == 0) goto L7b
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            int r5 = r3.length
            r7 = r6
        L67:
            if (r7 >= r5) goto La9
            r8 = r3[r7]
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L78
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = r10.v(r8, r6)
            r4.add(r8)
        L78:
            int r7 = r7 + 1
            goto L67
        L7b:
            boolean r5 = r3 instanceof java.util.ArrayList
            if (r5 == 0) goto L9c
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r5 = r3.size()
            r7 = r6
        L86:
            if (r7 >= r5) goto La9
            java.lang.Object r8 = r3.get(r7)
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L99
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = r10.v(r8, r6)
            r4.add(r8)
        L99:
            int r7 = r7 + 1
            goto L86
        L9c:
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto La9
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.util.HashMap r3 = r10.v(r3, r6)
            r4.add(r3)
        La9:
            r0.put(r2, r4)
            goto Ld
        Lae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.VX2.v(android.os.Bundle, boolean):java.util.HashMap");
    }

    public final void w(C0960kQ2 c0960kQ2, Object obj) {
        Preconditions.checkNotNull(obj);
        if (c0960kQ2.v) {
            c0960kQ2.f();
            c0960kQ2.v = false;
        }
        C1149nQ2.v((C1149nQ2) c0960kQ2.u);
        if (c0960kQ2.v) {
            c0960kQ2.f();
            c0960kQ2.v = false;
        }
        C1149nQ2.x((C1149nQ2) c0960kQ2.u);
        if (c0960kQ2.v) {
            c0960kQ2.f();
            c0960kQ2.v = false;
        }
        C1149nQ2.z((C1149nQ2) c0960kQ2.u);
        if (c0960kQ2.v) {
            c0960kQ2.f();
            c0960kQ2.v = false;
        }
        C1149nQ2.C((C1149nQ2) c0960kQ2.u);
        if (obj instanceof String) {
            c0960kQ2.i((String) obj);
            return;
        }
        if (obj instanceof Long) {
            c0960kQ2.g(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (c0960kQ2.v) {
                c0960kQ2.f();
                c0960kQ2.v = false;
            }
            C1149nQ2.y((C1149nQ2) c0960kQ2.u, dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.f.b(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                C0960kQ2 c0960kQ2P = C1149nQ2.p();
                for (String str : bundle.keySet()) {
                    C0960kQ2 c0960kQ2P2 = C1149nQ2.p();
                    c0960kQ2P2.h(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        c0960kQ2P2.g(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        c0960kQ2P2.i((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        if (c0960kQ2P2.v) {
                            c0960kQ2P2.f();
                            c0960kQ2P2.v = false;
                        }
                        C1149nQ2.y((C1149nQ2) c0960kQ2P2.u, dDoubleValue2);
                    }
                    if (c0960kQ2P.v) {
                        c0960kQ2P.f();
                        c0960kQ2P.v = false;
                    }
                    C1149nQ2.A((C1149nQ2) c0960kQ2P.u, (C1149nQ2) c0960kQ2P2.d());
                }
                if (((C1149nQ2) c0960kQ2P.u).n() > 0) {
                    arrayList.add((C1149nQ2) c0960kQ2P.d());
                }
            }
        }
        if (c0960kQ2.v) {
            c0960kQ2.f();
            c0960kQ2.v = false;
        }
        C1149nQ2.B((C1149nQ2) c0960kQ2.u, arrayList);
    }

    public final void x(C1448sR2 c1448sR2, Object obj) {
        Preconditions.checkNotNull(obj);
        if (c1448sR2.v) {
            c1448sR2.f();
            c1448sR2.v = false;
        }
        C1618vR2.u((C1618vR2) c1448sR2.u);
        if (c1448sR2.v) {
            c1448sR2.f();
            c1448sR2.v = false;
        }
        C1618vR2.w((C1618vR2) c1448sR2.u);
        if (c1448sR2.v) {
            c1448sR2.f();
            c1448sR2.v = false;
        }
        C1618vR2.y((C1618vR2) c1448sR2.u);
        if (obj instanceof String) {
            String str = (String) obj;
            if (c1448sR2.v) {
                c1448sR2.f();
                c1448sR2.v = false;
            }
            C1618vR2.t((C1618vR2) c1448sR2.u, str);
            return;
        }
        if (obj instanceof Long) {
            c1448sR2.g(((Long) obj).longValue());
            return;
        }
        if (!(obj instanceof Double)) {
            WO2 wo2 = this.a.i;
            C1391rR2.k(wo2);
            wo2.f.b(obj, "Ignoring invalid (type) user attribute value");
        } else {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (c1448sR2.v) {
                c1448sR2.f();
                c1448sR2.v = false;
            }
            C1618vR2.x((C1618vR2) c1448sR2.u, dDoubleValue);
        }
    }

    public final boolean z(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.a.n.currentTimeMillis() - j) > j2;
    }

    @Override // defpackage.AbstractC0906jX2
    public final void j() {
    }
}
