package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.AbstractC0019Bp2;
import defpackage.AbstractC0035Cp2;
import defpackage.AbstractC0132Lp1;
import defpackage.AbstractC0246Uh0;
import defpackage.AbstractC1214oR1;
import defpackage.AbstractC1435sH0;
import defpackage.AbstractC1493tH0;
import defpackage.C1232oi0;
import defpackage.C1318qH0;
import defpackage.C1374rH0;
import defpackage.Ji0;
import defpackage.K21;
import defpackage.Rx1;
import defpackage.Ux1;
import defpackage.lI;
import defpackage.mY;
import defpackage.nY;
import defpackage.oY;
import defpackage.pY;
import defpackage.qY;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class h extends n implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDismissed;
    private Handler mHandler;
    private boolean mShownByMe;
    private boolean mViewDestroyed;
    private Runnable mDismissRunnable = new mY(this);
    private DialogInterface.OnCancelListener mOnCancelListener = new nY(this);
    private DialogInterface.OnDismissListener mOnDismissListener = new oY(this);
    private int mStyle = 0;
    private int mTheme = 0;
    private boolean mCancelable = true;
    private boolean mShowsDialog = true;
    private int mBackStackId = -1;
    private K21 mObserver = new pY(this);
    private boolean mDialogCreated = false;

    public final void F0(boolean z, boolean z2, boolean z3) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) {
            s parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            a aVar = new a(parentFragmentManager);
            aVar.p = true;
            aVar.k(this);
            if (z3) {
                aVar.j();
                return;
            } else if (z) {
                aVar.i(true, true);
                return;
            } else {
                aVar.h();
                return;
            }
        }
        if (z3) {
            s parentFragmentManager2 = getParentFragmentManager();
            int i = this.mBackStackId;
            if (i < 0) {
                parentFragmentManager2.getClass();
                throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Bad id: "));
            }
            parentFragmentManager2.P(i, 1);
        } else {
            s parentFragmentManager3 = getParentFragmentManager();
            int i2 = this.mBackStackId;
            parentFragmentManager3.getClass();
            if (i2 < 0) {
                throw new IllegalArgumentException(AbstractC1214oR1.a(i2, "Bad id: "));
            }
            parentFragmentManager3.w(new C1232oi0(parentFragmentManager3, i2, 1), z);
        }
        this.mBackStackId = -1;
    }

    @Override // androidx.fragment.app.n
    public AbstractC0246Uh0 createFragmentContainer() {
        return new qY(this, super.createFragmentContainer());
    }

    public void dismiss() {
        F0(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        F0(true, false, false);
    }

    public void dismissNow() {
        F0(false, false, true);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.n
    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.n
    public void onAttach(Context context) {
        Object obj;
        super.onAttach(context);
        AbstractC1493tH0 viewLifecycleOwnerLiveData = getViewLifecycleOwnerLiveData();
        K21 k21 = this.mObserver;
        viewLifecycleOwnerLiveData.getClass();
        AbstractC1493tH0.a("observeForever");
        C1318qH0 c1318qH0 = new C1318qH0(viewLifecycleOwnerLiveData, k21);
        Ux1 ux1 = viewLifecycleOwnerLiveData.b;
        Rx1 rx1E = ux1.e(k21);
        if (rx1E != null) {
            obj = rx1E.u;
        } else {
            Rx1 rx1 = new Rx1(k21, c1318qH0);
            ux1.w++;
            Rx1 rx12 = ux1.u;
            if (rx12 == null) {
                ux1.t = rx1;
                ux1.u = rx1;
            } else {
                rx12.v = rx1;
                rx1.w = rx12;
                ux1.u = rx1;
            }
            obj = null;
        }
        AbstractC1435sH0 abstractC1435sH0 = (AbstractC1435sH0) obj;
        if (abstractC1435sH0 instanceof C1374rH0) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC1435sH0 == null) {
            c1318qH0.d(true);
        }
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // androidx.fragment.app.n
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new lI(getTheme(), requireContext());
    }

    @Override // androidx.fragment.app.n
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.n
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().g(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        F0(true, true, false);
    }

    public View onFindViewById(int i) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.n
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.mShowsDialog;
        if (!z || this.mCreatingDialog) {
            return layoutInflaterOnGetLayoutInflater;
        }
        if (z && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog dialogOnCreateDialog = onCreateDialog(bundle);
                this.mDialog = dialogOnCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(dialogOnCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
                this.mCreatingDialog = false;
            } catch (Throwable th) {
                this.mCreatingDialog = false;
                throw th;
            }
        }
        Dialog dialog = this.mDialog;
        return dialog != null ? layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext()) : layoutInflaterOnGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.n
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, bundleOnSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.n
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            AbstractC0019Bp2.a(decorView, this);
            decorView.setTag(AbstractC0132Lp1.view_tree_view_model_store_owner, this);
            AbstractC0035Cp2.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.n
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.n
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.n
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    public final lI requireComponentDialog() {
        Dialog dialogRequireDialog = requireDialog();
        if (dialogRequireDialog instanceof lI) {
            return (lI) dialogRequireDialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " did not return a ComponentDialog instance from requireDialog(). The actual Dialog is " + dialogRequireDialog);
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public void setStyle(int i, int i2) {
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(s sVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        sVar.getClass();
        a aVar = new a(sVar);
        aVar.p = true;
        aVar.d(0, this, str, 1);
        aVar.h();
    }

    public void showNow(s sVar, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        sVar.getClass();
        a aVar = new a(sVar);
        aVar.p = true;
        aVar.d(0, this, str, 1);
        aVar.j();
    }

    public int show(Ji0 ji0, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        ji0.d(0, this, str, 1);
        this.mViewDestroyed = false;
        int i = ((a) ji0).i(false, true);
        this.mBackStackId = i;
        return i;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
