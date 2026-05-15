package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import com.google.android.gms.common.internal.AccountType;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: zE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1825zE2 extends US2 {
    public long c;
    public String d;
    public AccountManager e;
    public Boolean f;
    public long g;

    @Override // defpackage.US2
    public final boolean h() {
        Calendar calendar = Calendar.getInstance();
        this.c = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.d = F.b(language.toLowerCase(locale2), "-", locale.getCountry().toLowerCase(locale2));
        return false;
    }

    public final long k() {
        g();
        return this.g;
    }

    public final long l() {
        i();
        return this.c;
    }

    public final String m() {
        i();
        return this.d;
    }

    public final boolean n() {
        Account[] result;
        g();
        C1391rR2 c1391rR2 = this.a;
        long jCurrentTimeMillis = c1391rR2.n.currentTimeMillis();
        if (jCurrentTimeMillis - this.g > 86400000) {
            this.f = null;
        }
        Boolean bool = this.f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context context = c1391rR2.a;
        int iA = U3.a(context, "android.permission.GET_ACCOUNTS");
        WO2 wo2 = c1391rR2.i;
        if (iA != 0) {
            C1391rR2.k(wo2);
            wo2.j.a("Permission error checking for dasher/unicorn accounts");
            this.g = jCurrentTimeMillis;
            this.f = Boolean.FALSE;
            return false;
        }
        if (this.e == null) {
            this.e = AccountManager.get(context);
        }
        try {
            result = this.e.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException e) {
            e = e;
            C1391rR2.k(wo2);
            wo2.g.b(e, "Exception checking account types");
        } catch (OperationCanceledException e2) {
            e = e2;
            C1391rR2.k(wo2);
            wo2.g.b(e, "Exception checking account types");
        } catch (IOException e3) {
            e = e3;
            C1391rR2.k(wo2);
            wo2.g.b(e, "Exception checking account types");
        }
        if (result != null && result.length > 0) {
            this.f = Boolean.TRUE;
            this.g = jCurrentTimeMillis;
            return true;
        }
        Account[] result2 = this.e.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f = Boolean.TRUE;
            this.g = jCurrentTimeMillis;
            return true;
        }
        this.g = jCurrentTimeMillis;
        this.f = Boolean.FALSE;
        return false;
    }
}
