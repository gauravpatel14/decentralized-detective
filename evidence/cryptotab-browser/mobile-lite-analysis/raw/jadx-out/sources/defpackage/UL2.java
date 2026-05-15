package defpackage;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.internal.cast.zzds;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UL2 extends AbstractC1665wJ2 {
    public static final String s;
    public long d;
    public MediaStatus e;
    public Long f;
    public M13 g;
    public final C1501tM2 h;
    public final C1501tM2 i;
    public final C1501tM2 j;
    public final C1501tM2 k;
    public final C1501tM2 l;
    public final C1501tM2 m;
    public final C1501tM2 n;
    public final C1501tM2 o;
    public final C1501tM2 p;
    public final C1501tM2 q;
    public final C1501tM2 r;

    static {
        Pattern pattern = AbstractC0700gL2.a;
        s = "urn:x-cast:".concat("com.google.cast.media");
    }

    public UL2() {
        C1501tM2 c1501tM2 = new C1501tM2(86400000L);
        this.h = c1501tM2;
        C1501tM2 c1501tM22 = new C1501tM2(86400000L);
        this.i = c1501tM22;
        C1501tM2 c1501tM23 = new C1501tM2(86400000L);
        this.j = c1501tM23;
        C1501tM2 c1501tM24 = new C1501tM2(86400000L);
        C1501tM2 c1501tM25 = new C1501tM2(10000L);
        this.k = c1501tM25;
        C1501tM2 c1501tM26 = new C1501tM2(86400000L);
        this.l = c1501tM26;
        C1501tM2 c1501tM27 = new C1501tM2(86400000L);
        this.m = c1501tM27;
        C1501tM2 c1501tM28 = new C1501tM2(86400000L);
        this.n = c1501tM28;
        C1501tM2 c1501tM29 = new C1501tM2(86400000L);
        C1501tM2 c1501tM210 = new C1501tM2(86400000L);
        C1501tM2 c1501tM211 = new C1501tM2(86400000L);
        C1501tM2 c1501tM212 = new C1501tM2(86400000L);
        this.o = c1501tM212;
        C1501tM2 c1501tM213 = new C1501tM2(86400000L);
        C1501tM2 c1501tM214 = new C1501tM2(86400000L);
        C1501tM2 c1501tM215 = new C1501tM2(86400000L);
        this.p = c1501tM215;
        C1501tM2 c1501tM216 = new C1501tM2(86400000L);
        this.r = c1501tM216;
        this.q = new C1501tM2(86400000L);
        C1501tM2 c1501tM217 = new C1501tM2(86400000L);
        C1501tM2 c1501tM218 = new C1501tM2(86400000L);
        b(c1501tM2);
        b(c1501tM22);
        b(c1501tM23);
        b(c1501tM24);
        b(c1501tM25);
        b(c1501tM26);
        b(c1501tM27);
        b(c1501tM28);
        b(c1501tM29);
        b(c1501tM210);
        b(c1501tM211);
        b(c1501tM212);
        b(c1501tM213);
        b(c1501tM214);
        b(c1501tM215);
        b(c1501tM216);
        b(c1501tM216);
        b(c1501tM217);
        b(c1501tM218);
        k();
    }

    public final long d() {
        C1728xN0 c1728xN0;
        MediaStatus mediaStatus = this.e;
        MediaInfo mediaInfo = mediaStatus == null ? null : mediaStatus.t;
        if (mediaInfo == null) {
            return 0L;
        }
        Long l = this.f;
        if (l == null) {
            if (this.d == 0) {
                return 0L;
            }
            double d = mediaStatus.w;
            long j = mediaStatus.z;
            return (d == 0.0d || mediaStatus.x != 2) ? j : i(d, j, mediaInfo.x);
        }
        if (l.equals(4294967296000L)) {
            MediaStatus mediaStatus2 = this.e;
            if (mediaStatus2.N != null) {
                long jLongValue = this.f.longValue();
                MediaStatus mediaStatus3 = this.e;
                if (mediaStatus3 != null && (c1728xN0 = mediaStatus3.N) != null) {
                    boolean z = c1728xN0.d;
                    long j2 = c1728xN0.b;
                    jI = !z ? i(1.0d, j2, -1L) : j2;
                }
                return Math.min(jLongValue, jI);
            }
            MediaInfo mediaInfo2 = mediaStatus2 == null ? null : mediaStatus2.t;
            if ((mediaInfo2 != null ? mediaInfo2.x : 0L) >= 0) {
                long jLongValue2 = this.f.longValue();
                MediaStatus mediaStatus4 = this.e;
                MediaInfo mediaInfo3 = mediaStatus4 != null ? mediaStatus4.t : null;
                return Math.min(jLongValue2, mediaInfo3 != null ? mediaInfo3.x : 0L);
            }
        }
        return this.f.longValue();
    }

    public final void e() {
        M13 m13 = this.g;
        if (m13 != null) {
            Nt1 nt1 = m13.a;
            nt1.getClass();
            Iterator it = nt1.g.iterator();
            while (it.hasNext()) {
                ((C1256pD2) it.next()).getClass();
            }
            Iterator it2 = nt1.h.iterator();
            while (it2.hasNext()) {
                ((Ht1) it2.next()).a();
            }
        }
    }

    public final void f() {
        M13 m13 = this.g;
        if (m13 != null) {
            Nt1 nt1 = m13.a;
            Iterator it = nt1.g.iterator();
            while (it.hasNext()) {
                ((C1256pD2) it.next()).getClass();
            }
            Iterator it2 = nt1.h.iterator();
            while (it2.hasNext()) {
                ((Ht1) it2.next()).getClass();
            }
        }
    }

    public final void g() {
        M13 m13 = this.g;
        if (m13 != null) {
            Nt1 nt1 = m13.a;
            Iterator it = nt1.g.iterator();
            while (it.hasNext()) {
                ((C1256pD2) it.next()).getClass();
            }
            Iterator it2 = nt1.h.iterator();
            while (it2.hasNext()) {
                ((Ht1) it2.next()).getClass();
            }
        }
    }

    public final void h() {
        M13 m13 = this.g;
        if (m13 != null) {
            Nt1 nt1 = m13.a;
            nt1.getClass();
            Iterator it = nt1.i.values().iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                if (!nt1.f() && nt1.f()) {
                    throw null;
                }
                throw null;
            }
            Iterator it2 = nt1.g.iterator();
            while (it2.hasNext()) {
                ((C1256pD2) it2.next()).getClass();
            }
            Iterator it3 = nt1.h.iterator();
            while (it3.hasNext()) {
                ((Ht1) it3.next()).b();
            }
        }
    }

    public final long i(double d, long j, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.d;
        if (jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        if (jElapsedRealtime == 0) {
            return j;
        }
        long j3 = j + ((long) (jElapsedRealtime * d));
        if (j2 > 0 && j3 > j2) {
            return j2;
        }
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public final void j(C0565eF2 c0565eF2, int i) {
        JSONObject jSONObject = new JSONObject();
        long jC = c();
        try {
            jSONObject.put("requestId", jC);
            jSONObject.put("type", "QUEUE_UPDATE");
            jSONObject.put("mediaSessionId", l());
            if (i != 0) {
                jSONObject.put("jump", i);
            }
        } catch (JSONException unused) {
        }
        a(jC, jSONObject.toString());
        this.o.c(jC, c0565eF2);
    }

    public final void k() {
        this.d = 0L;
        this.e = null;
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((C1501tM2) it.next()).d(2002);
        }
    }

    public final long l() throws zzds {
        MediaStatus mediaStatus = this.e;
        if (mediaStatus != null) {
            return mediaStatus.u;
        }
        throw new zzds();
    }
}
