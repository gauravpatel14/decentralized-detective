package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: pO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1270pO2 extends TO2 {
    public String c;
    public String d;
    public int e;
    public String f;
    public long g;
    public final long h;
    public List i;
    public String j;
    public int k;
    public String l;
    public String m;
    public String n;
    public long o;
    public String p;

    public C1270pO2(C1391rR2 c1391rR2, long j) {
        super(c1391rR2);
        this.o = 0L;
        this.p = null;
        this.h = j;
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return true;
    }

    public final String k() {
        h();
        Preconditions.checkNotNull(this.c);
        return this.c;
    }

    public final String l() {
        ((YZ2) XZ2.u.t.zza()).getClass();
        if (this.a.g.p(null, AbstractC0579eO2.h0)) {
            g();
        }
        h();
        Preconditions.checkNotNull(this.l);
        return this.l;
    }

    public final void m() {
        String str;
        g();
        C1391rR2 c1391rR2 = this.a;
        TP2 tp2 = c1391rR2.h;
        C1391rR2.i(tp2);
        if (tp2.l().f(EnumC1486tD2.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            C0653fY2 c0653fY2 = c1391rR2.l;
            C1391rR2.i(c0653fY2);
            c0653fY2.o().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.m.a("Analytics Storage consent is not granted");
            str = null;
        }
        WO2 wo22 = c1391rR2.i;
        C1391rR2.k(wo22);
        wo22.m.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.n = str;
        this.o = c1391rR2.n.currentTimeMillis();
    }
}
