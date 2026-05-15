package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ZG0 implements nI1 {
    public static final Method T;
    public static final Method U;
    public boolean B;
    public boolean C;
    public boolean D;
    public WG0 G;
    public View H;
    public AdapterView.OnItemClickListener I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f7J;
    public final Handler O;
    public Rect Q;
    public boolean R;
    public final C1459sb S;
    public final Context t;
    public ListAdapter u;
    public V30 v;
    public int y;
    public int z;
    public final int w = -2;
    public int x = -2;
    public final int A = 1002;
    public int E = 0;
    public final int F = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    public final VG0 K = new VG0(this, 1);
    public final YG0 L = new YG0(this);
    public final XG0 M = new XG0(this);
    public final VG0 N = new VG0(this, 0);
    public final Rect P = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                T = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                U = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ZG0(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        this.t = context;
        this.O = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.ListPopupWindow, i, 0);
        this.y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC0305Yp1.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC0305Yp1.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.z = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.B = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C1459sb c1459sb = new C1459sb(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.PopupWindow, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(AbstractC0305Yp1.PopupWindow_overlapAnchor)) {
            c1459sb.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(AbstractC0305Yp1.PopupWindow_overlapAnchor, false));
        }
        int i2 = AbstractC0305Yp1.PopupWindow_android_popupBackground;
        c1459sb.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(i2) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(i2, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(i2) : AbstractC1686wb.a(resourceId, context));
        typedArrayObtainStyledAttributes2.recycle();
        this.S = c1459sb;
        c1459sb.setInputMethodMode(1);
    }

    public void A(ListAdapter listAdapter) {
        WG0 wg0 = this.G;
        if (wg0 == null) {
            this.G = new WG0(this);
        } else {
            ListAdapter listAdapter2 = this.u;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(wg0);
            }
        }
        this.u = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.G);
        }
        V30 v30 = this.v;
        if (v30 != null) {
            v30.setAdapter(this.u);
        }
    }

    @Override // defpackage.nI1
    public final void a() {
        int i;
        int paddingBottom;
        V30 v30;
        V30 v302 = this.v;
        C1459sb c1459sb = this.S;
        Context context = this.t;
        if (v302 == null) {
            V30 v30B = b(context, !this.R);
            this.v = v30B;
            v30B.setAdapter(this.u);
            this.v.setOnItemClickListener(this.I);
            this.v.setFocusable(true);
            this.v.setFocusableInTouchMode(true);
            this.v.setOnItemSelectedListener(new TG0(this));
            this.v.setOnScrollListener(this.M);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f7J;
            if (onItemSelectedListener != null) {
                this.v.setOnItemSelectedListener(onItemSelectedListener);
            }
            c1459sb.setContentView(this.v);
        }
        Drawable background = c1459sb.getBackground();
        Rect rect = this.P;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.B) {
                this.z = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int maxAvailableHeight = c1459sb.getMaxAvailableHeight(this.H, this.z, c1459sb.getInputMethodMode() == 2);
        int i3 = this.w;
        if (i3 == -1) {
            paddingBottom = maxAvailableHeight + i;
        } else {
            int i4 = this.x;
            int iA = this.v.a(i4 != -2 ? i4 != -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), maxAvailableHeight);
            paddingBottom = iA + (iA > 0 ? this.v.getPaddingBottom() + this.v.getPaddingTop() + i : 0);
        }
        boolean z = this.S.getInputMethodMode() == 2;
        c1459sb.setWindowLayoutType(this.A);
        if (c1459sb.isShowing()) {
            if (this.H.isAttachedToWindow()) {
                int width = this.x;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.H.getWidth();
                }
                if (i3 == -1) {
                    i3 = z ? paddingBottom : -1;
                    if (z) {
                        c1459sb.setWidth(this.x == -1 ? -1 : 0);
                        c1459sb.setHeight(0);
                    } else {
                        c1459sb.setWidth(this.x == -1 ? -1 : 0);
                        c1459sb.setHeight(-1);
                    }
                } else if (i3 == -2) {
                    i3 = paddingBottom;
                }
                c1459sb.setOutsideTouchable(true);
                View view = this.H;
                int i5 = this.y;
                int i6 = this.z;
                if (width < 0) {
                    width = -1;
                }
                c1459sb.update(view, i5, i6, width, i3 < 0 ? -1 : i3);
                return;
            }
            return;
        }
        int width2 = this.x;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.H.getWidth();
        }
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = paddingBottom;
        }
        c1459sb.setWidth(width2);
        c1459sb.setHeight(i3);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = T;
            if (method != null) {
                try {
                    method.invoke(c1459sb, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            UG0.b(c1459sb);
        }
        c1459sb.setOutsideTouchable(true);
        c1459sb.setTouchInterceptor(this.L);
        if (this.D) {
            c1459sb.setOverlapAnchor(this.C);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = U;
            if (method2 != null) {
                try {
                    method2.invoke(c1459sb, this.Q);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            UG0.a(c1459sb, this.Q);
        }
        c1459sb.showAsDropDown(this.H, this.y, this.z, this.E);
        this.v.setSelection(-1);
        if ((!this.R || this.v.isInTouchMode()) && (v30 = this.v) != null) {
            v30.A = true;
            v30.requestLayout();
        }
        if (this.R) {
            return;
        }
        this.O.post(this.N);
    }

    public V30 b(Context context, boolean z) {
        return new V30(context, z);
    }

    public final void c(int i) {
        Drawable background = this.S.getBackground();
        if (background == null) {
            this.x = i;
            return;
        }
        Rect rect = this.P;
        background.getPadding(rect);
        this.x = rect.left + rect.right + i;
    }

    @Override // defpackage.nI1
    public final void dismiss() {
        C1459sb c1459sb = this.S;
        c1459sb.dismiss();
        c1459sb.setContentView(null);
        this.v = null;
        this.O.removeCallbacks(this.K);
    }

    @Override // defpackage.nI1
    public final V30 g() {
        return this.v;
    }

    @Override // defpackage.nI1
    public final boolean q() {
        return this.S.isShowing();
    }

    public final int r() {
        return this.y;
    }

    public final Drawable s() {
        return this.S.getBackground();
    }

    public final void u(Drawable drawable) {
        this.S.setBackgroundDrawable(drawable);
    }

    public final void v(int i) {
        this.z = i;
        this.B = true;
    }

    public final void x(int i) {
        this.y = i;
    }

    public final int y() {
        if (this.B) {
            return this.z;
        }
        return 0;
    }
}
