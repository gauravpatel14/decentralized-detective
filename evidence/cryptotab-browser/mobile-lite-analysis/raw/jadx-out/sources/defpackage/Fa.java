package defpackage;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Fa extends FragmentActivity implements Ja {
    public LayoutInflaterFactory2C0658fb T;

    public Fa() {
        this.w.b.c("androidx:appcompat", new C0039Da(this));
        Q0(new Ea(this));
    }

    public final AbstractC0231Ta X0() {
        if (this.T == null) {
            Ra ra = AbstractC0231Ta.t;
            this.T = new LayoutInflaterFactory2C0658fb(this, null, this, this);
        }
        return this.T;
    }

    public final AbstractC0508d3 Y0() {
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        layoutInflaterFactory2C0658fb.B();
        return layoutInflaterFactory2C0658fb.H;
    }

    public final void Z0() {
        AbstractC0019Bp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_view_model_store_owner, this);
        AbstractC0035Cp2.a(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(AbstractC0132Lp1.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    public boolean a1() {
        Intent intentA = ZW0.a(this);
        if (intentA == null) {
            return false;
        }
        if (!shouldUpRecreateTask(intentA)) {
            navigateUpTo(intentA);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        Intent intentA2 = ZW0.a(this);
        if (intentA2 == null) {
            intentA2 = ZW0.a(this);
        }
        if (intentA2 != null) {
            ComponentName component = intentA2.getComponent();
            if (component == null) {
                component = intentA2.resolveActivity(getPackageManager());
            }
            int size = arrayList.size();
            try {
                Intent intentB = ZW0.b(this, component);
                while (intentB != null) {
                    arrayList.add(size, intentB);
                    intentB = ZW0.b(this, intentB.getComponent());
                }
                arrayList.add(intentA2);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // defpackage.iI, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Z0();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        layoutInflaterFactory2C0658fb.x();
        ((ViewGroup) layoutInflaterFactory2C0658fb.U.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C0658fb.F.a(layoutInflaterFactory2C0658fb.E.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attachBaseContext(final android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Fa.attachBaseContext(android.content.Context):void");
    }

    public final void b1(Toolbar toolbar) {
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        if (layoutInflaterFactory2C0658fb.C instanceof Activity) {
            layoutInflaterFactory2C0658fb.B();
            AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
            if (abstractC0508d3 instanceof C1586uv2) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            layoutInflaterFactory2C0658fb.I = null;
            if (abstractC0508d3 != null) {
                abstractC0508d3.i();
            }
            layoutInflaterFactory2C0658fb.H = null;
            if (toolbar != null) {
                Object obj = layoutInflaterFactory2C0658fb.C;
                mb2 mb2Var = new mb2(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : layoutInflaterFactory2C0658fb.f27J, layoutInflaterFactory2C0658fb.F);
                layoutInflaterFactory2C0658fb.H = mb2Var;
                layoutInflaterFactory2C0658fb.F.u = mb2Var.c;
                if (!toolbar.o0) {
                    toolbar.o0 = true;
                    toolbar.J();
                }
            } else {
                layoutInflaterFactory2C0658fb.F.u = null;
            }
            layoutInflaterFactory2C0658fb.d();
        }
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        AbstractC0508d3 abstractC0508d3Y0 = Y0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0508d3Y0 == null || !abstractC0508d3Y0.a()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // defpackage.iI, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0508d3 abstractC0508d3Y0 = Y0();
        if (keyCode == 82 && abstractC0508d3Y0 != null && abstractC0508d3Y0.k(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        layoutInflaterFactory2C0658fb.x();
        return layoutInflaterFactory2C0658fb.E.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        if (layoutInflaterFactory2C0658fb.I == null) {
            layoutInflaterFactory2C0658fb.B();
            AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
            layoutInflaterFactory2C0658fb.I = new ZR1(abstractC0508d3 != null ? abstractC0508d3.f() : layoutInflaterFactory2C0658fb.D);
        }
        return layoutInflaterFactory2C0658fb.I;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = AbstractC1049ln2.a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        X0().d();
    }

    @Override // defpackage.iI, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        if (layoutInflaterFactory2C0658fb.Z && layoutInflaterFactory2C0658fb.T) {
            layoutInflaterFactory2C0658fb.B();
            AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
            if (abstractC0508d3 != null) {
                abstractC0508d3.h();
            }
        }
        C0914jb c0914jbA = C0914jb.a();
        Context context = layoutInflaterFactory2C0658fb.D;
        synchronized (c0914jbA) {
            dv1 dv1Var = c0914jbA.a;
            synchronized (dv1Var) {
                EJ0 ej0 = (EJ0) dv1Var.b.get(context);
                if (ej0 != null) {
                    ej0.a();
                }
            }
        }
        layoutInflaterFactory2C0658fb.l0 = new Configuration(layoutInflaterFactory2C0658fb.D.getResources().getConfiguration());
        layoutInflaterFactory2C0658fb.o(false, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        X0().g();
    }

    @Override // androidx.fragment.app.FragmentActivity, defpackage.iI, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AbstractC0508d3 abstractC0508d3Y0 = Y0();
        if (menuItem.getItemId() != 16908332 || abstractC0508d3Y0 == null || (abstractC0508d3Y0.d() & 4) == 0) {
            return false;
        }
        return a1();
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((LayoutInflaterFactory2C0658fb) X0()).x();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        layoutInflaterFactory2C0658fb.B();
        AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
        if (abstractC0508d3 != null) {
            abstractC0508d3.p(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((LayoutInflaterFactory2C0658fb) X0()).o(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LayoutInflaterFactory2C0658fb layoutInflaterFactory2C0658fb = (LayoutInflaterFactory2C0658fb) X0();
        layoutInflaterFactory2C0658fb.B();
        AbstractC0508d3 abstractC0508d3 = layoutInflaterFactory2C0658fb.H;
        if (abstractC0508d3 != null) {
            abstractC0508d3.p(false);
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        X0().n(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        AbstractC0508d3 abstractC0508d3Y0 = Y0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0508d3Y0 == null || !abstractC0508d3Y0.l()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // defpackage.iI, android.app.Activity
    public void setContentView(int i) {
        Z0();
        X0().j(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((LayoutInflaterFactory2C0658fb) X0()).n0 = i;
    }

    @Override // defpackage.iI, android.app.Activity
    public void setContentView(View view) {
        Z0();
        X0().k(view);
    }

    @Override // defpackage.iI, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Z0();
        X0().l(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }
}
