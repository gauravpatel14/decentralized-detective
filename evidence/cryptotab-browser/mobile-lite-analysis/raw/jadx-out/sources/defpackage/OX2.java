package defpackage;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OX2 {
    public VQ2 a;
    public ArrayList b;
    public ArrayList c;
    public long d;
    public final /* synthetic */ QX2 e;

    public /* synthetic */ OX2(QX2 qx2) {
        this.e = qx2;
    }

    public final boolean a(long j, C0471cQ2 c0471cQ2) {
        Preconditions.checkNotNull(c0471cQ2);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (!this.c.isEmpty() && ((((C0471cQ2) this.c.get(0)).n() / 1000) / 60) / 60 != ((c0471cQ2.n() / 1000) / 60) / 60) {
            return false;
        }
        long jC = this.d + ((long) c0471cQ2.c());
        QX2 qx2 = this.e;
        qx2.J();
        if (jC >= Math.max(0, ((Integer) AbstractC0579eO2.i.a(null)).intValue())) {
            return false;
        }
        this.d = jC;
        this.c.add(c0471cQ2);
        this.b.add(Long.valueOf(j));
        int size = this.c.size();
        qx2.J();
        return size < Math.max(1, ((Integer) AbstractC0579eO2.j.a(null)).intValue());
    }
}
