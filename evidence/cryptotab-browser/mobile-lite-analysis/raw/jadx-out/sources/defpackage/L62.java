package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L62 extends F62 {
    public final Runnable v;

    public L62(Runnable runnable, long j, I62 i62) {
        super(j, i62);
        this.v = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.v.run();
        } finally {
            this.u.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.v;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(hV.a(runnable));
        sb.append(", ");
        sb.append(this.t);
        sb.append(", ");
        sb.append(this.u);
        sb.append(']');
        return sb.toString();
    }
}
