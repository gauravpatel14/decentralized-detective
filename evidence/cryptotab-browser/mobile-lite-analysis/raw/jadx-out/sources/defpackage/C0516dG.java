package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;

/* JADX INFO: renamed from: dG, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0516dG extends AbstractC1103mg {
    public final /* synthetic */ Uri h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ ClipboardManagerOnPrimaryClipChangedListenerC0566eG j;

    public C0516dG(ClipboardManagerOnPrimaryClipChangedListenerC0566eG clipboardManagerOnPrimaryClipChangedListenerC0566eG, Uri uri, boolean z) {
        this.j = clipboardManagerOnPrimaryClipChangedListenerC0566eG;
        this.h = uri;
        this.i = z;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        return ClipData.newUri(AbstractC1499tM.a.getContentResolver(), "image", this.h);
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        ClipboardManagerOnPrimaryClipChangedListenerC0566eG clipboardManagerOnPrimaryClipChangedListenerC0566eG = this.j;
        if (clipboardManagerOnPrimaryClipChangedListenerC0566eG.l((ClipData) obj) && this.i) {
            clipboardManagerOnPrimaryClipChangedListenerC0566eG.m(AbstractC0275Wp1.image_copied);
        }
        ClipDescription primaryClipDescription = clipboardManagerOnPrimaryClipChangedListenerC0566eG.d.getPrimaryClipDescription();
        long timestamp = (primaryClipDescription == null || !primaryClipDescription.hasMimeType("image/*")) ? 0L : primaryClipDescription.getTimestamp();
        ZF zf = clipboardManagerOnPrimaryClipChangedListenerC0566eG.e;
        Uri uri = this.h;
        if (zf == null) {
            clipboardManagerOnPrimaryClipChangedListenerC0566eG.f = new YF(uri, timestamp);
        } else {
            zf.b(new YF(uri, timestamp));
        }
    }
}
