package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nA0 extends AbstractC0262Vr1 implements InterfaceC0382as1 {
    public Rect A;
    public long B;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final AbstractC0882jA0 m;
    public int o;
    public int q;
    public RecyclerView r;
    public VelocityTracker t;
    public ArrayList u;
    public ArrayList v;
    public GestureDetector x;
    public kA0 y;
    public final ArrayList a = new ArrayList();
    public final float[] b = new float[2];
    public ps1 c = null;
    public int l = -1;
    public int n = 0;
    public final ArrayList p = new ArrayList();
    public final RunnableC0559eA0 s = new RunnableC0559eA0(this);
    public View w = null;
    public final C0620fA0 z = new C0620fA0(this);

    public nA0(AbstractC0882jA0 abstractC0882jA0) {
        this.m = abstractC0882jA0;
    }

    public static boolean q(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    @Override // defpackage.InterfaceC0382as1
    public final void d(View view) {
        s(view);
        ps1 ps1VarM = this.r.M(view);
        if (ps1VarM == null) {
            return;
        }
        ps1 ps1Var = this.c;
        if (ps1Var != null && ps1VarM == ps1Var) {
            t(null, 0);
            return;
        }
        n(ps1VarM, false);
        if (this.a.remove(ps1VarM.t)) {
            this.m.b(this.r, ps1VarM);
        }
    }

    @Override // defpackage.AbstractC0262Vr1
    public final void g(Rect rect, View view, RecyclerView recyclerView, ms1 ms1Var) {
        rect.setEmpty();
    }

    @Override // defpackage.AbstractC0262Vr1
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.c != null) {
            float[] fArr = this.b;
            p(fArr);
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        ps1 ps1Var = this.c;
        ArrayList arrayList = this.p;
        int i = this.n;
        AbstractC0882jA0 abstractC0882jA0 = this.m;
        abstractC0882jA0.getClass();
        int i2 = 0;
        for (int size = arrayList.size(); i2 < size; size = size) {
            C0686gA0 c0686gA0 = (C0686gA0) arrayList.get(i2);
            float f4 = c0686gA0.t;
            float f5 = c0686gA0.v;
            ps1 ps1Var2 = c0686gA0.x;
            if (f4 == f5) {
                c0686gA0.B = ps1Var2.t.getTranslationX();
            } else {
                c0686gA0.B = AbstractC0146Mm2.a(f5, f4, c0686gA0.F, f4);
            }
            float f6 = c0686gA0.u;
            float f7 = c0686gA0.w;
            if (f6 == f7) {
                c0686gA0.C = ps1Var2.t.getTranslationY();
            } else {
                c0686gA0.C = AbstractC0146Mm2.a(f7, f6, c0686gA0.F, f6);
            }
            int iSave = canvas.save();
            abstractC0882jA0.k(canvas, recyclerView, c0686gA0.x, c0686gA0.B, c0686gA0.C, c0686gA0.y, false);
            canvas.restoreToCount(iSave);
            i2++;
        }
        if (ps1Var != null) {
            int iSave2 = canvas.save();
            abstractC0882jA0.k(canvas, recyclerView, ps1Var, f, f2, i, true);
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // defpackage.AbstractC0262Vr1
    public final void i(Canvas canvas, RecyclerView recyclerView) {
        boolean z = false;
        if (this.c != null) {
            float[] fArr = this.b;
            p(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
        }
        ps1 ps1Var = this.c;
        ArrayList arrayList = this.p;
        this.m.getClass();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0686gA0 c0686gA0 = (C0686gA0) arrayList.get(i);
            int iSave = canvas.save();
            View view = c0686gA0.x.t;
            canvas.restoreToCount(iSave);
        }
        if (ps1Var != null) {
            canvas.restoreToCount(canvas.save());
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            C0686gA0 c0686gA02 = (C0686gA0) arrayList.get(i2);
            boolean z2 = c0686gA02.E;
            if (z2 && !c0686gA02.A) {
                arrayList.remove(i2);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public final void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        C0620fA0 c0620fA0 = this.z;
        if (recyclerView2 != null) {
            recyclerView2.k0(this);
            this.r.l0(c0620fA0);
            ArrayList arrayList = this.r.W;
            if (arrayList != null) {
                arrayList.remove(this);
            }
            ArrayList arrayList2 = this.p;
            int size = arrayList2.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                C0686gA0 c0686gA0 = (C0686gA0) arrayList2.get(0);
                c0686gA0.z.cancel();
                this.m.b(this.r, c0686gA0.x);
            }
            arrayList2.clear();
            this.w = null;
            VelocityTracker velocityTracker = this.t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.t = null;
            }
            kA0 ka0 = this.y;
            if (ka0 != null) {
                ka0.a = false;
                this.y = null;
            }
            if (this.x != null) {
                this.x = null;
            }
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f = resources.getDimension(Hp1.item_touch_helper_swipe_escape_velocity);
            this.g = resources.getDimension(Hp1.item_touch_helper_swipe_escape_max_velocity);
            this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
            this.r.i(this);
            this.r.K.add(c0620fA0);
            this.r.j(this);
            this.y = new kA0(this);
            this.x = new GestureDetector(this.r.getContext(), this.y);
        }
    }

    public final int k(ps1 ps1Var, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        AbstractC0882jA0 abstractC0882jA0 = this.m;
        if (velocityTracker != null && this.l > -1) {
            float f = this.g;
            abstractC0882jA0.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.f && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float f2 = abstractC0882jA0.f() * this.r.getWidth();
        if ((i & i2) == 0 || Math.abs(this.h) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void l(int i, int i2, MotionEvent motionEvent) {
        View viewO;
        if (this.c == null && i == 2 && this.n != 2) {
            AbstractC0882jA0 abstractC0882jA0 = this.m;
            if (abstractC0882jA0.h()) {
                RecyclerView recyclerView = this.r;
                if (recyclerView.k0 == 1) {
                    return;
                }
                AbstractC0306Yr1 abstractC0306Yr1 = recyclerView.G;
                int i3 = this.l;
                ps1 ps1VarM = null;
                if (i3 != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                    float x = motionEvent.getX(iFindPointerIndex) - this.d;
                    float y = motionEvent.getY(iFindPointerIndex) - this.e;
                    float fAbs = Math.abs(x);
                    float fAbs2 = Math.abs(y);
                    float f = this.q;
                    if ((fAbs >= f || fAbs2 >= f) && ((fAbs <= fAbs2 || !abstractC0306Yr1.d()) && ((fAbs2 <= fAbs || !abstractC0306Yr1.e()) && (viewO = o(motionEvent)) != null))) {
                        ps1VarM = this.r.M(viewO);
                    }
                }
                if (ps1VarM == null) {
                    return;
                }
                RecyclerView recyclerView2 = this.r;
                int iC = (AbstractC0882jA0.c(abstractC0882jA0.e(recyclerView2, ps1VarM), recyclerView2.getLayoutDirection()) & 65280) >> 8;
                if (iC == 0) {
                    return;
                }
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                float f2 = x2 - this.d;
                float f3 = y2 - this.e;
                float fAbs3 = Math.abs(f2);
                float fAbs4 = Math.abs(f3);
                float f4 = this.q;
                if (fAbs3 >= f4 || fAbs4 >= f4) {
                    if (fAbs3 > fAbs4) {
                        if (f2 < 0.0f && (iC & 4) == 0) {
                            return;
                        }
                        if (f2 > 0.0f && (iC & 8) == 0) {
                            return;
                        }
                    } else {
                        if (f3 < 0.0f && (iC & 1) == 0) {
                            return;
                        }
                        if (f3 > 0.0f && (iC & 2) == 0) {
                            return;
                        }
                    }
                    this.i = 0.0f;
                    this.h = 0.0f;
                    this.l = motionEvent.getPointerId(0);
                    t(ps1VarM, 1);
                }
            }
        }
    }

    public final int m(ps1 ps1Var, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        AbstractC0882jA0 abstractC0882jA0 = this.m;
        if (velocityTracker != null && this.l > -1) {
            float f = this.g;
            abstractC0882jA0.getClass();
            velocityTracker.computeCurrentVelocity(1000, f);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.f && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float f2 = abstractC0882jA0.f() * this.r.getHeight();
        if ((i & i2) == 0 || Math.abs(this.i) <= f2) {
            return 0;
        }
        return i2;
    }

    public final void n(ps1 ps1Var, boolean z) {
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0686gA0 c0686gA0 = (C0686gA0) arrayList.get(size);
            if (c0686gA0.x == ps1Var) {
                c0686gA0.D |= z;
                if (!c0686gA0.E) {
                    c0686gA0.z.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View o(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        ps1 ps1Var = this.c;
        if (ps1Var != null) {
            float f = this.j + this.h;
            float f2 = this.k + this.i;
            View view = ps1Var.t;
            if (q(view, x, y, f, f2)) {
                return view;
            }
        }
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0686gA0 c0686gA0 = (C0686gA0) arrayList.get(size);
            View view2 = c0686gA0.x.t;
            if (q(view2, x, y, c0686gA0.B, c0686gA0.C)) {
                return view2;
            }
        }
        RecyclerView recyclerView = this.r;
        for (int iE = recyclerView.y.e() - 1; iE >= 0; iE--) {
            View viewD = recyclerView.y.d(iE);
            float translationX = viewD.getTranslationX();
            float translationY = viewD.getTranslationY();
            if (x >= viewD.getLeft() + translationX && x <= viewD.getRight() + translationX && y >= viewD.getTop() + translationY && y <= viewD.getBottom() + translationY) {
                return viewD;
            }
        }
        return null;
    }

    public final void p(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.c.t.getLeft();
        } else {
            fArr[0] = this.c.t.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.c.t.getTop();
        } else {
            fArr[1] = this.c.t.getTranslationY();
        }
    }

    public final void r(ps1 ps1Var) {
        int i;
        int i2;
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int iAbs4;
        AbstractC0306Yr1 abstractC0306Yr1;
        int i3;
        int i4;
        int i5;
        if (!this.r.isLayoutRequested() && this.n == 2) {
            AbstractC0882jA0 abstractC0882jA0 = this.m;
            abstractC0882jA0.getClass();
            int i6 = (int) (this.j + this.h);
            int i7 = (int) (this.k + this.i);
            float fAbs = Math.abs(i7 - ps1Var.t.getTop());
            View view = ps1Var.t;
            if (fAbs >= view.getHeight() * 0.5f || Math.abs(i6 - view.getLeft()) >= view.getWidth() * 0.5f) {
                ArrayList arrayList = this.u;
                if (arrayList == null) {
                    this.u = new ArrayList();
                    this.v = new ArrayList();
                } else {
                    arrayList.clear();
                    this.v.clear();
                }
                int iRound = Math.round(this.j + this.h);
                int iRound2 = Math.round(this.k + this.i);
                int width = view.getWidth() + iRound;
                int height = view.getHeight() + iRound2;
                int i8 = (iRound + width) / 2;
                int i9 = (iRound2 + height) / 2;
                AbstractC0306Yr1 abstractC0306Yr12 = this.r.G;
                int iV = abstractC0306Yr12.v();
                int i10 = 0;
                while (i10 < iV) {
                    View viewU = abstractC0306Yr12.u(i10);
                    if (viewU == view) {
                        i3 = iRound;
                        i4 = iRound2;
                        i5 = width;
                        abstractC0306Yr1 = abstractC0306Yr12;
                    } else {
                        abstractC0306Yr1 = abstractC0306Yr12;
                        if (viewU.getBottom() < iRound2 || viewU.getTop() > height || viewU.getRight() < iRound || viewU.getLeft() > width) {
                            i3 = iRound;
                        } else {
                            ps1 ps1VarM = this.r.M(viewU);
                            i3 = iRound;
                            if (abstractC0882jA0.a(this.c, ps1VarM)) {
                                int iAbs5 = Math.abs(i8 - ((viewU.getRight() + viewU.getLeft()) / 2));
                                int iAbs6 = Math.abs(i9 - ((viewU.getBottom() + viewU.getTop()) / 2));
                                int i11 = (iAbs6 * iAbs6) + (iAbs5 * iAbs5);
                                int size = this.u.size();
                                i4 = iRound2;
                                i5 = width;
                                int i12 = 0;
                                int i13 = 0;
                                while (i12 < size) {
                                    int i14 = size;
                                    if (i11 <= ((Integer) this.v.get(i12)).intValue()) {
                                        break;
                                    }
                                    i13++;
                                    i12++;
                                    size = i14;
                                }
                                this.u.add(i13, ps1VarM);
                                this.v.add(i13, Integer.valueOf(i11));
                            }
                        }
                        i4 = iRound2;
                        i5 = width;
                    }
                    i10++;
                    abstractC0306Yr12 = abstractC0306Yr1;
                    iRound = i3;
                    iRound2 = i4;
                    width = i5;
                }
                ArrayList arrayList2 = this.u;
                if (arrayList2.size() == 0) {
                    return;
                }
                int width2 = view.getWidth() + i6;
                int height2 = view.getHeight() + i7;
                int left2 = i6 - view.getLeft();
                int top2 = i7 - view.getTop();
                int size2 = arrayList2.size();
                ps1 ps1Var2 = null;
                int i15 = -1;
                int i16 = 0;
                while (i16 < size2) {
                    ps1 ps1Var3 = (ps1) arrayList2.get(i16);
                    ArrayList arrayList3 = arrayList2;
                    if (left2 > 0) {
                        int right = ps1Var3.t.getRight() - width2;
                        i = width2;
                        if (right < 0) {
                            i2 = size2;
                            if (ps1Var3.t.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i15) {
                                i15 = iAbs4;
                                ps1Var2 = ps1Var3;
                            }
                        }
                        if (left2 < 0 && (left = ps1Var3.t.getLeft() - i6) > 0 && ps1Var3.t.getLeft() < view.getLeft() && (iAbs3 = Math.abs(left)) > i15) {
                            i15 = iAbs3;
                            ps1Var2 = ps1Var3;
                        }
                        if (top2 < 0 && (top = ps1Var3.t.getTop() - i7) > 0 && ps1Var3.t.getTop() < view.getTop() && (iAbs2 = Math.abs(top)) > i15) {
                            i15 = iAbs2;
                            ps1Var2 = ps1Var3;
                        }
                        if (top2 <= 0 && (bottom = ps1Var3.t.getBottom() - height2) < 0 && ps1Var3.t.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i15) {
                            i15 = iAbs;
                            ps1Var2 = ps1Var3;
                        }
                        i16++;
                        arrayList2 = arrayList3;
                        width2 = i;
                        size2 = i2;
                    } else {
                        i = width2;
                    }
                    i2 = size2;
                    if (left2 < 0) {
                        i15 = iAbs3;
                        ps1Var2 = ps1Var3;
                    }
                    if (top2 < 0) {
                        i15 = iAbs2;
                        ps1Var2 = ps1Var3;
                    }
                    if (top2 <= 0) {
                    }
                    i16++;
                    arrayList2 = arrayList3;
                    width2 = i;
                    size2 = i2;
                }
                if (ps1Var2 == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int iD = ps1Var2.d();
                ps1Var.d();
                if (abstractC0882jA0.l(ps1Var, ps1Var2)) {
                    RecyclerView recyclerView = this.r;
                    AbstractC0306Yr1 abstractC0306Yr13 = recyclerView.G;
                    boolean z = abstractC0306Yr13 instanceof LinearLayoutManager;
                    View view2 = ps1Var2.t;
                    if (!z) {
                        if (abstractC0306Yr13.d()) {
                            if (AbstractC0306Yr1.A(view2) <= recyclerView.getPaddingLeft()) {
                                recyclerView.q0(iD);
                            }
                            if (AbstractC0306Yr1.B(view2) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                                recyclerView.q0(iD);
                            }
                        }
                        if (abstractC0306Yr13.e()) {
                            if (AbstractC0306Yr1.C(view2) <= recyclerView.getPaddingTop()) {
                                recyclerView.q0(iD);
                            }
                            if (AbstractC0306Yr1.y(view2) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                                recyclerView.q0(iD);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) abstractC0306Yr13;
                    linearLayoutManager.c("Cannot drop a view during a scroll or layout calculation");
                    linearLayoutManager.M0();
                    linearLayoutManager.e1();
                    int I = AbstractC0306Yr1.I(view);
                    int I2 = AbstractC0306Yr1.I(view2);
                    byte b = I < I2 ? (byte) 1 : (byte) -1;
                    if (linearLayoutManager.u) {
                        if (b == 1) {
                            linearLayoutManager.g1(I2, linearLayoutManager.r.g() - (linearLayoutManager.r.c(view) + linearLayoutManager.r.e(view2)));
                            return;
                        } else {
                            linearLayoutManager.g1(I2, linearLayoutManager.r.g() - linearLayoutManager.r.b(view2));
                            return;
                        }
                    }
                    if (b == -1) {
                        linearLayoutManager.g1(I2, linearLayoutManager.r.e(view2));
                    } else {
                        linearLayoutManager.g1(I2, linearLayoutManager.r.b(view2) - linearLayoutManager.r.c(view));
                    }
                }
            }
        }
    }

    public final void s(View view) {
        if (view == this.w) {
            this.w = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(defpackage.ps1 r22, int r23) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nA0.t(ps1, int):void");
    }

    public final void u(int i, int i2, MotionEvent motionEvent) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.d;
        this.h = f;
        this.i = y - this.e;
        if ((i & 4) == 0) {
            this.h = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    @Override // defpackage.InterfaceC0382as1
    public final void c(View view) {
    }
}
