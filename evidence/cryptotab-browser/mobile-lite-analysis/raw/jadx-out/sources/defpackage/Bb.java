package defpackage;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.widget.AppCompatSpinner;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Bb implements Hb, DialogInterface.OnClickListener {
    public s6 t;
    public Cb u;
    public CharSequence v;
    public final /* synthetic */ AppCompatSpinner w;

    public Bb(AppCompatSpinner appCompatSpinner) {
        this.w = appCompatSpinner;
    }

    @Override // defpackage.Hb
    public final void A(ListAdapter listAdapter) {
        this.u = (Cb) listAdapter;
    }

    @Override // defpackage.Hb
    public final void dismiss() {
        s6 s6Var = this.t;
        if (s6Var != null) {
            s6Var.dismiss();
            this.t = null;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AppCompatSpinner appCompatSpinner = this.w;
        appCompatSpinner.setSelection(i);
        if (appCompatSpinner.getOnItemClickListener() != null) {
            appCompatSpinner.performItemClick(null, i, this.u.getItemId(i));
        }
        dismiss();
    }

    @Override // defpackage.Hb
    public final void p(int i, int i2) {
        if (this.u == null) {
            return;
        }
        AppCompatSpinner appCompatSpinner = this.w;
        r6 r6Var = new r6(appCompatSpinner.u);
        CharSequence charSequence = this.v;
        n6 n6Var = r6Var.a;
        if (charSequence != null) {
            n6Var.d = charSequence;
        }
        Cb cb = this.u;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        n6Var.o = cb;
        n6Var.p = this;
        n6Var.u = selectedItemPosition;
        n6Var.t = true;
        s6 s6VarA = r6Var.a();
        this.t = s6VarA;
        AlertController$RecycleListView alertController$RecycleListView = s6VarA.y.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i2);
        this.t.show();
    }

    @Override // defpackage.Hb
    public final boolean q() {
        s6 s6Var = this.t;
        if (s6Var != null) {
            return s6Var.isShowing();
        }
        return false;
    }

    @Override // defpackage.Hb
    public final int r() {
        return 0;
    }

    @Override // defpackage.Hb
    public final Drawable s() {
        return null;
    }

    @Override // defpackage.Hb
    public final void t(CharSequence charSequence) {
        this.v = charSequence;
    }

    @Override // defpackage.Hb
    public final void u(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.Hb
    public final void v(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.Hb
    public final void w(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.Hb
    public final void x(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.Hb
    public final int y() {
        return 0;
    }

    @Override // defpackage.Hb
    public final CharSequence z() {
        return this.v;
    }
}
