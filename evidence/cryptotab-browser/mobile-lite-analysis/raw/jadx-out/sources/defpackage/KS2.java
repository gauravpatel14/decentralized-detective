package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KS2 implements Runnable {
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;
    public final /* synthetic */ String v;
    public final /* synthetic */ long w;
    public final /* synthetic */ MS2 x;

    public KS2(MS2 ms2, String str, String str2, String str3, long j) {
        this.x = ms2;
        this.t = str;
        this.u = str2;
        this.v = str3;
        this.w = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((W03) V03.u.t.zza()).getClass();
        if (this.x.t.J().p(null, AbstractC0579eO2.p0)) {
            String str = this.t;
            if (str == null) {
                QX2 qx2 = this.x.t;
                String str2 = this.u;
                qx2.b().g();
                String str3 = qx2.D;
                if (str3 == null || str3.equals(str2)) {
                    qx2.D = str2;
                    qx2.C = null;
                    return;
                }
                return;
            }
            TU2 tu2 = new TU2(this.w, this.v, str);
            QX2 qx22 = this.x.t;
            String str4 = this.u;
            qx22.b().g();
            String str5 = qx22.D;
            if (str5 != null) {
                str5.equals(str4);
            }
            qx22.D = str4;
            qx22.C = tu2;
            return;
        }
        if (this.t == null) {
            C1791yV2 c1791yV2 = this.x.t.l.o;
            C1391rR2.j(c1791yV2);
            String str6 = this.u;
            c1791yV2.g();
            synchronized (c1791yV2) {
                try {
                    String str7 = c1791yV2.m;
                    if (str7 == null || str7.equals(str6)) {
                        c1791yV2.m = str6;
                    }
                } finally {
                }
            }
            return;
        }
        C1791yV2 c1791yV22 = this.x.t.l.o;
        C1391rR2.j(c1791yV22);
        String str8 = this.u;
        c1791yV22.g();
        synchronized (c1791yV22) {
            try {
                String str9 = c1791yV22.m;
                if (str9 != null) {
                    str9.equals(str8);
                }
                c1791yV22.m = str8;
            } finally {
            }
        }
    }
}
