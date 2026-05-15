package androidx.mediarouter.app;

import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ MediaRouteExpandCollapseButton t;

    public e(MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton) {
        this.t = mediaRouteExpandCollapseButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = this.t;
        boolean z = mediaRouteExpandCollapseButton.A;
        mediaRouteExpandCollapseButton.A = !z;
        if (z) {
            mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.x);
            mediaRouteExpandCollapseButton.x.start();
            mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.y);
        } else {
            mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.w);
            mediaRouteExpandCollapseButton.w.start();
            mediaRouteExpandCollapseButton.setContentDescription(mediaRouteExpandCollapseButton.z);
        }
        View.OnClickListener onClickListener = mediaRouteExpandCollapseButton.B;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
