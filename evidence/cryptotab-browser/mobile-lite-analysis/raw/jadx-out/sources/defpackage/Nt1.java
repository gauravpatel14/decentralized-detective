package defpackage;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Nt1 implements xy {
    public final Object a;
    public final HandlerC0957kO2 b;
    public final UL2 c;
    public final Jt1 d;
    public final ty e;
    public GoogleApiClient f;
    public final CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    public final ConcurrentHashMap i;

    static {
        String str = UL2.s;
    }

    public Nt1(UL2 ul2, ty tyVar) {
        new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.a = new Object();
        this.b = new HandlerC0957kO2(Looper.getMainLooper());
        Jt1 jt1 = new Jt1(this);
        this.d = jt1;
        this.e = tyVar;
        UL2 ul22 = (UL2) Preconditions.checkNotNull(ul2);
        this.c = ul22;
        ul22.g = new M13(this);
        ul22.b = jt1;
        new UN0(this);
    }

    public static Kt1 o() {
        Kt1 kt1 = new Kt1(null);
        kt1.setResult(new XE2(new Status(17, (String) null)));
        return kt1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014b  */
    @Override // defpackage.xy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.cast.CastDevice r44, java.lang.String r45, java.lang.String r46) {
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Nt1.a(com.google.android.gms.cast.CastDevice, java.lang.String, java.lang.String):void");
    }

    public final long b() {
        long jD;
        synchronized (this.a) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            jD = this.c.d();
        }
        return jD;
    }

    public final MediaInfo c() {
        MediaInfo mediaInfo;
        synchronized (this.a) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = this.c.e;
            mediaInfo = mediaStatus == null ? null : mediaStatus.t;
        }
        return mediaInfo;
    }

    public final MediaStatus d() {
        MediaStatus mediaStatus;
        synchronized (this.a) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaStatus = this.c.e;
        }
        return mediaStatus;
    }

    public final long e() {
        long j;
        synchronized (this.a) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = this.c.e;
            MediaInfo mediaInfo = mediaStatus == null ? null : mediaStatus.t;
            j = mediaInfo != null ? mediaInfo.x : 0L;
        }
        return j;
    }

    public final boolean f() {
        int i;
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatusD = d();
        if ((mediaStatusD != null && mediaStatusD.x == 4) || h()) {
            return true;
        }
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatusD2 = d();
        if (mediaStatusD2 != null) {
            if (mediaStatusD2.x == 3) {
                return true;
            }
            if (g()) {
                synchronized (this.a) {
                    Preconditions.checkMainThread("Must be called from the main thread.");
                    MediaStatus mediaStatusD3 = d();
                    i = mediaStatusD3 != null ? mediaStatusD3.y : 0;
                }
                if (i == 2) {
                    return true;
                }
            }
        }
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatusD4 = d();
        return (mediaStatusD4 == null || mediaStatusD4.E == 0) ? false : true;
    }

    public final boolean g() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfoC = c();
        return mediaInfoC != null && mediaInfoC.u == 2;
    }

    public final boolean h() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatusD = d();
        return mediaStatusD != null && mediaStatusD.x == 2;
    }

    public final boolean i() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatusD = d();
        return mediaStatusD != null && mediaStatusD.K;
    }

    public final BasePendingResult j() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!r()) {
            return o();
        }
        ZD2 zd2 = new ZD2(this, this.f);
        p(zd2);
        return zd2;
    }

    public final BasePendingResult k() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!r()) {
            return o();
        }
        C1072mE2 c1072mE2 = new C1072mE2(this, this.f);
        p(c1072mE2);
        return c1072mE2;
    }

    public final void l() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (r()) {
            p(new C0329a23(this, this.f));
        } else {
            o();
        }
    }

    public final BasePendingResult m(long j) {
        C1387rP0 c1387rP0 = new C1387rP0(j);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!r()) {
            return o();
        }
        GE2 ge2 = new GE2(this, this.f, c1387rP0);
        p(ge2);
        return ge2;
    }

    public final void n() {
        int i;
        Preconditions.checkMainThread("Must be called from the main thread.");
        synchronized (this.a) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatusD = d();
            i = mediaStatusD != null ? mediaStatusD.x : 1;
        }
        if (i == 4 || i == 2) {
            j();
        } else {
            k();
        }
    }

    public final void p(Lt1 lt1) {
        try {
            this.f.execute(lt1);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Throwable unused) {
            lt1.setResult((Result) new C0826iF2(new Status(2100)));
        }
    }

    public final void q(GoogleApiClient googleApiClient) {
        GoogleApiClient googleApiClient2;
        String str;
        GoogleApiClient googleApiClient3 = this.f;
        if (googleApiClient3 == googleApiClient) {
            return;
        }
        Jt1 jt1 = this.d;
        if (googleApiClient3 != null) {
            UL2 ul2 = this.c;
            synchronized (ul2.c) {
                try {
                    Iterator it = ul2.c.iterator();
                    while (it.hasNext()) {
                        ((C1501tM2) it.next()).d(2002);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ul2.k();
            try {
                ty tyVar = this.e;
                googleApiClient2 = this.f;
                Preconditions.checkMainThread("Must be called from the main thread.");
                this.c.getClass();
                str = UL2.s;
                tyVar.getClass();
            } catch (IOException unused) {
            }
            try {
                ((OJ2) googleApiClient2.getClient(ML2.a)).c(str);
                jt1.a = null;
                this.b.removeCallbacksAndMessages(null);
            } catch (RemoteException unused2) {
                throw new IOException("service error");
            }
        }
        this.f = googleApiClient;
        if (googleApiClient != null) {
            jt1.a = googleApiClient;
        }
    }

    public final boolean r() {
        return this.f != null;
    }
}
