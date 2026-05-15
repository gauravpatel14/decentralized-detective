package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import defpackage.AbstractC0514dF0;
import defpackage.AbstractC1120mz1;
import defpackage.C0034Co2;
import defpackage.C0094Ho2;
import defpackage.C0533dW0;
import defpackage.C0886jF0;
import defpackage.FO;
import defpackage.InterfaceC0048Do2;
import defpackage.InterfaceC0105Io2;
import defpackage.InterfaceC1753xn0;
import defpackage.bF0;
import defpackage.tz1;
import defpackage.uz1;
import defpackage.vz1;
import defpackage.wz1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements InterfaceC1753xn0, vz1, InterfaceC0105Io2 {
    public final n t;
    public final C0094Ho2 u;
    public final i v;
    public InterfaceC0048Do2 w;
    public C0886jF0 x = null;
    public uz1 y = null;

    public w(n nVar, C0094Ho2 c0094Ho2, i iVar) {
        this.t = nVar;
        this.u = c0094Ho2;
        this.v = iVar;
    }

    public final void a(bF0 bf0) {
        this.x.e(bf0);
    }

    public final void b() {
        if (this.x == null) {
            this.x = new C0886jF0(this);
            uz1 uz1Var = new uz1(this);
            this.y = uz1Var;
            uz1Var.a();
            this.v.run();
        }
    }

    @Override // defpackage.InterfaceC1753xn0
    public final FO getDefaultViewModelCreationExtras() {
        Application application;
        n nVar = this.t;
        Context applicationContext = nVar.requireContext().getApplicationContext();
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
        c0533dW0.a(AbstractC1120mz1.a, nVar);
        c0533dW0.a(AbstractC1120mz1.b, this);
        if (nVar.getArguments() != null) {
            c0533dW0.a(AbstractC1120mz1.c, nVar.getArguments());
        }
        return c0533dW0;
    }

    @Override // defpackage.InterfaceC1753xn0
    public final InterfaceC0048Do2 getDefaultViewModelProviderFactory() {
        Application application;
        n nVar = this.t;
        InterfaceC0048Do2 defaultViewModelProviderFactory = nVar.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(nVar.mDefaultFactory)) {
            this.w = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.w == null) {
            Context applicationContext = nVar.requireContext().getApplicationContext();
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
            this.w = new wz1(application, nVar, nVar.getArguments());
        }
        return this.w;
    }

    @Override // defpackage.InterfaceC0762hF0
    public final AbstractC0514dF0 getLifecycle() {
        b();
        return this.x;
    }

    @Override // defpackage.vz1
    public final tz1 getSavedStateRegistry() {
        b();
        return this.y.b;
    }

    @Override // defpackage.InterfaceC0105Io2
    public final C0094Ho2 getViewModelStore() {
        b();
        return this.u;
    }
}
