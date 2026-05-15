package defpackage;

import android.widget.PopupMenu;
import org.chromium.ui.widget.TextViewWithClickableSpans;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I82 implements PopupMenu.OnDismissListener {
    public final /* synthetic */ TextViewWithClickableSpans a;

    public I82(TextViewWithClickableSpans textViewWithClickableSpans) {
        this.a = textViewWithClickableSpans;
    }

    @Override // android.widget.PopupMenu.OnDismissListener
    public final void onDismiss(PopupMenu popupMenu) {
        this.a.z = null;
    }
}
