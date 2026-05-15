package defpackage;

import org.chromium.ui.listmenu.ListMenuButton;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface DG0 {
    default Lr1 a(ListMenuButton listMenuButton) {
        ViewTreeObserverOnGlobalLayoutListenerC1410rp2 viewTreeObserverOnGlobalLayoutListenerC1410rp2 = new ViewTreeObserverOnGlobalLayoutListenerC1410rp2(listMenuButton);
        viewTreeObserverOnGlobalLayoutListenerC1410rp2.d(true);
        return viewTreeObserverOnGlobalLayoutListenerC1410rp2;
    }

    InterfaceC1772yG0 b();
}
