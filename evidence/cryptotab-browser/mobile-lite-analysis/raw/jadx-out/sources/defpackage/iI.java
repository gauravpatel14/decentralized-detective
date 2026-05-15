package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class iI extends Activity implements InterfaceC0105Io2, InterfaceC1753xn0, vz1, K41, v4, O41, V41, S41, T41, AQ0, InterfaceC0762hF0, EB0 {
    public static final /* synthetic */ int M = 0;
    public final AtomicInteger A;
    public final fI B;
    public final CopyOnWriteArrayList C;
    public final CopyOnWriteArrayList D;
    public final CopyOnWriteArrayList E;
    public final CopyOnWriteArrayList F;
    public final CopyOnWriteArrayList G;
    public final CopyOnWriteArrayList H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f31J;
    public final C0646fU1 K;
    public final C0646fU1 L;
    public final C0886jF0 t = new C0886jF0(this);
    public final KL u = new KL();
    public final BQ0 v = new BQ0(new VH(0, this));
    public final uz1 w;
    public C0094Ho2 x;
    public final dI y;
    public final C0646fU1 z;

    public iI() {
        uz1 uz1Var = new uz1(this);
        this.w = uz1Var;
        this.y = new dI(this);
        this.z = new C0646fU1(new gI(this, 2));
        this.A = new AtomicInteger();
        this.B = new fI(this);
        this.C = new CopyOnWriteArrayList();
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.G = new CopyOnWriteArrayList();
        this.H = new CopyOnWriteArrayList();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        final int i = 0;
        getLifecycle().a(new InterfaceC0564eF0(this) { // from class: WH
            public final /* synthetic */ iI u;

            {
                this.u = this;
            }

            @Override // defpackage.InterfaceC0564eF0
            public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
                Window window;
                View viewPeekDecorView;
                switch (i) {
                    case 0:
                        if (bf0 == bF0.ON_STOP && (window = this.u.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        iI iIVar = this.u;
                        if (bf0 == bF0.ON_DESTROY) {
                            iIVar.u.b = null;
                            if (!iIVar.isChangingConfigurations()) {
                                iIVar.getViewModelStore().a();
                            }
                            dI dIVar = iIVar.y;
                            iI iIVar2 = dIVar.w;
                            iIVar2.getWindow().getDecorView().removeCallbacks(dIVar);
                            iIVar2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(dIVar);
                        }
                        break;
                }
            }
        });
        final int i2 = 1;
        getLifecycle().a(new InterfaceC0564eF0(this) { // from class: WH
            public final /* synthetic */ iI u;

            {
                this.u = this;
            }

            @Override // defpackage.InterfaceC0564eF0
            public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
                Window window;
                View viewPeekDecorView;
                switch (i2) {
                    case 0:
                        if (bf0 == bF0.ON_STOP && (window = this.u.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        iI iIVar = this.u;
                        if (bf0 == bF0.ON_DESTROY) {
                            iIVar.u.b = null;
                            if (!iIVar.isChangingConfigurations()) {
                                iIVar.getViewModelStore().a();
                            }
                            dI dIVar = iIVar.y;
                            iI iIVar2 = dIVar.w;
                            iIVar2.getWindow().getDecorView().removeCallbacks(dIVar);
                            iIVar2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(dIVar);
                        }
                        break;
                }
            }
        });
        getLifecycle().a(new aI(this));
        uz1Var.a();
        AbstractC1120mz1.b(this);
        uz1Var.b.c("android:support:activity-result", new sz1() { // from class: XH
            @Override // defpackage.sz1
            public final Bundle a() {
                Bundle bundle = new Bundle();
                fI fIVar = this.a.B;
                fIVar.getClass();
                LinkedHashMap linkedHashMap = fIVar.b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(fIVar.d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(fIVar.g));
                return bundle;
            }
        });
        Q0(new P41() { // from class: YH
            @Override // defpackage.P41
            public final void a() {
                iI iIVar = this.a;
                Bundle bundleA = iIVar.w.b.a("android:support:activity-result");
                if (bundleA != null) {
                    fI fIVar = iIVar.B;
                    fIVar.getClass();
                    ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    ArrayList<String> stringArrayList2 = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if (stringArrayList2 != null) {
                        fIVar.d.addAll(stringArrayList2);
                    }
                    Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    Bundle bundle2 = fIVar.g;
                    if (bundle != null) {
                        bundle2.putAll(bundle);
                    }
                    int size = stringArrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = stringArrayList.get(i3);
                        LinkedHashMap linkedHashMap = fIVar.b;
                        boolean zContainsKey = linkedHashMap.containsKey(str);
                        LinkedHashMap linkedHashMap2 = fIVar.a;
                        if (zContainsKey) {
                            Integer num = (Integer) linkedHashMap.remove(str);
                            if (bundle2.containsKey(str)) {
                                continue;
                            } else {
                                if ((linkedHashMap2 instanceof BB0) && !(linkedHashMap2 instanceof CB0)) {
                                    AbstractC0222Si2.c(linkedHashMap2, "kotlin.collections.MutableMap");
                                    throw null;
                                }
                                linkedHashMap2.remove(num);
                            }
                        }
                        int iIntValue = integerArrayList.get(i3).intValue();
                        String str2 = stringArrayList.get(i3);
                        linkedHashMap2.put(Integer.valueOf(iIntValue), str2);
                        linkedHashMap.put(str2, Integer.valueOf(iIntValue));
                    }
                }
            }
        });
        this.K = new C0646fU1(new gI(this, 0));
        this.L = new C0646fU1(new gI(this, 3));
    }

    @Override // defpackage.EB0
    public final boolean F(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // defpackage.S41
    public final void F0(ai0 ai0Var) {
        this.F.remove(ai0Var);
    }

    @Override // defpackage.V41
    public final void I(ai0 ai0Var) {
        this.D.remove(ai0Var);
    }

    public void K0() {
        finish();
    }

    @Override // defpackage.O41
    public final void L(QK qk) {
        this.C.add(qk);
    }

    @Override // defpackage.V41
    public final void P(ai0 ai0Var) {
        this.D.add(ai0Var);
    }

    public final void Q0(P41 p41) {
        KL kl = this.u;
        if (kl.b != null) {
            p41.a();
        }
        kl.a.add(p41);
    }

    public final void R0() {
        AbstractC0019Bp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_view_model_store_owner, this);
        AbstractC0035Cp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_on_back_pressed_dispatcher_owner, this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.report_drawn, this);
    }

    public final void S0(Bundle bundle) {
        super.onCreate(bundle);
        int i = FragmentC1585uu1.t;
        AbstractC1353qu1.b(this);
    }

    public final void T0(Bundle bundle) {
        C0886jF0 c0886jF0 = this.t;
        cF0 cf0 = cF0.v;
        c0886jF0.d("setCurrentState");
        c0886jF0.f(cf0);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        R0();
        this.y.a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.T41
    public final void c0(QK qk) {
        this.G.add(qk);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (FB0.a(decorView, keyEvent)) {
            return true;
        }
        return FB0.b(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (FB0.a(getWindow().getDecorView(), keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // defpackage.InterfaceC1753xn0
    public final FO getDefaultViewModelCreationExtras() {
        C0533dW0 c0533dW0 = new C0533dW0(0);
        if (getApplication() != null) {
            c0533dW0.a(C0034Co2.d, getApplication());
        }
        c0533dW0.a(AbstractC1120mz1.a, this);
        c0533dW0.a(AbstractC1120mz1.b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            c0533dW0.a(AbstractC1120mz1.c, extras);
        }
        return c0533dW0;
    }

    @Override // defpackage.InterfaceC1753xn0
    public final InterfaceC0048Do2 getDefaultViewModelProviderFactory() {
        return (InterfaceC0048Do2) this.K.getValue();
    }

    @Override // defpackage.InterfaceC0762hF0
    public AbstractC0514dF0 getLifecycle() {
        return this.t;
    }

    @Override // defpackage.vz1
    public final tz1 getSavedStateRegistry() {
        return this.w.b;
    }

    @Override // defpackage.InterfaceC0105Io2
    public final C0094Ho2 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.x == null) {
            cI cIVar = (cI) getLastNonConfigurationInstance();
            if (cIVar != null) {
                this.x = cIVar.a;
            }
            if (this.x == null) {
                this.x = new C0094Ho2();
            }
        }
        return this.x;
    }

    @Override // defpackage.O41
    public final void j(ai0 ai0Var) {
        this.C.remove(ai0Var);
    }

    @Override // defpackage.AQ0
    public final void k0(C0600ei0 c0600ei0) {
        BQ0 bq0 = this.v;
        bq0.b.add(c0600ei0);
        bq0.a.run();
    }

    @Override // defpackage.K41
    public final J41 l() {
        return (J41) this.L.getValue();
    }

    @Override // defpackage.v4
    public final u4 m0() {
        return this.B;
    }

    @Override // defpackage.T41
    public final void n0(QK qk) {
        this.G.remove(qk);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.B.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        l().d();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((QK) it.next()).accept(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.w.b(bundle);
        KL kl = this.u;
        kl.b = this;
        Iterator it = kl.a.iterator();
        while (it.hasNext()) {
            ((P41) it.next()).a();
        }
        S0(bundle);
        int i = FragmentC1585uu1.t;
        AbstractC1353qu1.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = this.v.b.iterator();
        while (it.hasNext()) {
            ((C0600ei0) it.next()).a.j(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        boolean z = true;
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        Iterator it = this.v.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (((C0600ei0) it.next()).a.o(menuItem)) {
                break;
            }
        }
        return z;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.I) {
            return;
        }
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((QK) it.next()).accept(new XV0(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            ((QK) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = this.v.b.iterator();
        while (it.hasNext()) {
            ((C0600ei0) it.next()).a.p(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.f31J) {
            return;
        }
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            ((QK) it.next()).accept(new Og1(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.v.b.iterator();
        while (it.hasNext()) {
            ((C0600ei0) it.next()).a.s(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.B.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        cI cIVar;
        C0094Ho2 c0094Ho2 = this.x;
        if (c0094Ho2 == null && (cIVar = (cI) getLastNonConfigurationInstance()) != null) {
            c0094Ho2 = cIVar.a;
        }
        if (c0094Ho2 == null) {
            return null;
        }
        cI cIVar2 = new cI();
        cIVar2.a = c0094Ho2;
        return cIVar2;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (getLifecycle() instanceof C0886jF0) {
            C0886jF0 c0886jF0 = (C0886jF0) getLifecycle();
            cF0 cf0 = cF0.v;
            c0886jF0.d("setCurrentState");
            c0886jF0.f(cf0);
        }
        T0(bundle);
        this.w.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.D.iterator();
        while (it.hasNext()) {
            ((QK) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (AbstractC0268We2.a()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            C0731gk0 c0731gk0 = (C0731gk0) this.z.getValue();
            synchronized (c0731gk0.a) {
                try {
                    c0731gk0.b = true;
                    Iterator it = c0731gk0.c.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0798hk0) it.next()).c();
                    }
                    c0731gk0.c.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // defpackage.S41
    public final void s0(ai0 ai0Var) {
        this.F.add(ai0Var);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        R0();
        this.y.a(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // defpackage.AQ0
    public final void w(C0600ei0 c0600ei0) {
        BQ0 bq0 = this.v;
        bq0.b.remove(c0600ei0);
        if (bq0.c.remove(c0600ei0) != null) {
            throw new ClassCastException();
        }
        bq0.a.run();
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.I = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.I = false;
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                ((QK) it.next()).accept(new XV0(z));
            }
        } catch (Throwable th) {
            this.I = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.f31J = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.f31J = false;
            Iterator it = this.G.iterator();
            while (it.hasNext()) {
                ((QK) it.next()).accept(new Og1(z));
            }
        } catch (Throwable th) {
            this.f31J = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        R0();
        this.y.a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        R0();
        this.y.a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
