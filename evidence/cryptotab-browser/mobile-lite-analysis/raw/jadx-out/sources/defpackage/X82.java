package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class X82 implements InterfaceC0465cO {
    public final ThreadLocal t;

    public X82(ThreadLocal threadLocal) {
        this.t = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof X82) && lz0.a(this.t, ((X82) obj).t);
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.t + ')';
    }
}
