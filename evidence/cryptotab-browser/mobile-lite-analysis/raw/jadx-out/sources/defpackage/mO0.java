package defpackage;

import android.os.Handler;
import android.os.Message;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mO0 extends Handler {
    public final /* synthetic */ DialogC1385rO0 a;

    public mO0(DialogC1385rO0 dialogC1385rO0) {
        this.a = dialogC1385rO0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        DialogC1385rO0 dialogC1385rO0 = this.a;
        if (i == 1) {
            dialogC1385rO0.i((List) message.obj);
            return;
        }
        if (i == 2) {
            if (dialogC1385rO0.B.isEmpty()) {
                dialogC1385rO0.m(2);
                mO0 mo0 = dialogC1385rO0.P;
                mo0.removeMessages(2);
                mo0.removeMessages(3);
                mo0.sendMessageDelayed(mo0.obtainMessage(3), 15000L);
                return;
            }
            return;
        }
        if (i == 3 && dialogC1385rO0.B.isEmpty()) {
            dialogC1385rO0.m(3);
            mO0 mo02 = dialogC1385rO0.P;
            mo02.removeMessages(2);
            mo02.removeMessages(3);
            mo02.removeMessages(1);
            dialogC1385rO0.y.h(dialogC1385rO0.z);
        }
    }
}
