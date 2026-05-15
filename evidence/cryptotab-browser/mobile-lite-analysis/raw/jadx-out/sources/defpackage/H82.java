package defpackage;

import android.text.style.ClickableSpan;
import android.view.MenuItem;
import org.chromium.ui.widget.TextViewWithClickableSpans;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class H82 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ ClickableSpan t;
    public final /* synthetic */ TextViewWithClickableSpans u;

    public H82(TextViewWithClickableSpans textViewWithClickableSpans, ClickableSpan clickableSpan) {
        this.u = textViewWithClickableSpans;
        this.t = clickableSpan;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.t.onClick(this.u);
        return true;
    }
}
