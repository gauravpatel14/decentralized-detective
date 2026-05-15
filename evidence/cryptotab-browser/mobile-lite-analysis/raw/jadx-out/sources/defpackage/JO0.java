package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.h;
import androidx.mediarouter.app.d;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class JO0 extends h {
    public d t;
    public C0468cP0 u;

    public JO0() {
        setCancelable(true);
    }

    public d H0(Context context) {
        return new d(context);
    }

    @Override // androidx.fragment.app.n, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d dVar = this.t;
        if (dVar != null) {
            dVar.v();
        }
    }

    @Override // androidx.fragment.app.h
    public final Dialog onCreateDialog(Bundle bundle) {
        d dVarH0 = H0(getContext());
        this.t = dVarH0;
        return dVarH0;
    }

    @Override // androidx.fragment.app.h, androidx.fragment.app.n
    public void onStop() {
        super.onStop();
        d dVar = this.t;
        if (dVar != null) {
            dVar.m(false);
        }
    }
}
