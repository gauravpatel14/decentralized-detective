package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import defpackage.AbstractC0275Wp1;
import defpackage.C1285pb;
import defpackage.Ip1;
import defpackage.oP0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
class MediaRouteExpandCollapseButton extends C1285pb {
    public boolean A;
    public View.OnClickListener B;
    public final AnimationDrawable w;
    public final AnimationDrawable x;
    public final String y;
    public final String z;

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AnimationDrawable animationDrawable = (AnimationDrawable) context.getDrawable(Ip1.mr_group_expand);
        this.w = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) context.getDrawable(Ip1.mr_group_collapse);
        this.x = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(oP0.c(context), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(AbstractC0275Wp1.mr_controller_expand_group);
        this.y = string;
        this.z = context.getString(AbstractC0275Wp1.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new e(this));
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.B = onClickListener;
    }
}
