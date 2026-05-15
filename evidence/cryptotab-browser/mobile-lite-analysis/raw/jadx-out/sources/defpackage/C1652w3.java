package defpackage;

import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: renamed from: w3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1652w3 extends AbstractViewOnTouchListenerC0044Dh0 {
    public final /* synthetic */ ActionMenuItemView C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1652w3(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.C = actionMenuItemView;
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final nI1 b() {
        C1710x3 c1710x3;
        C1765y3 c1765y3 = this.C.E;
        if (c1765y3 == null || (c1710x3 = c1765y3.t.M) == null) {
            return null;
        }
        return c1710x3.a();
    }

    @Override // defpackage.AbstractViewOnTouchListenerC0044Dh0
    public final boolean c() {
        nI1 ni1B;
        ActionMenuItemView actionMenuItemView = this.C;
        InterfaceC0706gQ0 interfaceC0706gQ0 = actionMenuItemView.C;
        return interfaceC0706gQ0 != null && interfaceC0706gQ0.a(actionMenuItemView.z) && (ni1B = b()) != null && ni1B.q();
    }
}
