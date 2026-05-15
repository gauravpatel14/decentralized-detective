package defpackage;

import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: renamed from: aU0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0356aU0 {
    public YT0 t;
    public PropertyModel u;

    public static void a(AbstractC0356aU0 abstractC0356aU0, PropertyModel propertyModel, YT0 yt0, YT0 yt02) {
        if (propertyModel != null) {
            abstractC0356aU0.u = propertyModel;
            abstractC0356aU0.t = yt0;
            abstractC0356aU0.b(propertyModel, yt02);
        } else {
            PropertyModel propertyModel2 = abstractC0356aU0.u;
            abstractC0356aU0.e();
            abstractC0356aU0.u = null;
            abstractC0356aU0.t = null;
        }
    }

    public abstract void b(PropertyModel propertyModel, YT0 yt0);

    public final void d(int i) {
        YT0 yt0 = this.t;
        if (yt0 == null) {
            return;
        }
        this.t = null;
        yt0.a0(Integer.valueOf(i));
    }

    public abstract void e();
}
