package defpackage;

import J.N;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import org.chromium.base.ThreadUtils;
import org.chromium.net.HttpNegotiateAuthenticator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qp0 implements AccountManagerCallback {
    public final /* synthetic */ int a;
    public final Sp0 b;
    public final /* synthetic */ HttpNegotiateAuthenticator c;

    public /* synthetic */ Qp0(HttpNegotiateAuthenticator httpNegotiateAuthenticator, Sp0 sp0, int i) {
        this.a = i;
        this.c = httpNegotiateAuthenticator;
        this.b = sp0;
    }

    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture accountManagerFuture) {
        int i;
        switch (this.a) {
            case 0:
                Sp0 sp0 = this.b;
                try {
                    Account[] accountArr = (Account[]) accountManagerFuture.getResult();
                    if (accountArr.length == 0) {
                        Log.w("cr_net_auth", "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ");
                        N._V_IJOO(28, -341, sp0.a, this.c, null);
                    } else if (accountArr.length <= 1) {
                        HttpNegotiateAuthenticator httpNegotiateAuthenticator = this.c;
                        httpNegotiateAuthenticator.getClass();
                        Account account = accountArr[0];
                        sp0.e = account;
                        sp0.b.getAuthToken(account, sp0.d, sp0.c, true, (AccountManagerCallback<Bundle>) new Qp0(httpNegotiateAuthenticator, sp0, 1), new Handler(ThreadUtils.c()));
                    } else {
                        Log.w("cr_net_auth", "ERR_MISSING_AUTH_CREDENTIALS: Found " + accountArr.length + " accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.");
                        N._V_IJOO(28, -341, sp0.a, this.c, null);
                    }
                } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                    Log.w("cr_net_auth", "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e);
                    N._V_IJOO(28, -9, sp0.a, this.c, null);
                    return;
                }
                break;
            default:
                Sp0 sp02 = this.b;
                try {
                    Bundle bundle = (Bundle) accountManagerFuture.getResult();
                    if (!bundle.containsKey("intent")) {
                        HttpNegotiateAuthenticator httpNegotiateAuthenticator2 = this.c;
                        httpNegotiateAuthenticator2.getClass();
                        httpNegotiateAuthenticator2.a = bundle.getBundle("spnegoContext");
                        int i2 = bundle.getInt("spnegoResult", 1);
                        if (i2 != 0) {
                            switch (i2) {
                                case 2:
                                    i = -3;
                                    break;
                                case 3:
                                    i = -342;
                                    break;
                                case 4:
                                    i = -320;
                                    break;
                                case 5:
                                    i = -338;
                                    break;
                                case 6:
                                    i = -339;
                                    break;
                                case 7:
                                    i = -341;
                                    break;
                                case 8:
                                    i = -344;
                                    break;
                                case ConnectionResult.SERVICE_INVALID /* 9 */:
                                    i = -329;
                                    break;
                                default:
                                    i = -9;
                                    break;
                            }
                        } else {
                            i = 0;
                        }
                        N._V_IJOO(28, i, sp02.a, httpNegotiateAuthenticator2, bundle.getString("authtoken"));
                    } else {
                        Context context = AbstractC1499tM.a;
                        AbstractC1499tM.d(context, new Rp0(this, context), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
                    }
                } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
                    Log.w("cr_net_auth", "ERR_UNEXPECTED: Error while attempting to obtain a token.", e2);
                    N._V_IJOO(28, -9, sp02.a, this.c, null);
                }
                break;
        }
    }
}
