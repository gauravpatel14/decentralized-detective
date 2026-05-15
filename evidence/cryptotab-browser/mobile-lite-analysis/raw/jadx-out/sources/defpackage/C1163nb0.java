package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: renamed from: nb0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1163nb0 extends AbstractC0262Vr1 implements bs1 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final RunnableC0915jb0 B;
    public final int a;
    public final int b;
    public final StateListDrawable c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public final RecyclerView s;
    public final ValueAnimator z;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];

    public C1163nb0(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        this.A = 0;
        RunnableC0915jb0 runnableC0915jb0 = new RunnableC0915jb0(this);
        this.B = runnableC0915jb0;
        kb0 kb0Var = new kb0(this);
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.a = i2;
        this.b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new lb0(this));
        valueAnimatorOfFloat.addUpdateListener(new mb0(this));
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.k0(this);
            this.s.l0(this);
            this.s.m0(kb0Var);
            this.s.removeCallbacks(runnableC0915jb0);
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            recyclerView.i(this);
            this.s.K.add(this);
            this.s.k(kb0Var);
        }
    }

    public static int l(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    @Override // defpackage.bs1
    public final void a(MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zK = k(motionEvent.getX(), motionEvent.getY());
            boolean zJ = j(motionEvent.getX(), motionEvent.getY());
            if (zK || zJ) {
                if (zJ) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zK) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                m(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            m(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            n();
            int i = this.w;
            int i2 = this.b;
            if (i == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.y;
                iArr[0] = i2;
                int i3 = this.q - i2;
                iArr[1] = i3;
                float fMax = Math.max(i2, Math.min(i3, x));
                if (Math.abs(this.o - fMax) >= 2.0f) {
                    int iL = l(this.p, fMax, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                    if (iL != 0) {
                        this.s.scrollBy(iL, 0);
                    }
                    this.p = fMax;
                }
            }
            if (this.w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.x;
                iArr2[0] = i2;
                int i4 = this.r - i2;
                iArr2[1] = i4;
                float fMax2 = Math.max(i2, Math.min(i4, y));
                if (Math.abs(this.l - fMax2) < 2.0f) {
                    return;
                }
                int iL2 = l(this.m, fMax2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                if (iL2 != 0) {
                    this.s.scrollBy(0, iL2);
                }
                this.m = fMax2;
            }
        }
    }

    @Override // defpackage.bs1
    public final boolean b(MotionEvent motionEvent) {
        int i = this.v;
        if (i == 1) {
            boolean zK = k(motionEvent.getX(), motionEvent.getY());
            boolean zJ = j(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zK && !zJ) {
                return false;
            }
            if (zJ) {
                this.w = 1;
                this.p = (int) motionEvent.getX();
            } else if (zK) {
                this.w = 2;
                this.m = (int) motionEvent.getY();
            }
            m(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // defpackage.AbstractC0262Vr1
    public final void i(Canvas canvas, RecyclerView recyclerView) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            m(0);
            return;
        }
        if (this.A != 0) {
            if (this.t) {
                int i = this.q;
                int i2 = this.e;
                int i3 = i - i2;
                int i4 = this.l;
                int i5 = this.k;
                int i6 = i4 - (i5 / 2);
                StateListDrawable stateListDrawable = this.c;
                stateListDrawable.setBounds(0, 0, i2, i5);
                int i7 = this.r;
                int i8 = this.f;
                Drawable drawable = this.d;
                drawable.setBounds(0, 0, i8, i7);
                if (this.s.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i2, i6);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i2, -i6);
                } else {
                    canvas.translate(i3, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i6);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i3, -i6);
                }
            }
            if (this.u) {
                int i9 = this.r;
                int i10 = this.i;
                int i11 = i9 - i10;
                int i12 = this.o;
                int i13 = this.n;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable2 = this.g;
                stateListDrawable2.setBounds(0, 0, i13, i10);
                int i15 = this.q;
                int i16 = this.j;
                Drawable drawable2 = this.h;
                drawable2.setBounds(0, 0, i15, i16);
                canvas.translate(0.0f, i11);
                drawable2.draw(canvas);
                canvas.translate(i14, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i14, -i11);
            }
        }
    }

    public final boolean j(float f, float f2) {
        if (f2 >= this.r - this.i) {
            int i = this.o;
            int i2 = this.n;
            if (f >= i - (i2 / 2) && f <= (i2 / 2) + i) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(float f, float f2) {
        boolean z = this.s.getLayoutDirection() == 1;
        int i = this.e;
        if (z) {
            if (f > i) {
                return false;
            }
        } else if (f < this.q - i) {
            return false;
        }
        int i2 = this.l;
        int i3 = this.k / 2;
        return f2 >= ((float) (i2 - i3)) && f2 <= ((float) (i3 + i2));
    }

    public final void m(int i) {
        RunnableC0915jb0 runnableC0915jb0 = this.B;
        StateListDrawable stateListDrawable = this.c;
        if (i == 2 && this.v != 2) {
            stateListDrawable.setState(C);
            this.s.removeCallbacks(runnableC0915jb0);
        }
        if (i == 0) {
            this.s.invalidate();
        } else {
            n();
        }
        if (this.v == 2 && i != 2) {
            stateListDrawable.setState(D);
            this.s.removeCallbacks(runnableC0915jb0);
            this.s.postDelayed(runnableC0915jb0, 1200);
        } else if (i == 1) {
            this.s.removeCallbacks(runnableC0915jb0);
            this.s.postDelayed(runnableC0915jb0, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.v = i;
    }

    public final void n() {
        int i = this.A;
        ValueAnimator valueAnimator = this.z;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // defpackage.bs1
    public final void e(boolean z) {
    }
}
