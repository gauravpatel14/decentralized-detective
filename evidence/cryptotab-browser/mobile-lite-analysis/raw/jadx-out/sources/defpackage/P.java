package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class P {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(P.class, Object.class, "onCloseHandler");
    public final InterfaceC0926jk0 b;
    public final LI0 c = new LI0();
    private volatile /* synthetic */ Object onCloseHandler = null;

    public P(InterfaceC0926jk0 interfaceC0926jk0) {
        this.b = interfaceC0926jk0;
    }

    public static void d(C1433sG c1433sG) {
        Object obj = null;
        while (true) {
            PI0 pi0Q = c1433sG.q();
            C1059m c1059m = pi0Q instanceof C1059m ? (C1059m) pi0Q : null;
            if (c1059m == null) {
                break;
            }
            if (!c1059m.t()) {
                ((Zt1) c1059m.o()).a.r();
            } else if (obj == null) {
                obj = c1059m;
            } else if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(c1059m);
            } else {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(c1059m);
                obj = arrayList;
            }
        }
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((C1059m) obj).x(c1433sG);
            return;
        }
        ArrayList arrayList2 = (ArrayList) obj;
        int size = arrayList2.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                ((C1059m) arrayList2.get(size)).x(c1433sG);
            }
        }
    }

    public final boolean a(Throwable th) {
        boolean z;
        Object obj;
        eT1 et1;
        C1433sG c1433sG = new C1433sG(th);
        PI0 pi0 = this.c;
        while (true) {
            PI0 pi0Q = pi0.q();
            if (pi0Q instanceof C1433sG) {
                z = false;
                break;
            }
            if (pi0Q.l(c1433sG, pi0)) {
                z = true;
                break;
            }
        }
        if (!z) {
            c1433sG = (C1433sG) this.c.q();
        }
        d(c1433sG);
        if (z && (obj = this.onCloseHandler) != null && obj != (et1 = r.e)) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, et1)) {
                    AbstractC0222Si2.a(1, obj);
                    ((InterfaceC0926jk0) obj).j(th);
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        return z;
    }

    public String b() {
        return "";
    }

    public final C1433sG c() {
        PI0 pi0Q = this.c.q();
        C1433sG c1433sG = pi0Q instanceof C1433sG ? (C1433sG) pi0Q : null;
        if (c1433sG == null) {
            return null;
        }
        d(c1433sG);
        return c1433sG;
    }

    public Object e(Object obj) {
        InterfaceC0805hr1 interfaceC0805hr1F;
        do {
            interfaceC0805hr1F = f();
            if (interfaceC0805hr1F == null) {
                return r.c;
            }
        } while (interfaceC0805hr1F.b(obj) == null);
        interfaceC0805hr1F.g();
        return interfaceC0805hr1F.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [PI0] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.InterfaceC0805hr1 f() {
        /*
            r4 = this;
            LI0 r0 = r4.c
        L2:
            java.lang.Object r1 = r0.o()
            PI0 r1 = (defpackage.PI0) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof defpackage.InterfaceC0805hr1
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            hr1 r2 = (defpackage.InterfaceC0805hr1) r2
            boolean r2 = r2 instanceof defpackage.C1433sG
            if (r2 == 0) goto L20
            boolean r2 = r1.s()
            if (r2 != 0) goto L20
            goto L26
        L20:
            PI0 r2 = r1.u()
            if (r2 != 0) goto L29
        L26:
            hr1 r1 = (defpackage.InterfaceC0805hr1) r1
            return r1
        L29:
            r2.r()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.P.f():hr1");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.xE1 g() {
        /*
            r4 = this;
            LI0 r0 = r4.c
        L2:
            java.lang.Object r1 = r0.o()
            PI0 r1 = (defpackage.PI0) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L28
        Ld:
            boolean r3 = r1 instanceof defpackage.xE1
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            xE1 r2 = (defpackage.xE1) r2
            boolean r2 = r2 instanceof defpackage.C1433sG
            if (r2 == 0) goto L22
            java.lang.Object r2 = r1.o()
            boolean r2 = r2 instanceof defpackage.Zt1
            if (r2 != 0) goto L22
            goto L28
        L22:
            PI0 r2 = r1.u()
            if (r2 != 0) goto L2b
        L28:
            xE1 r1 = (defpackage.xE1) r1
            return r1
        L2b:
            r2.r()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.P.g():xE1");
    }

    public final Object h(Object obj) {
        C1057lz c1057lz;
        Object objE = e(obj);
        if (objE == r.b) {
            return C0302Yj2.a;
        }
        if (objE == r.c) {
            C1433sG c1433sGC = c();
            if (c1433sGC == null) {
                return AbstractC1181nz.a;
            }
            d(c1433sGC);
            Throwable closedSendChannelException = c1433sGC.w;
            if (closedSendChannelException == null) {
                closedSendChannelException = new ClosedSendChannelException("Channel was closed");
            }
            c1057lz = new C1057lz(closedSendChannelException);
        } else {
            if (!(objE instanceof C1433sG)) {
                throw new IllegalStateException(("trySend returned " + objE).toString());
            }
            C1433sG c1433sG = (C1433sG) objE;
            d(c1433sG);
            Throwable closedSendChannelException2 = c1433sG.w;
            if (closedSendChannelException2 == null) {
                closedSendChannelException2 = new ClosedSendChannelException("Channel was closed");
            }
            c1057lz = new C1057lz(closedSendChannelException2);
        }
        return c1057lz;
    }

    public final String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('@');
        sb.append(hV.a(this));
        sb.append('{');
        PI0 pi0 = this.c;
        PI0 pi0P = pi0.p();
        if (pi0P == pi0) {
            string2 = "EmptyQueue";
        } else {
            if (pi0P instanceof C1433sG) {
                string = pi0P.toString();
            } else if (pi0P instanceof C1059m) {
                string = "ReceiveQueued";
            } else if (pi0P instanceof xE1) {
                string = "SendQueued";
            } else {
                string = "UNEXPECTED:" + pi0P;
            }
            PI0 pi0Q = pi0.q();
            if (pi0Q != pi0P) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(",queueSize=");
                int i = 0;
                for (PI0 pi0P2 = (PI0) pi0.o(); !lz0.a(pi0P2, pi0); pi0P2 = pi0P2.p()) {
                    if (pi0P2 != null) {
                        i++;
                    }
                }
                sb2.append(i);
                string2 = sb2.toString();
                if (pi0Q instanceof C1433sG) {
                    string2 = string2 + ",closedForSend=" + pi0Q;
                }
            } else {
                string2 = string;
            }
        }
        sb.append(string2);
        sb.append('}');
        sb.append(b());
        return sb.toString();
    }
}
