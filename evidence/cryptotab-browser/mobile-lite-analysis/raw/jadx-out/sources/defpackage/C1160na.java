package defpackage;

import android.telephony.TelephonyManager$CellInfoCallback;
import java.util.List;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: na, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1160na extends TelephonyManager$CellInfoCallback {
    public final /* synthetic */ Callback a;

    public C1160na(Callback callback) {
        this.a = callback;
    }

    public final void onCellInfo(List list) {
        this.a.a0(list);
    }
}
