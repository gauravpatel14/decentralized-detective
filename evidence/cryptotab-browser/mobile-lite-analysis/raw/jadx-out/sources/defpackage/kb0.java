package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kb0 extends cs1 {
    public final /* synthetic */ C1163nb0 a;

    public kb0(C1163nb0 c1163nb0) {
        this.a = c1163nb0;
    }

    @Override // defpackage.cs1
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C1163nb0 c1163nb0 = this.a;
        int iComputeVerticalScrollRange = c1163nb0.s.computeVerticalScrollRange();
        int i3 = c1163nb0.r;
        int i4 = iComputeVerticalScrollRange - i3;
        int i5 = c1163nb0.a;
        c1163nb0.t = i4 > 0 && i3 >= i5;
        int iComputeHorizontalScrollRange = c1163nb0.s.computeHorizontalScrollRange();
        int i6 = c1163nb0.q;
        boolean z = iComputeHorizontalScrollRange - i6 > 0 && i6 >= i5;
        c1163nb0.u = z;
        boolean z2 = c1163nb0.t;
        if (!z2 && !z) {
            if (c1163nb0.v != 0) {
                c1163nb0.m(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            c1163nb0.l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
            c1163nb0.k = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (c1163nb0.u) {
            float f2 = iComputeHorizontalScrollOffset;
            float f3 = i6;
            c1163nb0.o = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
            c1163nb0.n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
        }
        int i7 = c1163nb0.v;
        if (i7 == 0 || i7 == 1) {
            c1163nb0.m(1);
        }
    }
}
