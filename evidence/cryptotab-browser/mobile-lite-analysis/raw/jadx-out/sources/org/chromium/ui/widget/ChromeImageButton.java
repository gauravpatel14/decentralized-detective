package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import defpackage.C1285pb;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class ChromeImageButton extends C1285pb {
    public ChromeImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getImageTintList() == null || getImageTintMode() != PorterDuff.Mode.SRC_ATOP) {
            return;
        }
        setImageTintMode(PorterDuff.Mode.SRC_IN);
    }
}
