package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Cw0 extends InputConnectionWrapper {
    public final /* synthetic */ C0023Bw0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cw0(InputConnection inputConnection, C0023Bw0 c0023Bw0) {
        super(inputConnection, false);
        this.a = c0023Bw0;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        Bundle bundle2;
        sL rLVar;
        Ew0 ew0 = inputContentInfo == null ? null : new Ew0(new Dw0(inputContentInfo));
        C0023Bw0 c0023Bw0 = this.a;
        if ((i & 1) != 0) {
            try {
                ew0.a.a.requestPermission();
                InputContentInfo inputContentInfo2 = ew0.a.a;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
            }
        } else {
            bundle2 = bundle;
        }
        ClipDescription description = ew0.a.a.getDescription();
        Dw0 dw0 = ew0.a;
        ClipData clipData = new ClipData(description, new ClipData.Item(dw0.a.getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            rLVar = new rL(clipData, 2);
        } else {
            tL tLVar = new tL();
            tLVar.b = clipData;
            tLVar.c = 2;
            rLVar = tLVar;
        }
        rLVar.b(dw0.a.getLinkUri());
        rLVar.setExtras(bundle2);
        if (AbstractC0604eo2.j(c0023Bw0.a, rLVar.a()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
