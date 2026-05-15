package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class rL implements sL, uL {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public rL(ContentInfo contentInfo) {
        this.b = qL.e(contentInfo);
    }

    @Override // defpackage.sL
    public vL a() {
        return new vL(new rL(((ContentInfo.Builder) this.b).build()));
    }

    @Override // defpackage.sL
    public void b(Uri uri) {
        ((ContentInfo.Builder) this.b).setLinkUri(uri);
    }

    @Override // defpackage.sL
    public void c(int i) {
        ((ContentInfo.Builder) this.b).setFlags(i);
    }

    @Override // defpackage.uL
    public int d() {
        return ((ContentInfo) this.b).getFlags();
    }

    @Override // defpackage.uL
    public int e() {
        return ((ContentInfo) this.b).getSource();
    }

    @Override // defpackage.uL
    public ClipData f() {
        return ((ContentInfo) this.b).getClip();
    }

    @Override // defpackage.uL
    public ContentInfo g() {
        return (ContentInfo) this.b;
    }

    @Override // defpackage.sL
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.b).setExtras(bundle);
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return "ContentInfoCompat{" + ((ContentInfo) this.b) + "}";
            default:
                return super.toString();
        }
    }

    public rL(ClipData clipData, int i) {
        this.b = qL.c(clipData, i);
    }
}
