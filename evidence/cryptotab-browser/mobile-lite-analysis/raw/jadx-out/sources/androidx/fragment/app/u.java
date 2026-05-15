package androidx.fragment.app;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.strictmode.WrongFragmentContainerViolation;
import androidx.fragment.app.strictmode.WrongNestedHierarchyViolation;
import defpackage.AbstractC0068Fh0;
import defpackage.AbstractC0092Hi0;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0604eo2;
import defpackage.AbstractC1668wM1;
import defpackage.C0665fi0;
import defpackage.Ei0;
import defpackage.Gi0;
import defpackage.InterfaceC0105Io2;
import defpackage.S3;
import defpackage.Xh0;
import defpackage.Zh0;
import defpackage.aM1;
import defpackage.cF0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public final Zh0 a;
    public final v b;
    public final n c;
    public boolean d = false;
    public int e = -1;

    public u(Zh0 zh0, v vVar, n nVar) {
        this.a = zh0;
        this.b = vVar;
        this.c = nVar;
    }

    public final void a() {
        n nVar;
        View view;
        View view2;
        int iIndexOfChild = -1;
        n nVar2 = this.c;
        View view3 = nVar2.mContainer;
        while (true) {
            nVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(AbstractC0132Lp1.fragment_container_view_tag);
            n nVar3 = tag instanceof n ? (n) tag : null;
            if (nVar3 != null) {
                nVar = nVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        n parentFragment = nVar2.getParentFragment();
        if (nVar != null && !nVar.equals(parentFragment)) {
            int i = nVar2.mContainerId;
            Gi0 gi0 = AbstractC0092Hi0.a;
            new WrongNestedHierarchyViolation("Attempting to nest fragment " + nVar2 + " within the view of parent fragment " + nVar + " via container with ID " + i + " without using parent's childFragmentManager");
            AbstractC0092Hi0.a(nVar2).getClass();
        }
        v vVar = this.b;
        vVar.getClass();
        ViewGroup viewGroup = nVar2.mContainer;
        if (viewGroup != null) {
            ArrayList arrayList = vVar.a;
            int iIndexOf = arrayList.indexOf(nVar2);
            int i2 = iIndexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        n nVar4 = (n) arrayList.get(iIndexOf);
                        if (nVar4.mContainer == viewGroup && (view = nVar4.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    n nVar5 = (n) arrayList.get(i2);
                    if (nVar5.mContainer == viewGroup && (view2 = nVar5.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        nVar2.mContainer.addView(nVar2.mView, iIndexOfChild);
    }

    public final void b() {
        n nVar = this.c;
        n nVar2 = nVar.mTarget;
        u uVar = null;
        v vVar = this.b;
        if (nVar2 != null) {
            u uVar2 = (u) vVar.b.get(nVar2.mWho);
            if (uVar2 == null) {
                throw new IllegalStateException("Fragment " + nVar + " declared target fragment " + nVar.mTarget + " that does not belong to this FragmentManager!");
            }
            nVar.mTargetWho = nVar.mTarget.mWho;
            nVar.mTarget = null;
            uVar = uVar2;
        } else {
            String str = nVar.mTargetWho;
            if (str != null && (uVar = (u) vVar.b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(nVar);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(S3.a(sb, nVar.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (uVar != null) {
            uVar.g();
        }
        s sVar = nVar.mFragmentManager;
        nVar.mHost = sVar.w;
        nVar.mParentFragment = sVar.y;
        Zh0 zh0 = this.a;
        zh0.g(nVar, false);
        nVar.performAttach();
        zh0.b(nVar, false);
    }

    public final int c() {
        n nVar = this.c;
        if (nVar.mFragmentManager == null) {
            return nVar.mState;
        }
        int iMin = this.e;
        int iOrdinal = nVar.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (nVar.mFromLayout) {
            if (nVar.mInLayout) {
                iMin = Math.max(this.e, 2);
                View view = nVar.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, nVar.mState) : Math.min(iMin, 1);
            }
        }
        if (nVar.mInDynamicContainer && nVar.mContainer == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!nVar.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = nVar.mContainer;
        if (viewGroup != null) {
            g gVarJ = g.j(viewGroup, nVar.getParentFragmentManager());
            gVarJ.getClass();
            y yVarG = gVarJ.g(nVar);
            int i = yVarG != null ? yVarG.b : 0;
            y yVarH = gVarJ.h(nVar);
            i = yVarH != null ? yVarH.b : 0;
            int i2 = i == 0 ? -1 : AbstractC1668wM1.a[aM1.b(i)];
            if (i2 != -1 && i2 != 1) {
                i = i;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (nVar.mRemoving) {
            iMin = nVar.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (nVar.mDeferStart && nVar.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        return nVar.mTransitioning ? Math.max(iMin, 3) : iMin;
    }

    public final void d() {
        String resourceName;
        n nVar = this.c;
        if (nVar.mFromLayout) {
            return;
        }
        Bundle bundle = nVar.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = nVar.performGetLayoutInflater(bundle2);
        ViewGroup viewGroup2 = nVar.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = nVar.mContainerId;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException(AbstractC0068Fh0.a("Cannot create fragment ", nVar, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) nVar.mFragmentManager.x.b(i);
                if (viewGroup == null) {
                    if (!nVar.mRestored && !nVar.mInDynamicContainer) {
                        try {
                            resourceName = nVar.getResources().getResourceName(nVar.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(nVar.mContainerId) + " (" + resourceName + ") for fragment " + nVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    Gi0 gi0 = AbstractC0092Hi0.a;
                    new WrongFragmentContainerViolation("Attempting to add fragment " + nVar + " to container " + viewGroup + " which is not a FragmentContainerView");
                    AbstractC0092Hi0.a(nVar).getClass();
                }
            }
        }
        nVar.mContainer = viewGroup;
        nVar.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        View view = nVar.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            nVar.mView.setTag(AbstractC0132Lp1.fragment_container_view_tag, nVar);
            if (viewGroup != null) {
                a();
            }
            if (nVar.mHidden) {
                nVar.mView.setVisibility(8);
            }
            if (nVar.mView.isAttachedToWindow()) {
                View view2 = nVar.mView;
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                view2.requestApplyInsets();
            } else {
                View view3 = nVar.mView;
                view3.addOnAttachStateChangeListener(new Ei0(view3));
            }
            nVar.performViewCreated();
            this.a.m(nVar, nVar.mView, bundle2, false);
            int visibility = nVar.mView.getVisibility();
            nVar.setPostOnViewCreatedAlpha(nVar.mView.getAlpha());
            if (nVar.mContainer != null && visibility == 0) {
                View viewFindFocus = nVar.mView.findFocus();
                if (viewFindFocus != null) {
                    nVar.setFocusedView(viewFindFocus);
                }
                nVar.mView.setAlpha(0.0f);
            }
        }
        nVar.mState = 2;
    }

    public final void e() {
        n nVarB;
        n nVar = this.c;
        boolean zIsChangingConfigurations = true;
        boolean z = nVar.mRemoving && !nVar.isInBackStack();
        v vVar = this.b;
        if (z && !nVar.mBeingSaved) {
            vVar.i(nVar.mWho, null);
        }
        if (!z) {
            t tVar = vVar.d;
            if (!((tVar.b.containsKey(nVar.mWho) && tVar.e) ? tVar.f : true)) {
                String str = nVar.mTargetWho;
                if (str != null && (nVarB = vVar.b(str)) != null && nVarB.mRetainInstance) {
                    nVar.mTarget = nVarB;
                }
                nVar.mState = 0;
                return;
            }
        }
        Xh0 xh0 = nVar.mHost;
        if (xh0 instanceof InterfaceC0105Io2) {
            zIsChangingConfigurations = vVar.d.f;
        } else {
            FragmentActivity fragmentActivity = xh0.u;
            if (fragmentActivity != null) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if ((z && !nVar.mBeingSaved) || zIsChangingConfigurations) {
            t tVar2 = vVar.d;
            tVar2.getClass();
            tVar2.c(nVar.mWho, false);
        }
        nVar.performDestroy();
        this.a.d(nVar, false);
        for (u uVar : vVar.d()) {
            if (uVar != null) {
                String str2 = nVar.mWho;
                n nVar2 = uVar.c;
                if (str2.equals(nVar2.mTargetWho)) {
                    nVar2.mTarget = nVar;
                    nVar2.mTargetWho = null;
                }
            }
        }
        String str3 = nVar.mTargetWho;
        if (str3 != null) {
            nVar.mTarget = vVar.b(str3);
        }
        vVar.h(this);
    }

    public final void f() {
        n nVar = this.c;
        if (nVar.mFromLayout && nVar.mInLayout && !nVar.mPerformedCreateView) {
            Bundle bundle = nVar.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            nVar.performCreateView(nVar.performGetLayoutInflater(bundle2), null, bundle2);
            View view = nVar.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                nVar.mView.setTag(AbstractC0132Lp1.fragment_container_view_tag, nVar);
                if (nVar.mHidden) {
                    nVar.mView.setVisibility(8);
                }
                nVar.performViewCreated();
                this.a.m(nVar, nVar.mView, bundle2, false);
                nVar.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x0177, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.g():void");
    }

    public final void h(ClassLoader classLoader) {
        n nVar = this.c;
        Bundle bundle = nVar.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (nVar.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            nVar.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            nVar.mSavedViewState = nVar.mSavedFragmentState.getSparseParcelableArray("viewState");
            nVar.mSavedViewRegistryState = nVar.mSavedFragmentState.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) nVar.mSavedFragmentState.getParcelable("state");
            if (fragmentState != null) {
                nVar.mTargetWho = fragmentState.F;
                nVar.mTargetRequestCode = fragmentState.G;
                Boolean bool = nVar.mSavedUserVisibleHint;
                if (bool != null) {
                    nVar.mUserVisibleHint = bool.booleanValue();
                    nVar.mSavedUserVisibleHint = null;
                } else {
                    nVar.mUserVisibleHint = fragmentState.H;
                }
            }
            if (nVar.mUserVisibleHint) {
                return;
            }
            nVar.mDeferStart = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + nVar, e);
        }
    }

    public final void i() {
        n nVar = this.c;
        View focusedView = nVar.getFocusedView();
        if (focusedView != null) {
            if (focusedView == nVar.mView) {
                focusedView.requestFocus();
                break;
            }
            for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == nVar.mView) {
                    focusedView.requestFocus();
                    break;
                }
            }
        }
        nVar.setFocusedView(null);
        nVar.performResume();
        this.a.i(nVar, false);
        this.b.i(nVar.mWho, null);
        nVar.mSavedFragmentState = null;
        nVar.mSavedViewState = null;
        nVar.mSavedViewRegistryState = null;
    }

    public final Bundle j() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        n nVar = this.c;
        if (nVar.mState == -1 && (bundle = nVar.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(nVar));
        if (nVar.mState > -1) {
            Bundle bundle3 = new Bundle();
            nVar.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.j(nVar, bundle3, false);
            Bundle bundle4 = new Bundle();
            nVar.mSavedStateRegistryController.c(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleV = nVar.mChildFragmentManager.V();
            if (!bundleV.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleV);
            }
            if (nVar.mView != null) {
                k();
            }
            SparseArray<? extends Parcelable> sparseArray = nVar.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = nVar.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = nVar.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void k() {
        n nVar = this.c;
        if (nVar.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        nVar.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            nVar.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        nVar.mViewLifecycleOwner.y.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        nVar.mSavedViewRegistryState = bundle;
    }

    public u(Zh0 zh0, v vVar, ClassLoader classLoader, C0665fi0 c0665fi0, Bundle bundle) {
        this.a = zh0;
        this.b = vVar;
        FragmentState fragmentState = (FragmentState) bundle.getParcelable("state");
        n nVarA = c0665fi0.a(fragmentState.t);
        nVarA.mWho = fragmentState.u;
        nVarA.mFromLayout = fragmentState.v;
        nVarA.mInDynamicContainer = fragmentState.w;
        nVarA.mRestored = true;
        nVarA.mFragmentId = fragmentState.x;
        nVarA.mContainerId = fragmentState.y;
        nVarA.mTag = fragmentState.z;
        nVarA.mRetainInstance = fragmentState.A;
        nVarA.mRemoving = fragmentState.B;
        nVarA.mDetached = fragmentState.C;
        nVarA.mHidden = fragmentState.D;
        nVarA.mMaxState = cF0.values()[fragmentState.E];
        nVarA.mTargetWho = fragmentState.F;
        nVarA.mTargetRequestCode = fragmentState.G;
        nVarA.mUserVisibleHint = fragmentState.H;
        this.c = nVarA;
        nVarA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        nVarA.setArguments(bundle2);
    }

    public u(Zh0 zh0, v vVar, n nVar, Bundle bundle) {
        this.a = zh0;
        this.b = vVar;
        this.c = nVar;
        nVar.mSavedViewState = null;
        nVar.mSavedViewRegistryState = null;
        nVar.mBackStackNesting = 0;
        nVar.mInLayout = false;
        nVar.mAdded = false;
        n nVar2 = nVar.mTarget;
        nVar.mTargetWho = nVar2 != null ? nVar2.mWho : null;
        nVar.mTarget = null;
        nVar.mSavedFragmentState = bundle;
        nVar.mArguments = bundle.getBundle("arguments");
    }
}
