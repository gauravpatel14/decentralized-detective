package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tL implements sL, uL {
    public final /* synthetic */ int a = 0;
    public ClipData b;
    public int c;
    public int d;
    public Uri e;
    public Bundle f;

    public /* synthetic */ tL() {
    }

    @Override // defpackage.sL
    public vL a() {
        return new vL(new tL(this));
    }

    @Override // defpackage.sL
    public void b(Uri uri) {
        this.e = uri;
    }

    @Override // defpackage.sL
    public void c(int i) {
        this.d = i;
    }

    @Override // defpackage.uL
    public int d() {
        return this.d;
    }

    @Override // defpackage.uL
    public int e() {
        return this.c;
    }

    @Override // defpackage.uL
    public ClipData f() {
        return this.b;
    }

    @Override // defpackage.uL
    public ContentInfo g() {
        return null;
    }

    @Override // defpackage.sL
    public void setExtras(Bundle bundle) {
        this.f = bundle;
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.b.getDescription());
                sb.append(", source=");
                int i = this.c;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.d;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                Uri uri = this.e;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return S3.a(sb, this.f != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public tL(tL tLVar) {
        this.b = tLVar.b;
        this.c = tLVar.c;
        this.d = tLVar.d;
        this.e = tLVar.e;
        this.f = tLVar.f;
    }
}
