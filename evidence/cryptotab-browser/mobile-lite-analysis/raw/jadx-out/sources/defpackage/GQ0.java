package defpackage;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GQ0 extends FrameLayout implements FG {
    public final CollapsibleActionView t;

    /* JADX WARN: Multi-variable type inference failed */
    public GQ0(View view) {
        super(view.getContext());
        this.t = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // defpackage.FG
    public final void b() {
        this.t.onActionViewExpanded();
    }

    @Override // defpackage.FG
    public final void f() {
        this.t.onActionViewCollapsed();
    }
}
