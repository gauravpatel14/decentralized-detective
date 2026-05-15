package defpackage;

import android.os.Looper;
import org.json.JSONObject;

/* JADX INFO: renamed from: tM2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1501tM2 {
    public static final YL2 f = new YL2("RequestTracker");
    public static final Object g = new Object();
    public final long a;
    public BM2 d;
    public GM2 e;
    public long c = -1;
    public final HandlerC0957kO2 b = new HandlerC0957kO2(Looper.getMainLooper());

    public C1501tM2(long j) {
        this.a = j;
    }

    public final boolean a(long j) {
        boolean z;
        synchronized (g) {
            long j2 = this.c;
            z = j2 != -1 && j2 == j;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        r5 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            YL2 r0 = defpackage.C1501tM2.f
            r0.getClass()
            java.lang.Object r0 = defpackage.C1501tM2.g
            monitor-enter(r0)
            BM2 r1 = r4.d     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L14
            long r2 = r4.c     // Catch: java.lang.Throwable -> L12
            r1.b(r2, r5, r6)     // Catch: java.lang.Throwable -> L12
            goto L14
        L12:
            r5 = move-exception
            goto L30
        L14:
            r5 = -1
            r4.c = r5     // Catch: java.lang.Throwable -> L12
            r5 = 0
            r4.d = r5     // Catch: java.lang.Throwable -> L12
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L12
            GM2 r6 = r4.e     // Catch: java.lang.Throwable -> L22
            if (r6 != 0) goto L24
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            goto L2c
        L22:
            r5 = move-exception
            goto L2e
        L24:
            kO2 r1 = r4.b     // Catch: java.lang.Throwable -> L22
            r1.removeCallbacks(r6)     // Catch: java.lang.Throwable -> L22
            r4.e = r5     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            return
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            throw r5     // Catch: java.lang.Throwable -> L12
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L12
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1501tM2.b(int, org.json.JSONObject):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [GM2, java.lang.Runnable] */
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
    public final void c(long j, BM2 bm2) {
        BM2 bm22;
        long j2;
        Object obj = g;
        synchronized (obj) {
            bm22 = this.d;
            j2 = this.c;
            this.c = j;
            this.d = bm2;
        }
        if (bm22 != null) {
            bm22.a(j2);
        }
        synchronized (obj) {
            try {
                GM2 gm2 = this.e;
                if (gm2 != null) {
                    this.b.removeCallbacks(gm2);
                }
                ?? r5 = new Runnable(this) { // from class: GM2
                    public final C1501tM2 t;

                    {
                        this.t = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C1501tM2 c1501tM2 = this.t;
                        c1501tM2.getClass();
                        synchronized (C1501tM2.g) {
                            try {
                                if (c1501tM2.c == -1) {
                                    return;
                                }
                                c1501tM2.d(15);
                            } finally {
                            }
                        }
                    }
                };
                this.e = r5;
                this.b.postDelayed(r5, this.a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(int i) {
        synchronized (g) {
            try {
                if (this.c == -1) {
                    return false;
                }
                b(i, null);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(long j, int i, JSONObject jSONObject) {
        synchronized (g) {
            try {
                long j2 = this.c;
                if (j2 == -1 || j2 != j) {
                    return;
                }
                b(i, jSONObject);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
