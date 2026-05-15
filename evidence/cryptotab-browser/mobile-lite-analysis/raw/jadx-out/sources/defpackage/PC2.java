package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PC2 implements Iterable, InterfaceC1601vE2, SD2 {
    public final TreeMap t;
    public final TreeMap u;

    public PC2() {
        this.t = new TreeMap();
        this.u = new TreeMap();
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        TreeMap treeMap = this.t;
        return treeMap.size() == 1 ? k(0).b() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // defpackage.SD2
    public final boolean e(String str) {
        return "length".equals(str) || this.u.containsKey(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PC2)) {
            return false;
        }
        PC2 pc2 = (PC2) obj;
        if (j() != pc2.j()) {
            return false;
        }
        TreeMap treeMap = this.t;
        if (treeMap.isEmpty()) {
            return pc2.t.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!k(iIntValue).equals(pc2.k(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return new C1599vC2(this.t.keySet().iterator(), this.u.keySet().iterator());
    }

    @Override // defpackage.SD2
    public final InterfaceC1601vE2 g(String str) {
        InterfaceC1601vE2 interfaceC1601vE2;
        return "length".equals(str) ? new C1369rD2(Double.valueOf(j())) : (!e(str) || (interfaceC1601vE2 = (InterfaceC1601vE2) this.u.get(str)) == null) ? InterfaceC1601vE2.l : interfaceC1601vE2;
    }

    @Override // defpackage.SD2
    public final void h(String str, InterfaceC1601vE2 interfaceC1601vE2) {
        TreeMap treeMap = this.u;
        if (interfaceC1601vE2 == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, interfaceC1601vE2);
        }
    }

    public final int hashCode() {
        return this.t.hashCode() * 31;
    }

    /* JADX WARN: Code restructure failed: missing block: B:357:0x0862, code lost:
    
        if (defpackage.AbstractC0457cG2.a(r27, r29, (defpackage.C1135nE2) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).j() == j()) goto L212;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x086c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a3  */
    /* JADX WARN: Type inference failed for: r0v105 */
    /* JADX WARN: Type inference failed for: r0v119, types: [PC2] */
    /* JADX WARN: Type inference failed for: r0v24, types: [PC2] */
    /* JADX WARN: Type inference failed for: r0v35, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v36, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v37, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v4, types: [vE2] */
    /* JADX WARN: Type inference failed for: r0v44, types: [OE2] */
    /* JADX WARN: Type inference failed for: r0v49, types: [OE2] */
    /* JADX WARN: Type inference failed for: r0v53, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v54, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v55, types: [rD2] */
    /* JADX WARN: Type inference failed for: r0v65, types: [PC2] */
    /* JADX WARN: Type inference failed for: r0v66, types: [PC2] */
    /* JADX WARN: Type inference failed for: r0v88, types: [PC2] */
    /* JADX WARN: Type inference failed for: r0v95, types: [vE2] */
    /* JADX WARN: Type inference failed for: r1v150, types: [vE2] */
    /* JADX WARN: Type inference failed for: r28v0, types: [java.lang.Object, java.lang.String] */
    @Override // defpackage.InterfaceC1601vE2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.InterfaceC1601vE2 i(java.lang.String r28, defpackage.IQ2 r29, java.util.ArrayList r30) {
        /*
            Method dump skipped, instruction units count: 2382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.PC2.i(java.lang.String, IQ2, java.util.ArrayList):vE2");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new GC2(this);
    }

    public final int j() {
        TreeMap treeMap = this.t;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final InterfaceC1601vE2 k(int i) {
        InterfaceC1601vE2 interfaceC1601vE2;
        if (i < j()) {
            return (!r(i) || (interfaceC1601vE2 = (InterfaceC1601vE2) this.t.get(Integer.valueOf(i))) == null) ? InterfaceC1601vE2.l : interfaceC1601vE2;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final String l(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.t.isEmpty()) {
            for (int i = 0; i < j(); i++) {
                InterfaceC1601vE2 interfaceC1601vE2K = k(i);
                sb.append(str);
                if (!(interfaceC1601vE2K instanceof UE2) && !(interfaceC1601vE2K instanceof C0691gE2)) {
                    sb.append(interfaceC1601vE2K.zzi());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final Iterator m() {
        return this.t.keySet().iterator();
    }

    public final ArrayList n() {
        ArrayList arrayList = new ArrayList(j());
        for (int i = 0; i < j(); i++) {
            arrayList.add(k(i));
        }
        return arrayList;
    }

    public final void o(int i) {
        TreeMap treeMap = this.t;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf(i2);
            if (treeMap.containsKey(numValueOf) || i2 < 0) {
                return;
            }
            treeMap.put(numValueOf, InterfaceC1601vE2.l);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i);
            InterfaceC1601vE2 interfaceC1601vE2 = (InterfaceC1601vE2) treeMap.get(numValueOf2);
            if (interfaceC1601vE2 != null) {
                treeMap.put(Integer.valueOf(i - 1), interfaceC1601vE2);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final void p(int i, InterfaceC1601vE2 interfaceC1601vE2) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC1214oR1.a(i, "Out of bounds index: "));
        }
        TreeMap treeMap = this.t;
        if (interfaceC1601vE2 == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), interfaceC1601vE2);
        }
    }

    public final boolean r(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.t;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        throw new IndexOutOfBoundsException(AbstractC1214oR1.a(i, "Out of bounds index: "));
    }

    public final String toString() {
        return l(",");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        PC2 pc2 = new PC2();
        for (Map.Entry entry : this.t.entrySet()) {
            boolean z = entry.getValue() instanceof SD2;
            TreeMap treeMap = pc2.t;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (InterfaceC1601vE2) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((InterfaceC1601vE2) entry.getValue()).zzd());
            }
        }
        return pc2;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return l(",");
    }

    public PC2(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                p(i, (InterfaceC1601vE2) list.get(i));
            }
        }
    }
}
