package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ol0 {
    public int a;
    public int b;
    public int[] c;
    public int d;

    public final void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.d;
        int i4 = i3 * 2;
        int[] iArr = this.c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.c;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.d++;
    }

    public final void b(RecyclerView recyclerView, boolean z) {
        this.d = 0;
        int[] iArr = this.c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        AbstractC0306Yr1 abstractC0306Yr1 = recyclerView.G;
        if (recyclerView.F == null || abstractC0306Yr1 == null || !abstractC0306Yr1.i) {
            return;
        }
        if (z) {
            if (!recyclerView.x.g()) {
                abstractC0306Yr1.i(recyclerView.F.b(), this);
            }
        } else if (!recyclerView.S()) {
            abstractC0306Yr1.h(this.a, this.b, recyclerView.B0, this);
        }
        int i = this.d;
        if (i > abstractC0306Yr1.j) {
            abstractC0306Yr1.j = i;
            abstractC0306Yr1.k = z;
            recyclerView.v.m();
        }
    }
}
