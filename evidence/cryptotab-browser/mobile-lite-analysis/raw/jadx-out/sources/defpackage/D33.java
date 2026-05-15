package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class D33 extends TM2 {
    public final /* synthetic */ hx1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D33(hx1 hx1Var, Looper looper) {
        super(looper);
        this.a = hx1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        hx1 hx1Var = this.a;
        hx1Var.getClass();
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new C1367rB2());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        hx1Var.g = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        hx1Var.f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent2.getAction())) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra != null) {
                        Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                        if (matcher.matches()) {
                            String strGroup = matcher.group(1);
                            String strGroup2 = matcher.group(2);
                            if (strGroup != null) {
                                Bundle extras = intent2.getExtras();
                                extras.putString("registration_id", strGroup2);
                                hx1Var.b(strGroup, extras);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String strValueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(strValueOf);
                        Log.w("Rpc", sb.toString());
                        return;
                    }
                    if (!stringExtra2.startsWith("|")) {
                        synchronized (hx1Var.a) {
                            int i = 0;
                            while (true) {
                                try {
                                    UJ1 uj1 = hx1Var.a;
                                    if (i < uj1.v) {
                                        hx1Var.b((String) uj1.f(i), intent2.getExtras());
                                        i++;
                                    }
                                } finally {
                                }
                            }
                        }
                        return;
                    }
                    String[] strArrSplit = stringExtra2.split("\\|");
                    if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                        Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = strArrSplit[2];
                    String strSubstring = strArrSplit[3];
                    if (strSubstring.startsWith(":")) {
                        strSubstring = strSubstring.substring(1);
                    }
                    hx1Var.b(str, intent2.putExtra("error", strSubstring).getExtras());
                    return;
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }
}
