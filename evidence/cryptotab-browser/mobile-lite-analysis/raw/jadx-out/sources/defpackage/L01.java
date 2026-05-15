package defpackage;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L01 {
    public final Context a;
    public final Notification.Builder b;
    public final F01 c;
    public final Bundle d;
    public final int e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.content.Context, android.content.res.Resources] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public L01(F01 f01) {
        String str;
        String str2;
        String str3;
        Notification notification;
        ArrayList arrayList;
        Notification notification2;
        String str4;
        Bundle[] bundleArr;
        ArrayList arrayList2;
        String str5;
        String str6;
        int i;
        ArrayList arrayList3;
        int i2;
        L01 l01 = this;
        new ArrayList();
        l01.d = new Bundle();
        l01.c = f01;
        Context context = f01.a;
        l01.a = context;
        Notification.Builder builder = new Notification.Builder(context, f01.y);
        l01.b = builder;
        Notification notification3 = f01.B;
        ?? r7 = 0;
        int i3 = 0;
        builder.setWhen(notification3.when).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, null).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((notification3.flags & 2) != 0).setOnlyAlertOnce((notification3.flags & 8) != 0).setAutoCancel((notification3.flags & 16) != 0).setDefaults(notification3.defaults).setContentTitle(f01.e).setContentText(f01.f).setContentInfo(null).setContentIntent(f01.g).setDeleteIntent(notification3.deleteIntent).setFullScreenIntent(null, (notification3.flags & 128) != 0).setNumber(f01.i).setProgress(f01.n, f01.o, f01.p);
        IconCompat iconCompat = f01.h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.e(context));
        builder.setSubText(f01.m).setUsesChronometer(false).setPriority(f01.j);
        Iterator it = f01.b.iterator();
        while (true) {
            str = "android.support.allowGeneratedReplies";
            str2 = "key_text_reply";
            str3 = "";
            if (!it.hasNext()) {
                break;
            }
            B01 b01 = (B01) it.next();
            if (b01.b == null && (i2 = b01.f) != 0) {
                b01.b = IconCompat.a(r7, "", i2);
            }
            IconCompat iconCompat2 = b01.b;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat2 != 0 ? iconCompat2.e(r7) : r7, b01.g, b01.h);
            Gt1[] gt1Arr = b01.c;
            if (gt1Arr != null) {
                int length = gt1Arr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                int i4 = i3;
                CharSequence[] charSequenceArr = r7;
                while (i4 < gt1Arr.length) {
                    Gt1 gt1 = gt1Arr[i4];
                    gt1.getClass();
                    RemoteInput.Builder builderAddExtras = new RemoteInput.Builder("key_text_reply").setLabel(gt1.a).setChoices(charSequenceArr).setAllowFreeFormInput(true).addExtras(gt1.b);
                    Iterator it2 = gt1.c.iterator();
                    while (it2.hasNext()) {
                        builderAddExtras.setAllowDataType((String) it2.next(), true);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        Ft1.a(builderAddExtras);
                    }
                    remoteInputArr[i4] = builderAddExtras.build();
                    i4++;
                    charSequenceArr = 0;
                }
                for (int i5 = 0; i5 < length; i5++) {
                    builder2.addRemoteInput(remoteInputArr[i5]);
                }
            }
            Bundle bundle = b01.a;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            boolean z = b01.d;
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            int i6 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z);
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i6 >= 28) {
                I01.a(builder2);
            }
            if (i6 >= 29) {
                J01.c(builder2);
            }
            if (i6 >= 31) {
                K01.a(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", b01.e);
            builder2.addExtras(bundle2);
            l01.b.addAction(builder2.build());
            r7 = 0;
            i3 = 0;
        }
        Bundle bundle3 = f01.u;
        if (bundle3 != null) {
            l01.d.putAll(bundle3);
        }
        int i7 = Build.VERSION.SDK_INT;
        l01.b.setShowWhen(f01.k);
        l01.b.setLocalOnly(f01.s);
        l01.b.setGroup(f01.q);
        l01.b.setSortKey(null);
        l01.b.setGroupSummary(f01.r);
        l01.e = 0;
        l01.b.setCategory(f01.t);
        l01.b.setColor(f01.v);
        l01.b.setVisibility(f01.w);
        l01.b.setPublicVersion(f01.x);
        l01.b.setSound(notification3.sound, notification3.audioAttributes);
        ArrayList arrayList4 = f01.E;
        ArrayList arrayList5 = f01.c;
        if (i7 < 28) {
            if (arrayList5 == null) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList(arrayList5.size());
                Iterator it3 = arrayList5.iterator();
                if (it3.hasNext()) {
                    it3.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (arrayList3 != null) {
                if (arrayList4 == null) {
                    arrayList4 = arrayList3;
                } else {
                    C0978kf c0978kf = new C0978kf(arrayList4.size() + arrayList3.size());
                    c0978kf.addAll(arrayList3);
                    c0978kf.addAll(arrayList4);
                    arrayList4 = new ArrayList(c0978kf);
                }
            }
        }
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                l01.b.addPerson((String) it4.next());
            }
        }
        ArrayList arrayList6 = f01.d;
        if (arrayList6.size() > 0) {
            if (f01.u == null) {
                f01.u = new Bundle();
            }
            Bundle bundle4 = f01.u.getBundle("android.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            int i8 = 0;
            while (i8 < arrayList6.size()) {
                String string = Integer.toString(i8);
                B01 b012 = (B01) arrayList6.get(i8);
                Bundle bundle7 = new Bundle();
                ArrayList arrayList7 = arrayList6;
                if (b012.b != null || (i = b012.f) == 0) {
                    notification2 = notification3;
                } else {
                    notification2 = notification3;
                    b012.b = IconCompat.a(null, str3, i);
                }
                IconCompat iconCompat3 = b012.b;
                bundle7.putInt("icon", iconCompat3 != null ? iconCompat3.b() : 0);
                bundle7.putCharSequence("title", b012.g);
                bundle7.putParcelable("actionIntent", b012.h);
                Bundle bundle8 = b012.a;
                Bundle bundle9 = bundle8 != null ? new Bundle(bundle8) : new Bundle();
                bundle9.putBoolean(str, b012.d);
                bundle7.putBundle("extras", bundle9);
                Gt1[] gt1Arr2 = b012.c;
                if (gt1Arr2 == null) {
                    arrayList2 = arrayList5;
                    str4 = str;
                    str6 = str2;
                    str5 = str3;
                    bundleArr = null;
                } else {
                    str4 = str;
                    bundleArr = new Bundle[gt1Arr2.length];
                    arrayList2 = arrayList5;
                    str5 = str3;
                    int i9 = 0;
                    while (i9 < gt1Arr2.length) {
                        Gt1 gt12 = gt1Arr2[i9];
                        Gt1[] gt1Arr3 = gt1Arr2;
                        Bundle bundle10 = new Bundle();
                        gt12.getClass();
                        bundle10.putString("resultKey", str2);
                        String str7 = str2;
                        bundle10.putCharSequence("label", gt12.a);
                        bundle10.putCharSequenceArray("choices", null);
                        bundle10.putBoolean("allowFreeFormInput", true);
                        bundle10.putBundle("extras", gt12.b);
                        HashSet hashSet = gt12.c;
                        if (!hashSet.isEmpty()) {
                            ArrayList<String> arrayList8 = new ArrayList<>(hashSet.size());
                            Iterator it5 = hashSet.iterator();
                            while (it5.hasNext()) {
                                arrayList8.add((String) it5.next());
                            }
                            bundle10.putStringArrayList("allowedDataTypes", arrayList8);
                        }
                        bundleArr[i9] = bundle10;
                        i9++;
                        gt1Arr2 = gt1Arr3;
                        str2 = str7;
                    }
                    str6 = str2;
                }
                bundle7.putParcelableArray("remoteInputs", bundleArr);
                bundle7.putBoolean("showsUserInterface", b012.e);
                bundle7.putInt("semanticAction", 0);
                bundle6.putBundle(string, bundle7);
                i8++;
                arrayList6 = arrayList7;
                notification3 = notification2;
                str = str4;
                str3 = str5;
                arrayList5 = arrayList2;
                str2 = str6;
            }
            notification = notification3;
            arrayList = arrayList5;
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (f01.u == null) {
                f01.u = new Bundle();
            }
            f01.u.putBundle("android.car.EXTENSIONS", bundle4);
            l01 = this;
            l01.d.putBundle("android.car.EXTENSIONS", bundle5);
        } else {
            notification = notification3;
            arrayList = arrayList5;
        }
        int i10 = Build.VERSION.SDK_INT;
        Icon icon = f01.D;
        if (icon != null) {
            l01.b.setSmallIcon(icon);
        }
        l01.b.setExtras(f01.u);
        l01.b.setRemoteInputHistory(null);
        l01.b.setBadgeIconType(0);
        l01.b.setSettingsText(null);
        l01.b.setShortcutId(null);
        l01.b.setTimeoutAfter(f01.z);
        l01.b.setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(f01.y)) {
            l01.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i10 >= 28) {
            Iterator it6 = arrayList.iterator();
            if (it6.hasNext()) {
                it6.next().getClass();
                throw new ClassCastException();
            }
        }
        if (i10 >= 29) {
            J01.a(l01.b, f01.A);
            J01.b(l01.b);
        }
        if (f01.C) {
            if (l01.c.r) {
                l01.e = 2;
            } else {
                l01.e = 1;
            }
            l01.b.setVibrate(null);
            l01.b.setSound(null);
            Notification notification4 = notification;
            int i11 = notification4.defaults & (-4);
            notification4.defaults = i11;
            l01.b.setDefaults(i11);
            if (TextUtils.isEmpty(l01.c.q)) {
                l01.b.setGroup("silent");
            }
            l01.b.setGroupAlertBehavior(l01.e);
        }
    }
}
