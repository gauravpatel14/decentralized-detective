package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.h;

/* JADX INFO: renamed from: sO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class C1445sO0 extends h {
    public DialogC1385rO0 t;
    public C0468cP0 u;

    public C1445sO0() {
        setCancelable(true);
    }

    public final void H0() {
        if (this.u == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.u = C0468cP0.b(arguments.getBundle("selector"));
            }
            if (this.u == null) {
                this.u = C0468cP0.c;
            }
        }
    }

    public DialogC1385rO0 K0(Context context) {
        return new DialogC1385rO0(0, context);
    }

    public final void M0(C0468cP0 c0468cP0) {
        if (c0468cP0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        H0();
        if (this.u.equals(c0468cP0)) {
            return;
        }
        this.u = c0468cP0;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle("selector", c0468cP0.a);
        setArguments(arguments);
        DialogC1385rO0 dialogC1385rO0 = this.t;
        if (dialogC1385rO0 != null) {
            dialogC1385rO0.k(c0468cP0);
        }
    }

    @Override // androidx.fragment.app.n, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DialogC1385rO0 dialogC1385rO0 = this.t;
        if (dialogC1385rO0 == null) {
            return;
        }
        dialogC1385rO0.getWindow().setLayout(QO0.a(dialogC1385rO0.getContext()), -2);
    }

    @Override // androidx.fragment.app.h
    public final Dialog onCreateDialog(Bundle bundle) {
        DialogC1385rO0 dialogC1385rO0K0 = K0(getContext());
        this.t = dialogC1385rO0K0;
        H0();
        dialogC1385rO0K0.k(this.u);
        return this.t;
    }
}
