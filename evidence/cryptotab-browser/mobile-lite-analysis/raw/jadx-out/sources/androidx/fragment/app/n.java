package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.strictmode.GetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentRequestCodeUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.SetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetUserVisibleHintViolation;
import defpackage.AbstractC0019Bp2;
import defpackage.AbstractC0035Cp2;
import defpackage.AbstractC0068Fh0;
import defpackage.AbstractC0092Hi0;
import defpackage.AbstractC0128Lh0;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0246Uh0;
import defpackage.AbstractC0514dF0;
import defpackage.AbstractC1065m4;
import defpackage.AbstractC1120mz1;
import defpackage.AbstractC1493tH0;
import defpackage.BN0;
import defpackage.C0034Co2;
import defpackage.C0081Gh0;
import defpackage.C0094Ho2;
import defpackage.C0102Ih0;
import defpackage.C0112Jh0;
import defpackage.C0533dW0;
import defpackage.C0665fi0;
import defpackage.C0714gW0;
import defpackage.C0886jF0;
import defpackage.C1290pi0;
import defpackage.C1325qM1;
import defpackage.EH0;
import defpackage.F;
import defpackage.FH0;
import defpackage.FO;
import defpackage.Gi0;
import defpackage.Gk0;
import defpackage.InterfaceC0048Do2;
import defpackage.InterfaceC0105Io2;
import defpackage.InterfaceC0762hF0;
import defpackage.InterfaceC1463si0;
import defpackage.InterfaceC1753xn0;
import defpackage.Kh0;
import defpackage.Qh0;
import defpackage.RunnableC0091Hh0;
import defpackage.U3;
import defpackage.Xh0;
import defpackage.bF0;
import defpackage.cF0;
import defpackage.k4;
import defpackage.mH1;
import defpackage.o4;
import defpackage.tz1;
import defpackage.u4;
import defpackage.uz1;
import defpackage.vz1;
import defpackage.wz1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0762hF0, InterfaceC0105Io2, InterfaceC1753xn0, vz1 {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    Kh0 mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    s mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    InterfaceC0048Do2 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    s mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    Xh0 mHost;
    boolean mInDynamicContainer;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    C0886jF0 mLifecycleRegistry;
    cF0 mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList mOnPreAttachedListeners;
    n mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final AbstractC0128Lh0 mSavedStateAttachListener;
    uz1 mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray mSavedViewState;
    int mState;
    String mTag;
    n mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mTransitioning;
    boolean mUserVisibleHint;
    View mView;
    w mViewLifecycleOwner;
    C0714gW0 mViewLifecycleOwnerLiveData;
    String mWho;

    public n() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new C1290pi0();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new RunnableC0091Hh0(0, this);
        this.mMaxState = cF0.x;
        this.mViewLifecycleOwnerLiveData = new C0714gW0();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList();
        this.mSavedStateAttachListener = new j(this);
        C0();
    }

    @Deprecated
    public static n instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final n A0(boolean z) {
        String str;
        if (z) {
            Gi0 gi0 = AbstractC0092Hi0.a;
            new GetTargetFragmentUsageViolation("Attempting to get target fragment from fragment " + this);
            AbstractC0092Hi0.a(this).getClass();
        }
        n nVar = this.mTarget;
        if (nVar != null) {
            return nVar;
        }
        s sVar = this.mFragmentManager;
        if (sVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return sVar.c.b(str);
    }

    public final void C0() {
        this.mLifecycleRegistry = new C0886jF0(this);
        this.mSavedStateRegistryController = new uz1(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        AbstractC0128Lh0 abstractC0128Lh0 = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            abstractC0128Lh0.a();
        } else {
            this.mOnPreAttachedListeners.add(abstractC0128Lh0);
        }
    }

    public final C0081Gh0 E0(AbstractC1065m4 abstractC1065m4, Gk0 gk0, k4 k4Var) {
        if (this.mState > 1) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        C0112Jh0 c0112Jh0 = new C0112Jh0(this, gk0, atomicReference, abstractC1065m4, k4Var);
        if (this.mState >= 0) {
            c0112Jh0.a();
        } else {
            this.mOnPreAttachedListeners.add(c0112Jh0);
        }
        return new C0081Gh0(atomicReference);
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        s sVar;
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 != null) {
            kh0.s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (sVar = this.mFragmentManager) == null) {
            return;
        }
        g gVarJ = g.j(viewGroup, sVar);
        gVarJ.l();
        if (z) {
            this.mHost.v.post(new RunnableC0091Hh0(2, gVarJ));
        } else {
            gVarJ.e();
        }
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            this.mPostponedHandler = null;
        }
    }

    public AbstractC0246Uh0 createFragmentContainer() {
        return new k(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        n nVarA0 = A0(false);
        if (nVarA0 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(nVarA0);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            EH0.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.u(F.a(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public n findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    /* JADX INFO: renamed from: getActivity, reason: merged with bridge method [inline-methods] */
    public final FragmentActivity w0() {
        Xh0 xh0 = this.mHost;
        if (xh0 == null) {
            return null;
        }
        return xh0.t;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null || (bool = kh0.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null || (bool = kh0.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        kh0.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final s getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        Xh0 xh0 = this.mHost;
        if (xh0 == null) {
            return null;
        }
        return xh0.u;
    }

    @Override // defpackage.InterfaceC1753xn0
    public FO getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C0533dW0 c0533dW0 = new C0533dW0(0);
        if (application != null) {
            c0533dW0.a(C0034Co2.d, application);
        }
        c0533dW0.a(AbstractC1120mz1.a, this);
        c0533dW0.a(AbstractC1120mz1.b, this);
        if (getArguments() != null) {
            c0533dW0.a(AbstractC1120mz1.c, getArguments());
        }
        return c0533dW0;
    }

    @Override // defpackage.InterfaceC1753xn0
    public InterfaceC0048Do2 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.mDefaultFactory = new wz1(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 0;
        }
        return kh0.b;
    }

    public Object getEnterTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        return kh0.i;
    }

    public mH1 getEnterTransitionCallback() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        kh0.getClass();
        return null;
    }

    public int getExitAnim() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 0;
        }
        return kh0.c;
    }

    public Object getExitTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        return kh0.k;
    }

    public mH1 getExitTransitionCallback() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        kh0.getClass();
        return null;
    }

    public View getFocusedView() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        return kh0.r;
    }

    @Deprecated
    public final s getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        Xh0 xh0 = this.mHost;
        if (xh0 == null) {
            return null;
        }
        return ((Qh0) xh0).x;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // defpackage.InterfaceC0762hF0
    public AbstractC0514dF0 getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public EH0 getLoaderManager() {
        return EH0.a(this);
    }

    public int getNextTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 0;
        }
        return kh0.f;
    }

    public final n getParentFragment() {
        return this.mParentFragment;
    }

    public final s getParentFragmentManager() {
        s sVar = this.mFragmentManager;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return false;
        }
        return kh0.a;
    }

    public int getPopEnterAnim() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 0;
        }
        return kh0.d;
    }

    public int getPopExitAnim() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 0;
        }
        return kh0.e;
    }

    public float getPostOnViewCreatedAlpha() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return 1.0f;
        }
        return kh0.q;
    }

    public Object getReenterTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        Object obj = kh0.l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        Gi0 gi0 = AbstractC0092Hi0.a;
        new GetRetainInstanceUsageViolation("Attempting to get retain instance for fragment " + this);
        AbstractC0092Hi0.a(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        Object obj = kh0.j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // defpackage.vz1
    public final tz1 getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        return kh0.m;
    }

    public Object getSharedElementReturnTransition() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return null;
        }
        Object obj = kh0.n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList getSharedElementSourceNames() {
        ArrayList arrayList;
        Kh0 kh0 = this.mAnimationInfo;
        return (kh0 == null || (arrayList = kh0.g) == null) ? new ArrayList() : arrayList;
    }

    public ArrayList getSharedElementTargetNames() {
        ArrayList arrayList;
        Kh0 kh0 = this.mAnimationInfo;
        return (kh0 == null || (arrayList = kh0.h) == null) ? new ArrayList() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final n getTargetFragment() {
        return A0(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        Gi0 gi0 = AbstractC0092Hi0.a;
        new GetTargetFragmentRequestCodeUsageViolation("Attempting to get target request code from fragment " + this);
        AbstractC0092Hi0.a(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC0762hF0 getViewLifecycleOwner() {
        w wVar = this.mViewLifecycleOwner;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
    }

    public AbstractC1493tH0 getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // defpackage.InterfaceC0105Io2
    public C0094Ho2 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (z0() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.O.d;
        C0094Ho2 c0094Ho2 = (C0094Ho2) map.get(this.mWho);
        if (c0094Ho2 != null) {
            return c0094Ho2;
        }
        C0094Ho2 c0094Ho22 = new C0094Ho2();
        map.put(this.mWho, c0094Ho22);
        return c0094Ho22;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        C0();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new C1290pi0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (!this.mHidden) {
            s sVar = this.mFragmentManager;
            if (sVar == null) {
                return false;
            }
            n nVar = this.mParentFragment;
            sVar.getClass();
            if (!(nVar == null ? false : nVar.isHidden())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (this.mMenuVisible) {
            if (this.mFragmentManager == null) {
                return true;
            }
            n nVar = this.mParentFragment;
            if (nVar == null ? true : nVar.isMenuVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPostponed() {
        Kh0 kh0 = this.mAnimationInfo;
        if (kh0 == null) {
            return false;
        }
        return kh0.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        s sVar = this.mFragmentManager;
        if (sVar == null) {
            return false;
        }
        return sVar.L();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.N();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Xh0 xh0 = this.mHost;
        FragmentActivity fragmentActivity = xh0 == null ? null : xh0.t;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onAttach((Activity) fragmentActivity);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        s sVar = this.mChildFragmentManager;
        if (sVar.v >= 1) {
            return;
        }
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Xh0 xh0 = this.mHost;
        FragmentActivity fragmentActivity = xh0 == null ? null : xh0.t;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onInflate((Activity) fragmentActivity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.N();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (this.mView != null) {
            Bundle bundle2 = this.mSavedFragmentState;
            restoreViewState(bundle2 != null ? bundle2.getBundle("savedInstanceState") : null);
        }
        this.mSavedFragmentState = null;
        s sVar = this.mChildFragmentManager;
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(4);
    }

    public void performAttach() {
        Iterator it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            ((AbstractC0128Lh0) it.next()).a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.u);
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.p.iterator();
        while (it2.hasNext()) {
            ((InterfaceC1463si0) it2.next()).a(this);
        }
        s sVar = this.mChildFragmentManager;
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.i(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.N();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new l(this));
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(bF0.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return z | this.mChildFragmentManager.j(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.N();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new w(this, getViewModelStore(), new i(this));
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.x != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        AbstractC0019Bp2.a(this.mView, this.mViewLifecycleOwner);
        this.mView.setTag(AbstractC0132Lp1.view_tree_view_model_store_owner, this.mViewLifecycleOwner);
        AbstractC0035Cp2.a(this.mView, this.mViewLifecycleOwner);
        this.mViewLifecycleOwnerLiveData.h(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.k();
        this.mLifecycleRegistry.e(bF0.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.t(1);
        if (this.mView != null) {
            w wVar = this.mViewLifecycleOwner;
            wVar.b();
            if (wVar.x.c.a(cF0.v)) {
                this.mViewLifecycleOwner.a(bF0.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        C1325qM1 c1325qM1 = EH0.a(this).b.b;
        int i = c1325qM1.v;
        for (int i2 = 0; i2 < i; i2++) {
            ((FH0) c1325qM1.u[i2]).j();
        }
        this.mPerformedCreateView = false;
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onDetach()"));
        }
        s sVar = this.mChildFragmentManager;
        if (sVar.f16J) {
            return;
        }
        sVar.k();
        this.mChildFragmentManager = new C1290pi0();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.o(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.p(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.t(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bF0.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(bF0.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return z | this.mChildFragmentManager.s(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zK = s.K(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zK) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zK);
            onPrimaryNavigationFragmentChanged(zK);
            s sVar = this.mChildFragmentManager;
            sVar.d0();
            sVar.q(sVar.z);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.N();
        this.mChildFragmentManager.y(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onResume()"));
        }
        C0886jF0 c0886jF0 = this.mLifecycleRegistry;
        bF0 bf0 = bF0.ON_RESUME;
        c0886jF0.e(bf0);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bf0);
        }
        s sVar = this.mChildFragmentManager;
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.N();
        this.mChildFragmentManager.y(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onStart()"));
        }
        C0886jF0 c0886jF0 = this.mLifecycleRegistry;
        bF0 bf0 = bF0.ON_START;
        c0886jF0.e(bf0);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bf0);
        }
        s sVar = this.mChildFragmentManager;
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(5);
    }

    public void performStop() {
        s sVar = this.mChildFragmentManager;
        sVar.I = true;
        sVar.O.g = true;
        sVar.t(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bF0.ON_STOP);
        }
        this.mLifecycleRegistry.e(bF0.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle = this.mSavedFragmentState;
        onViewCreated(this.mView, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.mChildFragmentManager.t(2);
    }

    public void postponeEnterTransition() {
        v0().s = true;
    }

    public final o4 registerForActivityResult(AbstractC1065m4 abstractC1065m4, k4 k4Var) {
        return E0(abstractC1065m4, new m(this), k4Var);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to Activity"));
        }
        s parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.E == null) {
            parentFragmentManager.w.getClass();
            return;
        }
        parentFragmentManager.F.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i));
        parentFragmentManager.E.a(strArr);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity fragmentActivityW0 = w0();
        if (fragmentActivityW0 != null) {
            return fragmentActivityW0;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final s requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to a host."));
    }

    public final n requireParentFragment() {
        n parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.mChildFragmentManager.U(bundle);
        s sVar = this.mChildFragmentManager;
        sVar.H = false;
        sVar.I = false;
        sVar.O.g = false;
        sVar.t(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(AbstractC0068Fh0.a("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bF0.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        v0().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        v0().o = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        v0().b = i;
        v0().c = i2;
        v0().d = i3;
        v0().e = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(mH1 mh1) {
        v0().getClass();
    }

    public void setEnterTransition(Object obj) {
        v0().i = obj;
    }

    public void setExitSharedElementCallback(mH1 mh1) {
        v0().getClass();
    }

    public void setExitTransition(Object obj) {
        v0().k = obj;
    }

    public void setFocusedView(View view) {
        v0().r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((Qh0) this.mHost).x.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(Fragment$SavedState fragment$SavedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (fragment$SavedState == null || (bundle = fragment$SavedState.t) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((Qh0) this.mHost).x.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        v0();
        this.mAnimationInfo.f = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        v0().a = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        v0().q = f;
    }

    public void setReenterTransition(Object obj) {
        v0().l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        Gi0 gi0 = AbstractC0092Hi0.a;
        new SetRetainInstanceUsageViolation("Attempting to set retain instance for fragment " + this);
        AbstractC0092Hi0.a(this).getClass();
        this.mRetainInstance = z;
        s sVar = this.mFragmentManager;
        if (sVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
            return;
        }
        if (!z) {
            sVar.O.d(this);
            return;
        }
        t tVar = sVar.O;
        if (tVar.g) {
            return;
        }
        HashMap map = tVar.b;
        if (map.containsKey(this.mWho)) {
            return;
        }
        map.put(this.mWho, this);
    }

    public void setReturnTransition(Object obj) {
        v0().j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        v0().m = obj;
    }

    public void setSharedElementNames(ArrayList arrayList, ArrayList arrayList2) {
        v0();
        Kh0 kh0 = this.mAnimationInfo;
        kh0.g = arrayList;
        kh0.h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        v0().n = obj;
    }

    @Deprecated
    public void setTargetFragment(n nVar, int i) {
        if (nVar != null) {
            Gi0 gi0 = AbstractC0092Hi0.a;
            new SetTargetFragmentUsageViolation("Attempting to set target fragment " + nVar + " with request code " + i + " for fragment " + this);
            AbstractC0092Hi0.a(this).getClass();
        }
        s sVar = this.mFragmentManager;
        s sVar2 = nVar != null ? nVar.mFragmentManager : null;
        if (sVar != null && sVar2 != null && sVar != sVar2) {
            throw new IllegalArgumentException(AbstractC0068Fh0.a("Fragment ", nVar, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (n nVarA0 = nVar; nVarA0 != null; nVarA0 = nVarA0.A0(false)) {
            if (nVarA0.equals(this)) {
                throw new IllegalArgumentException("Setting " + nVar + " as the target of " + this + " would create a target cycle");
            }
        }
        if (nVar == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || nVar.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = nVar;
        } else {
            this.mTargetWho = nVar.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        Gi0 gi0 = AbstractC0092Hi0.a;
        new SetUserVisibleHintViolation("Attempting to set user visible hint to " + z + " for fragment " + this);
        AbstractC0092Hi0.a(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            s sVar = this.mFragmentManager;
            u uVarF = sVar.f(this);
            n nVar = uVarF.c;
            if (nVar.mDeferStart) {
                if (sVar.b) {
                    sVar.K = true;
                } else {
                    nVar.mDeferStart = false;
                    uVarF.g();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        Xh0 xh0 = this.mHost;
        if (xh0 != null) {
            return U3.d(((Qh0) xh0).x, str);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to Activity"));
        }
        s parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.D == null) {
            Xh0 xh0 = parentFragmentManager.w;
            if (i != -1) {
                xh0.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            FragmentActivity fragmentActivity = xh0.t;
            if (fragmentActivity == null) {
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            fragmentActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent2, i2, i3);
        parentFragmentManager.F.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i));
        parentFragmentManager.D.a(intentSenderRequest);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !v0().s) {
            return;
        }
        if (this.mHost == null) {
            v0().s = false;
        } else if (Looper.myLooper() != this.mHost.v.getLooper()) {
            this.mHost.v.postAtFrontOfQueue(new RunnableC0091Hh0(1, this));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public final Kh0 v0() {
        if (this.mAnimationInfo == null) {
            Kh0 kh0 = new Kh0();
            kh0.i = null;
            Object obj = USE_DEFAULT_TRANSITION;
            kh0.j = obj;
            kh0.k = null;
            kh0.l = obj;
            kh0.m = null;
            kh0.n = obj;
            kh0.q = 1.0f;
            kh0.r = null;
            this.mAnimationInfo = kh0;
        }
        return this.mAnimationInfo;
    }

    public final int z0() {
        cF0 cf0 = this.mMaxState;
        return (cf0 == cF0.u || this.mParentFragment == null) ? cf0.ordinal() : Math.min(cf0.ordinal(), this.mParentFragment.z0());
    }

    @Deprecated
    public static n instantiate(Context context, String str, Bundle bundle) {
        try {
            n nVar = (n) C0665fi0.c(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(nVar.getClass().getClassLoader());
                nVar.setArguments(bundle);
            }
            return nVar;
        } catch (IllegalAccessException e) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment$InstantiationException(BN0.a("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        v0().s = true;
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
        }
        s sVar = this.mFragmentManager;
        if (sVar != null) {
            this.mPostponedHandler = sVar.w.v;
        } else {
            this.mPostponedHandler = new Handler(Looper.getMainLooper());
        }
        this.mPostponedHandler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public final o4 registerForActivityResult(AbstractC1065m4 abstractC1065m4, u4 u4Var, k4 k4Var) {
        return E0(abstractC1065m4, new C0102Ih0(u4Var), k4Var);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        Xh0 xh0 = this.mHost;
        if (xh0 == null) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to Activity"));
        }
        xh0.u.startActivity(intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(AbstractC0068Fh0.a("Fragment ", this, " not attached to Activity"));
        }
        s parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.C != null) {
            parentFragmentManager.F.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i));
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.C.a(intent);
            return;
        }
        Xh0 xh0 = parentFragmentManager.w;
        if (i == -1) {
            xh0.u.startActivity(intent, bundle);
        } else {
            xh0.getClass();
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        Xh0 xh0 = this.mHost;
        if (xh0 != null) {
            FragmentActivity fragmentActivity = ((Qh0) xh0).x;
            LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f);
            return layoutInflaterCloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public n(int i) {
        this();
        this.mContentLayoutId = i;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @Deprecated
    public void onAttachFragment(n nVar) {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }
}
