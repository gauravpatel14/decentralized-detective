package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class zzkm extends IOException {
    public static final /* synthetic */ int t = 0;

    public static zzkm a() {
        return new zzkm("Protocol message had invalid UTF-8.");
    }

    public static zzkm b() {
        return new zzkm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzkm c() {
        return new zzkm("Failed to parse the message.");
    }

    public static zzkm d() {
        return new zzkm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
