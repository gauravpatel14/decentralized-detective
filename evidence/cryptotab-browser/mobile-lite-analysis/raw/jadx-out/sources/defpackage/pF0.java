package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pF0 extends AbstractC0771hO implements Runnable, DW {
    private volatile int runningWorkers;
    public final AbstractC0771hO u;
    public final int v;
    public final /* synthetic */ DW w;
    public final QI0 x;
    public final Object y;

    /* JADX WARN: Multi-variable type inference failed */
    public pF0(AbstractC0771hO abstractC0771hO, int i) {
        this.u = abstractC0771hO;
        this.v = i;
        DW dw = abstractC0771hO instanceof DW ? (DW) abstractC0771hO : null;
        this.w = dw == null ? MV.a : dw;
        this.x = new QI0();
        this.y = new Object();
    }

    @Override // defpackage.DW
    public final L00 b(long j, RunnableC0853ia2 runnableC0853ia2, InterfaceC0577eO interfaceC0577eO) {
        return this.w.b(j, runnableC0853ia2, interfaceC0577eO);
    }

    @Override // defpackage.AbstractC0771hO
    public final void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable) {
        this.x.a(runnable);
        if (this.runningWorkers >= this.v) {
            return;
        }
        synchronized (this.y) {
            if (this.runningWorkers >= this.v) {
                return;
            }
            this.runningWorkers++;
            this.u.c(this, this);
        }
    }

    @Override // defpackage.AbstractC0771hO
    public final AbstractC0771hO e(int i) {
        qF0.a(1);
        return 1 >= this.v ? this : super.e(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r4.y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.x.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r4.runningWorkers++;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            QI0 r2 = r4.x
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            R60 r3 = defpackage.R60.t
            defpackage.kO.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            hO r2 = r4.u
            boolean r2 = r2.d()
            if (r2 == 0) goto L2
            hO r0 = r4.u
            r0.c(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.y
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L45
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L45
            QI0 r2 = r4.x     // Catch: java.lang.Throwable -> L45
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L45
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L45
            monitor-exit(r1)
            goto L1
        L45:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pF0.run():void");
    }
}
