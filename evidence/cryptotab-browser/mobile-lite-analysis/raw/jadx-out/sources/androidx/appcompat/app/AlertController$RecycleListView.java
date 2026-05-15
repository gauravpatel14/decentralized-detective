package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import defpackage.AbstractC0305Yp1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {
    public final int t;
    public final int u;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0305Yp1.RecycleListView);
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC0305Yp1.RecycleListView_paddingBottomNoButtons, -1);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC0305Yp1.RecycleListView_paddingTopNoTitle, -1);
    }
}
