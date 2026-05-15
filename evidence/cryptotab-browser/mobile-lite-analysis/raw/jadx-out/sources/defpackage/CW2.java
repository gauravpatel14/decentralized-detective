package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.measurement.internal.zzac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CW2 extends TO2 {
    public final AW2 c;
    public InterfaceC1086mO2 d;
    public volatile Boolean e;
    public final JV2 f;
    public final C0480cX2 g;
    public final ArrayList h;
    public final MV2 i;

    public CW2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.h = new ArrayList();
        this.g = new C0480cX2(c1391rR2.n);
        this.c = new AW2(this);
        this.f = new JV2(this, c1391rR2);
        this.i = new MV2(this, c1391rR2);
    }

    public static void u(CW2 cw2, ComponentName componentName) {
        cw2.g();
        if (cw2.d != null) {
            cw2.d = null;
            WO2 wo2 = cw2.a.i;
            C1391rR2.k(wo2);
            wo2.n.b(componentName, "Disconnected from device MeasurementService");
            cw2.g();
            cw2.v();
        }
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0317 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.InterfaceC1086mO2 r29, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r30, com.google.android.gms.measurement.internal.zzq r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CW2.k(mO2, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzq):void");
    }

    public final void l(zzac zzacVar) {
        boolean zN;
        Preconditions.checkNotNull(zzacVar);
        g();
        h();
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.getClass();
        C1503tO2 c1503tO2P = c1391rR2.p();
        C1391rR2 c1391rR22 = c1503tO2P.a;
        C1391rR2.i(c1391rR22.l);
        byte[] bArrT = C0653fY2.T(zzacVar);
        if (bArrT.length > 131072) {
            WO2 wo2 = c1391rR22.i;
            C1391rR2.k(wo2);
            wo2.g.a("Conditional user property too long for local database. Sending directly to service");
            zN = false;
        } else {
            zN = c1503tO2P.n(2, bArrT);
        }
        s(new SV2(this, p(true), zN, new zzac(zzacVar)));
    }

    public final boolean m() {
        g();
        h();
        return this.d != null;
    }

    public final boolean n() {
        g();
        h();
        if (!o()) {
            return true;
        }
        C0653fY2 c0653fY2 = this.a.l;
        C1391rR2.i(c0653fY2);
        return c0653fY2.d0() >= ((Integer) AbstractC0579eO2.g0.a(null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o() {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CW2.o():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzq p(boolean r38) {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CW2.p(boolean):com.google.android.gms.measurement.internal.zzq");
    }

    public final void q() {
        g();
        C1391rR2 c1391rR2 = this.a;
        WO2 wo2 = c1391rR2.i;
        C1391rR2.k(wo2);
        ArrayList arrayList = this.h;
        wo2.n.b(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                WO2 wo22 = c1391rR2.i;
                C1391rR2.k(wo22);
                wo22.f.b(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.i.a();
    }

    public final void r() {
        g();
        C0480cX2 c0480cX2 = this.g;
        c0480cX2.b = c0480cX2.a.elapsedRealtime();
        this.a.getClass();
        this.f.c(((Long) AbstractC0579eO2.I.a(null)).longValue());
    }

    public final void s(Runnable runnable) {
        g();
        if (m()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.getClass();
        if (size >= 1000) {
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.f.a("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.i.c(60000L);
            v();
        }
    }

    public final Boolean t() {
        return this.e;
    }

    public final void v() {
        g();
        h();
        if (m()) {
            return;
        }
        if (o()) {
            AW2 aw2 = this.c;
            aw2.v.g();
            Context context = aw2.v.a.a;
            synchronized (aw2) {
                try {
                    if (aw2.t) {
                        WO2 wo2 = aw2.v.a.i;
                        C1391rR2.k(wo2);
                        wo2.n.a("Connection attempt already in progress");
                        return;
                    } else {
                        if (aw2.u != null && (aw2.u.isConnecting() || aw2.u.isConnected())) {
                            WO2 wo22 = aw2.v.a.i;
                            C1391rR2.k(wo22);
                            wo22.n.a("Already awaiting connection attempt");
                            return;
                        }
                        aw2.u = new C1781yO2(context, Looper.getMainLooper(), 93, aw2, aw2, null);
                        WO2 wo23 = aw2.v.a.i;
                        C1391rR2.k(wo23);
                        wo23.n.a("Connecting to remote service");
                        aw2.t = true;
                        Preconditions.checkNotNull(aw2.u);
                        aw2.u.checkAvailabilityAndConnect();
                        return;
                    }
                } finally {
                }
            }
        }
        if (this.a.g.u()) {
            return;
        }
        this.a.getClass();
        List<ResolveInfo> listQueryIntentServices = this.a.a.getPackageManager().queryIntentServices(new Intent().setClassName(this.a.a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            WO2 wo24 = this.a.i;
            C1391rR2.k(wo24);
            wo24.f.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(this.a.a, "com.google.android.gms.measurement.AppMeasurementService"));
        AW2 aw22 = this.c;
        aw22.v.g();
        Context context2 = aw22.v.a.a;
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (aw22) {
            try {
                if (aw22.t) {
                    WO2 wo25 = aw22.v.a.i;
                    C1391rR2.k(wo25);
                    wo25.n.a("Connection attempt already in progress");
                } else {
                    WO2 wo26 = aw22.v.a.i;
                    C1391rR2.k(wo26);
                    wo26.n.a("Using local app measurement service");
                    aw22.t = true;
                    connectionTracker.bindService(context2, intent, aw22.v.c, 129);
                }
            } finally {
            }
        }
    }

    public final void w() {
        g();
        h();
        AW2 aw2 = this.c;
        if (aw2.u != null && (aw2.u.isConnected() || aw2.u.isConnecting())) {
            aw2.u.disconnect();
        }
        aw2.u = null;
        try {
            ConnectionTracker.getInstance().unbindService(this.a.a, this.c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.d = null;
    }

    public final void x(AtomicReference atomicReference) {
        g();
        h();
        s(new DV2(this, atomicReference, p(false)));
    }
}
