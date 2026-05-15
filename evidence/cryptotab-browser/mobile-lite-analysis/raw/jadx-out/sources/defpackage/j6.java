package defpackage;

import android.os.Message;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class j6 implements View.OnClickListener {
    public final /* synthetic */ q6 t;

    public j6(q6 q6Var) {
        this.t = q6Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        q6 q6Var = this.t;
        Message messageObtain = (view != q6Var.i || (message3 = q6Var.k) == null) ? (view != q6Var.l || (message2 = q6Var.n) == null) ? (view != q6Var.o || (message = q6Var.q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        q6Var.F.obtainMessage(1, q6Var.b).sendToTarget();
    }
}
