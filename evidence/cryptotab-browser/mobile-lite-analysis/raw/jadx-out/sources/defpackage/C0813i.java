package defpackage;

import androidx.appcompat.widget.ActionBarContextView;

/* JADX INFO: renamed from: i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0813i implements InterfaceC1236op2 {
    public boolean a = false;
    public int b;
    public final /* synthetic */ ActionBarContextView c;

    public C0813i(ActionBarContextView actionBarContextView) {
        this.c = actionBarContextView;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void a() {
        if (this.a) {
            return;
        }
        ActionBarContextView actionBarContextView = this.c;
        actionBarContextView.y = null;
        super/*android.view.View*/.setVisibility(this.b);
    }

    @Override // defpackage.InterfaceC1236op2
    public final void b() {
        this.a = true;
    }

    @Override // defpackage.InterfaceC1236op2
    public final void c() {
        super/*android.view.View*/.setVisibility(0);
        this.a = false;
    }
}
