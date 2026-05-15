package defpackage;

import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class os1 implements Runnable {
    public int t;
    public int u;
    public OverScroller v;
    public Interpolator w;
    public boolean x;
    public boolean y;
    public final /* synthetic */ RecyclerView z;

    public os1(RecyclerView recyclerView) {
        this.z = recyclerView;
        Nr1 nr1 = RecyclerView.b1;
        this.w = nr1;
        this.x = false;
        this.y = false;
        this.v = new OverScroller(recyclerView.getContext(), nr1);
    }

    public final void a(int i, int i2) {
        RecyclerView recyclerView = this.z;
        recyclerView.w0(2);
        this.u = 0;
        this.t = 0;
        Interpolator interpolator = this.w;
        Nr1 nr1 = RecyclerView.b1;
        if (interpolator != nr1) {
            this.w = nr1;
            this.v = new OverScroller(recyclerView.getContext(), nr1);
        }
        this.v.fling(0, 0, i, i2, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        b();
    }

    public final void b() {
        if (this.x) {
            this.y = true;
            return;
        }
        RecyclerView recyclerView = this.z;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = AbstractC0604eo2.a;
        recyclerView.postOnAnimation(this);
    }

    public final void c(int i, int i2, int i3, BaseInterpolator baseInterpolator) {
        RecyclerView recyclerView = this.z;
        if (i3 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z) {
                iAbs = iAbs2;
            }
            i3 = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        }
        int i4 = i3;
        Interpolator interpolator = baseInterpolator;
        if (baseInterpolator == null) {
            interpolator = RecyclerView.b1;
        }
        if (this.w != interpolator) {
            this.w = interpolator;
            this.v = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.u = 0;
        this.t = 0;
        recyclerView.w0(2);
        this.v.startScroll(0, 0, i, i2, i4);
        b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        RecyclerView recyclerView = this.z;
        if (recyclerView.G == null) {
            recyclerView.removeCallbacks(this);
            this.v.abortAnimation();
            return;
        }
        this.y = false;
        this.x = true;
        recyclerView.q();
        OverScroller overScroller = this.v;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i3 = currX - this.t;
            int i4 = currY - this.u;
            this.t = currX;
            this.u = currY;
            int iP = RecyclerView.p(i3, recyclerView.f0, recyclerView.h0, recyclerView.getWidth());
            int iP2 = RecyclerView.p(i4, recyclerView.g0, recyclerView.i0, recyclerView.getHeight());
            int[] iArr = recyclerView.N0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean zC = recyclerView.R().c(iP, iP2, 1, iArr, null);
            int[] iArr2 = recyclerView.N0;
            if (zC) {
                iP -= iArr2[0];
                iP2 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.o(iP, iP2);
            }
            if (recyclerView.F != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.p0(iP, iP2, iArr2);
                i = iArr2[0];
                i2 = iArr2[1];
                iP -= i;
                iP2 -= i2;
                AF0 af0 = recyclerView.G.e;
                if (af0 != null && !af0.d && af0.e) {
                    int iB = recyclerView.B0.b();
                    if (iB == 0) {
                        af0.i();
                    } else if (af0.a >= iB) {
                        af0.a = iB - 1;
                        af0.g(i, i2);
                    } else {
                        af0.g(i, i2);
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if (!recyclerView.f19J.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.N0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.R().d(i, i2, iP, iP2, null, 1, iArr3);
            int i5 = iP - iArr2[0];
            int i6 = iP2 - iArr2[1];
            if (i != 0 || i2 != 0) {
                recyclerView.w(i, i2);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
            AF0 af02 = recyclerView.G.e;
            if ((af02 == null || !af02.d) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                    if (i6 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i6 <= 0) {
                        currVelocity = 0;
                    }
                    if (i7 < 0) {
                        recyclerView.y();
                        if (recyclerView.f0.isFinished()) {
                            recyclerView.f0.onAbsorb(-i7);
                        }
                    } else if (i7 > 0) {
                        recyclerView.z();
                        if (recyclerView.h0.isFinished()) {
                            recyclerView.h0.onAbsorb(i7);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.A();
                        if (recyclerView.g0.isFinished()) {
                            recyclerView.g0.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.x();
                        if (recyclerView.i0.isFinished()) {
                            recyclerView.i0.onAbsorb(currVelocity);
                        }
                    }
                    if (i7 != 0 || currVelocity != 0) {
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                if (RecyclerView.Z0) {
                    ol0 ol0Var = recyclerView.A0;
                    int[] iArr4 = ol0Var.c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    ol0Var.d = 0;
                }
            } else {
                b();
                RunnableC1349ql0 runnableC1349ql0 = recyclerView.z0;
                if (runnableC1349ql0 != null) {
                    runnableC1349ql0.a(recyclerView, i, i2);
                }
            }
            if (AbstractC1808yv.c()) {
                AbstractC0227Sr1.a(recyclerView, Math.abs(overScroller.getCurrVelocity()));
            }
        }
        AF0 af03 = recyclerView.G.e;
        if (af03 != null && af03.d) {
            af03.g(0, 0);
        }
        this.x = false;
        if (!this.y) {
            recyclerView.w0(0);
            recyclerView.R().h(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
