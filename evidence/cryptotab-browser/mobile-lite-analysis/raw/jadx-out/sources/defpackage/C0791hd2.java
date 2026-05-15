package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: renamed from: hd2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0791hd2 {
    public final Toolbar a;
    public int b;
    public final View c;
    public final Drawable d;
    public final Drawable e;
    public final Drawable f;
    public boolean g;
    public CharSequence h;
    public final CharSequence i;
    public CharSequence j;
    public Window.Callback k;
    public boolean l;
    public C3 m;
    public final int n;
    public final Drawable o;

    public C0791hd2(Toolbar toolbar, boolean z) {
        int i;
        Drawable drawable;
        int i2 = AbstractC0275Wp1.abc_action_bar_up_description;
        this.n = 0;
        this.a = toolbar;
        CharSequence charSequence = toolbar.Q;
        this.h = charSequence;
        this.i = toolbar.R;
        this.g = charSequence != null;
        this.f = toolbar.p();
        C1342qa2 c1342qa2F = C1342qa2.f(toolbar.getContext(), null, AbstractC0305Yp1.ActionBar, Ep1.actionBarStyle);
        this.o = c1342qa2F.b(AbstractC0305Yp1.ActionBar_homeAsUpIndicator);
        if (z) {
            int i3 = AbstractC0305Yp1.ActionBar_title;
            TypedArray typedArray = c1342qa2F.b;
            CharSequence text = typedArray.getText(i3);
            if (!TextUtils.isEmpty(text)) {
                this.g = true;
                this.h = text;
                if ((this.b & 8) != 0) {
                    Toolbar toolbar2 = this.a;
                    toolbar2.G(text);
                    if (this.g) {
                        AbstractC0604eo2.p(text, toolbar2.getRootView());
                    }
                }
            }
            CharSequence text2 = typedArray.getText(AbstractC0305Yp1.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.b & 8) != 0) {
                    toolbar.F(text2);
                }
            }
            Drawable drawableB = c1342qa2F.b(AbstractC0305Yp1.ActionBar_logo);
            if (drawableB != null) {
                this.e = drawableB;
                d();
            }
            Drawable drawableB2 = c1342qa2F.b(AbstractC0305Yp1.ActionBar_icon);
            if (drawableB2 != null) {
                this.d = drawableB2;
                d();
            }
            if (this.f == null && (drawable = this.o) != null) {
                this.f = drawable;
                int i4 = this.b & 4;
                Toolbar toolbar3 = this.a;
                if (i4 != 0) {
                    toolbar3.D(drawable);
                } else {
                    toolbar3.D(null);
                }
            }
            a(typedArray.getInt(AbstractC0305Yp1.ActionBar_displayOptions, 0));
            int resourceId = typedArray.getResourceId(AbstractC0305Yp1.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.c;
                if (view != null && (this.b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.c = viewInflate;
                if (viewInflate != null && (this.b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                a(this.b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(AbstractC0305Yp1.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(AbstractC0305Yp1.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.c();
                toolbar.M.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(AbstractC0305Yp1.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.E = resourceId2;
                AppCompatTextView appCompatTextView = toolbar.u;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(AbstractC0305Yp1.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.F = resourceId3;
                AppCompatTextView appCompatTextView2 = toolbar.v;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(AbstractC0305Yp1.ActionBar_popupTheme, 0);
            if (resourceId4 != 0 && toolbar.D != resourceId4) {
                toolbar.D = resourceId4;
                if (resourceId4 == 0) {
                    toolbar.C = toolbar.getContext();
                } else {
                    toolbar.C = new ContextThemeWrapper(toolbar.getContext(), resourceId4);
                }
            }
        } else {
            if (toolbar.p() != null) {
                this.o = toolbar.p();
                i = 15;
            } else {
                i = 11;
            }
            this.b = i;
        }
        c1342qa2F.g();
        if (i2 != this.n) {
            this.n = i2;
            C1285pb c1285pb = toolbar.w;
            if (TextUtils.isEmpty(c1285pb != null ? c1285pb.getContentDescription() : null)) {
                b(this.n);
            }
        }
        C1285pb c1285pb2 = toolbar.w;
        this.j = c1285pb2 != null ? c1285pb2.getContentDescription() : null;
        toolbar.E(new ViewOnClickListenerC0661fd2(this));
    }

    public final void a(int i) {
        View view;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    c();
                }
                int i3 = this.b & 4;
                Toolbar toolbar = this.a;
                if (i3 != 0) {
                    Drawable drawable = this.f;
                    if (drawable == null) {
                        drawable = this.o;
                    }
                    toolbar.D(drawable);
                } else {
                    toolbar.D(null);
                }
            }
            if ((i2 & 3) != 0) {
                d();
            }
            int i4 = i2 & 8;
            Toolbar toolbar2 = this.a;
            if (i4 != 0) {
                if ((i & 8) != 0) {
                    toolbar2.G(this.h);
                    toolbar2.F(this.i);
                } else {
                    toolbar2.G(null);
                    toolbar2.F(null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.c) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void b(int i) {
        this.j = i == 0 ? null : this.a.getContext().getString(i);
        c();
    }

    public final void c() {
        if ((this.b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.j);
            Toolbar toolbar = this.a;
            if (zIsEmpty) {
                toolbar.B(this.n);
            } else {
                toolbar.C(this.j);
            }
        }
    }

    public final void d() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.e) == null) {
            drawable = this.d;
        }
        this.a.A(drawable);
    }
}
