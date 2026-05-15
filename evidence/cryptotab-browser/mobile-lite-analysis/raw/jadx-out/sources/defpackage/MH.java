package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class MH {
    public final Object a;
    public final AbstractC1474sx b;
    public final InterfaceC0926jk0 c;
    public final Object d;
    public final Throwable e;

    public MH(Object obj, AbstractC1474sx abstractC1474sx, InterfaceC0926jk0 interfaceC0926jk0, Object obj2, Throwable th) {
        this.a = obj;
        this.b = abstractC1474sx;
        this.c = interfaceC0926jk0;
        this.d = obj2;
        this.e = th;
    }

    public static MH a(MH mh, AbstractC1474sx abstractC1474sx, CancellationException cancellationException, int i) {
        Object obj = mh.a;
        if ((i & 2) != 0) {
            abstractC1474sx = mh.b;
        }
        AbstractC1474sx abstractC1474sx2 = abstractC1474sx;
        InterfaceC0926jk0 interfaceC0926jk0 = mh.c;
        Object obj2 = mh.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = mh.e;
        }
        mh.getClass();
        return new MH(obj, abstractC1474sx2, interfaceC0926jk0, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MH)) {
            return false;
        }
        MH mh = (MH) obj;
        return lz0.a(this.a, mh.a) && lz0.a(this.b, mh.b) && lz0.a(this.c, mh.c) && lz0.a(this.d, mh.d) && lz0.a(this.e, mh.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC1474sx abstractC1474sx = this.b;
        int iHashCode2 = (iHashCode + (abstractC1474sx == null ? 0 : abstractC1474sx.hashCode())) * 31;
        InterfaceC0926jk0 interfaceC0926jk0 = this.c;
        int iHashCode3 = (iHashCode2 + (interfaceC0926jk0 == null ? 0 : interfaceC0926jk0.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ MH(Object obj, AbstractC1474sx abstractC1474sx, InterfaceC0926jk0 interfaceC0926jk0, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : abstractC1474sx, (i & 4) != 0 ? null : interfaceC0926jk0, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
