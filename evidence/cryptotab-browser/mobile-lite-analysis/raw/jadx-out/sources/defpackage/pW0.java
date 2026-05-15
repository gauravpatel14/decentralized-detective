package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class pW0 implements iW0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(pW0.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    @Override // defpackage.iW0
    public final void a() {
        PI0 pi0;
        while (true) {
            Object obj = this._state;
            boolean z = obj instanceof J60;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            if (z) {
                if (((J60) obj).a == qW0.c) {
                    throw new IllegalStateException("Mutex is not locked");
                }
                J60 j60 = qW0.e;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, j60)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof h51) {
                ((h51) obj).a(this);
            } else {
                if (!(obj instanceof mW0)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                mW0 mw0 = (mW0) obj;
                while (true) {
                    pi0 = (PI0) mw0.o();
                    if (pi0 == mw0) {
                        pi0 = null;
                        break;
                    } else if (pi0.t()) {
                        break;
                    } else {
                        ((Zt1) pi0.o()).a.r();
                    }
                }
                if (pi0 == null) {
                    nW0 nw0 = new nW0(mw0);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, nw0)) {
                            if (nw0.a(this) == null) {
                                return;
                            }
                        } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                } else {
                    lW0 lw0 = (lW0) pi0;
                    if (lw0.x()) {
                        mw0.owner = qW0.b;
                        lw0.w();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        r11.q(new defpackage.Yt1(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
    
        r11 = r11.n();
        r0 = defpackage.pO.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r11 != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
    
        if (r11 != r0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b9, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ba, code lost:
    
        return r4;
     */
    @Override // defpackage.iW0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.yN r11) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pW0.b(yN):java.lang.Object");
    }

    public final String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof J60) {
                return "Mutex[" + ((J60) obj).a + ']';
            }
            if (!(obj instanceof h51)) {
                if (!(obj instanceof mW0)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((mW0) obj).owner + ']';
            }
            ((h51) obj).a(this);
        }
    }
}
