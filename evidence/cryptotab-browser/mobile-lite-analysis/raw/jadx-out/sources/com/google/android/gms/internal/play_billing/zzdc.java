package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class zzdc extends IOException {
    public static final /* synthetic */ int t = 0;

    public static zzdc a() {
        return new zzdc("Protocol message had invalid UTF-8.");
    }

    public static zzdc b() {
        return new zzdc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzdc c() {
        return new zzdc("Failed to parse the message.");
    }

    public static zzdc d() {
        return new zzdc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
