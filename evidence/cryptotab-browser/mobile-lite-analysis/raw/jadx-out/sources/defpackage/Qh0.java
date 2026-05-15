package defpackage;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.n;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qh0 extends Xh0 implements O41, V41, S41, T41, InterfaceC0105Io2, K41, v4, vz1, InterfaceC1463si0, AQ0 {
    public final /* synthetic */ FragmentActivity x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qh0(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.x = fragmentActivity;
    }

    @Override // defpackage.S41
    public final void F0(ai0 ai0Var) {
        this.x.F0(ai0Var);
    }

    @Override // defpackage.V41
    public final void I(ai0 ai0Var) {
        this.x.I(ai0Var);
    }

    @Override // defpackage.O41
    public final void L(QK qk) {
        this.x.L(qk);
    }

    @Override // defpackage.V41
    public final void P(ai0 ai0Var) {
        this.x.P(ai0Var);
    }

    @Override // defpackage.InterfaceC1463si0
    public final void a(n nVar) {
        this.x.W0(nVar);
    }

    @Override // defpackage.AbstractC0246Uh0
    public final View b(int i) {
        return this.x.findViewById(i);
    }

    @Override // defpackage.AbstractC0246Uh0
    public final boolean c() {
        Window window = this.x.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // defpackage.T41
    public final void c0(QK qk) {
        this.x.c0(qk);
    }

    @Override // defpackage.InterfaceC0762hF0
    public final AbstractC0514dF0 getLifecycle() {
        return this.x.O;
    }

    @Override // defpackage.vz1
    public final tz1 getSavedStateRegistry() {
        return this.x.w.b;
    }

    @Override // defpackage.InterfaceC0105Io2
    public final C0094Ho2 getViewModelStore() {
        return this.x.getViewModelStore();
    }

    @Override // defpackage.O41
    public final void j(ai0 ai0Var) {
        this.x.j(ai0Var);
    }

    @Override // defpackage.AQ0
    public final void k0(C0600ei0 c0600ei0) {
        this.x.k0(c0600ei0);
    }

    @Override // defpackage.K41
    public final J41 l() {
        return this.x.l();
    }

    @Override // defpackage.v4
    public final u4 m0() {
        return this.x.B;
    }

    @Override // defpackage.T41
    public final void n0(QK qk) {
        this.x.n0(qk);
    }

    @Override // defpackage.S41
    public final void s0(ai0 ai0Var) {
        this.x.s0(ai0Var);
    }

    @Override // defpackage.AQ0
    public final void w(C0600ei0 c0600ei0) {
        this.x.w(c0600ei0);
    }
}
