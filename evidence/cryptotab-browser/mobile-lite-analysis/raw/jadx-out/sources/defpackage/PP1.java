package defpackage;

import android.content.Context;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PP1 {
    public static StringBuilder a(Date date) {
        Context context = AbstractC1499tM.a;
        Calendar calendar = OP1.a;
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar calendar2 = OP1.b;
        calendar2.setTime(date);
        StringBuilder sb = new StringBuilder();
        if (Uw.b(calendar, calendar2)) {
            sb.append(context.getString(AbstractC0275Wp1.today));
            sb.append(" - ");
        } else {
            calendar.add(5, -1);
            if (Uw.b(calendar, calendar2)) {
                sb.append(context.getString(AbstractC0275Wp1.yesterday));
                sb.append(" - ");
            }
        }
        sb.append(DateUtils.formatDateTime(context, date.getTime(), 98308));
        return sb;
    }
}
