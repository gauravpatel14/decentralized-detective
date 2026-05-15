package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DS2 {
    public static double a(double d) {
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || d == 0.0d) {
            return d;
        }
        return Math.floor(Math.abs(d)) * ((double) (d > 0.0d ? 1 : -1));
    }

    public static int b(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        return (int) ((Math.floor(Math.abs(d)) * ((double) (d > 0.0d ? 1 : -1))) % 4.294967296E9d);
    }

    public static void c(IQ2 iq2) {
        int iB = b(iq2.d("runtime.counter").b().doubleValue() + 1.0d);
        if (iB > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        iq2.f("runtime.counter", new C1369rD2(Double.valueOf(iB)));
    }

    public static VG2 d(String str) {
        VG2 vg2 = null;
        if (str != null && !str.isEmpty()) {
            vg2 = (VG2) VG2.E0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (vg2 != null) {
            return vg2;
        }
        throw new IllegalArgumentException(Xd0.a("Unsupported commandId ", str));
    }

    public static Object e(InterfaceC1601vE2 interfaceC1601vE2) {
        if (InterfaceC1601vE2.m.equals(interfaceC1601vE2)) {
            return null;
        }
        if (InterfaceC1601vE2.l.equals(interfaceC1601vE2)) {
            return "";
        }
        if (interfaceC1601vE2 instanceof C0394bE2) {
            return f((C0394bE2) interfaceC1601vE2);
        }
        if (!(interfaceC1601vE2 instanceof PC2)) {
            return !interfaceC1601vE2.b().isNaN() ? interfaceC1601vE2.b() : interfaceC1601vE2.zzi();
        }
        ArrayList arrayList = new ArrayList();
        PC2 pc2 = (PC2) interfaceC1601vE2;
        pc2.getClass();
        int i = 0;
        while (i < pc2.j()) {
            if (i >= pc2.j()) {
                throw new NoSuchElementException(AbstractC1214oR1.a(i, "Out of bounds index: "));
            }
            int i2 = i + 1;
            Object objE = e(pc2.k(i));
            if (objE != null) {
                arrayList.add(objE);
            }
            i = i2;
        }
        return arrayList;
    }

    public static HashMap f(C0394bE2 c0394bE2) {
        HashMap map = new HashMap();
        c0394bE2.getClass();
        for (String str : new ArrayList(c0394bE2.t.keySet())) {
            Object objE = e(c0394bE2.g(str));
            if (objE != null) {
                map.put(str, objE);
            }
        }
        return map;
    }

    public static void g(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + list.size());
    }

    public static void h(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + list.size());
    }

    public static void i(int i, String str, ArrayList arrayList) {
        if (arrayList.size() <= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + arrayList.size());
    }

    public static boolean j(InterfaceC1601vE2 interfaceC1601vE2) {
        if (interfaceC1601vE2 == null) {
            return false;
        }
        Double dB = interfaceC1601vE2.b();
        return !dB.isNaN() && dB.doubleValue() >= 0.0d && dB.equals(Double.valueOf(Math.floor(dB.doubleValue())));
    }

    public static boolean k(InterfaceC1601vE2 interfaceC1601vE2, InterfaceC1601vE2 interfaceC1601vE22) {
        if (!interfaceC1601vE2.getClass().equals(interfaceC1601vE22.getClass())) {
            return false;
        }
        if ((interfaceC1601vE2 instanceof UE2) || (interfaceC1601vE2 instanceof C0691gE2)) {
            return true;
        }
        if (!(interfaceC1601vE2 instanceof C1369rD2)) {
            return interfaceC1601vE2 instanceof OE2 ? interfaceC1601vE2.zzi().equals(interfaceC1601vE22.zzi()) : interfaceC1601vE2 instanceof ZC2 ? interfaceC1601vE2.zzg().equals(interfaceC1601vE22.zzg()) : interfaceC1601vE2 == interfaceC1601vE22;
        }
        if (Double.isNaN(interfaceC1601vE2.b().doubleValue()) || Double.isNaN(interfaceC1601vE22.b().doubleValue())) {
            return false;
        }
        return interfaceC1601vE2.b().equals(interfaceC1601vE22.b());
    }
}
