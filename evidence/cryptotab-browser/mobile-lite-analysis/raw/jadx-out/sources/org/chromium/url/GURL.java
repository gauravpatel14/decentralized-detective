package org.chromium.url;

import J.N;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import defpackage.AbstractC0495cl0;
import defpackage.AbstractC1872zv;
import defpackage.C0496cl2;
import defpackage.F;
import defpackage.Gr1;
import defpackage.OE0;
import org.chromium.base.ThreadUtils;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class GURL {
    public String a;
    public boolean b;
    public Parsed c;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class BadSerializerVersionException extends RuntimeException {
    }

    public GURL(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a = "";
            this.c = new Parsed(0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, false, null);
        } else {
            c();
            N._V_OO(78, str, this);
        }
    }

    public static GURL a(String str) {
        try {
            return b(str);
        } catch (BadSerializerVersionException unused) {
            return new GURL(str.endsWith(Character.toString((char) 0)) ? "" : str.split(Character.toString((char) 0))[r1.length - 1]);
        } catch (Exception e) {
            Log.w("cr_GURL", "Exception while deserializing a GURL: " + str, e);
            return emptyGURL();
        }
    }

    public static GURL b(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyGURL();
        }
        String[] strArrSplit = str.split(Character.toString((char) 0));
        String str2 = strArrSplit[0];
        if (str.length() != str2.length() + Integer.parseInt(str2) + 1) {
            throw new IllegalArgumentException("Serialized GURL had the wrong length.");
        }
        String str3 = str.endsWith(Character.toString((char) 0)) ? "" : strArrSplit[strArrSplit.length - 1];
        if (Integer.parseInt(strArrSplit[1]) != 1) {
            throw new BadSerializerVersionException();
        }
        boolean z = Boolean.parseBoolean(strArrSplit[2]);
        Parsed parsedA = Parsed.a(3, strArrSplit);
        GURL gurl = new GURL();
        gurl.init(str3, z, parsedA);
        return gurl;
    }

    public static void c() {
        OE0 oe0 = OE0.h;
        if (oe0.d()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        oe0.b();
        if (ThreadUtils.f()) {
            Gr1.n(SystemClock.elapsedRealtime() - jElapsedRealtime, "Startup.Android.GURLEnsureMainDexInitialized");
        }
    }

    public static GURL emptyGURL() {
        return AbstractC0495cl0.a;
    }

    public static boolean k(GURL gurl) {
        return gurl == null || gurl.a.isEmpty() || !gurl.b;
    }

    public final String d(int i, int i2) {
        return i2 <= 0 ? "" : this.a.substring(i, i2 + i);
    }

    public final String e() {
        Parsed parsed = this.c;
        return d(parsed.g, parsed.h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GURL) {
            return this.a.equals(((GURL) obj).a);
        }
        return false;
    }

    public GURL f() {
        GURL gurl = new GURL();
        N._V_OO(77, this, gurl);
        return gurl;
    }

    public final String g() {
        Parsed parsed = this.c;
        return d(parsed.k, parsed.l);
    }

    public final String h() {
        Parsed parsed = this.c;
        return d(parsed.a, parsed.b);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String i() {
        return (this.b || this.a.isEmpty()) ? this.a : "";
    }

    public final void init(String str, boolean z, Parsed parsed) {
        this.a = str;
        this.b = z;
        this.c = parsed;
    }

    public final String j() {
        return this.b ? this.a : "";
    }

    public final String l() {
        String str = "1\u0000" + this.b + (char) 0 + this.c.b() + (char) 0 + this.a;
        return F.b(Integer.toString(str.length()), "\u0000", str);
    }

    public final C0496cl2 m() {
        C0496cl2 c0496cl2 = new C0496cl2(0);
        c0496cl2.b = (TextUtils.isEmpty(this.a) || this.a.length() > 2097152 || !this.b) ? "" : this.a;
        return c0496cl2;
    }

    public final void toNativeGURL(long j, long j2) {
        Parsed parsed = this.c;
        Parsed parsed2 = parsed;
        while (true) {
            Parsed parsed3 = parsed.q;
            boolean z = parsed2 == parsed3;
            N._V_ZZIIIIIIIIIIIIIIIIJ(0, z, parsed2.r, parsed2.a, parsed2.b, parsed2.c, parsed2.d, parsed2.e, parsed2.f, parsed2.g, parsed2.h, parsed2.i, parsed2.j, parsed2.k, parsed2.l, parsed2.m, parsed2.n, parsed2.o, parsed2.p, j2);
            if (z || parsed3 == null) {
                break;
            } else {
                parsed2 = parsed3;
            }
        }
        N._V_ZJJO(2, this.b, j, j2, this.a);
    }

    public String toString() {
        int i = AbstractC1872zv.a;
        return super.toString();
    }

    public GURL() {
    }
}
