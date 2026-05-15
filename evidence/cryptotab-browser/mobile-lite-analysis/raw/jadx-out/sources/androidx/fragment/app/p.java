package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import defpackage.AbstractC0092Hi0;
import defpackage.AbstractC0305Yp1;
import defpackage.BN0;
import defpackage.C0665fi0;
import defpackage.Gi0;
import defpackage.Xh0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements LayoutInflater.Factory2 {
    public final s t;

    public p(s sVar) {
        this.t = sVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        u uVarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        s sVar = this.t;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, sVar);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0305Yp1.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(AbstractC0305Yp1.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = n.class.isAssignableFrom(C0665fi0.b(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                n nVarB = resourceId != -1 ? sVar.B(resourceId) : null;
                if (nVarB == null && string != null) {
                    nVarB = sVar.C(string);
                }
                if (nVarB == null && id != -1) {
                    nVarB = sVar.B(id);
                }
                if (nVarB == null) {
                    C0665fi0 c0665fi0G = sVar.G();
                    context.getClassLoader();
                    nVarB = c0665fi0G.a(attributeValue);
                    nVarB.mFromLayout = true;
                    nVarB.mFragmentId = resourceId != 0 ? resourceId : id;
                    nVarB.mContainerId = id;
                    nVarB.mTag = string;
                    nVarB.mInLayout = true;
                    nVarB.mFragmentManager = sVar;
                    Xh0 xh0 = sVar.w;
                    nVarB.mHost = xh0;
                    nVarB.onInflate((Context) xh0.u, attributeSet, nVarB.mSavedFragmentState);
                    uVarF = sVar.a(nVarB);
                } else {
                    if (nVarB.mInLayout) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    nVarB.mInLayout = true;
                    nVarB.mFragmentManager = sVar;
                    Xh0 xh02 = sVar.w;
                    nVarB.mHost = xh02;
                    nVarB.onInflate((Context) xh02.u, attributeSet, nVarB.mSavedFragmentState);
                    uVarF = sVar.f(nVarB);
                }
                ViewGroup viewGroup = (ViewGroup) view;
                Gi0 gi0 = AbstractC0092Hi0.a;
                new FragmentTagUsageViolation("Attempting to use <fragment> tag to add fragment " + nVarB + " to container " + viewGroup);
                AbstractC0092Hi0.a(nVarB).getClass();
                nVarB.mContainer = viewGroup;
                uVarF.g();
                uVarF.f();
                View view2 = nVarB.mView;
                if (view2 == null) {
                    throw new IllegalStateException(BN0.a("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (nVarB.mView.getTag() == null) {
                    nVarB.mView.setTag(string);
                }
                nVarB.mView.addOnAttachStateChangeListener(new o(this, uVarF));
                return nVarB.mView;
            }
        }
        return null;
    }
}
