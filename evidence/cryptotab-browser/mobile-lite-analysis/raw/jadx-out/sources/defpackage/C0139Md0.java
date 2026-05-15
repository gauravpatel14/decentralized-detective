package defpackage;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: Md0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0139Md0 {
    public static final /* synthetic */ int c = 0;
    public final iL1 a = new iL1(16);
    public boolean b;

    static {
        new C0139Md0(0);
    }

    public C0139Md0() {
    }

    public static void b(CG cg, EnumC1415rw2 enumC1415rw2, int i, Object obj) {
        if (enumC1415rw2 == EnumC1415rw2.v) {
            cg.O(i, 3);
            ((AbstractC0003Al0) ((InterfaceC1787yS0) obj)).p(cg);
            cg.O(i, 4);
            return;
        }
        cg.O(i, enumC1415rw2.u);
        switch (enumC1415rw2.ordinal()) {
            case 0:
                cg.H(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                cg.F(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                cg.S(((Long) obj).longValue());
                break;
            case 3:
                cg.S(((Long) obj).longValue());
                break;
            case 4:
                cg.J(((Integer) obj).intValue());
                break;
            case 5:
                cg.H(((Long) obj).longValue());
                break;
            case 6:
                cg.F(((Integer) obj).intValue());
                break;
            case 7:
                cg.z(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof C0199Qv)) {
                    cg.N((String) obj);
                } else {
                    cg.D((C0199Qv) obj);
                }
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                ((AbstractC0003Al0) ((InterfaceC1787yS0) obj)).p(cg);
                break;
            case 10:
                cg.L((InterfaceC1787yS0) obj);
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                if (!(obj instanceof C0199Qv)) {
                    byte[] bArr = (byte[]) obj;
                    cg.B(bArr.length, bArr);
                } else {
                    cg.D((C0199Qv) obj);
                }
                break;
            case 12:
                cg.Q(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof cz0)) {
                    cg.J(((Integer) obj).intValue());
                } else {
                    cg.J(((cz0) obj).a());
                }
                break;
            case 14:
                cg.F(((Integer) obj).intValue());
                break;
            case 15:
                cg.H(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                cg.Q((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                cg.S((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        iL1 il1 = this.a;
        if (!il1.w) {
            if (il1.u.size() > 0) {
                il1.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = il1.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!il1.w) {
            il1.v = il1.v.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(il1.v);
            il1.y = il1.y.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(il1.y);
            il1.w = true;
        }
        this.b = true;
    }

    public final Object clone() {
        C0139Md0 c0139Md0 = new C0139Md0();
        iL1 il1 = this.a;
        if (il1.u.size() > 0) {
            Map.Entry entryC = il1.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = il1.d().iterator();
        if (!it.hasNext()) {
            return c0139Md0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0139Md0) {
            return this.a.equals(((C0139Md0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public C0139Md0(int i) {
        a();
        a();
    }
}
