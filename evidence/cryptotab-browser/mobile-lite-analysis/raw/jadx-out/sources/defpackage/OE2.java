package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OE2 implements Iterable, InterfaceC1601vE2 {
    public final String t;

    public OE2(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.t = str;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Double b() {
        String str = this.t;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OE2) {
            return this.t.equals(((OE2) obj).t);
        }
        return false;
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Iterator f() {
        return new BE2(this);
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015e  */
    @Override // defpackage.InterfaceC1601vE2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.InterfaceC1601vE2 i(java.lang.String r21, defpackage.IQ2 r22, java.util.ArrayList r23) {
        /*
            Method dump skipped, instruction units count: 1726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.OE2.i(java.lang.String, IQ2, java.util.ArrayList):vE2");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new IE2(this);
    }

    public final String toString() {
        return S3.a(new StringBuilder("\""), this.t, "\"");
    }

    @Override // defpackage.InterfaceC1601vE2
    public final InterfaceC1601vE2 zzd() {
        return new OE2(this.t);
    }

    @Override // defpackage.InterfaceC1601vE2
    public final Boolean zzg() {
        return Boolean.valueOf(!this.t.isEmpty());
    }

    @Override // defpackage.InterfaceC1601vE2
    public final String zzi() {
        return this.t;
    }
}
