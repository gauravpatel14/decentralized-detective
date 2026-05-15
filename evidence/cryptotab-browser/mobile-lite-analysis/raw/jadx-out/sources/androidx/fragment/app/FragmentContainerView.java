package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0305Yp1;
import defpackage.AbstractC0604eo2;
import defpackage.BN0;
import defpackage.C0383aw2;
import defpackage.C0665fi0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList t;
    public final ArrayList u;
    public View.OnApplyWindowInsetsListener v;
    public boolean w;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void a(View view) {
        if (this.u.contains(view)) {
            this.t.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(AbstractC0132Lp1.fragment_container_view_tag);
        if ((tag instanceof n ? (n) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C0383aw2 c0383aw2G = C0383aw2.g(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.v;
        C0383aw2 c0383aw2G2 = onApplyWindowInsetsListener != null ? C0383aw2.g(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : AbstractC0604eo2.i(this, c0383aw2G);
        if (!c0383aw2G2.a.m()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                AbstractC0604eo2.b(getChildAt(i), c0383aw2G2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.w) {
            Iterator it = this.t.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        if (this.w) {
            ArrayList arrayList = this.t;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        this.u.remove(view);
        if (this.t.remove(view)) {
            this.w = true;
        }
        super.endViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            }
            a(getChildAt(childCount));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public final void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.v = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            this.u.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, s sVar) {
        View view;
        super(context, attributeSet);
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.w = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        n nVarB = sVar.B(id);
        if (classAttribute != null && nVarB == null) {
            if (id == -1) {
                throw new IllegalStateException(BN0.a("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            C0665fi0 c0665fi0G = sVar.G();
            context.getClassLoader();
            n nVarA = c0665fi0G.a(classAttribute);
            nVarA.mFragmentId = id;
            nVarA.mContainerId = id;
            nVarA.mTag = string;
            nVarA.mFragmentManager = sVar;
            nVarA.mHost = sVar.w;
            nVarA.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(sVar);
            aVar.p = true;
            nVarA.mContainer = this;
            nVarA.mInDynamicContainer = true;
            aVar.d(getId(), nVarA, string, 1);
            if (!aVar.g) {
                aVar.h = false;
                aVar.r.z(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        for (u uVar : sVar.c.d()) {
            n nVar = uVar.c;
            if (nVar.mContainerId == getId() && (view = nVar.mView) != null && view.getParent() == null) {
                nVar.mContainer = this;
                uVar.a();
                uVar.g();
            }
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }
}
