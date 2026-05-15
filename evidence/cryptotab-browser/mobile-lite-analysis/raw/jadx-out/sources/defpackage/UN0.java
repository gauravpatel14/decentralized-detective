package defpackage;

import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UN0 {
    public long b;
    public final Nt1 c;
    public boolean d;
    public ArrayList e;
    public final SparseIntArray f;
    public final C1397rX2 g;
    public final ArrayList h;
    public final ArrayDeque i;
    public final HandlerC0957kO2 j;
    public final C1279pW2 k;
    public BasePendingResult l;
    public BasePendingResult m;
    public final RN0 n;
    public final RN0 o;
    public final SN0 p;
    public final HashSet q = new HashSet();
    public final YL2 a = new YL2("MediaQueue");

    public UN0(Nt1 nt1) {
        int i = 1;
        this.c = nt1;
        Math.max(20, 1);
        YL2 yl2 = C0025By.h;
        Preconditions.checkMainThread("Must be called from the main thread.");
        eF1 ef1A = C0025By.i.a();
        ef1A.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        AbstractC0338aF1 abstractC0338aF1C = ef1A.c();
        Ly ly = (abstractC0338aF1C == null || !(abstractC0338aF1C instanceof Ly)) ? null : (Ly) abstractC0338aF1C;
        this.e = new ArrayList();
        this.f = new SparseIntArray();
        this.h = new ArrayList();
        this.i = new ArrayDeque(20);
        this.j = new HandlerC0957kO2(Looper.getMainLooper());
        this.g = new C1397rX2(this);
        this.k = new C1279pW2(this);
        this.n = new RN0(this, 0);
        this.o = new RN0(this, i);
        this.p = new SN0(this);
        TN0 tn0 = new TN0(this);
        Preconditions.checkMainThread("Must be called from the main thread.");
        C0025By.i.a().a(tn0);
        if (ly == null || !ly.a()) {
            return;
        }
        c(ly.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long d(defpackage.Nt1 r5) {
        /*
            com.google.android.gms.cast.MediaStatus r5 = r5.d()
            if (r5 == 0) goto L2a
            com.google.android.gms.cast.MediaInfo r0 = r5.t
            if (r0 != 0) goto Lc
            r0 = -1
            goto Le
        Lc:
            int r0 = r0.u
        Le:
            int r1 = r5.x
            int r2 = r5.y
            int r3 = r5.E
            r4 = 1
            if (r1 == r4) goto L18
            goto L27
        L18:
            if (r2 == r4) goto L24
            r1 = 2
            if (r2 == r1) goto L21
            r0 = 3
            if (r2 == r0) goto L24
            goto L2a
        L21:
            if (r0 == r1) goto L27
            goto L2a
        L24:
            if (r3 != 0) goto L27
            goto L2a
        L27:
            long r0 = r5.u
            return r0
        L2a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.UN0.d(Nt1):long");
    }

    public static void e(UN0 un0) {
        SparseIntArray sparseIntArray = un0.f;
        sparseIntArray.clear();
        for (int i = 0; i < un0.e.size(); i++) {
            sparseIntArray.put(((Integer) un0.e.get(i)).intValue(), i);
        }
    }

    public final void a() {
        f();
        this.e.clear();
        this.f.clear();
        this.g.evictAll();
        this.h.clear();
        this.j.removeCallbacks(this.k);
        this.i.clear();
        BasePendingResult basePendingResult = this.m;
        if (basePendingResult != null) {
            basePendingResult.cancel();
            this.m = null;
        }
        BasePendingResult basePendingResult2 = this.l;
        if (basePendingResult2 != null) {
            basePendingResult2.cancel();
            this.l = null;
        }
        Iterator it = this.q.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        g();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b() {
        BasePendingResult basePendingResult;
        BasePendingResult basePendingResultO;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.d && this.b != 0 && (basePendingResult = this.m) == null) {
            if (basePendingResult != null) {
                basePendingResult.cancel();
                this.m = null;
            }
            BasePendingResult basePendingResult2 = this.l;
            if (basePendingResult2 != null) {
                basePendingResult2.cancel();
                this.l = null;
            }
            Nt1 nt1 = this.c;
            nt1.getClass();
            Preconditions.checkMainThread("Must be called from the main thread.");
            if (nt1.r()) {
                C1716xD2 c1716xD2 = new C1716xD2(nt1, nt1.f);
                nt1.p(c1716xD2);
                basePendingResultO = c1716xD2;
            } else {
                basePendingResultO = Nt1.o();
            }
            this.m = basePendingResultO;
            basePendingResultO.setResultCallback(this.o);
        }
    }

    public final void c(Nt1 nt1) {
        if (nt1 == null || this.c != nt1) {
            return;
        }
        this.d = true;
        SN0 sn0 = this.p;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sn0 != null) {
            nt1.h.add(sn0);
        }
        long jD = d(nt1);
        this.b = jD;
        if (jD != 0) {
            b();
        }
    }

    public final void f() {
        Iterator it = this.q.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void g() {
        Iterator it = this.q.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }
}
