package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import defpackage.C0886jF0;
import defpackage.C1290pi0;
import defpackage.P41;
import defpackage.QK;
import defpackage.Qh0;
import defpackage.T3;
import defpackage.Vh0;
import defpackage.bF0;
import defpackage.cF0;
import defpackage.iI;
import defpackage.sz1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends iI implements T3 {
    public static final /* synthetic */ int S = 0;
    public boolean P;
    public boolean Q;
    public final Vh0 N = new Vh0(new Qh0(this));
    public final C0886jF0 O = new C0886jF0(this);
    public boolean R = true;

    public FragmentActivity() {
        this.w.b.c("android:support:lifecycle", new sz1() { // from class: Nh0
            @Override // defpackage.sz1
            public final Bundle a() {
                int i = FragmentActivity.S;
                FragmentActivity fragmentActivity = this.a;
                while (FragmentActivity.V0(fragmentActivity.U0())) {
                }
                fragmentActivity.O.e(bF0.ON_STOP);
                return new Bundle();
            }
        });
        final int i = 0;
        L(new QK(this) { // from class: Oh0
            public final /* synthetic */ FragmentActivity u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.u.N.a();
                        break;
                    default:
                        this.u.N.a();
                        break;
                }
            }
        });
        final int i2 = 1;
        this.E.add(new QK(this) { // from class: Oh0
            public final /* synthetic */ FragmentActivity u;

            {
                this.u = this;
            }

            @Override // defpackage.QK
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.u.N.a();
                        break;
                    default:
                        this.u.N.a();
                        break;
                }
            }
        });
        Q0(new P41() { // from class: Ph0
            @Override // defpackage.P41
            public final void a() {
                Qh0 qh0 = this.a.N.a;
                qh0.w.b(qh0, qh0, null);
            }
        });
    }

    public static boolean V0(s sVar) {
        boolean zV0 = false;
        for (n nVar : sVar.c.f()) {
            if (nVar != null) {
                if (nVar.getHost() != null) {
                    zV0 |= V0(nVar.getChildFragmentManager());
                }
                w wVar = nVar.mViewLifecycleOwner;
                cF0 cf0 = cF0.w;
                cF0 cf02 = cF0.v;
                if (wVar != null) {
                    wVar.b();
                    if (wVar.x.c.a(cf0)) {
                        C0886jF0 c0886jF0 = nVar.mViewLifecycleOwner.x;
                        c0886jF0.d("setCurrentState");
                        c0886jF0.f(cf02);
                        zV0 = true;
                    }
                }
                if (nVar.mLifecycleRegistry.c.a(cf0)) {
                    C0886jF0 c0886jF02 = nVar.mLifecycleRegistry;
                    c0886jF02.d("setCurrentState");
                    c0886jF02.f(cf02);
                    zV0 = true;
                }
            }
        }
        return zV0;
    }

    public final C1290pi0 U0() {
        return this.N.a.w;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.String r3, java.io.FileDescriptor r4, java.io.PrintWriter r5, java.lang.String[] r6) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentActivity.dump(java.lang.String, java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // defpackage.iI, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.N.a();
        super.onActivityResult(i, i2, intent);
    }

    @Override // defpackage.iI, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O.e(bF0.ON_CREATE);
        C1290pi0 c1290pi0 = this.N.a.w;
        c1290pi0.H = false;
        c1290pi0.I = false;
        c1290pi0.O.g = false;
        c1290pi0.t(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.N.a.w.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.N.a.w.k();
        this.O.e(bF0.ON_DESTROY);
    }

    @Override // defpackage.iI, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.N.a.w.i(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q = false;
        this.N.a.w.t(5);
        this.O.e(bF0.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.O.e(bF0.ON_RESUME);
        C1290pi0 c1290pi0 = this.N.a.w;
        c1290pi0.H = false;
        c1290pi0.I = false;
        c1290pi0.O.g = false;
        c1290pi0.t(7);
    }

    @Override // defpackage.iI, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.N.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        Vh0 vh0 = this.N;
        vh0.a();
        super.onResume();
        this.Q = true;
        vh0.a.w.y(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        Vh0 vh0 = this.N;
        vh0.a();
        super.onStart();
        this.R = false;
        boolean z = this.P;
        Qh0 qh0 = vh0.a;
        if (!z) {
            this.P = true;
            C1290pi0 c1290pi0 = qh0.w;
            c1290pi0.H = false;
            c1290pi0.I = false;
            c1290pi0.O.g = false;
            c1290pi0.t(4);
        }
        qh0.w.y(true);
        this.O.e(bF0.ON_START);
        C1290pi0 c1290pi02 = qh0.w;
        c1290pi02.H = false;
        c1290pi02.I = false;
        c1290pi02.O.g = false;
        c1290pi02.t(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.N.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.R = true;
        while (V0(U0())) {
        }
        C1290pi0 c1290pi0 = this.N.a.w;
        c1290pi0.I = true;
        c1290pi0.O.g = true;
        c1290pi0.t(4);
        this.O.e(bF0.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = this.N.a.w.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }

    public void W0(n nVar) {
    }
}
