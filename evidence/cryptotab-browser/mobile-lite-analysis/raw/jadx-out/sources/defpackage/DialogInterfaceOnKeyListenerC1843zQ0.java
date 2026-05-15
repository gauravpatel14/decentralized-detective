package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: zQ0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnKeyListenerC1843zQ0 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, SQ0 {
    public SubMenuC1273pR1 t;
    public s6 u;
    public JG0 v;

    @Override // defpackage.SQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        s6 s6Var;
        if ((z || menuC0775hQ0 == this.t) && (s6Var = this.u) != null) {
            s6Var.dismiss();
        }
    }

    @Override // defpackage.SQ0
    public final boolean d(MenuC0775hQ0 menuC0775hQ0) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        JG0 jg0 = this.v;
        if (jg0.z == null) {
            jg0.z = new IG0(jg0);
        }
        this.t.q(jg0.z.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.v.b(this.t, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        SubMenuC1273pR1 subMenuC1273pR1 = this.t;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.u.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.u.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                subMenuC1273pR1.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return subMenuC1273pR1.performShortcut(i, keyEvent, 0);
    }
}
